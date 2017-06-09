package com.sist.databoard.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import java.util.*;
public interface DataBoardMapper {
	@Select("SELECT no, subject, name, regdate, hit, num "
			+"FROM (SELECT no, subject, name, regdate, hit, rownum as num "
			+"FROM (SELECT no, subject, name, regdate, hit "
			+"FROM dataBoard ORDER BY no DESC)) "
			+"WHERE num BETWEEN #{start} AND #{end}")
	public List<DataBoardVO> databoardListData(Map map);
	
	@Insert("INSERT INTO dataBoard VALUES("
			+"db_no_seq.nextval,#{name},#{subject},#{content},#{pwd},SYSDATE,0,#{filename},#{filesize},#{filecount})")
	public void databoardInsert(DataBoardVO vo);

}
