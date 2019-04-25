package com.zhy.dubbo.boot.demo.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.zhy.dubbo.demo.api.bean.UserAddress;
import com.zhy.dubbo.demo.api.service.OrderService;
import com.zhy.dubbo.demo.api.service.UserService;

@Service
public class OrderServiceImpl implements OrderService {

//	@Autowired
//	@Reference(url="127.0.0.1:20882")	 //dubbo直连
	@Reference(loadbalance="random") //负载均衡
	UserService userService;
	
	@HystrixCommand(fallbackMethod = "processHystrix_initOrder")
	@Override
	public List<UserAddress> initOrder(String userId) {
		
		System.out.println("用户id："+userId);
		
		//1、查询用户的收货地址
		List<UserAddress> addressList = userService.getUserAddressList(userId);
		
//		addressList.forEach(System.out::println);
		
		return addressList;
	}
	
	public List<UserAddress> processHystrix_initOrder(String userId){
		return Arrays.asList(new UserAddress(10, "测试地址", "1", "测试", "测试", "Y"));
	}
	

}