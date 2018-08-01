package com.bankhui.comm;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;


/**静态资源
* browser.properties里面的资源
* @author Baihuijinkong
* @time 2017年7月17日下午3:55:28
*       
*/ 
public class StaticResource {

	private static Logger log = Logger.getLogger(StaticResource.class);
	
	// 浏览器类型
	private static String browser;
	// 测试地址
	private static String testPath;
	// 文件路径
	private static String filePath;
	
	static {
		Properties pps = new Properties();
		try {
			InputStream in = OpenBrowser.class.getClassLoader().getResourceAsStream("browser.properties");
			pps.load(in);
			
			browser = pps.getProperty("browser");
			testPath = pps.getProperty("test.path");
			filePath = pps.getProperty("file.path");
		} catch (IOException e) {
			log.error("未获取到browser配置文件" + e);
			e.printStackTrace();
		}
	}
	
	
	public static String getBrowser() {
		return browser;
	}

	public static void setBrowser(String browser) {
		StaticResource.browser = browser;
	}

	public static String getTestPath() {
		return testPath;
	}

	public static void setTestPath(String testPath) {
		StaticResource.testPath = testPath;
	}

	public static String getFilePath() {
		return filePath;
	}

	public static void setFilePath(String filePath) {
		StaticResource.filePath = filePath;
	}

	
}
