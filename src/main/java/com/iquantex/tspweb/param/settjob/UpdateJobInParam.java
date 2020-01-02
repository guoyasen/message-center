package com.iquantex.tspweb.param.settjob;


/**
 * 修改工作
 */
public class UpdateJobInParam {
    /**
     * 工作流程Id
     */
    private Integer jobId;
    /**
     * 是否执行
     */
    private Integer ifRunning;
    /**
     * 状态
     */
    private Integer status;

    /**
     * 获取工作流程Id
     */
    public Integer getJobId() {
        return this.jobId;
    }

    /**
     * 设置工作流程Id
     */
    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }

    /**
     * 获取是否执行
     */
    public Integer getIfRunning() {
        return this.ifRunning;
    }

    /**
     * 设置是否执行
     */
    public void setIfRunning(Integer ifRunning) {
        this.ifRunning = ifRunning;
    }

    /**
     * 获取状态
     */
    public Integer getStatus() {
        return this.status;
    }

    /**
     * 设置状态
     */
    public void setStatus(Integer status) {
        this.status = status;
    }
}