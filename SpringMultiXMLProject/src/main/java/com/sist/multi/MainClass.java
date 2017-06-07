package com.sist.multi;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.user.UserMain;

//��ǻ� JSP ������ �� Ŭ����
public class MainClass {
	private UserMain um;
	
	public void setUm(UserMain um) {
		this.um = um;
	}

	public static void main(String[] args) {
		String[] xml={"application-context.xml","application-datasource.xml","application-security.xml"};
		ApplicationContext app = new ClassPathXmlApplicationContext("application-*.xml");
		MainClass mc = (MainClass)app.getBean("mc");
		mc.um.display();
	}
}
