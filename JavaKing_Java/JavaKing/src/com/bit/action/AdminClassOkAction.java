package com.bit.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bit.dao.ClassDao;
import com.bit.vo.ClassVo;


public class AdminClassOkAction implements BitAction {
	private int pageSize = 6;
	private int totalCount;
	private int totalPage;
	private ClassDao dao;

	@Override
	public String pro(HttpServletRequest request, HttpServletResponse resonse) throws ServletException, IOException {
		dao = ClassDao.getInstence();
		request.setCharacterEncoding("UTF-8");
		int class_no = Integer.parseInt(request.getParameter("class_no"));
		String class_name = request.getParameter("class_name");
		String class_startdate = request.getParameter("class_startdate");
		String class_enddate = request.getParameter("class_enddate");
		String class_dayofweek = request.getParameter("class_dayofweek");
		String class_time = request.getParameter("class_time");
		String class_room = request.getParameter("class_room");
		int class_credit = Integer.parseInt(request.getParameter("class_credit"));
		String class_type = request.getParameter("class_type");
		int pro_no = Integer.parseInt(request.getParameter("pro_no"));
		
		ClassVo c = new ClassVo();
		c.setClass_no(class_no);
		c.setClass_name(class_name);
		c.setClass_startdate(class_startdate);
		c.setClass_enddate(class_enddate);
		c.setClass_dayofweek(class_dayofweek);
		c.setClass_time(class_time);
		c.setClass_room(class_room);
		c.setClass_credit(class_credit);
		c.setClass_type(class_type);
		c.setPro_no(pro_no);
		
		int re = dao.insertClass(c);
		if(re > 0) {
			HttpSession session = request.getSession();
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
			return "class.jsp";
		}else {
			return "adminClass.jsp";
		}
	}

}
