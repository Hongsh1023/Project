package com.bit.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.dao.StudentDao;
import com.bit.vo.StudentVo;

public class DetailClassAction implements BitAction {

	@Override
	public String pro(HttpServletRequest request, HttpServletResponse resonse) throws ServletException, IOException {
		// ������û �� �л����� ������µ� �ʿ��� ����
		String id = String.valueOf(request.getSession().getAttribute("std_no"));
		int std_no = Integer.parseInt(id);
        StudentDao sdao = new StudentDao();
        StudentVo s = sdao.findByNo(std_no);
        request.getSession().setAttribute("s", s);
		return "detailClass.jsp";
	}

}
