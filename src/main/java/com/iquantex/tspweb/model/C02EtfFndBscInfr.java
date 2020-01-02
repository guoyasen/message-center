package com.iquantex.tspweb.model;

import java.util.Date;
import javax.persistence.*;
import org.apache.ibatis.type.JdbcType;
import tk.mybatis.mapper.annotation.ColumnType;

@Table(name = "C02_ETF_FND_BSC_INFR")
public class C02EtfFndBscInfr {
    /**
     * 证券编码
     */
    @Column(name = "SCRT_CD")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String scrtCd;

    /**
     * 一级市场申购赎回代码
     */
    @Column(name = "FRST_MRKT_PRCH_RDM_CD")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String frstMrktPrchRdmCd;

    /**
     * 申购赎回简称
     */
    @Column(name = "PRCH_RDM_ABBR")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String prchRdmAbbr;

    /**
     * 上市交易份额
     */
    @Column(name = "TRDN_SHR")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Double trdnShr;

    /**
     * etf基金对应指数代码
     */
    @Column(name = "INDX_CD")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String indxCd;

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

    public static final String TABLE = "C02_ETF_FND_BSC_INFR";

    public static final String f_scrtCd = "scrtCd";

    public static final String f_frstMrktPrchRdmCd = "frstMrktPrchRdmCd";

    public static final String f_prchRdmAbbr = "prchRdmAbbr";

    public static final String f_trdnShr = "trdnShr";

    public static final String f_indxCd = "indxCd";

    public static final String f_btchDt = "btchDt";

    public static final String f_etlSrcTblNm = "etlSrcTblNm";

    public static final String f_etlJobNm = "etlJobNm";

    /**
     * 获取证券编码
     *
     * @return SCRT_CD - 证券编码
     */
    public String getScrtCd() {
        return scrtCd;
    }

    /**
     * 设置证券编码
     *
     * @param scrtCd 证券编码
     */
    public void setScrtCd(String scrtCd) {
        this.scrtCd = scrtCd == null ? null : scrtCd.trim();
    }

    /**
     * 获取一级市场申购赎回代码
     *
     * @return FRST_MRKT_PRCH_RDM_CD - 一级市场申购赎回代码
     */
    public String getFrstMrktPrchRdmCd() {
        return frstMrktPrchRdmCd;
    }

    /**
     * 设置一级市场申购赎回代码
     *
     * @param frstMrktPrchRdmCd 一级市场申购赎回代码
     */
    public void setFrstMrktPrchRdmCd(String frstMrktPrchRdmCd) {
        this.frstMrktPrchRdmCd = frstMrktPrchRdmCd == null ? null : frstMrktPrchRdmCd.trim();
    }

    /**
     * 获取申购赎回简称
     *
     * @return PRCH_RDM_ABBR - 申购赎回简称
     */
    public String getPrchRdmAbbr() {
        return prchRdmAbbr;
    }

    /**
     * 设置申购赎回简称
     *
     * @param prchRdmAbbr 申购赎回简称
     */
    public void setPrchRdmAbbr(String prchRdmAbbr) {
        this.prchRdmAbbr = prchRdmAbbr == null ? null : prchRdmAbbr.trim();
    }

    /**
     * 获取上市交易份额
     *
     * @return TRDN_SHR - 上市交易份额
     */
    public Double getTrdnShr() {
        return trdnShr;
    }

    /**
     * 设置上市交易份额
     *
     * @param trdnShr 上市交易份额
     */
    public void setTrdnShr(Double trdnShr) {
        this.trdnShr = trdnShr;
    }

    /**
     * 获取etf基金对应指数代码
     *
     * @return INDX_CD - etf基金对应指数代码
     */
    public String getIndxCd() {
        return indxCd;
    }

    /**
     * 设置etf基金对应指数代码
     *
     * @param indxCd etf基金对应指数代码
     */
    public void setIndxCd(String indxCd) {
        this.indxCd = indxCd == null ? null : indxCd.trim();
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