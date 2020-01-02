package com.iquantex.tspweb.table;

import com.iquantex.tspconst.api.RuleConst;
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
 * 回购偏离度
 *
 * @author wudixiaobaozi
 * @date 2019/4/1 10:39
 */
@Slf4j
@Getter
@Setter
@NoArgsConstructor
public class R011 extends RuleResultTable {

    public static List<HeaderParam> getHeaderParam() {
        List<HeaderParam> headers = new ArrayList<>();
        headers.add(new HeaderParam(RuleConst.INST_CODE, "指令编码"));
        headers.add(new HeaderParam(RuleConst.EXECUTION_CODE, "成交编码"));
        headers.add(new HeaderParam(RuleConst.INST_PRC, "指令价格"));
        headers.add(new HeaderParam(RuleConst.AVG_PRICE_S, "区间内最新价"));
        headers.add(new HeaderParam(RuleConst.AVG_AMOUNT_S, "区间内成交量"));
        headers.add(new HeaderParam(RuleConst.EFFECTIVE_AVG_PRC, "区间内有效成交均价"));
        headers.add(new HeaderParam(RuleConst.INST_DEAL_AVG_PRC, "指令成交均价"));
        headers.add(new HeaderParam(RuleConst.PRICE_DIFF, "价差率"));
        headers.add(new HeaderParam(RuleConst.QUOTE_TIMES,"行情时间集合"));
        headers.add(new HeaderParam(RuleConst.DEAL_PRICE_LIST, "成交价格集合"));
        headers.add(new HeaderParam(RuleConst.DEAL_AMOUNT_LIST, "成交量集合"));
        headers.add(new HeaderParam(RuleConst.DEAL_TIME_LIST, "成交时间集合"));
        headers.add(new HeaderParam(RuleConst.EFFECTIVE_AVG_AMT, "市场有效成交量"));
        headers.add(new HeaderParam(RuleConst.INST_ACCUMULATED_DEAL_AMT, "指令累计成交量"));
        headers.add(new HeaderParam(RuleConst.COMPLETED_RATIO, "完成率"));
        headers.add(new HeaderParam(RuleResult.f_checkTime, "触发时间"));
        headers.add(new HeaderParam(RuleResult.f_dealName, "处理人"));
        headers.add(new HeaderParam(RuleResult.f_dealTime, "处理时间"));

        return headers;
    }

    public R011(ResultAllV allV, List<RuleResultFactor> factors) {
        // 组装公共字段信息
        super(allV);

        // 组装特殊字段信息
        Map<String, String> map = new HashMap<>();
        for (RuleResultFactor factor : factors) {
            map.put(factor.getFactorKey(), factor.getFactorValue());
        }

        this.instCode = map.get(RuleConst.INST_CODE);
        this.executionCode = map.get(RuleConst.EXECUTION_CODE);
        this.instPrc = map.get(RuleConst.INST_PRC);
        this.avgPrices = map.get(RuleConst.AVG_PRICE_S);
        this.avgAmounts = map.get(RuleConst.AVG_AMOUNT_S);
        this.effectiveAvgPrc = map.get(RuleConst.EFFECTIVE_AVG_PRC);
        this.instDealAvgPrc = map.get(RuleConst.INST_DEAL_AVG_PRC);
        this.priceDiff = map.get(RuleConst.PRICE_DIFF);
        this.quoteTimes = map.get(RuleConst.QUOTE_TIMES);
        this.dealPriceList = map.get(RuleConst.DEAL_PRICE_LIST);
        this.dealAmountList = map.get(RuleConst.DEAL_AMOUNT_LIST);
        this.dealTimeList = map.get(RuleConst.DEAL_TIME_LIST);
        this.effectiveAvgAmt = map.get(RuleConst.EFFECTIVE_AVG_AMT);
        this.instAccumulatedDealAmt = map.get(RuleConst.INST_ACCUMULATED_DEAL_AMT);
        this.completedRatio = map.get(RuleConst.COMPLETED_RATIO);

        log.debug("< " + this.getClass().getSimpleName() + ">" + " : End of conversion. ");
    }

    /**
     * 指令编码
     */
    private String instCode;


    /**
     * 成交编码
     */
    private String executionCode;

    /**
     * 指令价格
     */
    private String instPrc;

    /**
     * 样本点价格集合
     */
    private String avgPrices;


    /**
     * 区间内成交量
     */
    private String avgAmounts;


    /**
     * 市场有效成交均价
     */
    private String effectiveAvgPrc;

    /**
     * 指令成交均价
     */
    private String instDealAvgPrc;


    /**
     * 计算价差率
     */
    private String priceDiff;


    /**
     * 行情时间
     */
    private String quoteTimes;


    /**
     * 成交价格集合
     */
    private String dealPriceList;

    /**
     * 成交数量集合
     */
    private String dealAmountList;

    /**
     * 成交时间集合
     */
    private String dealTimeList;

    /**
     * 指令累积成交数量
     */
    private String instAccumulatedDealAmt;

    /**
     * 市场有效成交量
     */
    private String effectiveAvgAmt;

    /**
     * 完成率
     */
    private String completedRatio;

}
