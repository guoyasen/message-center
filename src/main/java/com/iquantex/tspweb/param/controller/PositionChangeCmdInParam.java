package com.iquantex.tspweb.param.controller;


import lombok.ToString;

/**
 * 持仓变动
 */
@ToString
public class PositionChangeCmdInParam {
    /**
     * 产品编码
     */
    private String fundCode;
    /**
     * 证券编码
     */
    private String secuCode;
    /**
     * 数量覆盖式
     */
    private Long qty;

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
     * 获取证券编码
     */
    public String getSecuCode() {
        return this.secuCode;
    }

    /**
     * 设置证券编码
     */
    public void setSecuCode(String secuCode) {
        this.secuCode = secuCode;
    }

    /**
     * 获取数量覆盖式
     */
    public Long getQty() {
        return this.qty;
    }

    /**
     * 设置数量覆盖式
     */
    public void setQty(Long qty) {
        this.qty = qty;
    }
}