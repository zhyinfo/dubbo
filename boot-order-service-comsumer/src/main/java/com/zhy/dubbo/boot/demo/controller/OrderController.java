package com.zhy.dubbo.boot.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zhy.dubbo.demo.api.bean.UserAddress;
import com.zhy.dubbo.demo.api.service.OrderService;

@RestController
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@RequestMapping("/initOrder")
	public List<UserAddress> initOrder(String userId){
		return orderService.initOrder(userId);
	}

}
