package com.iquantex.tspweb.service;

import com.iquantex.tspweb.dao.java.TspRoleMapper;
import com.iquantex.tspweb.model.TspRole;
import com.iquantex.tspweb.model.TspRoleDetail;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 角色服务
 *
 * @author shenzhengjie
 * @date 2019/4/16 14:28
 */
@Slf4j
@Service
public class RoleService {

    @Autowired
    private TspRoleMapper tspRoleDao;

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @Transactional(rollbackFor = Exception.class)
    public int add(TspRole tspRole, String userId) {
        //tspRole.setRoleId(tspRoleDao.getNextID());
        int insert = tspRoleDao.insertTspRole(tspRole);
        tspRoleDao.deleteRoleDepartmentByUserId(userId, tspRole.getRoleId());
        tspRoleDao.insertRoleDepartment(userId, tspRole.getRoleId());
        return insert;
    }

    public boolean delete(long roleId) {
        tspRoleDao.deleteByPrimaryKey(roleId);
        return true;
    }

    public int update(TspRole tspRole) {
        int i = tspRoleDao.updateTspRole(tspRole);
        return i;
    }

    public TspRole selectTspUserByPrimary(Long id) {
        return tspRoleDao.selectByPrimaryKey(id);
    }

    public List<TspRole> query(Long roleId, String roleName, String authorization) {
        Example example = new Example(TspRole.class);
        Example.Criteria criteria = example.createCriteria();
        if (roleId != null) {
            criteria.andEqualTo(TspRole.f_roleId, roleId);
        }
        if (roleName != null && !roleName.isEmpty()) {
            criteria.andEqualTo(TspRole.f_roleName, roleName);
        }
        if (authorization != null && !authorization.isEmpty()) {
            criteria.andLike(TspRole.f_authorization, "%" + authorization + "%");
        }
        return tspRoleDao.selectByExample(example);
    }


    //根据用户id查找该用户所属部门下的所有角色，如果没有用户id，则返回所有角色
    public List<TspRole> queryRole(String userId) {
        return tspRoleDao.selectRoleByUserId(userId);
    }

    //根据角色id查找该角色的所有菜单，所有用户
    public TspRoleDetail queryRoleDetail(Long roleId) {
        return tspRoleDao.selectRoleDetail(roleId);
    }


    //修改角色名称，角色权限，角色的用户
    //修改完成后，如果对用户的权限有影响，实时推送给前端
    //该角色当前的人，新增的人，删除的人
    @Transactional(rollbackFor = Exception.class)
    public Boolean updateRoleDetail(TspRoleDetail tspRoleDetail) {

        TspRoleDetail roleDetail = tspRoleDao.selectRoleDetail(tspRoleDetail.getRoleId());
        List<String> oldUserList = roleDetail.getUserList();

        //先修改角色名称，角色权限
        if (tspRoleDetail.getRoleName() != null) {
            TspRole tspRole = new TspRole();
            tspRole.setRoleId(tspRoleDetail.getRoleId());
            tspRole.setRoleName(tspRoleDetail.getRoleName());
            tspRoleDao.updateTspRole(tspRole);
        }
        if (tspRoleDetail.getMenuList() != null) {
            TspRole tspRole = new TspRole();
            tspRole.setRoleId(tspRoleDetail.getRoleId());
            tspRole.setAuthorization(StringUtils.join(tspRoleDetail.getMenuList().toArray(), ","));
            tspRoleDao.updateTspRole(tspRole);
        }
        if (tspRoleDetail.getUserList() != null) {
            //删除该角色的所有用户
            tspRoleDao.deleteUserRole(tspRoleDetail.getRoleId());
            //新增该角色的用户
            if (tspRoleDetail.getUserList().get(0) != "") {
                List<String> newUserList = tspRoleDetail.getUserList();
                tspRoleDao.insertUserRole(tspRoleDetail.getRoleId(), tspRoleDetail.getUserList());
                if(oldUserList==null){
                    oldUserList=new ArrayList<>();
                }
                for (String user : newUserList) {
                    if (!oldUserList.contains(user)) {
                        oldUserList.add(user);
                    }
                }
            }
        }
        if (oldUserList != null)
            for (String user : oldUserList) {
                //实时推送，修改后的用户权限
                String msg = "{\"authorizationchange\":true}";
                log.info("推送用户权限变更websocket，用户id：<{}>", user);
                messagingTemplate.convertAndSendToUser(user, "/queue/authorization", msg);
            }
        return true;
    }

    /**
     * 查询用户菜单
     *
     * @param userId
     * @return
     */
    public String selectUserMenuItems(String userId) {
        return tspRoleDao.selectUserMenuItems(userId);
    }

}
