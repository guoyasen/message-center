package com.iquantex.tspweb.controller;

import com.iquantex.tspweb.model.SubRule;
import com.iquantex.tspweb.tool.BaseWebTest;
import org.junit.Test;

public class SubRuleControllerTest extends BaseWebTest{
    public static final String BASE_URL = "/sub_rule";

    @Test
    public void getSubRules(){
        doGet(BASE_URL+"/c1");
    }

    /**
     * 更新细则 测试类
     */
    @Test
    public void updateSubRuleTest(){
        SubRule subRule = new SubRule();
        subRule.setId(1);
        subRule.setThreshold(12.0);

        doPut(BASE_URL, subRule);
    }
}
