package com.netflow.controller;

import com.netflow.bean.User;
import com.netflow.common.ErrorMsg;
import com.netflow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author 汪培林
 * @data 2020-12-24  13:36:41
 */
@RestController
@RequestMapping("/user")
public class UserController extends BaseController{

    @Autowired
    private UserService userServiceImpl;

    @RequestMapping("/login")
    public ErrorMsg login(@RequestBody User user){

        String token = userServiceImpl.login(user);

        if(token!=null&&token.length()>0){
            return new ErrorMsg("0","success",token);
        }else{
            return new ErrorMsg("-1","failed","get token failed");
        }

    }

    @RequestMapping("getAllUser")
    public ErrorMsg getAllUser(){

        List<User> users = userServiceImpl.getAllUser();
        return new ErrorMsg("0","success",users);
    }

    @RequestMapping("insertUser")
    public ErrorMsg insertUser(@RequestBody User user){

        String username = parseTokenValueByKey("username");
        user.setCreatePerson(username);

        int result = userServiceImpl.insertUser(user);

        if(result!=1){
            return new ErrorMsg("-1","failed","insert user failed");
        }else{
            return new ErrorMsg("0","success");
        }

    }

}
