package com.iquantex.tspweb.dao.java;

import com.iquantex.tspweb.model.Rule;
import com.iquantex.tspweb.param.*;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface RuleMapper extends Mapper<Rule> {

    /**
     * 获取对应条款类型下的触警条款数量
     *
     * @param typeId 条款类型
     * @return
     */
    @Select("select count(*)\n" +
            "    from RULE a left join RULE_RESULT b on a.id = b.RULE_ID\n" +
            "    where a.TYPE_ID = #{typeId} AND b.RESULT_STATUS = 2")
    Long getClauseTypeTriggerNum(@Param("typeId") String typeId);

    /**
     * 规则分类监控统计
     */
    List<RuleClassificationVO> getRuleClassification();

    /**
     * 规则类型分类监控统计
     */
    List<RuleTypeClassificationVO> getRuleTypeClassification(@Param("ruleId") String ruleId);

    /**
     * 规则市场分类监控统计
     */
    List<RuleMarketClassificationVO> getRuleMarketClassification(@Param("typeId") String typeId);

    /**
     * 按产品查看前N条记录
     *
     * @param typeId     类型id
     * @param num        前num条
     * @param marketCode 市场编码
     */
    List<FundMonitoringStatisticsVO> getFundMonitoringStatistics(@Param("typeId") String typeId, @Param("marketCode") String marketCode, @Param("num") Integer num);

    /**
     * 按证券查看前N条记录
     *
     * @param typeId     类型id
     * @param num        前num条
     * @param marketCode 市场编码
     */
    List<SecuMonitoringStatisticsVO> getSecuMonitoringStatistics(@Param("typeId") String typeId, @Param("marketCode") String marketCode, @Param("num") Integer num);
}