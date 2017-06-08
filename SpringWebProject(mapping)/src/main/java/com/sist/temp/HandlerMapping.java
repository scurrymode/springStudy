package com.sist.temp;
import java.util.*;
public class HandlerMapping {
	private List<String> list=new ArrayList<String>();
	
	public HandlerMapping(){
		
		//xml 파싱이 끝난 상태 이제 들어있는걸 요청에 따라 넘겨주는 역할을 하는게 handlerMapping
		list.add("com.sist.temp.AController");
		list.add("com.sist.temp.BController");
		list.add("com.sist.temp.CController");
	}

	public List<String> getList() {
		return list;
	}
	
	
}
