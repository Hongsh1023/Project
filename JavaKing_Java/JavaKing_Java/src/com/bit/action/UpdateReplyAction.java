package com.bit.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bit.dao.BoardDao;
import com.bit.dao.ReplyDao;
import com.bit.vo.BoardVo;
import com.bit.vo.ReplyVo;

public class UpdateReplyAction implements BitAction {
	public BoardDao b_dao;
	public ReplyDao r_dao;
	@Override
	public String pro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("updateReply 도착");
		b_dao = new BoardDao();
		r_dao = new ReplyDao();
		
		String reply_content = request.getParameter("reply_content");
		int reply_no = Integer.parseInt(request.getParameter("reply_no"));
		System.out.println("updateReply 도착2");
		r_dao.updateReply(reply_content, reply_no);
		
		
		HttpSession session = request.getSession();
		session.setAttribute("std_no", "2014104199"); //학번 세션 유지하려고 로그인시 유지하게끔 수정해야함
		System.out.println("updateReply 도착3");
		int board_no=Integer.parseInt(request.getParameter("board_no"));
		BoardVo b_vo = b_dao.getBoard(board_no);
		System.out.println("updateReply 도착4");
		ArrayList<ReplyVo> r_list = r_dao.listReply(board_no);
		
		
		System.out.println("updateReply 도착5");
		//댓글 개수를 반환하는 r_count 유지시키기
		request.setAttribute("reply_count", r_dao.getTotalReply(board_no));
		request.setAttribute("b_vo", b_vo);
		request.setAttribute("r_list", r_list);
		
		return "detailBoard.jsp";
	}

}
