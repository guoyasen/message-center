package com.iquantex.tspweb.model;

import org.apache.ibatis.type.JdbcType;
import tk.mybatis.mapper.annotation.ColumnType;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "RPSTOR_SETT_CHILDTASK")
public class RpstorSettChildtask {
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
     * childtask序号
     */
    @Id
    @Column(name = "CHILDTASK_ID")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Integer childtaskId;

    /**
     * childtask名称
     */
    @Column(name = "CHILDTASK_NAME")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String childtaskName;

    /**
     * childtask状态<>unstart=0=未开始&running=1=进行中&error=2=异常中&done=3=已完成&warning=4=警告&finish_stop=5=完成终止中
     */
    @Column(name = "STATUS")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Integer status;

    /**
     * Class对象
     */
    @Column(name = "CHILDTASK_CLS")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String childtaskCls;

    /**
     * 是否执行<>off=0=关闭&on=1=打开
     */
    @Column(name = "IF_RUNING")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Integer ifRuning;

    /**
     * childtask状态<>unstart=0=未开始&running=1=进行中&error=2=异常中&done=3=已完成&warning=4=警告&finish_stop=5=完成终止中
     */
    @Column(name = "LAST_STATUS")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Integer lastStatus;

    /**
     * 上一次操作时间
     */
    @Column(name = "LAST_TIME")
    @ColumnType(jdbcType = JdbcType.TIMESTAMP)
    private Date lastTime;

    /**
     * 是否可跳过<>no=0=不可跳过&yes=1=可跳过
     */
    @Column(name = "IF_SKIP")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Integer ifSkip;

    /**
     * 是否可重复<>no=0=不可重复执行&yes=1=可重复执行
     */
    @Column(name = "IF_REPEAT")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Integer ifRepeat;

    /**
     * ??????????????????<>no=0=??????&yes=1=????????
     */
    @Column(name = "EXCEPT_SKIP")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Integer exceptSkip;

    /**
     * 是否完成终止<>no=0=完成不终止&yes=1=完成终止
     */
    @Column(name = "FINISH_STOP")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Integer finishStop;

    public static final String TABLE = "RPSTOR_SETT_CHILDTASK";

    public static final String f_jobId = "jobId";

    public static final String f_taskId = "taskId";

    public static final String f_childtaskId = "childtaskId";

    public static final String f_childtaskName = "childtaskName";

    public static final String f_status = "status";

    public static final String f_childtaskCls = "childtaskCls";

    public static final String f_ifRuning = "ifRuning";

    public static final String f_lastStatus = "lastStatus";

    public static final String f_lastTime = "lastTime";

    public static final String f_ifSkip = "ifSkip";

    public static final String f_ifRepeat = "ifRepeat";

    public static final String f_exceptSkip = "exceptSkip";

    public static final String f_finishStop = "finishStop";

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
     * 关闭
     */
    public static final Integer c_ifRuning_off = 0;

    /**
     * 打开
     */
    public static final Integer c_ifRuning_on = 1;

    /**
     * 未开始
     */
    public static final Integer c_lastStatus_unstart = 0;

    /**
     * 进行中
     */
    public static final Integer c_lastStatus_running = 1;

    /**
     * 异常中
     */
    public static final Integer c_lastStatus_error = 2;

    /**
     * 已完成
     */
    public static final Integer c_lastStatus_done = 3;

    /**
     * 警告
     */
    public static final Integer c_lastStatus_warning = 4;

    /**
     * 完成终止中
     */
    public static final Integer c_lastStatus_finish_stop = 5;

    /**
     * 不可跳过
     */
    public static final Integer c_ifSkip_no = 0;

    /**
     * 可跳过
     */
    public static final Integer c_ifSkip_yes = 1;

    /**
     * 不可重复执行
     */
    public static final Integer c_ifRepeat_no = 0;

    /**
     * 可重复执行
     */
    public static final Integer c_ifRepeat_yes = 1;

    /**
     * ??????
     */
    public static final Integer c_exceptSkip_no = 0;

    /**
     * ????????
     */
    public static final Integer c_exceptSkip_yes = 1;

    /**
     * 完成不终止
     */
    public static final Integer c_finishStop_no = 0;

    /**
     * 完成终止
     */
    public static final Integer c_finishStop_yes = 1;

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
     * 获取childtask序号
     *
     * @return CHILDTASK_ID - childtask序号
     */
    public Integer getChildtaskId() {
        return childtaskId;
    }

    /**
     * 设置childtask序号
     *
     * @param childtaskId childtask序号
     */
    public void setChildtaskId(Integer childtaskId) {
        this.childtaskId = childtaskId;
    }

    /**
     * 获取childtask名称
     *
     * @return CHILDTASK_NAME - childtask名称
     */
    public String getChildtaskName() {
        return childtaskName;
    }

    /**
     * 设置childtask名称
     *
     * @param childtaskName childtask名称
     */
    public void setChildtaskName(String childtaskName) {
        this.childtaskName = childtaskName == null ? null : childtaskName.trim();
    }

    /**
     * 获取childtask状态<>unstart=0=未开始&running=1=进行中&error=2=异常中&done=3=已完成&warning=4=警告&finish_stop=5=完成终止中
     *
     * @return STATUS - childtask状态<>unstart=0=未开始&running=1=进行中&error=2=异常中&done=3=已完成&warning=4=警告&finish_stop=5=完成终止中
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置childtask状态<>unstart=0=未开始&running=1=进行中&error=2=异常中&done=3=已完成&warning=4=警告&finish_stop=5=完成终止中
     *
     * @param status childtask状态<>unstart=0=未开始&running=1=进行中&error=2=异常中&done=3=已完成&warning=4=警告&finish_stop=5=完成终止中
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取Class对象
     *
     * @return CHILDTASK_CLS - Class对象
     */
    public String getChildtaskCls() {
        return childtaskCls;
    }

    /**
     * 设置Class对象
     *
     * @param childtaskCls Class对象
     */
    public void setChildtaskCls(String childtaskCls) {
        this.childtaskCls = childtaskCls == null ? null : childtaskCls.trim();
    }

    /**
     * 获取是否执行<>off=0=关闭&on=1=打开
     *
     * @return IF_RUNING - 是否执行<>off=0=关闭&on=1=打开
     */
    public Integer getIfRuning() {
        return ifRuning;
    }

    /**
     * 设置是否执行<>off=0=关闭&on=1=打开
     *
     * @param ifRuning 是否执行<>off=0=关闭&on=1=打开
     */
    public void setIfRuning(Integer ifRuning) {
        this.ifRuning = ifRuning;
    }

    /**
     * 获取childtask状态<>unstart=0=未开始&running=1=进行中&error=2=异常中&done=3=已完成&warning=4=警告&finish_stop=5=完成终止中
     *
     * @return LAST_STATUS - childtask状态<>unstart=0=未开始&running=1=进行中&error=2=异常中&done=3=已完成&warning=4=警告&finish_stop=5=完成终止中
     */
    public Integer getLastStatus() {
        return lastStatus;
    }

    /**
     * 设置childtask状态<>unstart=0=未开始&running=1=进行中&error=2=异常中&done=3=已完成&warning=4=警告&finish_stop=5=完成终止中
     *
     * @param lastStatus childtask状态<>unstart=0=未开始&running=1=进行中&error=2=异常中&done=3=已完成&warning=4=警告&finish_stop=5=完成终止中
     */
    public void setLastStatus(Integer lastStatus) {
        this.lastStatus = lastStatus;
    }

    /**
     * 获取上一次操作时间
     *
     * @return LAST_TIME - 上一次操作时间
     */
    public Date getLastTime() {
        return lastTime;
    }

    /**
     * 设置上一次操作时间
     *
     * @param lastTime 上一次操作时间
     */
    public void setLastTime(Date lastTime) {
        this.lastTime = lastTime;
    }

    /**
     * 获取是否可跳过<>no=0=不可跳过&yes=1=可跳过
     *
     * @return IF_SKIP - 是否可跳过<>no=0=不可跳过&yes=1=可跳过
     */
    public Integer getIfSkip() {
        return ifSkip;
    }

    /**
     * 设置是否可跳过<>no=0=不可跳过&yes=1=可跳过
     *
     * @param ifSkip 是否可跳过<>no=0=不可跳过&yes=1=可跳过
     */
    public void setIfSkip(Integer ifSkip) {
        this.ifSkip = ifSkip;
    }

    /**
     * 获取是否可重复<>no=0=不可重复执行&yes=1=可重复执行
     *
     * @return IF_REPEAT - 是否可重复<>no=0=不可重复执行&yes=1=可重复执行
     */
    public Integer getIfRepeat() {
        return ifRepeat;
    }

    /**
     * 设置是否可重复<>no=0=不可重复执行&yes=1=可重复执行
     *
     * @param ifRepeat 是否可重复<>no=0=不可重复执行&yes=1=可重复执行
     */
    public void setIfRepeat(Integer ifRepeat) {
        this.ifRepeat = ifRepeat;
    }

    /**
     * 获取??????????????????<>no=0=??????&yes=1=????????
     *
     * @return EXCEPT_SKIP - ??????????????????<>no=0=??????&yes=1=????????
     */
    public Integer getExceptSkip() {
        return exceptSkip;
    }

    /**
     * 设置??????????????????<>no=0=??????&yes=1=????????
     *
     * @param exceptSkip ??????????????????<>no=0=??????&yes=1=????????
     */
    public void setExceptSkip(Integer exceptSkip) {
        this.exceptSkip = exceptSkip;
    }

    /**
     * 获取是否完成终止<>no=0=完成不终止&yes=1=完成终止
     *
     * @return FINISH_STOP - 是否完成终止<>no=0=完成不终止&yes=1=完成终止
     */
    public Integer getFinishStop() {
        return finishStop;
    }

    /**
     * 设置是否完成终止<>no=0=完成不终止&yes=1=完成终止
     *
     * @param finishStop 是否完成终止<>no=0=完成不终止&yes=1=完成终止
     */
    public void setFinishStop(Integer finishStop) {
        this.finishStop = finishStop;
    }
}