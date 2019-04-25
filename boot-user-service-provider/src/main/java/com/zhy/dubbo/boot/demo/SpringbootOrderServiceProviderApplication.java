package com.zhy.dubbo.boot.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.ImportResource;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;

/**
 * 1、导入依赖：
 * 		1）、导入dubbo-starter
 * 		2）、导入dubbo其他相关依赖
 * 2、在application.properties中配置dubbo项
 * 3、使用@com.alibaba.dubbo.config.annotation.Service注解暴露服务
 * 4、在主程序中开启基于注解的dubbo功能 @EnableDubbo 或者直接在application.properties中配置dubbo.scan.base-packages=xxx
 * 
 * 
 * springboot与dubbo整合的三种方式
 * 	1)、导入dubbo-starter，在application.properties中配置dubbo项，使用@service注解暴露服务，使用@reference注解引用服务，使用@EnableDubbo扫描包
 * 	2)、导入dubbo-starter，保留dubbo的xml配置文件，在启动类上通过@ImportResource注解引入该xml配置文件
 * 	3)、使用注解API : com.zhy.dubbo.boot.demo.config.DubboConfig
 * 		将每个组件手动创建到容器中，并让dubbo来扫描其他组件(@EnableDubbo)
 */
@EnableHystrix
//@EnableDubbo //使用@EnableDubbo注解或者在配置文件中配置dubbo.scan.base-packages=com.zhy.dubbo.boot.demo.service.impl
@ImportResource(locations="classpath:provider.xml")
@SpringBootApplication
public class SpringbootOrderServiceProviderApplication {
	
	public static void main(String[] args) {
		
		SpringApplication.run(SpringbootOrderServiceProviderApplication.class, args);
	}

}
