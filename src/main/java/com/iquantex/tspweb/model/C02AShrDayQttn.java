package com.iquantex.tspweb.model;

import java.util.Date;
import javax.persistence.*;
import org.apache.ibatis.type.JdbcType;
import tk.mybatis.mapper.annotation.ColumnType;

@Table(name = "C02_A_SHR_DAY_QTTN")
public class C02AShrDayQttn {
    /**
     * 证券代码
     */
    @Column(name = "SCRT_CD")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String scrtCd;

    /**
     * 交易日期
     */
    @Column(name = "TRDN_DT")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String trdnDt;

    /**
     * 货币代码
     */
    @Column(name = "CRRN_CD")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String crrnCd;

    /**
     * 昨收盘价
     */
    @Column(name = "YSTR_CLSN_PRC")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Double ystrClsnPrc;

    /**
     * 开盘价
     */
    @Column(name = "OPNN_PRC")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Double opnnPrc;

    /**
     * 最高价
     */
    @Column(name = "HGHST_PRC")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Double hghstPrc;

    /**
     * 最低价
     */
    @Column(name = "LWST_PRC")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Double lwstPrc;

    /**
     * 收盘价
     */
    @Column(name = "CLSN_PRC")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Double clsnPrc;

    /**
     * 涨跌价
     */
    @Column(name = "CHNG_PRC")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Double chngPrc;

    /**
     * 涨跌幅
     */
    @Column(name = "CHNG")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Double chng;

    /**
     * 成交量
     */
    @Column(name = "VLM")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Double vlm;

    /**
     * 成交金额
     */
    @Column(name = "TRNV_AMNT")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Double trnvAmnt;

    /**
     * 复权昨收盘价
     */
    @Column(name = "ADJST_PRVS_CLS_PRC")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Double adjstPrvsClsPrc;

    /**
     * 复权开盘价
     */
    @Column(name = "ADJST_OPN_PRC")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Double adjstOpnPrc;

    /**
     * 复权最高价
     */
    @Column(name = "ADJST_HGHST_PRC")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Double adjstHghstPrc;

    /**
     * 复权最低价
     */
    @Column(name = "ADJST_LWST_PRC")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Double adjstLwstPrc;

    /**
     * 复权收盘价
     */
    @Column(name = "ADJST_CLS_PRC")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Double adjstClsPrc;

    /**
     * 复权因子
     */
    @Column(name = "AJST_FCTR")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Double ajstFctr;

    /**
     * 均价
     */
    @Column(name = "AVRG_PRC")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Double avrgPrc;

    /**
     * 交易状态
     */
    @Column(name = "TRDN_STT")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String trdnStt;

    /**
     * 批量日期
     */
    @Column(name = "BTCH_DT")
    @ColumnType(jdbcType = JdbcType.TIMESTAMP)
    private Date btchDt;

    /**
     * ETL源表名称
     */
    @Column(name = "ETL_SRC_TBL_NM")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String etlSrcTblNm;

    /**
     * ETL作业名称
     */
    @Column(name = "ETL_JOB_NM")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String etlJobNm;

    public static final String TABLE = "TSP_C.C02_A_SHR_DAY_QTTN";

    public static final String f_scrtCd = "scrtCd";

    public static final String f_trdnDt = "trdnDt";

    public static final String f_crrnCd = "crrnCd";

    public static final String f_ystrClsnPrc = "ystrClsnPrc";

    public static final String f_opnnPrc = "opnnPrc";

    public static final String f_hghstPrc = "hghstPrc";

    public static final String f_lwstPrc = "lwstPrc";

    public static final String f_clsnPrc = "clsnPrc";

    public static final String f_chngPrc = "chngPrc";

    public static final String f_chng = "chng";

    public static final String f_vlm = "vlm";

    public static final String f_trnvAmnt = "trnvAmnt";

    public static final String f_adjstPrvsClsPrc = "adjstPrvsClsPrc";

    public static final String f_adjstOpnPrc = "adjstOpnPrc";

    public static final String f_adjstHghstPrc = "adjstHghstPrc";

    public static final String f_adjstLwstPrc = "adjstLwstPrc";

    public static final String f_adjstClsPrc = "adjstClsPrc";

    public static final String f_ajstFctr = "ajstFctr";

    public static final String f_avrgPrc = "avrgPrc";

    public static final String f_trdnStt = "trdnStt";

    public static final String f_btchDt = "btchDt";

    public static final String f_etlSrcTblNm = "etlSrcTblNm";

    public static final String f_etlJobNm = "etlJobNm";

    /**
     * 获取证券代码
     *
     * @return SCRT_CD - 证券代码
     */
    public String getScrtCd() {
        return scrtCd;
    }

    /**
     * 设置证券代码
     *
     * @param scrtCd 证券代码
     */
    public void setScrtCd(String scrtCd) {
        this.scrtCd = scrtCd == null ? null : scrtCd.trim();
    }

    /**
     * 获取交易日期
     *
     * @return TRDN_DT - 交易日期
     */
    public String getTrdnDt() {
        return trdnDt;
    }

    /**
     * 设置交易日期
     *
     * @param trdnDt 交易日期
     */
    public void setTrdnDt(String trdnDt) {
        this.trdnDt = trdnDt == null ? null : trdnDt.trim();
    }

    /**
     * 获取货币代码
     *
     * @return CRRN_CD - 货币代码
     */
    public String getCrrnCd() {
        return crrnCd;
    }

    /**
     * 设置货币代码
     *
     * @param crrnCd 货币代码
     */
    public void setCrrnCd(String crrnCd) {
        this.crrnCd = crrnCd == null ? null : crrnCd.trim();
    }

    /**
     * 获取昨收盘价
     *
     * @return YSTR_CLSN_PRC - 昨收盘价
     */
    public Double getYstrClsnPrc() {
        return ystrClsnPrc;
    }

    /**
     * 设置昨收盘价
     *
     * @param ystrClsnPrc 昨收盘价
     */
    public void setYstrClsnPrc(Double ystrClsnPrc) {
        this.ystrClsnPrc = ystrClsnPrc;
    }

    /**
     * 获取开盘价
     *
     * @return OPNN_PRC - 开盘价
     */
    public Double getOpnnPrc() {
        return opnnPrc;
    }

    /**
     * 设置开盘价
     *
     * @param opnnPrc 开盘价
     */
    public void setOpnnPrc(Double opnnPrc) {
        this.opnnPrc = opnnPrc;
    }

    /**
     * 获取最高价
     *
     * @return HGHST_PRC - 最高价
     */
    public Double getHghstPrc() {
        return hghstPrc;
    }

    /**
     * 设置最高价
     *
     * @param hghstPrc 最高价
     */
    public void setHghstPrc(Double hghstPrc) {
        this.hghstPrc = hghstPrc;
    }

    /**
     * 获取最低价
     *
     * @return LWST_PRC - 最低价
     */
    public Double getLwstPrc() {
        return lwstPrc;
    }

    /**
     * 设置最低价
     *
     * @param lwstPrc 最低价
     */
    public void setLwstPrc(Double lwstPrc) {
        this.lwstPrc = lwstPrc;
    }

    /**
     * 获取收盘价
     *
     * @return CLSN_PRC - 收盘价
     */
    public Double getClsnPrc() {
        return clsnPrc;
    }

    /**
     * 设置收盘价
     *
     * @param clsnPrc 收盘价
     */
    public void setClsnPrc(Double clsnPrc) {
        this.clsnPrc = clsnPrc;
    }

    /**
     * 获取涨跌价
     *
     * @return CHNG_PRC - 涨跌价
     */
    public Double getChngPrc() {
        return chngPrc;
    }

    /**
     * 设置涨跌价
     *
     * @param chngPrc 涨跌价
     */
    public void setChngPrc(Double chngPrc) {
        this.chngPrc = chngPrc;
    }

    /**
     * 获取涨跌幅
     *
     * @return CHNG - 涨跌幅
     */
    public Double getChng() {
        return chng;
    }

    /**
     * 设置涨跌幅
     *
     * @param chng 涨跌幅
     */
    public void setChng(Double chng) {
        this.chng = chng;
    }

    /**
     * 获取成交量
     *
     * @return VLM - 成交量
     */
    public Double getVlm() {
        return vlm;
    }

    /**
     * 设置成交量
     *
     * @param vlm 成交量
     */
    public void setVlm(Double vlm) {
        this.vlm = vlm;
    }

    /**
     * 获取成交金额
     *
     * @return TRNV_AMNT - 成交金额
     */
    public Double getTrnvAmnt() {
        return trnvAmnt;
    }

    /**
     * 设置成交金额
     *
     * @param trnvAmnt 成交金额
     */
    public void setTrnvAmnt(Double trnvAmnt) {
        this.trnvAmnt = trnvAmnt;
    }

    /**
     * 获取复权昨收盘价
     *
     * @return ADJST_PRVS_CLS_PRC - 复权昨收盘价
     */
    public Double getAdjstPrvsClsPrc() {
        return adjstPrvsClsPrc;
    }

    /**
     * 设置复权昨收盘价
     *
     * @param adjstPrvsClsPrc 复权昨收盘价
     */
    public void setAdjstPrvsClsPrc(Double adjstPrvsClsPrc) {
        this.adjstPrvsClsPrc = adjstPrvsClsPrc;
    }

    /**
     * 获取复权开盘价
     *
     * @return ADJST_OPN_PRC - 复权开盘价
     */
    public Double getAdjstOpnPrc() {
        return adjstOpnPrc;
    }

    /**
     * 设置复权开盘价
     *
     * @param adjstOpnPrc 复权开盘价
     */
    public void setAdjstOpnPrc(Double adjstOpnPrc) {
        this.adjstOpnPrc = adjstOpnPrc;
    }

    /**
     * 获取复权最高价
     *
     * @return ADJST_HGHST_PRC - 复权最高价
     */
    public Double getAdjstHghstPrc() {
        return adjstHghstPrc;
    }

    /**
     * 设置复权最高价
     *
     * @param adjstHghstPrc 复权最高价
     */
    public void setAdjstHghstPrc(Double adjstHghstPrc) {
        this.adjstHghstPrc = adjstHghstPrc;
    }

    /**
     * 获取复权最低价
     *
     * @return ADJST_LWST_PRC - 复权最低价
     */
    public Double getAdjstLwstPrc() {
        return adjstLwstPrc;
    }

    /**
     * 设置复权最低价
     *
     * @param adjstLwstPrc 复权最低价
     */
    public void setAdjstLwstPrc(Double adjstLwstPrc) {
        this.adjstLwstPrc = adjstLwstPrc;
    }

    /**
     * 获取复权收盘价
     *
     * @return ADJST_CLS_PRC - 复权收盘价
     */
    public Double getAdjstClsPrc() {
        return adjstClsPrc;
    }

    /**
     * 设置复权收盘价
     *
     * @param adjstClsPrc 复权收盘价
     */
    public void setAdjstClsPrc(Double adjstClsPrc) {
        this.adjstClsPrc = adjstClsPrc;
    }

    /**
     * 获取复权因子
     *
     * @return AJST_FCTR - 复权因子
     */
    public Double getAjstFctr() {
        return ajstFctr;
    }

    /**
     * 设置复权因子
     *
     * @param ajstFctr 复权因子
     */
    public void setAjstFctr(Double ajstFctr) {
        this.ajstFctr = ajstFctr;
    }

    /**
     * 获取均价
     *
     * @return AVRG_PRC - 均价
     */
    public Double getAvrgPrc() {
        return avrgPrc;
    }

    /**
     * 设置均价
     *
     * @param avrgPrc 均价
     */
    public void setAvrgPrc(Double avrgPrc) {
        this.avrgPrc = avrgPrc;
    }

    /**
     * 获取交易状态
     *
     * @return TRDN_STT - 交易状态
     */
    public String getTrdnStt() {
        return trdnStt;
    }

    /**
     * 设置交易状态
     *
     * @param trdnStt 交易状态
     */
    public void setTrdnStt(String trdnStt) {
        this.trdnStt = trdnStt == null ? null : trdnStt.trim();
    }

    /**
     * 获取批量日期
     *
     * @return BTCH_DT - 批量日期
     */
    public Date getBtchDt() {
        return btchDt;
    }

    /**
     * 设置批量日期
     *
     * @param btchDt 批量日期
     */
    public void setBtchDt(Date btchDt) {
        this.btchDt = btchDt;
    }

    /**
     * 获取ETL源表名称
     *
     * @return ETL_SRC_TBL_NM - ETL源表名称
     */
    public String getEtlSrcTblNm() {
        return etlSrcTblNm;
    }

    /**
     * 设置ETL源表名称
     *
     * @param etlSrcTblNm ETL源表名称
     */
    public void setEtlSrcTblNm(String etlSrcTblNm) {
        this.etlSrcTblNm = etlSrcTblNm == null ? null : etlSrcTblNm.trim();
    }

    /**
     * 获取ETL作业名称
     *
     * @return ETL_JOB_NM - ETL作业名称
     */
    public String getEtlJobNm() {
        return etlJobNm;
    }

    /**
     * 设置ETL作业名称
     *
     * @param etlJobNm ETL作业名称
     */
    public void setEtlJobNm(String etlJobNm) {
        this.etlJobNm = etlJobNm == null ? null : etlJobNm.trim();
    }
}