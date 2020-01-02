package com.iquantex.tspweb.table;

import com.iquantex.tspconst.api.RuleConst;
import com.iquantex.tspweb.model.ResultAllV;
import com.iquantex.tspweb.model.RuleResultFactor;
import com.iquantex.tspweb.param.HeaderParam;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.protocol.types.Field;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ETF价差计算规则
 *
 * @author 向鹏
 * @date 2019/9/10 9:06
 */
@Slf4j
@Getter
@Setter
@NoArgsConstructor
public class R022 extends RuleResultTable {

    public static List<HeaderParam> getHeaderParam() {
        List<HeaderParam> headers = new ArrayList<>();
        //headers.add(new HeaderParam("ruleName", "规则名称"));
        headers.add(new HeaderParam(RuleConst.F_FUNDCODE, "产品代码"));
        headers.add(new HeaderParam("etfLastPrice1", "ETF最新价"));
        headers.add(new HeaderParam(RuleConst.BID_PRICE1, "买一价"));
        headers.add(new HeaderParam(RuleConst.OFF_PRICE1, "卖一价"));
        headers.add(new HeaderParam(RuleConst.BID_AMOUNT1, "买一量"));
        headers.add(new HeaderParam(RuleConst.OFF_AMOUNT1, "卖一量"));
        headers.add(new HeaderParam(RuleConst.PRICE_DIFF, "价差"));
        headers.add(new HeaderParam(RuleConst.QUOTE_TIMES, "行情时间"));
        return headers;
    }

    public R022(ResultAllV allV, List<RuleResultFactor> factors) {
        // 组装公共字段信息
        super(allV);
        // 组装特殊字段信息
        Map<String, String> map = new HashMap<>();
        for (RuleResultFactor factor : factors) {
            map.put(factor.getFactorKey(), factor.getFactorValue());
        }
        this.fundCode = map.get(RuleConst.F_FUNDCODE);
        this.etfLastPrice1 = Double.valueOf(map.get(RuleConst.ETF_LASTPRICE));
        this.bidPrice1 = Double.valueOf(map.get(RuleConst.BID_PRICE1));
        this.bidAmount1 = Double.valueOf(map.get(RuleConst.BID_AMOUNT1));
        this.offerPrice1 = Double.valueOf(map.get(RuleConst.OFF_PRICE1));
        this.offerAmount1 = Double.valueOf(map.get(RuleConst.OFF_AMOUNT1));
        this.priceDiff = Double.valueOf(map.get(RuleConst.PRICE_DIFF));
        this.quoteTimes = Integer.valueOf(map.get(RuleConst.QUOTE_TIMES));
        log.debug("< " + this.getClass().getSimpleName() + ">" + " : End of conversion. ");
    }

    //产品代码
    private String fundCode;
    //ETF最新价
    private Double etfLastPrice1;
    //买一价
    private Double bidPrice1;
    //买一量
    private Double bidAmount1;
    //卖一价
    private Double offerPrice1;
    //卖一量
    private Double offerAmount1;
    //价差
    private Double priceDiff;
    //行情时间
    private Integer quoteTimes;
}
