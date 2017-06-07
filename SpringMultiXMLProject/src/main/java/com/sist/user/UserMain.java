package com.sist.user;

import com.sist.dao.EmpDAO;

public class UserMain {
	private EmpDAO dao;
	
	
	public void setDao(EmpDAO dao) {
		this.dao = dao;
	}


	public void display(){
		dao.select();
		dao.insert();
	}
}
