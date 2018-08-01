package com.bankhui.comm;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

/**
*  滑动设置
* @author liuyang
* @time 2017年6月29日下午4:41:05
*       
*/ 
public class Slide {

	/**
	* 向下滑动设置
	* @author liuyang
	* @time 2017年6月29日下午4:41:18
	* @param driver 驱动
	* @param count 次数
	* @throws InterruptedException       
	*/ 
	public static void slideDown(WebDriver driver, int count)  {
		pause(2) ;//停顿2S
		JavascriptExecutor js = (JavascriptExecutor)driver;
		for(int i=1; i< count;  i++){
			//将页面滚动条移动到页面任意位置，改变等于号后的数值即可    
			js.executeScript("scrollTo(0,"+i*300+")");
			pause(2) ; 
		}
	}
	
	
	/**
	*  向上滑动
	* @author liuyang
	* @time 2017年7月11日上午11:40:58
	* @param driver 驱动
	* @param count count>0 按count进行滑动，count=0，直接滑动到顶端  
	*/ 
	public static void slideUp(WebDriver driver, int count){
		pause(2) ;//停顿2S
		JavascriptExecutor js = (JavascriptExecutor)driver;
		if(count > 0){
			for(int i=1; i< count;  i++){
				//将页面滚动条移动到页面任意位置，改变等于号后的数值即可    
				js.executeScript("scrollTo(0,"+(1000-i*300)+")");
				pause(2) ; 
			}
		}else{
			js.executeScript("scrollTo(0,0)");
			pause(2) ; 
		}
	}
	
	/**
	* 停顿时间
	* @author liuyang
	* @time 2017年7月7日下午3:56:20
	* @param s 单位秒     
	*/ 
	public static void pause(int s){
		try {
			Thread.sleep(s * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
