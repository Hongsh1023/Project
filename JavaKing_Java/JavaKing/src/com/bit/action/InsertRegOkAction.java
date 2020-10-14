package com.bit.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.dao.RegisterDao;
import com.bit.vo.RegisterVo;




public class InsertRegOkAction implements BitAction {

	@Override
	public String pro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		RegisterVo r = new RegisterVo();
		RegisterDao dao = new RegisterDao();
		
		r.setReg_no(dao.nextNo());
		r.setReg_semester(Integer.parseInt(request.getParameter("reg_semester")));
		r.setReg_level(Integer.parseInt(request.getParameter("reg_level")));
		r.setReg_entfee(Integer.parseInt(request.getParameter("reg_entfee")));
		r.setReg_fee(Integer.parseInt(request.getParameter("reg_fee")));
		r.setReg_regfee(Integer.parseInt(request.getParameter("reg_regfee")));
		r.setStd_no(Integer.parseInt(request.getParameter("std_no")));
		r.setReg_year(Integer.parseInt(request.getParameter("reg_year")));

		
		int re = dao.insertReg(r);
		
		if(re > 0){
			System.out.println("등록금 등록완료!");
		}
		
		return "insertRegister.jsp";
	}

}
