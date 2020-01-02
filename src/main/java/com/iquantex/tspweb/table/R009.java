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
 * ETF补券监控
 *
 * @author shenzhengjie
 * @date 2019/3/18 16:03
 */
@Slf4j
@Getter
@Setter
@NoArgsConstructor
public class R009 extends RuleResultTable {

    public static List<HeaderParam> getHeaderParam() {
        List<HeaderParam> headers = new ArrayList<>();
        //headers.add(new HeaderParam("ruleName", "规则名称"));
        headers.add(new HeaderParam(RuleConst.F_FUNDCODE, "产品代码"));
        headers.add(new HeaderParam(RuleConst.F_FUNDNAME, "产品名称"));

        headers.add(new HeaderParam(RuleConst.NEED_PATCH_QTY, "应补券数量"));
        headers.add(new HeaderParam(RuleConst.COMPLETE_PATCH_QTY, "已补券数量"));
        headers.add(new HeaderParam(RuleConst.DIFFERENCE, "差额"));

        headers.add(new HeaderParam(RuleResult.f_checkTime, "触发时间"));
        headers.add(new HeaderParam(RuleResult.f_dealName, "处理人"));
        headers.add(new HeaderParam(RuleResult.f_dealTime, "处理时间"));

        return headers;
    }

    public R009(ResultAllV allV, List<RuleResultFactor> factors) {
        // 组装公共字段信息
        super(allV);

        // 组装特殊字段信息
        Map<String, String> map = new HashMap<>();
        for (RuleResultFactor factor : factors) {
            map.put(factor.getFactorKey(), factor.getFactorValue());
        }
        this.fundCode = map.get(RuleConst.F_FUNDCODE);
        this.fundName = map.get(RuleConst.F_FUNDNAME);
        this.needPatchQty = map.getOrDefault(RuleConst.NEED_PATCH_QTY, "0");
        this.completePatchQty = map.getOrDefault(RuleConst.COMPLETE_PATCH_QTY, "0");
        this.difference = map.getOrDefault(RuleConst.DIFFERENCE, "0");

        log.debug("< " + this.getClass().getSimpleName() + ">" + " : End of conversion. ");
    }

    /**
     * 产品编码
     */
    private String fundCode;

    /**
     * 产品名称
     */
    private String fundName;

    /**
     * 应补券数量
     */
    private String needPatchQty;

    /**
     * 已补券数量
     */
    private String completePatchQty;

    /**
     * 差额
     */
    private String difference;
}
