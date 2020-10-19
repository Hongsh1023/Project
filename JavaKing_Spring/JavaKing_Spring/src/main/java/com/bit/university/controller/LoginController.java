package com.bit.university.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bit.university.dao.MainDao;
import com.bit.university.db.StudentManager;
import com.bit.university.vo.StudentVo;

@Controller
public class LoginController {
	
	@Autowired
	private MainDao dao;
	
	public void setDao(MainDao dao) {
		this.dao = dao;
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public void login() {
	}
	
	@RequestMapping("/login/main")
	public String main(HttpSession session, HttpServletRequest request) {
		SecurityContext context = SecurityContextHolder.getContext();
		Authentication authentication = context.getAuthentication();
		User user = (User) authentication.getPrincipal();
		String std_no = user.getUsername();

		StudentVo vo = StudentManager.getStudent(std_no);
		
		// 아이디 저장 체크 여부 확인. 기본값은 체크하지 않은걸로 함
        String remember_id = "notChecked";
        if (request.getParameter("cb_id") != null && !request.getParameter("cb_id").equals("")) {
        	remember_id = request.getParameter("cb_id");
        }
        
        // 아이디 저장 체크일 경우 login.jsp 에서 사용할 id 값을 반환해줌
        if (remember_id.equals("checked")) {
        	request.getSession().setAttribute("re_id", std_no);
        }
        
		session.setAttribute("std_no", std_no);
		session.setAttribute("std_name", vo.getStd_name());
		session.setAttribute("std_major", vo.getStd_major());
		session.setAttribute("std_email", vo.getStd_email());
		session.setAttribute("std_semester", vo.getStd_semester());
		session.setAttribute("std_level", vo.getStd_level());
		
		session.setAttribute("main_notice", dao.getBoardList("공지사항", 100));
		session.setAttribute("main_freeboard", dao.getBoardList("자유게시판", 300));
		session.setAttribute("main_flee_buy", dao.getBoardList("삽니다", 300));
		session.setAttribute("main_flee_sell", dao.getBoardList("팝니다", 300));
		session.setAttribute("main_anonymous", dao.getBoardList("익명게시판", 300));
		return "/login/main";
	}
}