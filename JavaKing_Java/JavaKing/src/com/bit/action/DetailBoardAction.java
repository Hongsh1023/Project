package com.bit.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.dao.BoardDao;
import com.bit.dao.ReplyDao;
import com.bit.vo.BoardVo;

public class DetailBoardAction implements BitAction {
	
	public BoardDao b_dao;
	public ReplyDao r_dao;
	
	@Override
	public String pro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int board_no= Integer.parseInt(request.getParameter("board_no"));
		System.out.println("board_no :::::" + board_no);
		request.setAttribute("board_no", board_no);
		
		b_dao = new BoardDao();
		r_dao = new ReplyDao();
		
		b_dao.increaseHit(board_no);
		BoardVo b_vo = b_dao.getBoard(board_no);
		//-------------------------------------------------------------------------------------------------------------
		System.out.println("detailBoardAction.board_no는"+board_no);
		//댓글 개수를 반환하는 r_count 유지시키기
		
		request.setAttribute("reply_count", r_dao.getTotalReply(board_no));
		request.setAttribute("b_vo", b_vo);
		request.setAttribute("r_list", r_dao.listReply(board_no));
		
		return "detailBoard.jsp";
	}
}
