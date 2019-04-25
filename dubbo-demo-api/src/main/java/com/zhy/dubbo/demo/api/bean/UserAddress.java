package com.zhy.dubbo.demo.api.bean;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserAddress implements Serializable {
	 
	private static final long serialVersionUID = -826352141216238338L;
	
	private Integer id;
	private String userAddress;	//用户地址
	private String userId;		//用户ID
	private String consignee;	//收货人
	private String phoneNum;	//电话号码
	private String isDefault;	//是否为默认地址，Y-是，N-否

}
