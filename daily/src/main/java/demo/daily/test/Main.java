package demo.daily.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		String[] configLocations = new String[] {"classpath:spring-aop-annotation.xml"};
		ApplicationContext app = new ClassPathXmlApplicationContext();
	}
		
}
