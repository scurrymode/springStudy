package com.sist.member.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

public interface MemberMapper {
	@Select("SELECT zipcode,sido,gugun,dong,NVL(bunji,' ') as bunji FROM zipcode WHERE dong LIKE '%'||#{dong}||'%'")
	public List<ZipcodeVO> zipcodeListData(String dong);
}
