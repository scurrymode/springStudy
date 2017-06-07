package com.sist.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import java.util.*;

public interface EmpMapper {
	@Select("SELECT empno, ename, job, hiredate, sal FROM emp")
	public List<EmpVO> empAllDate();
	
	@Select("SELECT empno, ename, job, hiredate, sal FROM emp"
			+" WHERE empno=#{empno}")
	public EmpVO empFindData(int empno);
	
	@SelectKey(keyProperty="empno", resultType=int.class, before=true, statement="SELECT NVL (MAX(empno)+1,1) as empno FROM emp")
	@Insert("INSERT INTO emp VALUES(#{empno}, #{ename}, #{job}, 7788, SYSDATE, #{sal}, 100, 10)")
	public void empInsert(EmpVO vo);
	
}
