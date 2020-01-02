package com.iquantex.tspweb.param.controller;


/**
 * 产品净资产变动
 */
public class FundChangeCmdInParam {
    /**
     * 产品编码
     */
    private String fundCode;
    /**
     * 净资产
     */
    private Double netAssets;
    /**
     * 币种
     */
    private String currency;

    /**
     * 获取产品编码
     */
    public String getFundCode() {
        return this.fundCode;
    }

    /**
     * 设置产品编码
     */
    public void setFundCode(String fundCode) {
        this.fundCode = fundCode;
    }

    /**
     * 获取净资产
     */
    public Double getNetAssets() {
        return this.netAssets;
    }

    /**
     * 设置净资产
     */
    public void setNetAssets(Double netAssets) {
        this.netAssets = netAssets;
    }

    /**
     * 获取币种
     */
    public String getCurrency() {
        return this.currency;
    }

    /**
     * 设置币种
     */
    public void setCurrency(String currency) {
        this.currency = currency;
    }
}