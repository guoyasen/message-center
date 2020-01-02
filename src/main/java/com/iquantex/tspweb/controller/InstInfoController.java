package com.iquantex.tspweb.controller;


import com.iquantex.tspweb.model.InstInfo;
import com.iquantex.tspweb.param.HeaderParam;
import com.iquantex.tspweb.param.InstInfoVO;
import com.iquantex.tspweb.service.InstInfoService;
import com.iquantex.tspweb.table.InstTable;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/inst_info")
public class InstInfoController extends BaseController {

    @Autowired
    private InstInfoService instInfoService;

    @GetMapping("/query")
    public String query(@RequestParam(required = false) String fundCode,
                        @RequestParam(required = false) String secuCode,
                        @RequestParam(required = false) String o32SecuCode,
                        @RequestParam(required = false) String instCreateName,
                        @RequestParam(required = false) String instExecutionName,
                        @RequestParam(required = false) String tradeTypeCode) {
        // 组装body信息
        List<InstInfoVO> instInfos = instInfoService.query(fundCode, secuCode, o32SecuCode, instCreateName, instExecutionName, tradeTypeCode);
        for (InstInfoVO instInfo : instInfos) {
            instInfo.setTradeTypeCode(InstTable.tradeTypeCodeToString(Integer.valueOf(instInfo.getTradeTypeCode())));
            instInfo.setO32SecuCode(instInfo.getMarketName());
        }

        // 组装header信息
        List<HeaderParam> headerParams = new ArrayList<>();
        headerParams.add(new HeaderParam(InstInfo.f_instCode, "指令序号"));
        headerParams.add(new HeaderParam(InstInfo.f_fundCode, "基金名称"));
        headerParams.add(new HeaderParam(InstInfo.f_secuCode, "证券代码"));
        headerParams.add(new HeaderParam(InstInfo.f_o32SecuName, "证券名称"));
        headerParams.add(new HeaderParam(InstInfo.f_o32SecuCode, "交易市场"));
        headerParams.add(new HeaderParam(InstInfo.f_instCreateName, "投资经理"));
        headerParams.add(new HeaderParam(InstInfo.f_instExecutionName, "交易员"));
        headerParams.add(new HeaderParam(InstInfo.f_tradeTypeCode, "委托方向"));
        headerParams.add(new HeaderParam(InstInfo.f_qty, "指令数量"));
        headerParams.add(new HeaderParam(InstInfo.f_price, "指令价格"));
        headerParams.add(new HeaderParam(InstInfo.f_systemTime, "触发时间"));
        // 合并
        Map<String, Object> map = new HashMap<>();
        map.put("headers", headerParams);
        map.put("bodys", instInfos);
        return successReturn(map);
    }
}
