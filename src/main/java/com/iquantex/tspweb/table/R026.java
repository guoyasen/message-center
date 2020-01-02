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
 * 期货价差规则
 *
 * @author 向鹏
 * @date 2019/11/22 09:02
 */
@Slf4j
@Getter
@Setter
@NoArgsConstructor
public class R026 extends RuleResultTable {

    public static List<HeaderParam> getHeaderParam() {
        List<HeaderParam> headers = new ArrayList<>();
        //headers.add(new HeaderParam("ruleName", "规则名称"));
        headers.add(new HeaderParam(RuleConst.FUTUREA_CODE, "期货A代码"));
        headers.add(new HeaderParam(RuleConst.FUTUREA_NAME, "期货A名称"));
        headers.add(new HeaderParam(RuleConst.FUTUREA_PRICE, "期货A价格"));
        headers.add(new HeaderParam(RuleConst.FUTUREA_TIME, "期货A行情时间"));
        headers.add(new HeaderParam(RuleConst.FUTUREB_CODE, "期货B代码"));
        headers.add(new HeaderParam(RuleConst.FUTUREB_NAME, "期货B名称"));
        headers.add(new HeaderParam(RuleConst.FUTUREB_PRICE, "期货B价格"));
        headers.add(new HeaderParam(RuleConst.FUTUREB_TIME, "期货B行情时间"));
        headers.add(new HeaderParam(RuleConst.FUTURE_PRICE_DIFF, "期货价差"));
        return headers;
    }

    public R026(ResultAllV allV, List<RuleResultFactor> factors) {
        // 组装公共字段信息
        super(allV);
        // 组装特殊字段信息
        Map<String, String> map = new HashMap<>();
        for (RuleResultFactor factor : factors) {
            map.put(factor.getFactorKey(), factor.getFactorValue());
        }
        this.futureACode = map.get(RuleConst.FUTUREA_CODE);
        this.futureAName = map.get(RuleConst.FUTUREA_NAME);
        this.futureAPrice = Double.valueOf(map.get(RuleConst.FUTUREA_PRICE));
        this.futureATimeStamp = map.get(RuleConst.FUTUREA_TIME);

        this.futureBCode = map.get(RuleConst.FUTUREB_CODE);
        this.futureBName = map.get(RuleConst.FUTUREB_NAME);
        this.futureBPrice = Double.valueOf(map.get(RuleConst.FUTUREB_PRICE));
        this.futureBTimeStamp = map.get(RuleConst.FUTUREB_TIME);
        this.futurePriceDiff = Double.valueOf(map.get(RuleConst.FUTURE_PRICE_DIFF));
        log.debug("< " + this.getClass().getSimpleName() + ">" + " : End of conversion. ");
    }

    //期货A代码
    private String futureACode;
    //期货A名称
    private String futureAName;
    //期货A价格
    private Double futureAPrice;
    //期货A行情时间
    private String futureATimeStamp;

    //期货B代码
    private String futureBCode;
    //期货B名称
    private String futureBName;
    //期货B价格
    private Double futureBPrice;
    //期货B行情时间
    private String futureBTimeStamp;

    //期货价差
    private Double futurePriceDiff;
}
