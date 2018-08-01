package com.bankhui.sys.service;

import java.util.List;

import com.bankhui.sys.bean.TestCaseBean;

/**
*  用例管理业务类
* @author liuyang
* @time 2017年7月18日下午2:29:26
*       
*/ 
public interface TestCaseService {

	/**
	*  增加
	* @author liuyang
	* @time 2017年7月18日下午2:29:59
	* @param bean
	* @return       
	*/ 
	public int insert(TestCaseBean bean);
	/**
	*  根据id删除
	* @author liuyang
	* @time 2017年7月18日下午2:30:16
	* @param id 主键
	* @return  执行行数
	*/ 
	public int deleteById(int id);
	/**
	* 内容更改
	* @author liuyang
	* @time 2017年7月18日下午2:30:51
	* @param bean 实体对象
	* @return 执行行数
	*/ 
	public int update(TestCaseBean bean);
	/**
	* 批量状态更新
	* @author liuyang
	* @time 2017年7月18日下午2:31:29
	* @return  执行行数    
	*/ 
	public int updateAllStaust();
	/**
	* 查(列表)
	* @author liuyang
	* @time 2017年7月18日下午2:32:22
	* @return  List集合     
	*/ 
	public List<TestCaseBean> findAll();
	/**
	* 查(单条)
	* @author liuyang
	* @time 2017年7月18日下午2:32:44
	* @param id 主键
	* @return 实体对象   
	*/ 
	public TestCaseBean findById(int id);
}
