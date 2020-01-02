package com.iquantex.tspweb.controller;

import com.iquantex.tspweb.param.*;
import com.iquantex.tspweb.service.RuleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 监控统计Controller
 *
 * @author shenZhengJie
 * @date 2018/12/19
 */
@Slf4j
@RestController
@RequestMapping("/statistics")
public class StatisticsController extends BaseController {

    @Autowired
    private RuleService ruleService;

    /**
     * 规则分类
     */
    @GetMapping(value = "/rule")
    public String getRuleClassification() {
        try {
            List<RuleClassificationVO> vos = ruleService.getRuleClassification();
            return successReturn(vos);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return failReturn(String.format("Unable to get rule classification. throw message <%s>. ", e.getMessage()));
        }
    }

    /**
     * 规则类型分类
     */
    @GetMapping(value = "/rule_type")
    public String getRuleTypeClassification() {
        try {
            List<RuleTypeClassificationVO> vos = ruleService.getRuleTypeClassification();
            return successReturn(vos);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return failReturn(String.format("Unable to get rule type classification. throw message <%s>. ", e.getMessage()));
        }
    }

    /**
     * 规则市场分类
     */
    @GetMapping(value = "/market")
    public String getRuleMarketClassification(@RequestParam(required = false) String typeId) {
        try {
            List<RuleMarketClassificationVO> vos = ruleService.getRuleMarketClassification(typeId);
            return successReturn(vos);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return failReturn(String.format("Unable to get rule market classification. throw message <%s>. typeId<%s> . ", e.getMessage(), typeId));
        }
    }


    /**
     * 按证券查看前N条记录
     *
     * @param typeId     类型id
     * @param marketCode 市场编码
     * @param num        前num条
     */
    @GetMapping(value = "/security")
    public String getSecuMonitoringStatistics(@RequestParam(required = false) String typeId,
                                              @RequestParam(required = false) String marketCode,
                                              @RequestParam Integer num) {
        try {
            List<SecuMonitoringStatisticsVO> vos = ruleService.getSecuMonitoringStatistics(typeId, marketCode, num);
            return successReturn(vos);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return failReturn(String.format("Unable to get monitoring statistics. throw message <%s>, typeId<%s>, marketCode<%s>, num <%s>. ", e.getMessage(), typeId, marketCode, num));
        }
    }

    /**
     * 按产品查看前N条记录
     *
     * @param typeId     类型id
     * @param marketCode 市场编码
     * @param num        前num条
     */
    @GetMapping(value = "/fund")
    public String getFundMonitoringStatistics(@RequestParam(required = false) String typeId,
                                              @RequestParam(required = false) String marketCode,
                                              @RequestParam Integer num) {
        try {
            List<FundMonitoringStatisticsVO> vos = ruleService.getFundMonitoringStatistics(typeId, marketCode, num);
            return successReturn(vos);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return failReturn(String.format("Unable to get monitoring statistics. throw message <%s>, typeId<%s>, marketCode<%s>, num <%s>. ", e.getMessage(), typeId, marketCode, num));
        }
    }

}
