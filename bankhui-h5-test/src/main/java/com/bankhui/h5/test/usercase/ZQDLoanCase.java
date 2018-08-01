package com.bankhui.h5.test.usercase;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.bankhui.comm.OpenBrowser;
import com.bankhui.comm.StaticResource;
import com.bankhui.h5.test.service.login.LoginTest;
import com.bankhui.h5.test.service.logout.LogoutTest;
import com.bankhui.h5.test.service.product.loan.ZQDLoanTest;

/**
* 中轻助业金测试用例
* @author liuyang
* @time 2017年7月27日下午2:56:45
*       
*/ 
public class ZQDLoanCase {

	private static Logger log = Logger.getLogger(ZQDLoanCase.class);

	public boolean zqdLoanCaseByProduct(){
		log.info("zqd loan case start......");
		// 打开浏览器
		WebDriver driver = OpenBrowser.open();
		
		try{
	        //设置访问的地址
	        OpenBrowser.VisitPath(StaticResource.getTestPath() +"index.html");
	        
	        //实例化跟房贷对象
	        ZQDLoanTest loan = new ZQDLoanTest(driver);
	        
	        //选择跟房贷产品操作
	        loan.zqdLoanOperationByProduct();
	        
	        //具体操作
	        operation(driver, loan);
	        return true;
		}catch(Exception e){
			log.error("Handle zqd loan case error ----->>>>", e);
			return false;
		}finally{
			driver.close();
		}
	}
	
	public boolean zqdLoanCaseByIndex(){
		log.info("zqd loan case start......");
		// 打开浏览器
		WebDriver driver = OpenBrowser.open();
		
		try{
	        //设置访问的地址
	        OpenBrowser.VisitPath(StaticResource.getTestPath() +"index.html");
	        
	        //实例化跟房贷对象
	        ZQDLoanTest loan = new ZQDLoanTest(driver);
	        
	        //选择跟房贷产品操作
	        loan.zqdLoanOperationByIndex();
	        
	        //具体操作
	        operation(driver, loan);
	        
	        return true;
		}catch(Exception e){
			log.error("Handle zqd loan case error ----->>>>", e);
			return false;
		}finally{
			driver.close();
		}
	}


	/**
	* 具体操作
	* @author liuyang
	* @time 2017年7月24日上午10:25:36
	* @param driver
	* @param loan       
	*/ 
	private void operation(WebDriver driver, ZQDLoanTest loan) {
		 //助业金产品展示
		loan.gfdLoanShow();
		
		//1秒读懂助业金
		loan.readGfd();
		
		//1秒读懂助业金展示
		loan.gfdLoanReadShow();
		
		//返回
		loan.webBack();
		
		//立即申请
		loan.applyGfd();
		
		//设置跟房贷申请信息
		loan.setApplyInfo();
		
		//阅读协议
		loan.readAgreement();
		
		//勾选协议
		loan.checkAgreement();
		
		//提交申请
		loan.submit();
		
		//返回我的贷款
		loan.backMy(3);
		
        //实例化登陆对象
        LoginTest lt = new LoginTest(driver);
        
        //登陆
        lt.login();
        
        //返回我的贷款
  		loan.backMy(3);
		
		// 返回首页
		loan.back();
		
		//退出
		LogoutTest logout = new LogoutTest(driver);
		logout.logout();
	} 
}
