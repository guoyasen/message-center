package com.iquantex.tspweb.dao.java;

import com.iquantex.tspweb.model.C01FndAsstDtl;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface C01FndAsstDtlMapper extends Mapper<C01FndAsstDtl> {

    /**
     * 获取所有 C01基金资产明细
     */
    List<C01FndAsstDtl> getAll();
}