package org.wwj.demo.spring.jdbc;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:test.properties")
//@ConfigurationProperties(prefix = "user")
public class ReadProperties {
}
