package com.iquantex.tspweb.model;

import javax.persistence.*;
import org.apache.ibatis.type.JdbcType;
import tk.mybatis.mapper.annotation.ColumnType;

@Table(name = "C01_FND_ASST_DTL")
public class C01FndAsstDtl {
    /**
     * 交易日期
     */
    @Column(name = "TRDN_DT")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String trdnDt;

    /**
     * 基金序号
     */
    @Column(name = "FNDS_NMBR")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String fndsNmbr;

    /**
     * 托管席位
     */
    @Column(name = "TRST_ST")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String trstSt;

    /**
     * 股东代码
     */
    @Column(name = "SHRH_CD")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String shrhCd;

    /**
     * 持仓多空标志
     */
    @Column(name = "HLDN_LNG_SHRT_IDNT")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String hldnLngShrtIdnt;

    /**
     * 证券内码
     */
    @Column(name = "SCRT_INTR_CD")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String scrtIntrCd;

    /**
     * 期初数量
     */
    @Column(name = "BGNN_QNTT")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Double bgnnQntt;

    /**
     * 当前数量
     */
    @Column(name = "CRRN_QNTT")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Double crrnQntt;

    /**
     * 当日买入数量
     */
    @Column(name = "TDY_LNG_QNTT")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Double tdyLngQntt;

    /**
     * 当日卖出数量
     */
    @Column(name = "TDY_SHRT_QNTT")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Double tdyShrtQntt;

    /**
     * 当日买入金额
     */
    @Column(name = "TDY_LNG_AMNT")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Double tdyLngAmnt;

    /**
     * 当日卖出金额
     */
    @Column(name = "TDY_SHRT_AMNT")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Double tdyShrtAmnt;

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

    public static final String TABLE = "C01_FND_ASST_DTL";

    public static final String f_trdnDt = "trdnDt";

    public static final String f_fndsNmbr = "fndsNmbr";

    public static final String f_trstSt = "trstSt";

    public static final String f_shrhCd = "shrhCd";

    public static final String f_hldnLngShrtIdnt = "hldnLngShrtIdnt";

    public static final String f_scrtIntrCd = "scrtIntrCd";

    public static final String f_bgnnQntt = "bgnnQntt";

    public static final String f_crrnQntt = "crrnQntt";

    public static final String f_tdyLngQntt = "tdyLngQntt";

    public static final String f_tdyShrtQntt = "tdyShrtQntt";

    public static final String f_tdyLngAmnt = "tdyLngAmnt";

    public static final String f_tdyShrtAmnt = "tdyShrtAmnt";

    public static final String f_rsrcSyst = "rsrcSyst";

    public static final String f_btchDt = "btchDt";

    public static final String f_etlSrcTblNm = "etlSrcTblNm";

    public static final String f_etlJobNm = "etlJobNm";

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
     * 获取托管席位
     *
     * @return TRST_ST - 托管席位
     */
    public String getTrstSt() {
        return trstSt;
    }

    /**
     * 设置托管席位
     *
     * @param trstSt 托管席位
     */
    public void setTrstSt(String trstSt) {
        this.trstSt = trstSt == null ? null : trstSt.trim();
    }

    /**
     * 获取股东代码
     *
     * @return SHRH_CD - 股东代码
     */
    public String getShrhCd() {
        return shrhCd;
    }

    /**
     * 设置股东代码
     *
     * @param shrhCd 股东代码
     */
    public void setShrhCd(String shrhCd) {
        this.shrhCd = shrhCd == null ? null : shrhCd.trim();
    }

    /**
     * 获取持仓多空标志
     *
     * @return HLDN_LNG_SHRT_IDNT - 持仓多空标志
     */
    public String getHldnLngShrtIdnt() {
        return hldnLngShrtIdnt;
    }

    /**
     * 设置持仓多空标志
     *
     * @param hldnLngShrtIdnt 持仓多空标志
     */
    public void setHldnLngShrtIdnt(String hldnLngShrtIdnt) {
        this.hldnLngShrtIdnt = hldnLngShrtIdnt == null ? null : hldnLngShrtIdnt.trim();
    }

    /**
     * 获取证券内码
     *
     * @return SCRT_INTR_CD - 证券内码
     */
    public String getScrtIntrCd() {
        return scrtIntrCd;
    }

    /**
     * 设置证券内码
     *
     * @param scrtIntrCd 证券内码
     */
    public void setScrtIntrCd(String scrtIntrCd) {
        this.scrtIntrCd = scrtIntrCd == null ? null : scrtIntrCd.trim();
    }

    /**
     * 获取期初数量
     *
     * @return BGNN_QNTT - 期初数量
     */
    public Double getBgnnQntt() {
        return bgnnQntt;
    }

    /**
     * 设置期初数量
     *
     * @param bgnnQntt 期初数量
     */
    public void setBgnnQntt(Double bgnnQntt) {
        this.bgnnQntt = bgnnQntt;
    }

    /**
     * 获取当前数量
     *
     * @return CRRN_QNTT - 当前数量
     */
    public Double getCrrnQntt() {
        return crrnQntt;
    }

    /**
     * 设置当前数量
     *
     * @param crrnQntt 当前数量
     */
    public void setCrrnQntt(Double crrnQntt) {
        this.crrnQntt = crrnQntt;
    }

    /**
     * 获取当日买入数量
     *
     * @return TDY_LNG_QNTT - 当日买入数量
     */
    public Double getTdyLngQntt() {
        return tdyLngQntt;
    }

    /**
     * 设置当日买入数量
     *
     * @param tdyLngQntt 当日买入数量
     */
    public void setTdyLngQntt(Double tdyLngQntt) {
        this.tdyLngQntt = tdyLngQntt;
    }

    /**
     * 获取当日卖出数量
     *
     * @return TDY_SHRT_QNTT - 当日卖出数量
     */
    public Double getTdyShrtQntt() {
        return tdyShrtQntt;
    }

    /**
     * 设置当日卖出数量
     *
     * @param tdyShrtQntt 当日卖出数量
     */
    public void setTdyShrtQntt(Double tdyShrtQntt) {
        this.tdyShrtQntt = tdyShrtQntt;
    }

    /**
     * 获取当日买入金额
     *
     * @return TDY_LNG_AMNT - 当日买入金额
     */
    public Double getTdyLngAmnt() {
        return tdyLngAmnt;
    }

    /**
     * 设置当日买入金额
     *
     * @param tdyLngAmnt 当日买入金额
     */
    public void setTdyLngAmnt(Double tdyLngAmnt) {
        this.tdyLngAmnt = tdyLngAmnt;
    }

    /**
     * 获取当日卖出金额
     *
     * @return TDY_SHRT_AMNT - 当日卖出金额
     */
    public Double getTdyShrtAmnt() {
        return tdyShrtAmnt;
    }

    /**
     * 设置当日卖出金额
     *
     * @param tdyShrtAmnt 当日卖出金额
     */
    public void setTdyShrtAmnt(Double tdyShrtAmnt) {
        this.tdyShrtAmnt = tdyShrtAmnt;
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