package com.iquantex.tspweb.model;

import org.apache.ibatis.type.JdbcType;
import tk.mybatis.mapper.annotation.ColumnType;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "RPSTOR_SETT_JOB")
public class RpstorSettJob {
    /**
     * job序号
     */
    @Id
    @Column(name = "JOB_ID")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Integer jobId;

    /**
     * job名称
     */
    @Column(name = "JOB_NAME")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String jobName;

    /**
     * job状态<>unstart=0=未开始&running=1=进行中&error=2=异常中&done=3=已完成&warning=4=警告&finish_stop=5=完成终止中
     */
    @Column(name = "STATUS")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Integer status;

    /**
     * 上一级工作ID
     */
    @Column(name = "PRE_JOB_ID")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String preJobId;

    /**
     * 是否需要执行<>no=0=不可执行&yes=1=可执行
     */
    @Column(name = "IF_RUNNING")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Integer ifRunning;

    /**
     * 是否为流程导图节点<>no=0=否&yes=1=是
     */
    @Column(name = "IS_PROCESS_JOB")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Integer isProcessJob;

    /**
     * 是否退出系统<>no=0=不退出系统&yes=1=退出系统
     */
    @Column(name = "IF_EXIT_SYSTEM")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Integer ifExitSystem;

    /**
     * 日期来源<>sys=0=系统日期&oe=1=场内&ib=2=银行间&otc=3=场外
     */
    @Column(name = "DATE_SOURCE")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Integer dateSource;

    public static final String TABLE = "RPSTOR_SETT_JOB";

    public static final String f_jobId = "jobId";

    public static final String f_jobName = "jobName";

    public static final String f_status = "status";

    public static final String f_preJobId = "preJobId";

    public static final String f_ifRunning = "ifRunning";

    public static final String f_isProcessJob = "isProcessJob";

    public static final String f_ifExitSystem = "ifExitSystem";

    public static final String f_dateSource = "dateSource";

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
     * 警告
     */
    public static final Integer c_status_warning = 4;

    /**
     * 完成终止中
     */
    public static final Integer c_status_finish_stop = 5;

    /**
     * 不可执行
     */
    public static final Integer c_ifRunning_no = 0;

    /**
     * 可执行
     */
    public static final Integer c_ifRunning_yes = 1;

    /**
     * 否
     */
    public static final Integer c_isProcessJob_no = 0;

    /**
     * 是
     */
    public static final Integer c_isProcessJob_yes = 1;

    /**
     * 不退出系统
     */
    public static final Integer c_ifExitSystem_no = 0;

    /**
     * 退出系统
     */
    public static final Integer c_ifExitSystem_yes = 1;

    /**
     * 系统日期
     */
    public static final Integer c_dateSource_sys = 0;

    /**
     * 场内
     */
    public static final Integer c_dateSource_oe = 1;

    /**
     * 银行间
     */
    public static final Integer c_dateSource_ib = 2;

    /**
     * 场外
     */
    public static final Integer c_dateSource_otc = 3;

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
     * 获取job名称
     *
     * @return JOB_NAME - job名称
     */
    public String getJobName() {
        return jobName;
    }

    /**
     * 设置job名称
     *
     * @param jobName job名称
     */
    public void setJobName(String jobName) {
        this.jobName = jobName == null ? null : jobName.trim();
    }

    /**
     * 获取job状态<>unstart=0=未开始&running=1=进行中&error=2=异常中&done=3=已完成&warning=4=警告&finish_stop=5=完成终止中
     *
     * @return STATUS - job状态<>unstart=0=未开始&running=1=进行中&error=2=异常中&done=3=已完成&warning=4=警告&finish_stop=5=完成终止中
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置job状态<>unstart=0=未开始&running=1=进行中&error=2=异常中&done=3=已完成&warning=4=警告&finish_stop=5=完成终止中
     *
     * @param status job状态<>unstart=0=未开始&running=1=进行中&error=2=异常中&done=3=已完成&warning=4=警告&finish_stop=5=完成终止中
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取上一级工作ID
     *
     * @return PRE_JOB_ID - 上一级工作ID
     */
    public String getPreJobId() {
        return preJobId;
    }

    /**
     * 设置上一级工作ID
     *
     * @param preJobId 上一级工作ID
     */
    public void setPreJobId(String preJobId) {
        this.preJobId = preJobId == null ? null : preJobId.trim();
    }

    /**
     * 获取是否需要执行<>no=0=不可执行&yes=1=可执行
     *
     * @return IF_RUNNING - 是否需要执行<>no=0=不可执行&yes=1=可执行
     */
    public Integer getIfRunning() {
        return ifRunning;
    }

    /**
     * 设置是否需要执行<>no=0=不可执行&yes=1=可执行
     *
     * @param ifRunning 是否需要执行<>no=0=不可执行&yes=1=可执行
     */
    public void setIfRunning(Integer ifRunning) {
        this.ifRunning = ifRunning;
    }

    /**
     * 获取是否为流程导图节点<>no=0=否&yes=1=是
     *
     * @return IS_PROCESS_JOB - 是否为流程导图节点<>no=0=否&yes=1=是
     */
    public Integer getIsProcessJob() {
        return isProcessJob;
    }

    /**
     * 设置是否为流程导图节点<>no=0=否&yes=1=是
     *
     * @param isProcessJob 是否为流程导图节点<>no=0=否&yes=1=是
     */
    public void setIsProcessJob(Integer isProcessJob) {
        this.isProcessJob = isProcessJob;
    }

    /**
     * 获取是否退出系统<>no=0=不退出系统&yes=1=退出系统
     *
     * @return IF_EXIT_SYSTEM - 是否退出系统<>no=0=不退出系统&yes=1=退出系统
     */
    public Integer getIfExitSystem() {
        return ifExitSystem;
    }

    /**
     * 设置是否退出系统<>no=0=不退出系统&yes=1=退出系统
     *
     * @param ifExitSystem 是否退出系统<>no=0=不退出系统&yes=1=退出系统
     */
    public void setIfExitSystem(Integer ifExitSystem) {
        this.ifExitSystem = ifExitSystem;
    }

    /**
     * 获取日期来源<>sys=0=系统日期&oe=1=场内&ib=2=银行间&otc=3=场外
     *
     * @return DATE_SOURCE - 日期来源<>sys=0=系统日期&oe=1=场内&ib=2=银行间&otc=3=场外
     */
    public Integer getDateSource() {
        return dateSource;
    }

    /**
     * 设置日期来源<>sys=0=系统日期&oe=1=场内&ib=2=银行间&otc=3=场外
     *
     * @param dateSource 日期来源<>sys=0=系统日期&oe=1=场内&ib=2=银行间&otc=3=场外
     */
    public void setDateSource(Integer dateSource) {
        this.dateSource = dateSource;
    }
}