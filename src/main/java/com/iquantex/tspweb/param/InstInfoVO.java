package com.iquantex.tspweb.param;


import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
public class InstInfoVO {
    /**
     * 指令编号
     */
    private String instCode;

    /**
     * 基金序号
     */
    private String fundCode;

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
     * 委托方向<>stockBuy=1=股票买入&stockSell=2=股票卖出&bondBuy=3=债券买入&bondSell=4=债券卖出
     */
    private String tradeTypeCode;

    /**
     * 指令数量
     */
    private Long qty;

    /**
     * O32证券代码
     */
    private String o32SecuCode;

    /**
     * O32证券名称
     */
    private String o32SecuName;
    /**
     * 市场名称
     */
    private String marketName;

    /**
     * 指令价格
     */
    private Double price;

    /**
     * 系统时间
     */
    private Date systemTime;
}
