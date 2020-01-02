package com.iquantex.tspweb.controller;

import com.iquantex.tspweb.tool.BaseWebTest;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class MockControllerTest extends BaseWebTest {
    public static final String BASE_URL = "/mock";

    @Test
    public void test1(){
        Map<String, String> infoMap = new HashMap<>();
        infoMap.put("info", "{\"currentAmount\":60,\"entrustDirection\":\"申购\",\"fundCode\":\"000001.SH\",\"fundName\":\"000001.SH\",\"o32FundCode\":\"000001.SH\",\"windCode\":\"000001.SH\"}");
        doPost(BASE_URL+"etf_fund_change", infoMap);
    }
}
