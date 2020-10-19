package com.bit.university.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bit.university.dao.BoardDao;
import com.bit.university.dao.ReplyDao;
import com.bit.university.vo.BoardVo;


@Controller
@RequestMapping("listBoard.do")
public class ListBoardController {

	public static int board_boardno=100;
	public String board_category = "공지사항";
	public String board_boardname ="알림마당";
	public static int board_count = 0;
	public static int page_size = 5;	
	public static int total_page = 1;
	public static int page_max = 5;

	@Autowired
	private BoardDao b_dao;
	private ReplyDao r_dao;
	
	public void setBoardDao(BoardDao b_dao) {
		this.b_dao = b_dao;
	}
	
	public void setReplyDao(ReplyDao r_dao) {
		this.r_dao = r_dao;
	}

	@RequestMapping("/listBoard.do")
	public ModelAndView listBoard(HttpServletRequest request, HttpSession session) throws Throwable {

		request.setCharacterEncoding("utf-8");

		ModelAndView mav = new ModelAndView();

		session = request.getSession();

		int page_num = 1;
		if(session.getAttribute("page_size")!=null) {
			page_size= (int) session.getAttribute("page_size");
		}

		if(request.getParameter("page_size")!=null) {
			page_size = Integer.parseInt(request.getParameter("page_size"));
			session.setAttribute("page_size", page_size);
		}

		if(request.getParameter("page_num")!= null) {
			page_num = Integer.parseInt(request.getParameter("page_num"));
			session.setAttribute("page_num", page_num);
		}

		System.out.println("page_num는"+page_num);
		//-----------------------------------------------------------------------------------------------------------------------------
		//검색을 위한 search와 keyword변수
		String search=null;
		String keyword=null;
		b_dao = new BoardDao();

		if((request.getParameter("board_boardno"))!=null) {

			search="";
			keyword="";
			board_boardno = Integer.parseInt(request.getParameter("board_boardno"));
			System.out.println("board_boardno는 " + board_boardno);
			switch (board_boardno) {
			case 100: board_boardname = "알림마당"; board_category = "공지사항"; break;
			case 200: board_boardname = "도움마당";  board_category = "시설QNA"; break;
			case 300: board_boardname = "참여마당"; board_category = "삽니다"; break;
			}
			session.setAttribute("board_boardno", board_boardno);

		}
		if(session.getAttribute("board_boardno")!=null) {
			session.getAttribute("board_boardno");
		}

		//-------------------------------------------------------------------------------------------

		//카테고리 값을 요청받았을 경우, 변수에 지정
		if (board_category == null && session.getAttribute("board_category") != null
				&& request.getParameter("board_boardno") == null) {
			board_category = URLDecoder.decode(request.getParameter("board_category"), "UTF-8");
		}
		if (request.getParameter("board_category") != null) {
			board_category = URLDecoder.decode(request.getParameter("board_category"), "UTF-8");
			session.setAttribute("board_category", board_category);
		}

		//--------------------------------------------------------------------------------------

		if(session.getAttribute("search")!=null) {
			search = (String)session.getAttribute("search");
			keyword = (String)session.getAttribute("keyword"); 
		}

		if(request.getParameter("search")!=null) {
			search = request.getParameter("search");
			keyword = request.getParameter("keyword");
			session.setAttribute("search", search);
			session.setAttribute(keyword, "keyword");
		}

		System.out.println("board_category는 "+ board_category);

		//board_count변수에 해당 게시판의 모든 게시물 수를 반환한 값을 저장
		board_count=b_dao.getBoardCount(board_boardno, board_category, search, keyword);
		System.out.println("여기까지 옴-------------------------------1");
		//------------------------------------------------------------------------------------
		total_page = (int)Math.ceil((double)board_count/page_size);
		if(total_page==0) {
			total_page=1;
		}
		int start_page = (page_num-1)/page_max*page_max+1;
		int end_page = start_page+page_max-1;
		if(end_page > total_page) {
			end_page = total_page;
		}		
		System.out.println("여기까지 옴-------------------------------2");

		//--------------------------------------------------------------------------------------
		String page_str = "";
		if(start_page > 1) {
			page_str += "<a href='listBoard.do?page_num="+(start_page-1)+"'>[이전]</a>  ";
		}

		for(int i=start_page;i<=end_page;i++) {
			page_str += "<a href='listBoard.do?page_num="+i+"'>"+ i + "</a> ";
		}

		if(total_page > end_page) {
			page_str += "  <a href='listBoard.do?page_num="+(end_page+1)+"'>[다음]</a>";
		}

		System.out.println(page_size+""+board_count+""+total_page+""+page_max);

		mav.addObject("board_boardno", board_boardno);
		mav.addObject("page_str", page_str);
		mav.addObject("board_boardname", board_boardname);
		mav.addObject("category_list", b_dao.getBoardCategory(board_boardno));
		mav.addObject("list", b_dao.listAll(board_boardno, board_category, page_num, search, keyword));

		return mav;

	}

}






