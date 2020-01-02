package com.iquantex.tspweb.param;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * 跑马灯websocket
 */
@Data
@ToString
public class LightVO {
    /** 检查结果id */
    private long ruleResultId;
    /** 检查时间 */
    private long checkTime;
    /** 指令编码 */
    private String instCode;
    /** 规则id */
    private String ruleId;
    /** 规则名称 */
    private String ruleName;
    /** 处理状态<>error=1=处理异常&noneedCheck=0=不检查&pass=1=通过&notPass=2=告警 */
    private int status;

    public void setCheckTime(Date date) {
        this.checkTime = date.getTime();
    }
}