package org.wwj.demo.spring.jdbc;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

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

    }
}
