package com.sist.anno;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.dao.Board;

public class MainClass {
//	@Autowired
//	@Qualifier("freeb")
	@Resource(name="freeb")
	private Board board;
	
	@Resource(name="rb")
	private Board board2;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext app = new ClassPathXmlApplicationContext("app.xml");
		MainClass mc = app.getBean("mc", MainClass.class);
		mc.board.select();
		mc.board2.delete();
	}

}
