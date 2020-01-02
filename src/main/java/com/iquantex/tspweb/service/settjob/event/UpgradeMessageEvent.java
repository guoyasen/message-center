package com.iquantex.tspweb.service.settjob.event;

import lombok.Data;

/**
 * @Auther: baozi
 * @Date: 2018/12/11 21:58
 * @Description:
 */
@Data
public class UpgradeMessageEvent {
    public static final String c_action_stop = "stop";
    public static final String c_action_resume = "resume";

    private String action;
    private Long countdown;
    private String title;
}
