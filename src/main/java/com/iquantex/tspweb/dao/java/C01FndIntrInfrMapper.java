package com.iquantex.tspweb.dao.java;


import com.iquantex.tspweb.model.C01FndIntrInfr;
import com.iquantex.tspweb.param.DictoryVO;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface C01FndIntrInfrMapper extends Mapper<C01FndIntrInfr> {

    List<DictoryVO> getFundDict(@Param("code") String code, @Param("name") String name);
}