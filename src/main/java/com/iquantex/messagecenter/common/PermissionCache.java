package com.iquantex.messagecenter.common;

import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author allen
 * @date 2020-08-01
 */
public class PermissionCache {
    /**
     *  <fundCode,Set<userId>>
     */
    private static Map<String, Set<Long>> fundUserMap = new ConcurrentHashMap<>();

    public static void addUser(String fundCode,Long userId){
        Set<Long> userIds = fundUserMap.get(fundCode);
        userIds.add(userId);
        fundUserMap.put(fundCode,userIds);
    }

    public static void add(String fundCode,Set<Long> userIds){
        fundUserMap.put(fundCode,userIds);
    }

    public static Set<Long> getUserIds(String fundCode){
        Set<Long> userIds;
        userIds = fundUserMap.get(fundCode);
        return userIds == null ? Collections.emptySet() : userIds;

    }

    public static void setFundUserMap(Map<String, Set<Long>> fundUserMap) {
        synchronized (PermissionCache.class){
            PermissionCache.fundUserMap.clear();
            PermissionCache.fundUserMap = fundUserMap;
        }
    }

    public static Map<String, Set<Long>> getFundUserMap() {
        return fundUserMap;
    }

}
