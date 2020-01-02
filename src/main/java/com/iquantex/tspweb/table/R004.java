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
 * etf折溢价率规则
 *
 * @author xiangpeng
 * @date 2019/2/22 10:10
 */
@Slf4j
@Getter
@Setter
@NoArgsConstructor
public class R004 extends RuleResultTable {

    public static List<HeaderParam> getHeaderParam() {
        List<HeaderParam> headers = new ArrayList<>();
        //headers.add(new HeaderParam("ruleName", "规则名称"));
        headers.add(new HeaderParam(RuleConst.F_FUNDCODE, "产品代码"));
        headers.add(new HeaderParam(RuleConst.F_IOPV, "IOPV"));
        headers.add(new HeaderParam(RuleConst.ETF_LASTPRICE, "ETF最新价"));
        headers.add(new HeaderParam(RuleConst.ETF_PREMIUM_DISCOUNT, "ETF折溢价率"));
        headers.add(new HeaderParam(RuleResult.f_checkTime, "触发时间"));
        return headers;
    }

    public R004(ResultAllV allV, List<RuleResultFactor> factors) {
        // 组装公共字段信息
        super(allV);

        // 组装特殊字段信息
        Map<String, String> map = new HashMap<>();
        for (RuleResultFactor factor : factors) {
            map.put(factor.getFactorKey(), factor.getFactorValue());
        }
        this.etfPremiumDiscount = MathUtil.addSuffixPercent(map.getOrDefault(RuleConst.ETF_PREMIUM_DISCOUNT, "0"),2);
        this.fundCode = map.getOrDefault(RuleConst.F_FUNDCODE, "-1");
        this.iopv=Double.valueOf(map.getOrDefault(RuleConst.F_IOPV,"0")).toString();
        this.etfLastPrice=Double.valueOf(map.getOrDefault(RuleConst.ETF_LASTPRICE,"0")).toString();
        log.debug("< " + this.getClass().getSimpleName() + ">" + " : End of conversion. ");
    }


    /**
     * 产品名称
     */
    private String fundCode;

    /**
     * 基金当前iopv
     */
    private String iopv;

    /**
     * etf基金最新价
     */
    private String etfLastPrice;

    /**
     * etf基金折溢价率
     */
    private String etfPremiumDiscount;


}
