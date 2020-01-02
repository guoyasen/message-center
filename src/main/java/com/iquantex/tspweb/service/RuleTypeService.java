package com.iquantex.tspweb.service;

import com.iquantex.tspweb.dao.java.RuleTypeMapper;
import com.iquantex.tspweb.model.RuleType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by szhengjie on 2018/12/13 .
 */
@Service
public class RuleTypeService {
    private static final Logger LOG = LoggerFactory.getLogger(RuleTypeService.class);

    @Autowired
    private RuleTypeMapper ruleTypeDao;

    public List<RuleType> getTypeById(String typeId) {
        return ruleTypeDao.selectBy(RuleType.f_id, typeId);
    }
}
