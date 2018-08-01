package com.bankhui.h5.test.service.product.loan;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.bankhui.comm.Labeloperation;
import com.bankhui.h5.test.service.product.ProductTest;

/**
*  贷款测试
* @author liuyang
* @time 2017年7月11日下午2:00:17
*       
*/ 
public class LoanTest extends ProductTest {

	public LoanTest(WebDriver driver) {
		super(driver);
	}

	@Override
	public void choiceProduct() {
		WebElement webElement = Labeloperation.getUL(this.getDriver(), "class-list", 3);
		webElement.click();
	}

	@Override
	public void back() {
		// 返回到我的
		this.getDriver().findElement(By.className("back")).click();
	}

}
