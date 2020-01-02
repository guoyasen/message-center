package com.iquantex.tspweb.dao.java;

import com.iquantex.tspweb.model.C02AShrBscInfr;
import com.iquantex.tspweb.param.DictoryVO;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface C02AShrBscInfrMapper extends Mapper<C02AShrBscInfr> {
    List<DictoryVO> getSecuDict(@Param("code") String code, @Param("name") String name);
}