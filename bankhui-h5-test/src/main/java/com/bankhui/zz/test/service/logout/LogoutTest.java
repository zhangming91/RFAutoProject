package com.bankhui.zz.test.service.logout;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
*  退出
* @author liuyang
* @time 2017年7月11日下午4:52:59
*       
*/ 
public class LogoutTest {

	WebDriver driver;
	
	
    public LogoutTest(WebDriver driver){
    	this.driver = driver;
    }
	
	/**
	* 退出
	* @author liuyang
	* @time 2017年7月11日下午4:57:58       
	*/ 
	public void logout(){
		// 点击我的
		driver.findElement(By.id("a3")).click();
		// 点击退出
		driver.findElement(By.className("Signout_t")).click();
	}
}
