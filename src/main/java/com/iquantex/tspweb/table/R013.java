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
 * 可用券头寸
 *
 * @author shenzhengjie
 * @date 2019/4/15 17:09
 */
@Slf4j
@Getter
@Setter
@NoArgsConstructor
public class R013 extends RuleResultTable {

    public static List<HeaderParam> getHeaderParam() {
        List<HeaderParam> headers = new ArrayList<>();
        //headers.add(new HeaderParam("ruleName", "规则名称"));
        headers.add(new HeaderParam(RuleConst.TRADE_DATE, "交易日期"));
        headers.add(new HeaderParam(InstInfo.f_fundCode, "产品代码"));
        headers.add(new HeaderParam(RuleConst.F_FUNDNAME, "产品名称"));
        headers.add(new HeaderParam(RuleConst.COVERAGE, "覆盖度(百万)"));

        headers.add(new HeaderParam(RuleConst.STOCK_MARKET_SECU_CODE, "证券代码"));
        headers.add(new HeaderParam(RuleConst.STOCK_MARKET_SECU_NAME, "证券名称"));

        headers.add(new HeaderParam(RuleConst.PCF_STOCK_NUMBER, "PCF证券数量"));
        headers.add(new HeaderParam(RuleConst.POSITION_STOCK_NUMBER, "持仓证券数量"));
        headers.add(new HeaderParam(RuleConst.RATIO, "数量占比(%)"));
        headers.add(new HeaderParam(RuleConst.RATIO_THRESHOLD, "数量占比阈值"));

        headers.add(new HeaderParam(RuleResult.f_checkTime, "触发时间"));
        headers.add(new HeaderParam(RuleResult.f_dealName, "处理人"));
        headers.add(new HeaderParam(RuleResult.f_dealTime, "处理时间"));
        return headers;
    }

    public R013(ResultAllV allV, List<RuleResultFactor> factors) {
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
        this.coverage = map.get(RuleConst.COVERAGE);
        this.ratioThreshold=map.get(RuleConst.RATIO_THRESHOLD);

        String stockCode[]=map.get(RuleConst.STOCK_MARKET_SECU_CODE).split(",");
        String stockName[]=map.get(RuleConst.STOCK_MARKET_SECU_NAME).split(",");
        String pcfStockNumber[] = map.get(RuleConst.PCF_STOCK_NUMBER).split(",");
        String positionStockNumber[] = map.get(RuleConst.POSITION_STOCK_NUMBER).split(",");
        String ratio[] = map.get(RuleConst.RATIO).split(",");
        String maxRedemptionShares[] = map.get(RuleConst.MAX_REDEMPTION_SHARES).split(",");
        String isSecurityStopped[] = map.get(RuleConst.IS_SECURITY_STOPPED).split(",");

        for(int i=0;i<stockCode.length;i++){
            if(this.patchList==null)
                this.patchList=new ArrayList<>();
            this.patchList.add(new patch(stockCode[i],stockName[i],pcfStockNumber[i],positionStockNumber[i],
                    ratio[i],maxRedemptionShares[i],isSecurityStopped[i]));
        }

        log.debug("< " + this.getClass().getSimpleName() + ">" + " : End of conversion. ");
    }

    /**
     * 交易日期
     */
    private String tradeDate;

    /**
     * 产品编码
     */
    private String fundCode;

    /**
     * 产品名称
     */
    private String fundName;

    /**
     * 覆盖度
     */
    private String coverage;

    /**
     * 可用券信息
     */
    private List<patch> patchList;

    /*** 数量占比阈值*/
    private String ratioThreshold;

    @Getter
    @Setter
    public static class patch {
        /*** 证券代码*/
        private String secuCode;

        /*** 证券名称*/
        private String secuName;

        /*** PCF证券数量*/
        private String pcfStockNumber;

        /*** 持仓证券数量*/
        private String positionStockNumber;

        /*** 数量占比*/
        private String ratio;

        /*** 最大赎回数量*/
        private String maxRedemptionShares;

        /*** 是否停牌*/
        private String isSecurityStopped;


        public patch(String secuCode, String secuName, String pcfStockNumber, String positionStockNumber, String ratio
                , String maxRedemptionShares, String isSecurityStopped) {
            this.secuCode = secuCode;
            this.secuName = secuName;
            this.pcfStockNumber = pcfStockNumber;
            this.positionStockNumber = positionStockNumber;
            this.ratio = ratio;
            this.maxRedemptionShares = maxRedemptionShares;
            this.isSecurityStopped = isSecurityStopped;
        }
    }
}
