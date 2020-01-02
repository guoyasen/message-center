package com.iquantex.tspweb.service.settjob.task;

import com.iquantex.tspweb.common.RestTemplateUtil;
import com.iquantex.tspweb.model.RpstorSettChildtask;
import com.iquantex.tspweb.service.settjob.RpstorSettChildTaskIBasic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

/**
 * 更新证券日内行情静态数据
 *
 * @author  xp
 * @date 2019/03/05 09:11
 */
@Service
public class UpdateRealTimeQttinJob extends RpstorSettChildTaskIBasic {

    @Autowired
    private RestTemplateUtil restTemplateUtil;

    @Override
    public int execute() {
        String url = restTemplateUtil.tspUrl + "/refdata/rl_tm_qttin";
        String returnInfo = restTemplateUtil.exchangeByDefault(url, HttpMethod.PUT, null);

        String url2 = restTemplateUtil.tspUrl2 + "/refdata/rl_tm_qttin";
        String returnInfo2 = restTemplateUtil.exchangeByDefault(url2, HttpMethod.PUT, null);

        Integer res1 = restTemplateUtil.returnInfo(returnInfo, LOG, UpdateRealTimeQttinJob.class.getSimpleName());
        if (res1 ==  RpstorSettChildtask.c_status_done) {
            return  restTemplateUtil.returnInfo(returnInfo2, LOG, UpdateRealTimeQttinJob.class.getSimpleName());
        } else {
            return res1;
        }
    }
}
