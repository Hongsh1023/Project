package com.bit.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bit.dao.ClassRegDao;
import com.bit.vo.ClassregVo;

public class DetailClassOkAction implements BitAction {

	@Override
	public String pro(HttpServletRequest request, HttpServletResponse resonse) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		ClassRegDao dao = ClassRegDao.getInstance();
		HttpSession session = request.getSession();
		String id = String.valueOf(session.getAttribute("std_no"));
		int std_no =Integer.parseInt(id);
		int year =Integer.parseInt(request.getParameter("year"));
		int semester = Integer.parseInt(request.getParameter("semester"));
		ArrayList<ClassregVo> list = dao.getAtStudentInfo(std_no, year, semester);
		/**1006 세션명변경***/
		request.setAttribute("classreg_list", list);
		return "detailClass.jsp";
	}

}
