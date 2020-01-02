package com.iquantex.tspweb.dao.java;

import com.iquantex.tspweb.model.C01EtfFndIndxCnsttInfr;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface C01EtfFndIndxCnsttInfrMapper extends Mapper<C01EtfFndIndxCnsttInfr> {
    List<C01EtfFndIndxCnsttInfr> selectByFuncCode(@Param("fundCode") String fundCode);
}