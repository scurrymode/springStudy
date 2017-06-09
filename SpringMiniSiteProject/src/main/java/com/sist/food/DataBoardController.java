package com.sist.food;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.sist.databoard.dao.DataBoardService;
import com.sist.databoard.dao.DataBoardVO;
@Controller
public class DataBoardController {
	@Autowired
	private DataBoardService service;
	
	@RequestMapping("main/board_list.do")
	public String board_list(String page, Model model){
		if(page==null) page="1";
		int curpage = Integer.parseInt(page);
		Map map = new HashMap();
		int rowSize=10;
		int start=(rowSize*curpage)-(rowSize-1);
		int end=(rowSize*curpage);
		map.put("start", start);
		map.put("end", end);
		
		List<DataBoardVO> list = service.databoardListData(map);
		
		model.addAttribute("main_jsp", "board/board_list.jsp");
		model.addAttribute("list", list);
		
		return "main/main";
	}
	@RequestMapping("main/board_insert.do")
	public String board_insert(Model model){
		model.addAttribute("main_jsp", "board/board_insert.jsp");
		return "main/main";
	}
	@RequestMapping("main/board_insert_ok.do")
	public String board_insert_ok(DataBoardVO vo){
		List<MultipartFile> list = vo.getUpload();
		if(list==null && list.size()==0){
			vo.setFilename("");
			vo.setFilesize("");
			vo.setFilecount(0);
		}else{
			String strName="";
			String strSize="";
			for(MultipartFile mf : list){
				String filename=mf.getOriginalFilename();
				try {
					File file = new File("c://uploading/"+filename);
					mf.transferTo(file);
					int size=(int)file.length();
					strName+=filename+",";
					strSize+=size+",";
				} catch (Exception e) {
					e.printStackTrace();
				}
				vo.setFilename(strName.substring(0, strName.lastIndexOf(",")));
				vo.setFilesize(strSize.substring(0, strSize.lastIndexOf(",")));
				vo.setFilecount(list.size());
				
				service.databoardInsert(vo);
			}
			
		}
		return "redirect:/main/board_list.do";
	}
}






