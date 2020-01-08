package com.iquantex.messagecenter.interceptor.websocket;

import com.iquantex.web.framework.bean.RequestUserInfo;
import com.iquantex.web.framework.util.SessionData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

import java.text.MessageFormat;
import java.util.Map;

/**
 * 自定义{@link org.springframework.web.socket.server.HandshakeInterceptor}，实现“需要登录才允许连接WebSocket”
 *
 * @author qingjie.du
 */
@Component
public class AuthHandshakeInterceptor implements HandshakeInterceptor {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public boolean beforeHandshake(ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse, WebSocketHandler webSocketHandler, Map<String, Object> map) throws Exception {
        RequestUserInfo userInfo = SessionData.getUserInfo();
        if(userInfo != null){
            logger.debug(MessageFormat.format("用户{0}请求建立WebSocket连接", userInfo.getName()));
            return true;
        }else{
            logger.error("未登录系统，禁止连接WebSocket");
            return false;
        }
    }

    @Override
    public void afterHandshake(ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse, WebSocketHandler webSocketHandler, Exception e) {
        logger.info("after principal:"+serverHttpRequest.getPrincipal());
    }

}
