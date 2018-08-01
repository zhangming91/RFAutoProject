package com.bankhui.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankhui.sys.bean.TestCaseBean;
import com.bankhui.sys.dao.TestCaseDao;
import com.bankhui.sys.service.TestCaseService;

/**
* 用例管理业务类
* @author liuyang
* @time 2017年7月18日下午2:46:52
*       
*/ 
@Service("testCaseService")
public class TestCaseServiceImpl implements TestCaseService {

	@Autowired
	TestCaseDao testCaseDao;
	
	@Override
	public int insert(TestCaseBean bean) {
		return testCaseDao.insert(bean);
	}

	@Override
	public int deleteById(int id) {
		return testCaseDao.deleteById(id);
	}

	@Override
	public int update(TestCaseBean bean) {
		return testCaseDao.update(bean);
	}

	@Override
	public int updateAllStaust() {
		return testCaseDao.updateAllStaust();
	}

	@Override
	public List<TestCaseBean> findAll() {
		return testCaseDao.findAll();
	}

	@Override
	public TestCaseBean findById(int id) {
		return testCaseDao.findById(id);
	}

}
