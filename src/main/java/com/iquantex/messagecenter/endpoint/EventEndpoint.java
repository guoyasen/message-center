package com.iquantex.messagecenter.endpoint;

import com.alibaba.fastjson.JSONObject;
import com.iquantex.messagecenter.common.MyWebSocketConfigurator;
import com.iquantex.messagecenter.common.SessionUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.util.Objects;

/**
 * 消息推送的Websocket 服务终端
 *
 * @author devin
 */
@ServerEndpoint(value = "/event/endpoint", configurator = MyWebSocketConfigurator.class)
@Component
public class EventEndpoint {
    private static final Logger LOG = LoggerFactory.getLogger(EventEndpoint.class);

    @OnOpen
    public void handleOpen(Session session, EndpointConfig endpointConfig) {
        SessionUtil.setSession(session);
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        LOG.info("websocket<session: {}, user: {}>连接成功", session.getId(), SessionUtil.getUserId(session));
    }

    @OnClose
    public void handleClose(Session session) {
        SessionUtil.removeSession(session);
        LOG.warn("session<session: {}, user: {}>已关闭", session.getId(), getUserId(session));
    }

    @OnError
    public void handleError(Session session, Throwable t) {
        SessionUtil.removeSession(session);
        LOG.error("会话<session: {}, user: {}>, error:", session.getId(), SessionUtil.getUserId(session), t);
    }

    @OnMessage
    public void handleMessage(final Session session, String message) {
        LOG.info("接收到消息<session: {}, user: {}>:{}", session.getId(), getUserId(session),  message);

        if (StringUtils.isNotBlank(message)) {
            try {
                JSONObject jsonObject = JSONObject.parseObject(message);

                String msgType = jsonObject.getString("msgType");
                if (Objects.equals(msgType, "ack")) {
                    handleAckEvent(session, jsonObject.getString("requestId"));
                }
            } catch (Exception e) {
                LOG.warn("消息处理失败<session: {}, user: {}>: message<{}>", session.getId(), SessionUtil.getUserId(session), message, e);
            }
        }
    }

    /**
     * Event Ack处理
     *
     * @param session
     * @param requestId
     * @return
     */
    private static void handleAckEvent(Session session, String requestId) {
        // todo 做消息的ack处理，因为以前经常丢消息，所以做了个记录
    }

    private Long getUserId(Session session) {
        return SessionUtil.getUserId(session);
    }


}
