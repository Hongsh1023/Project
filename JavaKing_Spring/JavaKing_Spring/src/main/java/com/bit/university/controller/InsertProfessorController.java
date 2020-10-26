package com.bit.university.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bit.university.dao.ProfessorDao;
import com.bit.university.vo.ProfessorVo;

@Controller
@RequestMapping("/login/insertProfessor.do")
public class InsertProfessorController {

	@Autowired
	private ProfessorDao dao;

	public void setDao(ProfessorDao dao) {
		this.dao = dao;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public void prom() {
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView submit(ProfessorVo p) {
		ModelAndView mav = new ModelAndView();
		int re = dao.ProfessorInsert(p);
		if(re >0) {
			System.out.println("교수 등록에 성공하였습니다.");
		}

		return mav;
		
	}
	
	
}
