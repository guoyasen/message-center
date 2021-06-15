package com.iquantex.messagecenter.prividers;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.iquantex.messagecenter.MessageEvent;
import com.iquantex.messagecenter.bean.MsgData;
import com.iquantex.messagecenter.bean.SysEventAckBean;
import com.iquantex.messagecenter.bean.WebsocketMsg;
import com.iquantex.messagecenter.common.SessionUtil;
import com.iquantex.messagecenter.endpoint.AllEventEndpoint;
import com.iquantex.web.framework.util.DateUtil;
import com.iquantex.web.framework.util.ThreadLocalUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.websocket.Session;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * 消息推送器
 *
 * @author devin
 */
public class IMsgPusher {

    private static Logger LOG = LoggerFactory.getLogger(IMsgPusher.class);

    /**
     * session 发送
     *
     * @param session
     * @param data
     * @throws IOException
     */
    public static void send(Session session, Object data) throws IOException {
        if (null != session && session.isOpen()) {
            synchronized (session) {
                String text = makeReturn(data, session);
                LOG.info("消息发送到客户端<session: {}, user: {}> : {}", session.getId(), SessionUtil.getUserId(session), text);
                session.getBasicRemote().sendText(text);
            }
        }
    }

    /**
     * 消息内容推送给接收者
     *
     * @param userIds
     * @param eventObj
     */
    public static void push(List<Long> userIds, Object eventObj) {

        String msgType = eventObj.getClass().getSimpleName();    // 消息类型
        Object data = eventObj;    // 数据

        ThreadLocalUtil.setRequestId(UUID.randomUUID().toString());

        // 对qtwMsg事件特殊处理
        /*if (eventObj instanceof QTWMsgEvent) {
            QTWMsgEvent event = (QTWMsgEvent) eventObj;
            msgType = event.getMsgType();
            data = JSONObject.parseObject(event.getData());
        }*/

        // 当前事件是否需要持久化
        boolean isEventRecord = isEventRecord(eventObj);

        // 记录接收事件
        if (isEventRecord) {
//            recordEvent(eventObj);
        }

        MsgData msgData = new MsgData(msgType, data);
        msgData.setAck(isEventRecord);

        List<Session> sessions = SessionUtil.listSession(userIds);
        for (Session session : sessions) {
            try {
                if (isEventRecord && session.isOpen()) {
                    handleMsgAckEvent(session);
                }

                send(session, msgData);
            } catch (IOException e) {
                LOG.error("消息推送<session: {}, user: {}>失败", session.getId(), SessionUtil.getUserId(session), e);
            }
        }
        // 推送给所有人
        pushAll(msgData);
    }

    private static boolean isEventRecord(Object event) {
        return event instanceof MessageEvent;
    }


    /**
     * @param
     * @return
     * @author qgm
     * @date
     */
    private static void handleMsgAckEvent(Session session) {
        SysEventAckBean sysEventAckBean = new SysEventAckBean();
        sysEventAckBean.setRequestId(ThreadLocalUtil.getRequestId());
        sysEventAckBean.setSessionInfo(session);
        sysEventAckBean.setType(SysEventAckBean.C_TYPE_ADD);
        sysEventAckBean.setSendTime(DateUtil.getSysDate());

    }

    /**
     * 发送所有消息
     *
     * @param msgData
     */
    private static void pushAll(MsgData msgData) {
        for (Session session : AllEventEndpoint.sessions) {
            try {
                send(session, msgData);
            } catch (IOException e) {
                LOG.warn("消息推送<session: {}, user: {}>失败", session.getId(), SessionUtil.getUserId(session), e);
            }
        }
    }

    /**
     * 生成返回结果的json字符串
     *
     * @param data
     * @return
     */
    private static String makeReturn(Object data, Session session) {
        WebsocketMsg websocketMsg = new WebsocketMsg(data);
        // 设置sessionId
        websocketMsg.setSessionId(session.getId());
        return JSONObject.toJSONString(websocketMsg, SerializerFeature.WriteMapNullValue);
    }

}
