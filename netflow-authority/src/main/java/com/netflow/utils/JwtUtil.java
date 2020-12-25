package com.netflow.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.netflow.bean.User;
import com.netflow.contants.JwtConstants;

import java.util.Date;

/**
 * @author 汪培林
 * @data 2020-12-24  13:38:53
 */
public class JwtUtil {

    private static final long EXPIRE= JwtConstants.expire;
    private static final String SECRET = JwtConstants.secret;

    public static String sign(User user){

        Date now = new Date();
        String token = JWT.create()
                .withClaim("username", user.getUsername())
                .withIssuedAt(now)
                .withExpiresAt(new Date(now.getTime() + EXPIRE))
                .sign(Algorithm.HMAC256(SECRET));

        return token;
    }

    public static boolean verify(String token){

        try{
            DecodedJWT verify = JWT.require(Algorithm.HMAC256(SECRET))
                    .build().verify(token);

            return !isExpired(verify.getExpiresAt());
        }catch (Exception e){
            return false;
        }

    }

    private static boolean isExpired(Date expire){
        return expire.before(new Date());
    }

}
