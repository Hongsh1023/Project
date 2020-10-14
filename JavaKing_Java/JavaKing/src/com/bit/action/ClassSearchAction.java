package com.bit.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bit.dao.ClassDao;
import com.bit.dao.ClassRegDao;
import com.bit.vo.ClassVo;
import com.bit.vo.ClassregVo;

public class ClassSearchAction implements BitAction {

	private int pageSize = 6;
	private int totalCount;
	private int totalPage;
	
	@Override
	public String pro(HttpServletRequest request, HttpServletResponse resonse) throws ServletException, IOException {
		HttpSession session = request.getSession();
		ClassDao cdao = ClassDao.getInstence();
		ClassRegDao crdao = ClassRegDao.getInstance();
		request.setCharacterEncoding("utf-8");
		String search =null;
		if(session.getAttribute("search") != null) {
			search = (String) session.getAttribute("search");
		}
		
		if(request.getParameter("search") !=null) {
			search = request.getParameter("search").trim();
		}
		session.setAttribute("search", search);
		totalCount = cdao.getTotalCount(search);
		totalPage = (int) Math.ceil((double) totalCount/pageSize);
		session.setAttribute("totalPage", totalPage);
		int pageNum=1;
		if(request.getParameter("pageNum") !=null) {
			pageNum=Integer.parseInt(request.getParameter("pageNum"));
		}
		System.out.println("pageNum: "+pageNum);
		
		int start = (pageNum-1)*pageSize+1;
		int end = (start+pageSize)-1;
		if(end > totalCount) {
			end=totalCount;
		}
		
		ArrayList<ClassVo> list = cdao.listClass(start, end, search);
		session.setAttribute("searchList", list);
		
		//수강신청 하단의 신청내역
		int std_no = (int)session.getAttribute("std_no");
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

		return "classreg.jsp";
	}

}
