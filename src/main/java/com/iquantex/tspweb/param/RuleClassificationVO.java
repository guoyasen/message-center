package com.iquantex.tspweb.param;

import lombok.Data;
import lombok.ToString;

/***
 * @author shenZhengJie
 * @date 2018/12/19
 */
@Data
@ToString
public class RuleClassificationVO {

    /**
     * 规则id
     */
    private String ruleId;

    /**
     * 规则名称
     */
    private String ruleName;

    /**
     * 告警未处理数量
     */
    private Integer alarmNoHandleNumber;

    /**
     * 告警处理数量
     */
    private Integer alarmHandleNumber;
}
