package com.bit.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bit.dao.BoardDao;
import com.bit.vo.BoardVo;

public class UpdateBoardAction implements BitAction {

	public BoardDao b_dao;
	
	@Override
	public String pro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		b_dao = new BoardDao();
		
		HttpSession session = request.getSession();
		
		//세션에 담긴 글 번호를 가져옴
		int board_no=Integer.parseInt(request.getParameter("board_no"));
		
		//가져온 글 번호로 board vo 생성
		BoardVo b_vo = b_dao.getBoard(board_no);
		
		request.setAttribute("b_vo", b_dao.getBoard(board_no));
		request.setAttribute("category_list", b_dao.getBoardCategory(b_vo.getBoard_boardno()));
		return "updateBoard.jsp";
	}

}
