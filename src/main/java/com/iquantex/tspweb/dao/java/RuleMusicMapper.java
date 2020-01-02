package com.iquantex.tspweb.dao.java;

import com.iquantex.tspweb.model.RuleMusic;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface RuleMusicMapper extends Mapper<RuleMusic> {
    Integer updateRuleMusic(RuleMusic ruleMusic);
    List<RuleMusic> getRuleMusic(@Param("futuresType")String futuresType);
}