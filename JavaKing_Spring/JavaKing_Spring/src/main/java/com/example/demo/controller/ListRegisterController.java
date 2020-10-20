package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dao.RegisterDao;

@Controller
public class ListRegisterController {

	@Autowired
	private RegisterDao dao;

	public void setDao(RegisterDao dao) {
		this.dao = dao;
	}
	
	@RequestMapping("/listReg.do")
	public void registerList(Model model) {
		//HttpSession session = request.getSession();
        //int std_no = (Integer) session.getAttribute("std_no")
		int std_no = 2014104196;
		model.addAttribute("list", dao.registerList(std_no));
	}
}
