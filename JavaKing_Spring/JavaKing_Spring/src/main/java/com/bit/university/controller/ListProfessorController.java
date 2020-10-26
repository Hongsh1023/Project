package com.bit.university.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bit.university.dao.ProfessorDao;


@Controller
public class ListProfessorController {
	
	@Autowired
	private ProfessorDao dao;

	public void setDao(ProfessorDao dao) {
		this.dao = dao;
	}
	
	@RequestMapping("/login/listPro.do")
	public void professorList(Model model) {
		model.addAttribute("list", dao.professorList());
	}
}
