package com.bit.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bit.dao.BoardDao;
import com.bit.dao.ReplyDao;
import com.bit.vo.BoardVo;
import com.bit.vo.ReplyVo;

public class InsertReplyAction implements BitAction {
	
	public BoardDao b_dao;
	public ReplyDao r_dao;
	
	@Override
	public String pro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();

		b_dao = new BoardDao();
		r_dao = new ReplyDao();

		int reply_no = r_dao.getNextReplyNo();
		String reply_content = request.getParameter("reply_content");
		int board_no =Integer.parseInt(request.getParameter("board_no"));
		int std_no=(Integer)session.getAttribute("std_no");
		//----------------------------------------------------------------------------------------------		
		ReplyVo r_vo = new ReplyVo();

		r_vo.setReply_no(reply_no);
		r_vo.setReply_content(reply_content);
		r_vo.setStd_no(std_no);
		r_vo.setBoard_no(board_no);
		//----------------------------------------------------------------------------------------------

		int re = r_dao.insertReply(r_vo);

		b_dao.increaseHit(board_no);
		BoardVo b_vo = b_dao.getBoard(board_no);

		request.setAttribute("reply_count", r_dao.getTotalReply(board_no));
		request.setAttribute("b_vo", b_vo);
		request.setAttribute("r_list", r_dao.listReply(board_no));
		request.setAttribute("board_no", board_no);
		return "detailBoard.jsp";
	}

}
