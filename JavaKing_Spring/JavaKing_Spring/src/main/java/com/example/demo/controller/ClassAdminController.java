package com.example.demo.controller;


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
public class ClassAdminController {

	private HttpSession session;
	
	@Autowired
	private ClassDao dao;
	
	public void setDao (ClassDao dao) {
		this.dao=dao;
	}
	// insert---------------------------------------
	
	@RequestMapping(value="/adminClass.do", method=RequestMethod.GET)
	public void insertClassForm(Model model) {
		model.addAttribute("class_no", dao.classNextNo());
		System.out.println("다음번호: "+dao.classNextNo());
	}
	@RequestMapping(value="/adminClass.do", method=RequestMethod.POST)
	public ModelAndView insertClassSubmit(ClassVo c_vo) {
		
		ModelAndView mav = new ModelAndView();
		int re = -1;
		re = dao.classInsert(c_vo);
		if(re <= 0) {
			mav.setViewName("redirect:/adminClass.do");
		}else {
			mav.setViewName("redirect:/class.do");
		}
		return mav;
	}
	
	
	// update---------------------------------------
	
	@RequestMapping(value="/adminClassEdit.do", method=RequestMethod.GET)
	public void updateClassForm(Model model, int classno) {
		model.addAttribute("c", dao.classFindByNo(classno));
		System.out.println("수정글번호: "+classno);
	}
	@RequestMapping(value="/adminClassEdit.do", method=RequestMethod.POST)
	public ModelAndView updateClassSubmit(ClassVo c_vo) {
		
		ModelAndView mav = new ModelAndView();
		int re = -1;
		re = dao.classUpdate(c_vo);
		if(re <= 0) {
			mav.setViewName("redirect:/adminClass.do");
		}else {
			mav.setViewName("redirect:/class.do");
		}
		return mav;
	}
	
	
	// delete---------------------------------------
	
	@RequestMapping(value="/adminClassDelete.do")
	public ModelAndView insertClassSubmit(int classno) {
		ModelAndView mav = new ModelAndView("redirect:/class.do");
		dao.classDelete(classno);
		return mav;
	}
	
	
	
	
}
