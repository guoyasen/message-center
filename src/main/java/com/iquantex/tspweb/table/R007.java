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
 * ETF基金申赎监控
 *
 * @author shenzhengjie
 * @date 2019/3/7 9:39
 */
@Slf4j
@Getter
@Setter
@NoArgsConstructor
public class R007 extends RuleResultTable {

    public static List<HeaderParam> getHeaderParam() {
        List<HeaderParam> headers = new ArrayList<>();
        //headers.add(new HeaderParam("ruleName", "规则名称"));
        headers.add(new HeaderParam(RuleConst.F_FUNDCODE, "产品代码"));
        headers.add(new HeaderParam(RuleConst.F_FUNDNAME, "产品名称"));

        headers.add(new HeaderParam(RuleConst.ENTRUST_DIRECTION, "委托方向"));
        headers.add(new HeaderParam(RuleConst.TRADE_SHARES, "委托数量(百万)"));
        headers.add(new HeaderParam(RuleConst.TODAY_SHARES, "前一日产品规模(亿)"));
        headers.add(new HeaderParam(RuleConst.ACTUAL_RATIO, "实际比例值"));
        headers.add(new HeaderParam(RuleConst.RF_THRESHOLD, "阈值"));

        headers.add(new HeaderParam(RuleResult.f_checkTime, "触发时间"));
        headers.add(new HeaderParam(RuleResult.f_dealName, "处理人"));
        headers.add(new HeaderParam(RuleResult.f_dealTime, "处理时间"));

        return headers;
    }

    public R007(ResultAllV allV, List<RuleResultFactor> factors) {
        // 组装公共字段信息
        super(allV);

        // 组装特殊字段信息
        Map<String, String> map = new HashMap<>();
        for (RuleResultFactor factor : factors) {
            map.put(factor.getFactorKey(), factor.getFactorValue());
        }

        this.entrustDirection = map.get(RuleConst.ENTRUST_DIRECTION);
        this.fundCode = map.get(RuleConst.F_FUNDCODE);
        this.fundName = map.get(RuleConst.F_FUNDNAME);
        this.threshold = MathUtil.addSuffixPercent(map.getOrDefault(RuleConst.RF_THRESHOLD, "0"));
        this.tradeShares = MathUtil.fmtNumber(map.get(RuleConst.TRADE_SHARES),1000000,1);
        if (this.entrustDirection.equals("申购")) {
            this.purchaseShares = MathUtil.fmtNumber(map.get(RuleConst.TRADE_SHARES),1000000,1);
        }
        if (this.entrustDirection.equals("赎回")) {
            this.redemptionShares = MathUtil.fmtNumber(map.get(RuleConst.TRADE_SHARES),1000000,1);
        }
        this.todayShares = MathUtil.fmtNumber(map.get(RuleConst.TODAY_SHARES),100000000,2);
        this.actualRatio = MathUtil.addSuffixPercent(map.getOrDefault(RuleConst.ACTUAL_RATIO, "0"));

        log.debug("< " + this.getClass().getSimpleName() + ">" + " : End of conversion. ");
    }

    /**
     * 委托方向
     */
    private String entrustDirection;

    /**
     * 产品编码
     */
    private String fundCode;

    /**
     * 产品名称
     */
    private String fundName;

    /**
     * 触发阈值
     */
    private String threshold;

    /**
     * 委托数量
     */
    private String tradeShares;

    /**
     * 申购数量
     */
    private String purchaseShares;

    /**
     * 赎回数量
     */
    private String redemptionShares;

    /**
     * 前一日产品规模（日出份额）
     */
    private String todayShares;

    /**
     * 实际比例
     */
    private String actualRatio;
}
