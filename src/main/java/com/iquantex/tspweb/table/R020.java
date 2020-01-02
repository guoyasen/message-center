package com.iquantex.tspweb.table;

import com.iquantex.tspconst.api.RuleConst;
import com.iquantex.tspweb.model.ResultAllV;
import com.iquantex.tspweb.model.RuleResultFactor;
import com.iquantex.tspweb.param.HeaderParam;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 银行间交易成交单确认提醒
 *
 * @author 向鹏
 * @date 2019/8/19 17:09
 */
@Slf4j
@Getter
@Setter
@NoArgsConstructor
public class R020 extends RuleResultTable {

    public static List<HeaderParam> getHeaderParam() {
        List<HeaderParam> headers = new ArrayList<>();
        headers.add(new HeaderParam("ruleName", "规则名称"));
        //headers.add(new HeaderParam(RuleConst.INST_CODE, "指令序号"));
        //headers.add(new HeaderParam(RuleConst.EXECUTION_CODE, "成交单号"));
        //headers.add(new HeaderParam(RuleConst.ACCOUNT, "本方账号"));
        //headers.add(new HeaderParam(RuleConst.OPPOSITE_ACCOUNT, "对方账号"));
        headers.add(new HeaderParam(RuleConst.CREATEDATE, "创建时间"));
        return headers;
    }

    public R020(ResultAllV allV, List<RuleResultFactor> factors) {
        // 组装公共字段信息
        super(allV);

        // 组装特殊字段信息
        Map<String, String> map = new HashMap<>();
        for (RuleResultFactor factor : factors) {
            map.put(factor.getFactorKey(), factor.getFactorValue());
        }
        //this.instCode = map.get(RuleConst.INST_CODE);
        //this.executionCode = map.get(RuleConst.EXECUTION_CODE);
        //this.account = map.get(RuleConst.ACCOUNT);
        //this.oppositeAccount = map.get(RuleConst.OPPOSITE_ACCOUNT);
        this.createDate = map.get(RuleConst.CREATEDATE);
        log.debug("< " + this.getClass().getSimpleName() + ">" + " : End of conversion. ");
    }

    //指令序号
    //private String instCode;
    //成交单号
    //private String executionCode;
    //本方账号
    //private String account;
    //对方账号
    //private String oppositeAccount;
    //创建时间
    private String  createDate;
}
