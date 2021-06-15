package com.iquantex.messagecenter.common;

import com.iquantex.web.framework.bean.JwtData;
import org.apache.commons.collections.CollectionUtils;

import javax.websocket.Session;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Web Socket session 工具类
 *
 * @author devin
 */
public class SessionUtil {
    public static final String MAC = "mac";
    public static final String IP = "ip";
    public static final String USER_INFO = "userInfo";
    public static final String USER_ID = "userId";
    public static final String USER_ROLE_CODES = "userRoleCodes";
    public static final String USER_ROLE_IDS = "userRoleIds";

    /**
     * session 集合     <session id, session>
     */
    private static final Map<String, Session> sessionMap = new ConcurrentHashMap<>();

    /**
     * <userId, sessionIds>
     */
    private static final Map<Long, Set<String>> userSessionMap = new ConcurrentHashMap<>();

    /**
     * 获取用户信息
     *
     * @param session
     * @return
     */
    public static JwtData getUserInfo(Session session) {
        return (JwtData) session.getUserProperties().get(USER_INFO);
    }

    /**
     * 获取用户ID
     *
     * @param session
     * @return
     */
    public static Long getUserId(Session session) {
        return (Long) session.getUserProperties().get(USER_ID);
    }

    /**
     * 获取用户角色编码
     *
     * @param session
     * @return
     */
    @SuppressWarnings("unchecked")
    public static List<String> getUserRoleCodes(Session session) {
        return (List<String>) session.getUserProperties().get(USER_ROLE_CODES);
    }

    /**
     * 获取用户角色ID
     *
     * @param session
     * @return
     */
    @SuppressWarnings("unchecked")
    public static List<Long> getUserRoleIds(Session session) {
        return (List<Long>) session.getUserProperties().get(USER_ROLE_IDS);
    }

    /**
     * 获取session IP地址
     *
     * @param session
     * @return
     */
    @SuppressWarnings("unchecked")
    public static String getIp(Session session) {
        return (String) session.getUserProperties().get(IP);
    }

    /**
     * 用于客户端连接上之后保存session
     *
     * @param session socket session
     */
    public static void setSession(Session session) {
        if (!sessionMap.containsKey(session.getId())) {
            sessionMap.put(session.getId(), session);
        }
        Long userId = getUserId(session);
        Set<String> set = userSessionMap.get(userId);
        if (CollectionUtils.isEmpty(set)) {
            set = new HashSet<>();
            userSessionMap.put(userId, set);
        }
        set.add(session.getId());
    }

    /**
     * 获取用户的session列表
     *
     * @param userId
     * @return
     */
    public static List<Session> listSession(Long userId) {
        List<Session> sessions = new ArrayList<>();
        Set<String> sessionIdSet = userSessionMap.get(userId);
        if (CollectionUtils.isNotEmpty(sessionIdSet)) {
            for (String sessionId : sessionIdSet) {
                Session session = sessionMap.get(sessionId);
                if (null != session) {
                    sessions.add(session);
                }
            }
        }
        return sessions;
    }

    /**
     * 获取session
     *
     * @param userIds
     * @return
     */
    public static List<Session> listSession(List<Long> userIds) {
        List<Session> sessions = new ArrayList<>();
        for (Long userId : userIds) {
            sessions.addAll(listSession(userId));
        }
        return sessions;
    }

    /**
     * 获取所有的session
     *
     * @return
     */
    public static List<Session> listSession() {
        return new ArrayList<>(sessionMap.values());
    }

    public static List<Long> listUserId() {
        return new ArrayList<>(userSessionMap.keySet());
    }

    /**
     * 撤销session
     *
     * @param session socket session
     */
    public static void removeSession(Session session) {
        sessionMap.remove(session.getId());

        Long userId = getUserId(session);
        Set set = userSessionMap.get(userId);
        if (CollectionUtils.isNotEmpty(set)) {
            set.remove(session.getId());
            if (CollectionUtils.isEmpty(set)) {
                userSessionMap.remove(userId);
            }
        }
    }
}
