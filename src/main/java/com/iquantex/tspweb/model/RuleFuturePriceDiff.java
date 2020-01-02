package com.iquantex.tspweb.model;

import javax.persistence.*;
import org.apache.ibatis.type.JdbcType;
import tk.mybatis.mapper.annotation.ColumnType;

@Table(name = "RULE_FUTURE_PRICE_DIFF")
public class RuleFuturePriceDiff {
    /**
     * 用户id
     */
    @Column(name = "USER_ID")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String userId;

    /**
     * 期货a代码
     */
    @Column(name = "FUTUREA_CODE")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String futureaCode;

    /**
     * 期货b代码
     */
    @Column(name = "FUTUREB_CODE")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String futurebCode;

    /**
     * 价差
     */
    @Column(name = "PRICE_DIFF")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Double priceDiff;

    public static final String TABLE = "RULE_FUTURE_PRICE_DIFF";

    public static final String f_userId = "userId";

    public static final String f_futureaCode = "futureaCode";

    public static final String f_futurebCode = "futurebCode";

    public static final String f_priceDiff = "priceDiff";

    /**
     * 获取用户id
     *
     * @return USER_ID - 用户id
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置用户id
     *
     * @param userId 用户id
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * 获取期货a代码
     *
     * @return FUTUREA_CODE - 期货a代码
     */
    public String getFutureaCode() {
        return futureaCode;
    }

    /**
     * 设置期货a代码
     *
     * @param futureaCode 期货a代码
     */
    public void setFutureaCode(String futureaCode) {
        this.futureaCode = futureaCode == null ? null : futureaCode.trim();
    }

    /**
     * 获取期货b代码
     *
     * @return FUTUREB_CODE - 期货b代码
     */
    public String getFuturebCode() {
        return futurebCode;
    }

    /**
     * 设置期货b代码
     *
     * @param futurebCode 期货b代码
     */
    public void setFuturebCode(String futurebCode) {
        this.futurebCode = futurebCode == null ? null : futurebCode.trim();
    }

    /**
     * 获取价差
     *
     * @return PRICE_DIFF - 价差
     */
    public Double getPriceDiff() {
        return priceDiff;
    }

    /**
     * 设置价差
     *
     * @param priceDiff 价差
     */
    public void setPriceDiff(Double priceDiff) {
        this.priceDiff = priceDiff;
    }
}