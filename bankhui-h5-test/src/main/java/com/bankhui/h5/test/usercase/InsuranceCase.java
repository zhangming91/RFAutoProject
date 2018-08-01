package com.bankhui.h5.test.usercase;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.bankhui.comm.OpenBrowser;
import com.bankhui.comm.StaticResource;
import com.bankhui.h5.test.service.login.LoginTest;
import com.bankhui.h5.test.service.logout.LogoutTest;
import com.bankhui.h5.test.service.product.insurance.InsuranceTest;

/**
* 
* @author liuyang
* @time 2017年7月11日下午4:51:57
*       
*/ 
public class InsuranceCase {
	
	private static Logger log = Logger.getLogger(InsuranceCase.class);

	public static void main(String[] args) {
		new InsuranceCase().insuranceCaseByProduct();
		
	}
	
	/**
	* 保险用例
	* </br>
	* </br>1.打开浏览器
	* </br>2.设置访问的地址
	* </br>3.保险操作
	* </br>4.登陆
	* </br>5.保险操作
	* </br>6.下一步确认
	* </br>7.设置投保人信息
	* </br>8.设置被保人信息
	* </br>9.提交
	* </br>10.转入支付宝付款
	* </br>11.返回我的
	* </br>12.退出
	* @author liuyang
	* @time 2017年7月11日下午5:29:05       
	*/ 
	public boolean insuranceCaseByProduct(){
		
		log.info("insurance case start......");
		// 打开浏览器
		WebDriver driver = OpenBrowser.open();
		
		try{
	        // 设置访问的地址
	        OpenBrowser.VisitPath(StaticResource.getTestPath() +"index.html");
	        
	        // 实例化产品中的 保险对象
	        InsuranceTest pt = new InsuranceTest(driver);
	        
	        // 保险操作
	        pt.insuranceOperationByProduct();
	        
	        // 实例化登陆对象
	        LoginTest lt = new LoginTest(driver);
	        // 登陆
	        lt.login();
	        
	        // 保险操作
	        pt.insuranceOperationByProduct();
	        
	        operation(driver, pt);
	        return true;
		}catch(Exception e){
			log.error("Handle insurance case error ----->>>>", e);
			return false;
		}finally{
			//关闭浏览器
			driver.close();
		}
        
	}

	/**
	* 具体操作
	* @author liuyang
	* @time 2017年7月24日上午10:32:21
	* @param driver
	* @param pt       
	*/ 
	private void operation(WebDriver driver, InsuranceTest pt) {
		// 下一步
		pt.next();
		
		// 设置投保人信息
		pt.setInsurePeople("其他");
		
		// 设置被保人信息
		pt.setInsuredPeople();
		
		// 提交
		pt.submitBeaseInfo();
		
		// 提交支付宝
		pt.pay();
		
		// 返回我的保险
		pt.backMy(2);
		
		// 返回首页
		pt.back();
		
		//退出
		LogoutTest logout = new LogoutTest(driver);
		logout.logout();
	}
	/**
	 * 保险用例
	 * </br>
	 * </br>1.打开浏览器
	 * </br>2.设置访问的地址
	 * </br>3.保险操作
	 * </br>4.登陆
	 * </br>5.保险操作
	 * </br>6.下一步确认
	 * </br>7.设置投保人信息
	 * </br>8.设置被保人信息
	 * </br>9.提交
	 * </br>10.转入支付宝付款
	 * </br>11.返回我的
	 * </br>12.退出
	 * @author liuyang
	 * @time 2017年7月11日下午5:29:05       
	 */ 
	public boolean insuranceCaseByIndex(){
		
		log.info("insurance case start......");
		// 打开浏览器
		WebDriver driver = OpenBrowser.open();
		
		try{
			// 设置访问的地址
			OpenBrowser.VisitPath(StaticResource.getTestPath() +"index.html");
			
			// 实例化产品中的 保险对象
			InsuranceTest pt = new InsuranceTest(driver);
			
			// 保险操作
			pt.insuranceOperationByIndex();
			
			// 实例化登陆对象
			LoginTest lt = new LoginTest(driver);
			// 登陆
			lt.login();
			
			// 保险操作
			pt.insuranceOperationByIndex();
			
			operation(driver, pt);
			return true;
		}catch(Exception e){
			log.error("Handle insurance case error ----->>>>", e);
			return false;
		}finally{
			//关闭浏览器
			driver.close();
		}
		
	}

}
