package com.iquantex.tspweb.controller;

import com.iquantex.tspweb.tool.BaseWebTest;
import org.junit.Test;

/**
 * Created by szhengjie on 2018/12/13
 */
public class RuleTypeControllerTest extends BaseWebTest {
    private static final String BASE_URL = "/rule_type";

    @Test
    public void getRuleTypeById() {
        doGet(BASE_URL + "/dict?typeId=" + "t4");
    }

    @Test
    public void getRuleTypeById1() {
        doGet(BASE_URL + "/dict?typeId=" + "t42");
    }

    @Test
    public void getRuleTypeById2() {
        doGet(BASE_URL + "/dict");
    }

}
