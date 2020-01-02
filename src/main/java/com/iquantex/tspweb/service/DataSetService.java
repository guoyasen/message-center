package com.iquantex.tspweb.service;

import com.iquantex.tspweb.dao.java.TradeimpactcostVwMapper;
import com.iquantex.tspweb.model.DataSet.ImpctCost;
import com.iquantex.tspweb.model.TradeimpactcostVw;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by szhengjie on 2018/11/29 .
 */
@Service
public class DataSetService {
    private static final Logger LOG = LoggerFactory.getLogger(DataSetService.class);
    @Autowired
    private TradeimpactcostVwMapper TradeimpactcostVwDao;



    public ImpctCost getImpctCost(){
        ImpctCost impctCost=new ImpctCost();
        List<TradeimpactcostVw> tradeimpactcostVws=TradeimpactcostVwDao.selectAll();
        impctCost.AddLabelValueList(tradeimpactcostVws);
        return impctCost;
    }
}

