package com.bankhui.zz.test.service.my;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.util.Assert;

import com.bankhui.comm.Slide;

/**
* 我的二维码
* @author liuyang
* @time 2017年8月21日下午5:27:20
*       
*/ 
public class MyCode extends MyOperation {

	public MyCode(WebDriver driver) {
		super(driver);
	}

	// 我的二维码
	public void clickCode(){
		this.choice(0).click();
		WebElement we =  this.getDriver().findElement(By.className("shareAlert"));
		Slide.pause(2);
		Assert.isTrue(we.isDisplayed());
	}
}
