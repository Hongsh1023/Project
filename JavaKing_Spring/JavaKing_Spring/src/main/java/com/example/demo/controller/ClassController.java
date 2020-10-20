package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.ClassDao;
import com.example.demo.vo.ClassVo;


@Controller
public class ClassController {

	private int pageSize = 10;	//한 화면에 몇개 레코드가 보일지
	private int pageMax= 5;		//몇개까지 보이고 이전,다음 보일지
	private int totalRecord;	//db상 총 레코드가 몇갠지
	private int totalPage;		//총 몇쪽인지
	private HttpSession session;
	
	@Autowired
	private ClassDao dao;
	
	public void setDao (ClassDao dao) {
		this.dao=dao;
	}
	@RequestMapping(value="/class.do")
	public void listClass(
			@RequestParam(value="pageNum", defaultValue = "1") int pageNum, 
			@RequestParam(value="search", defaultValue = "") String search,
			@RequestParam(value="option", defaultValue = "class_name") String option,
			HttpServletRequest request, Model model) {
		
		session = request.getSession();
		
		//search, option 값 저장
		//빈칸상태로 검색을 눌렀을때 다시 보여지길 바라지만 되지않음!
		if(!search.equals("")) {
			search = search.trim();
			option = option.trim();
			session.setAttribute("search", search);
			session.setAttribute("option", option);
		}
		
		if(session.getAttribute("search")!=null) {
			search = (String)session.getAttribute("search");
			option = (String)session.getAttribute("option");
		}
		
		
		//레코드번호 ok
		HashMap mapRecord = new HashMap();
		mapRecord.put("search", search);
		mapRecord.put("option", option);
		System.out.println("search,option: "+mapRecord.get("search")+","+mapRecord.get("option"));
		totalRecord = dao.classTotalRecord(mapRecord);
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
			pageStr +="<a href='class.do?pageNum="+(startPage-1)+"'> [이전] </a>";
		}
		for(int i=startPage;i<=endPage;i++) {
			pageStr += "<a href='class.do?pageNum="+i+"'>"+ i + "</a> ";
		}
		if(totalPage > endPage) {
			pageStr += "<a href='class.do?pageNum="+(endPage+1)+"'> [다음] </a>";
		}
		
		System.out.println("startPage, endPage: "+startPage+","+endPage);
		model.addAttribute("pageStr", pageStr);
		
		HashMap map = new HashMap();
		map.put("start", start);
		map.put("end", end);
		map.put("search", search);
		map.put("option", option);
		System.out.println("map에서 start,end,totalRecord,search,option: "+map.get("start")+","+map.get("end")+","+totalRecord+","+map.get("search")+","+map.get("option"));	//map 인식 ok
		
		//리스트 ok! rownum 문제
		List<ClassVo> list = null;
		list = dao.classList(map);
		session.setAttribute("class_list", list);
		System.out.println("리스트 길이: "+list.size());
		System.out.println("리스트 내용: ");
		for(ClassVo c : list ) {
			System.out.print(c.getClass_name()+" ");
			System.out.println("");
		}
		
	}
	
	
}
