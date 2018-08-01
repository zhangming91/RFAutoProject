package com.bankhui.sys.bean;

import java.io.Serializable;

/**
*  用例实体
* @author liuyang
* @time 2017年7月18日下午2:17:06
*       
*/ 
public class TestCaseBean implements Serializable{

	
	/**
	* <p>Title: </p>
	* <p>Description: </p>
	* 
	*/ 
	private static final long serialVersionUID = 1L;
	
	
	private int id;
	
	private String caseNum; // 用例编号
	
	private String caseName; // 用例名称
	
	private String caseDetail; // 用例详情
	
	private String createTime; // 创建时间
	
	private String startTime; // 执行开始时间
	
	private String endTime; // 执行结束时间
	
	private String results; // 执行结果
	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCaseNum() {
		return caseNum;
	}

	public void setCaseNum(String caseNum) {
		this.caseNum = caseNum;
	}

	public String getCaseName() {
		return caseName;
	}

	public void setCaseName(String caseName) {
		this.caseName = caseName;
	}

	public String getCaseDetail() {
		return caseDetail;
	}

	public void setCaseDetail(String caseDetail) {
		this.caseDetail = caseDetail;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getResults() {
		return results;
	}

	public void setResults(String results) {
		this.results = results;
	}


}
