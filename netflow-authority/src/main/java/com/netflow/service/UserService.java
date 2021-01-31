package com.netflow.service;

import com.netflow.bean.User;

import java.util.List;

/**
 * 用户服务接口
 */
public interface UserService {

    /**
     * 登录
     * @param user
     * @return
     */
    String login(User user);

    /**
     * 获取所有用户信息
     * @Param page
     * @Param limit
     * @return
     */
    List<User> getAllUser(Integer page, Integer limit);

    /**
     * 获取指定id的用户信息
     * @param id
     * @return
     */
    User getUserById(String id);

    /**
     * 根据关键词获取所有用户信息
     * @Param page
     * @Param limit
     * @Param keyword
     * @return
     */
    List<User> getUserByKey(Integer page, Integer limit,String keyword);

    /**
     * 根据用户名获取用户信息
     * @param username
     * @return
     */
    User getUserByUsername(String username);

    /**
     * 添加新用户
     * @param user
     * @return
     */
    int insertUser(User user);

    /**
     * 修改用户信息
     * @param user
     * @return
     */
    int updateUser(User user);

    /**
     * 根据主键删除用户
     * @param id
     * @return
     */
    int deleteUserById(String id);

    /**
     * 获取用户信息总数
     * @return
     */
    long getUserCount();

    /**
     * 根据关键词获取用户信息总数
     * @return
     */
    long getUserCountByKey(String keyword);
}
