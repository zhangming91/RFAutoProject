package com.bankhui.comm;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
* 标签的基本操作
* @author liuyang
* @time 2017年7月11日上午11:42:14
*       
*/ 
public class Labeloperation {

	private static Logger log = Logger.getLogger(Labeloperation.class);
	
	public final static String xpath = "xpath";
	
	public final static String frame = "frame";
	
	public final static String tagName = "tagName";
	
	public final static String className = "className";
	
	public final static String id = "id";
	
	public final static String name = "name";
	
	/**
	*  判断是否存在此元素
	* @author liuyang
	* @time 2017年7月6日下午2:56:33
	* @param driver 驱动
	* @param type 类型  xpath or frame or tagName
	* @return true=存在 or false=不存在  
	*/ 
	public static boolean doesWebElementExist(String xpath, WebDriver driver, String type) { 
        try { 
        	if(type.equals(xpath)){
        		driver.findElement(By.xpath(xpath)); 
        	}
        	if(type.equals(frame)){
        		driver.switchTo().frame(xpath);
        	}
        	if(type.equals(tagName)){
        		driver.findElement(By.tagName("h4"));
        	}
        	if(type.equals(className)){
        		driver.findElement(By.className(xpath));
        	}
        	if(type.equals(name)){
        		driver.findElement(By.name(name));
        	}
        	if(type.equals(id)){
        		driver.findElement(By.id(id));
        	}
              return true; 
        } catch (Exception e) { 
        	log.error("-----Not Find " + xpath + " Element-----");
              return false; 
        } 
    }
	
	/**
	* 根据div获取ul里面li里面a标签里面的内容
	* @author liuyang
	* @time 2017年7月11日下午1:40:25
	* @param webDriver 驱动
	* @param divClass div的样式
	* @param count 获取第几个li, 下标从0开始
	* @return WebElement      
	*/ 
	public static WebElement getUL(WebDriver webDriver ,String divClass, int count){
		
		List<WebElement> webElements = webDriver.findElement(By.className(divClass)).
				findElement(By.tagName("ul")).findElements(By.tagName("li"));
		WebElement webElement = webElements.get(count).findElement(By.tagName("a")); 
		return webElement;
	}
	/**
	* 根据div获取ul里面li的内容
	* @author liuyang
	* @time 2017年7月11日下午1:40:25
	* @param webDriver 驱动
	* @param divClass div的样式
	* @param count 获取第几个li, 下标从0开始
	* @return WebElement      
	*/
	public static WebElement getLi(WebDriver webDriver ,String divClass, int count){
		
		List<WebElement> webElements = webDriver.findElement(By.className(divClass)).
				findElement(By.tagName("ul")).findElements(By.tagName("li"));
		WebElement webElement = webElements.get(count); 
		return webElement;
	}
	
	/** 
     * 切换窗口（当前窗口为2个） 
     * @param driver 
     */  
    public static void changeWindow(WebDriver driver) {  
        String currentWindow = driver.getWindowHandle();// 获取当前窗口句柄  
        Set<String> handles = driver.getWindowHandles();// 获取所有窗口句柄  
        log.info("当前窗口数量：" + handles.size());  
        Iterator<String> it = handles.iterator();  
        while (it.hasNext()) {  
            if (currentWindow == it.next()) {  
                continue;// 跳出本次循环，继续下个循环  
            }  
            try {  
                WebDriver window = driver.switchTo().window(it.next());// 切换到新窗口  
                log.info("New page title is:" + window.getTitle());  
                window.close();//关闭当前焦点所在的窗口  
            } catch (Exception e) {  
                log.info("无法切换至新打开的窗口");  
                log.info(e.getMessage());  
            }  
        }  
         driver.switchTo().window(currentWindow);//回到原来页面  
    }  
}
