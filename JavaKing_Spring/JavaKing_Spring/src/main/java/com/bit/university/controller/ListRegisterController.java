package com.bit.university.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bit.university.dao.RegisterDao;


@Controller
public class ListRegisterController {

	@Autowired
	private RegisterDao dao;

	public void setDao(RegisterDao dao) {
		this.dao = dao;
	}
	
	@RequestMapping("/login/listReg.do")
	public void registerList(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
        int std_no = (Integer) session.getAttribute("std_no");
		model.addAttribute("list", dao.registerList(std_no));
	}
}
