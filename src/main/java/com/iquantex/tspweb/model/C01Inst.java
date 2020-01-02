package com.iquantex.tspweb.model;

import java.util.Date;
import javax.persistence.*;
import org.apache.ibatis.type.JdbcType;
import tk.mybatis.mapper.annotation.ColumnType;

@Table(name = "C01_INST")
public class C01Inst {
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
     * 交易日期
     */
    @Column(name = "TRDN_DT")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Long trdnDt;

    /**
     * 基金序号
     */
    @Column(name = "FND_SRL_ID")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Long fndSrlId;

    /**
     * 组合序号
     */
    @Column(name = "PRTF_SRL_ID")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Long prtfSrlId;

    /**
     * 指令类型
     */
    @Column(name = "INST_TYP")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String instTyp;

    /**
     * 指令目标类型
     */
    @Column(name = "INST_TRGT_TYP")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String instTrgtTyp;

    /**
     * 指令目标值
     */
    @Column(name = "INST_TRGT_VL")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Double instTrgtVl;

    /**
     * 指令目标基数
     */
    @Column(name = "INST_TRGT_BS")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Double instTrgtBs;

    /**
     * 交易对手
     */
    @Column(name = "CNTR")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Long cntr;

    /**
     * 清算速度
     */
    @Column(name = "STTL_SPD")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Long sttlSpd;

    /**
     * 回购天数
     */
    @Column(name = "BUY_BCK_DYS")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Long buyBckDys;

    /**
     * 指令起始日期
     */
    @Column(name = "INST_STRT_DT")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Long instStrtDt;

    /**
     * 指令终止日期
     */
    @Column(name = "INST_END_DT")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Long instEndDt;

    /**
     * 指令起始时间
     */
    @Column(name = "INST_STRT_TM")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Long instStrtTm;

    /**
     * 指令终止时间
     */
    @Column(name = "INST_END_TM")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Long instEndTm;

    /**
     * 指令下达日期
     */
    @Column(name = "INST_ODR_DT")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Long instOdrDt;

    /**
     * 指令下达时间
     */
    @Column(name = "INST_ODR_TM")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Long instOdrTm;

    /**
     * 指令下达人
     */
    @Column(name = "INST_ORDR_PRSN")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Long instOrdrPrsn;

    /**
     * 审批时间
     */
    @Column(name = "ADT_TM")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Long adtTm;

    /**
     * 审批人
     */
    @Column(name = "ADTR")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Long adtr;

    /**
     * 审批拒绝原因
     */
    @Column(name = "ADT_RFS_RSN")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String adtRfsRsn;

    /**
     * 分发时间
     */
    @Column(name = "DSTR_TM")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Long dstrTm;

    /**
     * 分发人
     */
    @Column(name = "DSTR")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Long dstr;

    /**
     * 分发拒绝原因
     */
    @Column(name = "DSTR_RFS_RSN")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String dstrRfsRsn;

    /**
     * 撤销时间
     */
    @Column(name = "WTHD_TM")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Long wthdTm;

    /**
     * 撤销人
     */
    @Column(name = "RVCT_PRSN")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Long rvctPrsn;

    /**
     * 撤销原因
     */
    @Column(name = "WTHD_RSN")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String wthdRsn;

    /**
     * 执行人
     */
    @Column(name = "EXCT")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Long exct;

    /**
     * 指令状态
     */
    @Column(name = "INST_STT")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String instStt;

    /**
     * 审批状态
     */
    @Column(name = "ADT_STT")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String adtStt;

    /**
     * 分发状态
     */
    @Column(name = "DSTR_STT")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String dstrStt;

    /**
     * 撤销分发状态
     */
    @Column(name = "WTHD_DSTR_STT")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String wthdDstrStt;

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
     * 时间戳
     */
    @Column(name = "TMST")
    @ColumnType(jdbcType = JdbcType.TIMESTAMP)
    private Date tmst;

    /**
     * 指令业务分类
     */
    @Column(name = "INST_BSNS_CLSS")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String instBsnsClss;

    /**
     * 分发日期
     */
    @Column(name = "DSTR_DT")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Long dstrDt;

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

    public static final String TABLE = "C01_INST";

    public static final String f_instId = "instId";

    public static final String f_instMdfyOrdr = "instMdfyOrdr";

    public static final String f_trdnDt = "trdnDt";

    public static final String f_fndSrlId = "fndSrlId";

    public static final String f_prtfSrlId = "prtfSrlId";

    public static final String f_instTyp = "instTyp";

    public static final String f_instTrgtTyp = "instTrgtTyp";

    public static final String f_instTrgtVl = "instTrgtVl";

    public static final String f_instTrgtBs = "instTrgtBs";

    public static final String f_cntr = "cntr";

    public static final String f_sttlSpd = "sttlSpd";

    public static final String f_buyBckDys = "buyBckDys";

    public static final String f_instStrtDt = "instStrtDt";

    public static final String f_instEndDt = "instEndDt";

    public static final String f_instStrtTm = "instStrtTm";

    public static final String f_instEndTm = "instEndTm";

    public static final String f_instOdrDt = "instOdrDt";

    public static final String f_instOdrTm = "instOdrTm";

    public static final String f_instOrdrPrsn = "instOrdrPrsn";

    public static final String f_adtTm = "adtTm";

    public static final String f_adtr = "adtr";

    public static final String f_adtRfsRsn = "adtRfsRsn";

    public static final String f_dstrTm = "dstrTm";

    public static final String f_dstr = "dstr";

    public static final String f_dstrRfsRsn = "dstrRfsRsn";

    public static final String f_wthdTm = "wthdTm";

    public static final String f_rvctPrsn = "rvctPrsn";

    public static final String f_wthdRsn = "wthdRsn";

    public static final String f_exct = "exct";

    public static final String f_instStt = "instStt";

    public static final String f_adtStt = "adtStt";

    public static final String f_dstrStt = "dstrStt";

    public static final String f_wthdDstrStt = "wthdDstrStt";

    public static final String f_cmmsCmplStt = "cmmsCmplStt";

    public static final String f_dlCmplStt = "dlCmplStt";

    public static final String f_tmst = "tmst";

    public static final String f_instBsnsClss = "instBsnsClss";

    public static final String f_dstrDt = "dstrDt";

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
     * 获取交易日期
     *
     * @return TRDN_DT - 交易日期
     */
    public Long getTrdnDt() {
        return trdnDt;
    }

    /**
     * 设置交易日期
     *
     * @param trdnDt 交易日期
     */
    public void setTrdnDt(Long trdnDt) {
        this.trdnDt = trdnDt;
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
     * 获取组合序号
     *
     * @return PRTF_SRL_ID - 组合序号
     */
    public Long getPrtfSrlId() {
        return prtfSrlId;
    }

    /**
     * 设置组合序号
     *
     * @param prtfSrlId 组合序号
     */
    public void setPrtfSrlId(Long prtfSrlId) {
        this.prtfSrlId = prtfSrlId;
    }

    /**
     * 获取指令类型
     *
     * @return INST_TYP - 指令类型
     */
    public String getInstTyp() {
        return instTyp;
    }

    /**
     * 设置指令类型
     *
     * @param instTyp 指令类型
     */
    public void setInstTyp(String instTyp) {
        this.instTyp = instTyp == null ? null : instTyp.trim();
    }

    /**
     * 获取指令目标类型
     *
     * @return INST_TRGT_TYP - 指令目标类型
     */
    public String getInstTrgtTyp() {
        return instTrgtTyp;
    }

    /**
     * 设置指令目标类型
     *
     * @param instTrgtTyp 指令目标类型
     */
    public void setInstTrgtTyp(String instTrgtTyp) {
        this.instTrgtTyp = instTrgtTyp == null ? null : instTrgtTyp.trim();
    }

    /**
     * 获取指令目标值
     *
     * @return INST_TRGT_VL - 指令目标值
     */
    public Double getInstTrgtVl() {
        return instTrgtVl;
    }

    /**
     * 设置指令目标值
     *
     * @param instTrgtVl 指令目标值
     */
    public void setInstTrgtVl(Double instTrgtVl) {
        this.instTrgtVl = instTrgtVl;
    }

    /**
     * 获取指令目标基数
     *
     * @return INST_TRGT_BS - 指令目标基数
     */
    public Double getInstTrgtBs() {
        return instTrgtBs;
    }

    /**
     * 设置指令目标基数
     *
     * @param instTrgtBs 指令目标基数
     */
    public void setInstTrgtBs(Double instTrgtBs) {
        this.instTrgtBs = instTrgtBs;
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
     * 获取回购天数
     *
     * @return BUY_BCK_DYS - 回购天数
     */
    public Long getBuyBckDys() {
        return buyBckDys;
    }

    /**
     * 设置回购天数
     *
     * @param buyBckDys 回购天数
     */
    public void setBuyBckDys(Long buyBckDys) {
        this.buyBckDys = buyBckDys;
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
     * 获取指令下达日期
     *
     * @return INST_ODR_DT - 指令下达日期
     */
    public Long getInstOdrDt() {
        return instOdrDt;
    }

    /**
     * 设置指令下达日期
     *
     * @param instOdrDt 指令下达日期
     */
    public void setInstOdrDt(Long instOdrDt) {
        this.instOdrDt = instOdrDt;
    }

    /**
     * 获取指令下达时间
     *
     * @return INST_ODR_TM - 指令下达时间
     */
    public Long getInstOdrTm() {
        return instOdrTm;
    }

    /**
     * 设置指令下达时间
     *
     * @param instOdrTm 指令下达时间
     */
    public void setInstOdrTm(Long instOdrTm) {
        this.instOdrTm = instOdrTm;
    }

    /**
     * 获取指令下达人
     *
     * @return INST_ORDR_PRSN - 指令下达人
     */
    public Long getInstOrdrPrsn() {
        return instOrdrPrsn;
    }

    /**
     * 设置指令下达人
     *
     * @param instOrdrPrsn 指令下达人
     */
    public void setInstOrdrPrsn(Long instOrdrPrsn) {
        this.instOrdrPrsn = instOrdrPrsn;
    }

    /**
     * 获取审批时间
     *
     * @return ADT_TM - 审批时间
     */
    public Long getAdtTm() {
        return adtTm;
    }

    /**
     * 设置审批时间
     *
     * @param adtTm 审批时间
     */
    public void setAdtTm(Long adtTm) {
        this.adtTm = adtTm;
    }

    /**
     * 获取审批人
     *
     * @return ADTR - 审批人
     */
    public Long getAdtr() {
        return adtr;
    }

    /**
     * 设置审批人
     *
     * @param adtr 审批人
     */
    public void setAdtr(Long adtr) {
        this.adtr = adtr;
    }

    /**
     * 获取审批拒绝原因
     *
     * @return ADT_RFS_RSN - 审批拒绝原因
     */
    public String getAdtRfsRsn() {
        return adtRfsRsn;
    }

    /**
     * 设置审批拒绝原因
     *
     * @param adtRfsRsn 审批拒绝原因
     */
    public void setAdtRfsRsn(String adtRfsRsn) {
        this.adtRfsRsn = adtRfsRsn == null ? null : adtRfsRsn.trim();
    }

    /**
     * 获取分发时间
     *
     * @return DSTR_TM - 分发时间
     */
    public Long getDstrTm() {
        return dstrTm;
    }

    /**
     * 设置分发时间
     *
     * @param dstrTm 分发时间
     */
    public void setDstrTm(Long dstrTm) {
        this.dstrTm = dstrTm;
    }

    /**
     * 获取分发人
     *
     * @return DSTR - 分发人
     */
    public Long getDstr() {
        return dstr;
    }

    /**
     * 设置分发人
     *
     * @param dstr 分发人
     */
    public void setDstr(Long dstr) {
        this.dstr = dstr;
    }

    /**
     * 获取分发拒绝原因
     *
     * @return DSTR_RFS_RSN - 分发拒绝原因
     */
    public String getDstrRfsRsn() {
        return dstrRfsRsn;
    }

    /**
     * 设置分发拒绝原因
     *
     * @param dstrRfsRsn 分发拒绝原因
     */
    public void setDstrRfsRsn(String dstrRfsRsn) {
        this.dstrRfsRsn = dstrRfsRsn == null ? null : dstrRfsRsn.trim();
    }

    /**
     * 获取撤销时间
     *
     * @return WTHD_TM - 撤销时间
     */
    public Long getWthdTm() {
        return wthdTm;
    }

    /**
     * 设置撤销时间
     *
     * @param wthdTm 撤销时间
     */
    public void setWthdTm(Long wthdTm) {
        this.wthdTm = wthdTm;
    }

    /**
     * 获取撤销人
     *
     * @return RVCT_PRSN - 撤销人
     */
    public Long getRvctPrsn() {
        return rvctPrsn;
    }

    /**
     * 设置撤销人
     *
     * @param rvctPrsn 撤销人
     */
    public void setRvctPrsn(Long rvctPrsn) {
        this.rvctPrsn = rvctPrsn;
    }

    /**
     * 获取撤销原因
     *
     * @return WTHD_RSN - 撤销原因
     */
    public String getWthdRsn() {
        return wthdRsn;
    }

    /**
     * 设置撤销原因
     *
     * @param wthdRsn 撤销原因
     */
    public void setWthdRsn(String wthdRsn) {
        this.wthdRsn = wthdRsn == null ? null : wthdRsn.trim();
    }

    /**
     * 获取执行人
     *
     * @return EXCT - 执行人
     */
    public Long getExct() {
        return exct;
    }

    /**
     * 设置执行人
     *
     * @param exct 执行人
     */
    public void setExct(Long exct) {
        this.exct = exct;
    }

    /**
     * 获取指令状态
     *
     * @return INST_STT - 指令状态
     */
    public String getInstStt() {
        return instStt;
    }

    /**
     * 设置指令状态
     *
     * @param instStt 指令状态
     */
    public void setInstStt(String instStt) {
        this.instStt = instStt == null ? null : instStt.trim();
    }

    /**
     * 获取审批状态
     *
     * @return ADT_STT - 审批状态
     */
    public String getAdtStt() {
        return adtStt;
    }

    /**
     * 设置审批状态
     *
     * @param adtStt 审批状态
     */
    public void setAdtStt(String adtStt) {
        this.adtStt = adtStt == null ? null : adtStt.trim();
    }

    /**
     * 获取分发状态
     *
     * @return DSTR_STT - 分发状态
     */
    public String getDstrStt() {
        return dstrStt;
    }

    /**
     * 设置分发状态
     *
     * @param dstrStt 分发状态
     */
    public void setDstrStt(String dstrStt) {
        this.dstrStt = dstrStt == null ? null : dstrStt.trim();
    }

    /**
     * 获取撤销分发状态
     *
     * @return WTHD_DSTR_STT - 撤销分发状态
     */
    public String getWthdDstrStt() {
        return wthdDstrStt;
    }

    /**
     * 设置撤销分发状态
     *
     * @param wthdDstrStt 撤销分发状态
     */
    public void setWthdDstrStt(String wthdDstrStt) {
        this.wthdDstrStt = wthdDstrStt == null ? null : wthdDstrStt.trim();
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
     * 获取时间戳
     *
     * @return TMST - 时间戳
     */
    public Date getTmst() {
        return tmst;
    }

    /**
     * 设置时间戳
     *
     * @param tmst 时间戳
     */
    public void setTmst(Date tmst) {
        this.tmst = tmst;
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
     * 获取分发日期
     *
     * @return DSTR_DT - 分发日期
     */
    public Long getDstrDt() {
        return dstrDt;
    }

    /**
     * 设置分发日期
     *
     * @param dstrDt 分发日期
     */
    public void setDstrDt(Long dstrDt) {
        this.dstrDt = dstrDt;
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