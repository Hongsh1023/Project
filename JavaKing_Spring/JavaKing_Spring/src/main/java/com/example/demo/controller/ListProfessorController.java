package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dao.ProfessorDao;

@Controller
public class ListProfessorController {
	
	@Autowired
	private ProfessorDao dao;

	public void setDao(ProfessorDao dao) {
		this.dao = dao;
	}
	
	@RequestMapping("/listPro.do")
	public void professorList(Model model) {
		model.addAttribute("list", dao.professorList());
	}
}
