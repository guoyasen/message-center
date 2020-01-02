package com.iquantex.tspweb.param;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Etf偏离度跑马灯websocket
 */
@Data
@ToString
public class EtfDeviationLightVO {
    /**
     * 检查时间
     */
    private long checkTime;
    /**
     * 基金编码
     */
    private String fundCode;
    /**
     * 基金名称
     **/
    private String fundName;
    /**
     * iopv
     **/
    private String iopv;
    /**
     * 前一交易单位净值
     **/
    private String preNav;
    /***iopv涨跌幅*/
    private String iopvChg;
    /**
     * 指数编码
     **/
    private String indexCode;
    /**
     * 指数最新价
     **/
    private String indexPrice;
    /***指数昨日收盘价*/
    private String indexPreClosePrice;
    /***指数涨跌幅*/
    private String indexChg;
    /**
     * etf偏离度
     **/
    private String etfDeviation;
    /**
     * 规则id
     */
    private String ruleId;
    /**
     * 处理状态<>error=1=处理异常&noneedCheck=0=不检查&pass=1=通过&notPass=2=告警
     */
    private int status;

    /**
     * etf基金最新价
     */
    private String etfLastPrice;

    /**
     * etf基金折溢价率
     */
    private String etfPremiumDiscount;

    /**
     * etf基金成交量
     */
    private String etfVolume;

    /**
     * etf基金前20日平均成交量
     */
    private String etf20AvgVolume;

    /**
     * etf基金成交量20日偏离
     */
    private String etfVolume20Deviation;


    /**
     * pcf日期
     **/
    private String pcfDt;

    /**
     * etf基金每单元净值
     */
    private String navPerCu;

    /**
     * etf基金预测现金差额
     */
    private String estmCshCmpn;

    /**
     * etf基金分红金额
     */
    private String dvdnAmnt;

    /**
     * etf基金成分股市值
     */
    private String cnstMrktVl;

    /**
     * etf基金成分股币种汇率
     */
    private String cnstCrrnRt;

    /**
     * etf基金校验差额
     */
    private String chckMrgn;

    /**
     * 是否可申购、可赎回
     */
    private String prchRdmpFlg;

    /*** 申赎单元*/
    private String crtnRdmpUnt;

    /**
     * 申购数量
     */
    private String purchaseShares;
    /**
     * 赎回数量
     */
    private String redemptionShares;

    /**
     * 覆盖度（百万）
     */
    private String coverage;

    /**
     * 前一交易日基金份额  （日出份额）
     */
    private String todayShares;
    /**
     * 申购数量占比
     */
    private String purchaseRatio;
    /**
     * 赎回数量占比
     */
    private String redemptionRatio;


    /**
     * 应补数量
     */
    private String needPatchQty;
    /**
     * 已补数量
     */
    private String completePatchQty;
    /**
     * 补券差额
     */
    private String patchDifference;
    /**
     * 检查时间
     */
    private long patchCheckTime;

    private List<etfAvailableStock> patchlist;

    public void addPatchlist(String stockName, String pcfNum, String positionNum, String rate, String maxRedemptionShares, String isSecurityStopped) {
        if (this.patchlist == null) {
            this.patchlist = new ArrayList<>();
        }
        this.patchlist.add(new etfAvailableStock(stockName, pcfNum, positionNum, rate, maxRedemptionShares, isSecurityStopped));
    }

//    /**
//     * etf价差
//     */
//    private List<PriceDiff> priceDiffList;

//    /**
//     * 价差
//     */
//    private Double priceDiff;

//    public void addPriceDiffList(Double etfLastPrice, Double bidPrice1, Double bidAmount1, Double offerPrice1, Double offerAmount1, Double priceDiff, Integer quoteTimes) {
//        if (this.priceDiffList == null) {
//            this.priceDiffList = new ArrayList<>();
//        }
//        this.priceDiffList.add(new PriceDiff(etfLastPrice, bidPrice1, bidAmount1, offerPrice1, offerAmount1, priceDiff, quoteTimes));
//        this.priceDiff = priceDiff;
//    }


    /**
     * etf可用券信息
     **/
    @AllArgsConstructor
    @Getter
    class etfAvailableStock {
        /**
         * 证券名称
         **/
        private String secuName;
        /**
         * pcf数量
         **/
        private String pcfStockNumber;
        /**
         * etf持仓数量
         **/
        private String positionStockNumber;
        /**
         * etf占比
         **/
        private String ratio;
        /**
         * 可赎回数量
         **/
        private String maxRedemptionShares;
        /**
         * 是否停牌
         **/
        private String isSecurityStopped;
    }

    /**
     * etf价差规则
     */
//    @AllArgsConstructor
//    @Getter
//    class PriceDiff {
//        /**
//         * 最新价
//         */
    private Double etfLastPrice1;
    //买一价
    private Double bidPrice1;
    //买一量
    private Double bidAmount1;
    //卖一价
    private Double offerPrice1;
    //卖一量
    private Double offerAmount1;
    //价差
    private Double priceDiff;
    //行情时间
    private Integer quoteTimes;
//    }

    public void setCheckTime(Date date) {
        this.checkTime = date.getTime();
    }

    //etf赎回交易执行规则

    //赎回篮子数
    private Double redemptionBaskets;
    //主动补券是否完成
    private String isActivePatchCompleted;
    //主要未完成成分券
    private String mainUnCompletedStock;
    //检查时间
    private String updateTime;

}