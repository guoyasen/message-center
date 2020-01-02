package com.iquantex.tspweb.controller;

import com.iquantex.tspweb.service.DataSetService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * 数据集查询controller
 * Created by xp on 2019/05/29
 */
@Slf4j
@RestController
@RequestMapping("/dataset")
public class DataSetController extends BaseController {

    @Autowired
    private DataSetService dataSetService;


    @GetMapping("/pre_open_index/{data_set_id}")
    public String getDataSet(@PathVariable("data_set_id") String data_set_id) {
        try {
            String result="";
            switch (data_set_id) {
                case "impact_cost":
                    result= successReturn(dataSetService.getImpctCost());
                break;
                default:
                    result= failReturn("数据集id错误");
                break;
            }
            return result;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return failReturn(e.getMessage());
        }
    }

}
