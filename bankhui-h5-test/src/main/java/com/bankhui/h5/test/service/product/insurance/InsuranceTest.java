package com.bankhui.h5.test.service.product.insurance;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.bankhui.comm.Labeloperation;
import com.bankhui.comm.Slide;
import com.bankhui.h5.test.service.product.ProductTest;

/**
* 保险测试
* @author liuyang
* @time 2017年7月11日下午1:58:27
*       
*/ 
public class InsuranceTest extends ProductTest {

	public InsuranceTest(WebDriver driver) {
		super(driver);
	}

	/* (非 Javadoc)
	* <p>Title: 选择产品</p>
	* <p>Description: </p>
	* @see com.bankhui.h5.test.product.ProductTest#chanageProduct()
	*/ 
	@Override
	public void choiceProduct() {
		WebElement webElement = Labeloperation.getUL(this.getDriver(), "class-list", 2);
		webElement.click();
	}

	/**
	* 保险产品展示
	* @author liuyang
	* @time 2017年7月11日下午2:12:10       
	*/ 
	public void insuranceShow(){
		// 向下滑动
		Slide.slideDown(this.getDriver(), 4);
		
		// 置顶
		Slide.slideUp(this.getDriver(), 0);
	}
	
	/**
	* 购买保险操作
	* @author liuyang
	* @time 2017年7月11日下午2:45:33  
	* @return  List<WebElement>   
	*/ 
	public List<WebElement> buyInsurance(){
		List<WebElement> webElements = this.getDriver().findElement(By.id("choiceList"))
				.findElements(By.tagName("div"));
		return webElements;
	}
	
	/**
	* 第几个保险产新品，从零开始      
	* @author liuyang
	* @time 2017年7月11日下午3:42:34
	* @param webElements
	* @param count 第几个保险产新品，从零开始      
	*/ 
	public void chanageInsurance(List<WebElement> webElements, int count){
		WebElement webElement = webElements.get(count); 
		webElement.click();
	}
	
	
	/**
	*  下一步操作
	* @author liuyang
	* @time 2017年7月11日下午2:57:52       
	*/ 
	public void next(){
		Slide.pause(3);
		this.getDriver().findElement(By.className("claim-foot")).findElement(By.tagName("button")).click();
	}
	
	/**
	*  设置投保人基本信息
	* @author liuyang
	* @time 2017年7月11日下午3:35:09  
	* @param  release  本人，子女，配偶，其他    
	*/ 
	public void setInsurePeople(String release){
		// 获取投保人区域
		WebElement we = this.getDriver().findElement(By.id("applicantForm"));
		// 设置投保人基本信息
		this.setInfo(we);
		// 选择关系
		Select sel = new Select(this.getDriver().findElement(By.name("relationship2Insured")));
		sel.selectByValue(release);
	}
	
	
	/**
	* 设置保人基本信息
	* @author liuyang
	* @time 2017年7月11日下午3:38:24       
	*/ 
	public void setInsuredPeople(){
		// 获取投保人区域
		WebElement we = this.getDriver().findElement(By.id("insuredForm"));
		// 设置投保人基本信息
		this.setInfo(we);
	}
	
	/**
	* 人的基本信息
	* @author liuyang
	* @time 2017年7月11日下午3:34:51
	* @param we       
	*/ 
	public void setInfo(WebElement we){
		//姓名
		WebElement name = we.findElement(By.name("fullName"));
		name.sendKeys("万栋昆");
		
		//身份证
		WebElement idNo = we.findElement(By.name("idNo"));
		idNo.sendKeys("220302199211271179");
		
		//身份证
		WebElement phone = we.findElement(By.name("phone"));
		phone.sendKeys("17311111111");
		
		//邮箱
		WebElement email = we.findElement(By.name("email"));
		email.sendKeys("17311111111@163.com");
		
		//地址
		WebElement address = we.findElement(By.name("address"));
		address.sendKeys("中国人民共和国北京");
		
		//邮编
		WebElement zipCode = we.findElement(By.name("zipCode"));
		zipCode.sendKeys("100010");
		
		//停顿
		Slide.pause(2);
	}
	
	/**
	*  提交基本信息
	* @author liuyang
	* @time 2017年7月11日下午4:05:26       
	*/ 
	public void submitBeaseInfo(){
		//提交
		this.getDriver().findElement(By.id("fillFormSubmit")).click();
		
		Slide.pause(2);
	}
	
	/**
	*  提交到支付页面
	* @author liuyang
	* @time 2017年7月11日下午4:05:38       
	*/ 
	public void pay(){
		Slide.pause(5);
		// 点击调整支付宝
		this.getDriver().findElement(By.className("pay_methods__list--item")).click();
		
	}
	
	/**
	* 保险产品操作
	* @author liuyang
	* @time 2017年7月11日下午5:11:38
	* @param pt 保险实例       
	*/ 
	public void insuranceOperationByProduct() {
		// 打开产品
		openProduct();
        
        //选择保险
		choiceProduct();
        
        // 保险展示
        insuranceShow();
        
        // 购买保险操作
        List<WebElement> webElements = buyInsurance();
        
        //选择第一个产品
        chanageInsurance(webElements, 0);
	}
	/**
	 * 保险产品操作
	 * @author liuyang
	 * @time 2017年7月11日下午5:11:38
	 * @param pt 保险实例       
	 */ 
	public void insuranceOperationByIndex() {
		// 打开产品
		openInsurance();
		
		// 购买保险操作
		List<WebElement> webElements = buyInsurance();
		
		//选择第一个产品
		chanageInsurance(webElements, 0);
	}
}
