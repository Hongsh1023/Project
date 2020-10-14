package com.bit.action;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bit.dao.BoardDao;
import com.bit.dao.ReplyDao;
import com.bit.vo.BoardVo;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class UpdateBoardOkAction implements BitAction {

	public BoardDao b_dao;
	public ReplyDao r_dao;

	@Override
	public String pro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
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
			request.setAttribute("board_no", board_no);
			return "detailBoard.jsp";	
		} else {
			File file = new File(path+"/"+oldFname);
			file.delete();
			b_vo = b_dao.getBoard(board_no);
			request.setAttribute("reply_count", r_dao.getTotalReply(board_no));
			request.setAttribute("b_vo", b_vo);
			request.setAttribute("r_list", r_dao.listReply(board_no));
			return "detailBoard.jsp";	

		}

	}
}

