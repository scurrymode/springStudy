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
	//총 페이지
	@Select("SELECT CEIL(COUNT(*)/10) FROM dataBoard")
	public int databoardTotalPage();
	
	@Insert("INSERT INTO dataBoard VALUES("
			+"db_no_seq.nextval,#{name},#{subject},#{content},#{pwd},SYSDATE,0,#{filename},#{filesize},#{filecount})")
	public void databoardInsert(DataBoardVO vo);

	//내용 보기
	@Update("UPDATE dataBoard SET hit=hit+1 WHERE no=#{no}")
	public void databoardHitIncrement(int no);
	/*
	 * 1) 결과값 resultType=>리턴형
	 * 2) 매개변수 parameterType=>매개변수
	 */
	@Select("SELECT no,name,subject,content,regdate,hit,filename,filesize,filecount FROM dataBoard WHERE no=#{no}")
	public DataBoardVO databoardContentData(int no);
	
	//수정하기
	@Select("SELECT pwd FROM dataBoard WHERE no=#{no}")
	public String databoardGetPwd(int no); //비밀번호 확인
	@Select("SELECT filename, filesize, filecount FROM dataBoard WHERE no=#{no}")
	public DataBoardVO databoardGetFileInfo(int no);
	@Update("UPDATE dataBoard SET name=#{name}, subject=#{subject}, content=#{content}, filename=#{filename}, filesize=#{filesize}, filecount=#{filecount} WHERE no=#{no}")
	public void databoardUpdate(DataBoardVO vo);
	
	//삭제하기
	@Delete("DELETE FROM dataBoard WHERE no=#{no}")
	public void dataBoardDelete(int no);
	
}
