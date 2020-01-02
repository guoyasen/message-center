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
 * @author jiaoshihao
 * @date 2019/6/17 18:05
 */
@Slf4j
@Getter
@Setter
@NoArgsConstructor
public class R015 extends InstTable {

    public static List<HeaderParam> getHeaderParam() {
        List<HeaderParam> headers = new ArrayList<>();
        headers.add(new HeaderParam(RuleResult.f_instId, "指令序号"));
        //headers.add(new HeaderParam("ruleName", "规则名称"));

        headers.add(new HeaderParam(RuleConst.CNBD_YTE, "中债估值行权收益率"));
        headers.add(new HeaderParam(RuleConst.CNBD_YTM,"中债估值收益率"));

        headers.add(new HeaderParam(RuleConst.RF_CALC_YTE, "行权收益率"));
        headers.add(new HeaderParam(RuleConst.RF_CALC_YTM, "到期收益率"));

        headers.add(new HeaderParam(RuleConst.RF_CALC_VALUE, "偏离度"));
        headers.add(new HeaderParam(RuleConst.RF_THRESHOLD, "触发阈值"));

        headers.add(new HeaderParam(InstInfo.f_fundCode, "产品名称"));
        headers.add(new HeaderParam(InstInfo.f_tradeTypeCode, "方向"));
        headers.add(new HeaderParam(InstInfo.f_instCreateName, "投资经理"));
        headers.add(new HeaderParam(InstInfo.f_secuCode, "证券编码"));
        headers.add(new HeaderParam(InstInfo.f_o32SecuName, "证券名称"));

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

    public R015(ResultAllV allV, List<RuleResultFactor> factors) {
        // 组装公共字段信息
        super(allV);

        // 组装特殊字段信息
        Map<String, String> map = new HashMap<>();
        for (RuleResultFactor factor : factors) {
            map.put(factor.getFactorKey(), factor.getFactorValue());
        }
        this.cnbdYtm = MathUtil.addSuffixPercent(map.getOrDefault(RuleConst.CNBD_YTM, "0"));
        this.cnbdYte = MathUtil.addSuffixPercent(map.getOrDefault(RuleConst.CNBD_YTE, "0"));


        this.rfCalcYtm = MathUtil.addSuffixPercent(map.getOrDefault(RuleConst.RF_CALC_YTM, "0"));
        this.rfCalcYte = MathUtil.addSuffixPercent(map.getOrDefault(RuleConst.RF_CALC_YTE, "0"));

        this.calcValue = MathUtil.addSuffixBP(map.getOrDefault(RuleConst.RF_CALC_VALUE, "0"));

        this.threshold = MathUtil.addSuffixBP(map.getOrDefault(RuleConst.RF_THRESHOLD, "0"));
        this.internalRate = map.get(RuleConst.ADD_INTERNAL_RATE);

        log.debug("< " + this.getClass().getSimpleName() + ">" + " : End of conversion. ");
    }

    /**
     * 中债行权收益率
     */
    private String cnbdYte;
    /**
     * 中债到期收益率
     */
    private String cnbdYtm;
    /**
     * 行权收益率
     */
    private String rfCalcYte;
    /**
     * 到期收益率
     */
    private String rfCalcYtm;
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
     * 内部债项评级
     */
    private String internalRate;
}
