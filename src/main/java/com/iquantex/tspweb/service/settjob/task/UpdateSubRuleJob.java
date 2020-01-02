package com.iquantex.tspweb.service.settjob.task;

import com.iquantex.tspweb.common.RestTemplateUtil;
import com.iquantex.tspweb.model.RpstorSettChildtask;
import com.iquantex.tspweb.service.settjob.RpstorSettChildTaskIBasic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

/**
 * 更新细则信息
 *
 * @author shenzhengjie
 * @date 2018/12/27 14:57
 */
@Service
public class UpdateSubRuleJob extends RpstorSettChildTaskIBasic {

    @Autowired
    private RestTemplateUtil restTemplateUtil;

    @Override
    public int execute() {
//        String url = restTemplateUtil.tspUrl + "/refdata/rules";
//        String returnInfo = restTemplateUtil.exchangeByDefault(url, HttpMethod.PUT, null);
//        return restTemplateUtil.returnInfo(returnInfo, LOG, UpdateSubRuleJob.class.getSimpleName());
        String url = restTemplateUtil.tspUrl + "/refdata/rules";
        String returnInfo = restTemplateUtil.exchangeByDefault(url, HttpMethod.PUT, null);

        String url2 = restTemplateUtil.tspUrl2 + "/refdata/rules";
        String returnInfo2 = restTemplateUtil.exchangeByDefault(url2, HttpMethod.PUT, null);

        Integer res1 = restTemplateUtil.returnInfo(returnInfo, LOG, UpdateSecuInfosJob.class.getSimpleName());
        if (res1 ==  RpstorSettChildtask.c_status_done) {
            return  restTemplateUtil.returnInfo(returnInfo2, LOG, UpdateSecuInfosJob.class.getSimpleName());
        } else {
            return res1;
        }
    }
}
