package com.iquantex.tspweb.param;

import lombok.Data;
import lombok.ToString;

/**
 * @author shenzhengjie
 * @date 2018/12/26 10:41
 */
@Data
@ToString
public class RuleMarketClassificationVO {

    /**
     * 市场编码
     */
    private String marketCode;

    /**
     * 市场名称
     */
    private String marketName;

    /**
     * 告警未处理数量
     */
    private Integer alarmNoHandleNumber;

    /**
     * 告警处理数量
     */
    private Integer alarmHandleNumber;
}
