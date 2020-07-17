package org.wwj.demo.spring.jdbc;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.wwj.demo.spring.jdbc.service.TestTxService;

import java.util.List;
import java.util.Map;


@SpringBootApplication
public class SpringBootApp {

    public static void main(String[] args) {

        ApplicationContext applicationContext;
        applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        TestTxService testTxService = applicationContext.getBean(TestTxService.class);
        testTxService.txTest();

        //TransactionManager


    }

    private static void jdbcQuery(ApplicationContext applicationContext) {
        JdbcTemplate oracleJdbcTemplate = applicationContext.getBean("oracleJdbcTemplate", JdbcTemplate.class);
        System.out.println(oracleJdbcTemplate);

        List<Map<String, Object>> mapList = oracleJdbcTemplate.queryForList("select * from dwlesb.zs23");
        System.out.println(mapList.size());

        for (Map<String, Object> objectMap : mapList) {
            System.out.println(objectMap);
        }

        JdbcTemplate jdbcTemplate = applicationContext.getBean("mysqlJdbcTemplate", JdbcTemplate.class);
    }





}
