package com.iquantex.tspweb.table;

import com.iquantex.tspconst.api.RuleConst;
import com.iquantex.tspweb.common.MathUtil;
import com.iquantex.tspweb.model.*;
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
 * etf基金偏离度
 *
 * @author shenzhengjie
 * @date 2019/1/2 16:34
 */
@Slf4j
@Getter
@Setter
@NoArgsConstructor
public class R003 extends RuleResultTable {

    public static List<HeaderParam> getHeaderParam() {
        List<HeaderParam> headers = new ArrayList<>();
        //headers.add(new HeaderParam("ruleName", "规则名称"));
        headers.add(new HeaderParam(RuleConst.F_FUNDCODE, "产品代码"));
        headers.add(new HeaderParam(RuleConst.F_INDEXCODE, "指数代码"));
        headers.add(new HeaderParam(RuleConst.F_IOPV, "IOPV"));
        headers.add(new HeaderParam(RuleConst.F_FUND_PRENAV,"前一交易日单位净值"));
        headers.add(new HeaderParam(RuleConst.F_IOPV_CHG, "净值涨跌幅"));
        headers.add(new HeaderParam(RuleConst.F_INDEX, "指数当前点数"));
        headers.add(new HeaderParam(RuleConst.F_INDEX_PRECLOSE, "指数前收点数"));
        headers.add(new HeaderParam(RuleConst.F_INDEX_CHG, "指数涨跌幅"));
        headers.add(new HeaderParam(RuleConst.F_ETF_DEVIATION, "ETF偏离度"));
        headers.add(new HeaderParam(RuleResult.f_checkTime, "触发时间"));
        return headers;
    }

    public R003(ResultAllV allV, List<RuleResultFactor> factors) {
        // 组装公共字段信息
        super(allV);

        // 组装特殊字段信息
        Map<String, String> map = new HashMap<>();
        for (RuleResultFactor factor : factors) {
            map.put(factor.getFactorKey(), factor.getFactorValue());
        }
        this.etfDeviation = MathUtil.addSuffixPercent(map.getOrDefault(RuleConst.F_ETF_DEVIATION, "0"),2);
        this.fundCode = map.getOrDefault(RuleConst.F_FUNDCODE, "-1");
        this.iopv=Double.valueOf(map.getOrDefault(RuleConst.F_IOPV,"0")).toString();
        this.preNav=Double.valueOf(map.getOrDefault(RuleConst.F_FUND_PRENAV,"0")).toString();
        this.indexPrice=Double.valueOf(map.getOrDefault(RuleConst.F_INDEX,"0")).toString();
        this.indexPreClosePrice=Double.valueOf(map.getOrDefault(RuleConst.F_INDEX_PRECLOSE,"0")).toString();
        this.indexChg = MathUtil.addSuffixPercent(map.getOrDefault(RuleConst.F_INDEX_CHG, "0"),2);
        this.indexCode = map.getOrDefault(RuleConst.F_INDEXCODE, "0");
        this.iopvChg = MathUtil.addSuffixPercent(map.getOrDefault(RuleConst.F_IOPV_CHG, "0"),2);
        log.debug("< " + this.getClass().getSimpleName() + ">" + " : End of conversion. ");
    }


    /**
     * 产品名称
     */
    private String fundCode;

    /**
     * 指数名称
     */
    private String indexCode;


    /**
     * 基金当前iopv
     */
    private String iopv;

    /**
     * 基金昨iopv
     */
    private String preNav;


    /**
     * IOPV涨跌幅
     */
    private String iopvChg;


    /**
     * 指数当前点数
     */
    private String indexPrice;

    /**
     * 指数开盘点数
     */
    private String indexPreClosePrice;

    /**
     * 指数涨跌幅
     */
    private String indexChg;

    /**
     * ETF偏离度
     */
    private String etfDeviation;

}
