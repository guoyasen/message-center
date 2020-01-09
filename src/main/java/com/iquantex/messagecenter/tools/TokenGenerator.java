package com.iquantex.messagecenter.tools;

import com.auth0.jwt.JWTSigner;
import com.iquantex.spring.boot.autoconfigrue.web.framework.AppProperties;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class TokenGenerator {
    @Autowired
    private AppProperties appProperties;

    public String tokenGenerator() {
        JWTSigner signer = new JWTSigner(appProperties.getJwtSecret());
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", 1);
        claims.put("roleIds", "1");
        claims.put("loginTime", new Date());
        Date expire = DateUtils.addMinutes(new Date(), appProperties.getOrDefault("jwt-expire", Integer.class, 1440));
        claims.put("exp", expire.getTime());

        return signer.sign(claims);
    }
}