package com.sist.container;
class A{

	public A(){
		//������
		System.out.println("A Call...");
	}
	@Override
	protected void finalize() throws Throwable {//�Ҹ���
		System.out.println("��ü �Ҹ�!");
	}
	
}
public class MainClass2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A a=new A();
		a=null;
		System.gc();
	}

}
