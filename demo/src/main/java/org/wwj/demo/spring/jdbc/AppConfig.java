package org.wwj.demo.spring.jdbc;


import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.ImportResource;

/**
 * @ImportResource
 * 导入一个传统的xml配置文件
 */

@Configurable
@ImportResource(locations = {"classpath:spring-jdbc.xml"})
public class AppConfig {

}
