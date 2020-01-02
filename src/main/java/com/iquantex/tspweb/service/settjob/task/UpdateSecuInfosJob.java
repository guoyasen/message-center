package com.iquantex.tspweb.service.settjob.task;

import com.iquantex.tspweb.common.RestTemplateUtil;
import com.iquantex.tspweb.model.RpstorSettChildtask;
import com.iquantex.tspweb.service.settjob.RpstorSettChildTaskIBasic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

/**
 * 万得证券信息
 *
 * @author shenZhengJie
 * @date 2018/12/21 9:48
 */
@Service
public class UpdateSecuInfosJob extends RpstorSettChildTaskIBasic {

    @Autowired
    private RestTemplateUtil restTemplateUtil;

    @Override
    public int execute() {
        String url = restTemplateUtil.tspUrl + "/refdata/secu_infos";
        String returnInfo = restTemplateUtil.exchangeByDefault(url, HttpMethod.PUT, null);

        String url2 = restTemplateUtil.tspUrl2 + "/refdata/secu_infos";
        String returnInfo2 = restTemplateUtil.exchangeByDefault(url2, HttpMethod.PUT, null);

        Integer res1 = restTemplateUtil.returnInfo(returnInfo, LOG, UpdateSecuInfosJob.class.getSimpleName());
        if (res1 ==  RpstorSettChildtask.c_status_done) {
            return  restTemplateUtil.returnInfo(returnInfo2, LOG, UpdateSecuInfosJob.class.getSimpleName());
        } else {
            return res1;
        }
    }
}
