package com.bit.university.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bit.university.dao.BoardDao;
import com.bit.university.dao.ReplyDao;
import com.bit.university.vo.BoardVo;

@Controller
@RequestMapping("/detailBoard.do")
public class DetailBoardController {

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
	public ModelAndView detailBoard(HttpServletRequest request) throws Throwable {
		request.setCharacterEncoding("utf-8");	

		ModelAndView mav = new ModelAndView();
		
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
		
		mav.addObject("reply_count", r_dao.getTotalReply(board_no));
		mav.addObject("b_vo", b_vo);
		mav.addObject("r_list", r_dao.listReply(board_no));
		
		return mav;
		
		
	}

	
}
