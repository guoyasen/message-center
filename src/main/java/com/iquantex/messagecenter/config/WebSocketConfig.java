package com.iquantex.messagecenter.config;

import com.iquantex.messagecenter.interceptor.websocket.AuthHandshakeInterceptor;
import com.iquantex.messagecenter.interceptor.websocket.MyChannelInterceptor;
import com.iquantex.messagecenter.interceptor.websocket.MyHandshakeHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * WebSocket相关配置
 *
 * @author qingjie.du
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer{
    @Autowired
    private AuthHandshakeInterceptor authHandshakeInterceptor;

    @Autowired
    private MyHandshakeHandler myHandshakeHandler;

    @Autowired
    private MyChannelInterceptor myChannelInterceptor;

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/stomp-websocket")
                .setHandshakeHandler(myHandshakeHandler)
                .addInterceptors(authHandshakeInterceptor)
                .setAllowedOrigins("*")
                .withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        //客户端需要把消息发送到/message/xxx地址
        registry.setApplicationDestinationPrefixes("/message");
        //服务端广播消息的路径前缀，客户端需要相应订阅/topic/yyy这个地址的消息
        registry.enableSimpleBroker("/topic");
        //给指定用户发送消息的路径前缀，默认值是/user/
        registry.setUserDestinationPrefix("/user/");
    }

    @Override
    public void configureClientInboundChannel(ChannelRegistration registration) {
        registration.interceptors(myChannelInterceptor);
    }

    @Bean
    public ServerEndpointExporter serverEndpointExporter(){
        return new ServerEndpointExporter();
    }
}
