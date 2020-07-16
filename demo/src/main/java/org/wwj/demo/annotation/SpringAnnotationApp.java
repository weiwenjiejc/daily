package org.wwj.demo.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.wwj.demo.annotation.service.DemoService;

public class SpringAnnotationApp {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ApplicationContext applicationContext;
        applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        DemoService demoService;
        demoService = applicationContext.getBean(DemoService.class);
        demoService.demo();
    }

}
