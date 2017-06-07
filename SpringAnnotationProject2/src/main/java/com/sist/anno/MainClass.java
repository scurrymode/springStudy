package com.sist.anno;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.sist.dao.EmpDAO;
import com.sist.dao.EmpVO;

@Component("mc")
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext app = new ClassPathXmlApplicationContext("app.xml");
		EmpDAO dao = (EmpDAO)app.getBean("empDAO");
		/*List<EmpVO> list = dao.empAllData();
		for(EmpVO vo : list){
			System.out.println(vo.getEname());
		}*/
		
		/*EmpVO vo = dao.empFindData(7788);
		System.out.println(vo.getEmpno()+" "+vo.getEname()+" "+vo.getJob());*/
		
		
		EmpVO vo1 = new EmpVO();
		vo1.setEname("È«±æµ¿");
		vo1.setJob("´ë¸®");
		vo1.setSal(3000);
		dao.empInsert(vo1);
		
		List<EmpVO> list = dao.empAllData();
		for(EmpVO vo : list){
			System.out.println(vo.getEmpno()+" "+vo.getEname()+" "+vo.getJob());
			
		}
		
	}	

}
