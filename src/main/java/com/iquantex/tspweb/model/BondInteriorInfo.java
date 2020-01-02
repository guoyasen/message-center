package com.iquantex.tspweb.model;

import lombok.Data;

/**
 * 股票行情
 *
 * @author xiangpeng;
 *
 * @date 2019/01/17-16:53;
 * @Copyright: Copyright (c) 2018 Fullgoal Fund Management  Co., Ltd. Inc. All rights reserved.
 */
@Data
public class BondInteriorInfo {

    /**
     * 证券wind编码<>c02_etf_fnd_bsc_infr .scrt_cd
     */
    private String scrtCd;


    /**
     * 债券是否减持债
     */
    private  String riskyBond;


    /**
     * 债券内部评级
     */
    private String kmBondRate;



}
