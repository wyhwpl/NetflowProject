package com.netflow.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.netflow.utils.JwtUtil;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 汪培林
 * @data 2020-12-24  15:07:44
 */
@Component
public class TokenInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String token = request.getHeader("Authorization");

        response.setCharacterEncoding("UTF-8");
        if(token!=null&&token.length()>0){
            if(JwtUtil.verify(token)){
                return true;
            }
        }
        response.setContentType("application/json; charset=utf-8");
        JSONObject object = new JSONObject();
        object.put("errorCode","-3");
        object.put("errorMsg","token过期,请重新登录");
        response.getWriter().append(object.toJSONString());
        return false;
    }
}
