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
	
	//��� ���
	@Insert("INSERT INTO dataReply VALUES(dr_no_seq.nextval,#{bno},#{id},#{name},#{msg},SYSDATE,(SELECT NVL(MAX(group_id)+1,1) FROM dataReply),0,0,0,0)")
	public void replyNewInsert(DataReplyVO vo);
	//��� ����
	@Update("UPDATE dataReply SET msg=#{msg} WHERE no=#{no}")
	public void replyUpdate(DataReplyVO vo);
	//����
	@Select("SELECT group_id, group_step, group_tab FROM dataReply WHERE no=#{no}")
	public DataReplyVO replyParentInfo(int no);//�θ������� ��������
	@Update("UPDATE dataReply SET group_step=group_step+1 WHERE group_id=#{group_id} and group_step>#{group_step}")
	public void replyStepIncrement(DataReplyVO vo);//�޸��� ���ۺ��� �Ʒ��ִ¾ֵ� �ϳ��� �Ʒ��� ������
	@Insert("INSERT INTO dataReply VALUES(dr_no_seq.nextval,#{bno},#{id},#{name},#{msg},SYSDATE,#{group_id},#{group_step},#{group_tab},#{root},0)")
	public void replyRdInsert(DataReplyVO vo);//���� ����
	@Update("UPDATE dataReply SET depth=depth+1 WHERE no=#{no}")
	public void replyDepthIncrement(int no);//�θ��� �� �ø���
	
	//����(�����ڰ� ������ ����Դϴ�)
	@Select("SELECT depth, root FROM dataReply WHERE no=#{no}")
	public DataReplyVO replyGetDepthData(int no);//�ڽĵ� �����ϱ� ���� depth�� (0�� �ƴϸ� �ڽĵ� ����) ��������, �θ��� depth���̷��� root��
	@Delete("DELETE FROM dataReply WHERE no=#{no}")
	public void replyDelete(int no);
	@Update("UPDATE dataReply SET msg='�����ڰ� ������ ����Դϴ�' WHERE no=#{no}")
	public void replyMsgUpdate(int no);
	@Update("UPDATE dataReply SET depth=depth-1 WHERE no=#{no}")
	public void replyDepthDecrement(int no);//�θ��� �� ���̱�
	
	//�ۻ����� ����
	@Delete("DELETE FROM dataReply WHERE bn=#{bno}")
	public void replyAllDelete(int bno);
}
