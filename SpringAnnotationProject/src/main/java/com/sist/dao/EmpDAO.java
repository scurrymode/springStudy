package com.sist.dao;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository("dao")
public class EmpDAO extends SqlSessionDaoSupport{
	/*<bean id="dao" class="com.sist.dao.EmpDAO" p:sqlSessionTemplate-ref="sst"/>*/

	@Resource(name="sst")
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		// TODO Auto-generated method stub
		super.setSqlSessionTemplate(sqlSessionTemplate);
	}
	
	public List<EmpVO> empAllData(){
		return getSqlSession().selectList("empAllData");
	}
	
	
}
