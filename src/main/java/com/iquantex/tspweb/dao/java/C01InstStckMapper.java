package com.iquantex.tspweb.dao.java;


import com.iquantex.tspweb.model.C01InstStck;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface C01InstStckMapper extends Mapper<C01InstStck> {

    /**
     * 获取所有的 C01指令证券信息
     *
     * @return list
     */
    List<C01InstStck> getAll();
}