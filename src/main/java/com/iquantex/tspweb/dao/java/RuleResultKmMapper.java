package com.iquantex.tspweb.dao.java;

import com.iquantex.tspweb.model.RuleResultKm;
import com.iquantex.tspweb.param.Deal;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface RuleResultKmMapper extends Mapper<RuleResultKm> {
    List<RuleResultKm> selectByRuleResultIds(@Param("list") List<Deal> list);
}