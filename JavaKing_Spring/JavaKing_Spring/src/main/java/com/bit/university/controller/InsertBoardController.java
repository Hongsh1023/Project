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

import com.bit.action.String;
import com.bit.university.dao.BoardDao;
import com.bit.university.dao.ReplyDao;
import com.bit.university.vo.BoardVo;

@Controller
@RequestMapping("/insertBoard.do")
public class InsertBoardController {

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
		
		int board_boardno = 0;
		String board_category = "공지사항";
		String board_boardname = "알림마당";

		ModelAndView mav = new ModelAndView();
		
		request.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
		
		b_dao = new BoardDao();
		
		if((request.getParameter("board_boardno"))!=null) {
			board_boardno = Integer.parseInt(request.getParameter("board_boardno"));
			System.out.println("board_boardno는 " + board_boardno);
			session.setAttribute("board_boardno", board_boardno);
		}
		
		switch (board_boardno){
		case 100: board_boardname = "알림마당";break;
		case 200: board_boardname = "도움마당";break;
		case 300: board_boardname = "참여마당";break;
		}
		
		mav.addObject("board_boardname", board_boardname);
		mav.addObject("category_list", b_dao.getBoardCategory(board_boardno));
		return mav;
		
		
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView insertBoardPost(HttpServletRequest request, MultipartRequest multi) throws Throwable {
		int board_boardno = 0;
		String board_category = "공지사항";
		
		request.setCharacterEncoding("utf-8");	

		ModelAndView mav = new ModelAndView();
		
		request.setCharacterEncoding("utf-8");
		b_dao = new BoardDao();
		
		HttpSession session = request.getSession();
		
		String path = request.getRealPath("./image");
		System.out.println(path);
		
		multi = new MultipartRequest(request, path, 1024*1024*10, "utf-8", new DefaultFileRenamePolicy());
		
		//다음 글 번호를 반환하는 변수 no
		int no = b_dao.getNextNo();
		
		if(session.getAttribute("board_boardno")!=null) {
			board_boardno =(int) session.getAttribute("board_boardno");
			session.setAttribute("board_boardno", board_boardno);
		}
		
		BoardVo b_vo = new BoardVo();
		String board_category = multi.getParameter("board_category");
		String board_title = multi.getParameter("board_title");
		String board_content = multi.getParameter("board_content");
		String board_pwd = multi.getParameter("board_pwd");
		
		
		String board_fname=null;
		
		File file = multi.getFile("board_fname");
	      if(file != null) {
	         board_fname= file.getName();
	         b_vo.setBoard_fname(board_fname);
	      }
		
		
		int std_no = Integer.parseInt(multi.getParameter("std_no"));
		
		System.out.println("fname은" +board_fname);
		
		b_vo.setBoard_no(no);
		b_vo.setBoard_boardno(board_boardno);
		b_vo.setBoard_category(board_category);
		b_vo.setBoard_title(board_title);
		b_vo.setBoard_content(board_content);
		b_vo.setBoard_pwd(board_pwd);
		b_vo.setStd_no(std_no);
		
		int re =b_dao.insertBoard(b_vo);
		
		if(re<=0) {
			mav.setViewName("insertBoard");
		} else {
			mav.addObject("board_boardno", board_boardno);
			mav.setViewName("listBoard");	
		}
		
		return mav;
		
		
	}

	
}
