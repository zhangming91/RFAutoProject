package com.bankhui.zz.test.service.index;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.util.Assert;

import com.bankhui.comm.Slide;
import com.bankhui.zz.test.BaseOperation;

/**
*  分享操作
* @author liuyang
* @time 2017年8月21日下午4:37:43
*       
*/ 
public class ShareOperation extends BaseOperation {

	public ShareOperation(WebDriver driver) {
		super(driver);
	}
	
	// 分享给客户经理
	public void shareCusmanager(){
		this.getDriver().findElement(By.className("shareCusmanager")).click();
		Slide.pause(2);
		WebElement we = this.getDriver().findElement(By.className("shareAlert"));
		Assert.isTrue(we.isDisplayed());
	}
	
	// 分享给客户
	public void shareCustomer(){
		this.getDriver().findElement(By.className("shareCustomer")).click();
		Slide.pause(2);
		WebElement we = this.getDriver().findElement(By.className("shareAlert"));
		Assert.isTrue(we.isDisplayed());
	}
}
