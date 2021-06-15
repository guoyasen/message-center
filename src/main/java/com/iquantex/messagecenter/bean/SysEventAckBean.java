package com.iquantex.messagecenter.bean;

import com.iquantex.messagecenter.common.SessionUtil;

import javax.websocket.Session;
import java.util.Date;

public class SysEventAckBean {
    private String requestId;
    private String type;
    private String ip;
    private long userId;
    private String sessionId;
    private Date sendTime;

    public static final String C_TYPE_ADD = "add";
    public static final String C_TYPE_UPDATE = "update";

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setSessionInfo(Session session) {
        this.ip = SessionUtil.getIp(session);
        this.userId = SessionUtil.getUserId(session);
        this.sessionId = session.getId();
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }
}
