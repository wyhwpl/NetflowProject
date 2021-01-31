package com.netflow.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.netflow.bean.Role;
import com.netflow.bean.RoleTree;
import com.netflow.bean.User;
import com.netflow.common.ErrorMsg;
import com.netflow.common.PageResult;
import com.netflow.service.RoleService;
import com.netflow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 汪培林
 * @data 2020-12-24  13:36:41
 */
@RestController
@RequestMapping("/role")
public class RoleController extends BaseController{

    @Autowired
    private RoleService roleServiceImpl;

    @RequestMapping(value = "getRoleList",method = RequestMethod.GET)
    public ErrorMsg getAllRole(String page, String limit, String appId){

        System.out.println(page+" "+limit);
        Integer pageI = page == null || page.length()==0? 1 : Integer.valueOf(page);
        Integer rows = limit == null || limit.length()==0? 10 : Integer.valueOf(limit);
        appId = "0".equals(appId) ? null : appId;
        List<Role> roles = roleServiceImpl.getAllRole(pageI,rows,appId);
        long count = roleServiceImpl.getRoleCount(appId);

        return new ErrorMsg("0","success",new PageResult<Role>(count,roles));
    }

    @RequestMapping(value = "getRoleTree", method = RequestMethod.GET)
    public ErrorMsg getRoleTree(){
        List<RoleTree> trees = roleServiceImpl.getRoleTree();

        return new ErrorMsg("0","success",trees);
    }

    @RequestMapping(value = "getRoleIdByUser", method = RequestMethod.GET)
    public ErrorMsg getRoleIdByUser(String userId){
        List<String> roleIds = roleServiceImpl.getRoleIdByUser(userId);
        return new ErrorMsg("0","success",roleIds);
    }

    @RequestMapping(value = "getRoleById",method = RequestMethod.GET)
    public ErrorMsg getRoleById(String id){


        Role role = roleServiceImpl.getRoleById(id);

        return new ErrorMsg("0","success",role);
    }

    @RequestMapping(value = "getRoleByKey",method = RequestMethod.POST)
    public ErrorMsg getRoleByKey(@RequestBody String param){

        System.out.println(param);
        JSONObject object = JSON.parseObject(param);
        Integer page = object.getInteger("page") == null ? 1 : object.getInteger("page");
        Integer limit = object.getInteger("limit") == null ? 10 : object.getInteger("limit");
        String keyWord = object.getString("keyword");
        String appId = "0".equals(object.getString("appId")) ? null : object.getString("appId");
        if(keyWord==null||keyWord.length()==0){
            return new ErrorMsg("-1", "关键词为空");
        }

        List<Role> roles = roleServiceImpl.getRoleByKey(page,limit,keyWord,appId);
        Long count = roleServiceImpl.getRoleCountByKey(keyWord,appId);

        return new ErrorMsg("0","success",new PageResult<Role>(count,roles));
    }

    @RequestMapping("insertRole")
    public ErrorMsg insertRole(@RequestBody Role role){

        String username = parseTokenValueByKey("username");
        role.setCreatePerson(username);

        int result = roleServiceImpl.insertRole(role);

        if(result!=1){
            return new ErrorMsg("-1","failed","insert role failed");
        }else{
            return new ErrorMsg("0","success");
        }

    }

    @RequestMapping(value = "/allocateRole", method = RequestMethod.POST)
    public ErrorMsg allocateRole(@RequestBody String param){

        System.out.println(param);

        JSONObject object = JSON.parseObject(param);
        String userId = object.getString("userId");
        JSONArray roleIds = object.getJSONArray("roleIds");
        List<String> roles = roleIds.toJavaList(String.class);
        roleServiceImpl.allocateRole(userId,roles);
        return new ErrorMsg("0","success");
    }

    @RequestMapping("updateRole")
    public ErrorMsg updateRole(@RequestBody Role role){

        String username = parseTokenValueByKey("username");
        role.setUpdatePerson(username);

        int result = roleServiceImpl.updateRole(role);

        if(result!=1){
            return new ErrorMsg("-1","failed","update role failed");
        }else{
            return new ErrorMsg("0","success");
        }

    }

    @RequestMapping(value = "delRoleById",method = RequestMethod.GET)
    public ErrorMsg deleteRoleById(String id){


        int role = roleServiceImpl.deleteRoleById(id);

        return new ErrorMsg("0","success",role);
    }

}
