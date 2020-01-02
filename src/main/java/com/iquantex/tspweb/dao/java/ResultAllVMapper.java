package com.iquantex.tspweb.dao.java;

import com.iquantex.tspweb.model.ResultAllV;
import com.iquantex.tspweb.param.EtfDeviationLightVO;
import com.iquantex.tspweb.param.LightVO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface ResultAllVMapper extends Mapper<ResultAllV> {
    List<LightVO> queryLight(@Param("lastNum") Integer lastNum);
    List<EtfDeviationLightVO> queryEtfDeviationLight();
}