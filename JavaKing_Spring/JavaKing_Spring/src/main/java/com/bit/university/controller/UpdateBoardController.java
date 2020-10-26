package com.bit.university.controller;

import java.io.File;
import java.io.FileOutputStream;

import javax.servlet.http.HttpServletRequest;

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
@RequestMapping("/login/updateBoard.do")
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
		ModelAndView mav = new ModelAndView();
		b_dao = new BoardDao();
		
		int board_no=Integer.parseInt(request.getParameter("board_no"));
		
		//가져온 글 번호로 board vo 생성
		BoardVo b_vo = b_dao.getBoard(board_no);
		
		mav.addObject("b_vo", b_dao.getBoard(board_no));
		mav.addObject("category_list", b_dao.getBoardCategory(b_vo.getBoard_boardno()));
		
		return mav;
		
		
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView insertBoardPost(BoardVo b_vo, HttpServletRequest request, MultipartFile upload_file) throws Throwable {
		ModelAndView mav = new ModelAndView();
		b_dao = new BoardDao();
		r_dao = new ReplyDao();
		
		//-----------------------------------------------------------------------
		
		System.out.println("b_vo.boardcategory::::::::" +b_vo.getBoard_category());

		String path = request.getRealPath("image");
		System.out.println(path);
		
		String old_fname = b_vo.getBoard_fname();
		
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
	      } else{
	    	  b_vo.setBoard_fname(old_fname);
	      }
		 
		 
		int board_boardno = Integer.parseInt(request.getParameter("board_boardno"));
		int re =b_dao.updateBoard(b_vo);

		if(re<=0) {
			mav.setViewName("updateBoard");
		} else {
			if( old_fname != null && !old_fname.equals("") && !board_fname.equals("")) {
				File file = new File(path + "/" +board_fname);
				file.delete();
			}
			mav.addObject("board_boardno", board_boardno);
			mav.setViewName("redirect:/login/listBoard.do");	
		}

		return mav;
		
		
	}

	
	
	
}
