package com.iquantex.tspweb.controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessagingException;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.user.SimpUser;
import org.springframework.messaging.simp.user.SimpUserRegistry;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by baozi on 2018/6/11.
 */
@Controller
@Slf4j
public class WebSocketAction {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    //spring提供的发送消息模板
    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @Autowired
    private SimpUserRegistry userRegistry;

    @RequestMapping(value = "/templateTest")
    @ResponseBody
    public String templateTest(@RequestParam String userName) {
        logger.info("当前在线人数:" + userRegistry.getUserCount());
        int i = 1;
        for (SimpUser user : userRegistry.getUsers()) {
            logger.info("用户" + i++ + "---" + user);
        }
        //发送消息给指定用户
        try {
            messagingTemplate.convertAndSendToUser(userName, "/queue/message", "服务器主动推的数据" + userName);
        } catch (MessagingException e) {
            log.error("templateTest error <{}>,data <{}>", e.getMessage(),userName);
        }
        return "OK";
    }

}
