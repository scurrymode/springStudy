package com.sist.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class EmpDAO {
	
	@Autowired
	private EmpMapper mapper;
	//extends나 implements가 없는 방식을 POJO 라고 한다.
	
	public List<EmpVO> empAllData(){
		return mapper.empAllDate();
	}
	
	public EmpVO empFindData(int empno){
		return mapper.empFindData(empno);
	}
	
	public void empInsert(EmpVO vo){
		mapper.empInsert(vo);
	}
}
