package com.iquantex.tspweb.model;

import java.util.Date;
import javax.persistence.*;
import org.apache.ibatis.type.JdbcType;
import tk.mybatis.mapper.annotation.ColumnType;

@Table(name = "C02_A_SHR_BSC_INFR")
public class C02AShrBscInfr {
    /**
     * 证券编码
     */
    @Column(name = "SCRT_CD")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String scrtCd;

    /**
     * 证券简称
     */
    @Column(name = "SCRT_ABBR")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String scrtAbbr;

    /**
     * 公司中文名称
     */
    @Column(name = "CMPN_CHNS_NM")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String cmpnChnsNm;

    /**
     * 公司英文名称
     */
    @Column(name = "CMPN_ENGL_NM")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String cmpnEnglNm;

    /**
     * 交易代码
     */
    @Column(name = "TRDN_CD")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String trdnCd;

    /**
     * 交易所代码
     */
    @Column(name = "EXCH_CD")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String exchCd;

    /**
     * 上市板类型
     */
    @Column(name = "IPO_SCTR_TYP")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String ipoSctrTyp;

    /**
     * 上市日期
     */
    @Column(name = "IST_DT")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String istDt;

    /**
     * 退市日期
     */
    @Column(name = "CNCL_DT")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String cnclDt;

    /**
     * 货币代码
     */
    @Column(name = "CRRN_CD")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String crrnCd;

    /**
     * 简称拼音
     */
    @Column(name = "ABBR")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String abbr;

    /**
     * 上市板
     */
    @Column(name = "IPO_SCTR")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String ipoSctr;

    /**
     * 是否在沪股通或深港通范围内
     */
    @Column(name = "HK_STCK_CNNC_PRGR")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String hkStckCnncPrgr;

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

    public static final String TABLE = "C02_A_SHR_BSC_INFR";

    public static final String f_scrtCd = "scrtCd";

    public static final String f_scrtAbbr = "scrtAbbr";

    public static final String f_cmpnChnsNm = "cmpnChnsNm";

    public static final String f_cmpnEnglNm = "cmpnEnglNm";

    public static final String f_trdnCd = "trdnCd";

    public static final String f_exchCd = "exchCd";

    public static final String f_ipoSctrTyp = "ipoSctrTyp";

    public static final String f_istDt = "istDt";

    public static final String f_cnclDt = "cnclDt";

    public static final String f_crrnCd = "crrnCd";

    public static final String f_abbr = "abbr";

    public static final String f_ipoSctr = "ipoSctr";

    public static final String f_hkStckCnncPrgr = "hkStckCnncPrgr";

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
     * 获取证券简称
     *
     * @return SCRT_ABBR - 证券简称
     */
    public String getScrtAbbr() {
        return scrtAbbr;
    }

    /**
     * 设置证券简称
     *
     * @param scrtAbbr 证券简称
     */
    public void setScrtAbbr(String scrtAbbr) {
        this.scrtAbbr = scrtAbbr == null ? null : scrtAbbr.trim();
    }

    /**
     * 获取公司中文名称
     *
     * @return CMPN_CHNS_NM - 公司中文名称
     */
    public String getCmpnChnsNm() {
        return cmpnChnsNm;
    }

    /**
     * 设置公司中文名称
     *
     * @param cmpnChnsNm 公司中文名称
     */
    public void setCmpnChnsNm(String cmpnChnsNm) {
        this.cmpnChnsNm = cmpnChnsNm == null ? null : cmpnChnsNm.trim();
    }

    /**
     * 获取公司英文名称
     *
     * @return CMPN_ENGL_NM - 公司英文名称
     */
    public String getCmpnEnglNm() {
        return cmpnEnglNm;
    }

    /**
     * 设置公司英文名称
     *
     * @param cmpnEnglNm 公司英文名称
     */
    public void setCmpnEnglNm(String cmpnEnglNm) {
        this.cmpnEnglNm = cmpnEnglNm == null ? null : cmpnEnglNm.trim();
    }

    /**
     * 获取交易代码
     *
     * @return TRDN_CD - 交易代码
     */
    public String getTrdnCd() {
        return trdnCd;
    }

    /**
     * 设置交易代码
     *
     * @param trdnCd 交易代码
     */
    public void setTrdnCd(String trdnCd) {
        this.trdnCd = trdnCd == null ? null : trdnCd.trim();
    }

    /**
     * 获取交易所代码
     *
     * @return EXCH_CD - 交易所代码
     */
    public String getExchCd() {
        return exchCd;
    }

    /**
     * 设置交易所代码
     *
     * @param exchCd 交易所代码
     */
    public void setExchCd(String exchCd) {
        this.exchCd = exchCd == null ? null : exchCd.trim();
    }

    /**
     * 获取上市板类型
     *
     * @return IPO_SCTR_TYP - 上市板类型
     */
    public String getIpoSctrTyp() {
        return ipoSctrTyp;
    }

    /**
     * 设置上市板类型
     *
     * @param ipoSctrTyp 上市板类型
     */
    public void setIpoSctrTyp(String ipoSctrTyp) {
        this.ipoSctrTyp = ipoSctrTyp == null ? null : ipoSctrTyp.trim();
    }

    /**
     * 获取上市日期
     *
     * @return IST_DT - 上市日期
     */
    public String getIstDt() {
        return istDt;
    }

    /**
     * 设置上市日期
     *
     * @param istDt 上市日期
     */
    public void setIstDt(String istDt) {
        this.istDt = istDt == null ? null : istDt.trim();
    }

    /**
     * 获取退市日期
     *
     * @return CNCL_DT - 退市日期
     */
    public String getCnclDt() {
        return cnclDt;
    }

    /**
     * 设置退市日期
     *
     * @param cnclDt 退市日期
     */
    public void setCnclDt(String cnclDt) {
        this.cnclDt = cnclDt == null ? null : cnclDt.trim();
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
     * 获取简称拼音
     *
     * @return ABBR - 简称拼音
     */
    public String getAbbr() {
        return abbr;
    }

    /**
     * 设置简称拼音
     *
     * @param abbr 简称拼音
     */
    public void setAbbr(String abbr) {
        this.abbr = abbr == null ? null : abbr.trim();
    }

    /**
     * 获取上市板
     *
     * @return IPO_SCTR - 上市板
     */
    public String getIpoSctr() {
        return ipoSctr;
    }

    /**
     * 设置上市板
     *
     * @param ipoSctr 上市板
     */
    public void setIpoSctr(String ipoSctr) {
        this.ipoSctr = ipoSctr == null ? null : ipoSctr.trim();
    }

    /**
     * 获取是否在沪股通或深港通范围内
     *
     * @return HK_STCK_CNNC_PRGR - 是否在沪股通或深港通范围内
     */
    public String getHkStckCnncPrgr() {
        return hkStckCnncPrgr;
    }

    /**
     * 设置是否在沪股通或深港通范围内
     *
     * @param hkStckCnncPrgr 是否在沪股通或深港通范围内
     */
    public void setHkStckCnncPrgr(String hkStckCnncPrgr) {
        this.hkStckCnncPrgr = hkStckCnncPrgr == null ? null : hkStckCnncPrgr.trim();
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