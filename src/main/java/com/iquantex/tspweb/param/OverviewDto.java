package com.iquantex.tspweb.param;

import lombok.Data;
import lombok.ToString;
import org.apache.ibatis.type.JdbcType;
import tk.mybatis.mapper.annotation.ColumnType;

import javax.persistence.Column;
import java.util.Date;

/**
 * @author shenzhengjie
 * @date 2019/3/15 15:05
 */
@Data
@ToString
public class OverviewDto {

    /**
     * 规则id
     */
    private String ruleId;

    /**
     * 规则名称
     */
    private String ruleName;

    /**
     * 规则描述
     */
    private String ruleInfo;

    /**
     * 处理结果id
     */
    private Long ruleResultId;

    /**
     * 产品编码
     */
    private String fundCode;

    /**
     * 触发时间
     */
    private Date checkTime;
}
