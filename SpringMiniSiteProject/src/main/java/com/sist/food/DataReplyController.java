package com.sist.food;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sist.databoard.dao.DataBoardService;
import com.sist.databoard.dao.DataReplyVO;

@Controller
public class DataReplyController {
	@Autowired
	private DataBoardService service;
	@RequestMapping("main/reply_new_insert.do")
	public String reply_new_insert(int bno, int page, String msg, HttpSession session){
		
		DataReplyVO vo = new DataReplyVO();
		vo.setBno(bno);
		vo.setId((String)session.getAttribute("id"));
		vo.setName((String)session.getAttribute("name"));
		vo.setMsg(msg);
		service.replyNewInsert(vo);
		return "redirect:/main/board_content.do?no="+bno+"&page="+page;
	}
	@RequestMapping("main/reply_update.do")
	public String reply_update(int page, DataReplyVO vo){
		service.replyUpdate(vo);
		return "redirect:/main/board_content.do?no="+vo.getBno()+"&page="+page;
	}
	@RequestMapping("main/reply_re_insert.do")
	public String replyReInsert(int pno, int bno, int page, String msg, HttpSession session){
		DataReplyVO vo = new DataReplyVO();
		vo.setBno(bno);
		vo.setId((String)session.getAttribute("id"));
		vo.setName((String)session.getAttribute("name"));
		vo.setMsg(msg);
		service.replyReInsert(pno, vo);
		return "redirect:/main/board_content.do?no="+bno+"&page="+page;
	}
	@RequestMapping("main/reply_delete.do")
	public String reply_delete(int bno, int page, int no){
		service.replyDelete(no);
		return "redirect:/main/board_content.do?no="+bno+"&page="+page;
	}

}
