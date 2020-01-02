package com.iquantex.tspweb.model;

import javax.persistence.*;
import org.apache.ibatis.type.JdbcType;
import tk.mybatis.mapper.annotation.ColumnType;

@Table(name = "TSP_C.C01_SCRT_INFR_HND")
public class C01ScrtInfrHnd {
    /**
     * 证券编码_手工
     */
    @Column(name = "SCRT_CD_HD")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String scrtCdHd;

    /**
     * 属性名称
     */
    @Column(name = "PRPR_NM")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String prprNm;

    /**
     * 属性值
     */
    @Column(name = "PRPR_VL")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String prprVl;

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

    public static final String TABLE = "TSP_C.C01_SCRT_INFR_HND";

    public static final String f_scrtCdHd = "scrtCdHd";

    public static final String f_prprNm = "prprNm";

    public static final String f_prprVl = "prprVl";

    public static final String f_rsrcSyst = "rsrcSyst";

    public static final String f_btchDt = "btchDt";

    public static final String f_etlSrcTblNm = "etlSrcTblNm";

    public static final String f_etlJobNm = "etlJobNm";

    /**
     * 获取证券编码_手工
     *
     * @return SCRT_CD_HD - 证券编码_手工
     */
    public String getScrtCdHd() {
        return scrtCdHd;
    }

    /**
     * 设置证券编码_手工
     *
     * @param scrtCdHd 证券编码_手工
     */
    public void setScrtCdHd(String scrtCdHd) {
        this.scrtCdHd = scrtCdHd == null ? null : scrtCdHd.trim();
    }

    /**
     * 获取属性名称
     *
     * @return PRPR_NM - 属性名称
     */
    public String getPrprNm() {
        return prprNm;
    }

    /**
     * 设置属性名称
     *
     * @param prprNm 属性名称
     */
    public void setPrprNm(String prprNm) {
        this.prprNm = prprNm == null ? null : prprNm.trim();
    }

    /**
     * 获取属性值
     *
     * @return PRPR_VL - 属性值
     */
    public String getPrprVl() {
        return prprVl;
    }

    /**
     * 设置属性值
     *
     * @param prprVl 属性值
     */
    public void setPrprVl(String prprVl) {
        this.prprVl = prprVl == null ? null : prprVl.trim();
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