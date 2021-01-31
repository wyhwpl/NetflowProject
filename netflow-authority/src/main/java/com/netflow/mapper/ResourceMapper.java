package com.netflow.mapper;

import com.netflow.bean.AppTree;
import com.netflow.bean.Application;
import com.netflow.bean.Resource;
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
public class ResourceMapper {

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
     * 查询所有应用资源
     * @return 应用资源列表
     */
    public List<Resource> getAllResource(Integer page, Integer limit, String appId){
        Map<String, Object> param = new HashMap<>();
        param.put("page",page);
        param.put("limit",limit);
        param.put("appId",appId);
        return sqlSessionTemplateOne.selectList("getResourceList",param);
    }

    /**
     * 通过主键查询应用资源
     * @param id
     * @return
     */
    public Resource getResourceById(String id){
        return sqlSessionTemplateOne.selectOne("getResourceById",id);
    }


    public Resource getResourceByNameApp(String appId,String resourceName){
        Map<String, Object> param = new HashMap<>();
        param.put("appId",appId);
        param.put("resourceName",resourceName);
        return sqlSessionTemplateOne.selectOne("getResourceByNameApp",param);
    }


    /**
     * 根据关键词分页查询所有资源信息
     * @return 角色信息列表
     */
    public List<Resource> getResourceByKey(Integer page, Integer limit,String keyword,String appId){
        Map<String, Object> param = new HashMap<>();
        param.put("page",page);
        param.put("limit",limit);
        param.put("keyword",keyword);
        param.put("appId",appId);
        return sqlSessionTemplateOne.selectList("getResourceByKey",param);
    }

    /**
     * 根据条件查询所有资源信息
     * @param resource
     * @return
     */
    public List<Resource> getResourceByCondition(Resource resource){
        return sqlSessionTemplateOne.selectList("getResourceByCondition",resource);
    }

    public List<String> getResourceIdByPid(String pid){
        return sqlSessionTemplateOne.selectList("getResourceIdByPid",pid);
    }

    /**
     * 插入某个应用资源信息
     * @param resource 资源信息实体类
     * @return 插入结果 0 or 1
     */
    public int insertResource(Resource resource){
        return sqlSessionTemplateOne.insert("insertResource", resource);
    }


    /**
     * 修改某个应用资源信息
     * @param resource 应用资源信息实体类
     * @return 修改结果 0 or 1
     */
    public int updateResource(Resource resource){
        return sqlSessionTemplateOne.insert("updateResource", resource);
    }



    /**
     * 删除指定主键的应用资源信息
     * @param id
     * @return
     */
    public int deleteResourceById(String id){
        return sqlSessionTemplateOne.delete("deleteResourceById",id);
    }

    /**
     * 获取角色数量
     * @return
     */
    public Long getResourceCount(String appId){
        Map<String, Object> param = new HashMap<>();
        param.put("appId",appId);
        return sqlSessionTemplateOne.selectOne("countResource",param);
    }

    /**
     * 根据条件获取角色数量
     * @return
     */
    public Long getResourceCountByKey(String keyword,String appId){
        Map<String, Object> param = new HashMap<>();
        param.put("keyword",keyword);
        param.put("appId",appId);
        return sqlSessionTemplateOne.selectOne("countResourceByKey",param);
    }
}
