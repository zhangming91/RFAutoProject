package com.bankhui.sys.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bankhui.comm.CurrentUser;
import com.bankhui.sys.bean.UserBean;

@EnableAutoConfiguration
@RestController
@RequestMapping("case")
public class LoginController {

	/**
	* 登陆
	* @author liuyang
	* @time 2017年7月19日上午10:53:07
	* @param name 账号
	* @param password 密码
	* @return  map
	*/ 
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public Map<String,Object> login(@RequestParam(defaultValue="")String name ,
			@RequestParam(defaultValue="")String password){
		Map<String,Object> map = new HashMap<String, Object>();
		UserBean user = new UserBean();
		if(StringUtils.equals(name, "admin-test") && StringUtils.equals(password, "test-123")){
			user.setName(name);
			CurrentUser.set(user);
			map.put("user", CurrentUser.get());
		}
		return map;
	}
	
	/**
	*  获取当前用户
	* @author liuyang
	* @time 2017年7月19日上午10:53:32
	* @return  map     
	*/ 
	@RequestMapping(value="/current", method = RequestMethod.GET)
	public Map<String,Object> current(){
		Map<String,Object> map = new HashMap<String, Object>();
		UserBean user = CurrentUser.get();
		map.put("user", user);
		return map;
	}
}
