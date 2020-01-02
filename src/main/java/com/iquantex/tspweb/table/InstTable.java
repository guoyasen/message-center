package com.iquantex.tspweb.table;


import com.iquantex.tspconst.api.TradeConst;
import com.iquantex.tspweb.common.DateUtil;
import com.iquantex.tspweb.model.ResultAllV;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import static com.iquantex.tspweb.common.DateUtil.CURRENT_DATE_TIME;

@Data
@Slf4j
@NoArgsConstructor
public class InstTable extends RuleResultTable {

    // 指令要素
    /**
     * 指令编号
     */
    private String instCode;

    /**
     * 组合序号
     */
    private String ombinedCode;

    /**
     * 交易日期
     */
    private String tradeDate;

    /**
     * 基金序号
     */
    private String fundCode;

    /**
     * 指令下达人
     */
    private String instCreateName;

    /**
     * 指令执行人
     */
    private String instExecutionName;

    /**
     * 证券代码
     */
    private String secuCode;

    /**
     * 委托方向<>buy=0=买&sell=1=卖
     */
    private String tradeTypeCode;

    /**
     * 指令金额
     */
    private Double amt;

    /**
     * 指令数量
     */
    private Long qty;

    /**
     * 投资类型<>trade=1=可交易&maturity=2=持有到期&canSell=3=可供出售&other=4=贷款和应收款项
     */
    private Integer secuType;

    /**
     * O32证券代码
     */
    private String o32SecuCode;

    /**
     * O32证券名称
     */
    private String o32SecuName;

    /**
     * 是否长单<>true=1=是&false=0=否
     */
    private String isLongInst;

    /**
     * 指令价格
     */
    private Double price;
    /**
     * 指令序号
     */
    private String instId;

    InstTable(ResultAllV allV) {
        super(allV);
        log.debug("< " + this.getClass().getSimpleName() + ">" + " : Start conversion. ");
        this.instCode = allV.getInstCode();
        this.ombinedCode = allV.getOmbinedCode();
        this.tradeDate = DateUtil.format(allV.getTradeDate(), CURRENT_DATE_TIME);
        this.instId = allV.getInstId();
        this.fundCode = allV.getFundCode();
        this.tradeTypeCode = tradeTypeCodeToString(allV.getTradeTypeCode());
        this.instCreateName = allV.getInstCreateName();
        this.instExecutionName = allV.getInstExecutionName();
        this.secuCode = allV.getSecuCode();
        this.isLongInst = allV.getIsLongInst() != null ? (allV.getIsLongInst() == 1 ? "是" : "否") : null;
        this.price = allV.getPrice();
        this.qty = allV.getQty();
        this.secuType = allV.getSecuType();
        this.o32SecuCode = allV.getO32SecuCode();
        this.o32SecuName=allV.getO32SecuName();
        this.amt = allV.getAmt();
    }


    public static String tradeTypeCodeToString(Integer n) {
        if(n==null)
            return "-1";
        switch (n) {
            case TradeConst.TRADE_TYPE_STOCK_BUY:
                return "股票买入";
            case TradeConst.TRADE_TYPE_STOCK_SELL:
                return "股票卖出";
            case TradeConst.TRADE_TYPE_BOND_BUY:
                return "债券买入";
            case TradeConst.TRADE_TYPE_BOND_SELL:
                return "债券卖出";
            case TradeConst.TRADE_TYPE_REPO_SR1:
                return "正回购";
            case TradeConst.TRADE_TYPE_REPO_RR1:
                return "逆回购";
            default:
                return n.toString();
        }
    }
}
