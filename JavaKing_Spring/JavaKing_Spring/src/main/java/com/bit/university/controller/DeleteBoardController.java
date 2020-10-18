package com.bit.university.controller;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
@RequestMapping("deleteBoard.do")
public class DeleteBoardController {

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
	public ModelAndView deleteBoard(HttpServletRequest request) throws Throwable {
		b_dao = new BoardDao();
		r_dao = new ReplyDao();
		
		ModelAndView mav = new ModelAndView();
		
		int board_no=Integer.parseInt(request.getParameter("board_no"));
		
		BoardVo b_vo=b_dao.getBoard(board_no);
		List<ReplyVo> r_list = r_dao.listReply(board_no);
		 
		for (ReplyVo r : r_list) {
			int reply_no = r.getReply_no();
			r_dao.deleteReply(reply_no);
		}
		
		int re =b_dao.deleteBoard(board_no);
		
		if(re<=0) {
			  mav.addObject("msg", "게시판 삭제에 실패했습니다.");
		} else {
			if(b_vo.getBoard_fname()!=null) {
				String path=request.getRealPath("./image");
				String board_fname = b_vo.getBoard_fname();
				File file = new File(path+"/"+board_fname);
				file.delete();
			}
		}
		return mav;
		
	}
	
}
