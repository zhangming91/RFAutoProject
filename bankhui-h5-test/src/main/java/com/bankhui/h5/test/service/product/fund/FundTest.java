package com.bankhui.h5.test.service.product.fund;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.bankhui.comm.Labeloperation;
import com.bankhui.h5.test.service.product.ProductTest;

/**
* 基金测试
* @author liuyang
* @time 2017年7月11日下午1:57:24
*       
*/ 
public class FundTest extends ProductTest {

	public FundTest(WebDriver driver) {
		super(driver);
	}

	@Override
	public void choiceProduct() {
		WebElement webElement = Labeloperation.getUL(this.getDriver(), "class-list", 1);
		webElement.click();
	}

	@Override
	public void back() {
		// TODO Auto-generated method stub
		
	}

}
