package com.iquantex.tspweb.controller;

import com.iquantex.tspweb.tool.BaseWebTest;
import org.junit.Test;

public class AuthDataControllerTest extends BaseWebTest {

    public static final String BASE_URL = "/authData";

    @Test
    public void test1(){
        doGet(BASE_URL + "/update");
    }
}
