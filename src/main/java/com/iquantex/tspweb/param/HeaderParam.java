package com.iquantex.tspweb.param;


import lombok.Getter;
import lombok.Setter;

/**
 * Created by szhengjie on 2018/11/29 .
 */
@Getter
@Setter
public class HeaderParam {
    public HeaderParam(String fieldName, String showName) {
        this.fieldName = fieldName;
        this.showName = showName;
    }
    private String fieldName;
    private String showName;
}
