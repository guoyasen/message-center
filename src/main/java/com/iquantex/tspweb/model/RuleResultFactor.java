package com.iquantex.tspweb.model;

import java.util.Date;
import javax.persistence.*;
import org.apache.ibatis.type.JdbcType;
import tk.mybatis.mapper.annotation.ColumnType;

@Table(name = "RULE_RESULT_FACTOR")
public class RuleResultFactor {
    /**
     * 处理结果id
     */
    @Column(name = "RULE_RESULT_ID")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Long ruleResultId;

    /**
     * 因子key
     */
    @Column(name = "FACTOR_KEY")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String factorKey;

    /**
     * 因子value
     */
    @Column(name = "FACTOR_VALUE")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String factorValue;

    /**
     * 因子key+value
     */
    @Column(name = "FACTOR_KEY_VALUE")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String factorKeyValue;

    @Column(name = "SYSTEM_TIME")
    @ColumnType(jdbcType = JdbcType.TIMESTAMP)
    private Date systemTime;

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

    public static final String TABLE = "RULE_RESULT_FACTOR";

    public static final String f_ruleResultId = "ruleResultId";

    public static final String f_factorKey = "factorKey";

    public static final String f_factorValue = "factorValue";

    public static final String f_factorKeyValue = "factorKeyValue";

    public static final String f_systemTime = "systemTime";

    public static final String f_ruleId = "ruleId";

    public static final String f_resultStatus = "resultStatus";

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
     * 获取因子key
     *
     * @return FACTOR_KEY - 因子key
     */
    public String getFactorKey() {
        return factorKey;
    }

    /**
     * 设置因子key
     *
     * @param factorKey 因子key
     */
    public void setFactorKey(String factorKey) {
        this.factorKey = factorKey == null ? null : factorKey.trim();
    }

    /**
     * 获取因子value
     *
     * @return FACTOR_VALUE - 因子value
     */
    public String getFactorValue() {
        return factorValue;
    }

    /**
     * 设置因子value
     *
     * @param factorValue 因子value
     */
    public void setFactorValue(String factorValue) {
        this.factorValue = factorValue == null ? null : factorValue.trim();
    }

    /**
     * 获取因子key+value
     *
     * @return FACTOR_KEY_VALUE - 因子key+value
     */
    public String getFactorKeyValue() {
        return factorKeyValue;
    }

    /**
     * 设置因子key+value
     *
     * @param factorKeyValue 因子key+value
     */
    public void setFactorKeyValue(String factorKeyValue) {
        this.factorKeyValue = factorKeyValue == null ? null : factorKeyValue.trim();
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
}