package com.zhy.dubbo.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@ImportResource(locations = "provider.xml")
@SpringBootApplication
public class UserServiceProviderApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(UserServiceProviderApplication.class, args);
	}

}
