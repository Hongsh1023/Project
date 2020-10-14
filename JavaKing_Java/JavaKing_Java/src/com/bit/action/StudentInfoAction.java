package com.bit.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.dao.BitDao;
import com.bit.vo.StudentVo;

public class StudentInfoAction implements BitAction {

	@Override
	public String pro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int std_no = (Integer) request.getSession().getAttribute("std_no");
		BitDao dao = new BitDao();
		StudentVo sv = dao.getStudentInfo(std_no);
		request.setAttribute("sv", sv);
		return "studentInfo.jsp";
	}

}
