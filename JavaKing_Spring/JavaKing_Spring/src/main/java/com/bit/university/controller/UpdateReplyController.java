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
@RequestMapping("/updateReply.do")
public class UpdateReplyController {

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
	public ModelAndView udpateReply(HttpServletRequest request) throws Throwable {
		request.setCharacterEncoding("utf-8");	
		ModelAndView mav = new ModelAndView("redirect:/detailBoard.do");
		
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
		List<ReplyVo> r_list = r_dao.listReply(board_no);
		
		
		System.out.println("updateReply 도착5");
		//댓글 개수를 반환하는 r_count 유지시키기
		mav.addObject("reply_count", r_dao.getTotalReply(board_no));
		mav.addObject("b_vo", b_vo);
		mav.addObject("r_list", r_list);
		
		return mav;
	}
}
