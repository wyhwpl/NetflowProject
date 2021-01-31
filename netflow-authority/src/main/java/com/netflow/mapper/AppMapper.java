package com.netflow.mapper;

import com.netflow.bean.AppTree;
import com.netflow.bean.Application;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 汪培林
 * @data 2020-12-24  17:21:03
 */
@Repository
public class AppMapper {

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
     * 查询所有应用信息
     * @return 应用信息列表
     */
    public List<Application> getAllApp(){
        return sqlSessionTemplateOne.selectList("getAppList");
    }

    /**
     * 查询应用信息树
     * @return 应用信息列表
     */
    public List<AppTree> getAppTree(){
        return sqlSessionTemplateOne.selectList("getAppTree");
    }


    /**
     * 通过主键查询应用
     * @param id
     * @return
     */
    public Application getAppById(String id){
        return sqlSessionTemplateOne.selectOne("getAppById",id);
    }


    /**
     * 插入某个应用信息
     * @param application 信息实体类
     * @return 插入结果 0 or 1
     */
    public int insertApp(Application application){
        return sqlSessionTemplateOne.insert("insertApp", application);
    }


    /**
     * 修改某个应用信息
     * @param application 应用信息实体类
     * @return 修改结果 0 or 1
     */
    public int updateApp(Application application){
        return sqlSessionTemplateOne.insert("updateApp", application);
    }



    /**
     * 删除指定主键的应用信息
     * @param id
     * @return
     */
    public int deleteAppById(String id){
        return sqlSessionTemplateOne.delete("deleteAppById",id);
    }

}
