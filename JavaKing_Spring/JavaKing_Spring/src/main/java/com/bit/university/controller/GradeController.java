package com.bit.university.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bit.university.dao.GradeDao;
import com.bit.university.vo.GradeVo;

@Controller
public class GradeController {
	
	@Autowired
	private GradeDao dao;

	public void setDao(GradeDao dao) {
		this.dao = dao;
	}
	
	//@RequestMapping(value="/listGrade.do", method = RequestMethod.GET)
	public void listForm() {
	}
	
	@RequestMapping(value="/listGrade.do", method = RequestMethod.GET)
	public void listAll(HttpServletRequest request, Model model) {
		//int std_no = (Integer)request.getSession().getAttribute("std_no");
		int std_no = 2014104194;
		request.getSession().setAttribute("std_no",std_no);
		List<GradeVo> list = dao.listAll(std_no);
		model.addAttribute("grade_list",list);
		request.getSession().setAttribute("grade_list",list);
	}
	
	@RequestMapping("/detailGrade.do")
	public void detail(HttpServletRequest request, Model model) {
		int std_no = (Integer)request.getSession().getAttribute("std_no");
		String year = request.getParameter("year");
		int semester = Integer.parseInt(request.getParameter("semester"));
		HashMap map = new HashMap();
		map.put("year", year);
		map.put("semester", semester);
		map.put("std_no", std_no);
		model.addAttribute("dlist",dao.detail(map));
	}
	
	@RequestMapping(value="adminGrade.do", method=RequestMethod.GET)
	public void insertForm() {
	}
	
	@RequestMapping(value="adminGrade.do", method=RequestMethod.POST)
	public ModelAndView insertSubmit(GradeVo vo) {
		ModelAndView mav = new ModelAndView("redirect:/main.do");
		int score = vo.getGrade_score();
		if(score>=95) {
			vo.setGrade_rank("A+");
		}else if(score>=90) {
			vo.setGrade_rank("A");
		}else if(score>=85) {
			vo.setGrade_rank("B+");
		}else if(score>=80) {
			vo.setGrade_rank("B");
		}else if(score>=75) {
			vo.setGrade_rank("C+");
		}else if(score>=70) {
			vo.setGrade_rank("C");
		}else if(score>=65) {
			vo.setGrade_rank("D+");
		}else if(score>=60) {
			vo.setGrade_rank("D");
		}else {
			vo.setGrade_rank("F");
		}
		System.out.println(vo);
		int re = dao.insert(vo);
		if(re <= 0) {
			mav.addObject("msg", "추가에 실패하였습니다.");
			mav.setViewName("error");
		}
		return mav;
	}
	
	@RequestMapping(value="updateGrade.do", method=RequestMethod.GET)
	public void updateForm(int grade_no, Model model) {
		model.addAttribute("g", dao.findByNo(grade_no));
	}
	
	@RequestMapping(value="updateGrade.do", method=RequestMethod.POST)
	public ModelAndView updateSubmit(GradeVo vo) {
		ModelAndView mav = new ModelAndView("redirect:/updateGrade.do");
		int score = vo.getGrade_score();
		if(score>=95) {			vo.setGrade_rank("A+");}
		else if(score>=90) {	vo.setGrade_rank("A");}
		else if(score>=85) {	vo.setGrade_rank("B+");}
		else if(score>=80) {	vo.setGrade_rank("B");}
		else if(score>=75) {	vo.setGrade_rank("C+");}
		else if(score>=70) {	vo.setGrade_rank("C");}
		else if(score>=65) {	vo.setGrade_rank("D+");}
		else if(score>=60) {	vo.setGrade_rank("D");}
		else {	vo.setGrade_rank("F");}
		
		int re = dao.update(vo);
		if(re <= 0) {
			mav.addObject("msg", "수정에 실패하였습니다.");
			mav.setViewName("error");
		}
		return mav;
	}
	
	@RequestMapping(value="deleteGrade.do", method = RequestMethod.GET)
	public void deleteForm(int grade_no, Model model) {
		model.addAttribute("grade_no",grade_no);
	}
	
	@RequestMapping(value="deleteGrade.do", method = RequestMethod.POST)
	public ModelAndView deleteSubmit(int grade_no, Model model) {
		ModelAndView mav = new ModelAndView("redirect:/deleteGrade.do");
		int re = dao.delete(grade_no);
		if(re <= 0) {
			mav.addObject("msg", "삭제에 실패하였습니다.");
			mav.setViewName("error");
		}
		return mav;
	}
}
