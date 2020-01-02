package com.iquantex.tspweb.common;

import com.alibaba.fastjson.JSONObject;
import com.iquantex.tspweb.model.RpstorSettChildtask;
import com.iquantex.tspweb.service.settjob.RpstorLoggerPlus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;

/**
 * @author shenZhengJie
 * @date 2018/12/20 17:59
 */
@Slf4j
@Component
public class RestTemplateUtil {

    @Value("${tsp-server.url}")
    public String tspUrl;

    @Value("${tsp-server2.url}")
    public String tspUrl2;

    @Value("${tsp-collect.url}")
    public String collectUrl;

    @Value("${tsp-market.url}")
    public String marketUrl;

    @Autowired
    private RestTemplate restTemplate;

    private HttpHeaders headers;

    @PostConstruct
    public void init() {
        headers = new HttpHeaders();
    }

    /**
     * 默认请求头格式为Json返回值为字符串的的http请求
     *
     * @param method
     */
    public String exchangeByDefault(String url, HttpMethod method, String body) {
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        HttpEntity<String> entity = new HttpEntity<String>(body, headers);
        return restTemplate.exchange(url, method, entity, String.class).getBody();
    }

    /**
     * 返回信息
     *
     * @param retString 返回信息
     */
    public Integer returnInfo(String retString, RpstorLoggerPlus LOG, String name) {
        JSONObject json = JSONObject.parseObject(retString);
        Integer code = json.getInteger("code");
        if (code.equals(200)) {
            LOG.infoWithPub("初始化" + name + "成功");
            return RpstorSettChildtask.c_status_done;
        } else {
            LOG.errorWithPub(String.format("初始化<%s>失败. 失败信息<%s>. ", name, json.getString("msg")));
        }
        return RpstorSettChildtask.c_status_warning;
    }
}
