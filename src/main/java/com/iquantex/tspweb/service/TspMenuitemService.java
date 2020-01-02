package com.iquantex.tspweb.service;

import com.iquantex.tspweb.dao.java.TspMenuitemMapper;
import com.iquantex.tspweb.dao.java.TspRoleMapper;
import com.iquantex.tspweb.dao.java.TspUserMapper;
import com.iquantex.tspweb.model.TspMenuitem;
import com.iquantex.tspweb.model.TspRole;
import com.iquantex.tspweb.model.TspUser;
import com.iquantex.tspweb.param.TspMenuitemVO;
import com.iquantex.tspweb.param.TspWorkBenchVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;


@Service
public class TspMenuitemService {
    private static final Logger LOG = LoggerFactory.getLogger(TspMenuitemService.class);
    @Autowired
    private TspMenuitemMapper tspMenuitemDao;

    @Autowired
    private TspUserMapper tspUserDao;

    @Autowired
    private TspRoleMapper tspRoleDao;

    /**
     * 根据菜单类型和用户id来查询菜单
     *
     * @param mType
     * @param user_id
     * @return
     */
    public List<TspMenuitemVO> getMenuitemByUid(String mType, String user_id) {
        TspUser tspUser = tspUserDao.queryTspUserInfo(user_id);

        //TspRole tspRole = tspRoleDao.selectByPrimaryKey(tspUser.getRoleId());
        //String mIds = tspRole.getAuthorization();
        String mIds=tspRoleDao.selectUserMenuItems(tspUser.getUserId());
        // 为适应前端框架 映射关系为（key：id pId   value:desc_id desc_pId）
        String sql = "select desc_id as id, desc_pid as pId, name, url from tsp_menuitem where menu_type = '" + mType + "' and id in (" + mIds + ")  order by sort ";
        return tspMenuitemDao.selectMenuitemsById(sql);
    }

    /**
     * 查询菜单
     *
     * @param id
     * @return
     */
    public List<TspMenuitem> getMenuitemById(String id,String userId) {
        return tspMenuitemDao.selectMenuitemById(id,userId);
    }


    /**
     * 新增菜单
     *
     * @param tspMenuitem
     * @return
     */
    public int addMenuitem(TspMenuitem tspMenuitem) {
        int result= tspMenuitemDao.insertTspMentitem(tspMenuitem);
        return result;
    }

    /**
     * 修改菜单
     *
     * @param tspMenuitem
     * @return
     */
    public int modifyMenuitem(TspMenuitem tspMenuitem) {
        //return tspMenuitemDao.updateByPrimaryKey(tspMenuitem);
        int result = tspMenuitemDao.updateTspMenuitem(tspMenuitem);
        return result;
    }


    /**
     * 删除菜单
     *
     * @param id
     * @return
     */
    public int deleteMenuitem(String id) {
        return tspMenuitemDao.deleteByPrimaryKey(id);
    }


    /**
     * 查询菜单
     */
    public TspMenuitem selectMenuitemByPrimary(Long id) {
        return tspMenuitemDao.selectByPrimaryKey(id);
    }

    /**
     * 查询工作台的权限
     *
     * @param mType
     * @param user_id
     * @return
     */
    public List<TspWorkBenchVO> getWorkBenchByUid(String mType, String user_id) {
        try {
            TspUser tspUser = tspUserDao.queryTspUserInfo(user_id);

            //TspRole tspRole = tspRoleDao.selectByPrimaryKey(tspUser.getRoleId());
            //String mIds = tspRole.getAuthorization();
            String mIds=tspRoleDao.selectUserMenuItems(tspUser.getUserId());

            String sql = "select title as i,  name,groupId,groupName, component,iconType, comp_desc,rule_id as ruleID,type_id as typeId,idempotentKey,handle from tsp_menuitem where menu_type = '" + mType + "' and id in (" + mIds + ") order by sort ";
            return tspMenuitemDao.selectWorkBenchById(sql);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 判断用户是否拥有规则权限
     *
     * @param user_id
     * @return
     */
    public List<String> judgeRuleRole(String user_id) {
        try {
            TspUser tspUser = tspUserDao.queryTspUserInfo(user_id);
            // 根据用户获取权限
            String roleID = tspUser.getRoleId();
            //TspRole tspRole = tspRoleDao.selectByPrimaryKey(roleID);
            //List<String> authorizations = Arrays.asList(tspRole.getAuthorization().split(","));

            String mIds=tspRoleDao.selectUserMenuItems(tspUser.getUserId());
            List<String> authorizations=Arrays.asList(mIds.split(","));
            Example example = new Example(TspMenuitem.class);
            example.createCriteria().andIn(TspMenuitem.f_id, authorizations);
            List<TspMenuitem> menuitems = tspMenuitemDao.selectByExample(example);
            List<String> ids = new ArrayList<>();
            for (TspMenuitem menuitem : menuitems) {
                if (null != menuitem.getRuleId()) {
                    ids.add(menuitem.getRuleId());
                }
            }
            return ids;
        } catch (Exception e) {
            return null;
        }
    }
}
