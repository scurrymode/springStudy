package com.sist.sawon;
/*
 * �����̳�(Ŭ���� ����)
 * ==> ����
 * 	   BeanFactory : core(DI, DL)
 * 			|
 * 	ApplicationContext : core(DI, DL), AOP, ����ȭ
 * 			|
 * WebApplicationContext : core(DI, DL), AOP, ����ȭ, web(MVC)
 * 
 * ==> ����
 * 1) XML �б�
 * 2) XML �Ľ�
 * 3) Ŭ���� �޸� �Ҵ�, ������ DI
 * 4) setter DI
 * 5) �޼ҵ� ȣ��: init-method
 * ==========================
 * ���α׷��Ӱ� ���ϴ� �޼ҵ� Ȱ��(DL)
 *============================
 * 6) �޼ҵ� ȣ��: destroy-method
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
		System.out.println("======�������======");
	}
	public void destory(){
		System.out.println("�޸�����");
	}
	
	public void print(){
		System.out.println("���: "+sabun);
		System.out.println("�̸�: "+name);
		System.out.println("�μ�: "+dept);
	}
}
