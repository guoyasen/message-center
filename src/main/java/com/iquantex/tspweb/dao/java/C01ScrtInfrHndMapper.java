package com.iquantex.tspweb.dao.java;

import com.iquantex.tspweb.model.BondInteriorInfo;
import com.iquantex.tspweb.model.C01ScrtInfrHnd;
import com.iquantex.tspweb.model.Future;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface C01ScrtInfrHndMapper extends Mapper<C01ScrtInfrHnd> {
    List<C01ScrtInfrHnd> selectByPrprNmAndPrprVl();
    List<BondInteriorInfo> selectBondInteriorInfo();
    List<Future> selectAllFutures();
}