package com.sist.member.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {
	@Autowired
	private MemberMapper mMapper;
	public List<ZipcodeVO> zipcodeListData(String dong){//�����ȣ �˻�
		return mMapper.zipcodeListData(dong);
	}
	
	public int memberIdcheck(String id){//���̵� �ߺ� üũ
		return mMapper.memberIdcheck(id);
	}
	
	public void memberInsert(MemberVO vo){//ȸ�����
		mMapper.memberInsert(vo);
	}
	
	public String memberGetPwd(String id){//�α��ν� ���üũ
		return mMapper.memberGetPwd(id);
	}
	
	public MemberVO memberInfoData(String id){//�α��� �� ���ǿ� ���� ����
		return mMapper.memberInfoData(id);
	}
	
	
}
