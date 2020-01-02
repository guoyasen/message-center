package com.iquantex.tspweb.model;

import javax.persistence.*;
import org.apache.ibatis.type.JdbcType;
import tk.mybatis.mapper.annotation.ColumnType;

@Table(name = "RULE_TYPE_MARKET_MAPPING")
public class RuleTypeMarketMapping {
    /**
     * 市场ID
     */
    @Column(name = "TYPE_ID")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String typeId;

    /**
     * 市场名称
     */
    @Column(name = "MARKET_NAME")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String marketName;

    /**
     * 市场编码
     */
    @Column(name = "MARKET_CODE")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String marketCode;

    public static final String TABLE = "RULE_TYPE_MARKET_MAPPING";

    public static final String f_typeId = "typeId";

    public static final String f_marketName = "marketName";

    public static final String f_marketCode = "marketCode";

    /**
     * 获取市场ID
     *
     * @return TYPE_ID - 市场ID
     */
    public String getTypeId() {
        return typeId;
    }

    /**
     * 设置市场ID
     *
     * @param typeId 市场ID
     */
    public void setTypeId(String typeId) {
        this.typeId = typeId == null ? null : typeId.trim();
    }

    /**
     * 获取市场名称
     *
     * @return MARKET_NAME - 市场名称
     */
    public String getMarketName() {
        return marketName;
    }

    /**
     * 设置市场名称
     *
     * @param marketName 市场名称
     */
    public void setMarketName(String marketName) {
        this.marketName = marketName == null ? null : marketName.trim();
    }

    /**
     * 获取市场编码
     *
     * @return MARKET_CODE - 市场编码
     */
    public String getMarketCode() {
        return marketCode;
    }

    /**
     * 设置市场编码
     *
     * @param marketCode 市场编码
     */
    public void setMarketCode(String marketCode) {
        this.marketCode = marketCode == null ? null : marketCode.trim();
    }
}