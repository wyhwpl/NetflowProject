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
     * @return
     */
    List<User> getAllUser();

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
}
