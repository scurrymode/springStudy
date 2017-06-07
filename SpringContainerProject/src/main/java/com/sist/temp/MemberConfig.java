package com.sist.temp;

import java.util.*;
public class MemberConfig {
/*	private Member mem;

	public Member getMem() {
		return mem;
	}

	public void setMem(Member mem) {
		this.mem = mem;
	}
	
	public void print(){
		System.out.println("ID: "+mem.getId());
		System.out.println("name: "+mem.getName());
		System.out.println("addr: "+mem.getAddr());
	}*/
	
	private List<Member> list = new ArrayList<Member> ();
	private Map map = new HashMap();
	

	public Map getMap() {
		return map;
	}

	public void setMap(Map map) {
		this.map = map;
	}

	public List<Member> getList() {
		return list;
	}

	public void setList(List<Member> list) {
		this.list = list;
	}
	
	public void print(){
		for(Member m:list){
			System.out.println("ID: "+m.getId());
			System.out.println("name: "+m.getName());
			System.out.println("addr: "+m.getAddr());
			System.out.println("===================");
		}
		
		System.out.println("id: "+map.get("id"));
	}
	
}
