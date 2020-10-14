package com.bit.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bit.dao.ClassDao;

public class ClassAction implements BitAction {

	private int pageSize = 6;
	private int totalCount;
	private int totalPage;
	private ClassDao dao;
	
	@Override
	public String pro(HttpServletRequest request, HttpServletResponse resonse) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		dao = ClassDao.getInstence();
		totalCount = dao.getTotalCount(null);
		totalPage = (int) Math.ceil((double) totalCount/pageSize);
		session.setAttribute("totalPage", totalPage);
		int pageNum =1;
		if(request.getParameter("pageNum") !=null) {
			pageNum=Integer.parseInt(request.getParameter("pageNum"));
		}
		int start = (pageNum-1)*pageSize+1;
		int end = (start+pageSize)-1;
		if(end > totalCount) {
			end=totalCount;
		}
		System.out.println("pageNum: "+pageNum);
		System.out.println("start: "+start);
		System.out.println("end: "+end);
		
		request.setAttribute("list", dao.listClass(start, end, null));
		return "class.jsp";
	}

}
