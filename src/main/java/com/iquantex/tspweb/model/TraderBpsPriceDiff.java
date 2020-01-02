package com.iquantex.tspweb.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Data
@Setter
@Getter
public class TraderBpsPriceDiff implements Serializable {
    //指令成交均价
    private Double instDealAvgPrc;
    //市场有效成交均价
    private Double effectiveAvgPrc;
    //价差率
    private String priceDiff;
    private List<LineChartData> list;
}
