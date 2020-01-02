package com.iquantex.tspweb.dao.java;

import com.iquantex.tspweb.model.C99StndCd;
import com.iquantex.tspweb.param.DictoryVO;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface C99StndCdMapper extends Mapper<C99StndCd> {

    List<DictoryVO> getInstCreateNameDict(@Param("code") String code, @Param("name") String name);
}