package com.iquantex.tspweb;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;


@ServletComponentScan
@EnableScheduling
@MapperScan("com.iquantex.tspweb.dao")
@ComponentScan(basePackages = {"com.iquantex.tspweb.controller","com.iquantex.tspweb.common","com.iquantex.tspweb.service","com.iquantex.tspweb.config","com.iquantex.tspweb.consumer"})
@SpringBootApplication(exclude = MongoAutoConfiguration.class)
public class TspWebApplication {

    private static final Logger LOG = LoggerFactory.getLogger(TspWebApplication.class);
    public static void main(String[] args) {
        try {
            System.setProperty("com.rocketmq.sendMessageWithVIPChannel", "false");
            SpringApplication.run(TspWebApplication.class, args);
        }catch (Throwable e) {
            LOG.error(e.getMessage(), e);
            //e.printStackTrace();
            System.exit(1);
        }
    }

}