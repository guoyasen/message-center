package com.iquantex.tspweb.interceptor.websocket;

import com.alibaba.fastjson.JSON;
import com.iquantex.tspweb.common.SpringContextUtils;
import com.iquantex.tspweb.model.TspUser;
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
 * 自定义{@link DefaultHandshakeHandler}，实现“生成自定义的{@link Principal}”
 *
 * @author zifangsky
 * @date 2018/10/11
 * @since 1.0.0
 */
@Component
public class MyHandshakeHandler extends DefaultHandshakeHandler{
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    protected Principal determineUser(ServerHttpRequest request, WebSocketHandler wsHandler, Map<String, Object> attributes) {

        HttpSession session = SpringContextUtils.getSession();
        TspUser loginUser = (TspUser) session.getAttribute("user");
        logger.info(JSON.toJSONString(session));
        logger.info(JSON.toJSONString(loginUser));

        if(loginUser != null){
            logger.debug(MessageFormat.format("WebSocket连接开始创建Principal，用户：{0}", loginUser.getUserId()));
            return new MyPrincipal(loginUser.getUserId());
        }else{
            logger.error("未登录系统，禁止连接WebSocket");
            return null;
        }
    }

}
