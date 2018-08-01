package com.bankhui.zz.test.service.follow;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.bankhui.comm.Slide;
import com.bankhui.zz.test.BaseOperation;

/**
*  跟进
* @author liuyang
* @time 2017年8月21日下午5:11:15
*       
*/ 
public class FollowUpTest extends BaseOperation {

	public FollowUpTest(WebDriver driver) {
		super(driver);
	}

	// 选择操作
	public WebElement choice(int count) {
		WebElement we = this.getDriver()
				.findElement(By.className("mui-content"))
				.findElements(By.tagName("span")).get(count);
		return we;
	}
	// 申请中
	public void registering(){
		choice(0).click();
		Slide.slideDown(this.getDriver(), 3);
	}
	// 已放款
	public void loaned(){
		choice(1).click();
		Slide.slideDown(this.getDriver(), 3);
	}
	// 已失败
	public void failed(){
		choice(2).click();
		Slide.slideDown(this.getDriver(), 3);
	}
}
