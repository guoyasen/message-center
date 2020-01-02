package com.iquantex.tspweb.service.settjob.event;

import lombok.Data;

/**
 * @Auther: baozi
 * @Date: 2018/12/11 21:56
 * @Description:
 */
@Data
public class EodMsgLogInfoEvent {
    public static final int c_msgType_normal = 0;
    public static final int c_msgType_except = 1;
    public static final int c_msgType_warning = 2;
    public static final int c_contentFormat_json = 1;
    public static final int c_contentFormat_String = 2;
    public static final int c_viewType_processlist = 1;
    public static final int c_viewType_jobtreelist = 2;
    public static final int c_viewType_msg = 3;
    public static final int c_viewType_other = 4;

    private int jobId;
    private String msg;
    private int msgType;
    private int viewType;
    private int contentFormat;
}
