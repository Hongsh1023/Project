package com.bit.university.controller;

import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bit.university.dao.BoardDao;
import com.bit.university.dao.ReplyDao;

@Controller
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
	
	
	@RequestMapping(value = "/login/listBoard.do")
	public void listBoard(HttpServletRequest request, HttpSession session, Model model) throws Throwable {
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

		//-------------------------------------------------------------------------------------------

		//카테고리 값을 요청받았을 경우, 변수에 지정
		if (board_category == null && session.getAttribute("board_category") != null &&
				request.getParameter("board_category") != null) {
			board_category = request.getParameter("board_category");
		}
		if (request.getParameter("board_category") != null) {
			board_category = request.getParameter("board_category");
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
		
		int start = (page_num-1)*page_size+1;
	    int end = start+page_size-1;
	    if(end > board_count) {
	       end = board_count;
	    }   

		System.out.println("여기까지 옴-------------------------------1");
		//------------------------------------------------------------------------------------
		total_page = (int)Math.ceil((double)board_count/page_size);
		String page_str = "";
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
		
		if(start_page > 1) {
			page_str += "<a href=listBoard.do?page_num="+(start_page-1)+">[이전]</a>  ";
		}

		for(int i=start_page;i<=end_page;i++) {
			page_str += "<a href=listBoard.do?page_num="+i+">"+ i + "</a> ";
		}

		if(total_page > end_page) {
			page_str += "<a href=listBoard.do?page_num="+(end_page+1)+">[다음]</a>";
		}
		System.out.println("여기까지 옴-------------------------------3");
		System.out.println(board_boardno+"/"+board_category+"/"+page_num+"/"+search+"/"+keyword+"//////////"+page_size+"/"+board_count+"/"+total_page+"/"+page_max);

		model.addAttribute("board_boardno", board_boardno);
		model.addAttribute("page_str", page_str);
		model.addAttribute("board_boardname", board_boardname);
		model.addAttribute("category_list", b_dao.getBoardCategory(board_boardno));
		
		HashMap map = new HashMap();
		
		map.put("board_boardno", board_boardno);
		map.put("board_category", board_category);
		map.put("page_num", page_num);
		map.put("search", search);
		map.put("keyword", keyword);
		map.put("start", start);
		map.put("end", end);
		
		model.addAttribute("list", b_dao.listAll(map));
		
	}
}






