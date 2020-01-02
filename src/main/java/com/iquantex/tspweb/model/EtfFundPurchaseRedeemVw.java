package com.iquantex.tspweb.model;

import javax.persistence.*;
import org.apache.ibatis.type.JdbcType;
import tk.mybatis.mapper.annotation.ColumnType;

@Table(name = "ETF_FUND_PURCHASE_REDEEM_VW")
public class EtfFundPurchaseRedeemVw {
    @Column(name = "FUNDCODE")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String fundcode;

    @Column(name = "YESTERDAYFUNDSHARE")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String yesterdayfundshare;

    @Column(name = "PURCHASE_AMOUNT")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String purchaseAmount;

    @Column(name = "REDEMPTION_AMOUNT")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String redemptionAmount;

    @Column(name = "PURCHASE_RATIO")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String purchaseRatio;

    @Column(name = "REDEMPTION_RATIO")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String redemptionRatio;

    public static final String TABLE = "ETF_FUND_PURCHASE_REDEEM_VW";

    public static final String f_fundcode = "fundcode";

    public static final String f_yesterdayfundshare = "yesterdayfundshare";

    public static final String f_purchaseAmount = "purchaseAmount";

    public static final String f_redemptionAmount = "redemptionAmount";

    public static final String f_purchaseRatio = "purchaseRatio";

    public static final String f_redemptionRatio = "redemptionRatio";

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
     * @return YESTERDAYFUNDSHARE
     */
    public String getYesterdayfundshare() {
        return yesterdayfundshare;
    }

    /**
     * @param yesterdayfundshare
     */
    public void setYesterdayfundshare(String yesterdayfundshare) {
        this.yesterdayfundshare = yesterdayfundshare == null ? null : yesterdayfundshare.trim();
    }

    /**
     * @return PURCHASE_AMOUNT
     */
    public String getPurchaseAmount() {
        return purchaseAmount;
    }

    /**
     * @param purchaseAmount
     */
    public void setPurchaseAmount(String purchaseAmount) {
        this.purchaseAmount = purchaseAmount == null ? null : purchaseAmount.trim();
    }

    /**
     * @return REDEMPTION_AMOUNT
     */
    public String getRedemptionAmount() {
        return redemptionAmount;
    }

    /**
     * @param redemptionAmount
     */
    public void setRedemptionAmount(String redemptionAmount) {
        this.redemptionAmount = redemptionAmount == null ? null : redemptionAmount.trim();
    }

    /**
     * @return PURCHASE_RATIO
     */
    public String getPurchaseRatio() {
        return purchaseRatio;
    }

    /**
     * @param purchaseRatio
     */
    public void setPurchaseRatio(String purchaseRatio) {
        this.purchaseRatio = purchaseRatio == null ? null : purchaseRatio.trim();
    }

    /**
     * @return REDEMPTION_RATIO
     */
    public String getRedemptionRatio() {
        return redemptionRatio;
    }

    /**
     * @param redemptionRatio
     */
    public void setRedemptionRatio(String redemptionRatio) {
        this.redemptionRatio = redemptionRatio == null ? null : redemptionRatio.trim();
    }
}