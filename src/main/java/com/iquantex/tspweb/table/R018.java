package com.iquantex.tspweb.table;

import com.iquantex.tspconst.api.RuleConst;
import com.iquantex.tspweb.common.MathUtil;
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
 * 交易所指令委托超时规则
 *
 * @author 向鹏
 * @date 2019/7/18 17:09
 */
@Slf4j
@Getter
@Setter
@NoArgsConstructor
public class R018 extends RuleResultTable {

    public static List<HeaderParam> getHeaderParam() {
        List<HeaderParam> headers = new ArrayList<>();
        //headers.add(new HeaderParam("ruleName", "规则名称"));
        headers.add(new HeaderParam(RuleConst.INST_CODE, "指令序号"));
        headers.add(new HeaderParam(RuleConst.FUND_NAME, "基金名称"));
        headers.add(new HeaderParam(RuleConst.STOCK_MARKET_SECU_CODE, "证券代码"));
        headers.add(new HeaderParam(RuleConst.STOCK_MARKET_SECU_NAME, "证券名称"));
        headers.add(new HeaderParam(RuleConst.RF_TRADE_TYPE_CODE, "委托方向"));
        headers.add(new HeaderParam(RuleConst.TRADE_SHARES, "指令数量"));
        headers.add(new HeaderParam(RuleConst.INST_AMT, "指令金额"));
        headers.add(new HeaderParam(RuleConst.INST_DIRECT_TIME, "指令下达时间"));
        headers.add(new HeaderParam(RuleConst.INST_DISPENSE_TIME, "指令分发时间"));
        return headers;
    }

    public R018(ResultAllV allV, List<RuleResultFactor> factors) {
        // 组装公共字段信息
        super(allV);

        // 组装特殊字段信息
        Map<String, String> map = new HashMap<>();
        for (RuleResultFactor factor : factors) {
            map.put(factor.getFactorKey(), factor.getFactorValue());
        }
        this.instCode = map.get(RuleConst.INST_CODE);
        this.fundName = map.get(RuleConst.FUND_NAME);
        this.stockMarketSecuCode = map.get(RuleConst.STOCK_MARKET_SECU_CODE);
        this.stockMarketSecuName = map.get(RuleConst.STOCK_MARKET_SECU_NAME);
        this.tradeTypeCode = InstTable.tradeTypeCodeToString(Integer.valueOf(map.get(RuleConst.RF_TRADE_TYPE_CODE)));
        this.tradeShares = Long.valueOf(map.get(RuleConst.TRADE_SHARES));
        this.instAmt = Double.valueOf(map.get(RuleConst.INST_AMT));
        this.instDirectTime=map.get(RuleConst.INST_DIRECT_TIME);
        this.instDispenseTime=map.get(RuleConst.INST_DISPENSE_TIME);

        log.debug("< " + this.getClass().getSimpleName() + ">" + " : End of conversion. ");
    }

    //指令序号
    private String instCode;
    //基金名称
    private String fundName;
    //证券代码
    private String stockMarketSecuCode;
    //证券名称
    private String stockMarketSecuName;
    //委托方向
    private String  tradeTypeCode;
    //指令数量
    private Long tradeShares;
    //指令金额
    private Double instAmt;
    //指令下达时间
    private String instDirectTime;
    //指令分发时间
    private String instDispenseTime;
}
