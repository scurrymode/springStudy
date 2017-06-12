package com.sist.food;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.sist.databoard.dao.DataBoardFileVO;
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
		
		
		model.addAttribute("list", list);
		//curpage
		//totalpage
		int totalpage=service.databoardTotalPage();
		model.addAttribute("curpage", curpage);
		model.addAttribute("totalpage", totalpage);
		model.addAttribute("main_jsp", "board/board_list.jsp");
		
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
		if(list==null){
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
					mf.transferTo(file); //파일 저장하기
					int size=(int)file.length(); //파일 길이 파악
					strName+=filename+",";
					strSize+=size+",";
				} catch (Exception e) {
					e.printStackTrace();
				}
				vo.setFilename(strName.substring(0, strName.lastIndexOf(",")));
				vo.setFilesize(strSize.substring(0, strSize.lastIndexOf(",")));
				vo.setFilecount(list.size());
				
			}			
		}
		service.databoardInsert(vo);
		return "redirect:/main/board_list.do";
	}
	
	@RequestMapping("main/board_content.do")
	public String board_content(int no, int page, Model model){
		DataBoardVO vo=service.databoardContentData(no);
		if(vo.getFilecount()>0){
			List<DataBoardFileVO> list = new ArrayList<DataBoardFileVO>();
			String[] fileArr = vo.getFilename().split(",");
			String[] sizeArr = vo.getFilesize().split(",");
			for(int i=0; i<fileArr.length;i++){
				DataBoardFileVO fvo = new DataBoardFileVO();
				fvo.setFilename(fileArr[i]);
				fvo.setFilesize(Long.parseLong(sizeArr[i]));
				list.add(fvo);
			}
			vo.setFileList(list);
		}
		model.addAttribute("vo", vo);
		model.addAttribute("page", page);
		model.addAttribute("main_jsp", "board/board_content.jsp");
		return "main/main";
	}
	
	@RequestMapping("main/board_download.do")
	public void board_download(String fn, HttpServletResponse response){
		try{
			response.setHeader("Content-Disposition", "attachment;filename="+URLEncoder.encode(fn,"UTF-8"));
			File file = new File("c://uploading/"+fn);
			response.setContentLength((int)file.length());
			
			BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file)); //서버에서 데이터를 가져오고
			BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream()); //상대방에게 전달해줌
			int i=0;
			byte[] buffer = new byte[1024]; //버퍼에 1024씩 담아~!
			while((i=bis.read(buffer, 0, 1024))!=-1){
				bos.write(buffer, 0, i);
			}
			bis.close();
			bos.close();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	@RequestMapping("main/board_update.do")
	public String board_update(Model model, int no, int page){
		
		DataBoardVO vo = service.databoardUpdateData(no);
		model.addAttribute("vo", vo);
		model.addAttribute("page", page);		
		model.addAttribute("main_jsp", "board/board_update.jsp");
			
		return "main/main";
	}
	
	@RequestMapping("main/board_update_ok.do")//이렇게 하면 스프링이 알아서 submit했으니깐 다 vo에 채워서 받는거다~! 이게 제일 매력~!
	@ResponseBody
	public String board_update_ok(DataBoardVO vo, int page){
		boolean bCheck=false;
		try {
			String pwd=service.databoardGetPwd(vo.getNo());
			if(pwd.equals(vo.getPwd())){//비밀번호 맞을때
				bCheck=true;
				List<MultipartFile> list = vo.getUpload();
				DataBoardVO fvo = service.databoardGetFileInfo(vo.getNo());
				if(list==null){//파일업로드를 안했음
					vo.setFilename(fvo.getFilename());
					vo.setFilesize(fvo.getFilesize());
					vo.setFilecount(fvo.getFilecount());
					
				}else{//수정하면서 파일 업로드 했기에 기존 파일이 다 삭제되고 새로 올려야함
					if(fvo.getFilecount()>0){//기존에 파일이 있었으니깐~! 지우고 없었으면 걍 둬~!
						String[] files = fvo.getFilename().split(",");
						for(String f:files){
							File ff = new File("c://uploading/"+f);
							ff.delete();
						}
					}
					String strName="";
					String strSize="";
					for(MultipartFile mf : list){
						String filename=mf.getOriginalFilename();
						try {
							File file = new File("c://uploading/"+filename);
							mf.transferTo(file); //파일 저장하기
							int size=(int)file.length(); //파일 길이 파악
							strName+=filename+",";
							strSize+=size+",";
						} catch (Exception e) {
							e.printStackTrace();
						}
						vo.setFilename(strName.substring(0, strName.lastIndexOf(",")));
						vo.setFilesize(strSize.substring(0, strSize.lastIndexOf(",")));
						vo.setFilecount(list.size()); //파일 갯수만큼 설정
						//나머지 name이나 content이런건 자동으로 vo에 담겨져 있다~ 짱신기~!
					}
					service.databoardUpdate(vo);
				}
				
			}else{
				bCheck=false;
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		String send="";
		if(bCheck==true){
			send="<script>location.href=\"board_content.do?no="+vo.getNo()+"&page="+page+"\";</script>";
		}else{
			send="<script>alert(\"비밀번호가 틀립니다\");history.back();</script>";
		}
		return send;
	}
	
	
	
	
	
	
	
	
	
	
}






