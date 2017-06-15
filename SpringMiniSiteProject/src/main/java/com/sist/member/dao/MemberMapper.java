package com.sist.member.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface MemberMapper {
	@Select("SELECT zipcode,sido,gugun,dong,NVL(bunji,' ') as bunji FROM zipcode WHERE dong LIKE '%'||#{dong}||'%'")
	public List<ZipcodeVO> zipcodeListData(String dong);
	
	@Select("SELECT COUNT(*) FROM member WHERE id=#{id}")
	public int memberIdcheck(String id); //아이디 중복체크
	
	@Insert("INSERT INTO member VALUES(#{id},#{pwd},#{name},#{sex},#{bday},#{email},#{post},#{addr1},#{addr2},#{tel},'n')")
	public void memberInsert(MemberVO vo);//회원가입 저장
	
	@Select("SELECT pwd FROM member WHERE id=#{id}")
	public String memberGetPwd(String id); //로그인시 비번체크
	
	@Select("SELECT id, name, email, admin FROM member WHERE id=#{id}")
	public MemberVO memberInfoData(String id);//로그인하면 세션에 담을 정보 찾기 
	
	
}
