package com.zhy.dubbo.boot.demo.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.MethodConfig;
import com.alibaba.dubbo.config.MonitorConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.ServiceConfig;
import com.zhy.dubbo.demo.api.service.UserService;

//@Configuration
public class DubboConfig {
	
	@Bean // <dubbo:application name="boot-user-service-provider"/>
	public ApplicationConfig applicationConfig() {
		ApplicationConfig config = new ApplicationConfig();
		config.setName("boot-user-service-provider");
		return config;
	}
	
	@Bean //<dubbo:registry protocol="zookeeper" address="120.79.135.213:2180,120.79.135.213:2181,120.79.135.213:2182"/>
	public RegistryConfig registryConfig() {
		RegistryConfig registryConfig = new RegistryConfig();
		registryConfig.setProtocol("zookeeper");
		registryConfig.setAddress("120.79.135.213:2180,120.79.135.213:2181,120.79.135.213:2182");
		return registryConfig;
	}

	@Bean //<dubbo:protocol name="dubbo" port="20880"/>
	public ProtocolConfig protocolConfig() {
		ProtocolConfig protocolConfig = new ProtocolConfig();
		protocolConfig.setName("dubbo");
		protocolConfig.setPort(20880);
		return protocolConfig;
	}
	
	//	<dubbo:service interface="com.zhy.dubbo.demo.api.service.UserService" ref="userServiceImpl" timeout="2000" version="1.0.0">
	//		<dubbo:method name="getUserAddressList" timeout="1000"/>
	//	</dubbo:service>
	@Bean
	public ServiceConfig<UserService> userServiceConfig(UserService userService){
		ServiceConfig<UserService> serviceConfig = new ServiceConfig<>();
		serviceConfig.setInterface(UserService.class);
		serviceConfig.setRef(userService);
		serviceConfig.setTimeout(2000);
		serviceConfig.setVersion("1.0.0");
		
		//配置每一个method的信息
		MethodConfig methodConfig = new MethodConfig();
		methodConfig.setName("getUserAddressList");
		methodConfig.setTimeout(1000);
		
		//将method的设置关联到service配置中
		List<MethodConfig> methods = new ArrayList<>();
		methods.add(methodConfig);
		serviceConfig.setMethods(methods);
		
		return serviceConfig;
	}
	
	@Bean // <dubbo:monitor protocol="registry"/>
	public MonitorConfig monitorConfig () {
		MonitorConfig monitorConfig = new MonitorConfig();
		monitorConfig.setProtocol("registry");
		return monitorConfig;
	}
}
