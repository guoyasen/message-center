package com.iquantex.tspweb.table;

import com.alibaba.fastjson.JSONObject;
import com.iquantex.tspweb.model.ResultAllV;
import com.iquantex.tspweb.model.RuleResultFactor;
import com.iquantex.tspweb.param.HeaderParam;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Method;
import java.util.List;

/**
 * table工具类
 *
 * @author shenzhengjie
 * @date 2019/1/9 14:40
 */
@Slf4j
public class RuleResultTableUtils {

    private static final String RULE_PACKAGE_DIR = "com.iquantex.tspweb.table";
    private static final String HEADER_METHOD_NAME = "getHeaderParam";

    public static RuleResultTable getTableBodyByRuleId(ResultAllV resultAllV, List<RuleResultFactor> ruleResultFactorList) {
        String ruleClassName = RULE_PACKAGE_DIR + "." + resultAllV.getRuleId();
        try {
            Class ruleClass = Class.forName(ruleClassName);
            RuleResultTable ruleBody = (RuleResultTable) ruleClass.getConstructor(ResultAllV.class, List.class).newInstance(resultAllV, ruleResultFactorList);
            return ruleBody;
        } catch (Exception e) {
            log.error(String.format("getTableError:%s, RuleTableVO<%s>, RuleResultFactorList<%s>", e.getMessage(), JSONObject.toJSONString(resultAllV), JSONObject.toJSONString(ruleResultFactorList)), e);
        }
        return null;
    }

    public static List<HeaderParam> getHeaderParamByRuleId(String ruleId) {
        String ruleClassName = RULE_PACKAGE_DIR + "." + ruleId;
        try {
            Class ruleClass = Class.forName(ruleClassName);
            Method method = ruleClass.getMethod(HEADER_METHOD_NAME, null);
            List<HeaderParam> headerParams = (List<HeaderParam>) method.invoke(null);
            return headerParams;
        } catch (Exception e) {
            log.error(String.format("getHeaderError:%s, RuleId<%s>", e.getMessage(), ruleId), e);
        }
        return null;
    }
}
