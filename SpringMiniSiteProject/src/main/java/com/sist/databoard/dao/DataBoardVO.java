package com.sist.databoard.dao;

import java.util.*;

import org.springframework.web.multipart.MultipartFile;

/*
 * 		오라클	=>	자바
 * 		CHAR(2000byte) => String
 * 		VARCHAR2(4000byte)  => String
 * 		CLOB(4giga) 9i까지는 InputStream으로 받아서 가져와야했다. 10g부터 String으로 받을 수 있음
 *		NUMBER(default 14) => int, double, long
 *		NUMBER(7,2) 7자리중 2자리는 소수점 => double
 *		DATE, TIMESTAMP => Date(java.util.Date(o), java.sql.Date(x)), TimeStamp
 */
public class DataBoardVO {
	private int no;
	private String name;
	private String subject;
	private String content;
	private String pwd;
	private Date regdate;
	private int hit;
	private String filename;
	private String filesize;
	private int filecount;
	private List<MultipartFile> upload;
	private List<DataBoardFileVO> fileList = new ArrayList<DataBoardFileVO>(); //파일이름과 사이즈를 하나로 묶어서 보내주려공~!
	private int replycount; //댓글갯수
	
	
	public int getReplycount() {
		return replycount;
	}

	public void setReplycount(int replycount) {
		this.replycount = replycount;
	}

	public List<DataBoardFileVO> getFileList() {
		return fileList;
	}

	public void setFileList(List<DataBoardFileVO> fileList) {
		this.fileList = fileList;
	}

	public List<MultipartFile> getUpload() {
		return upload;
	}

	public void setUpload(List<MultipartFile> upload) {
		this.upload = upload;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getFilesize() {
		return filesize;
	}

	public void setFilesize(String filesize) {
		this.filesize = filesize;
	}

	public int getFilecount() {
		return filecount;
	}

	public void setFilecount(int filecount) {
		this.filecount = filecount;
	}

}
