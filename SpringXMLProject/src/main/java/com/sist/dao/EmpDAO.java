package com.sist.dao;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import java.util.*;
public class EmpDAO extends SqlSessionDaoSupport {
	public List<EmpVO> empAllData(){
		return getSqlSession().selectList("empAllData");
		//스프링안에서는 한줄에서 세션 가져오고, 쿼리문 날리고 세션 닫는 모든게 처리된다.
	}
}
