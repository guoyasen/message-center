package com.iquantex.tspweb.model;

import java.util.Date;
import javax.persistence.*;
import org.apache.ibatis.type.JdbcType;
import tk.mybatis.mapper.annotation.ColumnType;

@Table(name = "C01_INST_STCK")
public class C01InstStck {
    /**
     * 指令序号
     */
    @Column(name = "INST_ID")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Long instId;

    /**
     * 指令修改次序
     */
    @Column(name = "INST_MDFY_ORDR")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Long instMdfyOrdr;

    /**
     * 投资类型
     */
    @Column(name = "INVS_TYP")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String invsTyp;

    /**
     * 组合序号
     */
    @Column(name = "PRTF_SRL_ID")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String prtfSrlId;

    /**
     * 证券内码
     */
    @Column(name = "SCRT_INTR_CD")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String scrtIntrCd;

    /**
     * 委托方向
     */
    @Column(name = "CMMS_DRCT")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String cmmsDrct;

    /**
     * 金额证券标志
     */
    @Column(name = "AMNT_SCRT_IDNT")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String amntScrtIdnt;

    /**
     * 基金序号
     */
    @Column(name = "FND_SRL_ID")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Long fndSrlId;

    /**
     * 指令证券序号
     */
    @Column(name = "INST_SCRT_SRL_ID")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Long instScrtSrlId;

    /**
     * 日期
     */
    @Column(name = "DT")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Long dt;

    /**
     * 指令数量
     */
    @Column(name = "INST_QNTT")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Double instQntt;

    /**
     * 指令金额
     */
    @Column(name = "INST_AMNT")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Double instAmnt;

    /**
     * 价格模式
     */
    @Column(name = "PRC_MDL")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String prcMdl;

    /**
     * 指令价格
     */
    @Column(name = "INST_PRC")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Double instPrc;

    /**
     * 实际价格
     */
    @Column(name = "ACTL_PRC")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Double actlPrc;

    /**
     * 当日委托数量
     */
    @Column(name = "TDY_CMMS_QNTT")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Double tdyCmmsQntt;

    /**
     * 当日委托金额
     */
    @Column(name = "TDY_CMMS_AMNT")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Double tdyCmmsAmnt;

    /**
     * 当日成交数量
     */
    @Column(name = "TDY_DL_QNTT")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Double tdyDlQntt;

    /**
     * 当日成交金额
     */
    @Column(name = "TDY_TRNV")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Double tdyTrnv;

    /**
     * 当日成交均价
     */
    @Column(name = "TDY_AVRG_FNL_PRC")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Double tdyAvrgFnlPrc;

    /**
     * 状态
     */
    @Column(name = "STT")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String stt;

    /**
     * 委托完成状态
     */
    @Column(name = "CMMS_CMPL_STT")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String cmmsCmplStt;

    /**
     * 成交完成状态
     */
    @Column(name = "DL_CMPL_STT")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String dlCmplStt;

    /**
     * 累计成交数量
     */
    @Column(name = "ACCM_DL_QNTT")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Double accmDlQntt;

    /**
     * 累计成交金额
     */
    @Column(name = "ACCM_TRNV")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Double accmTrnv;

    /**
     * 累计成交均价
     */
    @Column(name = "ACCM_AVRG_FNL_PRC")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Double accmAvrgFnlPrc;

    /**
     * 累计委托数量
     */
    @Column(name = "ACCM_CMMS_QNTT")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Double accmCmmsQntt;

    /**
     * 累计委托金额
     */
    @Column(name = "ACCM_CMMS_AMNT")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Double accmCmmsAmnt;

    /**
     * 指令成交完成时间
     */
    @Column(name = "INST_DL_CMPL_TM")
    @ColumnType(jdbcType = JdbcType.TIMESTAMP)
    private Date instDlCmplTm;

    /**
     * 指令目标净值比例
     */
    @Column(name = "INST_TRGT_NTVL_RT")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Double instTrgtNtvlRt;

    /**
     * 组合目标净值比例
     */
    @Column(name = "PRTF_TRGT_NTVL_RT")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Double prtfTrgtNtvlRt;

    /**
     * 指令业务分类
     */
    @Column(name = "INST_BSNS_CLSS")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String instBsnsClss;

    /**
     * 指令起始日期
     */
    @Column(name = "INST_STRT_DT")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Long instStrtDt;

    /**
     * 指令起始时间
     */
    @Column(name = "INST_STRT_TM")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Long instStrtTm;

    /**
     * 指令终止日期
     */
    @Column(name = "INST_END_DT")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Long instEndDt;

    /**
     * 指令终止时间
     */
    @Column(name = "INST_END_TM")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Long instEndTm;

    /**
     * 清算速度
     */
    @Column(name = "STTL_SPD")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Long sttlSpd;

    /**
     * 交割日
     */
    @Column(name = "DLVR_DT")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Long dlvrDt;

    /**
     * 结算方式
     */
    @Column(name = "STTL_MTHD")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String sttlMthd;

    /**
     * 交易对手
     */
    @Column(name = "CNTR")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Long cntr;

    /**
     * 交易类别
     */
    @Column(name = "TRDN_TYP")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String trdnTyp;

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

    public static final String TABLE = "C01_INST_STCK";

    public static final String f_instId = "instId";

    public static final String f_instMdfyOrdr = "instMdfyOrdr";

    public static final String f_invsTyp = "invsTyp";

    public static final String f_prtfSrlId = "prtfSrlId";

    public static final String f_scrtIntrCd = "scrtIntrCd";

    public static final String f_cmmsDrct = "cmmsDrct";

    public static final String f_amntScrtIdnt = "amntScrtIdnt";

    public static final String f_fndSrlId = "fndSrlId";

    public static final String f_instScrtSrlId = "instScrtSrlId";

    public static final String f_dt = "dt";

    public static final String f_instQntt = "instQntt";

    public static final String f_instAmnt = "instAmnt";

    public static final String f_prcMdl = "prcMdl";

    public static final String f_instPrc = "instPrc";

    public static final String f_actlPrc = "actlPrc";

    public static final String f_tdyCmmsQntt = "tdyCmmsQntt";

    public static final String f_tdyCmmsAmnt = "tdyCmmsAmnt";

    public static final String f_tdyDlQntt = "tdyDlQntt";

    public static final String f_tdyTrnv = "tdyTrnv";

    public static final String f_tdyAvrgFnlPrc = "tdyAvrgFnlPrc";

    public static final String f_stt = "stt";

    public static final String f_cmmsCmplStt = "cmmsCmplStt";

    public static final String f_dlCmplStt = "dlCmplStt";

    public static final String f_accmDlQntt = "accmDlQntt";

    public static final String f_accmTrnv = "accmTrnv";

    public static final String f_accmAvrgFnlPrc = "accmAvrgFnlPrc";

    public static final String f_accmCmmsQntt = "accmCmmsQntt";

    public static final String f_accmCmmsAmnt = "accmCmmsAmnt";

    public static final String f_instDlCmplTm = "instDlCmplTm";

    public static final String f_instTrgtNtvlRt = "instTrgtNtvlRt";

    public static final String f_prtfTrgtNtvlRt = "prtfTrgtNtvlRt";

    public static final String f_instBsnsClss = "instBsnsClss";

    public static final String f_instStrtDt = "instStrtDt";

    public static final String f_instStrtTm = "instStrtTm";

    public static final String f_instEndDt = "instEndDt";

    public static final String f_instEndTm = "instEndTm";

    public static final String f_sttlSpd = "sttlSpd";

    public static final String f_dlvrDt = "dlvrDt";

    public static final String f_sttlMthd = "sttlMthd";

    public static final String f_cntr = "cntr";

    public static final String f_trdnTyp = "trdnTyp";

    public static final String f_rsrcSyst = "rsrcSyst";

    public static final String f_btchDt = "btchDt";

    public static final String f_etlSrcTblNm = "etlSrcTblNm";

    public static final String f_etlJobNm = "etlJobNm";

    /**
     * 获取指令序号
     *
     * @return INST_ID - 指令序号
     */
    public Long getInstId() {
        return instId;
    }

    /**
     * 设置指令序号
     *
     * @param instId 指令序号
     */
    public void setInstId(Long instId) {
        this.instId = instId;
    }

    /**
     * 获取指令修改次序
     *
     * @return INST_MDFY_ORDR - 指令修改次序
     */
    public Long getInstMdfyOrdr() {
        return instMdfyOrdr;
    }

    /**
     * 设置指令修改次序
     *
     * @param instMdfyOrdr 指令修改次序
     */
    public void setInstMdfyOrdr(Long instMdfyOrdr) {
        this.instMdfyOrdr = instMdfyOrdr;
    }

    /**
     * 获取投资类型
     *
     * @return INVS_TYP - 投资类型
     */
    public String getInvsTyp() {
        return invsTyp;
    }

    /**
     * 设置投资类型
     *
     * @param invsTyp 投资类型
     */
    public void setInvsTyp(String invsTyp) {
        this.invsTyp = invsTyp == null ? null : invsTyp.trim();
    }

    /**
     * 获取组合序号
     *
     * @return PRTF_SRL_ID - 组合序号
     */
    public String getPrtfSrlId() {
        return prtfSrlId;
    }

    /**
     * 设置组合序号
     *
     * @param prtfSrlId 组合序号
     */
    public void setPrtfSrlId(String prtfSrlId) {
        this.prtfSrlId = prtfSrlId == null ? null : prtfSrlId.trim();
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
     * 获取委托方向
     *
     * @return CMMS_DRCT - 委托方向
     */
    public String getCmmsDrct() {
        return cmmsDrct;
    }

    /**
     * 设置委托方向
     *
     * @param cmmsDrct 委托方向
     */
    public void setCmmsDrct(String cmmsDrct) {
        this.cmmsDrct = cmmsDrct == null ? null : cmmsDrct.trim();
    }

    /**
     * 获取金额证券标志
     *
     * @return AMNT_SCRT_IDNT - 金额证券标志
     */
    public String getAmntScrtIdnt() {
        return amntScrtIdnt;
    }

    /**
     * 设置金额证券标志
     *
     * @param amntScrtIdnt 金额证券标志
     */
    public void setAmntScrtIdnt(String amntScrtIdnt) {
        this.amntScrtIdnt = amntScrtIdnt == null ? null : amntScrtIdnt.trim();
    }

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
     * 获取指令证券序号
     *
     * @return INST_SCRT_SRL_ID - 指令证券序号
     */
    public Long getInstScrtSrlId() {
        return instScrtSrlId;
    }

    /**
     * 设置指令证券序号
     *
     * @param instScrtSrlId 指令证券序号
     */
    public void setInstScrtSrlId(Long instScrtSrlId) {
        this.instScrtSrlId = instScrtSrlId;
    }

    /**
     * 获取日期
     *
     * @return DT - 日期
     */
    public Long getDt() {
        return dt;
    }

    /**
     * 设置日期
     *
     * @param dt 日期
     */
    public void setDt(Long dt) {
        this.dt = dt;
    }

    /**
     * 获取指令数量
     *
     * @return INST_QNTT - 指令数量
     */
    public Double getInstQntt() {
        return instQntt;
    }

    /**
     * 设置指令数量
     *
     * @param instQntt 指令数量
     */
    public void setInstQntt(Double instQntt) {
        this.instQntt = instQntt;
    }

    /**
     * 获取指令金额
     *
     * @return INST_AMNT - 指令金额
     */
    public Double getInstAmnt() {
        return instAmnt;
    }

    /**
     * 设置指令金额
     *
     * @param instAmnt 指令金额
     */
    public void setInstAmnt(Double instAmnt) {
        this.instAmnt = instAmnt;
    }

    /**
     * 获取价格模式
     *
     * @return PRC_MDL - 价格模式
     */
    public String getPrcMdl() {
        return prcMdl;
    }

    /**
     * 设置价格模式
     *
     * @param prcMdl 价格模式
     */
    public void setPrcMdl(String prcMdl) {
        this.prcMdl = prcMdl == null ? null : prcMdl.trim();
    }

    /**
     * 获取指令价格
     *
     * @return INST_PRC - 指令价格
     */
    public Double getInstPrc() {
        return instPrc;
    }

    /**
     * 设置指令价格
     *
     * @param instPrc 指令价格
     */
    public void setInstPrc(Double instPrc) {
        this.instPrc = instPrc;
    }

    /**
     * 获取实际价格
     *
     * @return ACTL_PRC - 实际价格
     */
    public Double getActlPrc() {
        return actlPrc;
    }

    /**
     * 设置实际价格
     *
     * @param actlPrc 实际价格
     */
    public void setActlPrc(Double actlPrc) {
        this.actlPrc = actlPrc;
    }

    /**
     * 获取当日委托数量
     *
     * @return TDY_CMMS_QNTT - 当日委托数量
     */
    public Double getTdyCmmsQntt() {
        return tdyCmmsQntt;
    }

    /**
     * 设置当日委托数量
     *
     * @param tdyCmmsQntt 当日委托数量
     */
    public void setTdyCmmsQntt(Double tdyCmmsQntt) {
        this.tdyCmmsQntt = tdyCmmsQntt;
    }

    /**
     * 获取当日委托金额
     *
     * @return TDY_CMMS_AMNT - 当日委托金额
     */
    public Double getTdyCmmsAmnt() {
        return tdyCmmsAmnt;
    }

    /**
     * 设置当日委托金额
     *
     * @param tdyCmmsAmnt 当日委托金额
     */
    public void setTdyCmmsAmnt(Double tdyCmmsAmnt) {
        this.tdyCmmsAmnt = tdyCmmsAmnt;
    }

    /**
     * 获取当日成交数量
     *
     * @return TDY_DL_QNTT - 当日成交数量
     */
    public Double getTdyDlQntt() {
        return tdyDlQntt;
    }

    /**
     * 设置当日成交数量
     *
     * @param tdyDlQntt 当日成交数量
     */
    public void setTdyDlQntt(Double tdyDlQntt) {
        this.tdyDlQntt = tdyDlQntt;
    }

    /**
     * 获取当日成交金额
     *
     * @return TDY_TRNV - 当日成交金额
     */
    public Double getTdyTrnv() {
        return tdyTrnv;
    }

    /**
     * 设置当日成交金额
     *
     * @param tdyTrnv 当日成交金额
     */
    public void setTdyTrnv(Double tdyTrnv) {
        this.tdyTrnv = tdyTrnv;
    }

    /**
     * 获取当日成交均价
     *
     * @return TDY_AVRG_FNL_PRC - 当日成交均价
     */
    public Double getTdyAvrgFnlPrc() {
        return tdyAvrgFnlPrc;
    }

    /**
     * 设置当日成交均价
     *
     * @param tdyAvrgFnlPrc 当日成交均价
     */
    public void setTdyAvrgFnlPrc(Double tdyAvrgFnlPrc) {
        this.tdyAvrgFnlPrc = tdyAvrgFnlPrc;
    }

    /**
     * 获取状态
     *
     * @return STT - 状态
     */
    public String getStt() {
        return stt;
    }

    /**
     * 设置状态
     *
     * @param stt 状态
     */
    public void setStt(String stt) {
        this.stt = stt == null ? null : stt.trim();
    }

    /**
     * 获取委托完成状态
     *
     * @return CMMS_CMPL_STT - 委托完成状态
     */
    public String getCmmsCmplStt() {
        return cmmsCmplStt;
    }

    /**
     * 设置委托完成状态
     *
     * @param cmmsCmplStt 委托完成状态
     */
    public void setCmmsCmplStt(String cmmsCmplStt) {
        this.cmmsCmplStt = cmmsCmplStt == null ? null : cmmsCmplStt.trim();
    }

    /**
     * 获取成交完成状态
     *
     * @return DL_CMPL_STT - 成交完成状态
     */
    public String getDlCmplStt() {
        return dlCmplStt;
    }

    /**
     * 设置成交完成状态
     *
     * @param dlCmplStt 成交完成状态
     */
    public void setDlCmplStt(String dlCmplStt) {
        this.dlCmplStt = dlCmplStt == null ? null : dlCmplStt.trim();
    }

    /**
     * 获取累计成交数量
     *
     * @return ACCM_DL_QNTT - 累计成交数量
     */
    public Double getAccmDlQntt() {
        return accmDlQntt;
    }

    /**
     * 设置累计成交数量
     *
     * @param accmDlQntt 累计成交数量
     */
    public void setAccmDlQntt(Double accmDlQntt) {
        this.accmDlQntt = accmDlQntt;
    }

    /**
     * 获取累计成交金额
     *
     * @return ACCM_TRNV - 累计成交金额
     */
    public Double getAccmTrnv() {
        return accmTrnv;
    }

    /**
     * 设置累计成交金额
     *
     * @param accmTrnv 累计成交金额
     */
    public void setAccmTrnv(Double accmTrnv) {
        this.accmTrnv = accmTrnv;
    }

    /**
     * 获取累计成交均价
     *
     * @return ACCM_AVRG_FNL_PRC - 累计成交均价
     */
    public Double getAccmAvrgFnlPrc() {
        return accmAvrgFnlPrc;
    }

    /**
     * 设置累计成交均价
     *
     * @param accmAvrgFnlPrc 累计成交均价
     */
    public void setAccmAvrgFnlPrc(Double accmAvrgFnlPrc) {
        this.accmAvrgFnlPrc = accmAvrgFnlPrc;
    }

    /**
     * 获取累计委托数量
     *
     * @return ACCM_CMMS_QNTT - 累计委托数量
     */
    public Double getAccmCmmsQntt() {
        return accmCmmsQntt;
    }

    /**
     * 设置累计委托数量
     *
     * @param accmCmmsQntt 累计委托数量
     */
    public void setAccmCmmsQntt(Double accmCmmsQntt) {
        this.accmCmmsQntt = accmCmmsQntt;
    }

    /**
     * 获取累计委托金额
     *
     * @return ACCM_CMMS_AMNT - 累计委托金额
     */
    public Double getAccmCmmsAmnt() {
        return accmCmmsAmnt;
    }

    /**
     * 设置累计委托金额
     *
     * @param accmCmmsAmnt 累计委托金额
     */
    public void setAccmCmmsAmnt(Double accmCmmsAmnt) {
        this.accmCmmsAmnt = accmCmmsAmnt;
    }

    /**
     * 获取指令成交完成时间
     *
     * @return INST_DL_CMPL_TM - 指令成交完成时间
     */
    public Date getInstDlCmplTm() {
        return instDlCmplTm;
    }

    /**
     * 设置指令成交完成时间
     *
     * @param instDlCmplTm 指令成交完成时间
     */
    public void setInstDlCmplTm(Date instDlCmplTm) {
        this.instDlCmplTm = instDlCmplTm;
    }

    /**
     * 获取指令目标净值比例
     *
     * @return INST_TRGT_NTVL_RT - 指令目标净值比例
     */
    public Double getInstTrgtNtvlRt() {
        return instTrgtNtvlRt;
    }

    /**
     * 设置指令目标净值比例
     *
     * @param instTrgtNtvlRt 指令目标净值比例
     */
    public void setInstTrgtNtvlRt(Double instTrgtNtvlRt) {
        this.instTrgtNtvlRt = instTrgtNtvlRt;
    }

    /**
     * 获取组合目标净值比例
     *
     * @return PRTF_TRGT_NTVL_RT - 组合目标净值比例
     */
    public Double getPrtfTrgtNtvlRt() {
        return prtfTrgtNtvlRt;
    }

    /**
     * 设置组合目标净值比例
     *
     * @param prtfTrgtNtvlRt 组合目标净值比例
     */
    public void setPrtfTrgtNtvlRt(Double prtfTrgtNtvlRt) {
        this.prtfTrgtNtvlRt = prtfTrgtNtvlRt;
    }

    /**
     * 获取指令业务分类
     *
     * @return INST_BSNS_CLSS - 指令业务分类
     */
    public String getInstBsnsClss() {
        return instBsnsClss;
    }

    /**
     * 设置指令业务分类
     *
     * @param instBsnsClss 指令业务分类
     */
    public void setInstBsnsClss(String instBsnsClss) {
        this.instBsnsClss = instBsnsClss == null ? null : instBsnsClss.trim();
    }

    /**
     * 获取指令起始日期
     *
     * @return INST_STRT_DT - 指令起始日期
     */
    public Long getInstStrtDt() {
        return instStrtDt;
    }

    /**
     * 设置指令起始日期
     *
     * @param instStrtDt 指令起始日期
     */
    public void setInstStrtDt(Long instStrtDt) {
        this.instStrtDt = instStrtDt;
    }

    /**
     * 获取指令起始时间
     *
     * @return INST_STRT_TM - 指令起始时间
     */
    public Long getInstStrtTm() {
        return instStrtTm;
    }

    /**
     * 设置指令起始时间
     *
     * @param instStrtTm 指令起始时间
     */
    public void setInstStrtTm(Long instStrtTm) {
        this.instStrtTm = instStrtTm;
    }

    /**
     * 获取指令终止日期
     *
     * @return INST_END_DT - 指令终止日期
     */
    public Long getInstEndDt() {
        return instEndDt;
    }

    /**
     * 设置指令终止日期
     *
     * @param instEndDt 指令终止日期
     */
    public void setInstEndDt(Long instEndDt) {
        this.instEndDt = instEndDt;
    }

    /**
     * 获取指令终止时间
     *
     * @return INST_END_TM - 指令终止时间
     */
    public Long getInstEndTm() {
        return instEndTm;
    }

    /**
     * 设置指令终止时间
     *
     * @param instEndTm 指令终止时间
     */
    public void setInstEndTm(Long instEndTm) {
        this.instEndTm = instEndTm;
    }

    /**
     * 获取清算速度
     *
     * @return STTL_SPD - 清算速度
     */
    public Long getSttlSpd() {
        return sttlSpd;
    }

    /**
     * 设置清算速度
     *
     * @param sttlSpd 清算速度
     */
    public void setSttlSpd(Long sttlSpd) {
        this.sttlSpd = sttlSpd;
    }

    /**
     * 获取交割日
     *
     * @return DLVR_DT - 交割日
     */
    public Long getDlvrDt() {
        return dlvrDt;
    }

    /**
     * 设置交割日
     *
     * @param dlvrDt 交割日
     */
    public void setDlvrDt(Long dlvrDt) {
        this.dlvrDt = dlvrDt;
    }

    /**
     * 获取结算方式
     *
     * @return STTL_MTHD - 结算方式
     */
    public String getSttlMthd() {
        return sttlMthd;
    }

    /**
     * 设置结算方式
     *
     * @param sttlMthd 结算方式
     */
    public void setSttlMthd(String sttlMthd) {
        this.sttlMthd = sttlMthd == null ? null : sttlMthd.trim();
    }

    /**
     * 获取交易对手
     *
     * @return CNTR - 交易对手
     */
    public Long getCntr() {
        return cntr;
    }

    /**
     * 设置交易对手
     *
     * @param cntr 交易对手
     */
    public void setCntr(Long cntr) {
        this.cntr = cntr;
    }

    /**
     * 获取交易类别
     *
     * @return TRDN_TYP - 交易类别
     */
    public String getTrdnTyp() {
        return trdnTyp;
    }

    /**
     * 设置交易类别
     *
     * @param trdnTyp 交易类别
     */
    public void setTrdnTyp(String trdnTyp) {
        this.trdnTyp = trdnTyp == null ? null : trdnTyp.trim();
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