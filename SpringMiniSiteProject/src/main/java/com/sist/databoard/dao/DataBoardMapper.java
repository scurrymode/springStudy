package com.sist.databoard.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.*;
public interface DataBoardMapper {
	@Select("SELECT no, subject, name, regdate, hit, num "
			+"FROM (SELECT no, subject, name, regdate, hit, rownum as num "
			+"FROM (SELECT no, subject, name, regdate, hit "
			+"FROM dataBoard ORDER BY no DESC)) "
			+"WHERE num BETWEEN #{start} AND #{end}")
	public List<DataBoardVO> databoardListData(Map map);
	//�� ������
	@Select("SELECT CEIL(COUNT(*)/10) FROM dataBoard")
	public int databoardTotalPage();
	
	@Insert("INSERT INTO dataBoard VALUES("
			+"db_no_seq.nextval,#{name},#{subject},#{content},#{pwd},SYSDATE,0,#{filename},#{filesize},#{filecount})")
	public void databoardInsert(DataBoardVO vo);

	//���� ����
	@Update("UPDATE dataBoard SET hit=hit+1 WHERE no=#{no}")
	public void databoardHitIncrement(int no);
	/*
	 * 1) ����� resultType=>������
	 * 2) �Ű����� parameterType=>�Ű�����
	 */
	@Select("SELECT no,name,subject,content,regdate,hit,filename,filesize,filecount FROM dataBoard WHERE no=#{no}")
	public DataBoardVO databoardContentData(int no);
	
	//�����ϱ�
	@Select("SELECT pwd FROM dataBoard WHERE no=#{no}")
	public String databoardGetPwd(int no); //��й�ȣ Ȯ��
	@Select("SELECT filename, filesize, filecount FROM dataBoard WHERE no=#{no}")
	public DataBoardVO databoardGetFileInfo(int no);
	@Update("UPDATE dataBoard SET name=#{name}, subject=#{subject}, content=#{content}, filename=#{filename}, filesize=#{filesize}, filecount=#{filecount} WHERE no=#{no}")
	public void databoardUpdate(DataBoardVO vo);
	
	//�����ϱ�
	@Delete("DELETE FROM dataBoard WHERE no=#{no}")
	public void dataBoardDelete(int no);
	
}
