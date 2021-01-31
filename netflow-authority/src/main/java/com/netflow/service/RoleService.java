package com.netflow.service;

import com.netflow.bean.Role;
import com.netflow.bean.RoleTree;
import com.netflow.bean.User;

import java.util.List;

/**
 * 角色服务接口
 */
public interface RoleService {

    /**
     * 获取所有角色信息
     * @Param page
     * @Param limit
     * @return
     */
    List<Role> getAllRole(Integer page, Integer limit,String appId);

    /**
     * 获取指定id的角色信息
     * @param id
     * @return
     */
    Role getRoleById(String id);

    /**
     * 根据关键词获取所有角色信息
     * @Param page
     * @Param limit
     * @Param keyword
     * @return
     */
    List<Role> getRoleByKey(Integer page, Integer limit, String keyword,String appId);


    /**
     * 添加新角色
     * @param role
     * @return
     */
    int insertRole(Role role);

    /**
     * 修改角色信息
     * @param role
     * @return
     */
    int updateRole(Role role);

    /**
     * 根据主键删除角色
     * @param id
     * @return
     */
    int deleteRoleById(String id);

    /**
     * 获取角色信息总数
     * @return
     */
    long getRoleCount(String appId);

    /**
     * 根据关键词获取角色信息总数
     * @return
     */
    long getRoleCountByKey(String keyword,String appId);

    /**
     * 获取角色树
     * @return
     */
    public List<RoleTree> getRoleTree();


    /**
     * 根据用户id获取角色id
     */
    public List<String> getRoleIdByUser(String userId);

    /**
     * 为用户分配角色
     * @param userId
     * @param roles
     * @return
     */
    public int allocateRole(String userId, List<String> roles);

}
