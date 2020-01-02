package com.iquantex.tspweb.model;

import javax.persistence.*;
import org.apache.ibatis.type.JdbcType;
import tk.mybatis.mapper.annotation.ColumnType;

@Table(name = "RULE_MUSIC")
public class RuleMusic {
    /**
     * 期货类型
     */
    @Column(name = "FUTURESTYPE")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String futurestype;

    /**
     * 规则语音
     */
    @Column(name = "MUSIC")
    @ColumnType(jdbcType = JdbcType.CLOB)
    private String music;

    public static final String TABLE = "RULE_MUSIC";

    public static final String f_futurestype = "futurestype";

    public static final String f_music = "music";

    /**
     * 获取期货类型
     *
     * @return FUTURESTYPE - 期货类型
     */
    public String getFuturestype() {
        return futurestype;
    }

    /**
     * 设置期货类型
     *
     * @param futurestype 期货类型
     */
    public void setFuturestype(String futurestype) {
        this.futurestype = futurestype == null ? null : futurestype.trim();
    }

    /**
     * 获取规则语音
     *
     * @return MUSIC - 规则语音
     */
    public String getMusic() {
        return music;
    }

    /**
     * 设置规则语音
     *
     * @param music 规则语音
     */
    public void setMusic(String music) {
        this.music = music == null ? null : music.trim();
    }
}