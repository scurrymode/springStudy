package com.sist.container;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.sawon.Sawon2;

//main,jsp
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext app = new ClassPathXmlApplicationContext("app.xml");
		//�̰� �Ľ��� �̷�����. WEB�� dispatcher�� �־ �̷� ������ �����Ȱ�
		
//		Sawon sa=(Sawon)app.getBean("sa"); //�̰� DL
//		System.out.println("sa="+sa);
//		Sawon sa1=(Sawon)app.getBean("sa"); //�̰� DL
//		System.out.println("sa1="+sa1);
//		
//		Sawon sap=(Sawon)app.getBean("sap"); //�̰� DL
//		System.out.println("sa="+sap);
//		Sawon sap1=(Sawon)app.getBean("sap"); //�̰� DL
//		sap1.setSabun(2);
//		sap1.setName("��û��");
//		sap1.setDept("������");
//		System.out.println("sa1="+sap1);
//		//sap.init();
//		sap.print();
//		//sap1.init();
//		sap1.print();
		
		Sawon2 sa = (Sawon2)app.getBean("sa2");
		sa.print();
	}

}
