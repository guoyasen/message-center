package com.iquantex.tspweb.model;

import javax.persistence.*;
import org.apache.ibatis.type.JdbcType;
import tk.mybatis.mapper.annotation.ColumnType;

@Table(name = "RULE_PARAMETER")
public class RuleParameter {
    /**
     * 基金代码
     */
    @Id
    @Column(name = "FUND_CODE")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String fundCode;

    /**
     * 规则id
     */
    @Id
    @Column(name = "RULE_ID")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String ruleId;

    /**
     * double参数1
     */
    @Column(name = "D_PARAM1")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Double dParam1;

    /**
     * double参数2
     */
    @Column(name = "D_PARAM2")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Double dParam2;

    /**
     * double参数3
     */
    @Column(name = "D_PARAM3")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Double dParam3;

    /**
     * double参数4
     */
    @Column(name = "D_PARAM4")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Double dParam4;

    /**
     * double参数5
     */
    @Column(name = "D_PARAM5")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Double dParam5;

    /**
     * varchar参数1
     */
    @Column(name = "V_PARAM1")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String vParam1;

    /**
     * varchar参数2
     */
    @Column(name = "V_PARAM2")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String vParam2;

    /**
     * varchar参数3
     */
    @Column(name = "V_PARAM3")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String vParam3;

    /**
     * varchar参数4
     */
    @Column(name = "V_PARAM4")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String vParam4;

    /**
     * varchar参数5
     */
    @Column(name = "V_PARAM5")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String vParam5;

    /**
     * double参数1说明
     */
    @Column(name = "D_PARAM1_NAME")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String dParam1Name;

    /**
     * double参数2说明
     */
    @Column(name = "D_PARAM2_NAME")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String dParam2Name;

    /**
     * double参数3说明
     */
    @Column(name = "D_PARAM3_NAME")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String dParam3Name;

    /**
     * double参数4说明
     */
    @Column(name = "D_PARAM4_NAME")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String dParam4Name;

    /**
     * double参数5说明
     */
    @Column(name = "D_PARAM5_NAME")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String dParam5Name;

    /**
     * varchar参数1说明
     */
    @Column(name = "V_PARAM1_NAME")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String vParam1Name;

    /**
     * varchar参数2说明
     */
    @Column(name = "V_PARAM2_NAME")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String vParam2Name;

    /**
     * varchar参数3说明
     */
    @Column(name = "V_PARAM3_NAME")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String vParam3Name;

    /**
     * varchar参数4说明
     */
    @Column(name = "V_PARAM4_NAME")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String vParam4Name;

    /**
     * varchar参数5说明
     */
    @Column(name = "V_PARAM5_NAME")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String vParam5Name;

    /**
     * 描述
     */
    @Column(name = "REMARK")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String remark;

    public static final String TABLE = "RULE_PARAMETER";

    public static final String f_fundCode = "fundCode";

    public static final String f_ruleId = "ruleId";

    public static final String f_dParam1 = "dParam1";

    public static final String f_dParam2 = "dParam2";

    public static final String f_dParam3 = "dParam3";

    public static final String f_dParam4 = "dParam4";

    public static final String f_dParam5 = "dParam5";

    public static final String f_vParam1 = "vParam1";

    public static final String f_vParam2 = "vParam2";

    public static final String f_vParam3 = "vParam3";

    public static final String f_vParam4 = "vParam4";

    public static final String f_vParam5 = "vParam5";

    public static final String f_dParam1Name = "dParam1Name";

    public static final String f_dParam2Name = "dParam2Name";

    public static final String f_dParam3Name = "dParam3Name";

    public static final String f_dParam4Name = "dParam4Name";

    public static final String f_dParam5Name = "dParam5Name";

    public static final String f_vParam1Name = "vParam1Name";

    public static final String f_vParam2Name = "vParam2Name";

    public static final String f_vParam3Name = "vParam3Name";

    public static final String f_vParam4Name = "vParam4Name";

    public static final String f_vParam5Name = "vParam5Name";

    public static final String f_remark = "remark";

    /**
     * 获取基金代码
     *
     * @return FUND_CODE - 基金代码
     */
    public String getFundCode() {
        return fundCode;
    }

    /**
     * 设置基金代码
     *
     * @param fundCode 基金代码
     */
    public void setFundCode(String fundCode) {
        this.fundCode = fundCode == null ? null : fundCode.trim();
    }

    /**
     * 获取规则id
     *
     * @return RULE_ID - 规则id
     */
    public String getRuleId() {
        return ruleId;
    }

    /**
     * 设置规则id
     *
     * @param ruleId 规则id
     */
    public void setRuleId(String ruleId) {
        this.ruleId = ruleId == null ? null : ruleId.trim();
    }

    /**
     * 获取double参数1
     *
     * @return D_PARAM1 - double参数1
     */
    public Double getdParam1() {
        return dParam1;
    }

    /**
     * 设置double参数1
     *
     * @param dParam1 double参数1
     */
    public void setdParam1(Double dParam1) {
        this.dParam1 = dParam1;
    }

    /**
     * 获取double参数2
     *
     * @return D_PARAM2 - double参数2
     */
    public Double getdParam2() {
        return dParam2;
    }

    /**
     * 设置double参数2
     *
     * @param dParam2 double参数2
     */
    public void setdParam2(Double dParam2) {
        this.dParam2 = dParam2;
    }

    /**
     * 获取double参数3
     *
     * @return D_PARAM3 - double参数3
     */
    public Double getdParam3() {
        return dParam3;
    }

    /**
     * 设置double参数3
     *
     * @param dParam3 double参数3
     */
    public void setdParam3(Double dParam3) {
        this.dParam3 = dParam3;
    }

    /**
     * 获取double参数4
     *
     * @return D_PARAM4 - double参数4
     */
    public Double getdParam4() {
        return dParam4;
    }

    /**
     * 设置double参数4
     *
     * @param dParam4 double参数4
     */
    public void setdParam4(Double dParam4) {
        this.dParam4 = dParam4;
    }

    /**
     * 获取double参数5
     *
     * @return D_PARAM5 - double参数5
     */
    public Double getdParam5() {
        return dParam5;
    }

    /**
     * 设置double参数5
     *
     * @param dParam5 double参数5
     */
    public void setdParam5(Double dParam5) {
        this.dParam5 = dParam5;
    }

    /**
     * 获取varchar参数1
     *
     * @return V_PARAM1 - varchar参数1
     */
    public String getvParam1() {
        return vParam1;
    }

    /**
     * 设置varchar参数1
     *
     * @param vParam1 varchar参数1
     */
    public void setvParam1(String vParam1) {
        this.vParam1 = vParam1 == null ? null : vParam1.trim();
    }

    /**
     * 获取varchar参数2
     *
     * @return V_PARAM2 - varchar参数2
     */
    public String getvParam2() {
        return vParam2;
    }

    /**
     * 设置varchar参数2
     *
     * @param vParam2 varchar参数2
     */
    public void setvParam2(String vParam2) {
        this.vParam2 = vParam2 == null ? null : vParam2.trim();
    }

    /**
     * 获取varchar参数3
     *
     * @return V_PARAM3 - varchar参数3
     */
    public String getvParam3() {
        return vParam3;
    }

    /**
     * 设置varchar参数3
     *
     * @param vParam3 varchar参数3
     */
    public void setvParam3(String vParam3) {
        this.vParam3 = vParam3 == null ? null : vParam3.trim();
    }

    /**
     * 获取varchar参数4
     *
     * @return V_PARAM4 - varchar参数4
     */
    public String getvParam4() {
        return vParam4;
    }

    /**
     * 设置varchar参数4
     *
     * @param vParam4 varchar参数4
     */
    public void setvParam4(String vParam4) {
        this.vParam4 = vParam4 == null ? null : vParam4.trim();
    }

    /**
     * 获取varchar参数5
     *
     * @return V_PARAM5 - varchar参数5
     */
    public String getvParam5() {
        return vParam5;
    }

    /**
     * 设置varchar参数5
     *
     * @param vParam5 varchar参数5
     */
    public void setvParam5(String vParam5) {
        this.vParam5 = vParam5 == null ? null : vParam5.trim();
    }

    /**
     * 获取double参数1说明
     *
     * @return D_PARAM1_NAME - double参数1说明
     */
    public String getdParam1Name() {
        return dParam1Name;
    }

    /**
     * 设置double参数1说明
     *
     * @param dParam1Name double参数1说明
     */
    public void setdParam1Name(String dParam1Name) {
        this.dParam1Name = dParam1Name == null ? null : dParam1Name.trim();
    }

    /**
     * 获取double参数2说明
     *
     * @return D_PARAM2_NAME - double参数2说明
     */
    public String getdParam2Name() {
        return dParam2Name;
    }

    /**
     * 设置double参数2说明
     *
     * @param dParam2Name double参数2说明
     */
    public void setdParam2Name(String dParam2Name) {
        this.dParam2Name = dParam2Name == null ? null : dParam2Name.trim();
    }

    /**
     * 获取double参数3说明
     *
     * @return D_PARAM3_NAME - double参数3说明
     */
    public String getdParam3Name() {
        return dParam3Name;
    }

    /**
     * 设置double参数3说明
     *
     * @param dParam3Name double参数3说明
     */
    public void setdParam3Name(String dParam3Name) {
        this.dParam3Name = dParam3Name == null ? null : dParam3Name.trim();
    }

    /**
     * 获取double参数4说明
     *
     * @return D_PARAM4_NAME - double参数4说明
     */
    public String getdParam4Name() {
        return dParam4Name;
    }

    /**
     * 设置double参数4说明
     *
     * @param dParam4Name double参数4说明
     */
    public void setdParam4Name(String dParam4Name) {
        this.dParam4Name = dParam4Name == null ? null : dParam4Name.trim();
    }

    /**
     * 获取double参数5说明
     *
     * @return D_PARAM5_NAME - double参数5说明
     */
    public String getdParam5Name() {
        return dParam5Name;
    }

    /**
     * 设置double参数5说明
     *
     * @param dParam5Name double参数5说明
     */
    public void setdParam5Name(String dParam5Name) {
        this.dParam5Name = dParam5Name == null ? null : dParam5Name.trim();
    }

    /**
     * 获取varchar参数1说明
     *
     * @return V_PARAM1_NAME - varchar参数1说明
     */
    public String getvParam1Name() {
        return vParam1Name;
    }

    /**
     * 设置varchar参数1说明
     *
     * @param vParam1Name varchar参数1说明
     */
    public void setvParam1Name(String vParam1Name) {
        this.vParam1Name = vParam1Name == null ? null : vParam1Name.trim();
    }

    /**
     * 获取varchar参数2说明
     *
     * @return V_PARAM2_NAME - varchar参数2说明
     */
    public String getvParam2Name() {
        return vParam2Name;
    }

    /**
     * 设置varchar参数2说明
     *
     * @param vParam2Name varchar参数2说明
     */
    public void setvParam2Name(String vParam2Name) {
        this.vParam2Name = vParam2Name == null ? null : vParam2Name.trim();
    }

    /**
     * 获取varchar参数3说明
     *
     * @return V_PARAM3_NAME - varchar参数3说明
     */
    public String getvParam3Name() {
        return vParam3Name;
    }

    /**
     * 设置varchar参数3说明
     *
     * @param vParam3Name varchar参数3说明
     */
    public void setvParam3Name(String vParam3Name) {
        this.vParam3Name = vParam3Name == null ? null : vParam3Name.trim();
    }

    /**
     * 获取varchar参数4说明
     *
     * @return V_PARAM4_NAME - varchar参数4说明
     */
    public String getvParam4Name() {
        return vParam4Name;
    }

    /**
     * 设置varchar参数4说明
     *
     * @param vParam4Name varchar参数4说明
     */
    public void setvParam4Name(String vParam4Name) {
        this.vParam4Name = vParam4Name == null ? null : vParam4Name.trim();
    }

    /**
     * 获取varchar参数5说明
     *
     * @return V_PARAM5_NAME - varchar参数5说明
     */
    public String getvParam5Name() {
        return vParam5Name;
    }

    /**
     * 设置varchar参数5说明
     *
     * @param vParam5Name varchar参数5说明
     */
    public void setvParam5Name(String vParam5Name) {
        this.vParam5Name = vParam5Name == null ? null : vParam5Name.trim();
    }

    /**
     * 获取描述
     *
     * @return REMARK - 描述
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置描述
     *
     * @param remark 描述
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}