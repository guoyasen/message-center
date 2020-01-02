package com.iquantex.tspweb.model;

import java.util.Date;
import javax.persistence.*;
import org.apache.ibatis.type.JdbcType;
import tk.mybatis.mapper.annotation.ColumnType;

@Table(name = "ETF_AVAILABLE_STOCK")
public class EtfAvailableStock {
    @Column(name = "CHECK_TIME")
    @ColumnType(jdbcType = JdbcType.TIMESTAMP)
    private Date checkTime;

    @Column(name = "FUNDCODE")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String fundcode;

    @Column(name = "TRADEDATE")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String tradedate;

    @Column(name = "STOCKMARKETSECUCODE")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String stockmarketsecucode;

    @Column(name = "PCFSTOCKNUMBER")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String pcfstocknumber;

    @Column(name = "POSITIONSTOCKNUMBER")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String positionstocknumber;

    @Column(name = "RATIO")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String ratio;

    @Column(name = "STOCKMARKETSECUNAME")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String stockmarketsecuname;

    @Column(name = "MAXREDEMPTIONSHARES")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String maxredemptionshares;

    @Column(name = "ISSECURITYSTOPPED")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String issecuritystopped;

    @Column(name = "COVERAGE")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String coverage;

    public static final String TABLE = "ETF_AVAILABLE_STOCK";

    public static final String f_checkTime = "checkTime";

    public static final String f_fundcode = "fundcode";

    public static final String f_tradedate = "tradedate";

    public static final String f_stockmarketsecucode = "stockmarketsecucode";

    public static final String f_pcfstocknumber = "pcfstocknumber";

    public static final String f_positionstocknumber = "positionstocknumber";

    public static final String f_ratio = "ratio";

    public static final String f_stockmarketsecuname = "stockmarketsecuname";

    public static final String f_maxredemptionshares = "maxredemptionshares";

    public static final String f_issecuritystopped = "issecuritystopped";

    public static final String f_coverage = "coverage";

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
     * @return TRADEDATE
     */
    public String getTradedate() {
        return tradedate;
    }

    /**
     * @param tradedate
     */
    public void setTradedate(String tradedate) {
        this.tradedate = tradedate == null ? null : tradedate.trim();
    }

    /**
     * @return STOCKMARKETSECUCODE
     */
    public String getStockmarketsecucode() {
        return stockmarketsecucode;
    }

    /**
     * @param stockmarketsecucode
     */
    public void setStockmarketsecucode(String stockmarketsecucode) {
        this.stockmarketsecucode = stockmarketsecucode == null ? null : stockmarketsecucode.trim();
    }

    /**
     * @return PCFSTOCKNUMBER
     */
    public String getPcfstocknumber() {
        return pcfstocknumber;
    }

    /**
     * @param pcfstocknumber
     */
    public void setPcfstocknumber(String pcfstocknumber) {
        this.pcfstocknumber = pcfstocknumber == null ? null : pcfstocknumber.trim();
    }

    /**
     * @return POSITIONSTOCKNUMBER
     */
    public String getPositionstocknumber() {
        return positionstocknumber;
    }

    /**
     * @param positionstocknumber
     */
    public void setPositionstocknumber(String positionstocknumber) {
        this.positionstocknumber = positionstocknumber == null ? null : positionstocknumber.trim();
    }

    /**
     * @return RATIO
     */
    public String getRatio() {
        return ratio;
    }

    /**
     * @param ratio
     */
    public void setRatio(String ratio) {
        this.ratio = ratio == null ? null : ratio.trim();
    }

    /**
     * @return STOCKMARKETSECUNAME
     */
    public String getStockmarketsecuname() {
        return stockmarketsecuname;
    }

    /**
     * @param stockmarketsecuname
     */
    public void setStockmarketsecuname(String stockmarketsecuname) {
        this.stockmarketsecuname = stockmarketsecuname == null ? null : stockmarketsecuname.trim();
    }

    /**
     * @return MAXREDEMPTIONSHARES
     */
    public String getMaxredemptionshares() {
        return maxredemptionshares;
    }

    /**
     * @param maxredemptionshares
     */
    public void setMaxredemptionshares(String maxredemptionshares) {
        this.maxredemptionshares = maxredemptionshares == null ? null : maxredemptionshares.trim();
    }

    /**
     * @return ISSECURITYSTOPPED
     */
    public String getIssecuritystopped() {
        return issecuritystopped;
    }

    /**
     * @param issecuritystopped
     */
    public void setIssecuritystopped(String issecuritystopped) {
        this.issecuritystopped = issecuritystopped == null ? null : issecuritystopped.trim();
    }

    /**
     * @return COVERAGE
     */
    public String getCoverage() {
        return coverage;
    }

    /**
     * @param coverage
     */
    public void setCoverage(String coverage) {
        this.coverage = coverage == null ? null : coverage.trim();
    }
}