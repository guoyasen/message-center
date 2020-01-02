package com.iquantex.tspweb.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 折线图
 *
 * @author xiangpeng;
 * @date 2019/04/11-16:53;
 * @Copyright: Copyright (c) 2018 Fullgoal Fund Management  Co., Ltd. Inc. All rights reserved.
 */
@Data
@Setter
@Getter
public class LineChartData implements Serializable {
    private String name;
    private List<ValueBean> value;

    public LineChartData(String name) {
        this.name = name;
        this.value = new ArrayList<>();
    }

    public  void  addValue(String xDisplay, Double value) {
        this.value.add(new ValueBean(xDisplay, value));
    }

    @Getter
    @Setter
    public static class ValueBean {
        private String xDisplay;
        private Double value;

        public ValueBean(String xDisplay, Double value) {
            this.xDisplay = xDisplay;
            this.value = value;
        }
    }
}
