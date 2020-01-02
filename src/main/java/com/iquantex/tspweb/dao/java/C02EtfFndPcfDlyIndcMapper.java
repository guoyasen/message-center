package com.iquantex.tspweb.dao.java;

import com.iquantex.tspweb.model.C02EtfFndPcfDlyIndc;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface C02EtfFndPcfDlyIndcMapper extends Mapper<C02EtfFndPcfDlyIndc> {

    List<C02EtfFndPcfDlyIndc> selectByFuncCode(@Param("fundCode") String fundCode);
}