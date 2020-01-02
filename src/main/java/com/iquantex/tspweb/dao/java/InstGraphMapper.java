package com.iquantex.tspweb.dao.java;

import com.iquantex.tspweb.model.InstGraph;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

public interface InstGraphMapper extends Mapper<InstGraph> {
    @Select("select * from inst_graph where instcode = #{instcode}")
    InstGraph getInstGraph(@Param("instcode") String instcode);
}