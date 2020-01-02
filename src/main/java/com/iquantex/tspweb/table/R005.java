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
 * etf基金成交量偏离度规则
 *
 * @author xiangpeng
 * @date 2019/2/22 10:37
 */
@Slf4j
@Getter
@Setter
@NoArgsConstructor
public class R005 extends RuleResultTable {

    public static List<HeaderParam> getHeaderParam() {
        List<HeaderParam> headers = new ArrayList<>();
        //headers.add(new HeaderParam("ruleName", "规则名称"));
        headers.add(new HeaderParam(RuleConst.F_FUNDCODE, "产品代码"));
        headers.add(new HeaderParam(RuleConst.ETF_VOLUME, "etf基金成交量"));
        headers.add(new HeaderParam(RuleConst.ETF_20_AVG_VOLUME,"etf基金前20日平均成交量"));
        headers.add(new HeaderParam(RuleConst.ETF_VOLUME_20_DEVIATION, "etf基金成交量20日偏离"));
        headers.add(new HeaderParam(RuleResult.f_checkTime, "触发时间"));
        return headers;
    }

    public R005(ResultAllV allV, List<RuleResultFactor> factors) {
        // 组装公共字段信息
        super(allV);

        // 组装特殊字段信息
        Map<String, String> map = new HashMap<>();
        for (RuleResultFactor factor : factors) {
            map.put(factor.getFactorKey(), factor.getFactorValue());
        }
        this.etfVolume20Deviation = MathUtil.addSuffixPercent(map.getOrDefault(RuleConst.ETF_VOLUME_20_DEVIATION, "0"),2);
        this.fundCode = map.getOrDefault(RuleConst.F_FUNDCODE, "-1");
        this.etfVolume=MathUtil.fmtMicrometerNoDecimal(map.getOrDefault(RuleConst.ETF_VOLUME,"0"));
        this.etf20AvgVolume=MathUtil.fmtMicrometerNoDecimal(map.getOrDefault(RuleConst.ETF_20_AVG_VOLUME,"0"));
        log.debug("< " + this.getClass().getSimpleName() + ">" + " : End of conversion. ");
    }
    /**
     * 产品名称
     */
    private String fundCode;
    /**
     * etf基金成交量
     */
    private String etfVolume;
    /**
     * etf基金前20日平均成交量
     */
    private String etf20AvgVolume;
    /**
     * etf基金成交量20日偏离
     */
    private String etfVolume20Deviation;

}
