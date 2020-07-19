package org.wwj.demo.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import org.wwj.demo.aop.controller.DemoController;
import org.wwj.demo.aop.service.AopDemoService;
import org.wwj.demo.aop.service.AopDemoServiceImpl;

public class App {

	public static void main(String[] args) {
		System.out.println("main");
		String[] configLocations = new String[] { "classpath:spring-aop-annotation.xml" };
		ApplicationContext app = new ClassPathXmlApplicationContext(configLocations);
		/*DemoController demoController = app.getBean(DemoController.class);
		demoController.demo();*/

		AopDemoService aopDemoService = app.getBean(AopDemoService.class);
		aopDemoService.fun1();
	}

}
