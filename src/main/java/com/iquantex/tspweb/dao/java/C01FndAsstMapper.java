package com.iquantex.tspweb.dao.java;

import com.iquantex.tspweb.model.C01FndAsst;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface C01FndAsstMapper extends Mapper<C01FndAsst> {

    /**
     * 获取所有 C01基金资产明细
     * @return
     */
    public List<C01FndAsst> getAll();
}