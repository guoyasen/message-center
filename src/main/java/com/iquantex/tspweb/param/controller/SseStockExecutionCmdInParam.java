package com.iquantex.tspweb.param.controller;


import lombok.Data;

/**
 * 股票成交
 */
@Data
public class SseStockExecutionCmdInParam {
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
    private Long instQty;
    /**
     * 指令金额
     */
    private Double amt;
    /**
     * 指令成交金额
     */
    private Double executionAmt;
    /**
     * 投资类型<>1：可交易 2：持有到期 3：可供出售 4：贷款和应收款项
     */
    private Integer secuType;
    /**
     * 指令状态<>BEFOR=分发前&AFTER=分发后
     */
    private String status;
    /**
     * 数量覆盖式
     */
    private Long positionQty;
    /**
     * 净资产
     */
    private Double netAssets;
    /**
     * 币种
     */
    private String currency;

    /**
     * 成交编码
     */
    private String executionCode;
    /**
     * 成交价格
     */
    private double executionPrice;
    /**
     * 成交数量
     */
    private int executionQty;
    /**
     * 成交时间
     */
    private int executionTime;
}