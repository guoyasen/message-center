package com.iquantex.tspweb.model;

public class KmHandleResult {
    private boolean code;
    private String msg;
    private Object data;

    public KmHandleResult(boolean resultcode,Object data) {
        this.code=resultcode;
        this.data=data;
    }



    public KmHandleResult(boolean resultCode ,String msg ,Object data)
    {
        this.code=resultCode;
        this.msg=msg;
        this.data=data;
    }

    public boolean getCode()
    {
        return code;
    }

    public String getMsg()
    {
        return msg;
    }

    public Object getData()
    {
        return data;
    }

    public String toString()
    {
        return "{\"code\":"+this.code+",\"msg\":\""+this.msg+"\"}";
    }
}
