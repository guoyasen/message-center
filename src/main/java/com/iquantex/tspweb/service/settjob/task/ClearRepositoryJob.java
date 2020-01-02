package com.iquantex.tspweb.service.settjob.task;

import com.iquantex.tspweb.common.RestTemplateUtil;
import com.iquantex.tspweb.model.RpstorSettChildtask;
import com.iquantex.tspweb.service.settjob.RpstorSettChildTaskIBasic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

/**
 * 初始化聚合根信息
 *
 * @author shenzhengjie
 * @date 2018/12/24 10:35
 */
@Service
public class ClearRepositoryJob extends RpstorSettChildTaskIBasic {

    @Autowired
    private RestTemplateUtil restTemplateUtil;

    @Override
    public int execute() {
        String url = restTemplateUtil.tspUrl + "/root/clear_repository/tsp-server";
        String returnInfo = restTemplateUtil.exchangeByDefault(url, HttpMethod.POST, null);

        String url2 = restTemplateUtil.tspUrl2 + "/root/clear_repository/tsp-server";
        String returnInfo2 = restTemplateUtil.exchangeByDefault(url2, HttpMethod.POST, null);

        Integer res1 = restTemplateUtil.returnInfo(returnInfo, LOG, ClearRepositoryJob.class.getSimpleName());
        if (res1 ==  RpstorSettChildtask.c_status_done) {
            return restTemplateUtil.returnInfo(returnInfo2, LOG, ClearRepositoryJob.class.getSimpleName());
        } else {
            return res1;
        }

    }
}
