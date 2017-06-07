package com.sist.container;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.temp.MemberConfig;

public class MainClass3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext app = new ClassPathXmlApplicationContext("app2.xml");
		
		MemberConfig mc = app.getBean("mc", MemberConfig.class);
		mc.print();
		
	}

}
