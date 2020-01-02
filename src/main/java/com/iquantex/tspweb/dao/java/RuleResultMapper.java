package com.iquantex.tspweb.dao.java;

import com.iquantex.tspweb.model.ResultAllV;
import com.iquantex.tspweb.model.RuleResult;
import com.iquantex.tspweb.model.RuleResultFactor;
import com.iquantex.tspweb.param.OverviewDto;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface RuleResultMapper extends Mapper<RuleResult> {


    /**
     * 规则检查详情
     * @param ruleResultId 检查结果id
     * @param ruleId 规则id
     * @param status 处理状态
     */
    List<RuleResultFactor> getRuleResultFactor(@Param("ruleResultId") Long ruleResultId,
                                               @Param("ruleId") String ruleId,
                                               @Param("status") Integer status);


    /**
     * 由于目前使用前台搜索 ，所有该方法目前无用
     * 规则检查详情
     * @param ruleId
     * @param secuCode
     * @param tradeTypeCode
     * @param instCreateName
     * @param fundCode
     * @param list
     */
//    List<RuleResultFactor> getRuleResultFactor(@Param("ruleResultId") Long ruleResultId,
//                                               @Param("ruleId") String ruleId,
//                                               @Param("instId") String instId,
//                                               @Param("secuCode") String secuCode,
//                                               @Param("tradeTypeCode") Integer tradeTypeCode,
//                                               @Param("instCreateName") String instCreateName,
//                                               @Param("fundCode") String fundCode,
//                                               @Param("list") List<String> list,
//                                               @Param("status") Integer status);

    /**
     * 获取RuleResult + InstInfo
     * @param ruleId
     * @param ruleResultId
     * @param status
     */
    List<ResultAllV> getResultAllV(@Param("ruleResultId") Long ruleResultId,
                                   @Param("ruleId") String ruleId,
                                   @Param("status") Integer status);


    /**
     * 获取RuleResult + InstInfo
     * 由于目前使用前台搜索 ，所有该方法目前无用
     * @param ruleId
     * @param secuCode
     * @param tradeTypeCode
     * @param instCreateName
     * @param fundCode
     * @param list
     */
//    List<ResultAllV> getResultAllV(@Param("ruleResultId") Long ruleResultId,
//                                   @Param("ruleId") String ruleId,
//                                   @Param("instId") String instId,
//                                   @Param("secuCode") String secuCode,
//                                   @Param("tradeTypeCode") Integer tradeTypeCode,
//                                   @Param("instCreateName") String instCreateName,
//                                   @Param("fundCode") String fundCode,
//                                   @Param("list") List<String> list,
//                                   @Param("status") Integer status);


    /**
     * 查询概况
     *
     * @return
     */
    List<OverviewDto> selectOverview();
}