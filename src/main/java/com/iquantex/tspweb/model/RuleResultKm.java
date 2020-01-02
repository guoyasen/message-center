package com.iquantex.tspweb.model;

import javax.persistence.*;
import org.apache.ibatis.type.JdbcType;
import tk.mybatis.mapper.annotation.ColumnType;

@Table(name = "RULE_RESULT_KM")
public class RuleResultKm {
    @Column(name = "RULE_ID")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String ruleId;

    @Column(name = "RULE_RESULT_ID")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Long ruleResultId;

    @Column(name = "CHECK_TM")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String checkTm;

    @Column(name = "OPERATOR_NM")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String operatorNm;

    @Column(name = "RULE_NM")
    @ColumnType(jdbcType = JdbcType.CHAR)
    private String ruleNm;

    @Column(name = "INST_CODE")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String instCode;

    @Column(name = "TRADE_DIC")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String tradeDic;

    @Column(name = "FND_FLL_NM")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String fndFllNm;

    @Column(name = "N_INSTITUTIONAL_SHARE")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Double nInstitutionalShare;

    @Column(name = "N_NOINSTITUTIONAL_VALUE")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Double nNoinstitutionalValue;

    @Column(name = "VC_DEALCODE")
    @ColumnType(jdbcType = JdbcType.CHAR)
    private String vcDealcode;

    @Column(name = "N_BOND_VALUE")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Double nBondValue;

    @Column(name = "N_INVESTVALUE")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Double nInvestvalue;

    @Column(name = "SECU_CODE")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String secuCode;

    @Column(name = "N_COMYIEDS")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Double nComyieds;

    @Column(name = "N_VALUYIEDS")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Double nValuyieds;

    @Column(name = "DEVIATION")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Integer deviation;

    @Column(name = "QTY")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Long qty;

    @Column(name = "ORDER_DATA")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String orderData;

    public static final String TABLE = "RULE_RESULT_KM";

    public static final String f_ruleId = "ruleId";

    public static final String f_ruleResultId = "ruleResultId";

    public static final String f_checkTm = "checkTm";

    public static final String f_operatorNm = "operatorNm";

    public static final String f_ruleNm = "ruleNm";

    public static final String f_instCode = "instCode";

    public static final String f_tradeDic = "tradeDic";

    public static final String f_fndFllNm = "fndFllNm";

    public static final String f_nInstitutionalShare = "nInstitutionalShare";

    public static final String f_nNoinstitutionalValue = "nNoinstitutionalValue";

    public static final String f_vcDealcode = "vcDealcode";

    public static final String f_nBondValue = "nBondValue";

    public static final String f_nInvestvalue = "nInvestvalue";

    public static final String f_secuCode = "secuCode";

    public static final String f_nComyieds = "nComyieds";

    public static final String f_nValuyieds = "nValuyieds";

    public static final String f_deviation = "deviation";

    public static final String f_qty = "qty";

    public static final String f_orderData = "orderData";

    /**
     * @return RULE_ID
     */
    public String getRuleId() {
        return ruleId;
    }

    /**
     * @param ruleId
     */
    public void setRuleId(String ruleId) {
        this.ruleId = ruleId == null ? null : ruleId.trim();
    }

    /**
     * @return RULE_RESULT_ID
     */
    public Long getRuleResultId() {
        return ruleResultId;
    }

    /**
     * @param ruleResultId
     */
    public void setRuleResultId(Long ruleResultId) {
        this.ruleResultId = ruleResultId;
    }

    /**
     * @return CHECK_TM
     */
    public String getCheckTm() {
        return checkTm;
    }

    /**
     * @param checkTm
     */
    public void setCheckTm(String checkTm) {
        this.checkTm = checkTm == null ? null : checkTm.trim();
    }

    /**
     * @return OPERATOR_NM
     */
    public String getOperatorNm() {
        return operatorNm;
    }

    /**
     * @param operatorNm
     */
    public void setOperatorNm(String operatorNm) {
        this.operatorNm = operatorNm == null ? null : operatorNm.trim();
    }

    /**
     * @return RULE_NM
     */
    public String getRuleNm() {
        return ruleNm;
    }

    /**
     * @param ruleNm
     */
    public void setRuleNm(String ruleNm) {
        this.ruleNm = ruleNm == null ? null : ruleNm.trim();
    }

    /**
     * @return INST_CODE
     */
    public String getInstCode() {
        return instCode;
    }

    /**
     * @param instCode
     */
    public void setInstCode(String instCode) {
        this.instCode = instCode == null ? null : instCode.trim();
    }

    /**
     * @return TRADE_DIC
     */
    public String getTradeDic() {
        return tradeDic;
    }

    /**
     * @param tradeDic
     */
    public void setTradeDic(String tradeDic) {
        this.tradeDic = tradeDic == null ? null : tradeDic.trim();
    }

    /**
     * @return FND_FLL_NM
     */
    public String getFndFllNm() {
        return fndFllNm;
    }

    /**
     * @param fndFllNm
     */
    public void setFndFllNm(String fndFllNm) {
        this.fndFllNm = fndFllNm == null ? null : fndFllNm.trim();
    }

    /**
     * @return N_INSTITUTIONAL_SHARE
     */
    public Double getnInstitutionalShare() {
        return nInstitutionalShare;
    }

    /**
     * @param nInstitutionalShare
     */
    public void setnInstitutionalShare(Double nInstitutionalShare) {
        this.nInstitutionalShare = nInstitutionalShare;
    }

    /**
     * @return N_NOINSTITUTIONAL_VALUE
     */
    public Double getnNoinstitutionalValue() {
        return nNoinstitutionalValue;
    }

    /**
     * @param nNoinstitutionalValue
     */
    public void setnNoinstitutionalValue(Double nNoinstitutionalValue) {
        this.nNoinstitutionalValue = nNoinstitutionalValue;
    }

    /**
     * @return VC_DEALCODE
     */
    public String getVcDealcode() {
        return vcDealcode;
    }

    /**
     * @param vcDealcode
     */
    public void setVcDealcode(String vcDealcode) {
        this.vcDealcode = vcDealcode == null ? null : vcDealcode.trim();
    }

    /**
     * @return N_BOND_VALUE
     */
    public Double getnBondValue() {
        return nBondValue;
    }

    /**
     * @param nBondValue
     */
    public void setnBondValue(Double nBondValue) {
        this.nBondValue = nBondValue;
    }

    /**
     * @return N_INVESTVALUE
     */
    public Double getnInvestvalue() {
        return nInvestvalue;
    }

    /**
     * @param nInvestvalue
     */
    public void setnInvestvalue(Double nInvestvalue) {
        this.nInvestvalue = nInvestvalue;
    }

    /**
     * @return SECU_CODE
     */
    public String getSecuCode() {
        return secuCode;
    }

    /**
     * @param secuCode
     */
    public void setSecuCode(String secuCode) {
        this.secuCode = secuCode == null ? null : secuCode.trim();
    }

    /**
     * @return N_COMYIEDS
     */
    public Double getnComyieds() {
        return nComyieds;
    }

    /**
     * @param nComyieds
     */
    public void setnComyieds(Double nComyieds) {
        this.nComyieds = nComyieds;
    }

    /**
     * @return N_VALUYIEDS
     */
    public Double getnValuyieds() {
        return nValuyieds;
    }

    /**
     * @param nValuyieds
     */
    public void setnValuyieds(Double nValuyieds) {
        this.nValuyieds = nValuyieds;
    }

    /**
     * @return DEVIATION
     */
    public Integer getDeviation() {
        return deviation;
    }

    /**
     * @param deviation
     */
    public void setDeviation(Integer deviation) {
        this.deviation = deviation;
    }

    /**
     * @return QTY
     */
    public Long getQty() {
        return qty;
    }

    /**
     * @param qty
     */
    public void setQty(Long qty) {
        this.qty = qty;
    }

    /**
     * @return ORDER_DATA
     */
    public String getOrderData() {
        return orderData;
    }

    /**
     * @param orderData
     */
    public void setOrderData(String orderData) {
        this.orderData = orderData == null ? null : orderData.trim();
    }
}