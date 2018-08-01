package com.bankhui.comm;

import com.bankhui.sys.bean.UserBean;


/**
*  获取当前用户
* @author liuyang
* @time 2017年7月19日上午10:07:33
*       
*/ 
public class CurrentUser{

	private static ThreadLocal<UserBean> mylocal = new ThreadLocal<UserBean>();
	
	public static UserBean get() {
		return mylocal.get();
	}
	public static void set(UserBean value) {
		mylocal.set(value);
	}
	public static void remove() {
		mylocal.remove();
	}

}
