package com.netflow.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.netflow.bean.AppTree;
import com.netflow.bean.Application;
import com.netflow.bean.Resource;
import com.netflow.bean.TreeNode;
import com.netflow.common.ErrorMsg;
import com.netflow.common.PageResult;
import com.netflow.service.AppService;
import com.netflow.service.ResourceService;
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
@RequestMapping("/resource")
public class ResourceController extends BaseController{

    @Autowired
    private ResourceService resourceServiceImpl;

    @RequestMapping(value = "getResourceList",method = RequestMethod.GET)
    public ErrorMsg getAllResource(String page,String limit,String appId){

        Integer pageI = page == null || page.length()==0? 1 : Integer.valueOf(page);
        Integer rows = limit == null || limit.length()==0? 10 : Integer.valueOf(limit);
        appId = "0".equals(appId) ? null : appId;
        List<Resource> resources = resourceServiceImpl.getAllResource(pageI,rows,appId);
        Long count = resourceServiceImpl.getResourceCount(appId);
        return new ErrorMsg("0","success", new PageResult<Resource>(count,resources));
    }


    @RequestMapping(value = "getResourceById",method = RequestMethod.GET)
    public ErrorMsg getResourceById(String id){


        Resource resource = resourceServiceImpl.getResourceById(id);

        return new ErrorMsg("0","success",resource);
    }

    @RequestMapping(value = "getResourceByKey",method = RequestMethod.POST)
    public ErrorMsg getResourceByKey(@RequestBody String param){

        System.out.println(param);
        JSONObject object = JSON.parseObject(param);
        Integer page = object.getInteger("page") == null ? 1 : object.getInteger("page");
        Integer limit = object.getInteger("limit") == null ? 10 : object.getInteger("limit");
        String keyWord = object.getString("keyword");
        String appId = "0".equals(object.getString("appId")) ? null : object.getString("appId");
        if(keyWord==null||keyWord.length()==0){
            return new ErrorMsg("-1", "关键词为空");
        }

        List<Resource> resources = resourceServiceImpl.getResourceByKey(page,limit,keyWord,appId);
        Long count = resourceServiceImpl.getResourceCountByKey(keyWord,appId);

        return new ErrorMsg("0","success",new PageResult<Resource>(count,resources));
    }

    @RequestMapping(value = "getResourceTree", method = RequestMethod.POST)
    public ErrorMsg getResourceTree(@RequestBody String param){
        JSONObject object = JSON.parseObject(param);
        String appId = object.getString("appId");
        Integer resourceType = object.getInteger("resourceType");
        List<TreeNode> result = resourceServiceImpl.getResourceTree(appId,resourceType,"0");
        return new ErrorMsg("0","success",result);
    }

    @RequestMapping("insertResource")
    public ErrorMsg insertResource(@RequestBody Resource resource){

        String username = parseTokenValueByKey("username");
        resource.setCreatePerson(username);

        int result = resourceServiceImpl.insertResource(resource);

        if(result!=1){
            return new ErrorMsg("-1","failed","insert resource failed");
        }else{
            return new ErrorMsg("0","success");
        }

    }

    @RequestMapping(value = "/allocateResource", method = RequestMethod.POST)
    public ErrorMsg allocateResource(@RequestBody String param){

        System.out.println(param);

        JSONObject object = JSON.parseObject(param);
        String roleId = object.getString("roleId");
        JSONArray resourceIds = object.getJSONArray("resourceIds");
        Integer resourceType = object.getInteger("resourceType");
        List<String> resources = resourceIds.toJavaList(String.class);
        resourceServiceImpl.allocateResource(roleId,resources,resourceType);
        return new ErrorMsg("0","success");
    }

    @RequestMapping("updateResource")
    public ErrorMsg updateResource(@RequestBody Resource resource){

        String username = parseTokenValueByKey("username");
        resource.setUpdatePerson(username);

        int result = resourceServiceImpl.updateResource(resource);

        if(result!=1){
            return new ErrorMsg("-1","failed","update resource failed");
        }else{
            return new ErrorMsg("0","success");
        }

    }

    @RequestMapping(value = "delResourceById",method = RequestMethod.GET)
    public ErrorMsg deleteResourceById(String id){


        int resource = resourceServiceImpl.deleteResourceById(id);

        return new ErrorMsg("0","success",resource);
    }

    @RequestMapping(value = "getResourceIdByRole",method = RequestMethod.GET)
    public ErrorMsg getResourceIdByRole(String roleId, String resourceType){
        System.out.println(roleId+"  "+resourceType);
        Integer type = Integer.valueOf(resourceType);
        List<String> ids = resourceServiceImpl.getResourceIdByRole(roleId,type);
        return new ErrorMsg("0","success",ids);
    }

}
