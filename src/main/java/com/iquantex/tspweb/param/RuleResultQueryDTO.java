package com.iquantex.tspweb.param;

import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by szhengjie on 2018/11/29 .
 */
@Data
@ToString
public class RuleResultQueryDTO {

    /**
     * 规则id
     */
    private String ruleId;

    /**
     * 证券编码
     */
    private String secuCode;

    /**
     * 证券名称
     */
    private String secuName;

    /**
     * 方向
     */
    private Integer tradeTypeCode;

    /**
     * 指令下达人
     */
    private String instCreateName;

    /**
     * 产品编码
     */
    private String fundCode;

    /**
     * 状态<>noHandle=0=未处理&handle=1=处理&hang=2=挂起
     */
    private Integer status;

    /**
     * 因子list
     */
    public List<FactoryDTO> factoryParams;

    /**
     * 获取factoryKeyValues
     */
    public List<String> spliceFactorKeyValues() {
        if (null == factoryParams || factoryParams.size() <= 0) {
            return null;
        }
        List<String> factorKeyValues = new ArrayList<>();
        for (FactoryDTO factoryParam : factoryParams) {

            factoryParam.setFactoryKeyValue();
            factorKeyValues.add(factoryParam.getFactoryKeyValue());
        }
        return factorKeyValues;
    }
}
