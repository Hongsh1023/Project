package com.bit.university.controller;

import javax.servlet.http.HttpSession;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bit.university.dao.LoginDao;
import com.bit.university.db.StudentManager;

@Controller 
@RequestMapping("/login.do")
public class LoginController {
	
	@Autowired
	public LoginDao dao;
	
	public void setDao(LoginDao dao) {
		this.dao = dao;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView view () {
		return new ModelAndView("/login"); 
	}
	
	@RequestMapping("/login/main")
	public void mainPage(HttpSession session) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = (User) authentication.getPrincipal();
		String std_no = user.getUsername();
		String std_name = StudentManager.getStudent(std_no).getStd_name();
		session.setAttribute("std_no", std_no);
		session.setAttribute("std_name", std_name);
	}
}
