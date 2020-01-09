package com.iquantex.messagecenter.interceptor.websocket;

import com.alibaba.fastjson.JSON;
import com.iquantex.web.framework.annotation.Auth;
import com.iquantex.web.framework.bean.RequestUserInfo;
import com.iquantex.web.framework.util.SessionData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
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
@Auth
public class AuthHandshakeInterceptor implements HandshakeInterceptor {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public boolean beforeHandshake(ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse, WebSocketHandler webSocketHandler, Map<String, Object> map) throws Exception {
        ServletServerHttpRequest req = (ServletServerHttpRequest) serverHttpRequest;
        //获取token认证
        String token = req.getServletRequest().getParameter("token");
        try{
            SessionData.setToken(token,true);
            RequestUserInfo userInfo = SessionData.getUserInfo();
            logger.debug(MessageFormat.format("用户{0}请求建立WebSocket连接", userInfo.getName()));
            return true;
        } catch (Exception e) {
            logger.error(e.getMessage());
            return false;
        }
    }

    @Override
    public void afterHandshake(ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse, WebSocketHandler webSocketHandler, Exception e) {
        logger.info("after principal:"+serverHttpRequest.getPrincipal());
    }

}
