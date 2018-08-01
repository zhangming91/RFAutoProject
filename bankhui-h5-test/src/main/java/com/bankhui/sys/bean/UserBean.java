package com.bankhui.sys.bean;

import java.io.Serializable;

public class UserBean implements Serializable{

	/**
	* <p>Title: </p>
	* <p>Description: </p>
	* 
	*/ 
	private static final long serialVersionUID = 1L;
	
	private int uid;
	
	private String name;
	
	
	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
