package com.iquantex.tspweb.controller;

import com.iquantex.tspweb.tool.BaseWebTest;
import org.junit.Test;

/**
 * Created by xp on 2019/03/20.
 */
public class BondInteriorInfoControllerTest extends BaseWebTest {

    public static final String BASE_URL = "/api";


    @Test
    public void updateBondInteriorInfoTest1(){
        doPost(BASE_URL+"/v2/sett_job/childtask/1/3/1");
    }



    @Test
    public void ClearRedisDBJobTest(){doPost(BASE_URL+"/v2/sett_job/childtask/1/1/3");}
}
