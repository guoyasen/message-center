package com.iquantex.tspweb.model;

import java.util.Date;
import javax.persistence.*;
import org.apache.ibatis.type.JdbcType;
import tk.mybatis.mapper.annotation.ColumnType;

@Table(name = "INST_INFO")
public class InstInfo {
    /**
     * 指令编号
     */
    @Id
    @Column(name = "INST_CODE")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String instCode;

    /**
     * 组合序号
     */
    @Column(name = "OMBINED_CODE")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String ombinedCode;

    /**
     * 交易日期
     */
    @Column(name = "TRADE_DATE")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Long tradeDate;

    /**
     * 基金序号
     */
    @Column(name = "FUND_CODE")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String fundCode;

    /**
     * 指令下达人
     */
    @Column(name = "INST_CREATE_NAME")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String instCreateName;

    /**
     * 指令执行人
     */
    @Column(name = "INST_EXECUTION_NAME")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String instExecutionName;

    /**
     * 证券代码
     */
    @Column(name = "SECU_CODE")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String secuCode;

    /**
     * 委托方向<>stockBuy=1=股票买入&stockSell=2=股票卖出&bondBuy=3=债券买入&bondSell=4=债券卖出
     */
    @Column(name = "TRADE_TYPE_CODE")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Integer tradeTypeCode;

    /**
     * 指令金额
     */
    @Column(name = "AMT")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Double amt;

    /**
     * 指令数量
     */
    @Column(name = "QTY")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Long qty;

    /**
     * 投资类型<>trade=1=可交易&maturity=2=持有到期&canSell=3=可供出售&other=4=贷款和应收款项
     */
    @Column(name = "SECU_TYPE")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Integer secuType;

    /**
     * O32证券代码
     */
    @Column(name = "O32_SECU_CODE")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String o32SecuCode;

    /**
     * 是否长单<>true=1=是&false=0=否
     */
    @Column(name = "IS_LONG_INST")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Integer isLongInst;

    /**
     * 指令价格
     */
    @Column(name = "PRICE")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Double price;

    @Column(name = "SYSTEM_TIME")
    @ColumnType(jdbcType = JdbcType.TIMESTAMP)
    private Date systemTime;

    /**
     * O32证券名称
     */
    @Column(name = "O32_SECU_NAME")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String o32SecuName;

    public static final String TABLE = "INST_INFO";

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

    public static final String f_isLongInst = "isLongInst";

    public static final String f_price = "price";

    public static final String f_systemTime = "systemTime";

    public static final String f_o32SecuName = "o32SecuName";

    /**
     * 股票买入
     */
    public static final Integer c_tradeTypeCode_stockBuy = 1;

    /**
     * 股票卖出
     */
    public static final Integer c_tradeTypeCode_stockSell = 2;

    /**
     * 债券买入
     */
    public static final Integer c_tradeTypeCode_bondBuy = 3;

    /**
     * 债券卖出
     */
    public static final Integer c_tradeTypeCode_bondSell = 4;

    /**
     * 可交易
     */
    public static final Integer c_secuType_trade = 1;

    /**
     * 持有到期
     */
    public static final Integer c_secuType_maturity = 2;

    /**
     * 可供出售
     */
    public static final Integer c_secuType_canSell = 3;

    /**
     * 贷款和应收款项
     */
    public static final Integer c_secuType_other = 4;

    /**
     * 是
     */
    public static final Integer c_isLongInst_true = 1;

    /**
     * 否
     */
    public static final Integer c_isLongInst_false = 0;

    /**
     * 获取指令编号
     *
     * @return INST_CODE - 指令编号
     */
    public String getInstCode() {
        return instCode;
    }

    /**
     * 设置指令编号
     *
     * @param instCode 指令编号
     */
    public void setInstCode(String instCode) {
        this.instCode = instCode == null ? null : instCode.trim();
    }

    /**
     * 获取组合序号
     *
     * @return OMBINED_CODE - 组合序号
     */
    public String getOmbinedCode() {
        return ombinedCode;
    }

    /**
     * 设置组合序号
     *
     * @param ombinedCode 组合序号
     */
    public void setOmbinedCode(String ombinedCode) {
        this.ombinedCode = ombinedCode == null ? null : ombinedCode.trim();
    }

    /**
     * 获取交易日期
     *
     * @return TRADE_DATE - 交易日期
     */
    public Long getTradeDate() {
        return tradeDate;
    }

    /**
     * 设置交易日期
     *
     * @param tradeDate 交易日期
     */
    public void setTradeDate(Long tradeDate) {
        this.tradeDate = tradeDate;
    }

    /**
     * 获取基金序号
     *
     * @return FUND_CODE - 基金序号
     */
    public String getFundCode() {
        return fundCode;
    }

    /**
     * 设置基金序号
     *
     * @param fundCode 基金序号
     */
    public void setFundCode(String fundCode) {
        this.fundCode = fundCode == null ? null : fundCode.trim();
    }

    /**
     * 获取指令下达人
     *
     * @return INST_CREATE_NAME - 指令下达人
     */
    public String getInstCreateName() {
        return instCreateName;
    }

    /**
     * 设置指令下达人
     *
     * @param instCreateName 指令下达人
     */
    public void setInstCreateName(String instCreateName) {
        this.instCreateName = instCreateName == null ? null : instCreateName.trim();
    }

    /**
     * 获取指令执行人
     *
     * @return INST_EXECUTION_NAME - 指令执行人
     */
    public String getInstExecutionName() {
        return instExecutionName;
    }

    /**
     * 设置指令执行人
     *
     * @param instExecutionName 指令执行人
     */
    public void setInstExecutionName(String instExecutionName) {
        this.instExecutionName = instExecutionName == null ? null : instExecutionName.trim();
    }

    /**
     * 获取证券代码
     *
     * @return SECU_CODE - 证券代码
     */
    public String getSecuCode() {
        return secuCode;
    }

    /**
     * 设置证券代码
     *
     * @param secuCode 证券代码
     */
    public void setSecuCode(String secuCode) {
        this.secuCode = secuCode == null ? null : secuCode.trim();
    }

    /**
     * 获取委托方向<>stockBuy=1=股票买入&stockSell=2=股票卖出&bondBuy=3=债券买入&bondSell=4=债券卖出
     *
     * @return TRADE_TYPE_CODE - 委托方向<>stockBuy=1=股票买入&stockSell=2=股票卖出&bondBuy=3=债券买入&bondSell=4=债券卖出
     */
    public Integer getTradeTypeCode() {
        return tradeTypeCode;
    }

    /**
     * 设置委托方向<>stockBuy=1=股票买入&stockSell=2=股票卖出&bondBuy=3=债券买入&bondSell=4=债券卖出
     *
     * @param tradeTypeCode 委托方向<>stockBuy=1=股票买入&stockSell=2=股票卖出&bondBuy=3=债券买入&bondSell=4=债券卖出
     */
    public void setTradeTypeCode(Integer tradeTypeCode) {
        this.tradeTypeCode = tradeTypeCode;
    }

    /**
     * 获取指令金额
     *
     * @return AMT - 指令金额
     */
    public Double getAmt() {
        return amt;
    }

    /**
     * 设置指令金额
     *
     * @param amt 指令金额
     */
    public void setAmt(Double amt) {
        this.amt = amt;
    }

    /**
     * 获取指令数量
     *
     * @return QTY - 指令数量
     */
    public Long getQty() {
        return qty;
    }

    /**
     * 设置指令数量
     *
     * @param qty 指令数量
     */
    public void setQty(Long qty) {
        this.qty = qty;
    }

    /**
     * 获取投资类型<>trade=1=可交易&maturity=2=持有到期&canSell=3=可供出售&other=4=贷款和应收款项
     *
     * @return SECU_TYPE - 投资类型<>trade=1=可交易&maturity=2=持有到期&canSell=3=可供出售&other=4=贷款和应收款项
     */
    public Integer getSecuType() {
        return secuType;
    }

    /**
     * 设置投资类型<>trade=1=可交易&maturity=2=持有到期&canSell=3=可供出售&other=4=贷款和应收款项
     *
     * @param secuType 投资类型<>trade=1=可交易&maturity=2=持有到期&canSell=3=可供出售&other=4=贷款和应收款项
     */
    public void setSecuType(Integer secuType) {
        this.secuType = secuType;
    }

    /**
     * 获取O32证券代码
     *
     * @return O32_SECU_CODE - O32证券代码
     */
    public String getO32SecuCode() {
        return o32SecuCode;
    }

    /**
     * 设置O32证券代码
     *
     * @param o32SecuCode O32证券代码
     */
    public void setO32SecuCode(String o32SecuCode) {
        this.o32SecuCode = o32SecuCode == null ? null : o32SecuCode.trim();
    }

    /**
     * 获取是否长单<>true=1=是&false=0=否
     *
     * @return IS_LONG_INST - 是否长单<>true=1=是&false=0=否
     */
    public Integer getIsLongInst() {
        return isLongInst;
    }

    /**
     * 设置是否长单<>true=1=是&false=0=否
     *
     * @param isLongInst 是否长单<>true=1=是&false=0=否
     */
    public void setIsLongInst(Integer isLongInst) {
        this.isLongInst = isLongInst;
    }

    /**
     * 获取指令价格
     *
     * @return PRICE - 指令价格
     */
    public Double getPrice() {
        return price;
    }

    /**
     * 设置指令价格
     *
     * @param price 指令价格
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * @return SYSTEM_TIME
     */
    public Date getSystemTime() {
        return systemTime;
    }

    /**
     * @param systemTime
     */
    public void setSystemTime(Date systemTime) {
        this.systemTime = systemTime;
    }

    /**
     * 获取O32证券名称
     *
     * @return O32_SECU_NAME - O32证券名称
     */
    public String getO32SecuName() {
        return o32SecuName;
    }

    /**
     * 设置O32证券名称
     *
     * @param o32SecuName O32证券名称
     */
    public void setO32SecuName(String o32SecuName) {
        this.o32SecuName = o32SecuName == null ? null : o32SecuName.trim();
    }
}