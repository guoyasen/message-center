package com.iquantex.tspweb.param.settjob;


import java.util.Date;

/**
 *
 */
public class JobTree {
    /**
     * 未开始
     */
    public static final Integer c_status_unstart = 0;
    /**
     * 进行中
     */
    public static final Integer c_status_running = 1;
    /**
     * 异常中
     */
    public static final Integer c_status_error = 2;
    /**
     * 已完成
     */
    public static final Integer c_status_done = 3;
    /**
     * id
     */
    private String id;
    /**
     * 父id
     */
    private String pId;
    /**
     * 工作id
     */
    private Integer jobId;
    /**
     * 任务id
     */
    private Integer taskId;
    /**
     * 子任务id
     */
    private Integer childTaskId;
    /**
     * 任务名称
     */
    private String name;
    /**
     * 状态<>unstart=0=未开始&running=1=进行中&error=2=异常中&done=3=已完成
     */
    private Integer status;
    /**
     * 状态<>unstart=0=未开始&running=1=进行中&error=2=异常中&done=3=已完成
     */
    private Integer lastStatus;
    private Date lastTime;
    /**
     * 是否可以重做
     */
    private Integer ifRepeat;
    /**
     * 是否可以跳过
     */
    private Integer ifSkip;

    /**
     * 获取id
     */
    public String getId() {
        return this.id;
    }

    /**
     * 设置id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取父id
     */
    public String getpId() {
        return this.pId;
    }

    /**
     * 设置父id
     */
    public void setpId(String pId) {
        this.pId = pId;
    }

    /**
     * 获取工作id
     */
    public Integer getJobId() {
        return this.jobId;
    }

    /**
     * 设置工作id
     */
    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }

    /**
     * 获取任务id
     */
    public Integer getTaskId() {
        return this.taskId;
    }

    /**
     * 设置任务id
     */
    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    /**
     * 获取子任务id
     */
    public Integer getChildTaskId() {
        return this.childTaskId;
    }

    /**
     * 设置子任务id
     */
    public void setChildTaskId(Integer childTaskId) {
        this.childTaskId = childTaskId;
    }

    /**
     * 获取任务名称
     */
    public String getName() {
        return this.name;
    }

    /**
     * 设置任务名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取状态<>unstart=0=未开始&running=1=进行中&error=2=异常中&done=3=已完成
     */
    public Integer getStatus() {
        return this.status;
    }

    /**
     * 设置状态<>unstart=0=未开始&running=1=进行中&error=2=异常中&done=3=已完成
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getLastStatus() {
        return lastStatus;
    }

    public void setLastStatus(Integer lastStatus) {
        this.lastStatus = lastStatus;
    }

    public Date getLastTime() {
        return lastTime;
    }

    public void setLastTime(Date lastTime) {
        this.lastTime = lastTime;
    }

    public Integer getIfRepeat() {
        return ifRepeat;
    }

    public void setIfRepeat(Integer ifRepeat) {
        this.ifRepeat = ifRepeat;
    }

    public Integer getIfSkip() {
        return ifSkip;
    }

    public void setIfSkip(Integer ifSkip) {
        this.ifSkip = ifSkip;
    }
}