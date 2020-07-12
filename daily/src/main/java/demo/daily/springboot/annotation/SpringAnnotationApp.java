package demo.daily.springboot.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import demo.daily.springboot.annotation.config.AppConfig;
import demo.daily.springboot.annotation.service.DemoService;

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
