package com.bit.university.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bit.university.dao.MainDao;

@Controller
public class MainController {

	@Autowired
	private MainDao dao;

	public void setDao(MainDao dao) {
		this.dao = dao;
	}
	
	// 메인페이지
	@RequestMapping("/login/main.do")
	public void main(HttpServletRequest request) {
		
		// 세션
		HttpSession session = request.getSession();
		
		// 로그인, 메인에서 사용한 모든 에러메시지 삭제.
		session.removeAttribute("change_pwd_error");
		session.removeAttribute("login_error");
		session.removeAttribute("result_id");
		session.removeAttribute("result_pwd");
	}

	// 비밀번호 변경
	@RequestMapping(value = "/login/changePwd.do", method = RequestMethod.GET)
	public void updatePwdForm() {
	}

	@RequestMapping(value = "/login/changePwd.do", method = RequestMethod.POST)
	public ModelAndView updatePwd(HttpServletRequest request) {
		
		// 세션
		HttpSession session = request.getSession();
		
		// 기존 비밀번호, 새 비밀번호, 비밀번호 확인을 받아옴
		String old_pwd = request.getParameter("old_pwd");
		String new_pwd = request.getParameter("new_pwd");
		String new_pwd_check = request.getParameter("new_pwd_check");
		
		// 사용자 학번 받아옴
		String str_std_no = session.getAttribute("std_no") + "";
		int std_no = Integer.parseInt(str_std_no);
		
		// 비밀번호 변경 성공을 기본값으로 하여 성공시 main 으로 이동
		ModelAndView mav = new ModelAndView("redirect:/login/main.do");
		
		String msg = "";
		int re = -1;
		
		// 오류발생시 1로 만들어 나머지 if문 실행하지 않게함.
		int stop = 0;
		
		// 기존 비밀번호와 새 비밀번호가 일치할경우 에러발생
		if (old_pwd.equals(new_pwd) && stop == 0) {
			mav.setViewName("redirect:/login/changePwd.do");
			msg = "기존과 동일한 비밀번호입니다.";
			stop++;
		}
		
		// 새 비밀번호와 비밀번호 확인이 불일치할경우 에러발생
		if (!new_pwd.equals(new_pwd_check) && stop == 0) {
			mav.setViewName("redirect:/login/changePwd.do");
			msg = "비밀번호 확인이 맞지 않습니다.";
			stop++;
		}
		
		if (stop == 0) {
			
			// 비밀번호 변경 메소드 실행
			re = dao.updatePwd(old_pwd, new_pwd, std_no);
			
			// 비밀번호 변경시 기존 비밀번호가 DB 와 맞지 않을경우 에러발생
			if (re <= 0) {
				mav.setViewName("redirect:/login/changePwd.do");
				msg = "기존 비밀번호가 맞지 않습니다.";
			}
		}
		
		// 에러 메시지 세션 저장후 출력
		session.setAttribute("change_pwd_error", msg);
		return mav;
	}

	// 로그아웃
	@RequestMapping("/login/logout.do")
	public ModelAndView logout(HttpServletRequest request) {
		
		// 로그아웃 성공시 로그인 페이지로 이동
		ModelAndView mav = new ModelAndView("redirect:/login.do");
		
		// 세션
		HttpSession session = request.getSession();

		String cb_id = "";
		String re_id = null;
		
		// 아이디 저장여부 확인. 아이디 저장에 체크했을경우 해당 정보를 전송함
		if (session.getAttribute("cb_id") != null && !session.getAttribute("cb_id").equals("")) {
			cb_id = session.getAttribute("cb_id") + "";
		}
		
		// 아이디 저장에 체크했을경우 로그인페이지에서 보여줄 저장된 아이디를 전송함
		if (cb_id.equals("checked")) {
			re_id = session.getAttribute("re_id") + "";
		}
		
		// invalidate(); 로 모든 세션값을 삭제한 뒤 새 세션 생성후 아이디 저장정보 추가.
		session.invalidate();
		session = request.getSession(true);
		session.setAttribute("cb_id", cb_id);
		if (re_id != null && re_id.equals("")) {
			re_id = null;
		}
		session.setAttribute("re_id", re_id);
		
		return mav;
	}
}
