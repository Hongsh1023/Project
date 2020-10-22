package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dao.ClassDao;
import com.example.demo.dao.ClassregDao;
import com.example.demo.vo.ClassVo;

public class OpenPage {
	
	private static int pageSize = 5;	//한 화면에 몇개 레코드가 보일지
	private static int pageMax= 5;		//몇개까지 보이고 이전,다음 보일지
	private static int totalRecord;	//db상 총 레코드가 몇갠지
	private static int totalPage;		//총 몇쪽인지
	private static HttpSession session;
	private static HttpServletRequest request;
	
	@Autowired
	private static ClassregDao crdao;
	@Autowired
	private static ClassDao cdao;
	
	public void setDao (ClassregDao crdao) {
		this.crdao=crdao;
	}
	public void setDao (ClassDao cdao) {
		this.cdao=cdao;
	}
	
	
	public static void openClassList(int site, int pageNum, String search, String option) {
		session = request.getSession();
		//---------------과목리스트-------------------
		if(!search.equals("")) {
			search = search.trim();
			session.setAttribute("search", search);
		}
		if(session.getAttribute("search")!=null) {
			search = (String)session.getAttribute("search");
		}
		
		//총레코드번호
		HashMap recordMap = new HashMap();
		recordMap.put("option", option);
		recordMap.put("search", search);
		totalRecord = cdao.classTotalRecord(recordMap);
		
		//한페이지의 시작종료레코드
		int start = (pageNum-1)*pageSize+1;
		int end = start+pageSize-1;
		if(end > totalRecord) {
			end = totalRecord;
		}	
		
		//페이지 ok
		totalPage = (int)Math.ceil((double)totalRecord / pageSize);
		if(totalPage == 0) {
			totalPage =1;
		}
		String pageStr = "";
		int startPage = (pageNum-1)/pageMax*pageMax+1;
		int endPage = startPage+pageMax-1;
		if(endPage > totalPage) {
			endPage = totalPage;
		}
		
		if(startPage > 1) {
			pageStr +="<a href='classreg.do?pageNum="+(startPage-1)+"'> [이전] </a>";
		}
		for(int i=startPage;i<=endPage;i++) {
			pageStr += "<a href='classreg.do?pageNum="+i+"'>"+ i + "</a> ";
		}
		if(totalPage > endPage) {
			pageStr += "<a href='classreg.do?pageNum="+(endPage+1)+"'> [다음] </a>";
		}
		
		System.out.println("startPage, endPage: "+startPage+","+endPage);
		request.setAttribute("pageStr", pageStr);
		
		HashMap listMap = new HashMap();
		listMap.put("option", "class_name");
		listMap.put("search", search);
		listMap.put("start", start);
		listMap.put("end", end);
		
		//리스트
		List<ClassVo> list = null;
		list = cdao.classList(listMap);
		session.setAttribute("cr_list", list);
		System.out.println("리스트 길이: "+list.size());
		System.out.println("리스트 내용: ");
		for(ClassVo c : list ) {
			System.out.print(c.getClass_name()+" ");
			System.out.println("");
		}
	}
}
