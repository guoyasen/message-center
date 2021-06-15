package com.iquantex.messagecenter.service.impl;

import com.alibaba.fastjson.JSON;
import com.iquantex.messagecenter.common.PermissionCache;
import com.iquantex.messagecenter.common.SessionUtil;
import com.iquantex.messagecenter.prividers.IMsgPusher;
import com.iquantex.messagecenter.service.PushService;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Service
@Slf4j
public class PushServiceImpl implements PushService {
    @Override
    public void send(Object event) {
        List<Long> userIds = getAccessUserIds(event);
//        List<Long> userIds = SessionUtil.listUserId();
        log.info("【推送事件】{}【推送用户】{}", JSON.toJSONString(event), JSON.toJSONString(userIds));
        IMsgPusher.push(userIds, event);
    }

    public List<Long> getAccessUserIds(Object event) {
        List<Long> userIds = new ArrayList<>();
        userIds.add(1L);
        try {
            Class clz = event.getClass();
            Method method = BeanUtils.findDeclaredMethod(clz, "getIsAuthFilter");
            // 如果没有此方法则不做权限过滤
            if (null == method) {
                return SessionUtil.listUserId();
            }
            Boolean isAuthFilter = (Boolean) method.invoke(event);
            if(Objects.isNull(isAuthFilter)){
                return SessionUtil.listUserId();
            }
            if(Objects.nonNull(isAuthFilter) && isAuthFilter){
                // 说明需要权限过滤
                // 根据产品编码查询权限信息
                Method methodGetFundCode = BeanUtils.findDeclaredMethod(clz, "getFundCode");
                String fundCode = (String) methodGetFundCode.invoke(event);
                Set<Long> userSet = PermissionCache.getUserIds(fundCode);
                if (CollectionUtils.isNotEmpty(userSet)) {
                    userIds.addAll(userSet);
                }
            }
        } catch (Exception e) {
            log.error("获取有权限的用户失败", e);
        }
        return userIds;
    }
}
