package com.sist.sawon;

//�ʱⰪ�� �ִ� 2���� ��� 1.������, 2.setter 3.static��, �ν��Ͻ� ��



/*�ڹ� �޸� ����
==================
Methode����
static
 = data �ʱ�ȭ�� static int a;
 = data �ʱ�ȭ static int a=10;
 ===================
 stack ��������, �޸� ����(���� ����� �޸𸮿��� �������
 ===================
 heap ���α׷��Ӱ� ��������� �ϴµ� �̰� ��� gc������
  near heap
  far heap
  ====================
  class A
  int a;
  A aa=new A();
  �ϸ� a�� heap�� aa�� stack�� ����ȴ�.
  ���� �޸𸮴� heap�� ����ϴ� �޸𸮴� 

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
		System.out.println("���: "+sabun);
		System.out.println("�̸�: "+name);
		System.out.println("�μ�: "+dept);
	}
	
}
