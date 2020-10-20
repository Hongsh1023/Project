package com.bit.university.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bit.university.dao.ChangeDao;
import com.bit.university.dao.StudentDao;

@Controller
public class ChangeController {

	@Autowired
	private ChangeDao dao;

	
	
	public void setDao(ChangeDao dao) {
		this.dao = dao;
	}



	@RequestMapping("/change.do")
	public void getStudentInfo(int std_no, Model model) {
		model.addAttribute("cv", dao.getChangeInfo(std_no));
	}
	
}
