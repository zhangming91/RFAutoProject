package com.bankhui.comm;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;


/**
* cookie中获取sessionId
* @author liuyang
* @time 2017年6月29日下午3:36:04
*       
*/ 
public class SessionId {
	
	public static String getJsessionIdCookie(WebDriver driver) {
		String jsId = "";
		  Set<Cookie> cookies = driver.manage().getCookies();  
	        for(Cookie cookie : cookies){
	        	if("JSESSIONID".equalsIgnoreCase(cookie.getName())){
	        		jsId = cookie.getValue();
	        	}
	        }
	        return jsId;
	}   
}
