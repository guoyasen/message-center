package com.iquantex.tspweb.model;

import java.util.Date;
import javax.persistence.*;
import org.apache.ibatis.type.JdbcType;
import tk.mybatis.mapper.annotation.ColumnType;

@Table(name = "C01_ETF_FND_INDX_CNSTT_INFR")
public class C01EtfFndIndxCnsttInfr {
    /**
     * 基金证券编码
     */
    @Column(name = "FND_CD")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String fndCd;

    /**
     * 证券编码
     */
    @Column(name = "SCRT_CD")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String scrtCd;

    /**
     * 证券名称
     */
    @Column(name = "SCRT_NM")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String scrtNm;

    /**
     * 证券数量
     */
    @Column(name = "STCK_NMBR")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Double stckNmbr;

    /**
     * 现金替代标志
     */
    @Column(name = "CSH_RPLC_FLG")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String cshRplcFlg;

    /**
     * 现金替代溢价比例(%)
     */
    @Column(name = "CSH_RPLC_DSCN_RT")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String cshRplcDscnRt;

    /**
     * 固定替代金额
     */
    @Column(name = "RPLC_CSH")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Double rplcCsh;

    /**
     * 最新日涨跌幅%
     */
    @Column(name = "DLY_CHNG")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String dlyChng;

    /**
     * 当前交易价格
     */
    @Column(name = "NWST_PRC")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Double nwstPrc;

    /**
     * 是否停牌
     */
    @Column(name = "STP_STTS")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String stpStts;

    /**
     * 更新时间
     */
    @Column(name = "CHCK_TM")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String chckTm;

    /**
     * 预估现金差额
     */
    @Column(name = "ESTM_CSH_MRGN")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Double estmCshMrgn;

    /**
     * 今年以来涨跌幅%
     */
    @Column(name = "YR_CHNG")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String yrChng;

    /**
     * 行情数据证券编码
     */
    @Column(name = "QTTN_SCRT_CD")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String qttnScrtCd;

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

    public static final String TABLE = "C01_ETF_FND_INDX_CNSTT_INFR";

    public static final String f_fndCd = "fndCd";

    public static final String f_scrtCd = "scrtCd";

    public static final String f_scrtNm = "scrtNm";

    public static final String f_stckNmbr = "stckNmbr";

    public static final String f_cshRplcFlg = "cshRplcFlg";

    public static final String f_cshRplcDscnRt = "cshRplcDscnRt";

    public static final String f_rplcCsh = "rplcCsh";

    public static final String f_dlyChng = "dlyChng";

    public static final String f_nwstPrc = "nwstPrc";

    public static final String f_stpStts = "stpStts";

    public static final String f_chckTm = "chckTm";

    public static final String f_estmCshMrgn = "estmCshMrgn";

    public static final String f_yrChng = "yrChng";

    public static final String f_qttnScrtCd = "qttnScrtCd";

    public static final String f_btchDt = "btchDt";

    public static final String f_etlSrcTblNm = "etlSrcTblNm";

    public static final String f_etlJobNm = "etlJobNm";

    /**
     * 获取基金证券编码
     *
     * @return FND_CD - 基金证券编码
     */
    public String getFndCd() {
        return fndCd;
    }

    /**
     * 设置基金证券编码
     *
     * @param fndCd 基金证券编码
     */
    public void setFndCd(String fndCd) {
        this.fndCd = fndCd == null ? null : fndCd.trim();
    }

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
     * 获取证券名称
     *
     * @return SCRT_NM - 证券名称
     */
    public String getScrtNm() {
        return scrtNm;
    }

    /**
     * 设置证券名称
     *
     * @param scrtNm 证券名称
     */
    public void setScrtNm(String scrtNm) {
        this.scrtNm = scrtNm == null ? null : scrtNm.trim();
    }

    /**
     * 获取证券数量
     *
     * @return STCK_NMBR - 证券数量
     */
    public Double getStckNmbr() {
        return stckNmbr;
    }

    /**
     * 设置证券数量
     *
     * @param stckNmbr 证券数量
     */
    public void setStckNmbr(Double stckNmbr) {
        this.stckNmbr = stckNmbr;
    }

    /**
     * 获取现金替代标志
     *
     * @return CSH_RPLC_FLG - 现金替代标志
     */
    public String getCshRplcFlg() {
        return cshRplcFlg;
    }

    /**
     * 设置现金替代标志
     *
     * @param cshRplcFlg 现金替代标志
     */
    public void setCshRplcFlg(String cshRplcFlg) {
        this.cshRplcFlg = cshRplcFlg == null ? null : cshRplcFlg.trim();
    }

    /**
     * 获取现金替代溢价比例(%)
     *
     * @return CSH_RPLC_DSCN_RT - 现金替代溢价比例(%)
     */
    public String getCshRplcDscnRt() {
        return cshRplcDscnRt;
    }

    /**
     * 设置现金替代溢价比例(%)
     *
     * @param cshRplcDscnRt 现金替代溢价比例(%)
     */
    public void setCshRplcDscnRt(String cshRplcDscnRt) {
        this.cshRplcDscnRt = cshRplcDscnRt == null ? null : cshRplcDscnRt.trim();
    }

    /**
     * 获取固定替代金额
     *
     * @return RPLC_CSH - 固定替代金额
     */
    public Double getRplcCsh() {
        return rplcCsh;
    }

    /**
     * 设置固定替代金额
     *
     * @param rplcCsh 固定替代金额
     */
    public void setRplcCsh(Double rplcCsh) {
        this.rplcCsh = rplcCsh;
    }

    /**
     * 获取最新日涨跌幅%
     *
     * @return DLY_CHNG - 最新日涨跌幅%
     */
    public String getDlyChng() {
        return dlyChng;
    }

    /**
     * 设置最新日涨跌幅%
     *
     * @param dlyChng 最新日涨跌幅%
     */
    public void setDlyChng(String dlyChng) {
        this.dlyChng = dlyChng == null ? null : dlyChng.trim();
    }

    /**
     * 获取当前交易价格
     *
     * @return NWST_PRC - 当前交易价格
     */
    public Double getNwstPrc() {
        return nwstPrc;
    }

    /**
     * 设置当前交易价格
     *
     * @param nwstPrc 当前交易价格
     */
    public void setNwstPrc(Double nwstPrc) {
        this.nwstPrc = nwstPrc;
    }

    /**
     * 获取是否停牌
     *
     * @return STP_STTS - 是否停牌
     */
    public String getStpStts() {
        return stpStts;
    }

    /**
     * 设置是否停牌
     *
     * @param stpStts 是否停牌
     */
    public void setStpStts(String stpStts) {
        this.stpStts = stpStts == null ? null : stpStts.trim();
    }

    /**
     * 获取更新时间
     *
     * @return CHCK_TM - 更新时间
     */
    public String getChckTm() {
        return chckTm;
    }

    /**
     * 设置更新时间
     *
     * @param chckTm 更新时间
     */
    public void setChckTm(String chckTm) {
        this.chckTm = chckTm == null ? null : chckTm.trim();
    }

    /**
     * 获取预估现金差额
     *
     * @return ESTM_CSH_MRGN - 预估现金差额
     */
    public Double getEstmCshMrgn() {
        return estmCshMrgn;
    }

    /**
     * 设置预估现金差额
     *
     * @param estmCshMrgn 预估现金差额
     */
    public void setEstmCshMrgn(Double estmCshMrgn) {
        this.estmCshMrgn = estmCshMrgn;
    }

    /**
     * 获取今年以来涨跌幅%
     *
     * @return YR_CHNG - 今年以来涨跌幅%
     */
    public String getYrChng() {
        return yrChng;
    }

    /**
     * 设置今年以来涨跌幅%
     *
     * @param yrChng 今年以来涨跌幅%
     */
    public void setYrChng(String yrChng) {
        this.yrChng = yrChng == null ? null : yrChng.trim();
    }

    /**
     * 获取行情数据证券编码
     *
     * @return QTTN_SCRT_CD - 行情数据证券编码
     */
    public String getQttnScrtCd() {
        return qttnScrtCd;
    }

    /**
     * 设置行情数据证券编码
     *
     * @param qttnScrtCd 行情数据证券编码
     */
    public void setQttnScrtCd(String qttnScrtCd) {
        this.qttnScrtCd = qttnScrtCd == null ? null : qttnScrtCd.trim();
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