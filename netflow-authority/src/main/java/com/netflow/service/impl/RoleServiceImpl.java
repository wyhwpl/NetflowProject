package com.netflow.service.impl;

import com.netflow.bean.*;
import com.netflow.common.BaseError;
import com.netflow.common.BaseErrorEnum;
import com.netflow.exception.DuplicatedException;
import com.netflow.mapper.AppMapper;
import com.netflow.mapper.RoleMapper;
import com.netflow.mapper.RoleUserMapper;
import com.netflow.service.RoleService;
import com.netflow.utils.UUIDKeyGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author 汪培林
 * @data 2021-01-06  22:36:26
 */
@Service
public class RoleServiceImpl implements RoleService {

    /**
     * 角色操作类
     */
    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private AppMapper appMapper;

    /**
     * 角色用户关联操作类
     */
    @Autowired
    private RoleUserMapper roleUserMapper;

    @Override
    public List<Role> getAllRole(Integer page, Integer limit,String appId) {
        return roleMapper.getAllRole((page-1)*limit, limit,appId);
    }

    @Override
    public Role getRoleById(String id) {
        return roleMapper.getRoleById(id);
    }

    @Override
    public List<Role> getRoleByKey(Integer page, Integer limit, String keyword,String appId) {
        return roleMapper.getRoleByKey((page-1)*limit, limit, keyword,appId);
    }

    @Override
    public int insertRole(Role role) {
        Role roleName = roleMapper.queryRoleByRoleName(role.getRoleName(),role.getAppId());
        if(roleName != null){
            throw new DuplicatedException(BaseErrorEnum.DuplicateRole);
        }
        role.setCreateTime(new Timestamp(new Date().getTime()));
        role.setId(UUIDKeyGenerator.getUUID());
        return roleMapper.insertRole(role);
    }

    @Override
    public int updateRole(Role role) {
        role.setUpdateTime(new Timestamp(new Date().getTime()));
        return roleMapper.updateRole(role);
    }

    @Override
    public int deleteRoleById(String id) {
        roleUserMapper.deleteRoleUserByCondition(null,null,id);
        return roleMapper.deleteRoleById(id);
    }

    @Override
    public long getRoleCount(String appId) {
        return roleMapper.getRoleCount(appId);
    }

    @Override
    public long getRoleCountByKey(String keyword, String appId) {
        return roleMapper.getRoleCountByKey(keyword,appId);
    }

    @Override
    public List<RoleTree> getRoleTree() {
        List<Application> apps = appMapper.getAllApp();
        List<RoleTree> trees = new ArrayList<>();
        for (Application app : apps) {
            RoleTree roleTree = new RoleTree();
            String appId = app.getId();
            roleTree.setId(appId);
            roleTree.setType("app");
            roleTree.setLabel(app.getAppName());
            List<Role> allRole = roleMapper.getAllRole(null, null, appId);
            List<RoleVo> children = new ArrayList<>();
            for (Role role : allRole) {
                RoleVo roleVo = new RoleVo();
                roleVo.setId(role.getId());
                roleVo.setLabel(role.getRoleName());
                roleVo.setType("role");
                children.add(roleVo);
            }
            roleTree.setChildren(children);
            trees.add(roleTree);
        }
        return trees;
    }

    @Override
    public List<String> getRoleIdByUser(String userId) {
        List<String> roleIds = new ArrayList<>();
        RoleUser roleUser = new RoleUser();
        roleUser.setUserId(userId);
        List<RoleUser> roleUsers = roleUserMapper.getAllRoleUserByCondition(roleUser);
        for (RoleUser user : roleUsers) {
            roleIds.add(user.getRoleId());
        }
        return roleIds;
    }

    @Override
    public int allocateRole(String userId, List<String> roles) {
        roleUserMapper.deleteRoleUserByCondition(null,userId,null);
        for (String role : roles) {
            RoleUser roleUser = new RoleUser();
            roleUser.setId(UUIDKeyGenerator.getUUID());
            roleUser.setUserId(userId);
            roleUser.setRoleId(role);
            roleUserMapper.insertRoleUser(roleUser);
        }
        return 1;
    }
}
