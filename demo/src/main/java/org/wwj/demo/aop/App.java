package org.wwj.demo.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import demo.daily.aop.annotation.controller.DemoController;

public class App {

	public static void main(String[] args) {
		System.out.println("main");
		String[] configLocations = new String[] { "classpath:spring-aop-annotation.xml" };
		ApplicationContext app = new ClassPathXmlApplicationContext(configLocations);
		DemoController demoController = app.getBean(DemoController.class);
		demoController.demo();
	}

}
