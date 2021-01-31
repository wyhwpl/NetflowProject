package com.netflow.mapper;

import com.netflow.bean.User;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author 汪培林
 * @data 2020-12-24  17:21:03
 */
@Repository
public class UserMapper {

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
     * 分页查询所有用户信息
     * @return 用户信息列表
     */
    public List<User> getAllUser(Integer page, Integer limit){
        /*List<Map<String, Object>> maps = jdbcTemplate.queryForList("select * from authority.user");
        maps.stream().forEach(x->{
            Set<Map.Entry<String, Object>> entries = x.entrySet();

            for (Map.Entry<String, Object> entry : entries) {
                System.out.println(entry.getKey()+":"+entry.getValue());
            }

            System.out.println("--------------------------------------");

        });*/
        Map<String, Object> param = new HashMap<>();
        param.put("page",page);
        param.put("limit",limit);
        return sqlSessionTemplateOne.selectList("getUserList",param);
    }

    /**
     * 通过主键查询用户
     * @param id
     * @return
     */
    public User getUserById(String id){
        return sqlSessionTemplateOne.selectOne("getUserById",id);
    }

    /**
     * 根据关键词分页查询所有用户信息
     * @return 用户信息列表
     */
    public List<User> getUserByKey(Integer page, Integer limit,String keyword){
        Map<String, Object> param = new HashMap<>();
        param.put("page",page);
        param.put("limit",limit);
        param.put("keyword",keyword);
        return sqlSessionTemplateOne.selectList("getUserByKey",param);
    }

    /**
     * 插入某个用户信息
     * @param user 用户信息实体类
     * @return 插入结果 0 or 1
     */
    public int insertUser(User user){
        return sqlSessionTemplateOne.insert("insertUser", user);
    }


    /**
     * 插入某个用户信息
     * @param user 用户信息实体类
     * @return 插入结果 0 or 1
     */
    public int updateUser(User user){
        return sqlSessionTemplateOne.insert("updateUser", user);
    }


    /**
     *
     * 通过用户名查询用户信息
     * @param username 用户名
     * @return 用户信息
     */
    public User queryUserByUsername(String username){
        return sqlSessionTemplateOne.selectOne("getUserByUsername",username);
    }

    /**
     * 删除指定主键的用户信息
     * @param id
     * @return
     */
    public int deleteUserById(String id){
        return sqlSessionTemplateOne.delete("deleteUserById",id);
    }

    /**
     * 获取用户数量
     * @return
     */
    public Long getUserCount(){
        return sqlSessionTemplateOne.selectOne("count");
    }

    /**
     * 根据条件获取用户数量
     * @return
     */
    public Long getUserCountByKey(String keyword){
        return sqlSessionTemplateOne.selectOne("countByKey",keyword);
    }
}
