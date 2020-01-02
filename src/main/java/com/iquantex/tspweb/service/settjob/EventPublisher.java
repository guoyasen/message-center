package com.iquantex.tspweb.service.settjob;

import com.alibaba.fastjson.JSONObject;
import com.iquantex.tspweb.common.ApplicationContextProvider;
import com.iquantex.tspweb.param.settjob.MsgData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @Auther: baozi
 * @Date: 2018/12/11 21:57
 * @Description:
 */
@Slf4j
@Component
public class EventPublisher implements Runnable {

    protected static BlockingQueue<Object> blockingQueue = new LinkedBlockingQueue<>(500);

    // TODO 模拟IMS中MsgCenter处理模式
    public static void send(Object object) {
        try {
            blockingQueue.put(object);
        } catch (InterruptedException e) {
            log.error(e.getMessage(), e);
            Thread.interrupted();
        }
    }

    @Override
    public void run() {

        SimpMessagingTemplate simpMessagingTemplate = ApplicationContextProvider.getBean(SimpMessagingTemplate.class);
        while (true) {
            try {
                Object object = blockingQueue.take();

                String msgType = object.getClass().getSimpleName();
                MsgData msgData = new MsgData(msgType, object);
                simpMessagingTemplate.convertAndSend("/topic/joblog", msgData);
                log.info("send settle log:<{}>", JSONObject.toJSONString(msgData));
            } catch (InterruptedException e) {
                log.error(e.getMessage(), e);
                Thread.currentThread().interrupt();
            } catch (Throwable e) {
                log.error(e.getMessage(), e);
            }
        }
    }
}
