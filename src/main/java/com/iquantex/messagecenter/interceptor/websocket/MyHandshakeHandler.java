package com.iquantex.messagecenter.interceptor.websocket;

import com.iquantex.messagecenter.common.Constants;
import com.iquantex.messagecenter.common.SpringContextUtils;
import com.iquantex.web.framework.util.SessionData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.DefaultHandshakeHandler;

import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.text.MessageFormat;
import java.util.Map;

/**
 * 自定义{@link org.springframework.web.socket.server.support.DefaultHandshakeHandler}，实现“生成自定义的{@link java.security.Principal}”
 *
 * @author qingjie.du
 */
@Component
public class MyHandshakeHandler extends DefaultHandshakeHandler{
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    protected Principal determineUser(ServerHttpRequest request, WebSocketHandler wsHandler, Map<String, Object> attributes) {
        HttpSession session = SpringContextUtils.getSession();
        Long userId = (Long) session.getAttribute(Constants.SESSION_USER);

        if(null != userId && userId.equals(SessionData.getUserId())){
            logger.debug(MessageFormat.format("WebSocket连接开始创建Principal，用户id：{0}", userId));
            return new MyPrincipal(userId.toString());
        }else{
            logger.error("未登录系统，禁止连接WebSocket");
            return null;
        }
    }

}
