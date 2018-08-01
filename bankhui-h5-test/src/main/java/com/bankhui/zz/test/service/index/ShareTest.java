package com.bankhui.zz.test.service.index;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.bankhui.comm.Slide;

/**
*  分享赚钱
* @author liuyang
* @time 2017年8月21日下午5:05:49
*       
*/ 
public class ShareTest extends ShareOperation {

	public ShareTest(WebDriver driver) {
		super(driver);
	}
	
	// 分享赚钱
	public void share(){
		this.getDriver().findElement(By.id("oImg")).click();
		Slide.pause(2);
	}
	// 去赚钱吧
	public void shareFooter(){
		this.getDriver().findElement(By.className("share-footer")).click();
		Slide.pause(2);
	}
	
}
