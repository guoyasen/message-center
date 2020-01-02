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
 * 债券收益偏离度
 *
 * @author shenzhengjie
 * @date 2019/1/2 16:33
 */
@Slf4j
@Getter
@Setter
@NoArgsConstructor
public class R001 extends InstTable {

    public static List<HeaderParam> getHeaderParam() {
        List<HeaderParam> headers = new ArrayList<>();
        headers.add(new HeaderParam(RuleResult.f_instId, "指令序号"));
        //headers.add(new HeaderParam("ruleName", "规则名称"));

        headers.add(new HeaderParam(RuleConst.RF_ZZ_YIELD, "基准值"));
        headers.add(new HeaderParam(RuleConst.RF_CALC_YIELD, "实际值"));
        headers.add(new HeaderParam(RuleConst.RF_CALC_VALUE, "偏离度"));
        headers.add(new HeaderParam(RuleConst.RF_THRESHOLD, "触发阈值"));

        headers.add(new HeaderParam(InstInfo.f_fundCode, "产品名称"));
        headers.add(new HeaderParam(InstInfo.f_tradeTypeCode, "方向"));
        headers.add(new HeaderParam(InstInfo.f_instCreateName, "投资经理"));
        headers.add(new HeaderParam(InstInfo.f_secuCode, "证券编码"));
        headers.add(new HeaderParam(InstInfo.f_o32SecuName, "证券名称"));

        headers.add(new HeaderParam(RuleConst.ADD_REDUCTION_BOND, "是否减持债"));
        headers.add(new HeaderParam(RuleConst.ADD_INTERNAL_RATE, "内部债项评级"));

        headers.add(new HeaderParam(InstInfo.f_isLongInst, "是否长单"));
        headers.add(new HeaderParam(InstInfo.f_price, "价格"));
        headers.add(new HeaderParam(InstInfo.f_qty, "数量"));
        headers.add(new HeaderParam(InstInfo.f_amt, "金额(万元)"));
        headers.add(new HeaderParam(RuleResult.f_checkTime, "触发时间"));
        //headers.add(new HeaderParam(RuleResult.f_status,"是否处理"));
        headers.add(new HeaderParam(RuleResult.f_dealName, "处理人"));
        headers.add(new HeaderParam(RuleResult.f_dealTime, "处理时间"));
        //headers.add(new HeaderParam(RuleResult.f_sendStatus,"是否发送"));
        headers.add(new HeaderParam(RuleResult.f_sendName, "发送人"));
        headers.add(new HeaderParam(RuleResult.f_sendTime, "发送时间"));

        return headers;
    }

    public R001(ResultAllV allV, List<RuleResultFactor> factors) {
        // 组装公共字段信息
        super(allV);

        // 组装特殊字段信息
        Map<String, String> map = new HashMap<>();
        for (RuleResultFactor factor : factors) {
            map.put(factor.getFactorKey(), factor.getFactorValue());
        }
        this.zzYield = MathUtil.addSuffixPercent(map.getOrDefault(RuleConst.RF_ZZ_YIELD, "0"));
        this.calcYield = MathUtil.addSuffixPercent(map.getOrDefault(RuleConst.RF_CALC_YIELD, "0"));
        this.calcValue = MathUtil.addSuffixBP(map.getOrDefault(RuleConst.RF_CALC_VALUE, "0"));
        this.threshold = MathUtil.addSuffixBP(map.getOrDefault(RuleConst.RF_THRESHOLD, "0"));
        this.reductionBond = Boolean.valueOf(map.get(RuleConst.ADD_REDUCTION_BOND)) ? "是" : "否";
        this.internalRate = map.get(RuleConst.ADD_INTERNAL_RATE);

        log.debug("< " + this.getClass().getSimpleName() + ">" + " : End of conversion. ");
    }

    /**
     * 基准值
     */
    private String zzYield;
    /**
     * 实际值
     */
    private String calcYield;
    /**
     * 偏离度
     * <p>
     * 0.03  --> 30BP
     * </p>
     */
    private String calcValue;
    /**
     * 触发阈值
     */
    private String threshold;
    /**
     * 是否减持债
     */
    private String reductionBond;
    /**
     * 内部债项评级
     */
    private String internalRate;

}
