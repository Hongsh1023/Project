package com.bit.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bit.dao.BoardDao;
import com.bit.vo.BoardVo;

public class MainAction implements BitAction {

	@Override
	public String pro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardDao b_dao = new BoardDao();
		
		HttpSession session = request.getSession();
		
		ArrayList<BoardVo> notice = b_dao.listAll(100,"공지사항",1,"","");
		ArrayList<BoardVo> freeboard = b_dao.listAll(300,"자유게시판",1,"","");
		ArrayList<BoardVo> flee_buy = b_dao.listAll(300,"삽니다",1,"","");
		ArrayList<BoardVo> flee_sell = b_dao.listAll(300,"팝니다",1,"","");
		ArrayList<BoardVo> anonymous = b_dao.listAll(300,"익명게시판",1,"","");
		
		session.setAttribute("main_notice", notice);
		session.setAttribute("main_freeboard", freeboard);
		session.setAttribute("main_flee_buy", flee_buy);
		session.setAttribute("main_flee_sell", flee_sell);
		session.setAttribute("main_anonymous", anonymous);
		
		return "main.jsp";
	}

}
