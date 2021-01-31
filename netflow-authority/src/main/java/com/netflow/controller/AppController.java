package com.netflow.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.netflow.bean.AppTree;
import com.netflow.bean.Application;
import com.netflow.bean.Role;
import com.netflow.common.ErrorMsg;
import com.netflow.common.PageResult;
import com.netflow.service.AppService;
import com.netflow.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 汪培林
 * @data 2020-12-24  13:36:41
 */
@RestController
@RequestMapping("/app")
public class AppController extends BaseController{

    @Autowired
    private AppService appServiceImpl;

    @RequestMapping(value = "getAppList",method = RequestMethod.GET)
    public ErrorMsg getAllApp(){

        List<Application> applications = appServiceImpl.getAllApp();
        return new ErrorMsg("0","success", applications);
    }

    @RequestMapping(value = "getAppTree",method = RequestMethod.GET)
    public ErrorMsg getAppTree(){

        List<AppTree> trees = appServiceImpl.getAppTree();
        return new ErrorMsg("0","success", trees);
    }

    @RequestMapping(value = "getAppById",method = RequestMethod.GET)
    public ErrorMsg getAppById(String id){


        Application application = appServiceImpl.getAppById(id);

        return new ErrorMsg("0","success",application);
    }

    @RequestMapping("insertApp")
    public ErrorMsg insertApp(@RequestBody Application application){

        String username = parseTokenValueByKey("username");
        application.setCreatePerson(username);

        int result = appServiceImpl.insertApp(application);

        if(result!=1){
            return new ErrorMsg("-1","failed","insert app failed");
        }else{
            return new ErrorMsg("0","success");
        }

    }

    @RequestMapping("updateApp")
    public ErrorMsg updateApp(@RequestBody Application application){

        String username = parseTokenValueByKey("username");
        application.setUpdatePerson(username);

        int result = appServiceImpl.updateApp(application);

        if(result!=1){
            return new ErrorMsg("-1","failed","update app failed");
        }else{
            return new ErrorMsg("0","success");
        }

    }

    @RequestMapping(value = "delAppById",method = RequestMethod.GET)
    public ErrorMsg deleteAppById(String id){


        int app = appServiceImpl.deleteAppById(id);

        return new ErrorMsg("0","success",app);
    }

}
