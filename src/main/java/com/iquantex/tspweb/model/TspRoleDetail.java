package com.iquantex.tspweb.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 角色详细信息
 *
 * @author xiangpeng;
 *
 * @date 2019/06/19-16:53;
 * @Copyright: Copyright (c) 2018 Fullgoal Fund Management  Co., Ltd. Inc. All rights reserved.
 */
@Data
public class TspRoleDetail {
    /**
     * roleId : 1
     * roleName : admin
     * menuList : ["1","2,"3","4","5","6","7","8","9"]
     * userList : ["1","2","3","4","5","6"]
     */
    private Long roleId;
    private String roleName;
    private List<String> menuList;
    private List<String> userList;


    public void setMenuList(String menuList) {
        this.menuList = Arrays.asList(menuList.split(","));
    }

    public void setUserList(String userList) {
        this.userList = new ArrayList(Arrays.asList(userList.split(",")));
    }

}
