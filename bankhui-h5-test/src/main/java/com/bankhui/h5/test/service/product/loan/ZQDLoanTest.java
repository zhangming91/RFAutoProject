package com.bankhui.h5.test.service.product.loan;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.bankhui.comm.Labeloperation;
import com.bankhui.comm.RedisUtils;
import com.bankhui.comm.SessionId;
import com.bankhui.comm.Slide;

/**
* 中轻助业金
* @author liuyang
* @time 2017年7月27日下午2:16:52
*       
*/ 
public class ZQDLoanTest extends LoanTest {

	public ZQDLoanTest(WebDriver driver) {
		super(driver);
	}

	@Override
	public void choiceProduct() {
		WebElement webElement = Labeloperation.getUL(this.getDriver(), "class-list", 3);
		webElement.click();
	}
	/**
	* 贷款产品展示
	* @author liuyang
	* @time 2017年7月11日下午2:12:10       
	*/ 
	public void loanShow(){
		// 向下滑动
		Slide.slideDown(this.getDriver(), 2);
		
		// 置顶
		Slide.slideUp(this.getDriver(), 0);
	}
	/**
	* 申请贷款操作
	* @author liuyang
	* @time 2017年7月11日下午2:45:33  
	* @return  List<WebElement>   
	*/ 
	public List<WebElement> applyLoan(){
		List<WebElement> webElements = this.getDriver().findElement(By.className("loan-cont"))
				.findElements(By.tagName("div"));
		return webElements;
	}
	
	/**
	* 第1个贷款，从零开始      
	* @author liuyang
	* @time 2017年7月11日下午3:42:34
	* @param webElements
	* @param count 从零开始      
	*/ 
	public void choiceGFD(List<WebElement> webElements, int count){
		WebElement webElement = webElements.get(count); 
		webElement.click();
	}
	
	/**
	* 贷款产品展示
	* @author liuyang
	* @time 2017年7月11日下午2:12:10       
	*/ 
	public void gfdLoanShow(){
		// 向下滑动
		Slide.slideDown(this.getDriver(), 5);
		
		// 置顶
		Slide.slideUp(this.getDriver(), 0);
	}
	/**
	* 1键读懂中轻助业金
	* @author liuyang
	* @time 2017年7月12日下午1:59:27       
	*/ 
	public void readGfd(){
		this.getDriver().findElement(By.className("btn")).click();
	}
	/**
	* 1键读懂中轻助业金
	* @author liuyang
	* @time 2017年7月11日下午2:12:10       
	*/ 
	public void gfdLoanReadShow(){
		// 向下滑动
		Slide.slideDown(this.getDriver(), 5);
		
		// 置顶
		Slide.slideUp(this.getDriver(), 0);
	}
	/**
	* 立即申请操作
	* @author liuyang
	* @time 2017年7月12日下午2:04:50       
	*/ 
	public void applyGfd(){
		Slide.pause(1);
		this.getDriver().findElement(By.className("s_footer")).click();
		Slide.pause(1);
	}
	/**
	* 设置助业金申请信息
	* @author liuyang
	* @time 2017年7月12日下午2:14:05       
	*/ 
	public void setApplyInfo(){
		Slide.pause(2);
		//贷款人姓名
		WebElement name = this.getDriver().findElement(By.id("username"));
		name.sendKeys("万栋昆");
		
		//贷款人身份证号
		WebElement useridcard = this.getDriver().findElement(By.id("useridcard"));
		useridcard.sendKeys("220302199211271179");
		
		//图形验证码
		WebElement imgAuthCode = this.getDriver().findElement(By.id("imgAuthCode"));
		String mcode = SessionId.getJsessionIdCookie(this.getDriver())+"_codeKey";
		mcode = RedisUtils.get(mcode);
		imgAuthCode.sendKeys(mcode);
		
		//填写手机号
		String mobile = "13439870329";
		WebElement userphone = this.getDriver().findElement(By.id("userphone"));
		userphone.sendKeys(mobile);
		Slide.pause(1);
		
		 // 点击获取手机验证码事件
        this.getDriver().findElement(By.className("vcodeBtn")).click();
        
        // 获取手机验证码属性名称
        Slide.pause(3);//停顿3S，等待正式运营商发送验证码
        // 手机验证码
        String vcode = mobile+"_getQGYH5LoanCellPhoneCode";
        vcode = RedisUtils.get(vcode);
        WebElement mobileauthcode = this.getDriver().findElement(By.id("mobileauthcode"));
        mobileauthcode.sendKeys(vcode);
        
        //营业执照号
        WebElement businessnum = this.getDriver().findElement(By.id("businessnum"));
        businessnum.sendKeys("营业执照注册号");
        
        //中轻用户平台号
        WebElement QGYCode = this.getDriver().findElement(By.id("QGYCode"));
        QGYCode.sendKeys("100040");
        
        //授权获取您的中轻系统结算账户信息
        this.getDriver().findElement(By.id("accountNo")).click();
        Slide.pause(3);
	}
	
	/**
	* 查看协议
	* @author liuyang
	* @time 2017年7月12日下午3:55:36       
	*/ 
	public void readAgreement(){
		List<WebElement> webElements = this.getDriver()
				.findElement(By.className("loanAgreement"))
				.findElements(By.tagName("a"));
		//打开第一个新窗口
		webElements.get(0).click();
		//停顿2s,查看内容
		Slide.pause(2);
		//关闭新窗口
		Labeloperation.changeWindow(this.getDriver());
		
		//打开第二个新窗口
		webElements.get(1).click();
		//停顿2s,查看内容
		Slide.pause(2);
		//关闭新窗口
		Labeloperation.changeWindow(this.getDriver());
		
		//打开第三个新窗口
		webElements.get(2).click();
		//停顿2s,查看内容
		Slide.pause(2);
		//关闭新窗口
		Labeloperation.changeWindow(this.getDriver());
		
		//打开第四个新窗口
		webElements.get(3).click();
		//停顿2s,查看内容
		Slide.pause(2);
		//关闭新窗口
		Labeloperation.changeWindow(this.getDriver());
	}
	
	/**
	* 勾选协议
	* @author liuyang
	* @time 2017年7月13日上午11:47:17       
	*/ 
	public void checkAgreement(){
		Slide.pause(2);
		//注册协议
        this.getDriver().findElement(By.className("checkbox")).click();
	}
	
	/**
	* 提交申请
	* @author liuyang
	* @time 2017年7月12日下午3:40:57       
	*/ 
	public void submit(){
		this.getDriver().findElement(By.className("loanBtn")).click();
		Slide.pause(2);
	}
	
	/**
	*  选择跟房贷产品操作
	* @author liuyang
	* @time 2017年7月13日上午11:06:34       
	*/ 
	public void zqdLoanOperationByProduct(){
		//进入产品，获取贷款页签
		openProduct();
		//选择产品
        choiceProduct();
        //滑动浏览产品
        loanShow();
        //选择跟房贷产品操作
        List<WebElement> webElements = applyLoan();
        //选择跟房贷产品
        choiceGFD(webElements, 1);
	}
	/**
	 *  选择跟房贷产品操作
	 * @author liuyang
	 * @time 2017年7月13日上午11:06:34       
	 */ 
	public void zqdLoanOperationByIndex(){
		//进入产品，获取贷款页签
		openLoan();
		//选择跟房贷产品操作
		List<WebElement> webElements = applyLoan();
		//选择跟房贷产品
		choiceGFD(webElements, 1);
	}
}
