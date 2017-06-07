package com.sist.container;
class A{

	public A(){
		//积己磊
		System.out.println("A Call...");
	}
	@Override
	protected void finalize() throws Throwable {//家戈磊
		System.out.println("按眉 家戈!");
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
