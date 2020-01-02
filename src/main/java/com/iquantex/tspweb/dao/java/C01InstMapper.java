package com.iquantex.tspweb.dao.java;


import com.iquantex.tspweb.model.C01Inst;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface C01InstMapper extends Mapper<C01Inst> {

    /**
     * 获取所有的 C01指令信息
     *
     * @return list
     */
    List<C01Inst> getAll();
}