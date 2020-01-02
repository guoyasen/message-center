package com.iquantex.tspweb.model;

import javax.persistence.*;
import org.apache.ibatis.type.JdbcType;
import tk.mybatis.mapper.annotation.ColumnType;

@Table(name = "SUB_RULE")
public class SubRule {
    /**
     * 细则ID
     */
    @Id
    @Column(name = "ID")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Integer id;

    /**
     * 规则ID
     */
    @Column(name = "RULE_ID")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String ruleId;

    /**
     * 细则类别<>CAL=0=计算类&RANGE=1=范围类
     */
    @Column(name = "TYPE")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Integer type;

    /**
     * 表达式
     */
    @Column(name = "EXPR")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String expr;

    /**
     * 阈值
     */
    @Column(name = "THRESHOLD")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Double threshold;

    /**
     * 细则描述
     */
    @Column(name = "DESCRIBE")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String describe;

    public static final String TABLE = "SUB_RULE";

    public static final String f_id = "id";

    public static final String f_ruleId = "ruleId";

    public static final String f_type = "type";

    public static final String f_expr = "expr";

    public static final String f_threshold = "threshold";

    public static final String f_describe = "describe";

    /**
     * 计算类
     */
    public static final Integer c_type_CAL = 0;

    /**
     * 范围类
     */
    public static final Integer c_type_RANGE = 1;

    /**
     * 获取细则ID
     *
     * @return ID - 细则ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置细则ID
     *
     * @param id 细则ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取规则ID
     *
     * @return RULE_ID - 规则ID
     */
    public String getRuleId() {
        return ruleId;
    }

    /**
     * 设置规则ID
     *
     * @param ruleId 规则ID
     */
    public void setRuleId(String ruleId) {
        this.ruleId = ruleId == null ? null : ruleId.trim();
    }

    /**
     * 获取细则类别<>CAL=0=计算类&RANGE=1=范围类
     *
     * @return TYPE - 细则类别<>CAL=0=计算类&RANGE=1=范围类
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置细则类别<>CAL=0=计算类&RANGE=1=范围类
     *
     * @param type 细则类别<>CAL=0=计算类&RANGE=1=范围类
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 获取表达式
     *
     * @return EXPR - 表达式
     */
    public String getExpr() {
        return expr;
    }

    /**
     * 设置表达式
     *
     * @param expr 表达式
     */
    public void setExpr(String expr) {
        this.expr = expr == null ? null : expr.trim();
    }

    /**
     * 获取阈值
     *
     * @return THRESHOLD - 阈值
     */
    public Double getThreshold() {
        return threshold;
    }

    /**
     * 设置阈值
     *
     * @param threshold 阈值
     */
    public void setThreshold(Double threshold) {
        this.threshold = threshold;
    }

    /**
     * 获取细则描述
     *
     * @return DESCRIBE - 细则描述
     */
    public String getDescribe() {
        return describe;
    }

    /**
     * 设置细则描述
     *
     * @param describe 细则描述
     */
    public void setDescribe(String describe) {
        this.describe = describe == null ? null : describe.trim();
    }
}