package com.sist.member.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface MemberMapper {
	@Select("SELECT zipcode,sido,gugun,dong,NVL(bunji,' ') as bunji FROM zipcode WHERE dong LIKE '%'||#{dong}||'%'")
	public List<ZipcodeVO> zipcodeListData(String dong);
	
	@Select("SELECT COUNT(*) FROM member WHERE id=#{id}")
	public int memberIdcheck(String id); //���̵� �ߺ�üũ
	
	@Insert("INSERT INTO member VALUES(#{id},#{pwd},#{name},#{sex},#{bday},#{email},#{post},#{addr1},#{addr2},#{tel},'n')")
	public void memberInsert(MemberVO vo);//ȸ������ ����
	
	@Select("SELECT pwd FROM member WHERE id=#{id}")
	public String memberGetPwd(String id); //�α��ν� ���üũ
	
	@Select("SELECT id, name, email, admin FROM member WHERE id=#{id}")
	public MemberVO memberInfoData(String id);//�α����ϸ� ���ǿ� ���� ���� ã�� 
	
	
}
