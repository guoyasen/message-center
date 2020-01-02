package com.iquantex.tspweb.common;

import com.iquantex.tspweb.model.RuleFuturePriceDiff;
import com.iquantex.tspweb.model.TspRole;
import com.iquantex.tspweb.table.EtfConstituentStockDetail;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Data
public class AuthData {
    /**
     * 跑马灯的mId
     */
    public static Long LightVOMid = 8L;


    /**
     * ETF基金实时指标监控的mId
     */
    public static Long EtfFundRealIndexMid = 16L;


    /**
     * 角色数据
     */
    public static List<TspRole> tspRoles;


    /**
     * 拥有指令监控菜单权限的用户id列表
     */
    public static List<String> userIds;

    /**
     * 规则id 映射 menuitemId
     * key:    规则id
     * value: menuitemId
     */
    public static Map<String, List<Long>> ruleToMenuitemMap = new HashMap<>();

    /**
     * menuitemId 映射 用户id
     * key:   menuitemId
     * value: 用户id
     */
    public static Map<Long, List<String>> menuitemToUserMap = new HashMap<>();

    /**
     * o32内码 映射 市场名称
     * key: o32内码
     * value 市场名称
     */
    public static Map<String, String> o32SecuCodeToMarketName = new HashMap<>();


    /**
     * 指令推送websocket记录
     */
    public static  Set<String> websocketPushInstRecord=new HashSet<>();


    /**
     * 获取指定指令序号是否推送websocket
     */
    public static synchronized Boolean isInstinfoPushed(String instCode){
        return AuthData.websocketPushInstRecord.contains(instCode);
    }


    /**
     *规则id映射用户id
     * key ：规则id
     * values：用户id
     */
    public static Map<String,List<String>> ruleIdToUserMap=new HashMap<>();


    /**
     * 获取该rule_id 需要推送的用户列表
     * @param ruleId
     * @return
     */
    public static synchronized List<String> getUsersByRuleId(String ruleId){
        List<String> users = new ArrayList<>();
        List<Long> menuIds = AuthData.ruleToMenuitemMap.get(ruleId);
        if (menuIds != null){
            menuIds.forEach(menuId ->{
                users.addAll(AuthData.menuitemToUserMap.get(menuId));
            });
            Set<String> userList = new HashSet<>(users);
            return new ArrayList<>(userList);
        }
        return null;
    }

    /**
     * 根据mId来获取要推送的用户列表
     * @param mId
     * @return
     */
    public static synchronized List<String> getUsersByMenuitemId(Long mId){
        return AuthData.menuitemToUserMap.get(mId);
    }


    /**
     * 拥有指令监控菜单权限的用户id列表
     * @return
     */
    public static synchronized List<String> getUserIds(){
        return AuthData.userIds;
    }


    /**
     * etf基金成分股行情明细 使用ConcurrentHashMap 保证线程安全
     */
    public static ConcurrentHashMap<String,EtfConstituentStockDetail> etfConstituentStockDetailMap=new ConcurrentHashMap<>();

    /**
     * etf基金成分股行情明细(涨幅前十) 使用ConcurrentHashMap 保证线程安全
     */
    public static ConcurrentHashMap<String,EtfConstituentStockDetail> etfConstituentStockDetailUpMap=new ConcurrentHashMap<>();

    /**
     * etf基金成分股行情明细(跌幅前十) 使用ConcurrentHashMap 保证线程安全
     */
    public static ConcurrentHashMap<String,EtfConstituentStockDetail> etfConstituentStockDetailDownMap=new ConcurrentHashMap<>();

    /**
     * 用户自定义期货价差规则数据 使用ConcurrentHashMap 保证线程安全
     * key:期货a代码_期货b代码
     * value：userid
     */
    public static ConcurrentHashMap<String, List<String>> ruleFuturePriceDiffMap=new ConcurrentHashMap<>();
}
