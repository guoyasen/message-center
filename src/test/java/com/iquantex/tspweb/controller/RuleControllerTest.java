package com.iquantex.tspweb.controller;

import com.iquantex.tspweb.model.Rule;
import com.iquantex.tspweb.tool.BaseWebTest;
import org.junit.Test;

/**
 * Created by yanliang on 2018/11/28.
 */
public class RuleControllerTest extends BaseWebTest {

    public static final String BASE_URL = "/rule";

    @Test
    public void getRulesListTest(){
        doGet(BASE_URL+"/query");
        doGet(BASE_URL+"/query?id=c1");
    }

    /**
     * 更新规则 测试类
     */
    @Test
    public void updateRuleTest(){
        Rule rule = new Rule();
        rule.setId("ruleA");
        rule.setName("ruleA");
        rule.setTypeId("c3");
        rule.setCueFormat("test_cue_format");
        rule.setInfo("test_info");
        rule.setStartTime("00:00:00");
        rule.setEndTime("23:59:59");
        doPut(BASE_URL, rule);
    }

    /**
     * 更新规则 测试类（传入的值有异常）
     */
    @Test
    public void updateRuleTest1(){
        Rule rule = new Rule();
        rule.setId("test");
        rule.setName("test");
        rule.setTypeId("c_test_type");
        rule.setCueFormat("test_cue_format");
        rule.setInfo("test_info");
        rule.setStartTime("00:00:00");
        rule.setEndTime("23:59:59");


        doPut(BASE_URL, new Rule());
    }

    @Test
    public void getRuleGroupsTest(){
        doGet(BASE_URL + "/groups");
    }
}
