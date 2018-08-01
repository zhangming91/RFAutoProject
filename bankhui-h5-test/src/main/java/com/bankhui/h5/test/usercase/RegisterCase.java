package com.bankhui.h5.test.usercase;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.bankhui.comm.OpenBrowser;
import com.bankhui.comm.StaticResource;
import com.bankhui.h5.test.service.logout.LogoutTest;
import com.bankhui.h5.test.service.register.RegisterTest;

/**
* 注册用例
* @author liuyang
* @time 2017年7月26日上午11:32:37
*       
*/ 
public class RegisterCase {

	private static Logger log = Logger.getLogger(RegisterCase.class);
	
	public boolean registerCase(){
		log.info("register case start......");
		// 打开浏览器
        WebDriver driver = OpenBrowser.open();
		try{
			OpenBrowser.VisitPath(StaticResource.getTestPath() +"/index.html");
	        RegisterTest rt = new RegisterTest(driver);
	        rt.register();
	        
	        //退出
	        LogoutTest logout = new LogoutTest(driver);
	        logout.logout();
	        
	        return true;
		}catch(Exception e){
			log.error("Handle register  case error ----->>>>", e);
			return false;
		}finally{
			driver.close();
		}
	}
}
