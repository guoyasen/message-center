package com.iquantex.tspweb.service.settjob.task;

import com.iquantex.tspweb.common.RestTemplateUtil;
import com.iquantex.tspweb.model.RpstorSettChildtask;
import com.iquantex.tspweb.service.settjob.RpstorSettChildTaskIBasic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

/**
 * 删除银行间债券和回购成交信息
 *
 * @author 向鹏
 * @date 2019/08/16 9:49
 */
@Service
public class ClearInterBankExecutionInfoJob extends RpstorSettChildTaskIBasic {

    @Autowired
    private RestTemplateUtil restTemplateUtil;

    @Override
    public int execute() {
        String url = restTemplateUtil.tspUrl + "/refdata/inter_bank_execution_info";
        String returnInfo = restTemplateUtil.exchangeByDefault(url, HttpMethod.DELETE, null);

        String url2 = restTemplateUtil.tspUrl2 + "/refdata/inter_bank_execution_info";
        String returnInfo2 = restTemplateUtil.exchangeByDefault(url2, HttpMethod.DELETE, null);

        Integer res1 = restTemplateUtil.returnInfo(returnInfo, LOG, ClearInterBankExecutionInfoJob.class.getSimpleName());
        if (res1 ==  RpstorSettChildtask.c_status_done) {
            return restTemplateUtil.returnInfo(returnInfo2, LOG, ClearInterBankExecutionInfoJob.class.getSimpleName());
        } else {
            return res1;
        }
    }
}
