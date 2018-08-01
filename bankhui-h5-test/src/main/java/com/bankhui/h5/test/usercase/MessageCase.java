package com.bankhui.h5.test.usercase;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.bankhui.comm.OpenBrowser;
import com.bankhui.comm.StaticResource;
import com.bankhui.h5.test.service.login.LoginTest;
import com.bankhui.h5.test.service.logout.LogoutTest;
import com.bankhui.h5.test.service.message.MessageTest;

/**
* 消息测试用例
* @author liuyang
* @time 2017年7月21日上午11:37:08
*       
*/ 
public class MessageCase {
	
	
	public static void main(String[] args) {
		new MessageCase().messageCaseByMy();
	}

	private static Logger log = Logger.getLogger(MessageCase.class);

	public boolean messageCaseByMy(){
		log.info("insurance case start......");
		// 打开浏览器
		WebDriver driver = OpenBrowser.open();
		try {
			// 设置访问的地址
	        OpenBrowser.VisitPath(StaticResource.getTestPath() +"index.html");
			
	        MessageTest mt = new MessageTest(driver);
	        
	        //从我的进入消息
	        openMessageByMy(driver, mt);
	        
	        
	        return true;
		}catch(Exception e){
			log.error("Handle message case error ----->>>>", e);
			return false;
		}finally{
			//关闭浏览器
			driver.close();
		}
	}
	public boolean messageCaseByIndex(){
		log.info("insurance case start......");
		// 打开浏览器
		WebDriver driver = OpenBrowser.open();
		try {
			// 设置访问的地址
			OpenBrowser.VisitPath(StaticResource.getTestPath() +"index.html");
			
			MessageTest mt = new MessageTest(driver);
			
			//从首页进入消息
			openMessageByIndex(driver, mt);
			
			return true;
		}catch(Exception e){
			log.error("Handle message case error ----->>>>", e);
			return false;
		}finally{
			//关闭浏览器
			driver.close();
		}
	}

	/**
	*  从我的进入消息中心
	* @author liuyang
	* @time 2017年7月21日下午4:28:31
	* @param driver
	* @param mt       
	*/ 
	private void openMessageByMy(WebDriver driver, MessageTest mt) {
		//打开我的
		mt.openMy();
		
		//点击消息
		mt.choiceMessage();
		
		// 实例化登陆对象
		LoginTest lt = new LoginTest(driver);
		// 登陆
		lt.login();
		
		//打开我的
		mt.openMy();
		
		//点击消息
		mt.choiceMessage();
		
		//具体操作
		operation(driver, mt);
	}
	
	/**
	* 从首页进入消息
	* @author liuyang
	* @time 2017年7月21日下午4:35:04
	* @param driver
	* @param mt       
	*/ 
	private void openMessageByIndex(WebDriver driver, MessageTest mt) {
		//打开消息
		mt.openMessage();
		
		// 实例化登陆对象
		LoginTest lt = new LoginTest(driver);
		// 登陆
		lt.login();
		
		//点击消息
		mt.openMessage();
		
		//具体操作
		operation(driver, mt);
	}
	/**
	*  具体操作
	* @author liuyang
	* @time 2017年7月21日下午4:30:02
	* @param driver
	* @param mt       
	*/ 
	private void operation(WebDriver driver, MessageTest mt) {
		//查看第一个消息
		mt.readMessage();
		
		//系统返回
		mt.back();
		
		//选择推送
		mt.pushMessage();
		
		//查看第一个消息
		mt.readMessage();
		
		//系统返回
		mt.back();
		
		//查看公告
		mt.notice();
		
		//查看第一个消息
		mt.readMessage();
		
		//系统返回
		mt.back();
		
		//系统返回
		mt.back();
		
		//退出
		LogoutTest logout = new LogoutTest(driver);
		logout.logout();
	}
}
