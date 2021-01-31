package com.netflow.service;

import com.netflow.bean.*;

import java.util.List;

/**
 * 应用服务接口
 */
public interface ResourceService {

    /**
     * 获取所有应用资源信息
     * @return
     */
    List<Resource> getAllResource(Integer page, Integer limit, String appId);

    /**
     * 获取指定id的应用信息
     * @param id
     * @return
     */
    Resource getResourceById(String id);

    /**
     * 根据关键词获取所有角色信息
     * @Param page
     * @Param limit
     * @Param keyword
     * @return
     */
    List<Resource> getResourceByKey(Integer page, Integer limit, String keyword,String appId);

    List<TreeNode> getResourceTree(String appId,Integer resourceType,String pid);

    /**
     * 根据条件查询资源信息
     * @param resource
     * @return
     */
    List<Resource> getResourceByCondition(Resource resource);

    /**
     * 添加新应用资源
     * @param resource
     * @return
     */
    int insertResource(Resource resource);

    int allocateResource(String roleId,List<String> resourceId,Integer resourceType);

    /**
     * 修改应用资源信息
     * @param resource
     * @return
     */
    int updateResource(Resource resource);

    /**
     * 根据主键删除应用资源
     * @param id
     * @return
     */
    int deleteResourceById(String id);

    /**
     * 删除资源及其子级所有资源
     * @param id
     * @return
     */
    int deleteParentAndSon(String id);

    /**
     * 获取角色信息总数
     * @return
     */
    long getResourceCount(String appId);

    /**
     * 根据关键词获取角色信息总数
     * @return
     */
    long getResourceCountByKey(String keyword,String appId);

    List<String> getResourceIdByRole(String roleId,int resourceType);

}
