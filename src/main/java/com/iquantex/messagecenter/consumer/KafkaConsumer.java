package com.iquantex.messagecenter.consumer;

import com.alibaba.fastjson.JSONObject;
import com.iquantex.messagecenter.MessageEvent;
import com.iquantex.messagecenter.service.PushService;
import com.iquantex.messagecenter.service.feignclient.bean.User;
import com.iquantex.messagecenter.service.feignclient.service.UserDataService;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * kafka consumer kafka消息转发器
 *
 * @author qingjie.du
 */
@Service
public class KafkaConsumer {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserDataService userService;
    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @Autowired
    private PushService pushService;

    @KafkaListener(topics = "calendar-calendarEvent", groupId = "message-center")
    public void receiverMessage(ConsumerRecord<String, String> record) {
        logger.info("receive message: topic = {}, offset = {}, key = {}, value.size = {}",
                record.topic(), record.offset(), record.key(), record.value());
        try {
            onMessage(record.value());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }

    private void onMessage(String msg){
        List<User> users =  userService.getAll().getListFromData(User.class);
        for (User user:users) {
            logger.info("用户 {} 接收到 /topic/message 的消息，消息内容为:{}",user.getUserId(),msg);
            simpMessagingTemplate.convertAndSendToUser(user.getUserId().toString(),"/topic/message",msg);
        }
    }

    /**
     * 监听一个Kafka 主题
     **/
    @KafkaListener(topics = {"#{'${spring.kafka.consumer.topic}'.split(',')}"})
    public void receiveMessageFromKafka(ConsumerRecord<?, ?> record) {
        logger.info("监听消息:{}", JSONObject.parseObject(String.valueOf(record.value()), MessageEvent.class));

        Optional<?> kafkaMessage = Optional.ofNullable(record.value());
        if (kafkaMessage.isPresent()) {
            pushService.send(JSONObject.parseObject(String.valueOf(record.value()), MessageEvent.class));
//            sendMessageService.sendMessages(JSONObject.parseObject(String.valueOf(record.value()), MessageEvent.class));
        }
    }
}
