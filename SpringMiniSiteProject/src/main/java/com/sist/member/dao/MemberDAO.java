package com.sist.member.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {
	@Autowired
	private MemberMapper mMapper;
	public List<ZipcodeVO> zipcodeListData(String dong){//우편번호 검색
		return mMapper.zipcodeListData(dong);
	}
	
	public int memberIdcheck(String id){//아이디 중복 체크
		return mMapper.memberIdcheck(id);
	}
	
	public void memberInsert(MemberVO vo){//회원등록
		mMapper.memberInsert(vo);
	}
	
	public String memberGetPwd(String id){//로그인시 비번체크
		return mMapper.memberGetPwd(id);
	}
	
	public MemberVO memberInfoData(String id){//로그인 시 세션에 담을 정보
		return mMapper.memberInfoData(id);
	}
	
	
}
