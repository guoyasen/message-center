package com.iquantex.tspweb.model;

import javax.persistence.*;
import org.apache.ibatis.type.JdbcType;
import tk.mybatis.mapper.annotation.ColumnType;

@Table(name = "TSP_ROLE")
public class TspRole {
    /**
     * 角色id
     */
    @Id
    @Column(name = "ROLE_ID")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Long roleId;

    /**
     * 角色名
     */
    @Column(name = "ROLE_NAME")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String roleName;

    /**
     * 菜单列表
     */
    @Column(name = "AUTHORIZATION")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String authorization;

    @Column(name = "BLACKLIST")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String blacklist;

    /**
     * 规则列表
     */
    @Column(name = "RULELIST")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String rulelist;

    public static final String TABLE = "TSP_ROLE";

    public static final String f_roleId = "roleId";

    public static final String f_roleName = "roleName";

    public static final String f_authorization = "authorization";

    public static final String f_blacklist = "blacklist";

    public static final String f_rulelist = "rulelist";

    /**
     * 获取角色id
     *
     * @return ROLE_ID - 角色id
     */
    public Long getRoleId() {
        return roleId;
    }

    /**
     * 设置角色id
     *
     * @param roleId 角色id
     */
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    /**
     * 获取角色名
     *
     * @return ROLE_NAME - 角色名
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * 设置角色名
     *
     * @param roleName 角色名
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    /**
     * 获取菜单列表
     *
     * @return AUTHORIZATION - 菜单列表
     */
    public String getAuthorization() {
        return authorization;
    }

    /**
     * 设置菜单列表
     *
     * @param authorization 菜单列表
     */
    public void setAuthorization(String authorization) {
        this.authorization = authorization == null ? null : authorization.trim();
    }

    /**
     * @return BLACKLIST
     */
    public String getBlacklist() {
        return blacklist;
    }

    /**
     * @param blacklist
     */
    public void setBlacklist(String blacklist) {
        this.blacklist = blacklist == null ? null : blacklist.trim();
    }

    /**
     * 获取规则列表
     *
     * @return RULELIST - 规则列表
     */
    public String getRulelist() {
        return rulelist;
    }

    /**
     * 设置规则列表
     *
     * @param rulelist 规则列表
     */
    public void setRulelist(String rulelist) {
        this.rulelist = rulelist == null ? null : rulelist.trim();
    }
}