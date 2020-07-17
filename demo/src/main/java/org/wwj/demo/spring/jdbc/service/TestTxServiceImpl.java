package org.wwj.demo.spring.jdbc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

@Service
public class TestTxServiceImpl implements TestTxService {

    @Autowired
    @Qualifier(value = "mysqlJdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    @Autowired
    @Qualifier(value = "transactionManager1")
    private DataSourceTransactionManager transactionManager;

    public void test() {

    }


    private String getDropTableSQL() {
        String sql = "drop table if exists account";
        return sql;
    }

    private String getCreateTableSQL() {

        String sql = "create table account(" +
                "aid int(8) not null," +
                "name varchar(25) not null," +
                "money decimal(10,2) not null," +
                "constraint pk1 primary key(aid)" +
                ")";
        return sql;
    }

    public void txTest1() {



        /*DataSourceTransactionManager transactionManager;
        transactionManager = applicationContext.getBean(DataSourceTransactionManager.class);*/

        //默认的事务属性
        TransactionDefinition definition = new DefaultTransactionDefinition();

        TransactionStatus transactionStatus = null;


        try {

            //开启事务
            transactionStatus = transactionManager.getTransaction(definition);

            /*执行SQL语句*/
            String dropTableSQL = getDropTableSQL();
            String createTableSQL = getCreateTableSQL();
            /*int update = jdbcTemplate.update("insert into account(name, money)values(?,?)", new Object[]{
                    "小明", 36.25
            });*/
            System.out.println("删除表格");
            int update = jdbcTemplate.update(dropTableSQL);
            System.out.println(update);
            int a = 9;
            if (a > 7)
                throw new RuntimeException("出现异常了");

            /*int update1 = jdbcTemplate.update("insert into account(name, money)values(?,?)", new Object[]{
                    "小红", 569.25
            });*/
            System.out.println("创建表格");
            int update1 = jdbcTemplate.update(createTableSQL);
            System.out.println(update1);
            //提交事务
            transactionManager.commit(transactionStatus);

        } catch (Exception e) {
            //出现异常，事务回滚
            System.out.println("事务回滚了");
            if (transactionManager == null) {
                System.out.println("transactionManager");
            }
            if (transactionStatus == null) {
                System.out.println("transactionStatus");
            }
            transactionManager.rollback(transactionStatus);
        } finally {
            System.out.println("事务结束");
        }
    }


    @Transactional
    @Override
    public void txTest() {
        /*执行SQL语句*/

        String dropTableSQL = getDropTableSQL();
        String createTableSQL = getCreateTableSQL();

        if (jdbcTemplate == null) {
            System.out.println("is null");
        }

        System.out.println("删除表格");
        int update = jdbcTemplate.update(dropTableSQL);
        System.out.println(update);


        int a = 9;
        if (a > 7)
            throw new RuntimeException("出现异常了");


        System.out.println("创建表格");
        int update1 = jdbcTemplate.update(createTableSQL);
        System.out.println(update1);

    }
}
