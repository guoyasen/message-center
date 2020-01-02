package com.iquantex.tspweb.service;

import com.iquantex.tspweb.common.AuthData;
import com.iquantex.tspweb.dao.java.*;
import com.iquantex.tspweb.model.RuleFuturePriceDiff;
import com.iquantex.tspweb.model.TspMenuitem;
import com.iquantex.tspweb.model.TspRole;
import com.iquantex.tspweb.param.DictoryVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AuthDataService {
    private static final Logger LOG = LoggerFactory.getLogger(AuthDataService.class);

    // 指令监控菜单id
    private static final String mid = "48";

    @Autowired
    private TspMenuitemMapper tspMenuitemDao;

    @Autowired
    private TspRoleMapper tspRoleDao;

    @Autowired
    private TspUserMapper tspUserDao;

    @Autowired
    private InstInfoMapper instInfoDao;

    @Autowired
    private RuleFuturePriceDiffMapper ruleFuturePriceDiffDao;


    /**
     * 更新静态数据
     */
    @Scheduled(cron = "0 0/5 * * * ?")
    public void updateAuthData() {
        LOG.info("update AuthData.");
        synchronized (AuthData.class) {
            updateRuleToMenuitemMap();
            updateMenuitemToUserMap();
            updateUserIds();
        }
    }


    /**
     * 更新规则和用户id映射map
     */
    public void updateRuleIdToUserMap() {
        AuthData.ruleIdToUserMap.clear();
        List<Map<String, String>> result = tspRoleDao.selectRuleToUsersMap();
        result.forEach((map) -> {
            AuthData.ruleIdToUserMap.put(map.get("RULE"), Arrays.asList(map.get("USERS").split(",")));
        });
    }

    /**
     * 拥有指令监控菜单权限的用户id列表
     */
    public void updateUserIds() {
        AuthData.userIds = tspUserDao.selectUidByMenuitemId(mid);
    }

    /**
     * 更新角色数据
     */
    public void updateRoleList() {
        AuthData.tspRoles = tspRoleDao.selectAll();
    }

    /**
     * 更新ruleToMenuitemMap
     */
    public void updateRuleToMenuitemMap() {
        // 1.清空ruleToMenuitemMap
        AuthData.ruleToMenuitemMap.clear();

        // 2.更新ruleToMenuitemMap
        List<TspMenuitem> tspMenuitems = tspMenuitemDao.selectMenuitem();
        if (tspMenuitems != null) {
            tspMenuitems.forEach((TspMenuitem menu) -> {
                if (AuthData.ruleToMenuitemMap.containsKey(menu.getRuleId())) {
                    List<Long> menuIds = AuthData.ruleToMenuitemMap.get(menu.getRuleId());
                    if (!menuIds.contains(menu.getId())) {
                        menuIds.add(menu.getId());
                    }
                } else {
                    List<Long> menuList = new ArrayList<>();
                    menuList.add(menu.getId());
                    AuthData.ruleToMenuitemMap.put(menu.getRuleId(), menuList);
                }
            });
        }
    }

    /**
     * 更新menuitemToUserMap
     */
    public void updateMenuitemToUserMap() {
        // 1.清空 menuitemToUserMap
        AuthData.menuitemToUserMap.clear();
        // 2. 更新角色数据
        updateRoleList();
        // 3.根据menuId获取role
//        Map<Long, List<Integer>> menuToroleMap = new HashMap<>();
//        List<TspMenuitem> tspMenuitems = tspMenuitemDao.selectMenuitem();
//        if (tspMenuitems != null){
//            tspMenuitems.forEach(tspMenu -> {
//                List<Integer> roleIds = new ArrayList<>();
//                for (TspRole tspRole : AuthData.tspRoles) {
//                    String[] split = tspRole.getAuthorization().split(",");
//                    List<String> auth = Arrays.asList(split);
//                    if (auth.contains(String.valueOf(tspMenu.getId()))){
//                        roleIds.add(Math.toIntExact(tspRole.getRoleId()));
//                    }
//                }
//                menuToroleMap.put(tspMenu.getId(), roleIds);
//            });
//        }
//
//        // 4.单独处理跑马灯（mId=8）和ETF基金实时指标监控（mId=16）
//        List<Long> otherMid = new ArrayList<>();
//        otherMid.add(8L);
//        otherMid.add(16L);
//        otherMid.forEach(mid -> {
//            List<Integer> roleIds = new ArrayList<>();
//            for (TspRole tspRole : AuthData.tspRoles) {
//                String[] split = tspRole.getAuthorization().split(",");
//                List<String> auth = Arrays.asList(split);
//                if (auth.contains(String.valueOf(mid))){
//                    roleIds.add(Math.toIntExact(tspRole.getRoleId()));
//                }
//            }
//            menuToroleMap.put(mid, roleIds);
//        });
//
//        // 5.获取相应role的用户
//        Set<Long> mIds = menuToroleMap.keySet();
//        for (Long mId : mIds) {
//            List<Integer> roles = menuToroleMap.get(mId);
//            List<String> userIds = new ArrayList<>();
//            if (roles != null){
//                for (Integer roleId : roles) {
//                    List<String> userList = tspUserDao.selectUidByRoleId(Integer.toString(roleId));
//                    userIds.addAll(userList);
//                }
//                AuthData.menuitemToUserMap.put(mId, userIds);
//            }
//        }
        List<Map<String, String>> menuToUser = tspMenuitemDao.selectMenuToUser();

        for (Map<String, String> val : menuToUser) {
            Object menuid = val.get("MENUID");
            Object userid = val.get("USERID");
            AuthData.menuitemToUserMap.put(Long.valueOf(String.valueOf(menuid)), Arrays.asList(String.valueOf(userid).split(",")));
        }

    }

    /**
     * 更新o32内码 映射 市场名称的静态数据
     */
    public void updateO32SecuCodeToMarketName() {
        AuthData.o32SecuCodeToMarketName.clear();
        List<DictoryVO> o32SecuCodeDict = instInfoDao.getO32SecuCodeDict(null, null);
        if (o32SecuCodeDict != null) {
            for (DictoryVO dictoryVO : o32SecuCodeDict) {
                AuthData.o32SecuCodeToMarketName.put(dictoryVO.getId(), dictoryVO.getName());
            }
        }
    }

    /**
     * 清除清除指令推送websocket记录
     */
    public void clearWebsocketPushInstRecord() {
        AuthData.websocketPushInstRecord.clear();
    }


    /**
     * 更新期货价差规则静态数据
     */
    public void updateRuleFuturePriceDiffMap() {
        List<RuleFuturePriceDiff> priceDiffs = ruleFuturePriceDiffDao.selectAll();
        AuthData.ruleFuturePriceDiffMap.clear();
        for (RuleFuturePriceDiff priceDiff : priceDiffs) {
            String key = priceDiff.getFutureaCode() + "_" + priceDiff.getFuturebCode();
            if (AuthData.ruleFuturePriceDiffMap.containsKey(key)) {
                AuthData.ruleFuturePriceDiffMap.get(key).add(priceDiff.getUserId());
            } else {
                List<String> value = new ArrayList<>();
                value.add(priceDiff.getUserId());
                AuthData.ruleFuturePriceDiffMap.put(key, value);
            }
        }
    }
}
