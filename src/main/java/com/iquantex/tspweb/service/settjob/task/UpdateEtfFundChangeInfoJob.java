package com.iquantex.tspweb.service.settjob.task;

import com.iquantex.tspweb.common.RestTemplateUtil;
import com.iquantex.tspweb.model.RpstorSettChildtask;
import com.iquantex.tspweb.service.settjob.RpstorSettChildTaskIBasic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

/**
 * etf 基金日行情份额基本信息
 *
 * @author shenzhengjie
 * @date 2019/3/8 14:29
 */
@Service
public class UpdateEtfFundChangeInfoJob extends RpstorSettChildTaskIBasic {

    @Autowired
    private RestTemplateUtil restTemplateUtil;

    @Override
    public int execute() {
        String url = restTemplateUtil.tspUrl + "/refdata/etf_fund_change_info";
        String returnInfo = restTemplateUtil.exchangeByDefault(url, HttpMethod.PUT, null);

        String url2 = restTemplateUtil.tspUrl2 + "/refdata/etf_fund_change_info";
        String returnInfo2 = restTemplateUtil.exchangeByDefault(url2, HttpMethod.PUT, null);

        Integer res1 = restTemplateUtil.returnInfo(returnInfo, LOG, UpdateEtfFundChangeInfoJob.class.getSimpleName());
        if (res1 ==  RpstorSettChildtask.c_status_done) {
            return restTemplateUtil.returnInfo(returnInfo2, LOG, UpdateEtfFundChangeInfoJob.class.getSimpleName());
        } else {
            return res1;
        }
    }
}
