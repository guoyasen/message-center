package com.iquantex.tspweb.UnifiedExchange;

import com.murong.ecp.gep.zookeeper.client.HiGepHttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

@Component
public class UnifiedExchangeService {

    @Autowired
    UnifiedExchangeConfigBean unifiedExchangeConfigBean;


    public static final String UEXCHANGE_CONF = "./cfg/init.properties";
    private static final Logger LOG = LoggerFactory.getLogger(UnifiedExchangeService.class);


    @PostConstruct
    // 统一交换平台服务初始化
    public void init() {
        initConfig();
        HiGepHttpClient.initProperties(UEXCHANGE_CONF);
        LOG.info("初始化统一交换平台服务成功<{}>",unifiedExchangeConfigBean.getZkServer());
    }

    // 生成配置文件
    private void initConfig() {

        Properties properties = new Properties();
        properties.setProperty("clientId", unifiedExchangeConfigBean.getClientId());
        properties.setProperty("ZkServer", unifiedExchangeConfigBean.getZkServer());
        properties.setProperty("Encoding", unifiedExchangeConfigBean.getEncoding());
        properties.setProperty("timeOut", unifiedExchangeConfigBean.getTimeOut());
        properties.setProperty("confDir", unifiedExchangeConfigBean.getConfDir());
        //使用Properties生产配置文件
        try {
            properties.store(new FileWriter(UEXCHANGE_CONF), "统一交换平台配置文件");
        } catch (IOException e) {
            LOG.error(e.getMessage(), e);
            //e.printStackTrace();
        }
    }
}
