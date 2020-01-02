package com.iquantex.tspweb.param;

import lombok.Data;
import lombok.ToString;

/**
 * @author shenZhengJie
 * @date 2018/12/19
 */
@Data
@ToString
public class FundMonitoringStatisticsVO {
    /**
     * 证券编码
     */
    private String fundCode;

    /**
     * 触警数量
     */
    private Integer alarmNumber;

    /**
     * 触警比例
     */
    private Double alarmPer;

    /**
     * 买入触警数量
     */
    private Integer buyAlarmNumber;

    /**
     * 卖出触警数量
     */
    private Integer sellAlarmNumber;
}
