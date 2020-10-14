package com.bit.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bit.dao.ClassDao;

public class AdminClassDeleteAction implements BitAction {
	private int pageSize = 6;
	private int totalCount;
	private int totalPage;
	private ClassDao dao;
	@Override
	public String pro(HttpServletRequest request, HttpServletResponse resonse) throws ServletException, IOException {
		System.out.println("class_no : "+request.getParameter("classno"));
		int class_no = Integer.parseInt(request.getParameter("classno"));
		dao = ClassDao.getInstence();
		HttpSession session = request.getSession();
		int re = dao.deleteClass(class_no);
		if(re > 0) {
			totalCount = dao.getTotalCount(null);
			totalPage = (int) Math.ceil((double) totalCount/pageSize);
			session.setAttribute("totalPage", totalPage);
			int pageNum=1;
			if(request.getParameter("pageNum") !=null) {
				pageNum=Integer.parseInt(request.getParameter("pageNum"));
			}
			int start = (pageNum-1)*pageSize+1;
			int end = (start+pageSize)-1;
			if(end > totalCount) {
				end=totalCount;
			}
			session.setAttribute("list", dao.listClass(start,end,null));
		}
	
		return "class.jsp";
	}

}
