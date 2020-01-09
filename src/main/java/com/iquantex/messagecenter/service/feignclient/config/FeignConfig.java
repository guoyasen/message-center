package com.iquantex.messagecenter.service.feignclient.config;

import com.iquantex.messagecenter.tools.TokenGenerator;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public class FeignConfig implements RequestInterceptor {

    @Autowired
    private TokenGenerator tokenGenerator;

    @Override
    public void apply(RequestTemplate template) {
        String token = tokenGenerator.tokenGenerator();
        template.header("authorization", token);
    }
}