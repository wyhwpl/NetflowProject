package com.netflow.mapper;

import com.netflow.bean.RoleUser;
import com.netflow.bean.User;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 汪培林
 * @data 2020-12-24  17:21:03
 */
@Repository
public class RoleUserMapper {

    /**
     * 通过mybatis+mapper形式操作数据库
     */
    @Autowired
    @Qualifier("templateOne")
    private SqlSessionTemplate sqlSessionTemplateOne;


    /**
     * 通过jdbcTemplate形式操作数据库
     */
    @Autowired
    @Qualifier("templateTwo")
    private JdbcTemplate jdbcTemplate;

    /**
     * 查询所有角色用户关联信息
     * @return 角色用户关联信息列表
     */
    public List<RoleUser> getAllRoleUser(){
        return sqlSessionTemplateOne.selectList("getAllRoleUser");
    }

    /**
     * 按条件查询所有角色用户关联信息
     * @return 角色用户关联信息列表
     */
    public List<RoleUser> getAllRoleUserByCondition(RoleUser roleUser){
        return sqlSessionTemplateOne.selectList("getRoleUserByCondition", roleUser);
    }

    /**
     * 插入某个角色用户关联信息
     * @param roleUser 角色用户信息关联类
     * @return 插入结果 0 or 1
     */
    public int insertRoleUser(RoleUser roleUser){
        return sqlSessionTemplateOne.insert("insertRoleUser", roleUser);
    }


    /**
     * 修改某个角色用户关联信息
     * @param roleUser 角色用户信息关联类
     * @return 修改结果 0 or 1
     */
    public int updateRoleUser(RoleUser roleUser){
        return sqlSessionTemplateOne.insert("updateRoleUser", roleUser);
    }



    /**
     * 删除指定主键的角色用户关联信息
     * @param id
     * @return
     */
    public int deleteRoleUserById(String id){
        return sqlSessionTemplateOne.delete("deleteRoleUserById",id);
    }

    public int deleteRoleUserByCondition(String id, String userId, String roleId){
        Map<String, Object> param = new HashMap<>();
        param.put("id",id);
        param.put("userId",userId);
        param.put("roleId",roleId);
        return sqlSessionTemplateOne.delete("deleteRoleUserByCondition",param);
    }
}
