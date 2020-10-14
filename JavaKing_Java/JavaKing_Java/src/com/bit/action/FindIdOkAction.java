package com.bit.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.dao.BitDao;

public class FindIdOkAction implements BitAction {

	@Override
	public String pro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 인코딩
		request.setCharacterEncoding("UTF-8");

		// Dao 생성
		BitDao dao = new BitDao();

		// findId.jsp 에서 이름과 이메일을 받아옴
		String name = request.getParameter("name");
		String email = request.getParameter("email");

		// id를 가져옴
		String id = dao.getStudentId(name, email) + "";

		// 이름이나 이메일이 틀릴경우 에러메시지, 둘다 맞을 경우 id 를 전송한다.
		if (id.equals("-1")) {
			request.setAttribute("findid", "등록되지 않은 이름 또는 이메일입니다.");
		} else {
			request.setAttribute("findid", id);
		}
		return "findIdOk.jsp";
	}
}
