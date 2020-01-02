package com.iquantex.tspweb.service;

import com.iquantex.tspweb.dao.java.InstInfoMapper;
import com.iquantex.tspweb.param.InstInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author shenzhengjie
 * @date 2019/4/18 14:12
 */
@Service
public class InstInfoService {

    @Autowired
    private InstInfoMapper instInfoDao;

    public List<InstInfoVO> query(String fundCode, String secuCode, String marketName
            , String instCreateName, String instExecutionName, String tradeTypeCode) {
        return instInfoDao.query(fundCode, secuCode, marketName, instCreateName, instExecutionName, tradeTypeCode);
    }
}
