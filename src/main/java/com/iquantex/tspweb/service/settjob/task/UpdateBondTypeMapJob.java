package com.iquantex.tspweb.service.settjob.task;

import com.iquantex.tspweb.common.RestTemplateUtil;
import com.iquantex.tspweb.model.RpstorSettChildtask;
import com.iquantex.tspweb.service.settjob.RpstorSettChildTaskIBasic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

/**
 * 债券类型字典
 *
 * @author xiangpeng
 * @date 2019/09/19 14:09
 */
@Service
public class UpdateBondTypeMapJob extends RpstorSettChildTaskIBasic {

    @Autowired
    private RestTemplateUtil restTemplateUtil;

    @Override
    public int execute() {
        String url = restTemplateUtil.tspUrl + "/refdata/bond_type";
        String returnInfo = restTemplateUtil.exchangeByDefault(url, HttpMethod.PUT, null);

        String url2 = restTemplateUtil.tspUrl2 + "/refdata/bond_type";
        String returnInfo2 = restTemplateUtil.exchangeByDefault(url2, HttpMethod.PUT, null);

        Integer res1 = restTemplateUtil.returnInfo(returnInfo, LOG, UpdateBondTypeMapJob.class.getSimpleName());
        if (res1 ==  RpstorSettChildtask.c_status_done) {
            return restTemplateUtil.returnInfo(returnInfo2, LOG, UpdateBondTypeMapJob.class.getSimpleName());
        } else {
            return res1;
        }
    }
}
