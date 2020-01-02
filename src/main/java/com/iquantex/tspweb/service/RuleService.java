package com.iquantex.tspweb.service;

import com.iquantex.tspweb.dao.java.*;
import com.iquantex.tspweb.model.*;
import com.iquantex.tspweb.param.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yanliang on 2018/11/21.
 */
@Service
public class RuleService {
    private static final Logger LOG = LoggerFactory.getLogger(RuleService.class);

    @Autowired
    private RuleMapper ruleDao;

    @Autowired
    private RuleResultMapper ruleResultDao;

    @Autowired
    private RuleTypeMapper ruleTypeDao;

    @Autowired
    private RuleParameterMapper ruleParameterDao;

    @Autowired
    private RuleFuturePriceDiffMapper ruleFuturePriceDiffDao;

    @Autowired
    private RuleMusicMapper ruleMusicDao;
    /**
     * 获取规则列表
     *
     * @param id
     * @return
     */
    public List<Rule> selectRulesList(String id) {
        Example example = new Example(Rule.class);
        example.createCriteria().andEqualTo("id", id);
        List<Rule> rules = ruleDao.selectByExample(example);
        return rules;
    }

    public List<Rule> selectRulesListByIds(List<String> ids) {
        if (null == ids || ids.isEmpty()) {
            return null;
        }
        Example example = new Example(Rule.class);
        example.createCriteria().andIn("id", ids);
        List<Rule> rules = ruleDao.selectByExample(example);
        return rules;
    }

    /**
     * 更新规则
     *
     * @param rule
     * @return
     */
    public int updateRule(Rule rule) {
        return ruleDao.updateByPrimaryKeySelective(rule);
    }

    /**
     * 获取规则组列表详情
     *
     * @return
     */
    public List<RuleVO> getRuleGroups() {
        List<RuleVO> ruleVOList = new ArrayList<>();
        //1. 获取所有规则类型
        List<RuleType> ruleTypes = ruleTypeDao.selectAll();
        for (RuleType type : ruleTypes) {
            RuleVO ruleVO = new RuleVO();
            ruleVO.setTypeId(type.getId());
            ruleVO.setTypeName(type.getName());
            ruleVO.setTriggerNumber(ruleDao.getClauseTypeTriggerNum(type.getId()));
            ruleVOList.add(ruleVO);
        }
        return ruleVOList;
    }

    public List<RuleClassificationVO> getRuleClassification() {
        return ruleDao.getRuleClassification();
    }

    public List<RuleTypeClassificationVO> getRuleTypeClassification() {
        return ruleDao.getRuleTypeClassification(null);
    }

    public List<RuleMarketClassificationVO> getRuleMarketClassification(String typeId) {
        return ruleDao.getRuleMarketClassification(typeId);
    }

    public List<FundMonitoringStatisticsVO> getFundMonitoringStatistics(String typeId, String marketCode, Integer num) {
        return ruleDao.getFundMonitoringStatistics(typeId, marketCode, num);
    }

    public List<SecuMonitoringStatisticsVO> getSecuMonitoringStatistics(String typeId, String marketCode, Integer num) {
        return ruleDao.getSecuMonitoringStatistics(typeId, marketCode, num);
    }

    public List<RuleParameterView> getRuleParameter() {
        return ruleParameterDao.selectRuleParameterView();
    }

    public List<RuleParameterView> getRuleParameterByFundCode(String fundCode) {
        return ruleParameterDao.selectRuleParameterViewByFundCode(fundCode);
    }

    public List<RuleParameterView> getRuleParameterByFundCodeAndRuleId(String fundCode, String ruleId) {
        return ruleParameterDao.selectRuleParameterViewByFundCodeAndRuleId(fundCode, ruleId);
    }

    public RuleParameter getRuleParameter(String fundCode, String ruleId) {
        return ruleParameterDao.selectRuleParameter(fundCode, ruleId);
    }

    public RuleParameterView getRuleParameterView(String fundCode, String ruleId, String paramCode) {
        return ruleParameterDao.selectRuleParameterViewByKey(fundCode, ruleId, paramCode);
    }

    public String addRuleParameter(RuleParameter ruleParameter) {
        try {
            if (ruleParameterDao.existsWithPrimaryKey(ruleParameter)) {
                return "1";
            } else {
                ruleParameterDao.insert(ruleParameter);
                return "0";
            }
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public String updateRuleParameter(RuleParameter ruleParameter) {
        try {
            if (!ruleParameterDao.existsWithPrimaryKey(ruleParameter)) {
                return "1";
            } else {
                ruleParameterDao.updateRuleParameter(ruleParameter);
                return "0";
            }
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public String deleteRuleParameter(RuleParameter ruleParameter) {
        try {
            if (!ruleParameterDao.existsWithPrimaryKey(ruleParameter)) {
                return "1";
            } else {
                ruleParameterDao.deleteByPrimaryKey(ruleParameter);
                return "0";
            }
        } catch (Exception e) {
            return e.getMessage();
        }
    }


    /**
     * 用户自定义规则查询
     */
    public List<RuleCustomize> getRuleCustomize(String userId) {
        return ruleParameterDao.selectRuleCustomize(userId);
    }

    /**
     * 用户自定义规则查询
     */
    public RuleCustomize getRuleCustomize(String userId, String ruleId) {
        return ruleParameterDao.selectRuleCustomizeDetail(userId, ruleId);
    }

    /**
     * 用户自定义规则修改
     */
    public Integer updateRuleCustomize(RuleCustomize ruleCustomize) {
        return ruleParameterDao.updateRuleCustomize(ruleCustomize);
    }

    /**
     * 用户自定义接口初始化
     */
    public RuleCustomize getInitRuleCustomize(String userId, String ruleId) {
        return ruleParameterDao.selectInitRuleCustomize(userId, ruleId);
    }

    /**
     * 期货价差规则查询
     */
    public List<RuleFuturePriceDiff> getRuleFuturePriceDiff(String userId, String futureACode, String futureBCode) {
        return ruleFuturePriceDiffDao.selectByKey(userId, futureACode, futureBCode);
    }

    /**
     * 期货价差规则新增
     */
    public Integer insertRuleFuturePriceDiff(RuleFuturePriceDiff ruleFuturePriceDiff) {
        //先检查是否重复添加
        if(ruleFuturePriceDiffDao.selectByKey(ruleFuturePriceDiff.getUserId(),ruleFuturePriceDiff.getFutureaCode(),ruleFuturePriceDiff.getFuturebCode()).size()>0){
            return -1;
        }
        if(ruleFuturePriceDiff.getFutureaCode().equals(ruleFuturePriceDiff.getFuturebCode())){
            return -2;
        }
        return ruleFuturePriceDiffDao.insert(ruleFuturePriceDiff);
    }

    /**
     * 期货价差规则删除
     */
    public Integer deleteRuleFuturePriceDiff(RuleFuturePriceDiff ruleFuturePriceDiff) {
        return ruleFuturePriceDiffDao.deleteRuleFuturePriceDiff(ruleFuturePriceDiff);
    }

    /**
     * 期货价差规则语音修改接口
     */
    public Integer updateRuleMusic(RuleMusic ruleMusic){
        return ruleMusicDao.updateRuleMusic(ruleMusic);
    }

    /**
     * 期货价差规则语音查询接口
     */
    public List<RuleMusic> getRuleMusic(String futuresType){
        return ruleMusicDao.getRuleMusic(futuresType);
    }

}
