package com.zhy.dubbo.boot.demo.service.impl;


import java.util.Arrays;
import java.util.List;

import com.alibaba.dubbo.config.annotation.Service;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.zhy.dubbo.demo.api.bean.UserAddress;
import com.zhy.dubbo.demo.api.service.UserService;

//@Service //暴露服务
//@Service(weight=100) //权重直接在admin控制台动态修改
@org.springframework.stereotype.Service
public class UserServiceImpl implements UserService {

	@HystrixCommand
	@Override
	public List<UserAddress> getUserAddressList(String userId) {

		UserAddress address1 = new UserAddress(1, "北京市昌平区宏福科技园综合楼3层", "1", "李老师", "010-56253825", "Y");
		UserAddress address2 = new UserAddress(2, "深圳市宝安区西部硅谷大厦B座3层（深圳分校）", "1", "王老师", "010-56253825", "N");

		if(Math.random() > 0.5) {	//使用hystrix测试服务容错
			throw new RuntimeException();
		}
		
		return Arrays.asList(address1,address2);
	}

}