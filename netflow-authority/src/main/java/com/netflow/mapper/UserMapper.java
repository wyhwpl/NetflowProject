package com.netflow.mapper;

import com.netflow.bean.User;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

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
     * 查询所有用户信息
     * @return 用户信息列表
     */
    public List<User> getAllUser(){
        List<Map<String, Object>> maps = jdbcTemplate.queryForList("select * from authority.user");
        maps.stream().forEach(x->{
            Set<Map.Entry<String, Object>> entries = x.entrySet();

            for (Map.Entry<String, Object> entry : entries) {
                System.out.println(entry.getKey()+":"+entry.getValue());
            }

            System.out.println("--------------------------------------");

        });
        return sqlSessionTemplateOne.selectList("getAllUser");
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
     *
     * 通过用户名查询用户信息
     * @param username 用户名
     * @return 用户信息
     */
    public User queryUserByUsername(String username){
        return sqlSessionTemplateOne.selectOne("getUserByUsername",username);
    }

}
