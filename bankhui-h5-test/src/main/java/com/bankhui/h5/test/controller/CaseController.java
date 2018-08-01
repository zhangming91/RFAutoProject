package com.bankhui.h5.test.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bankhui.comm.DateUtil;
import com.bankhui.h5.test.usercase.GFDLoanCase;
import com.bankhui.h5.test.usercase.InsuranceCase;
import com.bankhui.h5.test.usercase.LoginCase;
import com.bankhui.h5.test.usercase.MessageCase;
import com.bankhui.h5.test.usercase.RegisterCase;
import com.bankhui.h5.test.usercase.ZQDLoanCase;
import com.bankhui.sys.bean.TestCaseBean;
import com.bankhui.sys.service.TestCaseService;

/**
*  用例交互操作
* @author liuyang
* @time 2017年7月14日下午3:09:11
*       
*/
@EnableAutoConfiguration
@RestController
@RequestMapping("h5/case/op")
public class CaseController {

	@Autowired
	TestCaseService testCaseService;
	
	/**
	* 用例列表
	* @author liuyang
	* @time 2017年7月14日下午3:27:28
	* @return       
	*/ 
	@RequestMapping(value="/show", method = RequestMethod.GET)
	public List<?> show(){
		List<TestCaseBean>list =  testCaseService.findAll();
		return list;
		
	}
	
	/**
	*  添加用例
	* @author liuyang
	* @time 2017年7月20日下午1:42:49
	* @param caseNum 用例编号
	* @param caseName 用例名称
	* @param caseDetail 用例详情
	* @return       
	*/ 
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public String add(@RequestParam(defaultValue="")String caseNum,
			@RequestParam(defaultValue="")String caseName,
			@RequestParam(defaultValue="")String id,
			@RequestParam(defaultValue="")String caseDetail){
		if(StringUtils.isBlank(caseNum) || StringUtils.isBlank(caseName) || StringUtils.isBlank(caseDetail)){
			return "0";
		}
		TestCaseBean bean = new TestCaseBean();
		bean.setCaseNum(caseNum);
		bean.setCaseName(caseName);
		bean.setCaseDetail(caseDetail);
		bean.setCreateTime(DateUtil.getSysCurDateTime());
		int count = 0;
		if(StringUtils.isNotBlank(id)){
			//更新
			bean.setId(Integer.valueOf(id));
			count = testCaseService.update(bean);
		}else{
			count = testCaseService.insert(bean);
		}
		return String.valueOf(count);
		
	}
	
	/**
	* 保险用例执行
	* @author liuyang
	* @time 2017年7月14日下午3:27:43       
	*/ 
	@RequestMapping(value="/run/{id}", method = RequestMethod.GET)
	public String run(@PathVariable("id") int id, @RequestParam(defaultValue="") String caseNum){
		boolean result = false;
		String startTime = DateUtil.getSysCurTime();
		try {
			switch (caseNum) {
			case "bhjf-h5-register": //注册
				result =  new RegisterCase().registerCase();
				break;
			case "bhjf-h5-login": //登陆
				result =  new LoginCase().loginCase();
				break;
			case "bhjf-h5-insurance-index": //保险-首页
				result =  new InsuranceCase().insuranceCaseByIndex();
				break;
			case "bhjf-h5-insurance-product": //保险-产品
				result =  new InsuranceCase().insuranceCaseByProduct();
				break;
			case "bhjf-h5-gfd-index": //跟房贷-首页
				result =  new GFDLoanCase().gfdLoanCaseByIndex();
				break;
			case "bhjf-h5-gfd-product": //跟房贷-产品
				result =  new GFDLoanCase().gfdLoanCaseByProduct();
				break;
			case "bhjf-h5-zqd-index": //跟房贷-首页
				result =  new ZQDLoanCase().zqdLoanCaseByIndex();
				break;
			case "bhjf-h5-zqd-product": //跟房贷-产品
				result =  new ZQDLoanCase().zqdLoanCaseByProduct();
				break;
			case "bhjf-h5-message-index": //消息-首页
				result =  new MessageCase().messageCaseByIndex();
				break;
			case "bhjf-h5-message-my": //消息-我的
				result =  new MessageCase().messageCaseByMy();
				break;
			default:
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		}finally{
			TestCaseBean bean = testCaseService.findById(id);
			if(bean == null ){
				return String.valueOf(result);
			}
			bean.setStartTime(startTime);
			bean.setEndTime(DateUtil.getSysCurTime());
			bean.setResults(String.valueOf(result));
			testCaseService.update(bean);
		}
		return String.valueOf(result);
	}
	
	/**
	* 根据id查询
	* @author liuyang
	* @time 2017年7月20日下午1:43:21
	* @param id 主键
	* @return       
	*/ 
	@RequestMapping(value="/find/{id}", method = RequestMethod.GET)
	public Map<String,Object> find(@PathVariable("id") int id){
		TestCaseBean bean = testCaseService.findById(id);
		Map<String,Object> map = new HashMap<String, Object>();
		if(bean != null ){
			map.put("bean", bean);
		}
		return map;
	}
	
	/**
	*  根据主键删除
	* @author liuyang
	* @time 2017年7月20日下午1:43:37
	* @param id
	* @return       
	*/ 
	@RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable("id") int id){
		int count = testCaseService.deleteById(id);
		return String.valueOf(count);
	}
	
	
	
	/**
	*  清空
	* @author liuyang
	* @time 2017年7月20日下午1:44:12
	* @return       
	*/ 
	@RequestMapping(value="/clear", method = RequestMethod.GET)
	public String clear(){
		int count = testCaseService.updateAllStaust();
		return String.valueOf(count);
	}
}
