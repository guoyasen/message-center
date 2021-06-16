package com.iquantex.messagecenter.endpoint;

import com.iquantex.messagecenter.bean.MonitorMessage;
import com.iquantex.messagecenter.bean.MsgData;
import com.iquantex.messagecenter.common.MyWebSocketConfigurator;
import com.iquantex.messagecenter.common.SessionUtil;
import com.iquantex.messagecenter.prividers.IMsgPusher;
import com.iquantex.web.framework.util.SessionData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 消息推送的Websocket 服务终端
 *
 * @author barry
 */
@ServerEndpoint(value = "/event/endpoint/monitor", configurator = MyWebSocketConfigurator.class)
@Component
public class MonitorEventEndpoint {
    private static final Logger LOG = LoggerFactory.getLogger(MonitorEventEndpoint.class);

    @OnOpen
    public void handleOpen(Session session, EndpointConfig endpointConfig) {
        SessionUtil.setSession(session);
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        LOG.info("websocket连接成功...userId:{}，sessionId:{}", SessionData.getUserId(), session.getId());
    }

    @OnClose
    public void handleClose(Session session) {
        SessionUtil.removeSession(session);
        LOG.info("session已关闭...userId={},sessionId:{}", getUserId(session), session.getId());
    }

    @OnError
    public void handleError(Session session, Throwable t) {
        SessionUtil.removeSession(session);
        LOG.error("会话异常,sessindID:<{}>,error:<{}>", session.getId(), t);
    }

    /**
     * 接收到客户端的消息后会回推信息给请求者
     *
     * @param session
     * @param message
     */
    @OnMessage
    public void handleMessage(final Session session, String message) {
        LOG.info("接收到消息:{}", message);
        sendMonitorEvent(session);
    }

    private Long getUserId(Session session) {
        return SessionUtil.getUserId(session);
    }

    private void sendMonitorEvent(Session session) {
        List<MonitorMessage> monitorEvents = new ArrayList<>();
        for (Session newsession : SessionUtil.listSession()) {
            MonitorMessage monitorMessage = new MonitorMessage();
            if (newsession.isOpen()) {
                monitorMessage.setIsAlive("alive");
            } else {
                monitorMessage.setIsAlive("dead");
            }
            monitorMessage.setEndpoint("/event/endpoint");
            monitorMessage.setIp((String) newsession.getUserProperties().get(SessionUtil.IP));
            monitorMessage.setMac((String) newsession.getUserProperties().get(SessionUtil.MAC));
            monitorMessage.setUserId((Long) newsession.getUserProperties().get(SessionUtil.USER_ID));

            monitorEvents.add(monitorMessage);
        }

        MsgData msgData = new MsgData("Sessions", monitorEvents);
        try {
            IMsgPusher.send(session, msgData);
        } catch (IOException e) {
            LOG.error("消息推送【" + session.getId() + "】失败", e);
        }

    }

}
