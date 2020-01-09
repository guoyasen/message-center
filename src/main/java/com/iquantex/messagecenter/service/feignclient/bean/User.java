package com.iquantex.messagecenter.service.feignclient.bean;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class User {
    private Long userId;

    private String code;

    private String name;

    private String employeeCode;

    private String companyCode;

    private String email;

    private String contactNumber;

    private String loginName;

    private Integer status;

    private Date updatedAt;
}