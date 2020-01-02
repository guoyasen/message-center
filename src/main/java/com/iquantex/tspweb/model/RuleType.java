package com.iquantex.tspweb.model;

import javax.persistence.*;
import org.apache.ibatis.type.JdbcType;
import tk.mybatis.mapper.annotation.ColumnType;

@Table(name = "RULE_TYPE")
public class RuleType {
    @Id
    @Column(name = "ID")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String id;

    @Column(name = "NAME")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String name;

    public static final String TABLE = "RULE_TYPE";

    public static final String f_id = "id";

    public static final String f_name = "name";

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
}