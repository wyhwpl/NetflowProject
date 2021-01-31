package com.netflow.service.impl;

import com.netflow.bean.User;
import com.netflow.common.BaseError;
import com.netflow.common.BaseErrorEnum;
import com.netflow.exception.DuplicatedException;
import com.netflow.mapper.RoleUserMapper;
import com.netflow.mapper.UserMapper;
import com.netflow.service.UserService;
import com.netflow.utils.JwtUtil;
import com.netflow.utils.UUIDKeyGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 用户服务实现类
 * @author 汪培林
 * @data 2020-12-24  14:29:10
 */
@Service
public class UserServiceImpl implements UserService {

    /**
     * 用户操作类
     */
    @Autowired
    private UserMapper userMapper;

    /**
     * 角色用户关联操作类
     */
    @Autowired
    private RoleUserMapper roleUserMapper;

    /**
     * 登录
     * @param user
     * @return
     */
    @Override
    public String login(User user) {
        String token = "";

        User find = getUserByUsername(user.getUsername());
        if(find!=null&&find.getUsername().equals(user.getUsername())&&find.getPassword().equals(user.getPassword())){
            token = JwtUtil.sign(user);
        }
        return token;
    }

    /**
     * 获取所有用户信息
     * @Param page
     * @Param limit
     * @return
     */
    @Override
    public List<User> getAllUser(Integer page, Integer limit) {
        List<User> users = userMapper.getAllUser((page-1)*limit, limit);
        return users;
    }

    @Override
    public User getUserById(String id) {
        return userMapper.getUserById(id);
    }

    @Override
    public List<User> getUserByKey(Integer page, Integer limit, String keyword) {
        return userMapper.getUserByKey((page-1)*limit, limit, keyword);
    }

    /**
     * 根据用户名获取用户信息
     * @param username
     * @return
     */
    @Override
    public User getUserByUsername(String username) {
        return userMapper.queryUserByUsername(username);
    }

    /**
     * 添加新用户
     * @param user
     * @return
     */
    @Override
    public int insertUser(User user) {


        user.setId(UUIDKeyGenerator.getUUID());
        user.setCreateTime(new Timestamp(new Date().getTime()));

        User username = getUserByUsername(user.getUsername());

        if(username != null){
            throw new DuplicatedException(BaseErrorEnum.DuplicateUser);
        }

        return userMapper.insertUser(user);
    }

    @Override
    public int updateUser(User user) {
        user.setUpdateTime(new Timestamp(new Date().getTime()));
        return userMapper.updateUser(user);
    }

    @Override
    public int deleteUserById(String id) {
        roleUserMapper.deleteRoleUserByCondition(null,id,null);
        return userMapper.deleteUserById(id);
    }

    @Override
    public long getUserCount() {
        return userMapper.getUserCount();
    }

    @Override
    public long getUserCountByKey(String keyword) {
        return userMapper.getUserCountByKey(keyword);
    }


}
