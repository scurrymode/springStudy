package com.sist.databoard.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class DataBoardService {
	@Autowired
	private DataBoardMapper bMapper;
	public List<DataBoardVO> databoardListData(Map map){
		return bMapper.databoardListData(map);
	}
	
	public void databoardInsert(DataBoardVO vo){
		bMapper.databoardInsert(vo);
	}
	
	//총페이지
	public int databoardTotalPage(){
		return bMapper.databoardTotalPage();
	}
	//내용보기
	public DataBoardVO databoardContentData(int no){
		bMapper.databoardHitIncrement(no); //조회수 증가
		return bMapper.databoardContentData(no); //데이터 가져보기
	}
	
	public DataBoardVO databoardUpdateData(int no){
		return bMapper.databoardContentData(no); //데이터 가져보기
	}
	public DataBoardVO databoardGetFileInfo(int no){
		return bMapper.databoardGetFileInfo(no);
	}
	
	public String databoardGetPwd(int no){
		return bMapper.databoardGetPwd(no);
	}
	
	public void databoardUpdate(DataBoardVO vo){
		bMapper.databoardUpdate(vo);
	}
	
	
}
