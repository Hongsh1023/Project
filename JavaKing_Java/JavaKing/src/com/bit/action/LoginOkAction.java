package com.bit.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.dao.BitDao;

public class LoginOkAction implements BitAction {

    @Override
    public String pro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// Dao 생성
    	BitDao dao = new BitDao();
    	 
    	// 인코딩
    	request.setCharacterEncoding("UTF-8");
    	
    	// login.jsp 에서 id 값 가져옴
        int id = Integer.parseInt(request.getParameter("id"));
        
        // 아이디 저장 체크 여부 확인. 기본값은 체크하지 않은걸로 함
        String remember_id = "notChecked";
        if (request.getParameter("cb_id") != null) {
        	remember_id = request.getParameter("cb_id");
        }
        
        // 아이디 저장 체크일 경우 login.jsp 에서 사용할 id 값을 반환해줌
        if (remember_id.equals("checked")) {
        	request.getSession().setAttribute("re_id", id);
        }
        
        // login.jsp 에서 pwd 값 가져옴
        String pwd = request.getParameter("pwd");
       
        // 뷰페이지 기본값을 login.jsp 로 함. 로그인 실패했다고 침
        String view = "login.jsp";
        
        // 로그인 실패시 출력할 에러메시지
        String msg = null;
        
        // 로그인 성공 여부 체크. 값이 1 일경우 성공. 필요한 모든 정보를 세션에 담아 main 뷰페이지로 보냄
        int check = dao.login(id, pwd);

        if (check == 1) {
        	String name = dao.getStudentInfo(id).getStd_name();
            int level = dao.getStudentInfo(id).getStd_level();
            int semester = dao.getStudentInfo(id).getStd_semester();
            String major = dao.getStudentInfo(id).getStd_major();
            String email = dao.getStudentInfo(id).getStd_email();
            request.getSession().setAttribute("std_no", id);
            request.getSession().setAttribute("name", name);
            request.getSession().setAttribute("level", level);
            request.getSession().setAttribute("semester", semester);
            request.getSession().setAttribute("major", major);
            request.getSession().setAttribute("email", email);
            view = "login/main.do";
        } else {
        	msg = "로그인에 실패하였습니다.";
        }
        // 에러메시지 전송
        request.setAttribute("login_error", msg);
        return view;
    }

}

