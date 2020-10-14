package com.bit.action;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.dao.BitDao;
import com.bit.vo.StudentVo;

public class AdminStudentOkInfoAction implements BitAction {

	@Override
	public String pro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		StudentVo sv3 = new StudentVo();
		sv3.setStd_no(Integer.parseInt(request.getParameter("std_no")));
		sv3.setStd_pwd(request.getParameter("std_pwd"));
		sv3.setStd_email(request.getParameter("std_email"));
		sv3.setStd_name(request.getParameter("std_name"));
		sv3.setStd_gender(request.getParameter("std_gender"));
		sv3.setStd_birthday(Date.valueOf(request.getParameter("std_birthday")));
		sv3.setStd_level(Integer.parseInt(request.getParameter("std_level")));
		sv3.setStd_semester(Integer.parseInt(request.getParameter("std_semester")));
		sv3.setStd_major(request.getParameter("std_major"));
		sv3.setStd_status(request.getParameter("std_status"));
		sv3.setStd_startdate(Date.valueOf(request.getParameter("std_startdate")));
		if (request.getParameter("std_enddate").equals("")) {
			sv3.setStd_enddate(null);
		}else {		
			sv3.setStd_enddate(Date.valueOf(request.getParameter("std_enddate")));
		}
		
		sv3.setStd_etc(request.getParameter("std_etc"));
		sv3.setPro_no(Integer.parseInt(request.getParameter("pro_no")));
		
		BitDao dao = new BitDao();
		int re = dao.insertStudentInfo(sv3);
		request.setAttribute("re", re);		
		return "adminStudentOkInfo.jsp";
	}

}
