package com.bit.university.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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

	// 로그인
	@RequestMapping(value = "/login.do", method = RequestMethod.GET)
	public void loginForm(HttpServletRequest request) {
	}

	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public ModelAndView login(HttpServletRequest request) {

		// 로그인 실패가 기본값. 리다이렉트 기본값으로 다시 login.do 로 오게함
		ModelAndView mav = new ModelAndView("redirect:/login.do");

		// 세션
		HttpSession session = request.getSession();

		// 입력한 std_no
		int std_no = Integer.parseInt(request.getParameter("std_no"));

		// 입력한 std_pwd
		String std_pwd = request.getParameter("std_pwd");

		// 로그인 성공여부 확인 메소드. (성공시 1 출력)
		int check = dao.loginCheck(std_no, std_pwd);

		// 성공할 경우
		if (check == 1) {

			// 메인페이지로 이동
			mav.setViewName("redirect:/login/main.do");

			// 학생정보 생성
			StudentVo vo = StudentManager.getStudent(std_no);

			// 아이디 저장 체크 여부 확인. 기본값은 체크하지 않은걸로 함
			String cb_id = "notChecked";
			if (request.getParameter("cb_id") != null && !request.getParameter("cb_id").equals("")) {
				cb_id = request.getParameter("cb_id");
			}
			session.setAttribute("cb_id", cb_id);

			// 아이디 저장 체크일 경우 login.jsp 에서 사용할 id 값을 반환해줌
			if (cb_id.equals("checked")) {
				session.setAttribute("re_id", std_no);
			}

			// 메인에서 사용할 학생정보 세션에 저장
			session.setAttribute("std_no", std_no);
			session.setAttribute("std_name", vo.getStd_name());
			session.setAttribute("std_major", vo.getStd_major());
			session.setAttribute("std_email", vo.getStd_email());
			session.setAttribute("std_semester", vo.getStd_semester());
			session.setAttribute("std_level", vo.getStd_level());

			// 메인에서 보여줄 게시판 목록 세션에 저장
			session.setAttribute("main_notice", dao.getBoardList("공지사항", 100));
			session.setAttribute("main_freeboard", dao.getBoardList("자유게시판", 300));
			session.setAttribute("main_flee_buy", dao.getBoardList("삽니다", 300));
			session.setAttribute("main_flee_sell", dao.getBoardList("팝니다", 300));
			session.setAttribute("main_anonymous", dao.getBoardList("익명게시판", 300));

		} else {

			// 실패할 경우 메시지 출력
			session.setAttribute("login_error", "로그인에 실패하였습니다.");
		}
		return mav;
	}

	// 아이디 찾기
	@RequestMapping("/findId.do")
	public void findIdForm() {

	}

	@RequestMapping("/findIdOk.do")
	public void findId(HttpServletRequest request) {

		// 세션
		HttpSession session = request.getSession();

		// findId.jsp 에서 이름과 이메일을 받아옴
		String std_name = request.getParameter("std_name");
		String std_email = request.getParameter("std_email");

		// std_no를 가져옴
		String std_no = dao.getStudentId(std_name, std_email) + "";

		// 이름이나 이메일이 틀릴경우 에러메시지, 둘다 맞을 경우 std_no 를 전송한다.
		if (std_no.equals("-1")) {
			session.setAttribute("result_id", "등록되지 않은 이름 또는 이메일입니다.");
		} else {
			session.setAttribute("result_id", std_no);
		}
	}

	// 비밀번호 찾기
	@RequestMapping("/findPwd.do")
	public void findPwdForm() {

	}

	@RequestMapping("/findPwdOk.do")
	public void findPwd(HttpServletRequest request) {

		// 세션
		HttpSession session = request.getSession();

		// findPwd.jsp 에서 아이디와 이메일을 받아옴
		int std_no = Integer.parseInt(request.getParameter("std_no"));
		String std_email = request.getParameter("std_email");

		// std_pwd 를 가져옴
		String std_pwd = dao.getStudentPwd(std_no, std_email);

		// 이름이나 이메일이 틀릴경우 에러메시지, 둘다 맞을 경우 std_pwd 를 전송한다.
		if (std_pwd != null && !std_pwd.equals("")) {
			session.setAttribute("result_pwd", std_pwd);
		} else {
			session.setAttribute("result_pwd", "등록되지 않은 아이디 또는 이메일입니다.");
		}
	}

}