package com.iquantex.tspweb.dao.java;

import com.iquantex.tspweb.model.InstInfo;
import com.iquantex.tspweb.param.DictoryVO;
import com.iquantex.tspweb.param.InstInfoVO;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;


public interface InstInfoMapper extends Mapper<InstInfo> {

    List<DictoryVO> getO32SecuCodeDict(@Param("code") String code, @Param("name") String name);

    List<InstInfoVO> query(@Param("fundCode") String fundCode
            , @Param("secuCode") String secuCode
            , @Param("marketName") String marketName
            , @Param("instCreateName") String instCreateName
            , @Param("instExecutionName") String instExecutionName
            , @Param("tradeTypeCode") String tradeTypeCode);
}