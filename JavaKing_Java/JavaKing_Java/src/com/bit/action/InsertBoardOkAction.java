package com.bit.action;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bit.dao.BoardDao;
import com.bit.vo.BoardVo;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class InsertBoardOkAction implements BitAction {
	
	public BoardDao dao;
	public int board_boardno = 0;
	public String board_category = "공지사항";
			
	@Override
	public String pro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		dao = new BoardDao();
		
		HttpSession session = request.getSession();
		
		String path = request.getRealPath("./image");
		System.out.println(path);
		
		MultipartRequest multi = new MultipartRequest(request, path, 1024*1024*10, "utf-8", new DefaultFileRenamePolicy());
		
		//다음 글 번호를 반환하는 변수 no
		int no = dao.getNextNo();
		
		if(session.getAttribute("board_boardno")!=null) {
			board_boardno=(int) session.getAttribute("board_boardno");
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
		
		int re =dao.insertBoard(b_vo);
		
		if(re<=0) {
			return "insertBoard.do";
		} else {
			request.setAttribute("board_boardno", board_boardno);
			return "listBoard.do";		
		}
		
		
	}
	
}
