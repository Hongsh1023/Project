package com.bit.university.controller;
import java.util.List;

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
@RequestMapping("/deleteReply.do")
public class DeleteReplyController {

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
	public ModelAndView deleteReply(HttpServletRequest request) throws Throwable {
		
		ModelAndView mav = new ModelAndView("redirect:/detailBoard.do");
		b_dao = new BoardDao();
		r_dao = new ReplyDao();
		
		int reply_no = Integer.parseInt(request.getParameter("reply_no"));
		int board_no=Integer.parseInt(request.getParameter("board_no"));
		
		r_dao.deleteReply(reply_no);
		
		//댓글 개수를 반환하는 r_count 유지시키기
		mav.addObject("reply_count", r_dao.getTotalReply(board_no));
		mav.addObject("b_vo", b_dao.getBoard(board_no));
		mav.addObject("r_list",  r_dao.listReply(board_no));
		
		
		return mav;
	}
}

