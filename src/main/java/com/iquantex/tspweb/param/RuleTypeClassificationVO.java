package com.iquantex.tspweb.param;

import lombok.Data;
import lombok.ToString;

/**
 * @author shenzhengjie
 * @date 2018/12/25 21:19
 */
@Data
@ToString
public class RuleTypeClassificationVO {

    /**
     * 类型id
     */
    private String typeId;

    /**
     * 类型名称
     */
    private String typeName;

    /**
     * 告警未处理数量
     */
    private Integer alarmNoHandleNumber;

    /**
     * 告警处理数量
     */
    private Integer alarmHandleNumber;
}
