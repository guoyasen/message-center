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
 * 社保基金券商交易量规则
 *
 * @author shenzhengjie
 * @date 2019/4/15 17:09
 */
@Slf4j
@Getter
@Setter
@NoArgsConstructor
public class R017 extends RuleResultTable {

    public static List<HeaderParam> getHeaderParam() {
        List<HeaderParam> headers = new ArrayList<>();
        //headers.add(new HeaderParam("ruleName", "规则名称"));
        headers.add(new HeaderParam(RuleConst.BROKER_NAME, "券商名称"));
        headers.add(new HeaderParam(RuleConst.TRADE_AMOUNT, "当日交易金额(万元)"));
        headers.add(new HeaderParam(RuleConst.RATE, "占比"));
        headers.add(new HeaderParam(RuleConst.TOTAL_TRADE_AMOUNT, "当季交易金额(万元)"));
        headers.add(new HeaderParam(RuleConst.TRADE_DATE, "交易日期"));
        headers.add(new HeaderParam(RuleConst.UPDATE_TIME, "更新时间"));
        return headers;
    }

    public R017(ResultAllV allV, List<RuleResultFactor> factors) {
        // 组装公共字段信息
        super(allV);

        // 组装特殊字段信息
        Map<String, String> map = new HashMap<>();
        for (RuleResultFactor factor : factors) {
            map.put(factor.getFactorKey(), factor.getFactorValue());
        }
        this.tradeDate = map.get(RuleConst.TRADE_DATE);
        this.brokerId = map.get(RuleConst.BROKER_ID);
        this.brokerName = map.get(RuleConst.BROKER_NAME);
        this.tradeAmount = Double.valueOf(map.get(RuleConst.TRADE_AMOUNT));
        this.rate = MathUtil.addSuffixPercent(map.get(RuleConst.RATE));
        this.totalTradeAmount = Double.valueOf(map.get(RuleConst.TOTAL_TRADE_AMOUNT));
        this.updateTime = map.get(RuleConst.UPDATE_TIME);

        log.debug("< " + this.getClass().getSimpleName() + ">" + " : End of conversion. ");
    }

    //交易日期
    private String tradeDate;
    //券商id
    private String brokerId;
    //券商名称
    private String brokerName;
    //成交量
    private Double tradeAmount;
    //成交量占比
    private String  rate;
    //总成交量
    private Double totalTradeAmount;
    //更新时间
    private String updateTime;
}
