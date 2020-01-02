package com.iquantex.tspweb.model;

import org.apache.ibatis.type.JdbcType;
import tk.mybatis.mapper.annotation.ColumnType;

import javax.persistence.Column;
import javax.persistence.Table;

@Table(name = "TSP_C.TRADEIMPACTCOST_VW")
public class TradeimpactcostVw {
    @Column(name = "SCRT_CD")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String scrtCd;

    @Column(name = "SCRT_NM")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String scrtNm;

    @Column(name = "LABEL_NM")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String labelNm;

    @Column(name = "TTL_EQTY")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Double ttlEqty;

    @Column(name = "RSTR_SHRS_TTL")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Double rstrShrsTtl;

    @Column(name = "NON_TRDB_SHR")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Double nonTrdbShr;

    @Column(name = "TRDB_SHRS_TTL")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Double trdbShrsTtl;

    @Column(name = "TTL_ASHR")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Double ttlAshr;

    @Column(name = "FLTD_ASHR")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Double fltdAshr;

    @Column(name = "RSTR_ASHR")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Double rstrAshr;

    @Column(name = "PLDG_NMBR")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String pldgNmbr;

    @Column(name = "STCK_PL_LVL")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String stckPlLvl;

    public static final String TABLE = "TSP_C.TRADEIMPACTCOST_VW";

    public static final String f_scrtCd = "scrtCd";

    public static final String f_scrtNm = "scrtNm";

    public static final String f_labelNm = "labelNm";

    public static final String f_ttlEqty = "ttlEqty";

    public static final String f_rstrShrsTtl = "rstrShrsTtl";

    public static final String f_nonTrdbShr = "nonTrdbShr";

    public static final String f_trdbShrsTtl = "trdbShrsTtl";

    public static final String f_ttlAshr = "ttlAshr";

    public static final String f_fltdAshr = "fltdAshr";

    public static final String f_rstrAshr = "rstrAshr";

    public static final String f_pldgNmbr = "pldgNmbr";

    public static final String f_stckPlLvl = "stckPlLvl";

    /**
     * @return SCRT_CD
     */
    public String getScrtCd() {
        return scrtCd;
    }

    /**
     * @param scrtCd
     */
    public void setScrtCd(String scrtCd) {
        this.scrtCd = scrtCd == null ? null : scrtCd.trim();
    }

    /**
     * @return SCRT_NM
     */
    public String getScrtNm() {
        return scrtNm;
    }

    /**
     * @param scrtNm
     */
    public void setScrtNm(String scrtNm) {
        this.scrtNm = scrtNm == null ? null : scrtNm.trim();
    }

    /**
     * @return LABEL_NM
     */
    public String getLabelNm() {
        return labelNm;
    }

    /**
     * @param labelNm
     */
    public void setLabelNm(String labelNm) {
        this.labelNm = labelNm == null ? null : labelNm.trim();
    }

    /**
     * @return TTL_EQTY
     */
    public Double getTtlEqty() {
        return ttlEqty;
    }

    /**
     * @param ttlEqty
     */
    public void setTtlEqty(Double ttlEqty) {
        this.ttlEqty = ttlEqty;
    }

    /**
     * @return RSTR_SHRS_TTL
     */
    public Double getRstrShrsTtl() {
        return rstrShrsTtl;
    }

    /**
     * @param rstrShrsTtl
     */
    public void setRstrShrsTtl(Double rstrShrsTtl) {
        this.rstrShrsTtl = rstrShrsTtl;
    }

    /**
     * @return NON_TRDB_SHR
     */
    public Double getNonTrdbShr() {
        return nonTrdbShr;
    }

    /**
     * @param nonTrdbShr
     */
    public void setNonTrdbShr(Double nonTrdbShr) {
        this.nonTrdbShr = nonTrdbShr;
    }

    /**
     * @return TRDB_SHRS_TTL
     */
    public Double getTrdbShrsTtl() {
        return trdbShrsTtl;
    }

    /**
     * @param trdbShrsTtl
     */
    public void setTrdbShrsTtl(Double trdbShrsTtl) {
        this.trdbShrsTtl = trdbShrsTtl;
    }

    /**
     * @return TTL_ASHR
     */
    public Double getTtlAshr() {
        return ttlAshr;
    }

    /**
     * @param ttlAshr
     */
    public void setTtlAshr(Double ttlAshr) {
        this.ttlAshr = ttlAshr;
    }

    /**
     * @return FLTD_ASHR
     */
    public Double getFltdAshr() {
        return fltdAshr;
    }

    /**
     * @param fltdAshr
     */
    public void setFltdAshr(Double fltdAshr) {
        this.fltdAshr = fltdAshr;
    }

    /**
     * @return RSTR_ASHR
     */
    public Double getRstrAshr() {
        return rstrAshr;
    }

    /**
     * @param rstrAshr
     */
    public void setRstrAshr(Double rstrAshr) {
        this.rstrAshr = rstrAshr;
    }

    /**
     * @return PLDG_NMBR
     */
    public String getPldgNmbr() {
        return pldgNmbr;
    }

    /**
     * @param pldgNmbr
     */
    public void setPldgNmbr(String pldgNmbr) {
        this.pldgNmbr = pldgNmbr == null ? null : pldgNmbr.trim();
    }

    /**
     * @return STCK_PL_LVL
     */
    public String getStckPlLvl() {
        return stckPlLvl;
    }

    /**
     * @param stckPlLvl
     */
    public void setStckPlLvl(String stckPlLvl) {
        this.stckPlLvl = stckPlLvl == null ? null : stckPlLvl.trim();
    }
}