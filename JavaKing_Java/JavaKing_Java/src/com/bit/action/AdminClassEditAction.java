package com.bit.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.dao.ClassDao;

public class AdminClassEditAction implements BitAction {

	private ClassDao dao;
	@Override
	public String pro(HttpServletRequest request, HttpServletResponse resonse) throws ServletException, IOException {
		System.out.println("class_no : "+request.getParameter("classno"));
		int class_no = Integer.parseInt(request.getParameter("classno"));
		dao = ClassDao.getInstence();
		request.setAttribute("c", dao.findByNo(class_no));
		
		return "adminClassEdit.jsp";
	}

}
