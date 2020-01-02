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
 * @author  xp
 * @date 2019/01/29 11:15
 */
@Service
public class UpdateEtfFundQuttJob extends RpstorSettChildTaskIBasic {

    @Autowired
    private RestTemplateUtil restTemplateUtil;

    @Override
    public int execute() {
        String url = restTemplateUtil.tspUrl + "/refdata/fnd_day_qutt";
        String returnInfo = restTemplateUtil.exchangeByDefault(url, HttpMethod.PUT, null);

        String url2 = restTemplateUtil.tspUrl2 + "/refdata/fnd_day_qutt";
        String returnInfo2 = restTemplateUtil.exchangeByDefault(url2, HttpMethod.PUT, null);

        Integer res1 = restTemplateUtil.returnInfo(returnInfo, LOG, UpdateEtfFundQuttJob.class.getSimpleName());
        if (res1 ==  RpstorSettChildtask.c_status_done) {
            return  restTemplateUtil.returnInfo(returnInfo2, LOG, UpdateEtfFundQuttJob.class.getSimpleName());
        } else {
            return res1;
        }
    }
}
