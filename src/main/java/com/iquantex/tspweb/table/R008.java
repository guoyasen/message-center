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
 * 指令卖出数量相同
 *
 * @author shenzhengjie
 * @date 2019/3/7 9:39
 */
@Slf4j
@Getter
@Setter
@NoArgsConstructor
public class R008 extends InstTable {

    public static List<HeaderParam> getHeaderParam() {
        List<HeaderParam> headers = new ArrayList<>();
        headers.add(new HeaderParam(RuleResult.f_instId, "指令序号"));
        //headers.add(new HeaderParam("ruleName", "规则名称"));
        headers.add(new HeaderParam(InstInfo.f_tradeTypeCode, "方向"));
        headers.add(new HeaderParam(InstInfo.f_instCreateName, "投资经理"));
        headers.add(new HeaderParam(InstInfo.f_fundCode, "产品名称"));
        headers.add(new HeaderParam(InstInfo.f_secuCode, "证券编码"));
        headers.add(new HeaderParam(InstInfo.f_o32SecuName, "证券名称"));
        headers.add(new HeaderParam(InstInfo.f_price, "价格"));
        headers.add(new HeaderParam(InstInfo.f_qty, "数量"));
        headers.add(new HeaderParam(InstInfo.f_amt, "指令金额"));

        headers.add(new HeaderParam(RuleConst.POSITION_QTY, "持仓数量"));
        headers.add(new HeaderParam(RuleConst.INST_AMT_ASSET_RATIO, "指令金额占净资产比"));

        headers.add(new HeaderParam(RuleResult.f_checkTime, "触发时间"));
        headers.add(new HeaderParam(RuleResult.f_dealName, "处理人"));
        headers.add(new HeaderParam(RuleResult.f_dealTime, "处理时间"));

        return headers;
    }

    public R008(ResultAllV allV, List<RuleResultFactor> factors) {
        // 组装公共字段信息
        super(allV);

        // 组装特殊字段信息
        Map<String, String> map = new HashMap<>();
        for (RuleResultFactor factor : factors) {
            map.put(factor.getFactorKey(), factor.getFactorValue());
        }

        this.positionQty = map.get(RuleConst.POSITION_QTY);
        this.instAmtAssetRatio = MathUtil.addSuffixPercent(map.get(RuleConst.INST_AMT_ASSET_RATIO));
        log.debug("< " + this.getClass().getSimpleName() + ">" + " : End of conversion. ");
    }



    /**
     * 持仓数量
     */
    private String positionQty;

    /**
     * 指令金额占净资产比
     */
    private String instAmtAssetRatio;
}
