package com.bankhui.h5.test.usercase;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.bankhui.comm.OpenBrowser;
import com.bankhui.comm.StaticResource;
import com.bankhui.h5.test.service.login.LoginTest;
import com.bankhui.h5.test.service.logout.LogoutTest;

/**
*  登陆用例
* @author liuyang
* @time 2017年7月26日上午11:33:10
*       
*/ 
public class LoginCase {
	private static Logger log = Logger.getLogger(LoginCase.class);

	public boolean loginCase(){
		log.info("login case start......");
		// 打开浏览器
		WebDriver driver = OpenBrowser.open();
		
		try{
	        //设置访问的地址
	        OpenBrowser.VisitPath(StaticResource.getTestPath() +"index.html");
	       
	        //实例化登陆
	        LoginTest login = new LoginTest(driver);
	        
	        //点击我的
	        login.openMy();
	        
	        //点击登陆
	        login.clickLogin();
	        
	        //登陆操作
	        login.login();
	        
	        //退出
	        LogoutTest logout = new LogoutTest(driver);
	        logout.logout();
	        
	        return true;
		}catch(Exception e){
			log.error("Handle login case error ----->>>>", e);
			return false;
		}finally{
			driver.close();
		}
	}

}
