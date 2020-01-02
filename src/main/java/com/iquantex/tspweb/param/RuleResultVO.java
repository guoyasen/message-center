package com.iquantex.tspweb.param;

import com.iquantex.tspweb.table.RuleResultTable;
import lombok.Data;

import java.util.List;

/**
 * @Auther: baozi
 * @Date: 2018/11/30 17:35
 * @Description:
 */
@Data
public class RuleResultVO {

    List<HeaderParam> headers;

    List<RuleResultTable> bodys;
}
