package com.iquantex.tspweb.controller;

import com.iquantex.tspweb.service.RuleTypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by szhengjie on 2018/12/13
 */
@Slf4j
@RestController
@RequestMapping("/rule_type")
public class RuleTypeController extends BaseController {

    @Autowired
    private RuleTypeService ruleTypeService;

    @GetMapping("/dict")
    public String getTypeById(@RequestParam(required = false) String typeId) {
        try {
            return successReturn(ruleTypeService.getTypeById(typeId));
        } catch (Exception e) {
            return failReturn(String.format("update clause throw, throw message <%s> typeId <%s> ",
                    e.getMessage(), typeId));
        }
    }
}
