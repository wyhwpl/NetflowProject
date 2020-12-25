package com.netflow.contants;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author 汪培林
 * @data 2020-12-24  15:48:40
 */
@Component
public class JwtConstants {

    public static long expire;
    public static String secret;

    @Value("${authority.jwt.expire}")
    public void setExpire(long expire) {
        JwtConstants.expire = expire;
    }

    @Value("${authority.jwt.secret}")
    public void setSecret(String secret) {
        JwtConstants.secret = secret;
    }
}
