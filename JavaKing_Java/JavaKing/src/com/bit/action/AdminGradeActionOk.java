package com.bit.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.dao.GradeDao;
import com.bit.vo.GradeVo;

public class AdminGradeActionOk implements BitAction {

	@Override
	public String pro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		GradeVo vo = new GradeVo();
		int grade_no = Integer.parseInt(request.getParameter("grade_no"));
		int grade_regcredit = Integer.parseInt(request.getParameter("grade_regcredit"));
		double grade_getcredit = Double.parseDouble(request.getParameter("grade_getcredit"));
		int grade_score = Integer.parseInt(request.getParameter("grade_score"));
		int grade_semester = Integer.parseInt(request.getParameter("grade_semester"));
		int grade_level = Integer.parseInt(request.getParameter("grade_level"));
		int std_no = Integer.parseInt(request.getParameter("std_no"));
		int class_no = Integer.parseInt(request.getParameter("class_no"));
		
		vo.setGrade_no(grade_no);
		vo.setGrade_regcredit(grade_regcredit);
		vo.setGrade_getcredit(grade_getcredit);
		vo.setGrade_score(grade_score);
		vo.setGrade_semester(grade_semester);
		vo.setGrade_level(grade_level);
		vo.setStd_no(std_no);
		vo.setClass_no(class_no);
		
		GradeDao dao= new GradeDao();
		int re = dao.insertGrade(vo);
		request.setAttribute("re", re);
		return "adminGradeOk.jsp";
	}

}
