package com.iquantex.tspweb.dao.java;

import com.iquantex.tspweb.model.TspUser;
import com.iquantex.tspweb.model.TspUserTree;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;


public interface TspUserMapper extends Mapper<TspUser> {


    TspUser queryTspUserInfo(@Param("user_id") String user_id);

    List<String> selectUidByRoleId(@Param("roleId") String roleId);

    List<String> selectUidByMenuitemId(@Param("mid") String mid);


    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Select("SELECT TSP_USER_ID_SEQ.nextval FROM dual")
    long getNextID();


    int updateTspUser(TspUser tspUser);

    int insertTspUser(TspUser tspUser);

    List<TspUserTree> selectUserByUserId(@Param("user_id") String user_id);
}