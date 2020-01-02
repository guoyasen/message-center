package com.iquantex.tspweb.table;

import com.iquantex.tspconst.api.RuleConst;
import com.iquantex.tspweb.model.ResultAllV;
import com.iquantex.tspweb.model.RuleResultFactor;
import com.iquantex.tspweb.param.HeaderParam;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 新股开板规则
 *
 * @author 向鹏
 * @date 2019/11/14 14:53
 */
@Slf4j
@Getter
@Setter
@NoArgsConstructor
public class R025 extends RuleResultTable {

    public static List<HeaderParam> getHeaderParam() {
        List<HeaderParam> headers = new ArrayList<>();
        //headers.add(new HeaderParam("ruleName", "规则名称"));
        headers.add(new HeaderParam(RuleConst.STOCK_MARKET_SECU_CODE, "证券代码"));
        headers.add(new HeaderParam(RuleConst.STOCK_MARKET_SECU_NAME, "证券名称"));
        headers.add(new HeaderParam(RuleConst.PRE_CLOSE_PRICE, "昨收盘价"));
        headers.add(new HeaderParam(RuleConst.STOCK_MARKET_LASTPRICE, "最新价"));
        headers.add(new HeaderParam(RuleConst.STOCK_MARKET_CHG, "涨跌幅"));
        headers.add(new HeaderParam(RuleConst.UP_PRICE, "涨停价"));
        headers.add(new HeaderParam(RuleConst.IS_STOP_LIMIT_UP, "是否开板"));
        headers.add(new HeaderParam(RuleConst.QUOTE_TIMES, "更新时间"));
        return headers;
    }

    public R025(ResultAllV allV, List<RuleResultFactor> factors) {
        // 组装公共字段信息
        super(allV);
        // 组装特殊字段信息
        Map<String, String> map = new HashMap<>();
        for (RuleResultFactor factor : factors) {
            map.put(factor.getFactorKey(), factor.getFactorValue());
        }
        this.stockMarketSecuCode = map.get(RuleConst.STOCK_MARKET_SECU_CODE);
        this.stockMarketSecuName = map.get(RuleConst.STOCK_MARKET_SECU_NAME);
        this.preClosePrice = Double.valueOf(map.get(RuleConst.PRE_CLOSE_PRICE));
        this.stockMarketLastPrice = Double.valueOf(map.get(RuleConst.STOCK_MARKET_LASTPRICE));
        this.stockMarketChg = Double.valueOf(map.get(RuleConst.STOCK_MARKET_CHG));
        this.upPrice = Double.valueOf(map.get(RuleConst.UP_PRICE));
        this.isStopLimitUp = map.get(RuleConst.IS_STOP_LIMIT_UP);
        this.quoteTimes = map.get(RuleConst.QUOTE_TIMES);
        log.debug("< " + this.getClass().getSimpleName() + ">" + " : End of conversion. ");
    }

    //证券代码
    private String stockMarketSecuCode;
    //证券名称
    private String stockMarketSecuName;
    //昨收盘价
    private Double preClosePrice;
    //最新价
    private Double stockMarketLastPrice;
    //涨跌幅
    private Double stockMarketChg;
    //涨停价
    private Double upPrice;
    //是否开板
    private String isStopLimitUp;
    //更新时间
    private String quoteTimes;
}
