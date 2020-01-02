package com.iquantex.tspweb.model;

import javax.persistence.*;
import org.apache.ibatis.type.JdbcType;
import tk.mybatis.mapper.annotation.ColumnType;

@Table(name = "TSP_USER")
public class TspUser {
    @Id
    @Column(name = "ID")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private Long id;

    @Column(name = "USER_ID")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private String userId;

    @Column(name = "ROLE_ID")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String roleId;

    @Column(name = "USER_NAME")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String userName;

    @Column(name = "PASSWORD")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String password;

    public static final String TABLE = "TSP_USER";

    public static final String f_id = "id";

    public static final String f_userId = "userId";

    public static final String f_roleId = "roleId";

    public static final String f_userName = "userName";

    public static final String f_password = "password";

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
     * @return USE_ID
     */
    public String getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * @return ROLE_ID
     */
    public String getRoleId() {
        return roleId;
    }

    /**
     * @param roleId
     */
    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }

    /**
     * @return USER_NAME
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * @return PASSWORD
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }
}