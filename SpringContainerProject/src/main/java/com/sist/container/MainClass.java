package com.sist.container;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.sawon.Sawon2;

//main,jsp
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext app = new ClassPathXmlApplicationContext("app.xml");
		//이게 파싱이 이뤄진다. WEB은 dispatcher가 있어서 이런 과정이 생략된거
		
//		Sawon sa=(Sawon)app.getBean("sa"); //이게 DL
//		System.out.println("sa="+sa);
//		Sawon sa1=(Sawon)app.getBean("sa"); //이게 DL
//		System.out.println("sa1="+sa1);
//		
//		Sawon sap=(Sawon)app.getBean("sap"); //이게 DL
//		System.out.println("sa="+sap);
//		Sawon sap1=(Sawon)app.getBean("sap"); //이게 DL
//		sap1.setSabun(2);
//		sap1.setName("심청이");
//		sap1.setDept("영업부");
//		System.out.println("sa1="+sap1);
//		//sap.init();
//		sap.print();
//		//sap1.init();
//		sap1.print();
		
		Sawon2 sa = (Sawon2)app.getBean("sa2");
		sa.print();
	}

}
