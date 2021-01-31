package com.netflow.mapper;

import com.netflow.bean.ResourceRole;
import com.netflow.bean.RoleUser;
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
public class ResourceRoleMapper {

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
    public List<ResourceRole> getAllResourceRole(){
        return sqlSessionTemplateOne.selectList("getAllResourceRole");
    }

    /**
     * 按条件查询所有角色用户关联信息
     * @return 角色用户关联信息列表
     */
    public List<ResourceRole> getAllResourceRoleByCondition(ResourceRole resourceRole){
        return sqlSessionTemplateOne.selectList("getResourceRoleByCondition", resourceRole);
    }

    /**
     * 插入某个角色用户关联信息
     * @param resourceRole 角色用户信息关联类
     * @return 插入结果 0 or 1
     */
    public int insertResourceRole(ResourceRole resourceRole){
        return sqlSessionTemplateOne.insert("insertResourceRole", resourceRole);
    }


    /**
     * 修改某个角色用户关联信息
     * @param resourceRole 角色用户信息关联类
     * @return 修改结果 0 or 1
     */
    public int updateResourceRole(ResourceRole resourceRole){
        return sqlSessionTemplateOne.insert("updateResourceRole", resourceRole);
    }



    /**
     * 删除指定主键的角色用户关联信息
     * @param id
     * @return
     */
    public int deleteResourceRoleById(String id){
        return sqlSessionTemplateOne.delete("deleteResourceRoleById",id);
    }

    public int deleteRoleUserByCondition(String id, String roleId, String resourceId, Integer resourceType){
        Map<String, Object> param = new HashMap<>();
        param.put("id",id);
        param.put("roleId",roleId);
        param.put("resourceId",resourceId);
        param.put("resourceType",resourceType);
        return sqlSessionTemplateOne.delete("deleteResourceRoleByCondition",param);
    }
}
