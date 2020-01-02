package com.iquantex.tspweb.model;

import javax.persistence.*;
import org.apache.ibatis.type.JdbcType;
import tk.mybatis.mapper.annotation.ColumnType;

@Table(name = "RULE")
public class Rule {
    @Id
    @Column(name = "ID")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String id;

    @Column(name = "NAME")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String name;

    @Column(name = "TYPE_ID")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String typeId;

    /**
     * 提示描述
     */
    @Column(name = "CUE_FORMAT")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String cueFormat;

    /**
     * 规则描述
     */
    @Column(name = "INFO")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String info;

    /**
     * 开始时间<>hh:mm:ss
     */
    @Column(name = "START_TIME")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String startTime;

    /**
     * 结束时间<>hh:mm:ss
     */
    @Column(name = "END_TIME")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String endTime;

    @Column(name = "TYPE_NAME")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String typeName;

    /**
     * 语速
     */
    @Column(name = "SPEED")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Double speed;

    /**
     * 音量
     */
    @Column(name = "VOLUME")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Double volume;

    /**
     * 是否全量推送（无论规则结果是否告警1：全量推送 0：只推送告警）
     */
    @Column(name = "ALL_PUSH")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Integer allPush;

    public static final String TABLE = "RULE";

    public static final String f_id = "id";

    public static final String f_name = "name";

    public static final String f_typeId = "typeId";

    public static final String f_cueFormat = "cueFormat";

    public static final String f_info = "info";

    public static final String f_startTime = "startTime";

    public static final String f_endTime = "endTime";

    public static final String f_typeName = "typeName";

    public static final String f_speed = "speed";

    public static final String f_volume = "volume";

    public static final String f_allPush = "allPush";

    /**
     * @return ID
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * @return NAME
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * @return TYPE_ID
     */
    public String getTypeId() {
        return typeId;
    }

    /**
     * @param typeId
     */
    public void setTypeId(String typeId) {
        this.typeId = typeId == null ? null : typeId.trim();
    }

    /**
     * 获取提示描述
     *
     * @return CUE_FORMAT - 提示描述
     */
    public String getCueFormat() {
        return cueFormat;
    }

    /**
     * 设置提示描述
     *
     * @param cueFormat 提示描述
     */
    public void setCueFormat(String cueFormat) {
        this.cueFormat = cueFormat == null ? null : cueFormat.trim();
    }

    /**
     * 获取规则描述
     *
     * @return INFO - 规则描述
     */
    public String getInfo() {
        return info;
    }

    /**
     * 设置规则描述
     *
     * @param info 规则描述
     */
    public void setInfo(String info) {
        this.info = info == null ? null : info.trim();
    }

    /**
     * 获取开始时间<>hh:mm:ss
     *
     * @return START_TIME - 开始时间<>hh:mm:ss
     */
    public String getStartTime() {
        return startTime;
    }

    /**
     * 设置开始时间<>hh:mm:ss
     *
     * @param startTime 开始时间<>hh:mm:ss
     */
    public void setStartTime(String startTime) {
        this.startTime = startTime == null ? null : startTime.trim();
    }

    /**
     * 获取结束时间<>hh:mm:ss
     *
     * @return END_TIME - 结束时间<>hh:mm:ss
     */
    public String getEndTime() {
        return endTime;
    }

    /**
     * 设置结束时间<>hh:mm:ss
     *
     * @param endTime 结束时间<>hh:mm:ss
     */
    public void setEndTime(String endTime) {
        this.endTime = endTime == null ? null : endTime.trim();
    }

    /**
     * @return TYPE_NAME
     */
    public String getTypeName() {
        return typeName;
    }

    /**
     * @param typeName
     */
    public void setTypeName(String typeName) {
        this.typeName = typeName == null ? null : typeName.trim();
    }

    /**
     * 获取语速
     *
     * @return SPEED - 语速
     */
    public Double getSpeed() {
        return speed;
    }

    /**
     * 设置语速
     *
     * @param speed 语速
     */
    public void setSpeed(Double speed) {
        this.speed = speed;
    }

    /**
     * 获取音量
     *
     * @return VOLUME - 音量
     */
    public Double getVolume() {
        return volume;
    }

    /**
     * 设置音量
     *
     * @param volume 音量
     */
    public void setVolume(Double volume) {
        this.volume = volume;
    }

    /**
     * 获取是否全量推送（无论规则结果是否告警1：全量推送 0：只推送告警）
     *
     * @return ALL_PUSH - 是否全量推送（无论规则结果是否告警1：全量推送 0：只推送告警）
     */
    public Integer getAllPush() {
        return allPush;
    }

    /**
     * 设置是否全量推送（无论规则结果是否告警1：全量推送 0：只推送告警）
     *
     * @param allPush 是否全量推送（无论规则结果是否告警1：全量推送 0：只推送告警）
     */
    public void setAllPush(Integer allPush) {
        this.allPush = allPush;
    }
}