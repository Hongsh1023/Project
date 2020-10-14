package com.bit.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bit.dao.BoardDao;

public class InsertBoardAction implements BitAction {
	
	public BoardDao dao;
	public int board_boardno = 0;
	public String board_category = "공지사항";
	public String board_boardname = "알림마당";
	
	@Override
	public String pro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
		
		dao = new BoardDao();
		
		if((request.getParameter("board_boardno"))!=null) {
			board_boardno = Integer.parseInt(request.getParameter("board_boardno"));
			System.out.println("board_boardno는 " + board_boardno);
			session.setAttribute("board_boardno", board_boardno);
		}
		
		switch (board_boardno){
		case 100: board_boardname = "알림마당";break;
		case 200: board_boardname = "도움마당";break;
		case 300: board_boardname = "참여마당";break;
		}
		
		request.setAttribute("board_boardname", board_boardname);
		request.setAttribute("category_list", dao.getBoardCategory(board_boardno));
		
		return "insertBoard.jsp";
	}

}
