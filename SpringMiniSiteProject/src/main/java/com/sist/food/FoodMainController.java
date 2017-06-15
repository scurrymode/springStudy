package com.sist.food;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sist.food.dao.CategoryVO;
import com.sist.food.dao.FoodDAO;
import com.sist.food.dao.FoodManager;
import com.sist.food.dao.FoodReserveVO;
import com.sist.food.dao.FoodVO;
@Controller
public class FoodMainController {
	@Autowired
	private FoodManager fmgr;
	@Autowired
	private FoodDAO dao;
	
	@RequestMapping("main/main.do") //root를 기준으로 행동한다는걸 기억하면된다.
	public String main_page(Model model){
		List<CategoryVO> list = fmgr.categoryAllData();
		model.addAttribute("list", list);
		model.addAttribute("main_jsp", "default.jsp");
		return "main/main";
		
	}
	@RequestMapping("main/loc.do")
	public String main_loc(Model model){
		model.addAttribute("main_jsp", "food/food_loc.jsp");
		return "main/main";
	}
	@RequestMapping("main/foodmain.do") //root를 기준으로 행동한다는걸 기억하면된다.
	public String main_foodpage(String title, String link, Model model){
		List<FoodVO> list = fmgr.categoryDetailData(link);
		model.addAttribute("title", title);
		model.addAttribute("list", list);
		model.addAttribute("main_jsp", "food/foodmain.jsp");
		return "main/main";
	}
	@RequestMapping("main/fooddetail.do")
	public String main_fooddetail(String link, String poster, Model model){
		FoodVO vo=fmgr.foodDetailData(link);
		model.addAttribute("vo", vo);		
		model.addAttribute("poster", poster);
		model.addAttribute("main_jsp", "food/fooddetail.jsp");
		return "main/main";
	}
	@RequestMapping("main/reserve.do")
	public String main_reserve(Model model){
		model.addAttribute("main_jsp", "food/foodreserve.jsp");
		return "main/main";
	}
	
	@RequestMapping("main/reserve_gu_find.do")
	public String main_reserve_gu_find(String kind, Model model){
		List<String> list = dao.reserveLocData(kind);
		model.addAttribute("list", list);
		model.addAttribute("kind", kind);
		return "main/food/reserve_gu_find";
	}
	
	@RequestMapping("main/reserve_list.do")
	public String main_reserve_list_find(String kind, String addr, Model model){
		Map map = new HashMap();
		map.put("kind", kind);
		map.put("addr", addr);
		List<FoodReserveVO> list=dao.reserveListData(map);
		for(FoodReserveVO vo:list){
			String[] data = vo.getImage().split(",");
			vo.setPoster(data[0]);
		}
		model.addAttribute("list", list);
		return "main/food/reserve_list";
	}
	@RequestMapping("main/reserve_date.do")
	public String reserve_date(String year, String month, int no, Model model){
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-d");
		String strYear=year;
		String strMonth=month;
		StringTokenizer st = new StringTokenizer(sdf.format(date), "-");
		if(year==null){
			strYear=st.nextToken();
		}
		if(month==null){
			strMonth=st.nextToken();
		}
		//이걸 하기위해서 MM이랑 dd로 안받고 M이랑 d로 받은거다!
		int y=Integer.parseInt(strYear);
		int m=Integer.parseInt(strMonth);
		
		//week, lastday가 있어야 달력을 보여줄 수 있다.
		//전년도까지 총날수 1년1월1일부터 작년까지...ㅋ
		int total=(y-1)*365
				+(y-1)/4
				-(y-1)/100
				+(y-1)/400;
		
		int[] lastDay={31,28,31,30,31,30,31,31,30,31,30,31};
		if((y%4==0 && y%100!=0||(y%400==0))){
			//윤년조건
			lastDay[1]=29;
		}else{
			lastDay[1]=28;
		}
		for(int i=0; i<m-1;i++){
			total+=lastDay[i];
		}
		total++;
		int week=total%7;//이번달의 첫날 요일을 알려준거임
		//jsp에서 완전히 아무것도 없이 그냥 달력을 만들 수 있도록 전달하는거다.
		model.addAttribute("year", y);
		model.addAttribute("month", m);
		model.addAttribute("week", week);
		model.addAttribute("lastDay", lastDay[m-1]);
		String[] strWeek={"일","월","화","수","목","금","토"};
		model.addAttribute("strWeek",strWeek);
		
		return "main/food/reserve_date";
	}
	
}
