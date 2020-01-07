package com.iquantex.tspweb.consumer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.iquantex.tspconst.api.RuleConst;
import com.iquantex.tspevent.RuleInstEvent;
import com.iquantex.tspweb.common.AuthData;
import com.iquantex.tspweb.common.MathUtil;
import com.iquantex.tspweb.common.ParamTransUtils;
import com.iquantex.tspweb.dao.java.RuleMapper;
import com.iquantex.tspweb.model.*;
import com.iquantex.tspweb.param.EtfDeviationLightVO;
import com.iquantex.tspweb.param.InstInfoVO;
import com.iquantex.tspweb.param.LightVO;
import com.iquantex.tspweb.service.UserService;
import com.iquantex.tspweb.table.InstTable;
import com.iquantex.tspweb.table.RuleResultTable;
import com.iquantex.tspweb.table.RuleResultTableUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.*;

/**
 * @Auther: baozi
 * @Date: 2018/11/22 14:42
 * @Description:
 */
@Slf4j
@Service
public class EventBusConsumer {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @Autowired
    private UserService userService;

    @Autowired
    private RuleMapper ruleDao;
    private static Set<String> lightRuleTypeByInst = new HashSet<>(Arrays.asList("R001", "R002"));
    private static Set<String> lightRuleTypeByIOPV = new HashSet<>(Arrays.asList("R003", "R004", "R005"));
    private static Set<String> lightRuleTypeByEtfStock = new HashSet<>(Arrays.asList("R006"));
    //不管是否告警都推送的规则列表

    private static Set<String> allPushRuleList = new HashSet<>(Arrays.asList("R013"));

    public void onMessage(RuleInstEvent clauseInstEvent) {
        // 获取rule信息
        Rule rule = ruleDao.selectByPrimaryKey(clauseInstEvent.getRuleResult().getRuleId());

        //如果是期货价差规则,全量推送
        if(rule.getId().equals("R026")){
            sendRuleFuturePriceDiffResultMessage(clauseInstEvent, rule,"/queue/rule_result_all");
            return;
        }
        // 根据userIdList推送instInfo(无论是否触警都进行推送)
        List<String> userIds = AuthData.getUserIds();
        log.info("userId list <{}>", userIds);
        if (null != userIds && !StringUtils.isEmpty(clauseInstEvent.getInstInfo().getInstCode()) && !AuthData.isInstinfoPushed(clauseInstEvent.getInstInfo().getInstCode())) {
            sendInstinfo(clauseInstEvent, userIds);
        }
        //如果配置为全量推送（无论规则结果是否告警）
        if (rule.getAllPush().equals(1)) {
            sendRuleResultMessage(clauseInstEvent, rule, "/queue/rule_result_all");
        }

        // 推送告警列表
        if (RuleResult.c_resultStatus_notPass.equals(clauseInstEvent.getRuleResult().getResultStatus())) {
            sendRuleResultMessage(clauseInstEvent, rule, "/queue/rule_result");
        }

        //R001,R002 处理结果到指令跑马灯
        if (lightRuleTypeByInst.contains(clauseInstEvent.getRuleResult().getRuleId())) {
            sendInstLight(clauseInstEvent, rule);
        }

        //推送R003,R004,R005 处理结果到IOPV跑马灯
        if (lightRuleTypeByIOPV.contains(clauseInstEvent.getRuleResult().getRuleId())) {
            sendEtfDeviationLight(clauseInstEvent);
        }

    }

    /**
     * 发送指令信息
     *
     * @param clauseInstEvent
     * @param userIds
     */
    private void sendInstinfo(RuleInstEvent clauseInstEvent, List<String> userIds) {
        InstInfoVO instInfo_webstock = new InstInfoVO();
        com.iquantex.tspevent.InstInfo instInfo = clauseInstEvent.getInstInfo();
        //BeanUtils.copyProperties(clauseInstEvent.getInstInfo(), instInfo_webstock);

        instInfo_webstock.setFundCode(instInfo.getFundCode());
        instInfo_webstock.setInstCode(instInfo.getInstCode());
        instInfo_webstock.setInstCreateName(instInfo.getInstCreateName());
        instInfo_webstock.setInstExecutionName(instInfo.getInstExecutionName());
        instInfo_webstock.setPrice(instInfo.getPrice());
        instInfo_webstock.setQty(instInfo.getQty());
        instInfo_webstock.setSecuCode(instInfo.getSecuCode());
        instInfo_webstock.setO32SecuName(instInfo.getO32SecuName());
        instInfo_webstock.setSystemTime(clauseInstEvent.getRuleResult().getCheckTime());

        String marketName = AuthData.o32SecuCodeToMarketName.get(instInfo.getO32SecuCode());
        if (marketName != null) {
            instInfo_webstock.setO32SecuCode(marketName);
        } else {
            instInfo_webstock.setO32SecuCode("未知");
        }

        //翻译指令方向
        instInfo_webstock.setTradeTypeCode(InstTable.tradeTypeCodeToString(instInfo.getTradeTypeCode()));
        userIds.forEach(userId -> {
            // webSocket推送instInfo
            if (null != instInfo_webstock) {
                messagingTemplate.convertAndSendToUser(userId, "/queue/instInfo", instInfo_webstock);
            } else {
                log.error("RuleResultEventConsumer: Push message is empty: clauseInstEvent <" + JSONObject.toJSONString(clauseInstEvent) + ">");
            }
            log.info("push instInfo websocket data:<{}> to userId_<{}>", JSONObject.toJSONString(instInfo_webstock), userId);
        });
        AuthData.websocketPushInstRecord.add(instInfo.getInstCode());
    }

    /**
     * 发送指令跑马灯信息
     *
     * @param clauseInstEvent
     * @param rule
     */
    private void sendInstLight(RuleInstEvent clauseInstEvent, Rule rule) {
        // 获取lightVo信息
        LightVO light = new LightVO();
        light.setRuleResultId(clauseInstEvent.getRuleResult().getRuleResultId());
        light.setInstCode(clauseInstEvent.getInstInfo().getInstCode());
        light.setCheckTime(clauseInstEvent.getRuleResult().getCheckTime());
        light.setStatus(clauseInstEvent.getRuleResult().getResultStatus());
        light.setRuleId(clauseInstEvent.getRuleResult().getRuleId());
        light.setRuleName(rule.getName());
        // webSocket推送lightVo  先根据跑马灯的menuId=8来获取要推送的用户列表
        List<String> userIdList = AuthData.getUsersByMenuitemId(AuthData.LightVOMid);
        log.info("inst light auth list <{}>", userIdList);
        userIdList.forEach(userId -> {
            messagingTemplate.convertAndSendToUser(userId, "/queue/rule_result/light", light);
            log.info("push instLight websocket data:<{}> to userId_<{}>", JSONObject.toJSONString(light), userId);
        });
    }

    /**
     * 发送etf总览websocket信息
     *
     * @param clauseInstEvent
     */
    private void sendEtfDeviationLight(RuleInstEvent clauseInstEvent) {
        Map<String, String> map = new HashMap<String, String>();
        for (com.iquantex.tspevent.RuleResultFactor factor : clauseInstEvent.getRuleResult().getRuleResultFactorList()) {
            map.put(factor.getFactorKey(), factor.getFactorValue());
        }
        EtfDeviationLightVO etfDeviationLightVO = new EtfDeviationLightVO();
        etfDeviationLightVO.setCheckTime(clauseInstEvent.getRuleResult().getCheckTime());
        etfDeviationLightVO.setEtfDeviation(MathUtil.addSuffixPercent(map.getOrDefault(RuleConst.F_ETF_DEVIATION, "0"), 2));
        etfDeviationLightVO.setFundCode(map.getOrDefault(RuleConst.F_FUNDCODE, "-1"));
        etfDeviationLightVO.setIndexChg(MathUtil.addSuffixPercent(map.getOrDefault(RuleConst.F_INDEX_CHG, "0"), 2));
        etfDeviationLightVO.setIndexCode(map.getOrDefault(RuleConst.F_INDEXCODE, "0"));
        etfDeviationLightVO.setIopvChg(MathUtil.addSuffixPercent(map.getOrDefault(RuleConst.F_IOPV_CHG, "0"), 2));
        etfDeviationLightVO.setIopv(Double.valueOf(map.getOrDefault(RuleConst.F_IOPV, "0")).toString());
        etfDeviationLightVO.setPreNav(Double.valueOf(map.getOrDefault(RuleConst.F_FUND_PRENAV, "0")).toString());
        etfDeviationLightVO.setIndexPrice(Double.valueOf(map.getOrDefault(RuleConst.F_INDEX, "0")).toString());
        etfDeviationLightVO.setIndexPreClosePrice(Double.valueOf(map.getOrDefault(RuleConst.F_INDEX_PRECLOSE, "0")).toString());
        etfDeviationLightVO.setRuleId(clauseInstEvent.getRuleResult().getRuleId());
        etfDeviationLightVO.setStatus(clauseInstEvent.getRuleResult().getResultStatus());
        etfDeviationLightVO.setEtfLastPrice(Double.valueOf(map.getOrDefault(RuleConst.ETF_LASTPRICE, "0")).toString());
        etfDeviationLightVO.setEtfPremiumDiscount(MathUtil.addSuffixPercent(map.getOrDefault(RuleConst.ETF_PREMIUM_DISCOUNT, "0"), 2));
        etfDeviationLightVO.setEtfVolume(MathUtil.fmtMicrometerNoDecimal(map.getOrDefault(RuleConst.ETF_VOLUME, "0")));
        etfDeviationLightVO.setEtf20AvgVolume(MathUtil.fmtMicrometerNoDecimal(map.getOrDefault(RuleConst.ETF_20_AVG_VOLUME, "0")));
        etfDeviationLightVO.setEtfVolume20Deviation(MathUtil.addSuffixPercent(map.getOrDefault(RuleConst.ETF_VOLUME_20_DEVIATION, "0"), 2));
        // webSocket推送EtfDeviationLightVO   先根据ETF基金实时指标监控的menuId=16来获取要推送的用户列表
        List<String> userIdList = AuthData.getUsersByMenuitemId(AuthData.EtfFundRealIndexMid);
        log.info("etf quotes light auth list<{}>", userIdList);
        userIdList.forEach(userId -> {
            messagingTemplate.convertAndSendToUser(userId, "/queue/rule_result/etf_deviation_light", etfDeviationLightVO);
            log.info("push etfLight websocket data:<{}> to userId_<{}>", JSONObject.toJSONString(etfDeviationLightVO), userId);
        });
    }

    /**
     * 发送websocket消息
     *
     * @param clauseInstEvent
     * @param rule
     * @param destination
     */
    private void sendRuleResultMessage(RuleInstEvent clauseInstEvent, Rule rule, String destination) {
        // 获取InstInfo对象信息
        InstInfo info = new InstInfo();
        BeanUtils.copyProperties(clauseInstEvent.getInstInfo(), info);

        // 获取RuleResult对象信息
        List<RuleResultFactor> factorList = new ArrayList<>();
        RuleResult ruleResult = new RuleResult();
        BeanUtils.copyProperties(clauseInstEvent.getRuleResult(), ruleResult);
        for (com.iquantex.tspevent.RuleResultFactor factor : clauseInstEvent.getRuleResult().getRuleResultFactorList()) {
            RuleResultFactor copyFactor = new RuleResultFactor();
            BeanUtils.copyProperties(factor, copyFactor);
            factorList.add(copyFactor);
        }
        //组装RuleResultTale信息
        ResultAllV allV = ParamTransUtils.resultAllVTrans(ruleResult, info, rule);
        // 组装table信息
        RuleResultTable ruleTable = RuleResultTableUtils.getTableBodyByRuleId(allV, factorList);

        // 根据ruleId获取需要推送的用户列表
        List<String> userIdList = AuthData.getUsersByRuleId(ruleTable.getRuleId());
        log.info("rule <{}> auth list <{}>", ruleTable.getRuleId(), userIdList);
        if (null != userIdList) {
            userIdList.forEach(userId -> {
                // webSocket推送ruleTable
                if (null != ruleTable) {
                    messagingTemplate.convertAndSendToUser(userId, destination, ruleTable);
                } else {
                    log.error("RuleResultEventConsumer: Push message is empty: clauseInstEvent <" + JSONObject.toJSONString(clauseInstEvent) + ">");
                }
                log.info("push ruleResult websocket data:<{}> to userId_<{}>", JSONObject.toJSONString(ruleTable), userId);
            });
        }
    }


    /**
     * 发送期货价差规则websocket消息
     *
     * @param clauseInstEvent
     * @param rule
     * @param destination
     */
    private void sendRuleFuturePriceDiffResultMessage(RuleInstEvent clauseInstEvent, Rule rule, String destination) {
        String futureACode = "";
        String futureBCode = "";
        for (com.iquantex.tspevent.RuleResultFactor factor : clauseInstEvent.getRuleResult().getRuleResultFactorList()) {
            if (factor.getFactorKey().equals(RuleConst.FUTUREA_CODE)) {
                futureACode = factor.getFactorValue();
                continue;
            }
            if (factor.getFactorKey().equals(RuleConst.FUTUREB_CODE)) {
                futureBCode = factor.getFactorValue();
                continue;
            }
        }
        List<String> userIdList = AuthData.ruleFuturePriceDiffMap.get(futureACode + "_" + futureBCode);
        if (userIdList.size() == 0)
            return;

        // 获取InstInfo对象信息
        InstInfo info = new InstInfo();
        BeanUtils.copyProperties(clauseInstEvent.getInstInfo(), info);

        // 获取RuleResult对象信息
        List<RuleResultFactor> factorList = new ArrayList<>();
        RuleResult ruleResult = new RuleResult();
        BeanUtils.copyProperties(clauseInstEvent.getRuleResult(), ruleResult);
        for (com.iquantex.tspevent.RuleResultFactor factor : clauseInstEvent.getRuleResult().getRuleResultFactorList()) {
            RuleResultFactor copyFactor = new RuleResultFactor();
            BeanUtils.copyProperties(factor, copyFactor);
            factorList.add(copyFactor);
        }
        //组装RuleResultTale信息
        ResultAllV allV = ParamTransUtils.resultAllVTrans(ruleResult, info, rule);
        // 组装table信息
        RuleResultTable ruleTable = RuleResultTableUtils.getTableBodyByRuleId(allV, factorList);
        userIdList.forEach(userId -> {
            // webSocket推送ruleTable
            if (null != ruleTable) {
                messagingTemplate.convertAndSendToUser(userId, destination, ruleTable);
            } else {
                log.error("RuleResultEventConsumer: Push message is empty: clauseInstEvent <" + JSONObject.toJSONString(clauseInstEvent) + ">");
            }
            log.info("push ruleResult websocket data:<{}> to userId_<{}>", JSONObject.toJSONString(ruleTable), userId);
        });

    }



    @KafkaListener(topics = "calendar-calendarEvent", groupId = "tsp")
    public void receiverMessage(ConsumerRecord<String, String> record) {
        log.info("receive message: topic = {}, offset = {}, key = {}, value.size = {}",
                record.topic(), record.offset(), record.key(), record.value());
//        RuleInstEvent ruleInstEvent = JSONObject.parseObject(record.value(), RuleInstEvent.class);
//        try {
//            onMessage(ruleInstEvent);
//        } catch (Exception e) {
//            log.error(e.getMessage(), e);
//        }
        try {
            List<TspUser> users =  userService.getAll();
            log.info("users: "+ JSON.toJSONString(users));
            for (TspUser user:users) {
                messagingTemplate.convertAndSendToUser(user.getUserId(),"/queue/instInfo",record.value());
            }
            for(TspUser user:users){
                messagingTemplate.convertAndSendToUser(user.getUserId(),"/queue/rule_result/light","mockEvent:"+record.value());
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }


}