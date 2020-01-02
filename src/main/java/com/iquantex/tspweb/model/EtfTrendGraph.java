package com.iquantex.tspweb.model;

import javax.persistence.*;
import org.apache.ibatis.type.JdbcType;
import tk.mybatis.mapper.annotation.ColumnType;

@Table(name = "ETF_TREND_GRAPH")
public class EtfTrendGraph {
    @Column(name = "FUNDCODE")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String fundcode;

    @Column(name = "SYSTEM_TIME")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String systemTime;

    @Column(name = "IOPVCHG")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Double iopvchg;

    @Column(name = "INDEXCHG")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Double indexchg;

    @Column(name = "ETFDEVIATION")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
        private Double etfdeviation;

    @Column(name = "ETFLASTPRICE")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String etflastprice;

    @Column(name = "IOPV")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String iopv;

    @Column(name = "ETFPREMIUMDISCOUNT")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Double etfpremiumdiscount;

    public static final String TABLE = "ETF_TREND_GRAPH";

    public static final String f_fundcode = "fundcode";

    public static final String f_systemTime = "systemTime";

    public static final String f_iopvchg = "iopvchg";

    public static final String f_indexchg = "indexchg";

    public static final String f_etfdeviation = "etfdeviation";

    public static final String f_etflastprice = "etflastprice";

    public static final String f_iopv = "iopv";

    public static final String f_etfpremiumdiscount = "etfpremiumdiscount";

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
    public String getSystemTime() {
        return systemTime;
    }

    /**
     * @param systemTime
     */
    public void setSystemTime(String systemTime) {
        this.systemTime = systemTime == null ? null : systemTime.trim();
    }

    /**
     * @return IOPVCHG
     */
    public Double getIopvchg() {
        return iopvchg;
    }

    /**
     * @param iopvchg
     */
    public void setIopvchg(Double iopvchg) {
        this.iopvchg = iopvchg;
    }

    /**
     * @return INDEXCHG
     */
    public Double getIndexchg() {
        return indexchg;
    }

    /**
     * @param indexchg
     */
    public void setIndexchg(Double indexchg) {
        this.indexchg = indexchg;
    }

    /**
     * @return ETFDEVIATION
     */
    public Double getEtfdeviation() {
        return etfdeviation;
    }

    /**
     * @param etfdeviation
     */
    public void setEtfdeviation(Double etfdeviation) {
        this.etfdeviation = etfdeviation;
    }

    /**
     * @return ETFLASTPRICE
     */
    public String getEtflastprice() {
        return etflastprice;
    }

    /**
     * @param etflastprice
     */
    public void setEtflastprice(String etflastprice) {
        this.etflastprice = etflastprice == null ? null : etflastprice.trim();
    }

    /**
     * @return IOPV
     */
    public String getIopv() {
        return iopv;
    }

    /**
     * @param iopv
     */
    public void setIopv(String iopv) {
        this.iopv = iopv == null ? null : iopv.trim();
    }

    /**
     * @return ETFPREMIUMDISCOUNT
     */
    public Double getEtfpremiumdiscount() {
        return etfpremiumdiscount;
    }

    /**
     * @param etfpremiumdiscount
     */
    public void setEtfpremiumdiscount(Double etfpremiumdiscount) {
        this.etfpremiumdiscount = etfpremiumdiscount;
    }
}