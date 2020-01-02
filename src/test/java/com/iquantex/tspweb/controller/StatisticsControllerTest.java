package com.iquantex.tspweb.controller;

import com.iquantex.tspweb.tool.BaseWebTest;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author shenZhengJie
 * @date 2018/12/19
 */
public class StatisticsControllerTest extends BaseWebTest {
    private static final String BASE_URL = "/statistics";

    @Test
    public void getRuleClassificationTest() {
        doGet(BASE_URL + "/rule");
    }

    @Test
    public void getRuleTypeClassificationTest() {
        doGet(BASE_URL + "/rule_type");
    }

    @Test
    public void getRuleMarketClassificationTest() {
        String typeId = "STOCK";
        doGet(BASE_URL + "/market?typeId=" + typeId);
    }

    @Test
    public void getSecuMonitoringStatisticsTest() {
        Integer num = 10;
        String typeId = "";
        String marketCode = "";
        doGet(BASE_URL + "/security?typeId=" + typeId + "&marketCode=" + marketCode + "&num=" + num);
    }

    @Test
    public void getFundMonitoringStatisticsTest() {
        Integer num = 10;
        String typeId = "";
        String marketCode = "";
        doGet(BASE_URL + "/fund?typeId=" + typeId + "&marketCode=" + marketCode + "&num=" + num);
    }
}
