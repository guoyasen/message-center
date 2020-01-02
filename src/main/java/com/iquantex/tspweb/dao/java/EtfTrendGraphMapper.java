package com.iquantex.tspweb.dao.java;

import com.iquantex.tspweb.model.EtfTrendGraph;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface EtfTrendGraphMapper extends Mapper<EtfTrendGraph> {
    List<EtfTrendGraph> selectByFundCd(@Param("id") String id);
}