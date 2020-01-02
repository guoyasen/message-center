package com.iquantex.tspweb.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Data
@Setter
@Getter
public class TraderBpsCompletedRatio implements Serializable {
    //市场有效成交量
    private Double effectiveAvgAmt;
    //指令累计成交量
    private Double instAccumulatedDealAmt;
    //市占率
    private String completedRatio;
    private List<LineChartData> list;
}
