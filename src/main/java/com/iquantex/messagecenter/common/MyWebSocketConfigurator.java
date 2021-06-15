package com.iquantex.messagecenter.common;

import com.iquantex.web.framework.bean.RequestUserInfo;
import com.iquantex.web.framework.util.SessionData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.websocket.HandshakeResponse;
import javax.websocket.server.HandshakeRequest;
import javax.websocket.server.ServerEndpointConfig;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by User on 2018/5/4.
 */
public class MyWebSocketConfigurator extends ServerEndpointConfig.Configurator {
    private static Logger LOG = LoggerFactory.getLogger(MyWebSocketConfigurator.class);

    @Override
    public void modifyHandshake(ServerEndpointConfig sec, HandshakeRequest request, HandshakeResponse response) {
        super.modifyHandshake(sec, request, response);

        // 设置用户信息
        RequestUserInfo userInfo = SessionData.getUserInfo();
        // 用户信息
        sec.getUserProperties().put(SessionUtil.USER_INFO, userInfo);
        // 用户ID
        sec.getUserProperties().put(SessionUtil.USER_ID, userInfo.getId());
        // 用户角色ID
        String delimiter = ",";
        if (null != userInfo.getRoleIds()) {
            List<Long> userRoleIds = Arrays.stream(userInfo.getRoleIds().split(delimiter)).map(Long::valueOf).collect(Collectors.toList());
            sec.getUserProperties().put(SessionUtil.USER_ROLE_IDS, userRoleIds);
        }
        if (null != userInfo.getRoleCodes()) {
            List<String> userRoleCodes = Arrays.asList(userInfo.getRoleCodes().split(delimiter));
            sec.getUserProperties().put(SessionUtil.USER_ROLE_CODES, userRoleCodes);
        }
        if (null != SessionData.getIp()) {
            sec.getUserProperties().put(SessionUtil.IP, SessionData.getIp());
        }

        if (null != SessionData.getMac()) {
            sec.getUserProperties().put(SessionUtil.MAC, SessionData.getMac());
        }
    }
}
