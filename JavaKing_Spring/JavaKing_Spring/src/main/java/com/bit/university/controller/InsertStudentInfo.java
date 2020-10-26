package com.bit.university.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bit.university.dao.StudentDao;
import com.bit.university.vo.StudentVo;

@Controller
@RequestMapping("/login/adminStudentInfo.do")
public class InsertStudentInfo {

	@Autowired
	private StudentDao dao;

	public void setDao(StudentDao dao) {
		this.dao = dao;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public void form() {	
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView submit(StudentVo sv3, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("redirect:/login/main.do");
		int re = dao.insertStudent(sv3);
		return mav;
	}
}
