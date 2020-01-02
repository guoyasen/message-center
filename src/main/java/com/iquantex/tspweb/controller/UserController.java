package com.iquantex.tspweb.controller;


import com.alibaba.fastjson.JSONObject;
import com.iquantex.tspweb.model.TspUser;
import com.iquantex.tspweb.model.TspUserTree;
import com.iquantex.tspweb.param.UserDTO;
import com.iquantex.tspweb.param.UserVO;
import com.iquantex.tspweb.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用户服务
 *
 * @author shenzhengjie
 * @date 2019/2/19 14:30
 */
@Slf4j
@RestController
@RequestMapping("/api/v2/users")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public String login(@RequestBody UserDTO userDTO) {
        try {
            TspUser user = userService.checkLogin(userDTO.getUserName(), userDTO.getPassword());
            if (null != user) {
                UserVO vo = new UserVO();
                vo.setCode(user.getUserName());
                vo.setToken(user.getUserName());
                vo.setUserId(user.getUserId());
                //  vo.setRoleId(user.getRoleId());
                return successReturn(vo);
            }
            return failReturn("用户名或密码不正确");
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return failReturn(e.getMessage());
        }
    }

    @PostMapping("/changePassword")
    public String changePassword(@RequestBody UserDTO dto) {
        try {
//            if (!Objects.equals(dto.getPassword(), dto.getConfirmPassword())) {
//                return failReturn("两次密码不一致，请重新输入");
//            }
            TspUser user = userService.checkUserId(dto.getUserId(), dto.getOldPassword());
            if (null == user) {
                return failReturn("原密码错误，请输入正确的密码");
            }
            if (userService.changePassword(user, dto.getPassword())) {
                return successReturn();
            }
            return failReturn("");
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return failReturn(e.getMessage());
        }
    }

    @GetMapping("/query")
    public String queryUser(@RequestParam(required = false) String userId, @RequestParam(required = false) String roleId, @RequestParam(required = false) String userName) {
        try {
            List<TspUser> tspUsers = userService.queryUser(userId, roleId, userName);
            return successReturn(tspUsers);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return failReturn(e.getMessage());
        }
    }

    @DeleteMapping("/delete")
    public String deleteUser(@RequestParam String userId) {
        try {
            if (userService.deleteUser(userId)) {
                log.info("delete user success. userId:<{}>. ", userId);
                return successReturn();
            } else {
                log.warn("delete user fail. userId:<{}>. ", userId);
                return failReturn("failed to delete.");
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return failReturn(e.getMessage());
        }
    }

    @PutMapping("/update")
    public String updateUser(@RequestBody TspUser dto) {
        try {
            if (dto.getUserId() == null) {
                return failReturn("update user userId is null.");
            }
            if (userService.updateUser(dto)==1) {
                TspUser tspUser=userService.selectTspUserByPrimary(dto.getId());
                log.info("add user. userInfo: <{}>", JSONObject.toJSONString(tspUser));
                return successReturn(tspUser);
            }
            log.warn("Update failed. userInfo:<{}>", JSONObject.toJSONString(dto));
            return failReturn("Update failed.");
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return failReturn(e.getMessage());
        }
    }

    @PostMapping("/add")
    public String addUser(@RequestBody TspUser dto) {
        try {
            if (dto.getUserId() == null) {
                log.error("userId is null");
                return failReturn("userId is null");
            }
            List<TspUser> tspUsers = userService.queryUser(dto.getUserId(), null, null);
            if (tspUsers.size() > 0) {
                log.error(" userId 已存在. userId:<{}>", dto.getUserId());
                return failReturn("userId:<" + dto.getUserId() + "> 已存在.");
            }
            if (userService.addUser(dto)==1) {
                TspUser tspUser=userService.selectTspUserByPrimary(dto.getId());
                log.info("add user. userInfo: <{}>", JSONObject.toJSONString(tspUser));
                return successReturn(tspUser);
            }
            log.warn("Add user failed. userInfo:<{}>. ", JSONObject.toJSONString(dto));
            return failReturn("Add user failed.");
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return failReturn(e.getMessage());
        }
    }



    //按用户ID查询（根据用户所属的部门返回用户,不传则返回所有用户）
    @GetMapping("/query_user_tree")
    public String queryUserTree(@RequestParam(required = false) String userId){
        try {
            List<TspUserTree> tspUserTrees=userService.queryUserTree(userId);
            return successReturn(tspUserTrees);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return failReturn(e.getMessage());
        }
    }
}
