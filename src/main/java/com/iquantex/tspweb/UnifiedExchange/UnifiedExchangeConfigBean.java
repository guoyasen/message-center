package com.iquantex.tspweb.UnifiedExchange;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "unifiedexchange")
public class UnifiedExchangeConfigBean {
    private String clientId;
    private String ZkServer;
    private String Encoding;
    private String timeOut;
    private String confDir;
}
