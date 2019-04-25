package com.zhy.dubbo.demo.service.impl;

import java.util.Arrays;
import java.util.List;

import com.zhy.dubbo.demo.api.bean.UserAddress;
import com.zhy.dubbo.demo.api.service.UserService;

public class UserServiceImpl2 implements UserService {

	@Override
	public List<UserAddress> getUserAddressList(String userId) {
		
		System.out.println("version > 2");

		UserAddress address1 = new UserAddress(1, "北京市昌平区宏福科技园综合楼3层", "1", "李老师", "010-56253825", "Y");
		UserAddress address2 = new UserAddress(2, "深圳市宝安区西部硅谷大厦B座3层（深圳分校）", "1", "王老师", "010-56253825", "N");

		return Arrays.asList(address1,address2);
	}

}