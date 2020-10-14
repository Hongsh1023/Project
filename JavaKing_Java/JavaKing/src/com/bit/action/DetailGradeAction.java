package com.bit.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bit.dao.GradeDao;

public class DetailGradeAction implements BitAction {

	@Override
	public String pro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String year = request.getParameter("year");
		int semester = Integer.parseInt(request.getParameter("semester"));
		GradeDao dao= new GradeDao();
		
		//---------------------------------------------------------------------------------
		int std_no = (Integer) session.getAttribute("std_no");
		//---------------------------------------------------------------------------------
		
		request.setAttribute("dlist", dao.detailAll(year,semester,std_no));
		return "detailGrade.jsp";
	}

}
