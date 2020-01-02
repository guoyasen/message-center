package com.iquantex.tspweb.param.controller;


import lombok.Data;

/**
 * 指令创建
 */
@Data
public class SseBondInstCmdInParam {
    /**
     * 产品编码
     */
    private String fundCode;
    /**
     * 组合序号
     */
    private String combinedCode;
    /**
     * 指令编码
     */
    private String instCode;
    /**
     * 交易日期
     */
    private Long tradeDate;
    /**
     * 指令下达人
     */
    private String instCreateName;
    /**
     * 指令执行人
     */
    private String instExecutionName;
    /**
     * o32内码
     */
    private String o32SecuCode;
    /**
     * 万得证券编码
     */
    private String windSecuCode;
    /**
     * 委托方向<>buy=0=买&sell=1=卖
     */
    private Integer tradeTypeCode;
    /**
     * 指令价格
     */
    private Double price;
    /**
     * 指令数量
     */
    private Long qty;
    /**
     * 指令金额
     */
    private Double amt;
    /**
     * 指令成交金额
     */
    private Double executionAmt;

    /**
     * accumulatedBalance
     */
    private Double accumulatedBalance;
    /**
     * 投资类型<>1：可交易 2：持有到期 3：可供出售 4：贷款和应收款项
     */
    private Integer secuType;
    /**
     * 指令状态<>BEFOR=分发前&AFTER=分发后
     */
    private String status;


    private Boolean isLongInst;

    /**
     * PCF 证券数量
     */
    private Integer pcfStockNumber;

    /**
     * 持仓证券数量
     */
    private Integer positionStockNumber;

    /**
     * 数量占比
     */
    private Double ratio;

    /**
     * 证券代码
     */
    private String stockCode;

    /**
     * 证券名称
     */
    private String stockName;


    /**申购数量**/
    private Double purchaseShares;

    /**赎回数量**/
    private Double redemptionShares;

    /**最大可赎回数量**/
    private Double maxRedemptionShares;

    /**
     * 指令有效状态
     */
    private String instructionStatus;

    public String getInstructionStatus() {
        return instructionStatus;
    }

    public void setInstructionStatus(String instructionStatus) {
        this.instructionStatus = instructionStatus;
    }

    /**
     * 买
     */
    public static final Integer c_tradeTypeCode_buy = 0;

    /**
     * 卖
     */
    public static final Integer c_tradeTypeCode_sell = 1;

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
     * 获取组合序号
     */
    public String getCombinedCode() {
        return this.combinedCode;
    }

    /**
     * 设置组合序号
     */
    public void setCombinedCode(String combinedCode) {
        this.combinedCode = combinedCode;
    }

    /**
     * 获取指令编码
     */
    public String getInstCode() {
        return this.instCode;
    }

    /**
     * 设置指令编码
     */
    public void setInstCode(String instCode) {
        this.instCode = instCode;
    }

    /**
     * 获取交易日期
     */
    public Long getTradeDate() {
        return this.tradeDate;
    }

    /**
     * 设置交易日期
     */
    public void setTradeDate(Long tradeDate) {
        this.tradeDate = tradeDate;
    }

    /**
     * 获取指令下达人
     */
    public String getInstCreateName() {
        return this.instCreateName;
    }

    /**
     * 设置指令下达人
     */
    public void setInstCreateName(String instCreateName) {
        this.instCreateName = instCreateName;
    }

    /**
     * 获取指令执行人
     */
    public String getInstExecutionName() {
        return this.instExecutionName;
    }

    /**
     * 设置指令执行人
     */
    public void setInstExecutionName(String instExecutionName) {
        this.instExecutionName = instExecutionName;
    }

    /**
     * 回购利率
     */
    private double repoRate;

    private int beginTime;

    private int endTime;

    private String lStockSerialNo;

    private Boolean isMultiOrder;

    private Integer dispenseTime;
    private Integer directDate;
    private Integer directTime;
    private Integer beginDate;


}