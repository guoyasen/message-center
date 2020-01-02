package com.iquantex.tspweb.param;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by yanliang on 2018/11/23.
 */
@Getter
@Setter
public class RuleVO {
    /** 类型id */
    private String typeId;
    /** 类型名称 */
    private String typeName;
    /** 触警数量 */
    private Long   triggerNumber;
}
