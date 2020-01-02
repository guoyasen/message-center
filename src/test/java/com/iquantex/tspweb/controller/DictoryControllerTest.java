package com.iquantex.tspweb.controller;

import com.iquantex.tspweb.service.AuthDataService;
import com.iquantex.tspweb.tool.BaseWebTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 字典controller测试类
 *
 * @author shenzhengjie
 * @date 2019/3/6 14:51
 */
public class DictoryControllerTest extends BaseWebTest {

    public static final String BASE_URL = "/qryDictory";
    @Autowired
    AuthDataService authDataService;

    @Test
    public void getAllFundDict() {
        String url = BASE_URL + "/fund";
        doGet(url);
    }

    @Test
    public void updateRuleToUserMap(){
        authDataService.updateRuleIdToUserMap();
    }
}
