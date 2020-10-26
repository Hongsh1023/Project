package com.bit.university.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.bit.university.dao.StudentDao;

@Controller
public class StudentController {

	@Autowired
	private StudentDao dao;

	public void setDao(StudentDao dao) {
		this.dao = dao;
	}
	
	@RequestMapping("/login/studentInfo.do")
	public void getStudentInfo(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		int std_no = Integer.parseInt(session.getAttribute("std_no")+"");
		model.addAttribute("sv", dao.getStudent(std_no));
	}
	
	@RequestMapping("/login/startEndDate.do")
	public void getStartEndDate(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		int std_no = Integer.parseInt(session.getAttribute("std_no")+"");
		model.addAttribute("sv2", dao.getStartEndDate(std_no));
	}
	
}
