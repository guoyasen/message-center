package com.iquantex.tspweb.model;

import javax.persistence.*;
import org.apache.ibatis.type.JdbcType;
import tk.mybatis.mapper.annotation.ColumnType;

@Table(name = "TSP_MENUITEM")
public class TspMenuitem {
    @Id
    @Column(name = "ID")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Long id;

    /**
     * 父id
     */
    @Column(name = "PID")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Long pid;

    @Column(name = "NAME")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String name;

    @Column(name = "TITLE")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String title;

    @Column(name = "MENU_TYPE")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String menuType;

    @Column(name = "SORT")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String sort;

    @Column(name = "URL")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String url;

    @Column(name = "GROUPID")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String groupid;

    @Column(name = "GROUPNAME")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String groupname;

    @Column(name = "COMPONENT")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String component;

    @Column(name = "ICONTYPE")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String icontype;

    @Column(name = "COMP_DESC")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String compDesc;

    /**
     * 规则id
     */
    @Column(name = "RULE_ID")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String ruleId;

    @Column(name = "DESC_ID")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String descId;

    @Column(name = "DESC_PID")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String descPid;

    @Column(name = "TYPE_ID")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String typeId;

    /**
     * 去重字段名称
     */
    @Column(name = "IDEMPOTENTKEY")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String idempotentkey;

    /**
     * 是否有处理菜单
     */
    @Column(name = "HANDLE")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Integer handle;

    public static final String TABLE = "TSP_MENUITEM";

    public static final String f_id = "id";

    public static final String f_pid = "pid";

    public static final String f_name = "name";

    public static final String f_title = "title";

    public static final String f_menuType = "menuType";

    public static final String f_sort = "sort";

    public static final String f_url = "url";

    public static final String f_groupid = "groupid";

    public static final String f_groupname = "groupname";

    public static final String f_component = "component";

    public static final String f_icontype = "icontype";

    public static final String f_compDesc = "compDesc";

    public static final String f_ruleId = "ruleId";

    public static final String f_descId = "descId";

    public static final String f_descPid = "descPid";

    public static final String f_typeId = "typeId";

    public static final String f_idempotentkey = "idempotentkey";

    public static final String f_handle = "handle";

    /**
     * @return ID
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取父id
     *
     * @return PID - 父id
     */
    public Long getPid() {
        return pid;
    }

    /**
     * 设置父id
     *
     * @param pid 父id
     */
    public void setPid(Long pid) {
        this.pid = pid;
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
     * @return TITLE
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * @return MENU_TYPE
     */
    public String getMenuType() {
        return menuType;
    }

    /**
     * @param menuType
     */
    public void setMenuType(String menuType) {
        this.menuType = menuType == null ? null : menuType.trim();
    }

    /**
     * @return SORT
     */
    public String getSort() {
        return sort;
    }

    /**
     * @param sort
     */
    public void setSort(String sort) {
        this.sort = sort == null ? null : sort.trim();
    }

    /**
     * @return URL
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * @return GROUPID
     */
    public String getGroupid() {
        return groupid;
    }

    /**
     * @param groupid
     */
    public void setGroupid(String groupid) {
        this.groupid = groupid == null ? null : groupid.trim();
    }

    /**
     * @return GROUPNAME
     */
    public String getGroupname() {
        return groupname;
    }

    /**
     * @param groupname
     */
    public void setGroupname(String groupname) {
        this.groupname = groupname == null ? null : groupname.trim();
    }

    /**
     * @return COMPONENT
     */
    public String getComponent() {
        return component;
    }

    /**
     * @param component
     */
    public void setComponent(String component) {
        this.component = component == null ? null : component.trim();
    }

    /**
     * @return ICONTYPE
     */
    public String getIcontype() {
        return icontype;
    }

    /**
     * @param icontype
     */
    public void setIcontype(String icontype) {
        this.icontype = icontype == null ? null : icontype.trim();
    }

    /**
     * @return COMP_DESC
     */
    public String getCompDesc() {
        return compDesc;
    }

    /**
     * @param compDesc
     */
    public void setCompDesc(String compDesc) {
        this.compDesc = compDesc == null ? null : compDesc.trim();
    }

    /**
     * 获取规则id
     *
     * @return RULE_ID - 规则id
     */
    public String getRuleId() {
        return ruleId;
    }

    /**
     * 设置规则id
     *
     * @param ruleId 规则id
     */
    public void setRuleId(String ruleId) {
        this.ruleId = ruleId == null ? null : ruleId.trim();
    }

    /**
     * @return DESC_ID
     */
    public String getDescId() {
        return descId;
    }

    /**
     * @param descId
     */
    public void setDescId(String descId) {
        this.descId = descId == null ? null : descId.trim();
    }

    /**
     * @return DESC_PID
     */
    public String getDescPid() {
        return descPid;
    }

    /**
     * @param descPid
     */
    public void setDescPid(String descPid) {
        this.descPid = descPid == null ? null : descPid.trim();
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
     * 获取去重字段名称
     *
     * @return IDEMPOTENTKEY - 去重字段名称
     */
    public String getIdempotentkey() {
        return idempotentkey;
    }

    /**
     * 设置去重字段名称
     *
     * @param idempotentkey 去重字段名称
     */
    public void setIdempotentkey(String idempotentkey) {
        this.idempotentkey = idempotentkey == null ? null : idempotentkey.trim();
    }

    /**
     * 获取是否有处理菜单
     *
     * @return HANDLE - 是否有处理菜单
     */
    public Integer getHandle() {
        return handle;
    }

    /**
     * 设置是否有处理菜单
     *
     * @param handle 是否有处理菜单
     */
    public void setHandle(Integer handle) {
        this.handle = handle;
    }
}