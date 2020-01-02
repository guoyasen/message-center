package com.iquantex.tspweb.service.settjob.task;

import com.iquantex.tspweb.common.RestTemplateUtil;
import com.iquantex.tspweb.model.RpstorSettChildtask;
import com.iquantex.tspweb.service.settjob.RpstorSettChildTaskIBasic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

/**
 * 基金基本信息
 *
 * @author shenZhengJie
 * @date 2018/12/21 9:48
 */
@Service
public class UpdateFundInfoJob extends RpstorSettChildTaskIBasic {

    @Autowired
    private RestTemplateUtil restTemplateUtil;

    @Override
    public int execute() {
        String url = restTemplateUtil.tspUrl + "/refdata/fund_info";
        String returnInfo = restTemplateUtil.exchangeByDefault(url, HttpMethod.PUT, null);

        String url2 = restTemplateUtil.tspUrl2 + "/refdata/fund_info";
        String returnInfo2 = restTemplateUtil.exchangeByDefault(url2, HttpMethod.PUT, null);

        Integer res1 = restTemplateUtil.returnInfo(returnInfo, LOG, UpdateFundInfoJob.class.getSimpleName());
        if (res1 == RpstorSettChildtask.c_status_done) {
            return restTemplateUtil.returnInfo(returnInfo2, LOG, UpdateFundInfoJob.class.getSimpleName());
        } else {
            return res1;
        }
    }
}
