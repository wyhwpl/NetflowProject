package com.netflow.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.Claim;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author 汪培林
 * @data 2020-12-23  13:49:13
 */
@RestController
public class BaseController {

    public String getToken(){

        ServletRequestAttributes attributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        return request.getHeader("Authorization");
    }

    public String parseTokenValueByKey(String key){
        String token = getToken();
        if(token==null||token.length()==0){
            return null;
        }
        Map<String, Claim> claims =
                JWT.decode(token).getClaims();

        return claims.get(key).asString();

    }
}
