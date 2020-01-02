package com.iquantex.tspweb.model;

import javax.persistence.*;
import org.apache.ibatis.type.JdbcType;
import tk.mybatis.mapper.annotation.ColumnType;

@Table(name = "C01_FND_INTR_INFR")
public class C01FndIntrInfr {
    /**
     * 基金代码
     */
    @Column(name = "FND_CD")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String fndCd;

    /**
     * 基金序号
     */
    @Column(name = "FNDS_NMBR")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String fndsNmbr;

    /**
     * 基金简称
     */
    @Column(name = "FND_ABBR")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String fndAbbr;

    /**
     * 基金全称
     */
    @Column(name = "FND_FLL_NM")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String fndFllNm;

    /**
     * 基金类型
     */
    @Column(name = "FND_TYP")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String fndTyp;

    /**
     * 来源系统
     */
    @Column(name = "RSRC_SYST")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String rsrcSyst;

    /**
     * 批量日期
     */
    @Column(name = "BTCH_DT")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String btchDt;

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

    public static final String TABLE = "C01_FND_INTR_INFR";

    public static final String f_fndCd = "fndCd";

    public static final String f_fndsNmbr = "fndsNmbr";

    public static final String f_fndAbbr = "fndAbbr";

    public static final String f_fndFllNm = "fndFllNm";

    public static final String f_fndTyp = "fndTyp";

    public static final String f_rsrcSyst = "rsrcSyst";

    public static final String f_btchDt = "btchDt";

    public static final String f_etlSrcTblNm = "etlSrcTblNm";

    public static final String f_etlJobNm = "etlJobNm";

    /**
     * 获取基金代码
     *
     * @return FND_CD - 基金代码
     */
    public String getFndCd() {
        return fndCd;
    }

    /**
     * 设置基金代码
     *
     * @param fndCd 基金代码
     */
    public void setFndCd(String fndCd) {
        this.fndCd = fndCd == null ? null : fndCd.trim();
    }

    /**
     * 获取基金序号
     *
     * @return FNDS_NMBR - 基金序号
     */
    public String getFndsNmbr() {
        return fndsNmbr;
    }

    /**
     * 设置基金序号
     *
     * @param fndsNmbr 基金序号
     */
    public void setFndsNmbr(String fndsNmbr) {
        this.fndsNmbr = fndsNmbr == null ? null : fndsNmbr.trim();
    }

    /**
     * 获取基金简称
     *
     * @return FND_ABBR - 基金简称
     */
    public String getFndAbbr() {
        return fndAbbr;
    }

    /**
     * 设置基金简称
     *
     * @param fndAbbr 基金简称
     */
    public void setFndAbbr(String fndAbbr) {
        this.fndAbbr = fndAbbr == null ? null : fndAbbr.trim();
    }

    /**
     * 获取基金全称
     *
     * @return FND_FLL_NM - 基金全称
     */
    public String getFndFllNm() {
        return fndFllNm;
    }

    /**
     * 设置基金全称
     *
     * @param fndFllNm 基金全称
     */
    public void setFndFllNm(String fndFllNm) {
        this.fndFllNm = fndFllNm == null ? null : fndFllNm.trim();
    }

    /**
     * 获取基金类型
     *
     * @return FND_TYP - 基金类型
     */
    public String getFndTyp() {
        return fndTyp;
    }

    /**
     * 设置基金类型
     *
     * @param fndTyp 基金类型
     */
    public void setFndTyp(String fndTyp) {
        this.fndTyp = fndTyp == null ? null : fndTyp.trim();
    }

    /**
     * 获取来源系统
     *
     * @return RSRC_SYST - 来源系统
     */
    public String getRsrcSyst() {
        return rsrcSyst;
    }

    /**
     * 设置来源系统
     *
     * @param rsrcSyst 来源系统
     */
    public void setRsrcSyst(String rsrcSyst) {
        this.rsrcSyst = rsrcSyst == null ? null : rsrcSyst.trim();
    }

    /**
     * 获取批量日期
     *
     * @return BTCH_DT - 批量日期
     */
    public String getBtchDt() {
        return btchDt;
    }

    /**
     * 设置批量日期
     *
     * @param btchDt 批量日期
     */
    public void setBtchDt(String btchDt) {
        this.btchDt = btchDt == null ? null : btchDt.trim();
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