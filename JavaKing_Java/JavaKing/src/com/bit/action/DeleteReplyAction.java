package com.bit.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.dao.BoardDao;
import com.bit.dao.ReplyDao;

public class DeleteReplyAction implements BitAction {
	public BoardDao b_dao;
	public ReplyDao r_dao;
	
	
	@Override
	public String pro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		b_dao = new BoardDao();
		r_dao = new ReplyDao();
		
		int reply_no = Integer.parseInt(request.getParameter("reply_no"));
		int board_no=Integer.parseInt(request.getParameter("board_no"));
		
		r_dao.deleteReply(reply_no);
		
		//댓글 개수를 반환하는 r_count 유지시키기
		request.setAttribute("reply_count", r_dao.getTotalReply(board_no));
		request.setAttribute("b_vo", b_dao.getBoard(board_no));
		request.setAttribute("r_list",  r_dao.listReply(board_no));
		
		return "detailBoard.jsp";
	}

}
