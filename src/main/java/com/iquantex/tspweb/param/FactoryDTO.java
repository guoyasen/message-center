package com.iquantex.tspweb.param;

import lombok.Data;
import lombok.ToString;

/**
 * @author shenzhengjie
 * @date 2019/1/3 9:48
 */
@Data
@ToString
public class FactoryDTO {

    public FactoryDTO() {
    }

    public FactoryDTO(String factoryKey, String factoryValue) {
        this.factoryKey = factoryKey;
        this.factoryValue = factoryValue;
        setFactoryKeyValue();
    }


    /**
     * 因子key
     */
    private String factoryKey;

    /**
     * 因子value
     */
    private String factoryValue;

    /**
     * 因子key+value
     */
    private String factoryKeyValue;

    /**
     * 设置因子和
     */
    public void setFactoryKeyValue() {
        this.factoryKeyValue = this.factoryKey + this.factoryValue;
    }
}
