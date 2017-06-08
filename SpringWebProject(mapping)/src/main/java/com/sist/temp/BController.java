package com.sist.temp;
@Controller
public class BController {
	@RequestMapping("update.do")
	public void update(String id, String pwd){
		System.out.println("update() Call..."+id+" "+pwd);
	}
	@RequestMapping("delete.do")
	public void delete(String id, String pwd){
		System.out.println("delete() Call..."+id+" "+pwd);
	}
}
