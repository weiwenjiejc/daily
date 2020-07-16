package org.wwj.demo.spring.jdbc;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


@SpringBootApplication
public class Main {

    public static void main(String[] args) {

        ApplicationContext applicationContext;
        applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);


    }
}
