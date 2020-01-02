package com.iquantex.tspweb.controller;

import com.alibaba.fastjson.JSONObject;
import com.iquantex.tspweb.model.TspRole;
import com.iquantex.tspweb.model.TspRoleDetail;
import com.iquantex.tspweb.service.RoleService;
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
@RequestMapping("/api/v2/role")
public class RoleController extends BaseController {

    @Autowired
    private RoleService roleService;

    @PostMapping("/add")
    public String add(@RequestBody TspRole tspRole,@RequestParam(required = false) String userId) {
        try {
            if (roleService.add(tspRole,userId) == 1) {
                tspRole = roleService.selectTspUserByPrimary(tspRole.getRoleId());
                return successReturn(tspRole);
            }
            log.warn("add role is failed. roleInfo:<{}>.", JSONObject.toJSONString(tspRole));
            return failReturn("add role is failed. roleInfo:<" + JSONObject.toJSONString(tspRole) + ">.");
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return failReturn(e.getMessage());
        }
    }

    @DeleteMapping("/delete")
    public String delete(@RequestParam Long roleId) {
        if (roleId == null) {
            return failReturn("roleId is null.");
        }
        try {
            if (roleService.delete(roleId)) {
                log.info("delete role. roleId:<{}>", roleId);
                return successReturn();
            }
            log.warn("delete role is failed. roleId:<{" + roleId + "}>. ");
            return failReturn("delete role is failed. roleId:<{" + roleId + "}>. ");
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return failReturn(e.getMessage());
        }
    }

    @PutMapping("/update")
    public String update(@RequestBody TspRole tspRole) {
        try {
            if (roleService.update(tspRole) == 1) {
                log.info("update role, roleInfo:<{}>. ", JSONObject.toJSONString(tspRole));
                tspRole = roleService.selectTspUserByPrimary(tspRole.getRoleId());
                return successReturn(tspRole);
            }
            return failReturn("update role is failed.");
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return failReturn(e.getMessage());
        }
    }

    @GetMapping("/query")
    public String query(@RequestParam(required = false) Long roleId, @RequestParam(required = false) String roleName, @RequestParam(required = false) String authorization) {
        try {
            List<TspRole> query = roleService.query(roleId, roleName, authorization);
            return successReturn(query);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return failReturn(e.getMessage());
        }
    }


    //根据用户id查找该用户所属部门下的所有角色，如果没有用户id，则返回所有角色
    @GetMapping("/query_role")
    public String queryRole(@RequestParam(required = false) String userId) {
        try {
            List<TspRole> tspRoles = roleService.queryRole(userId);
            return successReturn(tspRoles);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return failReturn(e.getMessage());
        }
    }


    //根据角色id查找该角色的所有菜单，所有用户
    @GetMapping("/query_role_detail")
    public String queryRoleDetail(@RequestParam(required = true) Long roleId) {
        try {
            TspRoleDetail tspRoles = roleService.queryRoleDetail(roleId);
            return successReturn(tspRoles);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return failReturn(e.getMessage());
        }
    }

    //角色权限修改接口，角色用户修改接口，修改角色名称
    @PutMapping("/update_role")
    public String updateRole(@RequestBody TspRoleDetail tspRoleDetail) {
        try {
            roleService.updateRoleDetail(tspRoleDetail);
            return successReturn();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return failReturn(e.getMessage());
        }
    }
}
