package com.bankhui.h5.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.bankhui.comm.Labeloperation;
import com.bankhui.comm.Slide;

/**
* 基础操作
* @author liuyang
* @time 2017年7月21日上午10:47:25
*       
*/ 
public abstract class BaseOperation {
	
	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	// 驱动
	private WebDriver driver;
	
	// 有参构造器
	public BaseOperation(WebDriver driver){
		this.driver = driver ;
	}
	
	// 打开首页
	public void openIndex(){
		Slide.pause(2);
		driver.findElement(By.id("a1")).click();
	}

	// 打开产品
	public void openProduct(){
		Slide.pause(2);
		driver.findElement(By.id("a2")).click();
	}
	// 打开我的
	public void openMy(){
		Slide.pause(2);
		driver.findElement(By.id("a3")).click();
	}
	
	// 从首页打开理财
	public void openFinancing(){
		Slide.pause(2);
		Labeloperation.getLi(driver, "index-nav", 0).click();
	}
	// 从首页打开基金
	public void openFund(){
		Slide.pause(2);
		Labeloperation.getLi(driver, "index-nav", 1).click();
	}
	// 从首页打开保险
	public void openInsurance(){
		Slide.pause(2);
		Labeloperation.getLi(driver, "index-nav", 2).click();
	}
	// 从首页打开贷款
	public void openLoan(){
		Slide.pause(2);
		Labeloperation.getLi(driver, "index-nav", 3).click();
	}
	/**
	*  浏览器的back
	* @author liuyang
	* @time 2017年7月13日上午11:41:39       
	*/ 
	public void webBack(){
		driver.navigate().back();
		Slide.pause(2);
	}
	
	/**
	* 系统返回
	* @author liuyang
	* @time 2017年7月21日上午10:59:55       
	*/ 
	public void back(){
		this.getDriver().findElement(By.className("back")).click();
		Slide.pause(2);
	}
}
