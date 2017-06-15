package com.sist.databoard.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.*;
public interface DataReplyMapper {
	@Select("SELECT COUNT(*) FROM dataReply WHERE bno=#{bno}")
	public int replyCount(int bno);
	@Select("SELECT no, bno, id, name, msg,TO_CHAR(regdate,'YYYY-MM-DD HH24:MI:SS') as strDay, group_tab FROM dataReply "
			+ "WHERE bno=#{bno} ORDER BY group_id DESC, group_step ASC")
	public List<DataReplyVO> replyListData(int bno);
	
	//댓글 등록
	@Insert("INSERT INTO dataReply VALUES(dr_no_seq.nextval,#{bno},#{id},#{name},#{msg},SYSDATE,(SELECT NVL(MAX(group_id)+1,1) FROM dataReply),0,0,0,0)")
	public void replyNewInsert(DataReplyVO vo);
	//댓글 수정
	@Update("UPDATE dataReply SET msg=#{msg} WHERE no=#{no}")
	public void replyUpdate(DataReplyVO vo);
	//대댓글
	@Select("SELECT group_id, group_step, group_tab FROM dataReply WHERE no=#{no}")
	public DataReplyVO replyParentInfo(int no);//부모댓글정보 가져오기
	@Update("UPDATE dataReply SET group_step=group_step+1 WHERE group_id=#{group_id} and group_step>#{group_step}")
	public void replyStepIncrement(DataReplyVO vo);//달리는 대댓글보다 아래있는애들 하나씩 아래로 보내기
	@Insert("INSERT INTO dataReply VALUES(dr_no_seq.nextval,#{bno},#{id},#{name},#{msg},SYSDATE,#{group_id},#{group_step},#{group_tab},#{root},0)")
	public void replyRdInsert(DataReplyVO vo);//대댓글 저장
	@Update("UPDATE dataReply SET depth=depth+1 WHERE no=#{no}")
	public void replyDepthIncrement(int no);//부모댓글 댑스 올리기
	
	//삭제(관리자가 삭제한 댓글입니다)
	@Select("SELECT depth, root FROM dataReply WHERE no=#{no}")
	public DataReplyVO replyGetDepthData(int no);//자식들 삭제하기 위해 depth를 (0이 아니면 자식들 삭제) 가져오고, 부모의 depth줄이려고 root도
	@Delete("DELETE FROM dataReply WHERE no=#{no}")
	public void replyDelete(int no);
	@Update("UPDATE dataReply SET msg='관리자가 삭제한 댓글입니다' WHERE no=#{no}")
	public void replyMsgUpdate(int no);
	@Update("UPDATE dataReply SET depth=depth-1 WHERE no=#{no}")
	public void replyDepthDecrement(int no);//부모댓글 댑스 줄이기
	
	//글삭제시 삭제
	@Delete("DELETE FROM dataReply WHERE bn=#{bno}")
	public void replyAllDelete(int bno);
}
