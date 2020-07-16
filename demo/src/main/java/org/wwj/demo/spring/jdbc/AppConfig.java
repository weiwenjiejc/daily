package org.wwj.demo.spring.jdbc;


import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.ImportResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @ImportResource
 * 导入一个传统的xml配置文件
 */

@Configurable
@ImportResource(locations = {"classpath:spring-jdbc.xml"})
@ComponentScan(basePackages = "org.wwj.demo.spring.jdbc")
public class AppConfig {

    @Bean("oracleJdbcTemplate")
    public JdbcTemplate jdbcTemplate(@Qualifier("oracleDataSource") DataSource dataSource){

        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
        return jdbcTemplate;

    }

    /*配置spring事务管理器*/
    @Bean
    public DataSourceTransactionManager dataSourceTransactionManager(@Qualifier("oracleDataSource") DataSource dataSource){
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
        transactionManager.setDataSource(dataSource);
        return transactionManager;
    }
}
