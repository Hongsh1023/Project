package com.bit.university.controller;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bit.university.dao.StudentDao;
import com.bit.university.vo.StudentVo;

@Controller
@RequestMapping("adminStudentInfo.do")
public class InsertStudentInfo {

	@Autowired
	private StudentDao dao;

	public void setDao(StudentDao dao) {
		this.dao = dao;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public void form() {	
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView submit(StudentVo sv3, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("redirect:/main.do");
		if (request.getParameter("std_enddate").equals("")) {
            sv3.setStd_enddate(Date.valueOf(""));
        }else {
            sv3.setStd_enddate(Date.valueOf(request.getParameter("std_enddate")));
        }
		
		int re = dao.insert(sv3);
		return mav;
	}
}
