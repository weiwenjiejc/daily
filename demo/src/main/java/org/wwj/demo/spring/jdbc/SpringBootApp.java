package org.wwj.demo.spring.jdbc;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.util.List;
import java.util.Map;


@SpringBootApplication

public class SpringBootApp {

    public static void main(String[] args) {

        ApplicationContext applicationContext;
        applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        /*JdbcTemplate jdbcTemplate = applicationContext.getBean(JdbcTemplate.class);
        jdbcTemplate.execute("create table (uid integer )");*/

        JdbcTemplate oracleJdbcTemplate = applicationContext.getBean("oracleJdbcTemplate", JdbcTemplate.class);
        System.out.println(oracleJdbcTemplate);

        List<Map<String, Object>> mapList = oracleJdbcTemplate.queryForList("select * from dwlesb.zs23");
        System.out.println(mapList.size());

        for (Map<String, Object> objectMap : mapList) {
            System.out.println(objectMap);
        }

        DataSourceTransactionManager transactionManager;
        transactionManager = applicationContext.getBean(DataSourceTransactionManager.class);

        //默认的事务属性
        TransactionDefinition definition = new DefaultTransactionDefinition();
        
        TransactionStatus transactionStatus = null;
        

        try {

            //开启事务
            transactionStatus = transactionManager.getTransaction(definition);
            
            /*只想SQL语句*/
            getCreateTableSQL();
            //提交事务
            transactionManager.commit(transactionStatus);
            
        } catch (Exception e){
            //出现异常，事务回滚
            transactionManager.rollback(transactionStatus);
        }
        


    }

    private static String getCreateTableSQL() {

        String sql = "create table account(" +
                "aid int primary auto)"
    }
}
