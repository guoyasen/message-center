/**
 * @program: tsp-market
 * @description:
 * @author: dzy
 * @create: 2019-02-20 16:23
 **/

package com.iquantex.tspweb.param;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class props {
    String ruleId;
    String typeId;
    String idempotentKey;
    Integer handle;
}
