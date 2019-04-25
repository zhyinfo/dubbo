package com.zhy.dubbo.demo.api.service;

import java.util.List;

import org.springframework.util.StringUtils;

import com.zhy.dubbo.demo.api.bean.UserAddress;

public class UserServiceStub implements UserService {
	
	
	private UserService userService;
	
	//构造函数传入真正的远程代理对象
	public UserServiceStub(UserService userService) {
		super();
		this.userService = userService;
	}


	@Override
	public List<UserAddress> getUserAddressList(String userId) {
		System.out.println("invoked stub..");
		if(!StringUtils.isEmpty(userId)) { // 预先验证参数是否合法
			return userService.getUserAddressList(userId);
		}
		return null;
	}

}
