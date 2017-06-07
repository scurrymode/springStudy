package com.sist.sawon;
/*
 * 컨테이너(클래스 관리)
 * ==> 종류
 * 	   BeanFactory : core(DI, DL)
 * 			|
 * 	ApplicationContext : core(DI, DL), AOP, 국제화
 * 			|
 * WebApplicationContext : core(DI, DL), AOP, 국제화, web(MVC)
 * 
 * ==> 동작
 * 1) XML 읽기
 * 2) XML 파싱
 * 3) 클래스 메모리 할당, 생성자 DI
 * 4) setter DI
 * 5) 메소드 호출: init-method
 * ==========================
 * 프로그래머가 원하는 메소드 활용(DL)
 *============================
 * 6) 메소드 호출: destroy-method
 */
public class Sawon {
	private int sabun;
	private String name;
	private String dept;
	public int getSabun() {
		return sabun;
	}
	public void setSabun(int sabun) {
		this.sabun = sabun;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public void init(){
		System.out.println("======사원정보======");
	}
	public void destory(){
		System.out.println("메모리해제");
	}
	
	public void print(){
		System.out.println("사번: "+sabun);
		System.out.println("이름: "+name);
		System.out.println("부서: "+dept);
	}
}
