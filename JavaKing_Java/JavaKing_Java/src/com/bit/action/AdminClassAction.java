package com.bit.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.dao.ClassDao;

public class AdminClassAction implements BitAction {

	private ClassDao dao;
	@Override
	public String pro(HttpServletRequest request, HttpServletResponse resonse) throws ServletException, IOException {
		dao = ClassDao.getInstence();
		int class_no=dao.getNextClassNo();
		request.setAttribute("class_no", class_no);
		return "adminClass.jsp";
	}

}
