package com.sist.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
	@RequestMapping("main/main.do")
	public String main_page(@RequestParam("id") String id, @RequestParam("page") int page, Model model){
		
		
		model.addAttribute("msg", "id:"+id+",page"+page); //=>request.setAttribute()
		
		return "main/main"; // /main/main.jsp
	}

}
