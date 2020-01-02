package com.iquantex.tspweb.tool;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * freemarker 框架中的会引入原来的配置文件，所以新写一个。
 *
 * @author yongbin.zhang
 * @date 2018/8/6
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public abstract class BaseWebTest {

    private final Logger LOG = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private MockMvc mvc;

    private MvcResult mockResult;

    private Object content;

    private Map<String, String> params;

    private MockHttpServletRequestBuilder builder;

    public BaseWebTest() {
    }

    @Before
    public void Before() {
        this.params = new HashMap();
    }

    protected void doGet(String url) {
        this.initRequest(url, RequestMethod.GET, (Object) null);
    }

    protected void doPost(String url, Object content) {
        this.initRequest(url, RequestMethod.POST, content);
    }

    protected void doPost(String url) {
        this.doPost(url, (Object) null);
    }

    protected void doPut(String url, Object content) {
        this.initRequest(url, RequestMethod.PUT, content);
    }

    protected void doPut(String url) {
        this.doPut(url, (Object) null);
    }

    protected void doDelete(String url, Object content) {
        this.initRequest(url, RequestMethod.DELETE, content);
    }

    protected void doDelete(String url) {
        this.doDelete(url, (Object) null);
    }

    protected void doPost4Multipart(String url, String field, File file, Object content) {
        this.initMultipartRequest(url, field, file, content);
    }

    private void initRequest(String url, RequestMethod method, Object content) {
        LOG.info(println("request Url : " + url + ", Method : " + method.name()));
        switch (method) {
            case GET:
                this.builder = MockMvcRequestBuilders.get(url, new Object[0]);
                break;
            case POST:
                this.builder = MockMvcRequestBuilders.post(url, new Object[0]);
                break;
            case PUT:
                this.builder = MockMvcRequestBuilders.put(url, new Object[0]);
                break;
            case DELETE:
                this.builder = MockMvcRequestBuilders.delete(url, new Object[0]);
        }

        this.setContent(content);
        this.execute();
    }

    private void initMultipartRequest(String url, String field, File file, Object content) {
        LOG.info(println("multipart request Url: " + url));
        this.builder = MockMvcRequestBuilders.fileUpload(url, new Object[0]).file(field, this.convert2Bytest(file));
        this.setContent(content);
        this.execute();
    }

    private byte[] convert2Bytest(File file) {
        byte[] buffer = null;

        try {
            FileInputStream fis = new FileInputStream(file);
            ByteArrayOutputStream bos = new ByteArrayOutputStream(1000);
            byte[] b = new byte[1000];

            int n;
            while ((n = fis.read(b)) != -1) {
                bos.write(b, 0, n);
            }

            fis.close();
            bos.close();
            buffer = bos.toByteArray();
        } catch (FileNotFoundException var7) {
            var7.printStackTrace();
        } catch (IOException var8) {
            var8.printStackTrace();
        }

        return buffer;
    }

    protected void setParam(String key, Object value) {
        this.setParam(key, JSON.toJSONString(value));
    }

    protected void setParam(String key, Integer value) {
        this.setParam(key, value.toString());
    }

    protected void setParam(String key, Double value) {
        this.setParam(key, value.toString());
    }

    protected void setParam(String key, Byte value) {
        this.setParam(key, value.toString());
    }

    protected void setParam(String key, Boolean value) {
        this.setParam(key, value.toString());
    }

    protected void setParam(String key, Character value) {
        this.setParam(key, value.toString());
    }

    protected void setParam(String key, String value) {
        this.params.put(key, value);
    }

    public void execute() {
        try {
            this.LOG.info("--------------- request params -----------");
            if (null != this.params && !this.params.isEmpty()) {
                this.LOG.debug(printOut(this.params));
            }

            this.LOG.info(printOut(this.content));
            this.LOG.info("------------------------------------------");
            if (null != this.params && !this.params.isEmpty()) {
                Iterator var1 = this.params.entrySet().iterator();

                while (var1.hasNext()) {
                    Map.Entry<String, String> entry = (Map.Entry) var1.next();
                    this.builder.param((String) entry.getKey(), new String[]{(String) entry.getValue()});
                }
            }

            this.perform();
            this.LOG.info("--------------- response -----------");
            this.LOG.info(printOut(JSON.parseObject(this.mockResult.getResponse().getContentAsString())));
            this.LOG.info("------------------------------------------");
        } catch (Exception var3) {
            var3.printStackTrace();
        }

    }

    public JSONObject getRusult() {
        try {
            return JSON.parseObject(this.mockResult.getResponse().getContentAsString());
        } catch (Exception var2) {
            return new JSONObject();
        }
    }

    private void perform() throws Exception {
        this.builder.contentType(MediaType.APPLICATION_JSON);
        this.builder.characterEncoding("UTF-8");
        ResultActions resultActions = this.mvc.perform(this.builder);
        this.mockResult = resultActions.andReturn();
    }

    private void setContent(Object content) {
        this.content = content;
        if (null != content) {
            this.builder.content(JSONObject.toJSONString(content));
        }

    }

    public static String printOut(Object... results) {
        int var2 = results.length;
        byte var3 = 0;
        if (var3 < var2) {
            Object object = results[var3];
            if (object == null) {
                return null;
            } else {
                return !(object instanceof JSONArray) && !(object instanceof List) ? printJsonObject(JSONObject.parseObject(JSON.toJSONString(object)), "", "") : printJsonArray(JSONArray.parseArray(JSON.toJSONString(object)), "", "");
            }
        } else {
            return null;
        }
    }

    private static String printJsonObject(JSONObject jsonObj, String blank, String firstBlank) {
        StringBuilder sb = new StringBuilder();
        sb.append(println());
        sb.append(println(firstBlank + "{"));
        int i = 0;
        Iterator var5 = jsonObj.entrySet().iterator();

        while (var5.hasNext()) {
            Map.Entry<String, Object> param = (Map.Entry) var5.next();
            sb.append(blank);
            sb.append("  \"");
            sb.append((String) param.getKey());
            sb.append("\":");
            Object value = param.getValue();
            if (value instanceof JSONObject) {
                sb.append(printJsonObject((JSONObject) value, blank + "  ", blank + "  "));
            } else if (!(value instanceof JSONArray)) {
                if (value instanceof String) {
                    sb.append("\"");
                    sb.append(value);
                    sb.append("\"");
                } else {
                    sb.append(value.toString());
                }
            } else {
                JSONArray array = (JSONArray) value;
                sb.append("[");

                for (int j = 0; j < array.size(); ++j) {
                    Object childParam = array.get(j);
                    if (childParam instanceof JSONObject) {
                        sb.append(printJsonObject(array.getJSONObject(j), blank + "   ", blank + "   "));
                    } else {
                        sb.append("\n");
                        if (childParam instanceof String) {
                            sb.append(blank + "    " + "\"" + childParam + "\"");
                        } else {
                            sb.append(blank + "    " + childParam);
                        }
                    }

                    if (j != array.size() - 1) {
                        sb.append(",");
                    }
                }

                sb.append(println());
                sb.append(blank);
                sb.append("  ]");
            }

            ++i;
            if (i == jsonObj.entrySet().size()) {
                sb.append(println());
            } else {
                sb.append(println(","));
            }
        }

        sb.append(blank);
        sb.append("}");
        return sb.toString();
    }

    private static String printJsonArray(JSONArray jsonArray, String blank, String firstBlank) {
        StringBuilder sb = new StringBuilder();
        sb.append(println());
        sb.append(println(firstBlank + "["));

        for (int i = 0; i < jsonArray.size(); ++i) {
            Object object = jsonArray.get(i);
            sb.append(printJsonObject((JSONObject) object, "   ", "   "));
            if (i < jsonArray.size() - 1) {
                sb.append(println(","));
            }
        }

        sb.append(println());
        sb.append(blank);
        sb.append("]");
        return sb.toString();
    }

    private static String println(String str) {
        return str + println();
    }

    private static String println() {
        return "\n";
    }
}
