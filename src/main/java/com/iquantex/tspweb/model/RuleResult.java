package com.iquantex.tspweb.model;

import java.util.Date;
import javax.persistence.*;
import org.apache.ibatis.type.JdbcType;
import tk.mybatis.mapper.annotation.ColumnType;

@Table(name = "RULE_RESULT")
public class RuleResult {
    /**
     * 处理结果id
     */
    @Id
    @Column(name = "RULE_RESULT_ID")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Long ruleResultId;

    /**
     * 规则id
     */
    @Column(name = "RULE_ID")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String ruleId;

    /**
     * 告警状态<>error=-1=异常&noneedCheck=0=不检查&pass=1=通过&notPass=2=告警
     */
    @Column(name = "RESULT_STATUS")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Integer resultStatus;

    @Column(name = "INST_ID")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String instId;

    /**
     * 触发时间
     */
    @Column(name = "CHECK_TIME")
    @ColumnType(jdbcType = JdbcType.TIMESTAMP)
    private Date checkTime;

    /**
     * 处理时间
     */
    @Column(name = "DEAL_TIME")
    @ColumnType(jdbcType = JdbcType.TIMESTAMP)
    private Date dealTime;

    /**
     * 状态<>noHandle=0=未处理&handle=1=处理&hang=2=挂起
     */
    @Column(name = "STATUS")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Integer status;

    /**
     * 处理人
     */
    @Column(name = "DEAL_NAME")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String dealName;

    /**
     * 指令状态<>BEFOR=分发前&AFTER=分发后
     */
    @Column(name = "INST_STATUS")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String instStatus;

    @Column(name = "SYSTEM_TIME")
    @ColumnType(jdbcType = JdbcType.TIMESTAMP)
    private Date systemTime;

    /**
     * 是否发送km<>notsend=0=未发送&send=1=已发送
     */
    @Column(name = "SEND_STATUS")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Integer sendStatus;

    /**
     * 发送人
     */
    @Column(name = "SEND_NAME")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String sendName;

    /**
     * 发送时间
     */
    @Column(name = "SEND_TIME")
    @ColumnType(jdbcType = JdbcType.TIMESTAMP)
    private Date sendTime;

    /**
     * 错误日志的堆栈信息
     */
    @Column(name = "ERROR_MESSAGE")
    @ColumnType(jdbcType = JdbcType.CLOB)
    private String errorMessage;

    public static final String TABLE = "RULE_RESULT";

    public static final String f_ruleResultId = "ruleResultId";

    public static final String f_ruleId = "ruleId";

    public static final String f_resultStatus = "resultStatus";

    public static final String f_instId = "instId";

    public static final String f_checkTime = "checkTime";

    public static final String f_dealTime = "dealTime";

    public static final String f_status = "status";

    public static final String f_dealName = "dealName";

    public static final String f_instStatus = "instStatus";

    public static final String f_systemTime = "systemTime";

    public static final String f_sendStatus = "sendStatus";

    public static final String f_sendName = "sendName";

    public static final String f_sendTime = "sendTime";

    public static final String f_errorMessage = "errorMessage";

    /**
     * 异常
     */
    public static final Integer c_resultStatus_error = -1;

    /**
     * 不检查
     */
    public static final Integer c_resultStatus_noneedCheck = 0;

    /**
     * 通过
     */
    public static final Integer c_resultStatus_pass = 1;

    /**
     * 告警
     */
    public static final Integer c_resultStatus_notPass = 2;

    /**
     * 未处理
     */
    public static final Integer c_status_noHandle = 0;

    /**
     * 处理
     */
    public static final Integer c_status_handle = 1;

    /**
     * 挂起
     */
    public static final Integer c_status_hang = 2;

    /**
     * 未发送
     */
    public static final Integer c_sendStatus_notsend = 0;

    /**
     * 已发送
     */
    public static final Integer c_sendStatus_send = 1;

    /**
     * 获取处理结果id
     *
     * @return RULE_RESULT_ID - 处理结果id
     */
    public Long getRuleResultId() {
        return ruleResultId;
    }

    /**
     * 设置处理结果id
     *
     * @param ruleResultId 处理结果id
     */
    public void setRuleResultId(Long ruleResultId) {
        this.ruleResultId = ruleResultId;
    }

    /**
     * 获取规则id
     *
     * @return RULE_ID - 规则id
     */
    public String getRuleId() {
        return ruleId;
    }

    /**
     * 设置规则id
     *
     * @param ruleId 规则id
     */
    public void setRuleId(String ruleId) {
        this.ruleId = ruleId == null ? null : ruleId.trim();
    }

    /**
     * 获取告警状态<>error=-1=异常&noneedCheck=0=不检查&pass=1=通过&notPass=2=告警
     *
     * @return RESULT_STATUS - 告警状态<>error=-1=异常&noneedCheck=0=不检查&pass=1=通过&notPass=2=告警
     */
    public Integer getResultStatus() {
        return resultStatus;
    }

    /**
     * 设置告警状态<>error=-1=异常&noneedCheck=0=不检查&pass=1=通过&notPass=2=告警
     *
     * @param resultStatus 告警状态<>error=-1=异常&noneedCheck=0=不检查&pass=1=通过&notPass=2=告警
     */
    public void setResultStatus(Integer resultStatus) {
        this.resultStatus = resultStatus;
    }

    /**
     * @return INST_ID
     */
    public String getInstId() {
        return instId;
    }

    /**
     * @param instId
     */
    public void setInstId(String instId) {
        this.instId = instId == null ? null : instId.trim();
    }

    /**
     * 获取触发时间
     *
     * @return CHECK_TIME - 触发时间
     */
    public Date getCheckTime() {
        return checkTime;
    }

    /**
     * 设置触发时间
     *
     * @param checkTime 触发时间
     */
    public void setCheckTime(Date checkTime) {
        this.checkTime = checkTime;
    }

    /**
     * 获取处理时间
     *
     * @return DEAL_TIME - 处理时间
     */
    public Date getDealTime() {
        return dealTime;
    }

    /**
     * 设置处理时间
     *
     * @param dealTime 处理时间
     */
    public void setDealTime(Date dealTime) {
        this.dealTime = dealTime;
    }

    /**
     * 获取状态<>noHandle=0=未处理&handle=1=处理&hang=2=挂起
     *
     * @return STATUS - 状态<>noHandle=0=未处理&handle=1=处理&hang=2=挂起
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置状态<>noHandle=0=未处理&handle=1=处理&hang=2=挂起
     *
     * @param status 状态<>noHandle=0=未处理&handle=1=处理&hang=2=挂起
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取处理人
     *
     * @return DEAL_NAME - 处理人
     */
    public String getDealName() {
        return dealName;
    }

    /**
     * 设置处理人
     *
     * @param dealName 处理人
     */
    public void setDealName(String dealName) {
        this.dealName = dealName == null ? null : dealName.trim();
    }

    /**
     * 获取指令状态<>BEFOR=分发前&AFTER=分发后
     *
     * @return INST_STATUS - 指令状态<>BEFOR=分发前&AFTER=分发后
     */
    public String getInstStatus() {
        return instStatus;
    }

    /**
     * 设置指令状态<>BEFOR=分发前&AFTER=分发后
     *
     * @param instStatus 指令状态<>BEFOR=分发前&AFTER=分发后
     */
    public void setInstStatus(String instStatus) {
        this.instStatus = instStatus == null ? null : instStatus.trim();
    }

    /**
     * @return SYSTEM_TIME
     */
    public Date getSystemTime() {
        return systemTime;
    }

    /**
     * @param systemTime
     */
    public void setSystemTime(Date systemTime) {
        this.systemTime = systemTime;
    }

    /**
     * 获取是否发送km<>notsend=0=未发送&send=1=已发送
     *
     * @return SEND_STATUS - 是否发送km<>notsend=0=未发送&send=1=已发送
     */
    public Integer getSendStatus() {
        return sendStatus;
    }

    /**
     * 设置是否发送km<>notsend=0=未发送&send=1=已发送
     *
     * @param sendStatus 是否发送km<>notsend=0=未发送&send=1=已发送
     */
    public void setSendStatus(Integer sendStatus) {
        this.sendStatus = sendStatus;
    }

    /**
     * 获取发送人
     *
     * @return SEND_NAME - 发送人
     */
    public String getSendName() {
        return sendName;
    }

    /**
     * 设置发送人
     *
     * @param sendName 发送人
     */
    public void setSendName(String sendName) {
        this.sendName = sendName == null ? null : sendName.trim();
    }

    /**
     * 获取发送时间
     *
     * @return SEND_TIME - 发送时间
     */
    public Date getSendTime() {
        return sendTime;
    }

    /**
     * 设置发送时间
     *
     * @param sendTime 发送时间
     */
    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    /**
     * 获取错误日志的堆栈信息
     *
     * @return ERROR_MESSAGE - 错误日志的堆栈信息
     */
    public String getErrorMessage() {
        return errorMessage;
    }

    /**
     * 设置错误日志的堆栈信息
     *
     * @param errorMessage 错误日志的堆栈信息
     */
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage == null ? null : errorMessage.trim();
    }
}