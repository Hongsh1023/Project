package com.bit.university.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bit.university.dao.LoginDao;

@Controller 
@RequestMapping("/login.do")
public class LoginController {
	
	@Autowired
	public LoginDao dao;
	
	public void setDao(LoginDao dao) {
		this.dao = dao;
	}

	@RequestMapping(method = RequestMethod.GET)
	public void view () {
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView login(HttpServletRequest request, int id, String pwd) {
		ModelAndView mav = new ModelAndView();
		int re = -1;
		re = dao.loginCheck(id, pwd);
		if(re == 1) {
			mav.addObject("");
		}
		return mav;
	}
}
