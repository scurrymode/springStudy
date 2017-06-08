package com.sist.temp;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Scanner scan = new Scanner(System.in);
			System.out.println("입력:"); //select.do?id=aaa&pwd=1234 주면 어떻게 처리될지 보자
			String cmd = scan.next();
			HandlerMapping hm = new HandlerMapping();
			List<String> list = hm.getList();
			for(String clsName:list){
				Class cls = Class.forName(clsName);
				if(cls.isAnnotationPresent(Controller.class)==false){
					continue;
				}
				 Object obj = cls.newInstance();
				 //System.out.println(obj);
				 Method[] methods = cls.getDeclaredMethods();
				 for(Method m: methods){
					 //System.out.println(m.getName());
					 RequestMapping rm = m.getAnnotation(RequestMapping.class);
					 //System.out.println(rm.value());
					 String str = cmd.substring(0,cmd.lastIndexOf("?"));
					 String data = cmd.substring(cmd.lastIndexOf("?")+1);
					 String[] datas = data.split("&");
					 Map map = new HashMap();
					 for(String s:datas){
						 StringTokenizer st = new StringTokenizer(s,"=");
						 map.put(st.nextToken(), st.nextToken());
						
					 }
					 if(str.equals(rm.value())){
						 m.invoke(obj, map.get("id"), map.get("pwd"));
					 }
				 }
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
