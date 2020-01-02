package com.iquantex.tspweb.dao.java;

import com.iquantex.tspweb.model.TspRole;
import com.iquantex.tspweb.model.TspRoleDetail;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.common.Mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface TspRoleMapper extends Mapper<TspRole> {

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Select("SELECT TSP_ROLE_ID_SEQ.nextval FROM dual")
    long getNextID();

    List<Map<String,String>> selectRuleToUsersMap();

    int updateTspRole(TspRole tspRole);

    int insertTspRole(TspRole tspRole);

    List<TspRole> selectRoleByUserId(@Param("user_id") String user_id);

    TspRoleDetail selectRoleDetail(@Param("roleId") Long roleId);

    int deleteUserRole(@Param("roleId") Long roleId);

    int insertUserRole(@Param("roleId") Long roleId,@Param("list") List<String> list);

    String selectUserMenuItems(@Param("userId") String userId);

    int deleteRoleDepartmentByUserId(@Param("userId") String userId ,@Param("roleId") Long roleId);

    int insertRoleDepartment(@Param("userId") String userId ,@Param("roleId") Long roleId);

}