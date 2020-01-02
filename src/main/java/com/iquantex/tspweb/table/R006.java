package com.iquantex.tspweb.table;

import com.iquantex.tspconst.api.RuleConst;
import com.iquantex.tspweb.common.MathUtil;
import com.iquantex.tspweb.model.ResultAllV;
import com.iquantex.tspweb.model.RuleResult;
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
 * @author shenzhengjie
 * @date 2019/3/5 11:01
 */
@Slf4j
@Getter
@Setter
@NoArgsConstructor
public class R006 extends RuleResultTable {

    public R006(ResultAllV allV, List<RuleResultFactor> factors) {
        super(allV);

        // 组装特殊字段信息
        Map<String, String> map = new HashMap<>();
        for (RuleResultFactor factor : factors) {
            map.put(factor.getFactorKey(), factor.getFactorValue());
        }
        this.isSecurityStopped = Boolean.valueOf(map.get(RuleConst.IS_SECURITY_STOPPED)) ? "是" : "否";
        this.limitMove = map.get(RuleConst.LIMIT_MOVE);
        this.stockMarketChg = MathUtil.addSuffixPercent(map.getOrDefault(RuleConst.STOCK_MARKET_CHG, "0"));
        this.stockMarketLastPrice = map.getOrDefault(RuleConst.STOCK_MARKET_LASTPRICE, "0");
        // TODO fundName 和 secuName 暂时使用对应的Code代替
        this.fundName = map.get(RuleConst.STOCK_MARKET_FUND_CODE);
        this.stockMarketFundCode = map.get(RuleConst.STOCK_MARKET_FUND_CODE);
        this.stockMarketSecuCode = map.get(RuleConst.STOCK_MARKET_SECU_CODE);
        this.stockMarketSecuName = map.get(RuleConst.STOCK_MARKET_SECU_NAME);

        log.debug("< " + this.getClass().getSimpleName() + ">" + " : End of conversion. ");
    }

    public static List<HeaderParam> getHeaderParam() {
        List<HeaderParam> headers = new ArrayList<>();
        //headers.add(new HeaderParam("ruleName", "规则名称"));
        headers.add(new HeaderParam(RuleConst.STOCK_MARKET_SECU_CODE, "证券代码"));
        headers.add(new HeaderParam(RuleConst.STOCK_MARKET_SECU_NAME, "证券名称"));
        headers.add(new HeaderParam(RuleConst.STOCK_MARKET_LASTPRICE, "最新价格"));
        headers.add(new HeaderParam(RuleConst.STOCK_MARKET_CHG, "涨跌幅"));
        headers.add(new HeaderParam(RuleConst.LIMIT_MOVE, "涨跌停"));
        headers.add(new HeaderParam(RuleConst.IS_SECURITY_STOPPED, "是否停牌"));

        headers.add(new HeaderParam(RuleConst.STOCK_MARKET_FUND_CODE, "产品代码"));
        headers.add(new HeaderParam("fundName", "产品名称"));
        headers.add(new HeaderParam(RuleResult.f_checkTime, "触发时间"));
        headers.add(new HeaderParam(RuleResult.f_dealName, "处理人"));
        headers.add(new HeaderParam(RuleResult.f_dealTime, "处理时间"));

        return headers;
    }

    /**
     * 证券代码
     */
    private String stockMarketSecuCode;

    /**
     * 证券名称
     */
    private String stockMarketSecuName;

    /**
     * 产品名称
     */
    private String fundName;

    /**
     * 是否停牌
     */
    private String isSecurityStopped;

    /**
     * 涨跌停
     */
    private String limitMove;

    /**
     * 成分股行情涨跌幅
     */
    private String stockMarketChg;

    /**
     * 成分股行情最新价
     */
    private String stockMarketLastPrice;

    /**
     * 成分股行情产品代码
     */
    private String stockMarketFundCode;
}
