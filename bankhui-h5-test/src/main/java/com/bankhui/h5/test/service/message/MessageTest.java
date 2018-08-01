package com.bankhui.h5.test.service.message;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.bankhui.comm.Labeloperation;
import com.bankhui.comm.Slide;
import com.bankhui.h5.test.BaseOperation;

/**
* 消息测试类
* @author liuyang
* @time 2017年7月21日上午10:32:04
*       
*/ 
public class MessageTest extends BaseOperation{

	public MessageTest(WebDriver driver) {
		super(driver);
	}
	
	// 点击消息
	public void openMessage(){
		Slide.pause(2);
		WebElement webElement = this.getDriver().findElement(By.className("index-news")).findElement(By.tagName("a"));
		webElement.click();
		Slide.pause(3);
	}
	
	
	// 选择消息
	public void choiceMessage() {
		// 进入我的消息
		WebElement webElement = Labeloperation.getUL(this.getDriver(), "my-list2", 0);
		webElement.click();
		Slide.pause(3);
	}
	// 查看 第一个消息
	public void readMessage(){
		List<WebElement> webElements = this.getDriver().findElement(By.className("my_news-list"))
				.findElements(By.tagName("a"));
		WebElement webElement = webElements.get(0); 
		webElement.click();
		Slide.pause(2);
	}
	// 消息推送
	public void pushMessage(){
		List<WebElement> webElements = this.getDriver().findElement(By.className("my_news-nav"))
				.findElements(By.tagName("p"));
		WebElement webElement = webElements.get(1); 
		webElement.click();
		Slide.pause(2);
	}
	// 公告
	public void notice(){
		List<WebElement> webElements = this.getDriver().findElement(By.className("my_news-nav"))
				.findElements(By.tagName("p"));
		WebElement webElement = webElements.get(2); 
		webElement.click();
		Slide.pause(2);
	}
	
}
