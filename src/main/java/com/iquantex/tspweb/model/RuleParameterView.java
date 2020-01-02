package com.iquantex.tspweb.model;

import lombok.Data;

//规则参数接口报文类
@Data
public class RuleParameterView {
    private String fundCode;
    private String paramCode;
    private String paramName;
    private String paramValue;
    private String remark;
    private String ruleId;


    public RuleParameter transferRuleParameter(){
        RuleParameter parameter=new RuleParameter();
        parameter.setFundCode(this.fundCode);
        parameter.setRuleId(this.ruleId);
        parameter.setRemark(this.remark);
        switch (this.paramCode){
            case "D_PARAM1":
                parameter.setdParam1(Double.valueOf(this.paramValue));
                parameter.setdParam1Name(this.paramName);
                break;
            case "D_PARAM2":
                parameter.setdParam2(Double.valueOf(this.paramValue));
                parameter.setdParam2Name(this.paramName);
                break;
            case "D_PARAM3":
                parameter.setdParam3(Double.valueOf(this.paramValue));
                parameter.setdParam3Name(this.paramName);
                break;
            case "D_PARAM4":
                parameter.setdParam4(Double.valueOf(this.paramValue));
                parameter.setdParam4Name(this.paramName);
                break;
            case "D_PARAM5":
                parameter.setdParam5(Double.valueOf(this.paramValue));
                parameter.setdParam5Name(this.paramName);
                break;
            case "V_PARAM1":
                parameter.setvParam1(this.paramValue);
                parameter.setvParam1Name(this.paramName);
                break;
            case "V_PARAM2":
                parameter.setvParam2(this.paramValue);
                parameter.setvParam2Name(this.paramName);
                break;
            case "V_PARAM3":
                parameter.setvParam3(this.paramValue);
                parameter.setvParam3Name(this.paramName);
                break;
            case "V_PARAM4":
                parameter.setvParam4(this.paramValue);
                parameter.setvParam4Name(this.paramName);
                break;
            case "V_PARAM5":
                parameter.setvParam5(this.paramValue);
                parameter.setvParam5Name(this.paramName);
                break;
        }
        return parameter;
    }
}
