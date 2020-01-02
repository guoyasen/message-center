package com.iquantex.tspweb.model;

import java.util.Date;
import javax.persistence.*;
import org.apache.ibatis.type.JdbcType;
import tk.mybatis.mapper.annotation.ColumnType;

@Table(name = "ETF_PATCH_NUM")
public class EtfPatchNum {
    @Column(name = "FUNDCODE")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String fundcode;

    @Column(name = "SYSTEM_TIME")
    @ColumnType(jdbcType = JdbcType.TIMESTAMP)
    private Date systemTime;

    @Column(name = "NEEDPATCHQTY")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String needpatchqty;

    @Column(name = "COMPLETEPATCHQTY")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String completepatchqty;

    @Column(name = "DIFFERENCE")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String difference;

    public static final String TABLE = "ETF_PATCH_NUM";

    public static final String f_fundcode = "fundcode";

    public static final String f_systemTime = "systemTime";

    public static final String f_needpatchqty = "needpatchqty";

    public static final String f_completepatchqty = "completepatchqty";

    public static final String f_difference = "difference";

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
     * @return NEEDPATCHQTY
     */
    public String getNeedpatchqty() {
        return needpatchqty;
    }

    /**
     * @param needpatchqty
     */
    public void setNeedpatchqty(String needpatchqty) {
        this.needpatchqty = needpatchqty == null ? null : needpatchqty.trim();
    }

    /**
     * @return COMPLETEPATCHQTY
     */
    public String getCompletepatchqty() {
        return completepatchqty;
    }

    /**
     * @param completepatchqty
     */
    public void setCompletepatchqty(String completepatchqty) {
        this.completepatchqty = completepatchqty == null ? null : completepatchqty.trim();
    }

    /**
     * @return DIFFERENCE
     */
    public String getDifference() {
        return difference;
    }

    /**
     * @param difference
     */
    public void setDifference(String difference) {
        this.difference = difference == null ? null : difference.trim();
    }
}