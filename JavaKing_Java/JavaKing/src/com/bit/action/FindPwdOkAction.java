package com.bit.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.dao.BitDao;

public class FindPwdOkAction implements BitAction {

	@Override
	public String pro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 인코딩
		request.setCharacterEncoding("UTF-8");

		// Dao 생성
		BitDao dao = new BitDao();

		// findId.jsp 에서 아이디와 이메일을 받아옴
		int id = Integer.parseInt(request.getParameter("id"));
		String email = request.getParameter("email");

		// pwd 를 가져옴
		String pwd = dao.getStudentPwd(id, email);

		// 이름이나 이메일이 틀릴경우 에러메시지, 둘다 맞을 경우 pwd 를 전송한다.
		if (pwd != null && !pwd.equals("")) {
			request.setAttribute("findpwd", pwd);
		} else {
			request.setAttribute("findpwd", "등록되지 않은 아이디 또는 이메일입니다.");
		}
		return "findPwdOk.jsp";
	}
}
