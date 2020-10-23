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
import org.springframework.web.servlet.view.InternalResourceView;

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
	
	@RequestMapping(value="/classreg.do") //기본뷰
	public void classregForm(
			Model model,
			@RequestParam(value="pageNum", defaultValue = "1") int pageNum, 
			@RequestParam(value="search", defaultValue = "") String search,
			@RequestParam(value="option", defaultValue = "class_name") String option,
			@RequestParam(value="std_no", defaultValue = "2014104195") int std_no,
			HttpServletRequest request
			) {
		//int std_no =(Integer) session.getAttribute("std_no");
		//학생정보 출력을 위한 학생정보 전달
		model.addAttribute("s", crdao.classregStudentInfoByNo(std_no));

		//---------------검색어기억-------------------
		session = request.getSession();
		if(!search.equals("")) {
			search = search.trim();
			session.setAttribute("search", search);
			//수강신청결과메시지 삭제
			session.setAttribute("msg", "");
			session.setAttribute("color", "");
		}
		if(session.getAttribute("search")!=null) {
			search = (String)session.getAttribute("search");
		}
		
		//-------------등록내역,수,학점기억-----------------
		
		model.addAttribute("cSubject", crdao.classregCountlRecord(std_no));
		model.addAttribute("cCredit", crdao.classregCountCredit(std_no));
		model.addAttribute("mycrList", crdao.classregList(std_no));
		
		
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
				
				
	}
	@RequestMapping(value="/classregInsert.do") //insert뷰
	public ModelAndView classregInsert(
			Model model,
			@RequestParam(value="std_no", defaultValue = "2014104195") int std_no,
			@RequestParam(value="classno") int class_no,
			HttpServletRequest request
			) {
		//int std_no =(Integer) session.getAttribute("std_no");
		//학생정보 출력을 위한 학생정보 전달
		model.addAttribute("s", crdao.classregStudentInfoByNo(std_no));
		
		HashMap insertMap = new HashMap();
		insertMap.put("std_no", std_no);
		insertMap.put("class_no", class_no);
		String class_name = cdao.classFindByNo(class_no).getClass_name();
		int re = -1;
		re = crdao.classregInsert(insertMap);
		if(re <= 0) {
			session.setAttribute("msg", class_name+"신청에 실패했습니다.");
			session.setAttribute("color", "red");
			
			
		}else {
			session.setAttribute("msg",class_name+"신청되었습니다.");
			session.setAttribute("color", "blue");
			session.setAttribute("cCredit",crdao.classregCountCredit(std_no));
			session.setAttribute("cSubject",crdao.classregCountlRecord(std_no));
			session.setAttribute("mycrList", crdao.classregList(std_no));
		}
		
		//-------------
		
		ModelAndView mav = new ModelAndView("redirect:/classreg.do");
		return mav;
		
	}
	@RequestMapping(value="/classregDelete.do") //삭제뷰
	public ModelAndView classregDelete(
			Model model,
			@RequestParam(value="std_no", defaultValue = "2014104195") int std_no,
			@RequestParam(value="classregno") int classreg_no,
			HttpServletRequest request
			) {
		//int std_no =(Integer) session.getAttribute("std_no");
		//학생정보 출력을 위한 학생정보 전달
		model.addAttribute("s", crdao.classregStudentInfoByNo(std_no));
		
		session.setAttribute("msg", "");
		session.setAttribute("color", "");
		
		HashMap deleteMap = new HashMap();
		deleteMap.put("std_no", std_no);
		deleteMap.put("classreg_no", classreg_no);
		crdao.classregDelete(deleteMap);
		session.setAttribute("cCredit",crdao.classregCountCredit(std_no));
		session.setAttribute("cSubject",crdao.classregCountlRecord(std_no));
		session.setAttribute("mycrList", crdao.classregList(std_no));
		//-------------
		
		ModelAndView mav = new ModelAndView("redirect:/classreg.do");
		return mav;
		
	}

	@RequestMapping(value="/printClassreg.do") //삭제뷰
	public void printClassreg(
			@RequestParam(value="std_no", defaultValue = "2014104195") int std_no,
			HttpServletRequest request) {
		
		session = request.getSession();
				
		//수강신청 하단의 신청내역
		session.setAttribute("crList", crdao.classregList(std_no));
		
		//신청 점수, 갯수
		session.setAttribute("cCredit",crdao.classregCountCredit(std_no));
		session.setAttribute("cSubject",crdao.classregCountlRecord(std_no));
	}
			
}
