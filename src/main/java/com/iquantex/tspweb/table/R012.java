package com.iquantex.tspweb.table;

import com.iquantex.tspconst.api.RuleConst;
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
 * 现金头寸
 *
 * @author shenzhengjie
 * @date 2019/4/15 17:09
 */
@Slf4j
@Getter
@Setter
@NoArgsConstructor
public class R012 extends RuleResultTable {

    public static List<HeaderParam> getHeaderParam() {
        List<HeaderParam> headers = new ArrayList<>();
        //headers.add(new HeaderParam("ruleName", "规则名称"));
        headers.add(new HeaderParam(RuleConst.TRADE_DATE, "交易日期"));
        headers.add(new HeaderParam(InstInfo.f_fundCode, "产品代码"));
        headers.add(new HeaderParam(RuleConst.F_FUNDNAME, "产品名称"));

        headers.add(new HeaderParam(RuleConst.T_DAY_CASH, "T日可用现金(元)"));
        headers.add(new HeaderParam(RuleConst.RF_THRESHOLD, "T日阈值"));
        headers.add(new HeaderParam(RuleConst.TPLUS1_DAY_CASH, "T+1日可用现金(元)"));
        headers.add(new HeaderParam(RuleConst.TPLUS1_DAY_THRESHOLD, "T+1日阈值"));
        headers.add(new HeaderParam(RuleConst.RF_NET_ASSETS, "基金净资产(元)"));

        headers.add(new HeaderParam(RuleResult.f_checkTime, "触发时间"));
        headers.add(new HeaderParam(RuleResult.f_dealName, "处理人"));
        headers.add(new HeaderParam(RuleResult.f_dealTime, "处理时间"));
        return headers;
    }

    public R012(ResultAllV allV, List<RuleResultFactor> factors) {
        // 组装公共字段信息
        super(allV);

        // 组装特殊字段信息
        Map<String, String> map = new HashMap<>();
        for (RuleResultFactor factor : factors) {
            map.put(factor.getFactorKey(), factor.getFactorValue());
        }

        this.fundCode = map.get(RuleConst.F_FUNDCODE);
        this.fundName = map.get(RuleConst.F_FUNDNAME);

        this.tradeDate = map.get(RuleConst.TRADE_DATE); // todo 待确定传入时间格式
        this.tDayCash = map.getOrDefault(RuleConst.T_DAY_CASH, "0");
        this.threshold = map.getOrDefault(RuleConst.RF_THRESHOLD, "0");
        this.tPlus1DayCash = map.getOrDefault(RuleConst.TPLUS1_DAY_CASH, "0");
        this.tPlus1DayThreshold = map.getOrDefault(RuleConst.TPLUS1_DAY_THRESHOLD, "0");
        this.netAssets = map.getOrDefault(RuleConst.RF_NET_ASSETS, "0");
        log.debug("< " + this.getClass().getSimpleName() + ">" + " : End of conversion. ");
    }

    /**
     * 交易日期
     */
    private String tradeDate;

    /**
     * T日可用现金
     */
    private String tDayCash;
    /**
     * T日阈值
     */
    private String threshold;

    /**
     * T+1日可用现金
     */
    private String tPlus1DayCash;

    /**
     * T+1日阈值
     */
    private String tPlus1DayThreshold;

    /**
     * 基金净资产
     */
    private String netAssets;

    /**
     * 产品编码
     */
    private String fundCode;

    /**
     * 产品名称
     */
    private String fundName;
}
