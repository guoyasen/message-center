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

import static com.iquantex.tspweb.common.MathUtil.addSuffixBP100;

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
public class R010 extends InstTable {

    public static List<HeaderParam> getHeaderParam() {
        List<HeaderParam> headers = new ArrayList<>();
        headers.add(new HeaderParam(RuleResult.f_instId, "指令序号"));
        //headers.add(new HeaderParam("ruleName", "规则名称"));
        headers.add(new HeaderParam(InstInfo.f_tradeTypeCode, "方向"));
        headers.add(new HeaderParam(InstInfo.f_instCreateName, "投资经理"));
        //headers.add(new HeaderParam(InstInfo.f_fundCode, "产品代码"));
        headers.add(new HeaderParam(InstInfo.f_fundCode, "产品名称"));
        headers.add(new HeaderParam(InstInfo.f_secuCode, "证券编码"));
        headers.add(new HeaderParam(InstInfo.f_o32SecuName, "证券名称"));


        headers.add(new HeaderParam(RuleConst.REPO_RATE, "回购利率(%)"));
        headers.add(new HeaderParam(RuleConst.REAL_AVG_REPO_RATE, "加权平均利率(%)"));
        headers.add(new HeaderParam(RuleConst.RF_CALC_VALUE, "差额"));
        headers.add(new HeaderParam(RuleConst.RF_THRESHOLD, "阈值"));

        headers.add(new HeaderParam(RuleResult.f_checkTime, "触发时间"));
        headers.add(new HeaderParam(RuleResult.f_dealName, "处理人"));
        headers.add(new HeaderParam(RuleResult.f_dealTime, "处理时间"));

        return headers;
    }

    public R010(ResultAllV allV, List<RuleResultFactor> factors) {
        // 组装公共字段信息
        super(allV);

        // 组装特殊字段信息
        Map<String, String> map = new HashMap<>();
        for (RuleResultFactor factor : factors) {
            map.put(factor.getFactorKey(), factor.getFactorValue());
        }

        this.repoRate = map.getOrDefault(RuleConst.REPO_RATE, "0");
        this.realAvgRepoRate = map.getOrDefault(RuleConst.REAL_AVG_REPO_RATE, "0");
        this.calcValue = addSuffixBP100(map.getOrDefault(RuleConst.RF_CALC_VALUE, "0"));
        this.threshold = addSuffixBP100(map.get(RuleConst.RF_THRESHOLD));
        this.fundName = allV.getFundCode();
        log.debug("< " + this.getClass().getSimpleName() + ">" + " : End of conversion. ");
    }


    /**
     * 产品名称
     */
    private String fundName;

    /**
     * 回购利率
     */
    private String repoRate;

    /**
     * 加权平均回购利率
     */
    private String realAvgRepoRate;

    /**
     * 差额bp
     */
    private String calcValue;

    /**
     * 阈值
     */
    private String threshold;
}
