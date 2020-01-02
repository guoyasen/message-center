package com.iquantex.tspweb.service;


import com.iquantex.tspweb.dao.java.*;
import com.iquantex.tspweb.model.C01ScrtInfrHnd;
import com.iquantex.tspweb.model.C99StndCd;
import com.iquantex.tspweb.model.Future;
import com.iquantex.tspweb.param.DictoryVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DictoryService {


    private static final Logger LOG = LoggerFactory.getLogger(DictoryService.class);

    @Autowired
    private C01FndIntrInfrMapper c01FndIntrInfrDao;

    @Autowired
    private C99StndCdMapper c99StndCdDao;

    @Autowired
    private C02AShrBscInfrMapper c02AShrBscInfrDao;

    @Autowired
    private InstInfoMapper instInfoDao;

    @Autowired
    private C01ScrtInfrHndMapper c01ScrtInfrHndDao;

    /**
     * 基金名称和基金代码字典查询
     * key and name is null : all
     * key is value : name
     * name is value : key
     *
     * @return
     */
    public List<DictoryVO> getFundDict(String code, String name) {
        return c01FndIntrInfrDao.getFundDict(code, name);
    }

    /**
     * 投资经理名字字典查询
     *
     * @return 投资经理名字典列表
     */
    public List<DictoryVO> getInstCreateNameDict(String code, String name) {
        return c99StndCdDao.getInstCreateNameDict(code, name);
    }

    /**
     * 证券名称字典
     *
     * @return 投资经理名字典列表
     */
    public List<DictoryVO> getSecuCodeDict(String code, String name) {
        return c02AShrBscInfrDao.getSecuDict(code, name);
    }

    /**
     * o32SecuCode => marketName
     */
    public List<DictoryVO> getO32SecuCodeDict(String code, String name) {
        return instInfoDao.getO32SecuCodeDict(code, name);
    }

    /**
     * 中金所所有期货查询
     */
    public List<Future> getAllFuture(){
        return c01ScrtInfrHndDao.selectAllFutures();
    }

}
