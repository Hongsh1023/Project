package com.bit.university.controller;

import java.io.FileOutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.bit.university.dao.BoardDao;
import com.bit.university.dao.ReplyDao;
import com.bit.university.vo.BoardVo;

@Controller
@RequestMapping("/login/insertBoard.do")
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
		int board_boardno =0;
		String board_category = "공지사항";
		String board_boardname = "알림마당";

		ModelAndView mav = new ModelAndView();

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
	public ModelAndView insertBoardPost(BoardVo b_vo, HttpServletRequest request, MultipartFile upload_file) throws Throwable {
		
		b_dao = new BoardDao();
		
		System.out.println("b_vo.boardcategory::::::::" +b_vo.getBoard_category());
		ModelAndView mav = new ModelAndView();

		HttpSession session = request.getSession();
		
		//다음 글 번호를 반환하는 변수 no
		int no = (int)(b_dao.getNextNo());
		b_vo.setBoard_no(no);
		String path = request.getRealPath("image");
		
		System.out.println(path);
		
		String fname = upload_file.getOriginalFilename();
		String board_fname = fname.substring(fname.lastIndexOf("\\")+1);
		
		 if(board_fname != null && !board_fname.equals("")) {
	         try {
	            byte[] data = upload_file.getBytes();
	            FileOutputStream fos = new FileOutputStream(path+"/"+board_fname);
	            fos.write(data);
	            fos.close();
	         }catch (Exception e) {
	            System.out.println("예외발생s : " + e.getMessage());
	         }
	         b_vo.setBoard_fname(board_fname);
	      }

		int board_boardno = (int) session.getAttribute("board_boardno");
		int re =b_dao.insertBoard(b_vo);

		if(re<=0) {
			mav.setViewName("insertBoard");
		} else {
			mav.addObject("board_boardno", board_boardno);
			mav.setViewName("redirect:/login/listBoard.do");	
		}

		return mav;


	}


}
