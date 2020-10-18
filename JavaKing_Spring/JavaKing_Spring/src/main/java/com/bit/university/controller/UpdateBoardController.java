package com.bit.university.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartRequest;
import org.springframework.web.servlet.ModelAndView;

import com.bit.action.DefaultFileRenamePolicy;
import com.bit.action.String;
import com.bit.university.dao.BoardDao;
import com.bit.university.dao.ReplyDao;
import com.bit.university.vo.BoardVo;

@Controller
@RequestMapping("updateBoard.do")
public class UpdateBoardController {
	
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
	public ModelAndView insertBoardGet(HttpServletRequest request) throws Throwable {
		request.setCharacterEncoding("utf-8");
		ModelAndView mav = new ModelAndView();
		b_dao = new BoardDao();
		
		HttpSession session = request.getSession();
		
		//세션에 담긴 글 번호를 가져옴
		int board_no=Integer.parseInt(request.getParameter("board_no"));
		
		//가져온 글 번호로 board vo 생성
		BoardVo b_vo = b_dao.getBoard(board_no);
		
		mav.addObject("b_vo", b_dao.getBoard(board_no));
		mav.addObject("category_list", b_dao.getBoardCategory(b_vo.getBoard_boardno()));
		return mav;
		
		
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView insertBoardPost(HttpServletRequest request, MultipartRequest multi) throws Throwable {
		request.setCharacterEncoding("utf-8");
		ModelAndView mav = new ModelAndView();
		b_dao = new BoardDao();
		r_dao = new ReplyDao();
		
		HttpSession session = request.getSession();

		String path = request.getRealPath("./image");
		System.out.println(path);
		MultipartRequest multi = new MultipartRequest(request, path, 1024*1024*10, "utf-8", new DefaultFileRenamePolicy());

		int board_no= Integer.parseInt(multi.getParameter("board_no"));
		System.out.println("updateOK.board_no"+board_no);
		BoardVo b_vo = new BoardVo();

		String board_category = multi.getParameter("board_category");
		String board_title = multi.getParameter("board_title");
		String board_content = multi.getParameter("board_content");
		String board_pwd = multi.getParameter("board_pwd");
		String oldFname= multi.getParameter("oldFname");
		String board_fname =null;
		if(multi.getFile("board_fname")!=null) {
			board_fname =multi.getFile("board_fname").getName();
			b_vo.setBoard_fname(board_fname);
		}

		int std_no = Integer.parseInt(multi.getParameter("std_no"));

		b_vo.setBoard_fname(board_fname);
		b_vo.setBoard_category(board_category);
		b_vo.setBoard_title(board_title);
		b_vo.setBoard_content(board_content);
		b_vo.setStd_no(std_no);
		b_vo.setBoard_no(board_no);

		int re =b_dao.updateBoard(b_vo);

		if(re<=0) {
			mav.addObject("board_no", board_no);
		} else {
			File file = new File(path+"/"+oldFname);
			file.delete();
			b_vo = b_dao.getBoard(board_no);
			mav.addObject("reply_count", r_dao.getTotalReply(board_no));
			mav.addObject("b_vo", b_vo);
			mav.addObject("r_list", r_dao.listReply(board_no));

		}
		return mav;
		
		
	}

	
	
	
}
