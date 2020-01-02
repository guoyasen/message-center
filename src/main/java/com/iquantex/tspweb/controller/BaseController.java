package com.iquantex.tspweb.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Collection;

/**
 * Created by devin on 2018/4/28.
 */
@CrossOrigin
public class BaseController {

    protected String successReturn(Object data) {

        JSONObject dataObj = new JSONObject();

        dataObj.put("code", 200);

        if(data instanceof Collection) {

            JSONObject subDataObj = new JSONObject();
            subDataObj.put("list", data);

            dataObj.put("data", subDataObj);
        }else{
            dataObj.put("data", data);
        }

        dataObj.put("msg", "");

        return dataObj.toJSONString();
    }

    protected String failReturn(String msg) {

        JSONObject dataObj = new JSONObject();

        dataObj.put("code", 500);

        dataObj.put("msg", msg);

        return dataObj.toJSONString();
    }

    protected String successReturn() {

        JSONObject dataObj = new JSONObject();

        dataObj.put("code", 200);

        return dataObj.toJSONString();
    }




}
