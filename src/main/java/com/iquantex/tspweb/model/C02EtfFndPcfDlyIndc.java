package com.iquantex.tspweb.model;

import java.util.Date;
import javax.persistence.*;
import org.apache.ibatis.type.JdbcType;
import tk.mybatis.mapper.annotation.ColumnType;

@Table(name = "C02_ETF_FND_PCF_DLY_INDC")
public class C02EtfFndPcfDlyIndc {
    /**
     * 证券编码
     */
    @Column(name = "SCRT_CD")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String scrtCd;

    /**
     * 交易日期
     */
    @Column(name = "TRDN_DT")
    @ColumnType(jdbcType = JdbcType.TIMESTAMP)
    private Date trdnDt;

    /**
     * 申赎单元
     */
    @Column(name = "CRTN_RDMP_UNT")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Double crtnRdmpUnt;

    /**
     * 最大现金比例
     */
    @Column(name = "MAX_CSH_RT")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Double maxCshRt;

    /**
     * 预测现金差额
     */
    @Column(name = "ESTM_CSH_CMPN")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Double estmCshCmpn;

    /**
     * 实际现金差额
     */
    @Column(name = "CSH_CMPN")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Double cshCmpn;

    /**
     * 单位净值
     */
    @Column(name = "NAV")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Double nav;

    /**
     * 每单元净值
     */
    @Column(name = "NAV_PER_CU")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Double navPerCu;

    /**
     * 成分股数量
     */
    @Column(name = "RCRD_NMBR")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Double rcrdNmbr;

    /**
     * 分红金额
     */
    @Column(name = "DVDN_AMNT")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Double dvdnAmnt;

    /**
     * 成分股市值
     */
    @Column(name = "CNST_MRKT_VL")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Double cnstMrktVl;

    /**
     * 成分股币种汇率
     */
    @Column(name = "CNST_CRRN_RT")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Double cnstCrrnRt;

    /**
     * 校验差额
     */
    @Column(name = "CHCK_MRGN")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Double chckMrgn;

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

    public static final String TABLE = "C02_ETF_FND_PCF_DLY_INDC";

    public static final String f_scrtCd = "scrtCd";

    public static final String f_trdnDt = "trdnDt";

    public static final String f_crtnRdmpUnt = "crtnRdmpUnt";

    public static final String f_maxCshRt = "maxCshRt";

    public static final String f_estmCshCmpn = "estmCshCmpn";

    public static final String f_cshCmpn = "cshCmpn";

    public static final String f_nav = "nav";

    public static final String f_navPerCu = "navPerCu";

    public static final String f_rcrdNmbr = "rcrdNmbr";

    public static final String f_dvdnAmnt = "dvdnAmnt";

    public static final String f_cnstMrktVl = "cnstMrktVl";

    public static final String f_cnstCrrnRt = "cnstCrrnRt";

    public static final String f_chckMrgn = "chckMrgn";

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
     * 获取交易日期
     *
     * @return TRDN_DT - 交易日期
     */
    public Date getTrdnDt() {
        return trdnDt;
    }

    /**
     * 设置交易日期
     *
     * @param trdnDt 交易日期
     */
    public void setTrdnDt(Date trdnDt) {
        this.trdnDt = trdnDt;
    }

    /**
     * 获取申赎单元
     *
     * @return CRTN_RDMP_UNT - 申赎单元
     */
    public Double getCrtnRdmpUnt() {
        return crtnRdmpUnt;
    }

    /**
     * 设置申赎单元
     *
     * @param crtnRdmpUnt 申赎单元
     */
    public void setCrtnRdmpUnt(Double crtnRdmpUnt) {
        this.crtnRdmpUnt = crtnRdmpUnt;
    }

    /**
     * 获取最大现金比例
     *
     * @return MAX_CSH_RT - 最大现金比例
     */
    public Double getMaxCshRt() {
        return maxCshRt;
    }

    /**
     * 设置最大现金比例
     *
     * @param maxCshRt 最大现金比例
     */
    public void setMaxCshRt(Double maxCshRt) {
        this.maxCshRt = maxCshRt;
    }

    /**
     * 获取预测现金差额
     *
     * @return ESTM_CSH_CMPN - 预测现金差额
     */
    public Double getEstmCshCmpn() {
        return estmCshCmpn;
    }

    /**
     * 设置预测现金差额
     *
     * @param estmCshCmpn 预测现金差额
     */
    public void setEstmCshCmpn(Double estmCshCmpn) {
        this.estmCshCmpn = estmCshCmpn;
    }

    /**
     * 获取实际现金差额
     *
     * @return CSH_CMPN - 实际现金差额
     */
    public Double getCshCmpn() {
        return cshCmpn;
    }

    /**
     * 设置实际现金差额
     *
     * @param cshCmpn 实际现金差额
     */
    public void setCshCmpn(Double cshCmpn) {
        this.cshCmpn = cshCmpn;
    }

    /**
     * 获取单位净值
     *
     * @return NAV - 单位净值
     */
    public Double getNav() {
        return nav;
    }

    /**
     * 设置单位净值
     *
     * @param nav 单位净值
     */
    public void setNav(Double nav) {
        this.nav = nav;
    }

    /**
     * 获取每单元净值
     *
     * @return NAV_PER_CU - 每单元净值
     */
    public Double getNavPerCu() {
        return navPerCu;
    }

    /**
     * 设置每单元净值
     *
     * @param navPerCu 每单元净值
     */
    public void setNavPerCu(Double navPerCu) {
        this.navPerCu = navPerCu;
    }

    /**
     * 获取成分股数量
     *
     * @return RCRD_NMBR - 成分股数量
     */
    public Double getRcrdNmbr() {
        return rcrdNmbr;
    }

    /**
     * 设置成分股数量
     *
     * @param rcrdNmbr 成分股数量
     */
    public void setRcrdNmbr(Double rcrdNmbr) {
        this.rcrdNmbr = rcrdNmbr;
    }

    /**
     * 获取分红金额
     *
     * @return DVDN_AMNT - 分红金额
     */
    public Double getDvdnAmnt() {
        return dvdnAmnt;
    }

    /**
     * 设置分红金额
     *
     * @param dvdnAmnt 分红金额
     */
    public void setDvdnAmnt(Double dvdnAmnt) {
        this.dvdnAmnt = dvdnAmnt;
    }

    /**
     * 获取成分股市值
     *
     * @return CNST_MRKT_VL - 成分股市值
     */
    public Double getCnstMrktVl() {
        return cnstMrktVl;
    }

    /**
     * 设置成分股市值
     *
     * @param cnstMrktVl 成分股市值
     */
    public void setCnstMrktVl(Double cnstMrktVl) {
        this.cnstMrktVl = cnstMrktVl;
    }

    /**
     * 获取成分股币种汇率
     *
     * @return CNST_CRRN_RT - 成分股币种汇率
     */
    public Double getCnstCrrnRt() {
        return cnstCrrnRt;
    }

    /**
     * 设置成分股币种汇率
     *
     * @param cnstCrrnRt 成分股币种汇率
     */
    public void setCnstCrrnRt(Double cnstCrrnRt) {
        this.cnstCrrnRt = cnstCrrnRt;
    }

    /**
     * 获取校验差额
     *
     * @return CHCK_MRGN - 校验差额
     */
    public Double getChckMrgn() {
        return chckMrgn;
    }

    /**
     * 设置校验差额
     *
     * @param chckMrgn 校验差额
     */
    public void setChckMrgn(Double chckMrgn) {
        this.chckMrgn = chckMrgn;
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