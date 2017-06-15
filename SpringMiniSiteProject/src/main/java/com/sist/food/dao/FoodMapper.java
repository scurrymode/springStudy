package com.sist.food.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

public interface FoodMapper {
	//중복없는 구 찾기
	@Select("SELECT DISTINCT SUBSTR(addr, INSTR(addr,' ',1,1)+1, INSTR(addr,' ',1,2)-INSTR(addr,' ',1,1)) as gu FROM food WHERE kind=#{kind} ORDER BY gu ASC")
	public List<String> reserveLocData(String kind);
	
	@Select("SELECT no, name, tel, addr, image FROM food WHERE addr LIKE '%'||#{addr}||'%' AND kind=#{kind}")
	public List<FoodReserveVO> reserveListData(Map map);
}
