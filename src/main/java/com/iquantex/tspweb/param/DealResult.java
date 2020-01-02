package com.iquantex.tspweb.param;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
public class DealResult {

    /**
     * 处理结果id
     */
    private Long ruleResultId;

    /**
     * 处理人
     */
    private String dealId;


    /**
     * 处理时间
     */
    private String dealTime;

    /**
     * 处理状态
     * 成功 or 失败
     */
    private String dealStatus;
}
