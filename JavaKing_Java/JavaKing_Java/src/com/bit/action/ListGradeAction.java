package com.bit.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bit.dao.GradeDao;
import com.bit.vo.GradeVo;

public class ListGradeAction implements BitAction {

	@Override
	public String pro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		GradeDao dao= new GradeDao();
		//---------------------------------------------------------------------------------
		int std_no = (Integer) session.getAttribute("std_no");
		ArrayList<GradeVo> list = dao.listAll(std_no);
		//---------------------------------------------------------------------------------
		//상세성적의 detailGrade로 이동될 경우를 대비해
		//listGrade에서 불러온 list의 세션을 유지
		session.setAttribute("grade_list", list);
		return "listGrade.jsp";
	}

}
