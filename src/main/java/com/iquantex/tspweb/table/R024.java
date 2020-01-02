package com.iquantex.tspweb.table;

import com.iquantex.tspconst.api.RuleConst;
import com.iquantex.tspweb.model.ResultAllV;
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
 * ETF基金赎回交易规则
 *
 * @author 向鹏
 * @date 2019/10/23 10:28
 */
@Slf4j
@Getter
@Setter
@NoArgsConstructor
public class R024 extends RuleResultTable {

    public static List<HeaderParam> getHeaderParam() {
        List<HeaderParam> headers = new ArrayList<>();
        //headers.add(new HeaderParam("ruleName", "规则名称"));
        headers.add(new HeaderParam(RuleConst.F_FUNDCODE, "基金代码"));
        headers.add(new HeaderParam(RuleConst.FUND_NAME, "基金名称"));
        headers.add(new HeaderParam(RuleConst.REDEMPTION_BASKETS, "赎回数量"));
        headers.add(new HeaderParam(RuleConst.ISACTIVE_PATCH_COMPLETED, "主动补券是否完成"));
        headers.add(new HeaderParam(RuleConst.MAIN_UNCOMPLETED_STOCK, "主要未完成成分券"));
        headers.add(new HeaderParam(RuleConst.UPDATE_TIME, "检查时间"));
        return headers;
    }

    public R024(ResultAllV allV, List<RuleResultFactor> factors) {
        // 组装公共字段信息
        super(allV);
        // 组装特殊字段信息
        Map<String, String> map = new HashMap<>();
        for (RuleResultFactor factor : factors) {
            map.put(factor.getFactorKey(), factor.getFactorValue());
        }
        this.fundCode = map.get(RuleConst.F_FUNDCODE);
        this.fundName = map.get(RuleConst.FUND_NAME);
        this.redemptionBaskets = Double.valueOf(map.get(RuleConst.REDEMPTION_BASKETS));
        this.isActivePatchCompleted = map.get(RuleConst.ISACTIVE_PATCH_COMPLETED).equals("true") ? "是" : "否";
        this.mainUnCompletedStock = map.get(RuleConst.MAIN_UNCOMPLETED_STOCK);
        this.updateTime = map.get(RuleConst.UPDATE_TIME);

        log.debug("< " + this.getClass().getSimpleName() + ">" + " : End of conversion. ");
    }

    //产品代码
    private String fundCode;
    //产品名称
    private String fundName;
    //赎回篮子数
    private Double redemptionBaskets;
    //主动补券是否完成
    private String isActivePatchCompleted;
    //主要未完成成分券
    private String mainUnCompletedStock;
    //检查时间
    private String updateTime;
}
