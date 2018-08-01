package com.bankhui.comm;

import org.apache.log4j.Logger;

/**
* 身份证正反面获取
* @author liuyang
* @time 2017年7月12日下午3:27:12
*       
*/ 
public class ImgUtil {
	private static Logger log = Logger.getLogger(ImgUtil.class);
	
	/**
	* 身份证正面获取
	* @author liuyang
	* @time 2017年7月12日下午3:27:33
	* @return  path  
	*/ 
	public static String getImg_left(){
		String str = "";
		try {
			str = ImgUtil.class.getResource("/img/123.png").toString();
			return str;
		} catch (Exception e) {
			log.error("Not find 123.png --->>>", e);
			return "";
		}
	}
	/**
	* 身份证反面获取
	* @author liuyang
	* @time 2017年7月12日下午3:27:33
	* @return  path  
	*/
	public static String getImg_right(){
		String str = "";
		try {
			str = ImgUtil.class.getResource("/img/456.png").toString();
			return str;
		} catch (Exception e) {
			log.error("Not find 456.png --->>>", e);
			return "";
		}
	}
	
	
	public static void main(String[] args) {
		String str = ImgUtil.class.getResource("/img/123.png").toString();
		System.out.println(str);
	}
}
