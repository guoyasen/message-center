package com.iquantex.tspweb.model;

import lombok.*;

import java.beans.ConstructorProperties;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

//用户自定义规则类
@Getter
@Setter
public class RuleCustomize {
    //用户id
    private String userId;
    //规则id
    private String ruleId;
    //规则名称
    private String ruleName;
    //提示描述
    private String cueFormat;
    //语音描述
    private String info;
    //语速
    private BigDecimal speed;
    //音量
    private BigDecimal volume;
    //规则因子
    private List<factorBean> factors;

    @ConstructorProperties({"userId", "ruleId", "ruleName", "cueFormat", "info", "speed", "volume", "factor", "factorName"})
    public RuleCustomize(String userId, String ruleId, String ruleName, String cueFormat, String info, BigDecimal speed, BigDecimal volume, String factor, String factorName) {
        this.userId = userId;
        this.ruleId = ruleId;
        this.ruleName = ruleName;
        this.cueFormat = cueFormat;
        this.info = info;
        this.speed = speed;
        this.volume = volume;
        if (factor != null && factorName != null) {
            if (this.factors == null) {
                this.factors = new ArrayList<>();
            }
            String factors[] = factor.split(",");
            String factorNames[] = factorName.split(",");
            for (int i = 0; i < factors.length && i < factorNames.length; i++) {
                this.factors.add(new factorBean(factors[i], factorNames[i]));
            }
        }
    }


    @Getter
    @Setter
    public static class factorBean {
        private String factor;
        private String factorName;

        @ConstructorProperties({"factor", "factorName"})
        public factorBean(String factor, String factorName) {
            this.factor = factor;
            this.factorName = factorName;
        }

        public factorBean() {
        }
    }


}
