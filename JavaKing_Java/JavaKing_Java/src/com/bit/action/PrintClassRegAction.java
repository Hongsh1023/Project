package com.bit.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bit.dao.ClassRegDao;
import com.bit.vo.ClassregVo;

public class PrintClassRegAction implements BitAction {

	@Override
	public String pro(HttpServletRequest request, HttpServletResponse resonse) throws ServletException, IOException {
		HttpSession session = request.getSession();
		ClassRegDao crdao = ClassRegDao.getInstance();
		request.setCharacterEncoding("utf-8");
		
		//수강신청 하단의 신청내역
		int std_no = Integer.parseInt(request.getParameter("stdno"));
		ArrayList<ClassregVo> list2 = new ArrayList<ClassregVo>();
		list2 = crdao.listAll(std_no);
		session.setAttribute("crList", list2);
		
		//신청 점수, 갯수
		int countCredit =0;
		int countSubject =0;
		countCredit = crdao.countCredit(std_no);
		countSubject = crdao.countSubject(std_no);
		session.setAttribute("cCredit", countCredit);
		session.setAttribute("cSubject", countSubject);

		return "printClassreg.jsp";
	}

}
