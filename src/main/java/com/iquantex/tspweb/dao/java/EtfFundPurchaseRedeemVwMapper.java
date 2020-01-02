package com.iquantex.tspweb.dao.java;

import com.iquantex.tspweb.model.EtfFundPurchaseRedeemVw;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface EtfFundPurchaseRedeemVwMapper extends Mapper<EtfFundPurchaseRedeemVw> {
    List<EtfFundPurchaseRedeemVw> selectByFundCode(@Param("fundCode") String fundCode);
}