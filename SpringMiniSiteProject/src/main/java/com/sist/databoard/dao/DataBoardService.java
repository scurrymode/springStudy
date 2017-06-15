package com.sist.databoard.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
public class DataBoardService {
	@Autowired
	private DataBoardMapper bMapper;
	@Autowired
	private DataReplyMapper rMapper;
	
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
	public int replyCount(int bno){
		return rMapper.replyCount(bno);
	}
	public List<DataReplyVO> replyListData(int bno){
		return rMapper.replyListData(bno);
	}
	
	public void replyNewInsert(DataReplyVO vo){
		rMapper.replyNewInsert(vo);
	}
	public void replyUpdate(DataReplyVO vo){
		rMapper.replyUpdate(vo);
	}

	public void replyReInsert(int root, DataReplyVO vo){
		DataReplyVO pvo = rMapper.replyParentInfo(root);//부모댓글정보 가져오기
		rMapper.replyStepIncrement(pvo);//달리는 대댓글보다 아래있는애들 하나씩 아래로 보내기
		vo.setGroup_id(pvo.getGroup_id());
		vo.setGroup_step(pvo.getGroup_step()+1);//부모보다 하나더 
		vo.setGroup_tab(pvo.getGroup_tab()+1);//부모보다 하다너
		vo.setRoot(root);
		rMapper.replyRdInsert(vo);//대댓글 저장
		rMapper.replyDepthIncrement(root);//부모댓글 댑스 올리기
	}
	//댓글삭제
	public void replyDelete(int no){
		DataReplyVO vo = rMapper.replyGetDepthData(no);
		if(vo.getDepth()==0){
			rMapper.replyDelete(no);
		}else{
			rMapper.replyMsgUpdate(no);
		}
		rMapper.replyDepthDecrement(vo.getRoot());
	}
	
	//글삭제
	public void boardDelete(int no){
		rMapper.replyAllDelete(no);
		bMapper.dataBoardDelete(no);
	}
	
	
	
	
	
}
