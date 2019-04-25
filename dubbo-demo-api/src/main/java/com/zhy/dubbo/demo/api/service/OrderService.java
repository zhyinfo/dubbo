package com.zhy.dubbo.demo.api.service;

import java.util.List;

import com.zhy.dubbo.demo.api.bean.UserAddress;

public interface OrderService {

	/**
	 * 初始化订单
	 * @param userId
	 */
	public List<UserAddress> initOrder(String userId);
}
