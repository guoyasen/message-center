package com.iquantex.tspweb.table;

import com.iquantex.tspconst.api.RuleConst;
import com.iquantex.tspweb.model.InstInfo;
import com.iquantex.tspweb.model.ResultAllV;
import com.iquantex.tspweb.model.RuleResult;
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
 * km当日投资建议流程
 *
 * @author shenzhengjie
 * @date 2019/4/15 17:09
 */
@Slf4j
@Getter
@Setter
@NoArgsConstructor
public class R014 extends RuleResultTable {

    public static List<HeaderParam> getHeaderParam() {
        List<HeaderParam> headers = new ArrayList<>();
        //headers.add(new HeaderParam("ruleName", "规则名称"));
        headers.add(new HeaderParam(RuleConst.PROCESS_INST_ID, "流程id"));
        headers.add(new HeaderParam(RuleConst.OPERATOR_NAME, "发起人"));
        headers.add(new HeaderParam(RuleConst.DEPARTMENT, "部门"));
        headers.add(new HeaderParam(RuleConst.FUND_NAME, "组合名称"));
        headers.add(new HeaderParam(RuleConst.TITLE, "标题"));
        headers.add(new HeaderParam(RuleConst.CONTENT, "内容"));
        headers.add(new HeaderParam(RuleConst.CREATEDATE, "创建时间"));
        return headers;
    }

    public R014(ResultAllV allV, List<RuleResultFactor> factors) {
        // 组装公共字段信息
        super(allV);

        // 组装特殊字段信息
        Map<String, String> map = new HashMap<>();
        for (RuleResultFactor factor : factors) {
            map.put(factor.getFactorKey(), factor.getFactorValue());
        }

        this.processInstId = map.get(RuleConst.PROCESS_INST_ID);
        this.operatorName = map.get(RuleConst.OPERATOR_NAME);
        this.department = map.get(RuleConst.DEPARTMENT);
        this.fundName = map.get(RuleConst.FUND_NAME);
        this.title = map.get(RuleConst.TITLE);
        this.content = map.get(RuleConst.CONTENT);
        this.createDate = map.get(RuleConst.CREATEDATE);


        log.debug("< " + this.getClass().getSimpleName() + ">" + " : End of conversion. ");
    }

    /**流程id**/
    private  String processInstId;
    /**发起人**/
    private  String operatorName;
    /**部门**/
    private  String department;
    /**组合名称**/
    private String fundName;
    /**标题**/
    private String title;
    /**内容**/
    private String content;
    /**创建时间**/
    private String createDate;
}
