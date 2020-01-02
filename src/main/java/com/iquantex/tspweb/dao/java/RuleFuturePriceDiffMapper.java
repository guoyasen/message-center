package com.iquantex.tspweb.dao.java;

import com.iquantex.tspweb.model.RuleFuturePriceDiff;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface RuleFuturePriceDiffMapper extends Mapper<RuleFuturePriceDiff> {
    List<RuleFuturePriceDiff> selectByKey(@Param("userId")String userId, @Param("futureACode")String futureACode, @Param("futureBCode")String futureBCode);
    Integer insertRuleFuturePriceDiff(RuleFuturePriceDiff ruleFuturePriceDiff);
    Integer deleteRuleFuturePriceDiff(RuleFuturePriceDiff ruleFuturePriceDiff);
}