package com.iquantex.tspweb.dao.java;

import com.iquantex.tspweb.model.EtfVolumeGraph;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface EtfVolumeGraphMapper extends Mapper<EtfVolumeGraph> {
    List<EtfVolumeGraph> selectByFundCd(@Param("id") String id);

}