package com.bankhui.zz.test.service.register;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.bankhui.comm.RedisUtils;
import com.bankhui.comm.SessionId;
import com.bankhui.comm.Slide;
import com.bankhui.h5.test.BaseOperation;

/**
* 注册测试
* @author liuyang
* @time 2017年8月18日下午2:47:58
*       
*/ 
public class RegisterTest extends BaseOperation{

	public RegisterTest(WebDriver driver) {
		super(driver);
	}

	private static Logger log = Logger.getLogger(RegisterTest.class);
	
	//点击注册
	public void clickReg(){
		// 点击注册按钮
        this.getDriver().findElement(By.className("regisBtn")).click();
	}
	
	//注册信息录入
	public void register(){
		try{
	        // 填充手机号
	        String mobile = "13439870329";
	        // 获取手机号属性名称
	        WebElement element_mobile = this.getDriver().findElement(By.name("mobile"));
	        element_mobile.sendKeys(mobile);
	        
	        // 获取验证码属性名称
	        WebElement element_vcode = this.getDriver().findElement(By.name("vcode"));
	        // 图片验证码
	        String mcode = SessionId.getJsessionIdCookie(this.getDriver())+"_codeKey";
	        mcode = RedisUtils.get(mcode);
	        element_vcode.sendKeys(mcode);
	        
	        // 点击获取手机验证码事件
	        this.getDriver().findElement(By.className("vcode-button")).click();
	        
	        // 获取手机验证码属性名称
	        WebElement element_mcode = this.getDriver().findElement(By.name("mcode"));
	        Slide.pause(3);//停顿3S，等待正式运营商发送验证码
	        // 手机验证码
	        String vcode = mobile+"_mcode";
	        vcode = RedisUtils.get(vcode);
	        element_mcode.sendKeys(vcode);
	
	        // 获取密码的属性
	        WebElement element_pw = this.getDriver().findElement(By.className("login_showText"));
	        element_pw.sendKeys("baihui123");
	        
	        // 确认密码
	        WebElement element_rpw = this.getDriver().findElement(By.xpath("//input[@name='okpassword']/parent::p")).findElement(By.className("login_showText"));
	        element_rpw.sendKeys("baihui123");
	        
	        //注册协议
//	        driver.findElement(By.className("checkbox")).click();
	        
	        WebElement element_submit = this.getDriver().findElement(By.className("registerBtn"));
	       //提交 input 所在的  form
	        element_submit.click();
	        
	        //是否到首页
	        log.info("模拟注册成功....");
		}catch(Exception e){
			log.error(e);
			log.error("模拟注册失败....---------------->>", e);
		}
        
	}
}
