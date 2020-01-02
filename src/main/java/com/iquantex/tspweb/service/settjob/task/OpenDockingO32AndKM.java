package com.iquantex.tspweb.service.settjob.task;

import com.iquantex.tspweb.common.RestTemplateUtil;
import com.iquantex.tspweb.service.settjob.RpstorSettChildTaskIBasic;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

/**
 * 开启对接O32和KM
 *
 * @author shenzhengjie
 * @date 2019/1/16 15:55
 */
@Slf4j
@Service
public class OpenDockingO32AndKM extends RpstorSettChildTaskIBasic {

    @Autowired
    private RestTemplateUtil restTemplateUtil;

    @Override
    public int execute() {
        String url = restTemplateUtil.collectUrl + "/kafka/start";
        String returnInfo = restTemplateUtil.exchangeByDefault(url, HttpMethod.GET, null);
        return restTemplateUtil.returnInfo(returnInfo, LOG, OpenDockingO32AndKM.class.getSimpleName());
    }
}
