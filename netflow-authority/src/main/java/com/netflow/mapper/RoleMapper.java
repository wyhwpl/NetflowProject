package com.netflow.mapper;

import com.netflow.bean.Role;
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
public class RoleMapper {

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
     * 分页查询所有角色信息
     * @return 角色信息列表
     */
    public List<Role> getAllRole(Integer page, Integer limit,String appId){
        Map<String, Object> param = new HashMap<>();
        param.put("page",page);
        param.put("limit",limit);
        param.put("appId",appId);
        return sqlSessionTemplateOne.selectList("getRoleList",param);
    }

    /**
     * 通过主键查询角色
     * @param id
     * @return
     */
    public Role getRoleById(String id){
        return sqlSessionTemplateOne.selectOne("getRoleById",id);
    }

    /**
     * 根据关键词分页查询所有角色信息
     * @return 角色信息列表
     */
    public List<Role> getRoleByKey(Integer page, Integer limit,String keyword,String appId){
        Map<String, Object> param = new HashMap<>();
        param.put("page",page);
        param.put("limit",limit);
        param.put("keyword",keyword);
        param.put("appId",appId);
        return sqlSessionTemplateOne.selectList("getRoleByKey",param);
    }

    /**
     *
     * 通过角色名查询用户信息
     * @param roleName 角色名
     * @return 角色信息
     */
    public Role queryRoleByRoleName(String roleName,String appId){
        Map<String, Object> param = new HashMap<>();
        param.put("roleName",roleName);
        param.put("appId",appId);
        return sqlSessionTemplateOne.selectOne("getRoleByRoleName",param);
    }

    /**
     * 插入某个角色信息
     * @param role 信息实体类
     * @return 插入结果 0 or 1
     */
    public int insertRole(Role role){
        return sqlSessionTemplateOne.insert("insertRole", role);
    }


    /**
     * 修改某个角色信息
     * @param role 角色信息实体类
     * @return 修改结果 0 or 1
     */
    public int updateRole(Role role){
        return sqlSessionTemplateOne.insert("updateRole", role);
    }



    /**
     * 删除指定主键的角色信息
     * @param id
     * @return
     */
    public int deleteRoleById(String id){
        return sqlSessionTemplateOne.delete("deleteRoleById",id);
    }

    /**
     * 获取角色数量
     * @return
     */
    public Long getRoleCount(String appId){
        Map<String, Object> param = new HashMap<>();
        param.put("appId",appId);
        return sqlSessionTemplateOne.selectOne("countRole",param);
    }

    /**
     * 根据条件获取角色数量
     * @return
     */
    public Long getRoleCountByKey(String keyword,String appId){
        Map<String, Object> param = new HashMap<>();
        param.put("keyword",keyword);
        param.put("appId",appId);
        return sqlSessionTemplateOne.selectOne("countRoleByKey",param);
    }
}
