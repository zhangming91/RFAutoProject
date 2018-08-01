package com.bankhui.zz.test.service.index;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.bankhui.comm.Slide;

/**
* 首页详情
* @author liuyang
* @time 2017年8月21日下午4:31:25
*       
*/ 
public class DetailTest extends ShareOperation {

	public DetailTest(WebDriver driver) {
		super(driver);
	}

	//点击详情
	public void clickDetail(){
		this.getDriver().findElement(By.id("seeContAs")).click();
		Slide.pause(2);
	}
}
