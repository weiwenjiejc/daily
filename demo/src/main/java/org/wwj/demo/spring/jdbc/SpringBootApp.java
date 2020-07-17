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
        txTest(applicationContext);


    }

    private static void jdbcQuery(ApplicationContext applicationContext) {
        JdbcTemplate oracleJdbcTemplate = applicationContext.getBean("oracleJdbcTemplate", JdbcTemplate.class);
        System.out.println(oracleJdbcTemplate);

        List<Map<String, Object>> mapList = oracleJdbcTemplate.queryForList("select * from dwlesb.zs23");
        System.out.println(mapList.size());

        for (Map<String, Object> objectMap : mapList) {
            System.out.println(objectMap);
        }
    }

    private static void txTest(ApplicationContext applicationContext) {

        JdbcTemplate jdbcTemplate = applicationContext.getBean("mysqlJdbcTemplate", JdbcTemplate.class);

        DataSourceTransactionManager transactionManager;
        transactionManager = applicationContext.getBean(DataSourceTransactionManager.class);

        //默认的事务属性
        TransactionDefinition definition = new DefaultTransactionDefinition();

        TransactionStatus transactionStatus = null;


        try {

            //开启事务
            transactionStatus = transactionManager.getTransaction(definition);

            /*执行SQL语句*/
            String dropTableSQL = getDropTableSQL();
            String createTableSQL = getCreateTableSQL();
            int update = jdbcTemplate.update(dropTableSQL);
            System.out.println(update);
            int update1 = jdbcTemplate.update(getCreateTableSQL());
            System.out.println(update1);
            //提交事务
            transactionManager.commit(transactionStatus);

        } catch (Exception e){
            //出现异常，事务回滚
            transactionManager.rollback(transactionStatus);
        }finally {
            System.out.println("事务结束");
        }
    }

    private static String getDropTableSQL(){
        String sql = "drop table if exists account";
        return sql;
    }
    private static String getCreateTableSQL() {

        String sql = "create table account(" +
                "aid int(8) not null," +
                "name varchar(25) not null," +
                "money decimal(10,2) not null," +
                "constraint pk1 primary key(aid)" +
                ")";
        return sql;
    }
}
