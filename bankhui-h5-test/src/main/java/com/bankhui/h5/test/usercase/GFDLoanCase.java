package com.bankhui.h5.test.usercase;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.bankhui.comm.OpenBrowser;
import com.bankhui.comm.StaticResource;
import com.bankhui.h5.test.service.login.LoginTest;
import com.bankhui.h5.test.service.logout.LogoutTest;
import com.bankhui.h5.test.service.product.loan.GFDLoanTest;

/**
* 跟房贷case
* @author liuyang
* @time 2017年7月13日上午10:16:16
*       
*/ 
public class GFDLoanCase {
	
	private static Logger log = Logger.getLogger(GFDLoanCase.class);

	public static void main(String[] args) {
		new GFDLoanCase().gfdLoanCaseByProduct();
	}
	

	/**
	 * 跟房贷产品测试
	* </br>
	* </br>1.打开浏览器
	* </br>2.设置访问的地址
	* </br>3.贷款操作(1.进入产品，获取贷款页签 2.滑动浏览产品 3.选择跟房贷产品)
	* </br>4.登陆
	* </br>5.贷款操作(1.进入产品，获取贷款页签 2.滑动浏览产品 3.选择跟房贷产品 )
	* </br>6.申请贷款(1.跟房贷产品展示 2.1秒读懂跟房贷 3.1秒读懂跟房贷展示 4.返回 )
	* </br>7.立即申请(1.产看央行手册 2.滑动阅读 3.返回 4.点击申请 5.已有账号，继续申请)
	* </br>8.提交(1.添加基本信息 2.查看还款计划 3.查看央行手册 3.返回 4.添加央行信息 5.上传身份证照片 6.添加其他信息 7.查看协议 8.提交申请)
	* </br>9.返回我的查看贷款
	* </br>10.退出 
	* @author liuyang
	* @time 2017年7月13日上午10:17:07       
	*/ 
	public boolean gfdLoanCaseByProduct(){
		log.info("gfd loan case start......");
		// 打开浏览器
		WebDriver driver = OpenBrowser.open();
		
		try{
	        //设置访问的地址
	        OpenBrowser.VisitPath(StaticResource.getTestPath() +"index.html");
	        
	        //实例化跟房贷对象
	        GFDLoanTest loan = new GFDLoanTest(driver);
	        
	        //选择跟房贷产品操作
	        loan.gfdLoanOperationByProduct();
	        
	        //实例化登陆对象
	        LoginTest lt = new LoginTest(driver);
	        //登陆
	        lt.login();
	        
	        //选择跟房贷产品操作
	        loan.gfdLoanOperationByProduct();
	        
	        //具体操作
	        operation(driver, loan);
	        return true;
		}catch(Exception e){
			log.error("Handle gdf loan case error ----->>>>", e);
			return false;
		}finally{
			driver.close();
		}
	}
	
	public boolean gfdLoanCaseByIndex(){
		log.info("gfd loan case start......");
		// 打开浏览器
		WebDriver driver = OpenBrowser.open();
		
		try{
	        //设置访问的地址
	        OpenBrowser.VisitPath(StaticResource.getTestPath() +"index.html");
	        
	        //实例化跟房贷对象
	        GFDLoanTest loan = new GFDLoanTest(driver);
	        
	        //选择跟房贷产品操作
	        loan.gfdLoanOperationByIndex();
	        
	        //实例化登陆对象
	        LoginTest lt = new LoginTest(driver);
	        //登陆
	        lt.login();
	        
	        //选择跟房贷产品操作
	        loan.gfdLoanOperationByIndex();
	        
	        //具体操作
	        operation(driver, loan);
	        
	        return true;
		}catch(Exception e){
			log.error("Handle gdf loan case error ----->>>>", e);
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
	private void operation(WebDriver driver, GFDLoanTest loan) {
		//跟房贷产品展示
		loan.gfdLoanShow();
		
		//1秒读懂跟房贷
		loan.readGfd();
		
		//1秒读懂跟房贷展示
		loan.gfdLoanReadShow();
		
		//返回
		loan.back();
		
		//立即申请
		loan.applyGfd();
		
		//查看央行征信账号申请手册操作
		loan.readOperation();
		
		//查看央行征信账号申请手册
		loan.applyReadShow();
		
		//后退
		loan.webBack();
		
		//立即申请
		loan.applyGfd();
		
		//已有账号，继续申请
		loan.getInfoAndApply();
		
		//设置跟房贷申请信息
		loan.setApplyInfo();
		
		//查看还款计划
		loan.readPlan();
		
		//关闭还款计划
		loan.closedPlan();
		
		//查看攻略
		loan.readRaiders();
		
		//查看央行征信账号申请手册
		loan.applyReadShow();
		
		//后退
		loan.webBack();
		
		//填写央行信息
		loan.setCreditInfo();
		
		//上传身份证
		loan.uploadImg();
		
		//选填进行操作
		loan.choiceInfo();
		
		//填写选填信息
		loan.setChoiceInfo();
		
		//阅读协议
		loan.readAgreement();
		
		//勾选协议
		loan.checkAgreement();
		
		//提交申请
		loan.submit();
		
		//点击我知道了
		loan.IKonwn();
		
		//返回我的贷款
		loan.backMy(3);
		
		// 返回首页
		loan.back();
		
		//退出
		LogoutTest logout = new LogoutTest(driver);
		logout.logout();
	} 
}
