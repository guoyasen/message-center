package com.iquantex.tspweb.model;

import javax.persistence.*;
import org.apache.ibatis.type.JdbcType;
import tk.mybatis.mapper.annotation.ColumnType;

@Table(name = "C01_FND_ASST")
public class C01FndAsst {
    /**
     * 基金序号
     */
    @Column(name = "FND_SRL_ID")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Long fndSrlId;

    /**
     * 币种
     */
    @Column(name = "CRRN")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String crrn;

    /**
     * 发生日期
     */
    @Column(name = "OCCR_DT")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Long occrDt;

    /**
     * 股指期货保证金账户余额
     */
    @Column(name = "STCK_INDX_FTRS_MRGN_ACCN_BLNC")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Double stckIndxFtrsMrgnAccnBlnc;

    /**
     * 股指期货保证金
     */
    @Column(name = "STCK_INDX_FTRS_MRGN")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Double stckIndxFtrsMrgn;

    /**
     * 基金净资产
     */
    @Column(name = "FND_NET_ASST")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Double fndNetAsst;

    /**
     * 基金单位净值
     */
    @Column(name = "FND_NAV")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Double fndNav;

    /**
     * 基金总资产
     */
    @Column(name = "FND_TTL_ASST")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Double fndTtlAsst;

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

    public static final String TABLE = "C01_FND_ASST";

    public static final String f_fndSrlId = "fndSrlId";

    public static final String f_crrn = "crrn";

    public static final String f_occrDt = "occrDt";

    public static final String f_stckIndxFtrsMrgnAccnBlnc = "stckIndxFtrsMrgnAccnBlnc";

    public static final String f_stckIndxFtrsMrgn = "stckIndxFtrsMrgn";

    public static final String f_fndNetAsst = "fndNetAsst";

    public static final String f_fndNav = "fndNav";

    public static final String f_fndTtlAsst = "fndTtlAsst";

    public static final String f_btchDt = "btchDt";

    public static final String f_etlSrcTblNm = "etlSrcTblNm";

    public static final String f_etlJobNm = "etlJobNm";

    /**
     * 获取基金序号
     *
     * @return FND_SRL_ID - 基金序号
     */
    public Long getFndSrlId() {
        return fndSrlId;
    }

    /**
     * 设置基金序号
     *
     * @param fndSrlId 基金序号
     */
    public void setFndSrlId(Long fndSrlId) {
        this.fndSrlId = fndSrlId;
    }

    /**
     * 获取币种
     *
     * @return CRRN - 币种
     */
    public String getCrrn() {
        return crrn;
    }

    /**
     * 设置币种
     *
     * @param crrn 币种
     */
    public void setCrrn(String crrn) {
        this.crrn = crrn == null ? null : crrn.trim();
    }

    /**
     * 获取发生日期
     *
     * @return OCCR_DT - 发生日期
     */
    public Long getOccrDt() {
        return occrDt;
    }

    /**
     * 设置发生日期
     *
     * @param occrDt 发生日期
     */
    public void setOccrDt(Long occrDt) {
        this.occrDt = occrDt;
    }

    /**
     * 获取股指期货保证金账户余额
     *
     * @return STCK_INDX_FTRS_MRGN_ACCN_BLNC - 股指期货保证金账户余额
     */
    public Double getStckIndxFtrsMrgnAccnBlnc() {
        return stckIndxFtrsMrgnAccnBlnc;
    }

    /**
     * 设置股指期货保证金账户余额
     *
     * @param stckIndxFtrsMrgnAccnBlnc 股指期货保证金账户余额
     */
    public void setStckIndxFtrsMrgnAccnBlnc(Double stckIndxFtrsMrgnAccnBlnc) {
        this.stckIndxFtrsMrgnAccnBlnc = stckIndxFtrsMrgnAccnBlnc;
    }

    /**
     * 获取股指期货保证金
     *
     * @return STCK_INDX_FTRS_MRGN - 股指期货保证金
     */
    public Double getStckIndxFtrsMrgn() {
        return stckIndxFtrsMrgn;
    }

    /**
     * 设置股指期货保证金
     *
     * @param stckIndxFtrsMrgn 股指期货保证金
     */
    public void setStckIndxFtrsMrgn(Double stckIndxFtrsMrgn) {
        this.stckIndxFtrsMrgn = stckIndxFtrsMrgn;
    }

    /**
     * 获取基金净资产
     *
     * @return FND_NET_ASST - 基金净资产
     */
    public Double getFndNetAsst() {
        return fndNetAsst;
    }

    /**
     * 设置基金净资产
     *
     * @param fndNetAsst 基金净资产
     */
    public void setFndNetAsst(Double fndNetAsst) {
        this.fndNetAsst = fndNetAsst;
    }

    /**
     * 获取基金单位净值
     *
     * @return FND_NAV - 基金单位净值
     */
    public Double getFndNav() {
        return fndNav;
    }

    /**
     * 设置基金单位净值
     *
     * @param fndNav 基金单位净值
     */
    public void setFndNav(Double fndNav) {
        this.fndNav = fndNav;
    }

    /**
     * 获取基金总资产
     *
     * @return FND_TTL_ASST - 基金总资产
     */
    public Double getFndTtlAsst() {
        return fndTtlAsst;
    }

    /**
     * 设置基金总资产
     *
     * @param fndTtlAsst 基金总资产
     */
    public void setFndTtlAsst(Double fndTtlAsst) {
        this.fndTtlAsst = fndTtlAsst;
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