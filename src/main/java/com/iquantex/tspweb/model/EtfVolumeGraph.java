package com.iquantex.tspweb.model;

import java.util.Date;
import javax.persistence.*;
import org.apache.ibatis.type.JdbcType;
import tk.mybatis.mapper.annotation.ColumnType;

@Table(name = "ETF_VOLUME_GRAPH")
public class EtfVolumeGraph {
    @Column(name = "FUNDCODE")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String fundcode;

    @Column(name = "SYSTEM_TIME")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String systemTime;

    @Column(name = "ETFVOLUME")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String etfvolume;

    @Column(name = "ETF20AVGVOLUME")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String etf20avgvolume;

    @Column(name = "ETFVOLUME20DEVIATION")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String etfvolume20deviation;

    public static final String TABLE = "ETF_VOLUME_GRAPH";

    public static final String f_fundcode = "fundcode";

    public static final String f_systemTime = "systemTime";

    public static final String f_etfvolume = "etfvolume";

    public static final String f_etf20avgvolume = "etf20avgvolume";

    public static final String f_etfvolume20deviation = "etfvolume20deviation";

    /**
     * @return FUNDCODE
     */
    public String getFundcode() {
        return fundcode;
    }

    /**
     * @param fundcode
     */
    public void setFundcode(String fundcode) {
        this.fundcode = fundcode == null ? null : fundcode.trim();
    }

    /**
     * @return SYSTEM_TIME
     */
    public String getSystemTime() {
        return systemTime;
    }

    /**
     * @param systemTime
     */
    public void setSystemTime(String systemTime) {
        this.systemTime = systemTime;
    }

    /**
     * @return ETFVOLUME
     */
    public String getEtfvolume() {
        return etfvolume;
    }

    /**
     * @param etfvolume
     */
    public void setEtfvolume(String etfvolume) {
        this.etfvolume = etfvolume == null ? null : etfvolume.trim();
    }

    /**
     * @return ETF20AVGVOLUME
     */
    public String getEtf20avgvolume() {
        return etf20avgvolume;
    }

    /**
     * @param etf20avgvolume
     */
    public void setEtf20avgvolume(String etf20avgvolume) {
        this.etf20avgvolume = etf20avgvolume == null ? null : etf20avgvolume.trim();
    }

    /**
     * @return ETFVOLUME20DEVIATION
     */
    public String getEtfvolume20deviation() {
        return etfvolume20deviation;
    }

    /**
     * @param etfvolume20deviation
     */
    public void setEtfvolume20deviation(String etfvolume20deviation) {
        this.etfvolume20deviation = etfvolume20deviation == null ? null : etfvolume20deviation.trim();
    }
}