package com.iquantex.tspweb.model;

import org.apache.ibatis.type.JdbcType;
import tk.mybatis.mapper.annotation.ColumnType;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "RPSTOR_SETT_TASK")
public class RpstorSettTask {
    /**
     * job序号
     */
    @Id
    @Column(name = "JOB_ID")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Integer jobId;

    /**
     * task序号
     */
    @Id
    @Column(name = "TASK_ID")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Integer taskId;

    /**
     * task名称
     */
    @Column(name = "TASK_NAME")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String taskName;

    /**
     * task状态<>unstart=0=未开始&running=1=进行中&error=2=异常中&done=3=已完成&finish_stop=4=完成终止中
     */
    @Column(name = "STATUS")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Integer status;

    public static final String TABLE = "RPSTOR_SETT_TASK";

    public static final String f_jobId = "jobId";

    public static final String f_taskId = "taskId";

    public static final String f_taskName = "taskName";

    public static final String f_status = "status";

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
     * 完成终止中
     */
    public static final Integer c_status_finish_stop = 4;

    /**
     * 获取job序号
     *
     * @return JOB_ID - job序号
     */
    public Integer getJobId() {
        return jobId;
    }

    /**
     * 设置job序号
     *
     * @param jobId job序号
     */
    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }

    /**
     * 获取task序号
     *
     * @return TASK_ID - task序号
     */
    public Integer getTaskId() {
        return taskId;
    }

    /**
     * 设置task序号
     *
     * @param taskId task序号
     */
    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    /**
     * 获取task名称
     *
     * @return TASK_NAME - task名称
     */
    public String getTaskName() {
        return taskName;
    }

    /**
     * 设置task名称
     *
     * @param taskName task名称
     */
    public void setTaskName(String taskName) {
        this.taskName = taskName == null ? null : taskName.trim();
    }

    /**
     * 获取task状态<>unstart=0=未开始&running=1=进行中&error=2=异常中&done=3=已完成&finish_stop=4=完成终止中
     *
     * @return STATUS - task状态<>unstart=0=未开始&running=1=进行中&error=2=异常中&done=3=已完成&finish_stop=4=完成终止中
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置task状态<>unstart=0=未开始&running=1=进行中&error=2=异常中&done=3=已完成&finish_stop=4=完成终止中
     *
     * @param status task状态<>unstart=0=未开始&running=1=进行中&error=2=异常中&done=3=已完成&finish_stop=4=完成终止中
     */
    public void setStatus(Integer status) {
        this.status = status;
    }
}