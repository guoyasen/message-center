package com.iquantex.tspweb.controller;


import com.iquantex.tspweb.param.DictoryVO;
import com.iquantex.tspweb.service.DictoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/qryDictory")
public class DictoryController extends BaseController {

    @Autowired
    private DictoryService dictoryService;


    @GetMapping("/fund")
    public String getAllFundDict() {
        try {
            List<DictoryVO> dict = dictoryService.getFundDict(null, null);
            return successReturn(dict);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return failReturn(e.getMessage());
        }
    }

    @GetMapping("/inst_create_name")
    public String getInstCreateName() {
        try {
            return successReturn(dictoryService.getInstCreateNameDict(null, null));
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return failReturn(e.getMessage());
        }
    }

    @GetMapping("/secu_code")
    public String getSecuName() {
        try {
            return successReturn(dictoryService.getSecuCodeDict(null, null));
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return failReturn(e.getMessage());
        }
    }

    @GetMapping("/market_name")
    public String getMarketName() {
        try {
            return successReturn(dictoryService.getO32SecuCodeDict(null,null));
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return failReturn(e.getMessage());
        }
    }

    //所有中金所期货查询接口
    @GetMapping("/futures")
    public String getAllFutures(){
        try{
            return successReturn(dictoryService.getAllFuture());
        }catch (Exception e){
            log.error(e.getMessage(), e);
            return failReturn(e.getMessage());
        }
    }
}
