package com.sist.databoard.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
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
	
	
	
}
