package com.iquantex.tspweb.controller;

import com.alibaba.fastjson.JSONObject;
import com.iquantex.tspweb.model.*;
import com.iquantex.tspweb.param.RuleVO;
import com.iquantex.tspweb.service.RuleService;
import com.iquantex.tspweb.service.TspMenuitemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by yanliang on 2018/11/21.
 */
@Slf4j
@RestController
@RequestMapping("/rule")
public class RuleController extends BaseController {

    @Autowired
    private RuleService ruleService;

    @Autowired
    private TspMenuitemService tspMenuitemService;

    /**
     * 获取规则列表
     *
     * @param id
     * @return
     */
    @GetMapping("/query")
    public String getRulesList(@RequestParam(value = "ruleId", required = false) String id) {
        try {
            List<Rule> rules = ruleService.selectRulesList(id);
            return successReturn(rules);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return failReturn(e.getMessage());
        }
    }

    /**
     * 获取规则列表增加权限判断
     * 此次 登录接口改造不返回角色ID 防止用户串改报文导致可以查询不同的角色的权限
     *
     * @param user_id
     * @return
     */
    @GetMapping("/queryWorkBench/{user_id}")
    public String getRulesAndRoleList(@PathVariable("user_id") String user_id) {
        try {
            List<String> ids = tspMenuitemService.judgeRuleRole(user_id);
            List<Rule> rules = ruleService.selectRulesListByIds(ids);
            if (null != rules && !rules.isEmpty()) {
                return successReturn(rules);
            } else {
                return failReturn("权限不足");
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return failReturn(e.getMessage());
        }
    }

    /**
     * 更新规则
     *
     * @param rule
     * @return
     */
    @PutMapping
    public String updateRule(@RequestBody Rule rule) {
        try {
            int flag = ruleService.updateRule(rule);
            if (flag == 1) {
                return successReturn();
            }
            return failReturn("update rule fail, rule<" + JSONObject.toJSONString(rule) + ">");
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return failReturn(String.format("update rule throw, throw message <%s> rule<%s>",
                    e.getMessage(), JSONObject.toJSONString(rule)));
        }
    }

    /**
     * 获取规则组列表详情
     *
     * @return
     */
    @GetMapping("/groups")
    public String getRuleGroups() {
        try {
            List<RuleVO> ruleVOList = ruleService.getRuleGroups();
            return successReturn(ruleVOList);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return failReturn(e.getMessage());
        }
    }

    /**
     * 规则参数字典查询接口,查询所有
     */
    @GetMapping("/rule_parameter")
    public String getRuleParameter() {
        try {
            List<RuleParameterView> ruleParameters = ruleService.getRuleParameter();
            return successReturn(ruleParameters);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return failReturn(e.getMessage());
        }
    }

    /**
     * 规则参数字典查询接口,根据基金代码查询
     */
    @GetMapping("/rule_parameter/{fund_code}")
    public String getRuleParameter(@PathVariable("fund_code") String fund_code) {
        try {
            List<RuleParameterView> ruleParameters = ruleService.getRuleParameterByFundCode(fund_code);
            return successReturn(ruleParameters);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return failReturn(e.getMessage());
        }
    }

    /**
     * 规则参数字典查询接口,根据基金代码和规则id查询
     */
    @GetMapping("/rule_parameter/{fund_code}/{rule_id}")
    public String getRuleParameter(@PathVariable("fund_code") String fund_code, @PathVariable("rule_id") String rule_id) {
        try {
            List<RuleParameterView> ruleParameters = ruleService.getRuleParameterByFundCodeAndRuleId(fund_code, rule_id);
            return successReturn(ruleParameters);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return failReturn(e.getMessage());
        }
    }

    /**
     * 规则参数新增接口
     */
    @PostMapping("/rule_parameter")
    public String addRuleParameter(@RequestBody RuleParameter ruleParameter) {
        String result = ruleService.addRuleParameter(ruleParameter);
        if (result.equals("0")) {
            return successReturn(ruleParameter);
        } else if (result.equals("1")) {
            return failReturn("基金代码和规则id重复");
        } else {
            return failReturn(result);
        }
    }


    /**
     * 规则参数修改接口,批量更新
     */
    @PutMapping("/rule_parameter")
    public String updateRuleParameter(@RequestBody List<RuleParameterView> ruleParameterViews) {
        try {
            for (RuleParameterView view : ruleParameterViews) {
                RuleParameter ruleParameter = view.transferRuleParameter();
                ruleService.updateRuleParameter(ruleParameter);
            }
            return successReturn();
        } catch (Exception e) {
            return failReturn(e.getMessage());
        }
    }

    /**
     * 规则参数删除接口
     */
    @DeleteMapping("/rule_parameter")
    public String deleteRuleParameter(@RequestBody RuleParameter ruleParameter) {
        String result = ruleService.deleteRuleParameter(ruleParameter);
        if (result.equals("0")) {
            return successReturn(getRuleParameter());
        } else if (result.equals("1")) {
            return failReturn("记录不存在");
        } else {
            return failReturn(result);
        }
    }


    /**
     * 用户自定义规则查询接口
     */
    @GetMapping("/rule_customize/{user_id}")
    public String getRuleCustomize(@PathVariable("user_id") String user_id) {
        try {
            return successReturn(ruleService.getRuleCustomize(user_id));
        } catch (Exception e) {
            return failReturn(e.getMessage());
        }
    }

    /**
     * 用户自定义规则查询接口
     */
    @GetMapping("/rule_customize/{user_id}/{rule_id}")
    public String getRuleCustomize(@PathVariable("user_id") String user_id, @PathVariable("rule_id") String rule_id) {
        try {
            return successReturn(ruleService.getRuleCustomize(user_id, rule_id));
        } catch (Exception e) {
            return failReturn(e.getMessage());
        }
    }

    /**
     * 用户自定义规则修改接口
     */
    @PutMapping("/rule_customize")
    public String updateRuleCustomize(@RequestBody RuleCustomize ruleCustomize) {
        try {
            ruleService.updateRuleCustomize(ruleCustomize);
            return successReturn(ruleService.getRuleCustomize(ruleCustomize.getUserId(), ruleCustomize.getRuleId()));
        } catch (Exception e) {
            return failReturn(e.getMessage());
        }
    }

    /**
     * 用户自定义规则初始化接口
     */
    @GetMapping("/rule_customize_init/{user_id}/{rule_id}")
    public String initRuleCustomize(@PathVariable("user_id") String user_id, @PathVariable("rule_id") String rule_id) {
        try {
            return successReturn(ruleService.getInitRuleCustomize(user_id, rule_id));
        } catch (Exception e) {
            return failReturn(e.getMessage());
        }
    }

    /**
     * 期货价差规则查询接口
     */
    @GetMapping("/price_diff/{user_id}")
    public String getFuturePriceDiffByUserId(@PathVariable("user_id") String user_id) {
        try {
            return successReturn(ruleService.getRuleFuturePriceDiff(user_id, null, null));
        } catch (Exception e) {
            return failReturn(e.getMessage());
        }
    }

    /**
     * 期货价差规则查询接口
     */
    @GetMapping("/price_diff/{user_id}/{futurea_code}/{futureb_code}")
    public String getFuturePriceDiff(@PathVariable("user_id") String user_id, @PathVariable("futurea_code") String futurea_code, @PathVariable("futureb_code") String futureb_code) {
        try {
            return successReturn(ruleService.getRuleFuturePriceDiff(user_id, futurea_code, futureb_code));
        } catch (Exception e) {
            return failReturn(e.getMessage());
        }
    }

    /**
     * 期货价差规则新增接口
     */
    @PostMapping("/price_diff")
    public String addFuturePriceDiff(@RequestBody RuleFuturePriceDiff ruleFuturePriceDiff) {
        try {
            int res = ruleService.insertRuleFuturePriceDiff(ruleFuturePriceDiff);
            if (res == -1) {
                return failReturn("规则已存在");
            } else if (res == -2) {
                return failReturn("期货代码相同");
            }
            return successReturn(ruleService.getRuleFuturePriceDiff(ruleFuturePriceDiff.getUserId(), ruleFuturePriceDiff.getFutureaCode(), ruleFuturePriceDiff.getFuturebCode()));
        } catch (Exception e) {
            return failReturn(e.getMessage());
        }
    }

    /**
     * 期货价差规则删除接口
     */
//    @DeleteMapping("/price_diff")
//    public String deleteFuturePriceDiff(@RequestBody RuleFuturePriceDiff ruleFuturePriceDiff) {
//        try {
//            ruleService.deleteRuleFuturePriceDiff(ruleFuturePriceDiff);
//            return successReturn();
//        } catch (Exception e) {
//            return failReturn(e.getMessage());
//        }
//    }

    /**
     * 期货价差规则批量删除接口
     */
    @DeleteMapping("/price_diff")
    public String deleteFuturePriceDiffs(@RequestBody List<RuleFuturePriceDiff> ruleFuturePriceDiffs) {
        try {
            for (int i = 0; i < ruleFuturePriceDiffs.size(); i++) {
                ruleService.deleteRuleFuturePriceDiff(ruleFuturePriceDiffs.get(i));
            }
            return successReturn();
        } catch (Exception e) {
            return failReturn(e.getMessage());
        }
    }


    /**
     * 期货价差规则语音修改接口
     */
    @PutMapping("/rule_music")
    public String updateRuleMusic(@RequestBody RuleMusic ruleMusic) {
        try {
            ruleService.updateRuleMusic(ruleMusic);
            return successReturn();
        } catch (Exception e) {
            return failReturn(e.getMessage());
        }
    }

    /**
     * 期货价差规则语音查询接口
     */
    @GetMapping("/rule_music/{futuresType}")
    public String getRuleMusic(@PathVariable("futuresType") String futuresType) {
        try {
            return successReturn(ruleService.getRuleMusic(futuresType));
        } catch (Exception e) {
            return failReturn(e.getMessage());
        }
    }


    /**
     * 期货价差规则语音查询接口
     */
    @GetMapping("/rule_music")
    public String getRuleMusic() {
        try {
            return successReturn(ruleService.getRuleMusic(null));
        } catch (Exception e) {
            return failReturn(e.getMessage());
        }
    }
}
