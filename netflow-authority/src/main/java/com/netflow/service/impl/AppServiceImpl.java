package com.netflow.service.impl;

import com.netflow.bean.AppTree;
import com.netflow.bean.Application;
import com.netflow.bean.Role;
import com.netflow.common.BaseErrorEnum;
import com.netflow.exception.DuplicatedException;
import com.netflow.mapper.AppMapper;
import com.netflow.mapper.RoleMapper;
import com.netflow.mapper.RoleUserMapper;
import com.netflow.service.AppService;
import com.netflow.service.RoleService;
import com.netflow.utils.UUIDKeyGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * @author 汪培林
 * @data 2021-01-09  20:50:20
 */
@Service
public class AppServiceImpl implements AppService {

    @Autowired
    private AppMapper appMapper;

    @Autowired
    private RoleService roleService;

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private RoleUserMapper roleUserMapper;


    @Override
    public List<Application> getAllApp() {
        return appMapper.getAllApp();
    }

    @Override
    public List<AppTree> getAppTree() {
        return appMapper.getAppTree();
    }

    @Override
    public Application getAppById(String id) {
        return appMapper.getAppById(id);
    }

    @Override
    public int insertApp(Application application) {
        application.setId(UUIDKeyGenerator.getUUID());
        application.setCreateTime(new Timestamp(new Date().getTime()));
        return appMapper.insertApp(application);
    }

    @Override
    public int updateApp(Application application) {
        application.setUpdateTime(new Timestamp(new Date().getTime()));
        return appMapper.updateApp(application);
    }

    @Transactional(rollbackFor = { Exception.class, Error.class})
    @Override
    public int deleteAppById(String id) {

        List<Role> allRole = roleMapper.getAllRole(null, null, id);
        for (Role role : allRole) {
            String roleId = role.getId();
            roleUserMapper.deleteRoleUserByCondition(null,null,roleId);
            if("0".equals(roleId)){
                throw new DuplicatedException(BaseErrorEnum.DuplicateUser);
            }
            roleMapper.deleteRoleById(roleId);
        }
        return appMapper.deleteAppById(id);
    }
}
