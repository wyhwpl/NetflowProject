package com.netflow.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.netflow.bean.User;
import com.netflow.common.ErrorMsg;
import com.netflow.common.PageResult;
import com.netflow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "getUserList",method = RequestMethod.GET)
    public ErrorMsg getAllUser(String page, String limit){

        System.out.println(page+" "+limit);
        Integer pageI = page == null || page.length()==0? 1 : Integer.valueOf(page);
        Integer rows = limit == null || limit.length()==0? 10 : Integer.valueOf(limit);
        List<User> users = userServiceImpl.getAllUser(pageI,rows);
        long count = userServiceImpl.getUserCount();

        return new ErrorMsg("0","success",new PageResult<User>(count,users));
    }

    @RequestMapping(value = "getUserById",method = RequestMethod.GET)
    public ErrorMsg getUserById(String id){


        User user = userServiceImpl.getUserById(id);

        return new ErrorMsg("0","success",user);
    }

    @RequestMapping(value = "getUserByKey",method = RequestMethod.POST)
    public ErrorMsg getUserByKey(@RequestBody String param){

        System.out.println(param);
        JSONObject object = JSON.parseObject(param);
        Integer page = object.getInteger("page") == null ? 1 : object.getInteger("page");
        Integer limit = object.getInteger("limit") == null ? 10 : object.getInteger("limit");
        String keyWord = object.getString("keyword");
        if(keyWord==null||keyWord.length()==0){
            return new ErrorMsg("-1", "关键词为空");
        }

        List<User> users = userServiceImpl.getUserByKey(page,limit,keyWord);
        Long count = userServiceImpl.getUserCountByKey(keyWord);

        return new ErrorMsg("0","success",new PageResult<User>(count,users));
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

    @RequestMapping("updateUser")
    public ErrorMsg updateUser(@RequestBody User user){

        String username = parseTokenValueByKey("username");
        user.setUpdatePerson(username);

        int result = userServiceImpl.updateUser(user);

        if(result!=1){
            return new ErrorMsg("-1","failed","update user failed");
        }else{
            return new ErrorMsg("0","success");
        }

    }

    @RequestMapping(value = "delUserById",method = RequestMethod.GET)
    public ErrorMsg deleteUserById(String id){


        int user = userServiceImpl.deleteUserById(id);

        return new ErrorMsg("0","success",user);
    }

}
