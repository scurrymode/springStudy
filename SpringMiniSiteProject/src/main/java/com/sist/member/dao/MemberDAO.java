package com.sist.member.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {
	@Autowired
	private MemberMapper mMapper;
	public List<ZipcodeVO> zipcodeListData(String dong){
		return mMapper.zipcodeListData(dong);
	}
	
	
	
}
