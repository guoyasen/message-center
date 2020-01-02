package com.iquantex.tspweb.service.settjob.task;

import com.iquantex.tspweb.common.RestTemplateUtil;
import com.iquantex.tspweb.service.settjob.RpstorSettChildTaskIBasic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

/**
 * 更新ETF下成分股缓存（market）
 *
 * @author shenzhengjie
 * @date 2019/3/5 17:15
 */
@Service
public class UpdateEtfIngredientStockCacheJob extends RpstorSettChildTaskIBasic {

    @Autowired
    private RestTemplateUtil restTemplateUtil;

    @Override
    public int execute() {
        String url = restTemplateUtil.marketUrl + "/stock/load";
        String returnInfo = restTemplateUtil.exchangeByDefault(url, HttpMethod.PUT, null);
        return restTemplateUtil.returnInfo(returnInfo, LOG, UpdateEtfIngredientStockCacheJob.class.getSimpleName());
    }
}
