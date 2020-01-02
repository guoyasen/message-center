package com.iquantex.tspweb.param.controller;

import lombok.Data;

/**
 * @Auther: baozi
 * @Date: 2019/4/9 10:50
 * @Description:
 */
@Data
public class StockChangeInParam {
    // 市场代码
    private int marketNo;
    // 证券代码
    private String stockCode;
    // 证券名称
    private String stockName;
    // 停牌标识<>0=不停牌&1=停牌
    private int stockStatus;
    // 最新价
    private double lastPrice;
    // 总成交量
    private double amount;
    // 时间 HHmmss or Hmmss
    private int time;
}
