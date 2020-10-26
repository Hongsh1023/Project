package com.bit.university.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bit.university.dao.ChangeDao;

@Controller
public class ChangeController {

	@Autowired
	private ChangeDao dao;

	public void setDao(ChangeDao dao) {
		this.dao = dao;
	}

	@RequestMapping("/login/change.do")
	public void getStudentInfo(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		int std_no = Integer.parseInt(session.getAttribute("std_no")+"");
		model.addAttribute("cv", dao.getChangeInfo(std_no));
	}

}
