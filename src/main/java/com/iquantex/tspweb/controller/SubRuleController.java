package com.iquantex.tspweb.controller;

import com.alibaba.fastjson.JSONObject;
import com.iquantex.tspweb.model.SubRule;
import com.iquantex.tspweb.service.SubRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by yanliang on 2018/11/30.
 */
@RestController
@RequestMapping("/sub_rule")
public class SubRuleController extends BaseController{
    @Autowired
    private SubRuleService subRuleService;

    /**
     * 获取细则列表
     * @param ruleId
     * @return
     */
    @GetMapping("/{ruleId}")
    public String selectSubRules(@PathVariable("ruleId") String ruleId){
        try {
            List<SubRule> subRules = subRuleService.getSubRules(ruleId);
            return successReturn(subRules);
        } catch (Exception e) {
            return failReturn(e.getMessage());
        }
    }

    /**
     * 更新细则
     * @param subRule
     * @return
     */
    @PutMapping
    public String updateSubRule(@RequestBody SubRule subRule){
        try {
            int flag = subRuleService.updateSubRule(subRule);
            if (flag == 1){
                return successReturn();
            }
            return failReturn("update subRule fail, subRule<"+ JSONObject.toJSONString(subRule)+">");
        } catch (Exception e) {
            return failReturn(String.format("update subRule throw, throw message <%s> subRule<%s>",
                    e.getMessage(), JSONObject.toJSONString(subRule)));
        }
    }

    /**
     * 删除细则
     * @param subRuleId
     * @return
     */
    @DeleteMapping("/{subRuleId}")
    public String deleteSubRule(@PathVariable("subRuleId") String subRuleId){
        try {
            int flag = subRuleService.deleteSubRule(subRuleId);
            if (flag == 1){
                return successReturn();
            }
            return failReturn("delete subRule fail, ruleId<"+ subRuleId+">");
        } catch (Exception e) {
            return failReturn(String.format("delete subRule throw, throw message <%s> ruleId<%s>",
                    e.getMessage(), subRuleId));
        }
    }
}
