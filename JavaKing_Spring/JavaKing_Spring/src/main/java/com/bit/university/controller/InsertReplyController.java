package com.bit.university.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bit.university.dao.BoardDao;
import com.bit.university.dao.ReplyDao;
import com.bit.university.vo.BoardVo;
import com.bit.university.vo.ReplyVo;

@Controller
@RequestMapping("/insertReply.do")
public class InsertReplyController {
	
	@Autowired
	private BoardDao b_dao;
	private ReplyDao r_dao;
	
	public void setBoardDao(BoardDao b_dao) {
		this.b_dao = b_dao;
	}
	
	public void setReplyDao(ReplyDao r_dao) {
		this.r_dao = r_dao;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView insertReply(HttpServletRequest request) throws Throwable {
		request.setCharacterEncoding("utf-8");	
		ModelAndView mav = new ModelAndView("redirect:/detailBoard.do");
		
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

		mav.addObject("reply_count", r_dao.getTotalReply(board_no));
		mav.addObject("b_vo", b_vo);
		mav.addObject("r_list", r_dao.listReply(board_no));
		mav.addObject("board_no", board_no);
		
		return mav;
	}
}
