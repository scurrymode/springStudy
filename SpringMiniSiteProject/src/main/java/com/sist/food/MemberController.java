package com.sist.food;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sist.member.dao.MemberDAO;
import com.sist.member.dao.MemberVO;
import com.sist.member.dao.ZipcodeVO;

@Controller
public class MemberController {
	@Autowired
	private MemberDAO dao;
	@RequestMapping("main/join.do")
	public String member_join(Model model){
		model.addAttribute("main_jsp", "member/join.jsp");
		return "main/main";
	}
	@RequestMapping("main/join_ok.do")
	public String member_join_ok(Model model, MemberVO vo){
		vo.setPost(vo.getPost1()+"-"+vo.getPost2()); //따로따로 받았지만 한번에 DB에 넣기
		vo.setTel(vo.getTel1()+"-"+vo.getTel2());
		dao.memberInsert(vo);//데이터 등록
		model.addAttribute("main_jsp", "member/join_ok.jsp");
		return "main/main";
	}
	
	@RequestMapping("main/idcheck.do")
	public String member_idcheck(){
		return "main/member/idcheck";
	}
	@RequestMapping("main/idcheck_result.do")
	public String member_idcheck_result(Model model, String id){
		int count = dao.memberIdcheck(id);
		model.addAttribute("id", id);
		model.addAttribute("count", count);
		return "main/member/idcheck_result";
	}
	
	@RequestMapping("main/postfind.do")
	public String member_postfind(){
		return "main/member/postfind";
	}
	@RequestMapping("main/postfind_result.do")
	public String member_postfind_result(String dong, Model model){
		System.out.println(dong+"동");
		List<ZipcodeVO> list =dao.zipcodeListData(dong);
		model.addAttribute("list", list);
		model.addAttribute("count", list.size());
		return "main/member/postfind_result";
	}
	
	@RequestMapping("main/login.do")
	public String member_login(String id, String pwd, Model model, HttpSession session){//로그인하고 정보를 세션에 담기 위해 가져온다.
		//경우의 수 3가지 아이디 잘못, 패스워드 잘못, 로그인 성공
		int count=dao.memberIdcheck(id);
		String res="";
		if(count==0){
			res="NOID";
		}else{
			String db_pwd = dao.memberGetPwd(id);
			if(db_pwd.equals(pwd)){
				res="OK";
				MemberVO vo = dao.memberInfoData(id);
				session.setAttribute("id", vo.getId());
				session.setAttribute("name", vo.getName());
				session.setAttribute("admin", vo.getAdmin());
			}else{
				res="NOPWD";
			}
		}
		model.addAttribute("res",res);
		return "main/member/login";
	}
	@RequestMapping("main/logout.do")
	public String member_logout(HttpSession session){
		session.invalidate();
		return "redirect:/main/main.do";
	}
	
	
	
	
}
