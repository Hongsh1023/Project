package com.bit.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.dao.ProfessorDao;
import com.bit.vo.ProfessorVo;

public class InsertProOkAction implements BitAction {

	@Override
	public String pro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		ProfessorVo p = new ProfessorVo();
		
		p.setPro_no(Integer.parseInt(request.getParameter("pro_no")));
		p.setPro_name(request.getParameter("pro_name"));
		p.setPro_email(request.getParameter("pro_email"));
		p.setPro_major(request.getParameter("pro_major"));
		p.setPro_type(request.getParameter("pro_type"));
		
		ProfessorDao dao = new ProfessorDao();
		int re = dao.insertPro(p);
		
		if(re > 0){
			System.out.println("교수 등록완료!");
		}
		
		return "insertProfessor.jsp";
	}

}
