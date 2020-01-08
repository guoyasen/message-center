package com.iquantex.messagecenter.service.feignclient.service;

import com.iquantex.messagecenter.service.feignclient.config.ServiceContext;
import com.iquantex.messagecenter.service.feignclient.config.ServiceName;
import com.iquantex.web.framework.bean.RpcResultObj;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 用户服务
 */
@Service
@FeignClient(name = ServiceName.USER_DATA_SERVICE, path = ServiceContext.USER_DATA_SERVICE_PATH)
public interface UserDataService {

    /**
     * 获取默认日期
     * @return 默认日期
     */
    @GetMapping("/users/all")
    RpcResultObj getAll();
}
