package com.iquantex.tspweb.model;

import java.util.Date;
import javax.persistence.*;
import org.apache.ibatis.type.JdbcType;
import tk.mybatis.mapper.annotation.ColumnType;

@Table(name = "INST_GRAPH")
public class InstGraph {
    @Column(name = "INSTCODE")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String instcode;

    @Column(name = "SYSTEM_TIME")
    @ColumnType(jdbcType = JdbcType.TIMESTAMP)
    private Date systemTime;

    @Column(name = "EXECUTIONCODE")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String executioncode;

    @Column(name = "INSTPRC")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String instprc;

    @Column(name = "AVGPRICES")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String avgprices;

    @Column(name = "AVGAMOUNTS")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String avgamounts;

    @Column(name = "EFFECTIVEAVGPRC")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String effectiveavgprc;

    @Column(name = "INSTDEALAVGPRC")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String instdealavgprc;

    @Column(name = "DEALPRICELIST")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String dealpricelist;

    @Column(name = "DEALAMOUNTLIST")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String dealamountlist;

    @Column(name = "DEALTIMELIST")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String dealtimelist;

    @Column(name = "QUOTETIMES")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String quotetimes;

    @Column(name = "EFFECTIVEAVGAMT")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String effectiveavgamt;

    @Column(name = "INSTACCUMULATEDDEALAMT")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String instaccumulateddealamt;

    @Column(name = "COMPLETEDRATIO")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String completedratio;

    @Column(name = "PRICEDIFF")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String pricediff;

    public static final String TABLE = "INST_GRAPH";

    public static final String f_instcode = "instcode";

    public static final String f_systemTime = "systemTime";

    public static final String f_executioncode = "executioncode";

    public static final String f_instprc = "instprc";

    public static final String f_avgprices = "avgprices";

    public static final String f_avgamounts = "avgamounts";

    public static final String f_effectiveavgprc = "effectiveavgprc";

    public static final String f_instdealavgprc = "instdealavgprc";

    public static final String f_dealpricelist = "dealpricelist";

    public static final String f_dealamountlist = "dealamountlist";

    public static final String f_dealtimelist = "dealtimelist";

    public static final String f_quotetimes = "quotetimes";

    public static final String f_effectiveavgamt = "effectiveavgamt";

    public static final String f_instaccumulateddealamt = "instaccumulateddealamt";

    public static final String f_completedratio = "completedratio";

    public static final String f_pricediff = "pricediff";

    /**
     * @return INSTCODE
     */
    public String getInstcode() {
        return instcode;
    }

    /**
     * @param instcode
     */
    public void setInstcode(String instcode) {
        this.instcode = instcode == null ? null : instcode.trim();
    }

    /**
     * @return SYSTEM_TIME
     */
    public Date getSystemTime() {
        return systemTime;
    }

    /**
     * @param systemTime
     */
    public void setSystemTime(Date systemTime) {
        this.systemTime = systemTime;
    }

    /**
     * @return EXECUTIONCODE
     */
    public String getExecutioncode() {
        return executioncode;
    }

    /**
     * @param executioncode
     */
    public void setExecutioncode(String executioncode) {
        this.executioncode = executioncode == null ? null : executioncode.trim();
    }

    /**
     * @return INSTPRC
     */
    public String getInstprc() {
        return instprc;
    }

    /**
     * @param instprc
     */
    public void setInstprc(String instprc) {
        this.instprc = instprc == null ? null : instprc.trim();
    }

    /**
     * @return AVGPRICES
     */
    public String getAvgprices() {
        return avgprices;
    }

    /**
     * @param avgprices
     */
    public void setAvgprices(String avgprices) {
        this.avgprices = avgprices == null ? null : avgprices.trim();
    }

    /**
     * @return AVGAMOUNTS
     */
    public String getAvgamounts() {
        return avgamounts;
    }

    /**
     * @param avgamounts
     */
    public void setAvgamounts(String avgamounts) {
        this.avgamounts = avgamounts == null ? null : avgamounts.trim();
    }

    /**
     * @return EFFECTIVEAVGPRC
     */
    public String getEffectiveavgprc() {
        return effectiveavgprc;
    }

    /**
     * @param effectiveavgprc
     */
    public void setEffectiveavgprc(String effectiveavgprc) {
        this.effectiveavgprc = effectiveavgprc == null ? null : effectiveavgprc.trim();
    }

    /**
     * @return INSTDEALAVGPRC
     */
    public String getInstdealavgprc() {
        return instdealavgprc;
    }

    /**
     * @param instdealavgprc
     */
    public void setInstdealavgprc(String instdealavgprc) {
        this.instdealavgprc = instdealavgprc == null ? null : instdealavgprc.trim();
    }

    /**
     * @return DEALPRICELIST
     */
    public String getDealpricelist() {
        return dealpricelist;
    }

    /**
     * @param dealpricelist
     */
    public void setDealpricelist(String dealpricelist) {
        this.dealpricelist = dealpricelist == null ? null : dealpricelist.trim();
    }

    /**
     * @return DEALAMOUNTLIST
     */
    public String getDealamountlist() {
        return dealamountlist;
    }

    /**
     * @param dealamountlist
     */
    public void setDealamountlist(String dealamountlist) {
        this.dealamountlist = dealamountlist == null ? null : dealamountlist.trim();
    }

    /**
     * @return DEALTIMELIST
     */
    public String getDealtimelist() {
        return dealtimelist;
    }

    /**
     * @param dealtimelist
     */
    public void setDealtimelist(String dealtimelist) {
        this.dealtimelist = dealtimelist == null ? null : dealtimelist.trim();
    }

    /**
     * @return QUOTETIMES
     */
    public String getQuotetimes() {
        return quotetimes;
    }

    /**
     * @param quotetimes
     */
    public void setQuotetimes(String quotetimes) {
        this.quotetimes = quotetimes == null ? null : quotetimes.trim();
    }

    /**
     * @return EFFECTIVEAVGAMT
     */
    public String getEffectiveavgamt() {
        return effectiveavgamt;
    }

    /**
     * @param effectiveavgamt
     */
    public void setEffectiveavgamt(String effectiveavgamt) {
        this.effectiveavgamt = effectiveavgamt == null ? null : effectiveavgamt.trim();
    }

    /**
     * @return INSTACCUMULATEDDEALAMT
     */
    public String getInstaccumulateddealamt() {
        return instaccumulateddealamt;
    }

    /**
     * @param instaccumulateddealamt
     */
    public void setInstaccumulateddealamt(String instaccumulateddealamt) {
        this.instaccumulateddealamt = instaccumulateddealamt == null ? null : instaccumulateddealamt.trim();
    }

    /**
     * @return COMPLETEDRATIO
     */
    public String getCompletedratio() {
        return completedratio;
    }

    /**
     * @param completedratio
     */
    public void setCompletedratio(String completedratio) {
        this.completedratio = completedratio == null ? null : completedratio.trim();
    }

    /**
     * @return PRICEDIFF
     */
    public String getPricediff() {
        return pricediff;
    }

    /**
     * @param pricediff
     */
    public void setPricediff(String pricediff) {
        this.pricediff = pricediff == null ? null : pricediff.trim();
    }
}