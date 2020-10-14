package com.bit.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bit.dao.RegisterDao;

public class ListRegAction implements BitAction {

	@Override
	public String pro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RegisterDao dao = new RegisterDao();
		HttpSession session = request.getSession();
        int std_no = (Integer) session.getAttribute("std_no");
		request.setAttribute("reg_list", dao.listReg(std_no));
		return "listRegister.jsp";
		
	}

}
