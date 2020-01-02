package com.iquantex.tspweb.controller;

import com.alibaba.fastjson.JSONObject;
import com.iquantex.tspweb.param.Deal;
import com.iquantex.tspweb.param.DealsDTO;
import com.iquantex.tspweb.param.RuleResultQueryDTO;
import com.iquantex.tspweb.tool.BaseWebTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by szhengjie on 2018/11/29
 */
public class RuleResultControllerTest extends BaseWebTest {

    private static final String BASE_URL = "/rule_result";

    @Autowired
    private RestTemplate restTemplate;

    @Test
    public void queryDealTables() {
        RuleResultQueryDTO param = new RuleResultQueryDTO();
        param.setRuleId("R001");
        System.out.println(JSONObject.toJSONString(param));

        String json = JSONObject.toJSONString(param);
        String url = BASE_URL + "/query?ruleResultQueryParam={json}";
        String email = restTemplate.getForObject(url,String.class,json);
        doGet(email);
    }

    @Test
    public void queryMapping() {
        String id = "R001";
        doGet(BASE_URL + "/mapping/" + id);
    }

    @Test
    public void queryMapping1() {
        String id = null;
        doGet(BASE_URL + "/mapping/" + id);
    }

    @Test
    public void queryMapping2() {
        String id = "asda";
        doGet(BASE_URL + "/mapping/" + id);
    }

    @Test
    public void transactionProcessIng() {
        DealsDTO dealsDTO = new DealsDTO();
        List<Deal> dealList = new ArrayList<>();
        Deal deal = new Deal();
        deal.setRuleResultId(6L);
        deal.setDealId("admin");
        dealList.add(deal);
        dealsDTO.setDeals(dealList);
        doPut(BASE_URL + "/deal", dealsDTO);
    }

    @Test
    public void transactionProcessIng1() {
        DealsDTO dealsDTO = new DealsDTO();
        List<Deal> dealList = new ArrayList<>();
        Deal deal = new Deal();
        deal.setRuleResultId(6L);
        deal.setDealId("admin");
        dealList.add(deal);
        deal = new Deal();
        deal.setRuleResultId(7L);
        deal.setDealId("admin");
        dealList.add(deal);
        dealsDTO.setDeals(dealList);
        doPut(BASE_URL + "/deal", dealsDTO);
    }

    @Test
    public void transactionProcessIng2() {
        DealsDTO dealsDTO = new DealsDTO();
        dealsDTO.setDeals(new ArrayList<>());
        doPut(BASE_URL + "/deal", dealsDTO);
    }


    @Test
    public void sendKmTest() {
        List<Deal> deals=new ArrayList<>();
        Deal deal=new Deal();
        deal.setDealId("aa");
        deal.setRuleResultId(Long.valueOf(4127006));
        deals.add(deal);

        deal=new Deal();
        deal.setDealId("bb");
        deal.setRuleResultId(Long.valueOf(4133550));
        deals.add(deal);

        deal=new Deal();
        deal.setDealId("cc");
        deal.setRuleResultId(Long.valueOf(4126992));
        deals.add(deal);

        DealsDTO dealsDTO = new DealsDTO();
        dealsDTO.setDeals(deals);
        doPut(BASE_URL + "/send", dealsDTO);
    }
}
