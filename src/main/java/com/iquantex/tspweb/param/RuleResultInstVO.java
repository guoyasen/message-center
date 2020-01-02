package com.iquantex.tspweb.param;


import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 *
 */
@Data
@ToString
public class RuleResultInstVO {
    /**
     * 指令编号
     */
    private String instCode;
    /**
     * 组合序号
     */
    private String ombinedCode;
    /**
     * 基金序号
     */
    private String fundCode;
    /**
     * 交易日期
     */
    private Long tradeDate;
    /**
     * 指令下达人
     */
    private String instCreateName;
    /**
     * 指令执行人
     */
    private String instExecutionName;
    /**
     * 证券代码
     */
    private String secuCode;
    /**
     * 委托方向<>buy=0=买&sell=1=卖
     */
    private Integer tradeTypeCode;
    /**
     * 指令价格
     */
    private Double price;
    /**
     * 指令数量
     */
    private Long qty;
    /**
     * 投资类型<>trade=1=可交易&maturity=2=持有到期&canSell=3=可供出售&other=4=贷款和应收款项
     */
    private Integer secuType;
    /**
     * 规则Id
     */
    private String ruleId;
    /**
     * 规则名称
     */
    private String ruleName;
    /**
     * 阈值
     */
    private Double threshold;
    /**
     * 实际值
     */
    private Double calcValue;

    /**
     * 规则类型ID
     */
    private String typeId;

    /**
     * 状态<>noHandle=0=未处理&handle=1=处理&hang=2=挂起
     */
    private Integer status;

    /**
     * 处理时间
     */
    private Date dealTime;

    /**
     * 触发时间 TRIGGER_TIME
     */
    private Date alarmTime;

    /**
     * 处理人
     */
    private String dealName;

    /**
     * 指令金额
     */
    private Double amt;

    public void setResultInfo(String resultInfo) {
        JSONObject jsonObject = JSONObject.parseObject(resultInfo);
        this.threshold = jsonObject.getDouble("threshold");
        this.calcValue = jsonObject.getDouble("calc_value");
    }

    /**
     * 买
     */
    public static final Integer c_tradeTypeCode_buy = 0;

    /**
     * 卖
     */
    public static final Integer c_tradeTypeCode_sell = 1;

    /**
     * 可交易
     */
    public static final Integer c_secuType_trade = 1;

    /**
     * 持有到期
     */
    public static final Integer c_secuType_maturity = 2;

    /**
     * 可供出售
     */
    public static final Integer c_secuType_canSell = 3;

    /**
     * 贷款和应收款项
     */
    public static final Integer c_secuType_other = 4;

}