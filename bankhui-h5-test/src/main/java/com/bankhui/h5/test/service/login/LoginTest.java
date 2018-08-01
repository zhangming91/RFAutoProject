package com.bankhui.h5.test.service.login;



import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.bankhui.comm.Slide;
import com.bankhui.h5.test.BaseOperation;

/**
*  登陆测试
* @author liuyang
* @time 2017年6月29日下午2:38:24
*       
*/ 
public class LoginTest extends BaseOperation{
	
	private static Logger log = Logger.getLogger(LoginTest.class);
	
	public LoginTest(WebDriver driver) {
		super(driver);
	}


	
	
	/**
	*  登陆
	* @author liuyang
	* @time 2017年7月11日下午5:00:35       
	*/ 
	public void login(){
		try{
	        Slide.pause(2);
	        // 填充手机号
	        String mobile = "13439870329";
	        // 获取手机号属性名称
	        WebElement element_mobile = this.getDriver().findElement(By.id("username"));
	        element_mobile.sendKeys(mobile);
	        
	        // 设置密码
	        WebElement element_pw = this.getDriver().findElement(By.id("password"));
	        element_pw.sendKeys("baihui123");
	        
	        // 提交登陆
	        this.getDriver().findElement(By.className("signInBtn")).click();
	        
	        Slide.pause(2);
	        
	        log.info("login success !");
		}catch(Exception e){
			log.error(e);
			log.error("登陆失败  ....---------------->>", e);
		}
		
	}
	
	// 点击登陆button
	public void clickLogin(){
		this.getDriver().findElement(By.className("touIcon")).click();
	}
}
