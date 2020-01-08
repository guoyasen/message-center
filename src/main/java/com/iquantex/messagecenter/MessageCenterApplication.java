package com.iquantex.messagecenter;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@ServletComponentScan
@EnableAsync
@EnableEurekaClient
@EnableFeignClients
@EnableApolloConfig
@EnableDiscoveryClient
public class MessageCenterApplication {
	public static void main(String[] args) {
		SpringApplication.run(MessageCenterApplication.class, args);
	}
}
