package com.bankhui.sys.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.bankhui.sys.bean.TestCaseBean;

/**
* 用例的dao
* @author liuyang
* @time 2017年7月18日下午2:18:11
*       
*/ 
@Component
public interface TestCaseDao {

	// 增
	public int insert(TestCaseBean bean);
	// 删
	public int deleteById(int id);
	// 内容更改
	public int update(TestCaseBean bean);
	// 状态更新
	public int updateAllStaust();
	// 查(列表)
	public List<TestCaseBean> findAll();
	// 查(单条)
	public TestCaseBean findById(int id);
	
	
	
	
}
