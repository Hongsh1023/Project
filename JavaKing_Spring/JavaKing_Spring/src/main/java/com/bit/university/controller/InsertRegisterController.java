package com.bit.university.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bit.university.dao.RegisterDao;
import com.bit.university.vo.RegisterVo;


@Controller
@RequestMapping("/login/insertRegister.do")
public class InsertRegisterController {

	@Autowired
	private RegisterDao dao;

	public void setDao(RegisterDao dao) {
		this.dao = dao;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public void prom() {
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView submit(RegisterVo r) {
		ModelAndView mav = new ModelAndView();
		int no = dao.registerNextNo();
		r.setReg_no(no);
		int re = dao.registerInsert(r);
		if(re >0) {
			System.out.println("등록금 등록에 성공하였습니다.");
		}
		
		return mav;
	}
}
