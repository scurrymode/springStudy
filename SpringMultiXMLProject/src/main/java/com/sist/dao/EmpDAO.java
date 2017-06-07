package com.sist.dao;

import com.sist.security.MySecurity;

public class EmpDAO {
	private MySecurity ms;
	
	public void setMs(MySecurity ms) {
		this.ms = ms;
	}
	public void select(){
		ms.security();
		System.out.println("데이터읽기");
	}
	public void insert(){
		ms.security();
		System.out.println("데이터쓰기");
	}
}
