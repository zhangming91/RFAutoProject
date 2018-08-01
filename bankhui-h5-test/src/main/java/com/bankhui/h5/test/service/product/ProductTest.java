package com.bankhui.h5.test.service.product;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.bankhui.comm.Labeloperation;
import com.bankhui.comm.OpenBrowser;
import com.bankhui.comm.Slide;
import com.bankhui.comm.StaticResource;
import com.bankhui.h5.test.BaseOperation;

/**
* 产品列表
* @author liuyang
* @time 2017年6月29日下午3:57:47
*       
*/ 
public abstract class ProductTest extends BaseOperation{

	public ProductTest(WebDriver driver) {
		super(driver);
	}

	
	/**
	* 返回我的
	* @author liuyang
	* @time 2017年7月12日上午10:08:02       
	*/ 
	public void backMy(int count){
		
		// 返回到我的
		OpenBrowser.VisitPath(StaticResource.getTestPath() +"views/protal/my_account.html");
		// 进入我的贷款
		WebElement webElement = Labeloperation.getUL(this.getDriver(), "my-list1", count);
		webElement.click();
		
        Slide.pause(5);
        
	}
	// 打开产品
	public void openProduct(){
		Slide.pause(2);
		this.getDriver().findElement(By.id("a2")).click();
	}
	/**
	* 产品选择
	* @author liuyang
	* @time 2017年7月11日下午1:49:06
	*/ 
	public abstract void choiceProduct();
	
	/**
	*  浏览器的back
	* @author liuyang
	* @time 2017年7月13日上午11:41:39       
	*/ 
	public void webBack(){
		this.getDriver().navigate().back();
	}
}
