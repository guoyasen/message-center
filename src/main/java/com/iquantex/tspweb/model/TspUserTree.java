package com.iquantex.tspweb.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * 用户树结构详细信息
 *
 * @author xiangpeng;
 *
 * @date 2019/06/19-16:53;
 * @Copyright: Copyright (c) 2018 Fullgoal Fund Management  Co., Ltd. Inc. All rights reserved.
 */
@Data
@Setter
@Getter
public class TspUserTree {
    /**
     * id : 1001
     * name : admin
     * pId : 1
     */
    private String id;
    private String name;
    private String pId;
}
