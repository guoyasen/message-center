package com.iquantex.messagecenter.interceptor.websocket;

import java.security.Principal;

/**
 * 自定义{@link java.security.Principal}
 *
 * @author qingjie.du
 */
public class MyPrincipal implements Principal {
    private String loginName;

    public MyPrincipal(String loginName) {
        this.loginName = loginName;
    }

    @Override
    public String getName() {
        return loginName;
    }
}
