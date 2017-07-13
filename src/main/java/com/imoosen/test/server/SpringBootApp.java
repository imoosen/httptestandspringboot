package com.imoosen.test.server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by Administrator on 2017/6/20.
 */
@ComponentScan(basePackages = "com.imoosen.test")
@MapperScan(basePackages = "com.imoosen.test.dao")
@EnableAutoConfiguration
public class SpringBootApp {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootApp.class,args);
    }
}
