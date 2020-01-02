package com.iquantex.tspweb.model;

import javax.persistence.*;
import org.apache.ibatis.type.JdbcType;
import tk.mybatis.mapper.annotation.ColumnType;

@Table(name = "ETF_PRICE_DIFF_VW")
public class EtfPriceDiffVw {
    @Column(name = "FUNDCODE")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String fundcode;

    @Column(name = "BIDPRICE1")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String bidprice1;

    @Column(name = "BIDAMOUNT1")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String bidamount1;

    @Column(name = "OFFERPRICE1")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String offerprice1;

    @Column(name = "OFFERAMOUNT1")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String offeramount1;

    @Column(name = "PRICEDIFF")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String pricediff;

    @Column(name = "ETFLASTPRICE")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String etflastprice;

    @Column(name = "QUOTETIMES")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String quotetimes;

    public static final String TABLE = "ETF_PRICE_DIFF_VW";

    public static final String f_fundcode = "fundcode";

    public static final String f_bidprice1 = "bidprice1";

    public static final String f_bidamount1 = "bidamount1";

    public static final String f_offerprice1 = "offerprice1";

    public static final String f_offeramount1 = "offeramount1";

    public static final String f_pricediff = "pricediff";

    public static final String f_etflastprice = "etflastprice";

    public static final String f_quotetimes = "quotetimes";

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
     * @return BIDPRICE1
     */
    public String getBidprice1() {
        return bidprice1;
    }

    /**
     * @param bidprice1
     */
    public void setBidprice1(String bidprice1) {
        this.bidprice1 = bidprice1 == null ? null : bidprice1.trim();
    }

    /**
     * @return BIDAMOUNT1
     */
    public String getBidamount1() {
        return bidamount1;
    }

    /**
     * @param bidamount1
     */
    public void setBidamount1(String bidamount1) {
        this.bidamount1 = bidamount1 == null ? null : bidamount1.trim();
    }

    /**
     * @return OFFERPRICE1
     */
    public String getOfferprice1() {
        return offerprice1;
    }

    /**
     * @param offerprice1
     */
    public void setOfferprice1(String offerprice1) {
        this.offerprice1 = offerprice1 == null ? null : offerprice1.trim();
    }

    /**
     * @return OFFERAMOUNT1
     */
    public String getOfferamount1() {
        return offeramount1;
    }

    /**
     * @param offeramount1
     */
    public void setOfferamount1(String offeramount1) {
        this.offeramount1 = offeramount1 == null ? null : offeramount1.trim();
    }

    /**
     * @return PRICEDIFF
     */
    public String getPricediff() {
        return pricediff;
    }

    /**
     * @param pricediff
     */
    public void setPricediff(String pricediff) {
        this.pricediff = pricediff == null ? null : pricediff.trim();
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
     * @return QUOTETIMES
     */
    public String getQuotetimes() {
        return quotetimes;
    }

    /**
     * @param quotetimes
     */
    public void setQuotetimes(String quotetimes) {
        this.quotetimes = quotetimes == null ? null : quotetimes.trim();
    }
}