package org.wwj.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;


@EnableTransactionManagement//相当于<tx:annotation-driven />
@SpringBootApplication
public class SpringApp {


    @Bean
    public Object testBean(PlatformTransactionManager platformTransactionManager){
        System.out.println("---------->"+platformTransactionManager.getClass().getName());
        //默认使用spring的事务管理器：org.springframework.jdbc.datasource.DataSourceTransactionManager

        return new Object();
    }

    @Bean
    public DataSource dataSource(){

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("");
        dataSource.setDriverClassName("");
        dataSource.setUsername("root");
        dataSource.setPassword("toor");
        return dataSource;

    }


    //事务管理器
    @Bean
    public PlatformTransactionManager platformTransactionManager(DataSource dataSource){
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
        transactionManager.setDataSource(dataSource);
        return transactionManager;
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext configurableApplicationContext;
        configurableApplicationContext = SpringApplication.run(SpringApp.class, args);


    }
}
