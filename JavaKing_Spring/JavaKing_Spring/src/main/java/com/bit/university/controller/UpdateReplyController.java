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
@RequestMapping("/login/updateReply.do")
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
	public ModelAndView udpateReply(HttpServletRequest request, ReplyVo r_vo) throws Throwable {
		ModelAndView mav = new ModelAndView("redirect:/login/detailBoard.do");
		System.out.println(r_vo.getBoard_no()+"/"+r_vo.getReply_content()+"/"+r_vo.getReply_no()+"/"+r_vo.getStd_no()+"/"+r_vo.getReply_regdate());
		
		r_dao = new ReplyDao();
		
		HttpSession session = request.getSession();
		
		int std_no= (int)session.getAttribute("std_no");
		r_vo.setStd_no(std_no);
		
		r_dao.updateReply(r_vo.getReply_content(),r_vo.getReply_no());

		BoardVo b_vo = b_dao.getBoard(r_vo.getBoard_no());
		
		mav.addObject("board_no", r_vo.getBoard_no());
		mav.addObject("reply_count", r_dao.getTotalReply(r_vo.getBoard_no()));
		mav.addObject("b_vo", b_vo);
		mav.addObject("r_list", r_dao.listReply(r_vo.getBoard_no()));
		
		return mav;
	}
}
