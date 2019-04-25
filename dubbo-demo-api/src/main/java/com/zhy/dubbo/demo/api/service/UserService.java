package com.zhy.dubbo.demo.api.service;

import java.util.List;

import com.zhy.dubbo.demo.api.bean.UserAddress;

/**   
 * @ClassName	:  UserService   
 * @Description	：  用户服务接口   
 * @author	: 	zhy
 * @date	:   2019年4月17日 上午11:46:34   
 */
public interface UserService {
	
	/**
	 * 按照用户id返回所有的收货地址
	 */
	public List<UserAddress> getUserAddressList(String userId);

}