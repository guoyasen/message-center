package com.iquantex.tspweb.service;

import com.iquantex.tspweb.dao.java.TspUserMapper;
import com.iquantex.tspweb.model.TspUser;
import com.iquantex.tspweb.model.TspUserTree;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * 用户服务
 *
 * @author shenzhengjie
 * @date 2019/2/19 11:46
 */
@Slf4j
@Service
public class UserService {

    @Autowired
    private TspUserMapper tspUserDao;

    /**
     * 登录 使用userName登录
     *
     * @param userName
     * @param password
     * @return
     */
    public TspUser checkLogin(String userName, String password) {
        List<TspUser> tspUsers = tspUserDao.selectBy(TspUser.f_userName, userName, TspUser.f_password, password);
        if (null == tspUsers || tspUsers.isEmpty()) {
            return null;
        } else {
            return tspUsers.get(0);
        }
    }

    /**
     * 校验useId和password
     *
     * @param userId
     * @param password
     * @return
     */
    public TspUser checkUserId(Long userId, String password) {
        List<TspUser> tspUsers = tspUserDao.selectBy(TspUser.f_userId, userId, TspUser.f_password, password);
        if (null == tspUsers || tspUsers.isEmpty()) {
            return null;
        } else {
            return tspUsers.get(0);
        }
    }

    /**
     * 更新密码
     *
     * @param user
     * @param password
     * @return
     */
    public boolean changePassword(TspUser user, String password) {
        user.setPassword(password);
        int num = tspUserDao.updateByPrimaryKey(user);
        return num > 0;
    }

    /**
     * 用户列表查询
     *
     * @param userId
     * @param roleId
     * @param userName
     * @return
     */
    public List<TspUser> queryUser(String userId, String roleId, String userName) {
        Example example = new Example(TspUser.class);
        Example.Criteria criteria = example.createCriteria();
        if (userId != null && !userId.isEmpty()) {
            criteria.andEqualTo(TspUser.f_userId, userId);
        }
        if (roleId != null && !roleId.isEmpty()) {
            criteria.andEqualTo(TspUser.f_roleId, roleId);
        }
        if (userName != null && !userName.isEmpty()) {
            criteria.andEqualTo(TspUser.f_userName, userName);
        }
        return tspUserDao.selectByExample(example);
    }

    /**
     * 删除用户
     *
     * @param userId
     * @return
     */
    public boolean deleteUser(String userId) {
        if (userId == null || userId.isEmpty()) {
            return true;
        }
        Example example = new Example(TspUser.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo(TspUser.f_userId, userId);
        int i = tspUserDao.deleteByExample(example);
        return i > 0;
    }

    /**
     * 更新用户
     *
     * @param tspUser
     * @return
     */
    public int updateUser(TspUser tspUser) {
        Example example = new Example(TspUser.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo(TspUser.f_userId, tspUser.getUserId());
        criteria.andNotEqualTo(TspUser.f_id, tspUser.getId());
        List<TspUser> tspUsers = tspUserDao.selectByExample(example);
        if (tspUsers.size() > 0) {
            log.error("userId:<{}> 已存在", tspUser.getUserId());
            return 0;
        }
        int i = tspUserDao.updateTspUser(tspUser);
        return i;
    }

    /**
     * 增加用户
     *
     * @param tspUser
     * @return
     */
    public int addUser(TspUser tspUser) {
        //tspUser.setId(tspUserDao.getNextID());
        int insert = tspUserDao.insertTspUser(tspUser);
        return insert;
    }


    /**
     * 查询菜单
     */
    public TspUser selectTspUserByPrimary(Long id) {
        return tspUserDao.selectByPrimaryKey(id);
    }

    /**按用户ID查询（根据用户所属的部门返回用户,不传则返回所有用户）**/
    public List<TspUserTree> queryUserTree(String userId){
        return tspUserDao.selectUserByUserId(userId);
    }

    public List<TspUser> getAll(){
        return tspUserDao.selectAll();
    }
}
