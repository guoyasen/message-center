package com.iquantex.tspweb.service.settjob.task;

import com.alibaba.fastjson.JSONObject;
import com.iquantex.tspweb.common.RestTemplateUtil;
import com.iquantex.tspweb.model.RpstorSettChildtask;
import com.iquantex.tspweb.service.settjob.RpstorSettChildTaskIBasic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

/**
 * 初始化快照信息
 *
 * @author shenzhengjie
 * @date 2018/12/24 10:36
 */
@Service
public class SaveSnapshotJob extends RpstorSettChildTaskIBasic {

    @Autowired
    private RestTemplateUtil restTemplateUtil;

    @Override
    public int execute() {
        // 打快照方法，只对master打快照即可，tsp-server内部会自己判断自己是否是master，非master会报错
        String url = restTemplateUtil.tspUrl + "/root";
        String returnInfo = restTemplateUtil.exchangeByDefault(url, HttpMethod.POST, null);

        String url2 = restTemplateUtil.tspUrl2 + "/root";
        String returnInfo2 = restTemplateUtil.exchangeByDefault(url2, HttpMethod.POST, null);

        // 第一个失败再执行第二个，两个都失败为失败，一个成功为成功
        JSONObject json = JSONObject.parseObject(returnInfo);
        Integer code = json.getInteger("code");
        if (code.equals(200)) {
            LOG.infoWithPub("初始化" + SaveSnapshotJob.class.getSimpleName() + "成功");
            return RpstorSettChildtask.c_status_done;
        } else {
            json = JSONObject.parseObject(returnInfo2);
            code = json.getInteger("code");
            if (code.equals(200)) {
                LOG.infoWithPub("初始化" + SaveSnapshotJob.class.getSimpleName() + "成功");
                return RpstorSettChildtask.c_status_done;
            } else {
                LOG.errorWithPub(String.format("初始化<%s>失败. 失败信息<%s>. ", SaveSnapshotJob.class.getSimpleName(), json.getString("msg")));
                return RpstorSettChildtask.c_status_warning;
            }
        }
    }
}
