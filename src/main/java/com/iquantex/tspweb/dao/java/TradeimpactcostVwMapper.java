package com.iquantex.tspweb.dao.java;

import com.iquantex.tspweb.model.TradeimpactcostVw;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface TradeimpactcostVwMapper extends Mapper<TradeimpactcostVw> {
    List<TradeimpactcostVw> selectAll();
}