package com.iquantex.tspweb.model;

import java.util.Date;
import javax.persistence.*;
import org.apache.ibatis.type.JdbcType;
import tk.mybatis.mapper.annotation.ColumnType;

@Table(name = "ETF_RULE_RESULTS_NEWEST_VW")
public class EtfRuleResultsNewestVw {
    @Column(name = "RULE_ID")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String ruleId;

    @Column(name = "RULE_NAME")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String ruleName;

    @Column(name = "RULE_RESULT_ID")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Long ruleResultId;

    @Column(name = "FUND_CODE")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String fundCode;

    @Column(name = "CHECK_TIME")
    @ColumnType(jdbcType = JdbcType.TIMESTAMP)
    private Date checkTime;

    public static final String TABLE = "ETF_RULE_RESULTS_NEWEST_VW";

    public static final String f_ruleId = "ruleId";

    public static final String f_ruleName = "ruleName";

    public static final String f_ruleResultId = "ruleResultId";

    public static final String f_fundCode = "fundCode";

    public static final String f_checkTime = "checkTime";

    /**
     * @return RULE_ID
     */
    public String getRuleId() {
        return ruleId;
    }

    /**
     * @param ruleId
     */
    public void setRuleId(String ruleId) {
        this.ruleId = ruleId == null ? null : ruleId.trim();
    }

    /**
     * @return RULE_NAME
     */
    public String getRuleName() {
        return ruleName;
    }

    /**
     * @param ruleName
     */
    public void setRuleName(String ruleName) {
        this.ruleName = ruleName == null ? null : ruleName.trim();
    }

    /**
     * @return RULE_RESULT_ID
     */
    public Long getRuleResultId() {
        return ruleResultId;
    }

    /**
     * @param ruleResultId
     */
    public void setRuleResultId(Long ruleResultId) {
        this.ruleResultId = ruleResultId;
    }

    /**
     * @return FUND_CODE
     */
    public String getFundCode() {
        return fundCode;
    }

    /**
     * @param fundCode
     */
    public void setFundCode(String fundCode) {
        this.fundCode = fundCode == null ? null : fundCode.trim();
    }

    /**
     * @return CHECK_TIME
     */
    public Date getCheckTime() {
        return checkTime;
    }

    /**
     * @param checkTime
     */
    public void setCheckTime(Date checkTime) {
        this.checkTime = checkTime;
    }
}