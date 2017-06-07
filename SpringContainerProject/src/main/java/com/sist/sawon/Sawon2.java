package com.sist.sawon;

//초기값을 주는 2가지 방법 1.생성자, 2.setter 3.static블럭, 인스턴스 블럭



/*자바 메모리 구조
==================
Methode영역
static
 = data 초기화전 static int a;
 = data 초기화 static int a=10;
 ===================
 stack 지역변수, 메모리 관리(블럭을 벗어나면 메모리에서 사라지게
 ===================
 heap 프로그래머가 관리해줘야 하는데 이걸 대신 gc가해줘
  near heap
  far heap
  ====================
  class A
  int a;
  A aa=new A();
  하면 a는 heap에 aa는 stack에 저장된다.
  실제 메모리는 heap에 사용하는 메모리는 

*/
public class Sawon2 {
	private int sabun;
	private String name;
	private String dept;
	public Sawon2(int sabun, String name, String dept){
		this.sabun=sabun;
		this.name=name;
		this.dept=dept;
	}
	
	public void print(){
		System.out.println("사번: "+sabun);
		System.out.println("이름: "+name);
		System.out.println("부서: "+dept);
	}
	
}
