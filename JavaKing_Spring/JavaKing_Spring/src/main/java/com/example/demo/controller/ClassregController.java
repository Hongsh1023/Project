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
import com.example.demo.dao.ClassregDao;
import com.example.demo.vo.ClassVo;
import com.example.demo.vo.ClassregVo;

@Controller
public class ClassregController {
	
	private  int pageSize = 5;	//한 화면에 몇개 레코드가 보일지
	private  int pageMax= 5;		//몇개까지 보이고 이전,다음 보일지
	private  int totalRecord;	//db상 총 레코드가 몇갠지
	private  int totalPage;		//총 몇쪽인지
	private  HttpSession session;
	
	@Autowired
	private ClassregDao crdao;
	@Autowired
	private ClassDao cdao;
	
	public void setDao (ClassregDao crdao) {
		this.crdao=crdao;
	}
	public void setDao (ClassDao cdao) {
		this.cdao=cdao;
	}
	
	@RequestMapping(value="/classreg.do")
	public void classregForm(

			Model model,
			@RequestParam(value="site", defaultValue="1") int site,
			@RequestParam(value="pageNum", defaultValue = "1") int pageNum, 
			@RequestParam(value="search", defaultValue = "") String search,
			@RequestParam(value="option", defaultValue = "class_name") String option,
			@RequestParam(value="std_no", defaultValue = "2014104195") int std_no,
			@RequestParam(value="classno", defaultValue = "0") int class_no,
			HttpServletRequest request
			) {
		//int std_no =(Integer) session.getAttribute("std_no");
		//test 용!
		//int std_no = 2014104195; 	
		//학생정보 출력을 위한 학생정보 전달
		model.addAttribute("s", crdao.classregStudentInfoByNo(std_no));
		
		openClassList(site, pageNum, search, option, std_no, class_no, model, request);
	}
	

	public void openClassList(
		int site, int pageNum, String search, String option, int std_no, int class_no, Model model,HttpServletRequest request) 
	
	{
		//---------------검색어기억-------------------
		session = request.getSession();
		if(!search.equals("")) {
			search = search.trim();
			session.setAttribute("search", search);
		}
		if(session.getAttribute("search")!=null) {
			search = (String)session.getAttribute("search");
		}
		
		//---------------과목리스트-------------------
		
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
				session.setAttribute("mycrList", crdao.classregList(std_no));
		
		//-------------

		if(site == 2) {
			HashMap insertMap = new HashMap();
			insertMap.put("std_no", std_no);
			insertMap.put("class_no", class_no);
			String class_name = cdao.classFindByNo(class_no).getClass_name();
			int re = -1;
			re = crdao.classregInsert(insertMap);
			if(re <= 0) {
				request.setAttribute("msg", class_name+"신청에 실패했습니다.");
				request.setAttribute("color", "red");
				
				
			}else {
				request.setAttribute("msg",class_name+"신청되었습니다.");
				request.setAttribute("color", "blue");
				session.setAttribute("cCredit",crdao.classregCountCredit(std_no));
				session.setAttribute("cSubject",crdao.classregCountlRecord(std_no));
				session.setAttribute("mycrList", crdao.classregList(std_no));
			}
		
		//-------------
		
		
		
		
		
		}
			
	}
	
	
	public void classregInsert(int std_no, int class_no, Model model, HttpServletRequest request) { 
		HttpSession session = request.getSession();
		//재수강여부 체크는 다오에서 진행
		HashMap insertMap = new HashMap();
		insertMap.put("std_no", std_no);
		insertMap.put("class_no", class_no);
		String class_name = cdao.classFindByNo(class_no).getClass_name();
		int re = -1;
		re = crdao.classregInsert(insertMap);
		if(re <= 0) {
			request.setAttribute("msg", class_name+"신청에 실패했습니다.");
			request.setAttribute("color", "red");
			
			
		}else {
			request.setAttribute("msg",class_name+"신청되었습니다.");
			request.setAttribute("color", "blue");
			session.setAttribute("cCredit",crdao.classregCountCredit(std_no));
			session.setAttribute("cSubject",crdao.classregCountlRecord(std_no));
			session.setAttribute("mycrList", crdao.classregList(std_no));
		}
	}

	

}
