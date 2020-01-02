package com.iquantex.tspweb.table;

import com.iquantex.tspconst.api.RuleConst;
import com.iquantex.tspweb.common.MathUtil;
import com.iquantex.tspweb.model.InstInfo;
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
 * 投资计划有效性
 *
 * @author shenzhengjie
 * @date 2019/1/2 16:34
 */
@Slf4j
@Getter
@Setter
@NoArgsConstructor
public class R002 extends InstTable {

    public static List<HeaderParam> getHeaderParam() {
        List<HeaderParam> headers = new ArrayList<>();
        headers.add(new HeaderParam(RuleResult.f_instId, "指令序号"));
        //headers.add(new HeaderParam("ruleName", "规则名称"));

        headers.add(new HeaderParam(RuleConst.RF_CALC_POSITION_MARKET_V_RATIO, "实际值"));
        headers.add(new HeaderParam(RuleConst.RF_POSITION_MARKET_V_RATIO, "触发阈值"));

        headers.add(new HeaderParam(InstInfo.f_tradeTypeCode, "方向"));
        headers.add(new HeaderParam(InstInfo.f_instCreateName, "投资经理"));
        headers.add(new HeaderParam(InstInfo.f_fundCode, "产品名称"));

        headers.add(new HeaderParam(RuleConst.RF_STCK_PL_LVL, "股票库级别"));
        headers.add(new HeaderParam(RuleConst.RF_INVESTMENT_AUTHORITY, "投资计划"));

        headers.add(new HeaderParam(InstInfo.f_secuCode, "证券编码"));
        headers.add(new HeaderParam(InstInfo.f_o32SecuName, "证券名称"));

        headers.add(new HeaderParam(InstInfo.f_price, "价格"));
        headers.add(new HeaderParam(InstInfo.f_qty, "数量"));
        headers.add(new HeaderParam(InstInfo.f_amt, "金额(万元)"));
        headers.add(new HeaderParam(RuleResult.f_checkTime, "触发时间"));
        headers.add(new HeaderParam(RuleResult.f_dealName, "处理人"));
        headers.add(new HeaderParam(RuleResult.f_dealTime, "处理时间"));

        return headers;
    }

    public R002(ResultAllV allV, List<RuleResultFactor> factors) {
        // 组装公共字段信息
        super(allV);

        // 组装特殊字段信息
        Map<String, String> map = new HashMap<>();
        for (RuleResultFactor factor : factors) {
            map.put(factor.getFactorKey(), factor.getFactorValue());
        }
        this.calcPositionMarketVRatio = MathUtil.addSuffixPercent(map.getOrDefault(RuleConst.RF_CALC_POSITION_MARKET_V_RATIO, "0"));
        this.threshold = MathUtil.addSuffixPercent(map.getOrDefault(RuleConst.RF_THRESHOLD, "0"));
        this.stckPlLvl = map.get(RuleConst.RF_STCK_PL_LVL);
        this.investmentAuthority = map.get(RuleConst.RF_INVESTMENT_AUTHORITY);
        this.positionMarketVRatio = MathUtil.addSuffixPercent(map.getOrDefault(RuleConst.RF_POSITION_MARKET_V_RATIO, "0"));
        log.debug("< " + this.getClass().getSimpleName() + ">" + " : End of conversion. ");
    }

    /**
     * 实际值
     */
    private String calcPositionMarketVRatio;
    /**
     * 触发阈值
     */
    private String threshold;
    /**
     * 股票库级别
     */
    private String stckPlLvl;
    /**
     * 投资计划
     */
    private String investmentAuthority;

    /**
     * 计算触发阈值
     */
    private String positionMarketVRatio;
}
