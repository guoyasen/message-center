package com.iquantex.tspweb.table;

import com.iquantex.tspweb.common.DateUtil;
import com.iquantex.tspweb.model.ResultAllV;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import static com.iquantex.tspweb.common.DateUtil.CURRENT_DATE_TIME;

/**
 * table 父类
 *
 * @author shenzhengjie
 * @date 2019/1/9 14:40
 */
@Data
@Slf4j
@NoArgsConstructor
public class RuleResultTable {

    // 处理结果和规则要素
    /**
     * 处理结果id
     */
    private Long ruleResultId;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 规则id
     */
    private String ruleId;

    /**
     * typeID
     */
    private String typeId;

    /**
     * 规则名称
     */
    private String ruleName;
    /**
     * 触发时间
     */
    private String checkTime;
    /**
     * 处理人
     */
    private String dealName;
    /**
     * 处理时间
     */
    private String dealTime;

    /**
     * 是否发送
     * @param allV
     */
    private Integer sendStatus;

    /**
     * 发送人
     * @param allV
     */
    private String sendName;

    /**
     * 发送时间
     * @param allV
     */
    private String sendTime;


    RuleResultTable(ResultAllV allV) {
        log.debug("< " + this.getClass().getSimpleName() + ">" + " : Start conversion. ");
        this.ruleResultId = allV.getRuleResultId();
        this.status = allV.getStatus();
        this.ruleId = allV.getRuleId();
        this.typeId = allV.getTypeId();
        this.ruleName = allV.getName();
        this.checkTime = DateUtil.format(allV.getCheckTime(), CURRENT_DATE_TIME);
        this.dealName = allV.getDealName();
        this.dealTime = DateUtil.format(allV.getDealTime(), CURRENT_DATE_TIME);
        this.sendStatus=allV.getSendStatus();
        this.sendName=allV.getSendName();
        this.sendTime=DateUtil.format(allV.getSendTime(), CURRENT_DATE_TIME);
    }
}
