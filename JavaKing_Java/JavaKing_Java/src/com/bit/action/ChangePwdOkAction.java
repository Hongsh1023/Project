package com.bit.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.dao.BitDao;

public class ChangePwdOkAction implements BitAction {

	@Override
	public String pro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 인코딩
		request.setCharacterEncoding("UTF-8");

		// Dao 생성
		BitDao dao = new BitDao();

		// 뷰페이지 생성. 기본값은 실패로 치고 비밀번호 변경페이지로 이동시킴
		String view = "changePwd.jsp";

		// 비밀번호 변경 페이지에서 보여줄 값 설정.
		String msg = null;

		// findId.jsp 에서 기존 비밀번호, 변경 비밀번호, 비밀번호 확인을 받아옴
		String old_pwd = request.getParameter("old_pwd");
		String new_pwd = request.getParameter("new_pwd");
		String new_pwd_check = request.getParameter("new_pwd_check");
		
		// 비밀번호와 비밀번호 확인 일치여부 체크.
		if (!new_pwd.equals(new_pwd_check)) {
			msg = "비밀번호 확인이 맞지 않습니다.";
		} else {
			// id를 가져옴
			int id = (Integer) request.getSession().getAttribute("login");

			// pwd 변경
			int re = dao.updatePwd(id, old_pwd, new_pwd);

			if (re <= 0) {
				msg = "기존 비밀번호가 맞지 않습니다.";
			} else {
				view = "main.do";
			}
		}

		// 실패시 전송할 메시지
		request.setAttribute("change_pwd_error", msg);

		return view;
	}
}

