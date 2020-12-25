package com.netflow.datasource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * @author 汪培林
 * @data 2020-12-24  16:08:42
 */
@Configuration
//@MapperScan(basePackages = "com.netflow.mapper")
public class SourceOneConfig {

    @Bean("datasourceOne")
    @ConfigurationProperties(prefix = "spring.datasource.one")
    public DataSource getDataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean("factoryOne")
    public SqlSessionFactory getSqlSessionFactory(@Qualifier("datasourceOne") DataSource dataSource) throws Exception {

        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:mapper/*.xml"));

        return factoryBean.getObject();

    }

    @Bean("templateOne")
    public SqlSessionTemplate getTemplate(@Qualifier("factoryOne") SqlSessionFactory sqlSessionFactory){
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
