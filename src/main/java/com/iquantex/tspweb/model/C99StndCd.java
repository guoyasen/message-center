package com.iquantex.tspweb.model;

import javax.persistence.*;
import org.apache.ibatis.type.JdbcType;
import tk.mybatis.mapper.annotation.ColumnType;

@Table(name = "C99_STND_CD")
public class C99StndCd {
    @Column(name = "PRMT_TYP")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String prmtTyp;

    @Column(name = "CRRL_SYST")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String crrlSyst;

    @Column(name = "STND_CD_VL")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String stndCdVl;

    @Column(name = "STND_CD_NT")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String stndCdNt;

    @Column(name = "DATA_DT")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String dataDt;

    @Column(name = "DATA_SRC")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String dataSrc;

    @Column(name = "ETL_JOB_NM")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String etlJobNm;

    public static final String TABLE = "C99_STND_CD";

    public static final String f_prmtTyp = "prmtTyp";

    public static final String f_crrlSyst = "crrlSyst";

    public static final String f_stndCdVl = "stndCdVl";

    public static final String f_stndCdNt = "stndCdNt";

    public static final String f_dataDt = "dataDt";

    public static final String f_dataSrc = "dataSrc";

    public static final String f_etlJobNm = "etlJobNm";

    /**
     * @return PRMT_TYP
     */
    public String getPrmtTyp() {
        return prmtTyp;
    }

    /**
     * @param prmtTyp
     */
    public void setPrmtTyp(String prmtTyp) {
        this.prmtTyp = prmtTyp == null ? null : prmtTyp.trim();
    }

    /**
     * @return CRRL_SYST
     */
    public String getCrrlSyst() {
        return crrlSyst;
    }

    /**
     * @param crrlSyst
     */
    public void setCrrlSyst(String crrlSyst) {
        this.crrlSyst = crrlSyst == null ? null : crrlSyst.trim();
    }

    /**
     * @return STND_CD_VL
     */
    public String getStndCdVl() {
        return stndCdVl;
    }

    /**
     * @param stndCdVl
     */
    public void setStndCdVl(String stndCdVl) {
        this.stndCdVl = stndCdVl == null ? null : stndCdVl.trim();
    }

    /**
     * @return STND_CD_NT
     */
    public String getStndCdNt() {
        return stndCdNt;
    }

    /**
     * @param stndCdNt
     */
    public void setStndCdNt(String stndCdNt) {
        this.stndCdNt = stndCdNt == null ? null : stndCdNt.trim();
    }

    /**
     * @return DATA_DT
     */
    public String getDataDt() {
        return dataDt;
    }

    /**
     * @param dataDt
     */
    public void setDataDt(String dataDt) {
        this.dataDt = dataDt == null ? null : dataDt.trim();
    }

    /**
     * @return DATA_SRC
     */
    public String getDataSrc() {
        return dataSrc;
    }

    /**
     * @param dataSrc
     */
    public void setDataSrc(String dataSrc) {
        this.dataSrc = dataSrc == null ? null : dataSrc.trim();
    }

    /**
     * @return ETL_JOB_NM
     */
    public String getEtlJobNm() {
        return etlJobNm;
    }

    /**
     * @param etlJobNm
     */
    public void setEtlJobNm(String etlJobNm) {
        this.etlJobNm = etlJobNm == null ? null : etlJobNm.trim();
    }
}