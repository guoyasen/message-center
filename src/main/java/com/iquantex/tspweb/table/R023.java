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
 * 债券质押比例规则
 *
 * @author 向鹏
 * @date 2019/9/18 18:23
 */
@Slf4j
@Getter
@Setter
@NoArgsConstructor
public class R023 extends RuleResultTable {

    public static List<HeaderParam> getHeaderParam() {
        List<HeaderParam> headers = new ArrayList<>();
        //headers.add(new HeaderParam("ruleName", "规则名称"));
        //headers.add(new HeaderParam(RuleConst.F_FUNDCODE, "基金代码"));
        headers.add(new HeaderParam(RuleConst.FUND_NAME, "基金名称"));
        headers.add(new HeaderParam(RuleConst.TRADER, "交易员名称"));
        headers.add(new HeaderParam(RuleConst.REPO_CODE, "回购代码"));
        headers.add(new HeaderParam(RuleConst.REPO_RATE, "回购利率"));
        headers.add(new HeaderParam(RuleConst.REPO_AMOUNT, "回购金额"));
        headers.add(new HeaderParam(RuleConst.RIVAL_TRADER_NAME, "对手方交易员"));
        headers.add(new HeaderParam(RuleConst.BOND_CODE, "质押券代码"));
        headers.add(new HeaderParam(RuleConst.BOND_NAME, "质押券名称"));
        headers.add(new HeaderParam(RuleConst.BOND_TYPE, "质押券类别"));
        headers.add(new HeaderParam(RuleConst.BOND_RATING, "质押券评级"));
        headers.add(new HeaderParam(RuleConst.CALCULATE_BOND_PLEDGE_RATIO, "计算质押率"));
        headers.add(new HeaderParam(RuleConst.BOND_PLEDGE_RATIO, "报价质押率"));
        headers.add(new HeaderParam(RuleConst.DIFFERENCE, "误差"));

        //headers.add(new HeaderParam(RuleConst.ENTRUST_DIRECTION, "委托方向"));

        return headers;
    }

    public R023(ResultAllV allV, List<RuleResultFactor> factors) {
        // 组装公共字段信息
        super(allV);
        // 组装特殊字段信息
        Map<String, String> map = new HashMap<>();
        for (RuleResultFactor factor : factors) {
            map.put(factor.getFactorKey(), factor.getFactorValue());
        }
        this.fundCode = map.get(RuleConst.F_FUNDCODE);
        this.fundName = map.get(RuleConst.FUND_NAME);
        this.repoCode = map.get(RuleConst.REPO_CODE);
        this.bondCode = map.get(RuleConst.BOND_CODE);
        this.bondName = map.get(RuleConst.BOND_NAME);
        this.entrustDirection = map.get(RuleConst.ENTRUST_DIRECTION);

        this.bondRating = map.get(RuleConst.BOND_RATING);
        this.bondType = map.get(RuleConst.BOND_TYPE);
        this.trader = map.get(RuleConst.TRADER);
        this.rivalTraderName = map.get(RuleConst.RIVAL_TRADER_NAME);

        this.repoRate = Double.valueOf(map.get(RuleConst.REPO_RATE));
        this.repoAmount = Double.valueOf(map.get(RuleConst.REPO_AMOUNT));
        this.bondPledgeRatio = Double.valueOf(map.get(RuleConst.BOND_PLEDGE_RATIO));
        this.calculateBondPledgeRatio = Double.valueOf(map.get(RuleConst.CALCULATE_BOND_PLEDGE_RATIO));
        this.difference=Double.valueOf(map.get(RuleConst.DIFFERENCE));
        log.debug("< " + this.getClass().getSimpleName() + ">" + " : End of conversion. ");
    }

    //产品代码
    private String fundCode;
    //产品名称
    private String fundName;
    //回购代码
    private String repoCode;
    //质押券代码
    private String bondCode;
    //质押券名称
    private String bondName;

    //委托方向
    private String entrustDirection;
    //委托金额
    private Double repoRate;
    //委托价格
    private Double repoAmount;
    //质押比例
    private Double bondPledgeRatio;
    //计算质押比例
    private Double calculateBondPledgeRatio;
    //债券评级
    private String bondRating;
    //债券类型
    private String bondType;
    //本方交易员
    private String trader;
    //对方交易员
    private String rivalTraderName;
    //误差
    private Double difference;
}
