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
	
	private int pageSize = 5;	//한 화면에 몇개 레코드가 보일지
	private int pageMax= 5;		//몇개까지 보이고 이전,다음 보일지
	private int totalRecord;	//db상 총 레코드가 몇갠지
	private int totalPage;		//총 몇쪽인지
	private HttpSession session;

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
	
	@RequestMapping(value="/classreg.do", method = RequestMethod.GET)
	public void classregForm(


			Model model,
			@RequestParam(value="pageNum", defaultValue = "1") int pageNum, 
			@RequestParam(value="search", defaultValue = "") String search,
			@RequestParam(value="option", defaultValue = "class_name") String option,
			HttpServletRequest request
			) {
	//	int std_no =(Integer) session.getAttribute("std_no");
		int std_no = 2014104195; 	//test 용!
		//학생정보 출력을 위한 학생정보 전달
		model.addAttribute("s", crdao.classregStudentInfoByNo(std_no));
		
		//---------------과목리스트-------------------
		
		session = request.getSession();
		
		//빈칸상태로 검색을 눌렀을때 다시 보여지길 바라지만 되지않음!
		//검색이 아닌 페이지를 눌렀을대는 get으로 받기때문에 여기도 세션이 필요하다.
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
		model.addAttribute("pageStr", pageStr);
		
		HashMap listMap = new HashMap();
		listMap.put("option", "class_name");
		listMap.put("search", search);
		listMap.put("start", start);
		listMap.put("end", end);
		
		//리스트 ok! rownum 문제
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
	
	@RequestMapping(value="/classreg.do", method = RequestMethod.POST)
	public void classregSubmit(Model model,
			@RequestParam(value="pageNum", defaultValue = "1") int pageNum, 
			@RequestParam(value="search", defaultValue = "") String search,
			HttpServletRequest request
			) {
		//int std_no =(Integer) session.getAttribute("std_no");
		int std_no = 2014104195; 	//test 용!
		model.addAttribute("s", crdao.classregStudentInfoByNo(std_no));
		
		//---------------과목리스트-------------------
		
		//search 값 저장
		//빈칸상태로 검색을 눌렀을때 다시 보여지길 바라지만 되지않음!
		if(!search.equals("")) {
			search = search.trim();
			session.setAttribute("search", search);
		}
		if(session.getAttribute("search")!=null) {
			search = (String)session.getAttribute("search");
		}
		
		session = request.getSession();
		//총레코드번호
		String option = "class_name";
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
		model.addAttribute("pageStr", pageStr);
		
		HashMap listMap = new HashMap();
		listMap.put("option", "class_name");
		listMap.put("search", search);
		listMap.put("start", start);
		listMap.put("end", end);
		
		//리스트 ok! rownum 문제
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
	
	@RequestMapping("/classregInsert.do")
	public ModelAndView classregInsert(
			@RequestParam(value="stdno") int std_no,
			@RequestParam(value="classno") int class_no) { 
		//재수강여부 체크는 다오에서 진행
		ModelAndView mav = new ModelAndView("redirect:/classreg.do");
		HashMap insertMap = new HashMap();
		insertMap.put("std_no", std_no);
		insertMap.put("class_no", class_no);
		String class_name = cdao.classFindByNo(class_no).getClass_name();
		int re = -1;
		re = crdao.classregInsert(insertMap);
		if(re <= 0) {
			mav.addObject("msg", class_name+"신청에 실패했습니다.");
			mav.addObject("color", "red");
			mav.addObject("cCredit","0");
			mav.addObject("cSubject","0");
			
			
		}else {
			mav.addObject("msg",class_name+"신청되었습니다.");
			mav.addObject("color", "blue");
			mav.addObject("cCredit",crdao.classregCountCredit(std_no));
			mav.addObject("cSubject",crdao.classregCountlRecord(std_no));
			mav.addObject("mycrList", crdao.classregList(std_no));
		}
		return mav;
	}
}
