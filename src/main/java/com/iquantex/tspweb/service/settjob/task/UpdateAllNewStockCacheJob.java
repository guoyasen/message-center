package com.iquantex.tspweb.service.settjob.task;

import com.iquantex.tspweb.common.RestTemplateUtil;
import com.iquantex.tspweb.service.settjob.RpstorSettChildTaskIBasic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

/**
 * 更新所有新股集合（market）
 *
 * @author  xp
 * @date 2019/4/12 17:15
 */
@Service
public class UpdateAllNewStockCacheJob extends RpstorSettChildTaskIBasic {

    @Autowired
    private RestTemplateUtil restTemplateUtil;

    @Override
    public int execute() {
        String url = restTemplateUtil.marketUrl + "/stock/all_new_stock";
        String returnInfo = restTemplateUtil.exchangeByDefault(url, HttpMethod.PUT, null);
        return restTemplateUtil.returnInfo(returnInfo, LOG, UpdateAllNewStockCacheJob.class.getSimpleName());
    }
}
