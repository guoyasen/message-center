package com.iquantex.tspweb.dao.java;

import com.iquantex.tspweb.model.EtfRuleResultsNewestVw;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface EtfRuleResultsNewestVwMapper extends Mapper<EtfRuleResultsNewestVw> {

    List<EtfRuleResultsNewestVw> queryNewestRuleResultsByFundCode(@Param("fundCode") String fundCode);

}