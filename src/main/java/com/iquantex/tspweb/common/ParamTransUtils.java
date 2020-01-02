package com.iquantex.tspweb.common;

import com.iquantex.tspweb.model.*;
import com.iquantex.tspweb.param.RuleResultInstVO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParamTransUtils {

    /**
     * 组装RuleResultInstVO
     *
     * @param instInfo
     * @param ruleResult
     * @param rule
     * @param factorList
     * @return 如果参数中有一个为null，则返回null；否则返回RuleResultInstVO
     */
    public static RuleResultInstVO ruleResultInstVoTrans(InstInfo instInfo, RuleResult ruleResult, Rule rule, List<RuleResultFactor> factorList) {
        if (null == instInfo || null == ruleResult || null == rule) {
            return null;
        }
        Map<String, String> map = new HashMap<>();
        for (RuleResultFactor factor : factorList) {
            map.put(factor.getFactorKey(), factor.getFactorValue());
        }
        RuleResultInstVO instVO = new RuleResultInstVO();
        instVO.setInstCode(instInfo.getInstCode());
        instVO.setOmbinedCode(instInfo.getOmbinedCode());
        instVO.setFundCode(instInfo.getFundCode());
        instVO.setTradeDate(instInfo.getTradeDate());
        instVO.setInstCreateName(instInfo.getInstCreateName());
        instVO.setInstExecutionName(instInfo.getInstExecutionName());
        instVO.setSecuCode(instInfo.getSecuCode());
        instVO.setTradeTypeCode(instInfo.getTradeTypeCode());
        instVO.setPrice(instInfo.getAmt());
        instVO.setQty(instInfo.getQty());
        instVO.setSecuType(instInfo.getSecuType());
        instVO.setRuleId(ruleResult.getRuleId());
        instVO.setRuleName(rule.getName());
        instVO.setThreshold(Double.valueOf(map.get("threshold")));
        instVO.setCalcValue(Double.valueOf(map.get("calc_value")));
        instVO.setTypeId(rule.getTypeId());
        instVO.setStatus(ruleResult.getStatus());
        instVO.setDealTime(ruleResult.getDealTime());
        instVO.setAlarmTime(ruleResult.getCheckTime());
        instVO.setDealName(ruleResult.getDealName());
        instVO.setAmt(instInfo.getAmt() * instInfo.getQty());
        return instVO;
    }

    /**
     * RuleResult + InstInfo 合并为 allV.set
     *
     * @param ruleResult
     * @param instInfo
     */
    public static ResultAllV resultAllVTrans(RuleResult ruleResult, InstInfo instInfo, Rule rule) {
        ResultAllV allV = new ResultAllV();
        // 设置ruleResult信息
        allV.setRuleResultId(ruleResult.getRuleResultId());
        allV.setRuleId(ruleResult.getRuleId());
        allV.setResultStatus(ruleResult.getResultStatus());
        allV.setInstId(ruleResult.getInstId());
        allV.setCheckTime(ruleResult.getCheckTime());
        allV.setDealTime(ruleResult.getDealTime());
        allV.setStatus(ruleResult.getStatus());
        allV.setDealName(ruleResult.getDealName());
        allV.setInstStatus(ruleResult.getInstStatus());
        // 设置instInfo信息
        allV.setInstCode(instInfo.getInstCode());
        allV.setOmbinedCode(instInfo.getOmbinedCode());
        allV.setTradeDate(instInfo.getTradeDate());
        allV.setFundCode(instInfo.getFundCode());
        allV.setInstCreateName(instInfo.getInstCreateName());
        allV.setInstExecutionName(instInfo.getInstExecutionName());
        allV.setSecuCode(instInfo.getSecuCode());
        allV.setTradeTypeCode(instInfo.getTradeTypeCode());
        allV.setAmt(instInfo.getAmt());
        allV.setQty(instInfo.getQty());
        allV.setSecuType(instInfo.getSecuType());
        allV.setO32SecuCode(instInfo.getO32SecuCode());
        allV.setO32SecuName(instInfo.getO32SecuName());
        allV.setIsLongInst(instInfo.getIsLongInst());
        allV.setPrice(instInfo.getPrice());
        // 设置rule信息
        allV.setId(rule.getId());
        allV.setName(rule.getName());
        allV.setTypeId(rule.getTypeId());
        allV.setCueFormat(rule.getCueFormat());
        allV.setInfo(rule.getInfo());
        allV.setStartTime(rule.getStartTime());
        allV.setEndTime(rule.getEndTime());
        allV.setTypeName(rule.getName());
        allV.setSpeed(rule.getSpeed());
        allV.setVolume(rule.getVolume());
        return allV;
    }
}
