package com.bankhui.zz.test.service.my;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.bankhui.comm.Labeloperation;
import com.bankhui.zz.test.BaseOperation;

/**
* 我的基本操作
* @author liuyang
* @time 2017年8月21日下午5:21:09
*       
*/ 
public class MyOperation extends BaseOperation {

	public MyOperation(WebDriver driver) {
		super(driver);
	}
	
	// 选择第几个，从0开始
	public WebElement choice(int count){
		return Labeloperation.getUL(this.getDriver(), "my-list1", count);
	}
}
