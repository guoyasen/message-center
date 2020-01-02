package com.iquantex.tspweb.param.settjob;

/**
 * Created by hegj on 2017/5/25.
 */
public class MsgData {
    private String msgType;
    private Object data;
    private boolean ack;

    public MsgData(String msgType, Object data) {
        this.msgType = msgType;
        this.data = data;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public boolean isAck() {
        return ack;
    }

    public void setAck(boolean ack) {
        this.ack = ack;
    }
}