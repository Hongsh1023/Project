package com.bit.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.bit.dao.ProfessorDao;

public class ListProAction implements BitAction {

	@Override
	public String pro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ProfessorDao dao = new ProfessorDao();
		request.setAttribute("list", dao.listPro());
		return "listProfessor.jsp";
		
	}

}