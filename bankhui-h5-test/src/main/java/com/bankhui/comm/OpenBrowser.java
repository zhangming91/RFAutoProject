package com.bankhui.comm;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


/**
*  浏览器的选择
* @author liuyang
* @time 2017年6月29日下午3:20:00
*       
*/ 
public class OpenBrowser {
	
	// 创建一个 FireFox 的浏览器实例
	private static WebDriver driver;
	
	
	/**
	* 打开浏览器 （默认是火狐低版本浏览器）
	* @author liuyang
	* @time 2017年6月29日下午3:33:08
	* @return WebDriver     
	*/ 
	public static WebDriver open(){
		String type = StaticResource.getBrowser();
		if("IE".equals(type)){
			setupIE();
		}else if("GOOGLE".equals(type)){
			setupGoogle();
		}else{
			setupFireFox();
		}
		driver = new FirefoxDriver();
        // 设置浏览器为手机模式
        driver.manage().window().setSize(new Dimension(430, 709));
        return driver;
	}
	
	/**
	* 访问地址
	* @author liuyang
	* @time 2017年6月29日下午3:34:09
	* @param path 访问的地址 <br> eg: https://www.baidu.com</br>    
	*/ 
	public static void VisitPath(String path){
		 driver.get(path);
	}
	// 设置火狐浏览器
	private static void setupFireFox(){
		// 如果你的 FireFox 没有安装在默认目录，那么必须在程序中设置
		System.setProperty("webdriver.firefox.marionette", 
				"C:\\Program Files (x86)\\Mozilla Firefox\\geckodriver.exe");
	}
	// 设置IE浏览器
	private static void setupIE(){
		// 如果你的 FireFox 没有安装在默认目录，那么必须在程序中设置
		//System.setProperty("webdriver.firefox.marionette", 
				//"C:\\Program Files (x86)\\Mozilla Firefox\\geckodriver.exe");
	}
	// 设置google浏览器
	private static void setupGoogle(){
		// 如果你的 FireFox 没有安装在默认目录，那么必须在程序中设置
		System.setProperty("webdriver.chrome.driver", 
				"/Users/sunny/workspace/project/libs/chromedriver");
	}
	
	public static WebDriver getDriver() {
		return driver;
	}

	public static void setDriver(WebDriver driver) {
		OpenBrowser.driver = driver;
	}
	
}
