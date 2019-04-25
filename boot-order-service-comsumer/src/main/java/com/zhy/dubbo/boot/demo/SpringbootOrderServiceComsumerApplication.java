package com.zhy.dubbo.boot.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;

/**
 * 1、导入依赖：
 * 		1）、导入dubbo-starter
 * 		2）、导入dubbo其他相关依赖
 * 2、在application.properties中配置dubbo项
 * 3、使用@Reference注解从注册中心引用服务
 * 4、在主程序中开启基于注解的dubbo功能 @EnableDubbo
 */
@EnableHystrix
@EnableDubbo
@SpringBootApplication
public class SpringbootOrderServiceComsumerApplication {
	
	public static void main(String[] args) {
		
		SpringApplication.run(SpringbootOrderServiceComsumerApplication.class, args);
	}

}
