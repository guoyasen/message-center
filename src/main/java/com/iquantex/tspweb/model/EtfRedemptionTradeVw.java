package com.iquantex.tspweb.model;

import javax.persistence.*;
import org.apache.ibatis.type.JdbcType;
import tk.mybatis.mapper.annotation.ColumnType;

@Table(name = "ETF_REDEMPTION_TRADE_VW")
public class EtfRedemptionTradeVw {
    @Column(name = "FUNDCODE")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String fundcode;

    @Column(name = "FUNDNAME")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String fundname;

    @Column(name = "REDEMPTIONBASKETS")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Double redemptionbaskets;

    @Column(name = "ISACTIVEPATCHCOMPLETED")
    @ColumnType(jdbcType = JdbcType.CHAR)
    private String isactivepatchcompleted;

    @Column(name = "MAINUNCOMPLETEDSTOCK")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String mainuncompletedstock;

    @Column(name = "UPDATETIME")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String updatetime;

    public static final String TABLE = "ETF_REDEMPTION_TRADE_VW";

    public static final String f_fundcode = "fundcode";

    public static final String f_fundname = "fundname";

    public static final String f_redemptionbaskets = "redemptionbaskets";

    public static final String f_isactivepatchcompleted = "isactivepatchcompleted";

    public static final String f_mainuncompletedstock = "mainuncompletedstock";

    public static final String f_updatetime = "updatetime";

    /**
     * @return FUNDCODE
     */
    public String getFundcode() {
        return fundcode;
    }

    /**
     * @param fundcode
     */
    public void setFundcode(String fundcode) {
        this.fundcode = fundcode == null ? null : fundcode.trim();
    }

    /**
     * @return FUNDNAME
     */
    public String getFundname() {
        return fundname;
    }

    /**
     * @param fundname
     */
    public void setFundname(String fundname) {
        this.fundname = fundname == null ? null : fundname.trim();
    }

    /**
     * @return REDEMPTIONBASKETS
     */
    public Double getRedemptionbaskets() {
        return redemptionbaskets;
    }

    /**
     * @param redemptionbaskets
     */
    public void setRedemptionbaskets(Double redemptionbaskets) {
        this.redemptionbaskets = redemptionbaskets;
    }

    /**
     * @return ISACTIVEPATCHCOMPLETED
     */
    public String getIsactivepatchcompleted() {
        return isactivepatchcompleted;
    }

    /**
     * @param isactivepatchcompleted
     */
    public void setIsactivepatchcompleted(String isactivepatchcompleted) {
        this.isactivepatchcompleted = isactivepatchcompleted == null ? null : isactivepatchcompleted.trim();
    }

    /**
     * @return MAINUNCOMPLETEDSTOCK
     */
    public String getMainuncompletedstock() {
        return mainuncompletedstock;
    }

    /**
     * @param mainuncompletedstock
     */
    public void setMainuncompletedstock(String mainuncompletedstock) {
        this.mainuncompletedstock = mainuncompletedstock == null ? null : mainuncompletedstock.trim();
    }

    /**
     * @return UPDATETIME
     */
    public String getUpdatetime() {
        return updatetime;
    }

    /**
     * @param updatetime
     */
    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime == null ? null : updatetime.trim();
    }
}