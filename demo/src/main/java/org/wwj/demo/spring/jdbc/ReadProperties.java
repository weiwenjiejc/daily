package org.wwj.demo.spring.jdbc;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Component;

/**
 * 从配置文件中读取内容到类中
 */
@Component
@PropertySource("classpath:test.properties")
//@ConfigurationProperties(prefix = "user")
public class ReadProperties {


    @Value("${username}")
    public String username;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
