package com.netflow.service.impl;

import com.netflow.bean.Resource;
import com.netflow.bean.ResourceRole;
import com.netflow.bean.TreeNode;
import com.netflow.common.BaseErrorEnum;
import com.netflow.exception.DuplicatedException;
import com.netflow.mapper.ResourceMapper;
import com.netflow.mapper.ResourceRoleMapper;
import com.netflow.service.ResourceService;
import com.netflow.utils.UUIDKeyGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author 汪培林
 * @data 2021-01-12  17:48:22
 */
@Service
public class ResourceServiceImpl implements ResourceService {

    @Autowired
    private ResourceMapper resourceMapper;

    @Autowired
    private ResourceRoleMapper resourceRoleMapper;

    @Override
    public List<Resource> getAllResource(Integer page, Integer limit, String appId) {

        return resourceMapper.getAllResource((page-1)*limit, limit, appId);
    }

    @Override
    public Resource getResourceById(String id) {
        return resourceMapper.getResourceById(id);
    }

    @Override
    public List<Resource> getResourceByKey(Integer page, Integer limit, String keyword, String appId) {
        return resourceMapper.getResourceByKey((page-1)*limit,limit,keyword,appId);
    }

    @Override
    public List<TreeNode> getResourceTree(String appId, Integer resourceType, String pid) {
        Resource condition = new Resource();
        condition.setAppId(appId);
        condition.setResourceType(resourceType);
        condition.setPid(pid);
        List<TreeNode> trees = new ArrayList<>();
        List<Resource> resources = resourceMapper.getResourceByCondition(condition);
        for (Resource resource : resources) {
            TreeNode tree = new TreeNode();
            tree.setId(resource.getId());
            tree.setLabel(resource.getResourceName());
            List<TreeNode> children = getResourceTree(appId,resourceType,tree.getId());
            tree.setChildren(children);
            trees.add(tree);
        }
        return trees;
    }

    @Override
    public List<Resource> getResourceByCondition(Resource resource) {
        return resourceMapper.getResourceByCondition(resource);
    }

    @Override
    public int insertResource(Resource resource) {

        resource.setId(UUIDKeyGenerator.getUUID());
        resource.setCreateTime(new Timestamp(new Date().getTime()));
        return resourceMapper.insertResource(resource);
    }

    @Override
    public int allocateResource(String roleId,List<String> resourceIds,Integer resourceType) {

        resourceRoleMapper.deleteRoleUserByCondition(null,roleId,null,resourceType);

        for (String resourceId : resourceIds) {
            ResourceRole resourceRole =  new ResourceRole();
            resourceRole.setId(UUIDKeyGenerator.getUUID());
            resourceRole.setRoleId(roleId);
            resourceRole.setResourceId(resourceId);
            resourceRole.setResourceType(resourceType);
            resourceRoleMapper.insertResourceRole(resourceRole);
        }
        return 0;
    }

    @Override
    public int updateResource(Resource resource) {
        resource.setUpdateTime(new Timestamp(new Date().getTime()));
        return resourceMapper.updateResource(resource);
    }

    @Override
    public int deleteResourceById(String id) {
        resourceRoleMapper.deleteRoleUserByCondition(null,null,id,null);
        return resourceMapper.deleteResourceById(id);
    }

    @Transactional(rollbackFor = {Exception.class, Error.class})
    @Override
    public int deleteParentAndSon(String id) {

        return 0;
    }

    @Override
    public long getResourceCount(String appId) {
        return resourceMapper.getResourceCount(appId);
    }

    @Override
    public long getResourceCountByKey(String keyword, String appId) {
        return resourceMapper.getResourceCountByKey(keyword, appId);
    }

    @Override
    public List<String> getResourceIdByRole(String roleId, int resourceType) {
        ResourceRole condition = new ResourceRole();
        condition.setRoleId(roleId);
        List<ResourceRole> rrs = resourceRoleMapper.getAllResourceRoleByCondition(condition);

        List<String> ids = new ArrayList<>();

        for (ResourceRole rr : rrs) {
            String resourceId = rr.getResourceId();
            Resource resource = resourceMapper.getResourceById(resourceId);
            if(resource.getResourceType() == resourceType) {
                ids.add(resourceId);
            }
        }

        return ids;
    }

    private int deleteSonResource(String id){
        resourceMapper.deleteResourceById(id);
        List<String> resourceId = resourceMapper.getResourceIdByPid(id);
        for (String pid : resourceId) {
            deleteSonResource(pid);
        }
        return 0;
    }
}
