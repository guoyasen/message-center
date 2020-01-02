package com.iquantex.tspweb.model;

import java.util.Date;
import javax.persistence.*;
import org.apache.ibatis.type.JdbcType;
import tk.mybatis.mapper.annotation.ColumnType;

@Table(name = "RESULT_ALL_V")
public class ResultAllV {
    @Column(name = "RULE_RESULT_ID")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Long ruleResultId;

    @Column(name = "RULE_ID")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String ruleId;

    @Column(name = "RESULT_STATUS")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Integer resultStatus;

    @Column(name = "INST_ID")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String instId;

    @Column(name = "CHECK_TIME")
    @ColumnType(jdbcType = JdbcType.TIMESTAMP)
    private Date checkTime;

    @Column(name = "DEAL_TIME")
    @ColumnType(jdbcType = JdbcType.TIMESTAMP)
    private Date dealTime;

    @Column(name = "STATUS")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Integer status;

    @Column(name = "SEND_STATUS")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Integer sendStatus;

    @Column(name = "SEND_NAME")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String sendName;

    @Column(name = "SEND_TIME")
    @ColumnType(jdbcType = JdbcType.TIMESTAMP)
    private Date sendTime;

    @Column(name = "DEAL_NAME")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String dealName;

    @Column(name = "INST_STATUS")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String instStatus;

    @Column(name = "INST_CODE")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String instCode;

    @Column(name = "OMBINED_CODE")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String ombinedCode;

    @Column(name = "TRADE_DATE")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Long tradeDate;

    @Column(name = "FUND_CODE")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String fundCode;

    @Column(name = "INST_CREATE_NAME")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String instCreateName;

    @Column(name = "INST_EXECUTION_NAME")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String instExecutionName;

    @Column(name = "SECU_CODE")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String secuCode;

    @Column(name = "TRADE_TYPE_CODE")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Integer tradeTypeCode;

    @Column(name = "AMT")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Double amt;

    @Column(name = "QTY")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Long qty;

    @Column(name = "SECU_TYPE")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Integer secuType;

    @Column(name = "O32_SECU_CODE")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String o32SecuCode;

    @Column(name = "O32_SECU_NAME")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String o32SecuName;

    @Column(name = "IS_LONG_INST")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Integer isLongInst;

    @Column(name = "PRICE")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Double price;

    @Column(name = "ID")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String id;

    @Column(name = "NAME")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String name;

    @Column(name = "TYPE_ID")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String typeId;

    @Column(name = "CUE_FORMAT")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String cueFormat;

    @Column(name = "INFO")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String info;

    @Column(name = "START_TIME")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String startTime;

    @Column(name = "END_TIME")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String endTime;

    @Column(name = "TYPE_NAME")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String typeName;

    @Column(name = "SPEED")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Double speed;

    @Column(name = "VOLUME")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Double volume;

    @Column(name = "ERROR_MESSAGE")
    @ColumnType(jdbcType = JdbcType.CLOB)
    private String errorMessage;

    public static final String TABLE = "RESULT_ALL_V";

    public static final String f_ruleResultId = "ruleResultId";

    public static final String f_ruleId = "ruleId";

    public static final String f_resultStatus = "resultStatus";

    public static final String f_instId = "instId";

    public static final String f_checkTime = "checkTime";

    public static final String f_dealTime = "dealTime";

    public static final String f_status = "status";

    public static final String f_sendStatus = "sendStatus";

    public static final String f_sendName = "sendName";

    public static final String f_sendTime = "sendTime";

    public static final String f_dealName = "dealName";

    public static final String f_instStatus = "instStatus";

    public static final String f_instCode = "instCode";

    public static final String f_ombinedCode = "ombinedCode";

    public static final String f_tradeDate = "tradeDate";

    public static final String f_fundCode = "fundCode";

    public static final String f_instCreateName = "instCreateName";

    public static final String f_instExecutionName = "instExecutionName";

    public static final String f_secuCode = "secuCode";

    public static final String f_tradeTypeCode = "tradeTypeCode";

    public static final String f_amt = "amt";

    public static final String f_qty = "qty";

    public static final String f_secuType = "secuType";

    public static final String f_o32SecuCode = "o32SecuCode";

    public static final String f_o32SecuName = "o32SecuName";

    public static final String f_isLongInst = "isLongInst";

    public static final String f_price = "price";

    public static final String f_id = "id";

    public static final String f_name = "name";

    public static final String f_typeId = "typeId";

    public static final String f_cueFormat = "cueFormat";

    public static final String f_info = "info";

    public static final String f_startTime = "startTime";

    public static final String f_endTime = "endTime";

    public static final String f_typeName = "typeName";

    public static final String f_speed = "speed";

    public static final String f_volume = "volume";

    public static final String f_errorMessage = "errorMessage";

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
     * @return RESULT_STATUS
     */
    public Integer getResultStatus() {
        return resultStatus;
    }

    /**
     * @param resultStatus
     */
    public void setResultStatus(Integer resultStatus) {
        this.resultStatus = resultStatus;
    }

    /**
     * @return INST_ID
     */
    public String getInstId() {
        return instId;
    }

    /**
     * @param instId
     */
    public void setInstId(String instId) {
        this.instId = instId == null ? null : instId.trim();
    }

    /**
     * @return CHECK_TIME
     */
    public Date getCheckTime() {
        return checkTime;
    }

    /**
     * @param checkTime
     */
    public void setCheckTime(Date checkTime) {
        this.checkTime = checkTime;
    }

    /**
     * @return DEAL_TIME
     */
    public Date getDealTime() {
        return dealTime;
    }

    /**
     * @param dealTime
     */
    public void setDealTime(Date dealTime) {
        this.dealTime = dealTime;
    }

    /**
     * @return STATUS
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * @param status
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * @return SEND_STATUS
     */
    public Integer getSendStatus() {
        return sendStatus;
    }

    /**
     * @param sendStatus
     */
    public void setSendStatus(Integer sendStatus) {
        this.sendStatus = sendStatus;
    }

    /**
     * @return SEND_NAME
     */
    public String getSendName() {
        return sendName;
    }

    /**
     * @param sendName
     */
    public void setSendName(String sendName) {
        this.sendName = sendName == null ? null : sendName.trim();
    }

    /**
     * @return SEND_TIME
     */
    public Date getSendTime() {
        return sendTime;
    }

    /**
     * @param sendTime
     */
    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    /**
     * @return DEAL_NAME
     */
    public String getDealName() {
        return dealName;
    }

    /**
     * @param dealName
     */
    public void setDealName(String dealName) {
        this.dealName = dealName == null ? null : dealName.trim();
    }

    /**
     * @return INST_STATUS
     */
    public String getInstStatus() {
        return instStatus;
    }

    /**
     * @param instStatus
     */
    public void setInstStatus(String instStatus) {
        this.instStatus = instStatus == null ? null : instStatus.trim();
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
     * @return OMBINED_CODE
     */
    public String getOmbinedCode() {
        return ombinedCode;
    }

    /**
     * @param ombinedCode
     */
    public void setOmbinedCode(String ombinedCode) {
        this.ombinedCode = ombinedCode == null ? null : ombinedCode.trim();
    }

    /**
     * @return TRADE_DATE
     */
    public Long getTradeDate() {
        return tradeDate;
    }

    /**
     * @param tradeDate
     */
    public void setTradeDate(Long tradeDate) {
        this.tradeDate = tradeDate;
    }

    /**
     * @return FUND_CODE
     */
    public String getFundCode() {
        return fundCode;
    }

    /**
     * @param fundCode
     */
    public void setFundCode(String fundCode) {
        this.fundCode = fundCode == null ? null : fundCode.trim();
    }

    /**
     * @return INST_CREATE_NAME
     */
    public String getInstCreateName() {
        return instCreateName;
    }

    /**
     * @param instCreateName
     */
    public void setInstCreateName(String instCreateName) {
        this.instCreateName = instCreateName == null ? null : instCreateName.trim();
    }

    /**
     * @return INST_EXECUTION_NAME
     */
    public String getInstExecutionName() {
        return instExecutionName;
    }

    /**
     * @param instExecutionName
     */
    public void setInstExecutionName(String instExecutionName) {
        this.instExecutionName = instExecutionName == null ? null : instExecutionName.trim();
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
     * @return TRADE_TYPE_CODE
     */
    public Integer getTradeTypeCode() {
        return tradeTypeCode;
    }

    /**
     * @param tradeTypeCode
     */
    public void setTradeTypeCode(Integer tradeTypeCode) {
        this.tradeTypeCode = tradeTypeCode;
    }

    /**
     * @return AMT
     */
    public Double getAmt() {
        return amt;
    }

    /**
     * @param amt
     */
    public void setAmt(Double amt) {
        this.amt = amt;
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
     * @return SECU_TYPE
     */
    public Integer getSecuType() {
        return secuType;
    }

    /**
     * @param secuType
     */
    public void setSecuType(Integer secuType) {
        this.secuType = secuType;
    }

    /**
     * @return O32_SECU_CODE
     */
    public String getO32SecuCode() {
        return o32SecuCode;
    }

    /**
     * @param o32SecuCode
     */
    public void setO32SecuCode(String o32SecuCode) {
        this.o32SecuCode = o32SecuCode == null ? null : o32SecuCode.trim();
    }

    /**
     * @return O32_SECU_NAME
     */
    public String getO32SecuName() {
        return o32SecuName;
    }

    /**
     * @param o32SecuName
     */
    public void setO32SecuName(String o32SecuName) {
        this.o32SecuName = o32SecuName == null ? null : o32SecuName.trim();
    }

    /**
     * @return IS_LONG_INST
     */
    public Integer getIsLongInst() {
        return isLongInst;
    }

    /**
     * @param isLongInst
     */
    public void setIsLongInst(Integer isLongInst) {
        this.isLongInst = isLongInst;
    }

    /**
     * @return PRICE
     */
    public Double getPrice() {
        return price;
    }

    /**
     * @param price
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * @return ID
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * @return NAME
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * @return TYPE_ID
     */
    public String getTypeId() {
        return typeId;
    }

    /**
     * @param typeId
     */
    public void setTypeId(String typeId) {
        this.typeId = typeId == null ? null : typeId.trim();
    }

    /**
     * @return CUE_FORMAT
     */
    public String getCueFormat() {
        return cueFormat;
    }

    /**
     * @param cueFormat
     */
    public void setCueFormat(String cueFormat) {
        this.cueFormat = cueFormat == null ? null : cueFormat.trim();
    }

    /**
     * @return INFO
     */
    public String getInfo() {
        return info;
    }

    /**
     * @param info
     */
    public void setInfo(String info) {
        this.info = info == null ? null : info.trim();
    }

    /**
     * @return START_TIME
     */
    public String getStartTime() {
        return startTime;
    }

    /**
     * @param startTime
     */
    public void setStartTime(String startTime) {
        this.startTime = startTime == null ? null : startTime.trim();
    }

    /**
     * @return END_TIME
     */
    public String getEndTime() {
        return endTime;
    }

    /**
     * @param endTime
     */
    public void setEndTime(String endTime) {
        this.endTime = endTime == null ? null : endTime.trim();
    }

    /**
     * @return TYPE_NAME
     */
    public String getTypeName() {
        return typeName;
    }

    /**
     * @param typeName
     */
    public void setTypeName(String typeName) {
        this.typeName = typeName == null ? null : typeName.trim();
    }

    /**
     * @return SPEED
     */
    public Double getSpeed() {
        return speed;
    }

    /**
     * @param speed
     */
    public void setSpeed(Double speed) {
        this.speed = speed;
    }

    /**
     * @return VOLUME
     */
    public Double getVolume() {
        return volume;
    }

    /**
     * @param volume
     */
    public void setVolume(Double volume) {
        this.volume = volume;
    }

    /**
     * @return ERROR_MESSAGE
     */
    public String getErrorMessage() {
        return errorMessage;
    }

    /**
     * @param errorMessage
     */
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage == null ? null : errorMessage.trim();
    }
}