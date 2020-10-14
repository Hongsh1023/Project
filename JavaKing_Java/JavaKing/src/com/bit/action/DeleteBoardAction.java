package com.bit.action;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.dao.BoardDao;
import com.bit.dao.ReplyDao;
import com.bit.vo.BoardVo;
import com.bit.vo.ReplyVo;

public class DeleteBoardAction implements BitAction {

	@Override
	public String pro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardDao b_dao = new BoardDao();
		ReplyDao r_dao = new ReplyDao();
		
		int board_no=Integer.parseInt(request.getParameter("board_no"));
		
		BoardVo b_vo=b_dao.getBoard(board_no);
		ArrayList<ReplyVo> r_list = r_dao.listReply(board_no);
		
		for (ReplyVo r : r_list) {
			int reply_no = r.getReply_no();
			r_dao.deleteReply(reply_no);
		}
		
		
		int re =b_dao.deleteBoard(board_no);
		
		if(re<=0) {
			request.setAttribute("msg", "게시판 삭제에 실패했습니다.");
			response.sendRedirect("error.jsp");
		} else {
			if(b_vo.getBoard_fname()!=null) {
				String path=request.getRealPath("./image");
				String board_fname = b_vo.getBoard_fname();
				File file = new File(path+"/"+board_fname);
				file.delete();
				
			}
		}
		
		return "listBoard.do";
	}

}
