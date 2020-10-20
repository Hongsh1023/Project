package com.bit.university.controller;

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
	
	@RequestMapping("/studentInfo.do")
	public void getStudentInfo(int std_no, Model model) {
		model.addAttribute("sv", dao.getStudentInfo(std_no));
	}
	
	@RequestMapping("/startEndDate.do")
	public void getStartEndDate(int std_no, Model model) {
		model.addAttribute("sv2", dao.getStartEndDate(std_no));
	}
	
}
