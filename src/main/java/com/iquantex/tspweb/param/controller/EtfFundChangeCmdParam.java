package com.iquantex.tspweb.param.controller;

import lombok.Data;

/**
 * 指令变更命令
 */
@Data
public class EtfFundChangeCmdParam {
    /**
     * 产品代码
     */
    private String fundCode;
    /**
     * 万得代码
     */
    private String windCode;
    /**
     * O32 产品代码
     */
    private String o32FundCode;
    /**
     * 产品名称
     */
    private String fundName;
    /**
     * 申赎方向(申购、赎回)
     */
    private String entrustDirection;
    /**
     * 当前数量
     */
    private Long currentAmount;

    /**
     * 应补券数量
     */
    private Long needPatchQty;

    /**
     * 已补券数量
     */
    private Long completePatchQty;

    /**
     * 交易日期
     */
    private String tradeDate;

    /**
     * T日可用现金
     */
    private Double tDayCash;

    /**
     * T+1日可用现金
     */
    private Double tPlus1DayCash;

    /**
     * 基金净资产
     */
    private Double fundNetAsset;
}
