package com.sist.food;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sist.food.dao.CategoryVO;
import com.sist.food.dao.FoodManager;
import com.sist.news.NewsManager;
@Controller
public class FoodMainController {
	@Autowired
	private FoodManager fmgr;
	
	@RequestMapping("main/main.do") //root를 기준으로 행동한다는걸 기억하면된다.
	public String main_page(Model model){
		List<CategoryVO> list = fmgr.categoryAllData();
		model.addAttribute("list", list);
		
		model.addAttribute("main_jsp", "default.jsp");
		
		return "main/main";
		
	}
}
