package com.bankhui.h5.test.service.product.loan;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.bankhui.comm.ImgUtil;
import com.bankhui.comm.Labeloperation;
import com.bankhui.comm.Slide;

/**
*  跟房贷测试
* @author liuyang
* @time 2017年7月12日上午11:54:30
*       
*/ 
public class GFDLoanTest extends LoanTest {

	public GFDLoanTest(WebDriver driver) {
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
	* 1键读懂跟房贷
	* @author liuyang
	* @time 2017年7月12日下午1:59:27       
	*/ 
	public void readGfd(){
		this.getDriver().findElement(By.className("btn")).findElement(By.tagName("a")).click();
	}
	
	/**
	* 1键读懂跟房贷展示
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
		this.getDriver().findElement(By.className("in_footer_a")).click();
		Slide.pause(1);
	}
	
	/**
	* 查看央行征信账号申请手册操作
	* @author liuyang
	* @time 2017年7月12日下午2:07:43       
	*/ 
	public void readOperation(){
		this.getDriver().findElement(By.className("howgain")).click();
	}
	
	/**
	* 查看央行征信账号申请手册
	* @author liuyang
	* @time 2017年7月11日下午2:08:10       
	*/ 
	public void applyReadShow(){
		// 向下滑动
		Slide.slideDown(this.getDriver(), 12);
		
		// 置顶
		Slide.slideUp(this.getDriver(), 0);
	}
	
	/**
	* 已获取央行征信账号 且继续申请
	* @author liuyang
	* @time 2017年7月12日下午2:12:36       
	*/ 
	public void getInfoAndApply(){
		this.getDriver().findElement(By.className("alreadygain")).click();
	}
	
	/**
	* 设置跟房贷申请信息
	* @author liuyang
	* @time 2017年7月12日下午2:14:05       
	*/ 
	public void setApplyInfo(){
		Slide.pause(2);
		// 贷款人姓名
		WebElement name = this.getDriver().findElement(By.id("fausername"));
		name.sendKeys("万栋昆");
		
		//贷款人身份证号
		WebElement idcard = this.getDriver().findElement(By.id("idcard"));
		idcard.sendKeys("220302199211271179");
		
		//贷款金额
		WebElement appAmount = this.getDriver().findElement(By.id("appAmount"));
		appAmount.sendKeys("49");
		
		//贷款期限
		WebElement timeLimit = this.getDriver().findElement(By.id("timeLimit"));
		timeLimit.sendKeys("10");
		
		Slide.pause(2);
	}
	
	/**
	* 查看还款计划
	* @author liuyang
	* @time 2017年7月12日下午2:21:50       
	*/ 
	public void readPlan(){
		this.getDriver().findElement(By.id("repayplanA")).click();
		Slide.pause(3);
	}
	
	/**
	*  关闭还款计划
	* @author liuyang
	* @time 2017年7月13日上午11:34:23       
	*/ 
	public void closedPlan(){
		this.getDriver().findElement(By.className("blueclose")).click();
		Slide.pause(2);
	}
	
	/**
	* 查看攻略
	* @author Baihuijinkong
	* @time 2017年7月12日下午2:23:35       
	*/ 
	public void readRaiders(){
		this.getDriver().findElement(By.className("raiders")).click();
	}
	
	/**
	* 设置征信信息
	* @author liuyang
	* @time 2017年7月12日下午2:25:17       
	*/ 
	public void setCreditInfo(){
		Slide.pause(2);
		//征信查询登陆名
		WebElement zxusername = this.getDriver().findElement(By.id("zxusername"));
		zxusername.sendKeys("zxusername1");
		
		//征信查询密码
		WebElement zxpassword = this.getDriver().findElement(By.id("zxpassword"));
		zxpassword.sendKeys("zxpassword1");
		
		//征信身份验证码
		WebElement zxyzm = this.getDriver().findElement(By.id("zxyzm"));
		zxyzm.sendKeys("zxyzm");
		Slide.pause(2);
	}
	
	/**
	* 上传照片
	* @author liuyang
	* @time 2017年7月12日下午2:33:21       
	*/ 
	public void uploadImg(){
		WebElement left = this.getDriver().findElement(By.id("zPicker")).findElement(By.tagName("input"));
		left.sendKeys(ImgUtil.getImg_left());
		Slide.pause(2);
		WebElement right = this.getDriver().findElement(By.id("fPicker")).findElement(By.tagName("input"));
		right.sendKeys(ImgUtil.getImg_right());
		Slide.pause(2);
	}
	
	/**
	* 点击选填信息
	* @author liuyang
	* @time 2017年7月12日下午3:30:53       
	*/ 
	public void choiceInfo(){
		this.getDriver().findElement(By.className("arrow")).click();
		Slide.pause(2);
	}
	
	/**
	* 设置选填信息
	* @author liuyang
	* @time 2017年7月12日下午3:32:35       
	*/ 
	public void setChoiceInfo(){
		Slide.pause(2);
		//家庭住址／经营场所
		WebElement address = this.getDriver().findElement(By.id("address"));
		address.sendKeys("家庭住址");
		
		//单位名称
		WebElement qiname = this.getDriver().findElement(By.id("qiname"));
		qiname.sendKeys("单位名称");
		
		//配偶姓名
		WebElement peiname = this.getDriver().findElement(By.id("peiname"));
		peiname.sendKeys("配偶姓");
		
		//配偶联系方式
		WebElement peiphone = this.getDriver().findElement(By.id("peiphone"));
		peiphone.sendKeys("13439870329");
		
		//父母姓名
		WebElement parentname = this.getDriver().findElement(By.id("parentname"));
		parentname.sendKeys("父母姓");
		
		//父母联系方式
		WebElement parentphone = this.getDriver().findElement(By.id("parentphone"));
		parentphone.sendKeys("13439870329");
		
		//紧急联系人
		WebElement friendname = this.getDriver().findElement(By.id("friendname"));
		friendname.sendKeys("紧急联");
		
		//紧急联系方式
		WebElement friendphone = this.getDriver().findElement(By.id("friendphone"));
		friendphone.sendKeys("13439870329");
		
		// 推荐人手机号(客户经理)
		WebElement refereephone = this.getDriver().findElement(By.id("refereephone"));
		refereephone.sendKeys("13439870329");
		
        Slide.pause(2);
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
		this.getDriver().findElement(By.className("bhd_apply_btn")).click();
		Slide.pause(2);
	}
	
	/**
	* 点击我知道了
	* @author liuyang
	* @time 2017年7月12日下午3:45:16       
	*/ 
	public void IKonwn(){
		Slide.pause(4);
		this.getDriver().findElement(By.className("kownbtn")).click();
		Slide.pause(2);
	}
	
	/**
	*  选择跟房贷产品操作
	* @author liuyang
	* @time 2017年7月13日上午11:06:34       
	*/ 
	public void gfdLoanOperationByProduct(){
		//进入产品，获取贷款页签
		openProduct();
		//选择产品
        choiceProduct();
        //滑动浏览产品
        loanShow();
        //选择跟房贷产品操作
        List<WebElement> webElements = applyLoan();
        //选择跟房贷产品
        choiceGFD(webElements, 0);
	}
	/**
	 *  选择跟房贷产品操作
	 * @author liuyang
	 * @time 2017年7月13日上午11:06:34       
	 */ 
	public void gfdLoanOperationByIndex(){
		//进入产品，获取贷款页签
		openLoan();
		//选择跟房贷产品操作
		List<WebElement> webElements = applyLoan();
		//选择跟房贷产品
		choiceGFD(webElements, 0);
	}
}
