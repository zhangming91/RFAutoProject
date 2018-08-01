package com.bankhui.h5.test.service.product.financing;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.bankhui.comm.Labeloperation;
import com.bankhui.h5.test.service.product.ProductTest;

/**
*  理财测试
* @author liuyang
* @time 2017年7月11日下午1:54:45
*       
*/ 
public class FinancingTest extends ProductTest {

	public FinancingTest(WebDriver driver) {
		super(driver);
	}

	@Override
	public void choiceProduct() {
		WebElement webElement = Labeloperation.getUL(this.getDriver(), "class-list", 0);
		webElement.click();
	}

	@Override
	public void back() {
		// TODO Auto-generated method stub
		
	}

}
