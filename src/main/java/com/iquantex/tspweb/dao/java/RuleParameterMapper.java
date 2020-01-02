package com.iquantex.tspweb.dao.java;

import com.iquantex.tspweb.model.RuleCustomize;
import com.iquantex.tspweb.model.RuleParameter;
import com.iquantex.tspweb.model.RuleParameterView;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface RuleParameterMapper extends Mapper<RuleParameter> {
    int updateRuleParameter(RuleParameter ruleParameter);
    RuleParameter selectRuleParameter(@Param("fundCode") String fundCode,@Param("ruleId") String ruleId);
    List<RuleParameterView> selectRuleParameterView();
    List<RuleParameterView> selectRuleParameterViewByFundCode(@Param("fundCode") String fundCode);
    List<RuleParameterView> selectRuleParameterViewByFundCodeAndRuleId(@Param("fundCode") String fundCode,@Param("ruleId") String ruleId);
    RuleParameterView selectRuleParameterViewByKey(@Param("fundCode") String fundCode,@Param("ruleId") String ruleId,@Param("paramCode") String paramCode);
    List<RuleCustomize> selectRuleCustomize(@Param("userId") String userId);
    RuleCustomize selectInitRuleCustomize(@Param("userId") String userId,@Param("ruleId") String ruleId);
    RuleCustomize selectRuleCustomizeDetail(@Param("userId") String userId,@Param("ruleId") String ruleId);
    int updateRuleCustomize(RuleCustomize ruleCustomize);
}