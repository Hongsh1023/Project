package com.bit.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bit.dao.ClassDao;
import com.bit.dao.ClassRegDao;
import com.bit.vo.ClassVo;
import com.bit.vo.ClassregVo;

public class ClassRegDeleteAction implements BitAction {
	private int pageSize = 6;
	private int totalCount;
	private int totalPage;
	private ClassRegDao crdao;
	
	@Override
	public String pro(HttpServletRequest request, HttpServletResponse resonse) throws ServletException, IOException {
		int classreg_no = Integer.parseInt(request.getParameter("classregno"));
		crdao = ClassRegDao.getInstance();
		ClassDao cdao = ClassDao.getInstence();
		HttpSession session = request.getSession();
		int std_no = Integer.parseInt(request.getParameter("stdno"));
		
		int re = crdao.deleteClassreg(classreg_no);
		if(re > 0 ) {
			request.setAttribute("msg", "삭제에 성공했습니다.");
			request.setAttribute("color","blue");
		}else {
			request.setAttribute("msg", "삭제에 실패했습니다.");
			request.setAttribute("color","red");
		}
		
		//서치내역
		totalCount = cdao.getTotalCount(null);
		totalPage = (int) Math.ceil((double) totalCount/pageSize);
		session.setAttribute("totalPage", totalPage);
		int pageNum=1;
		if(request.getParameter("pageNum") !=null) {
			pageNum=Integer.parseInt(request.getParameter("pageNum"));
		}
					int start = (pageNum-1)*pageSize+1;
		int end = (start+pageSize)-1;
		if(end > totalCount) {
			end=totalCount;
		}
		ArrayList<ClassVo> list2 = cdao.listClass(start, end, null); //전체보이기
		session.setAttribute("searchList", list2);
		

		//신청 점수, 갯수
		int countCredit =0;
		int countSubject =0;
		countCredit = crdao.countCredit(std_no);
		countSubject = crdao.countSubject(std_no);
		session.setAttribute("cCredit", countCredit);
		session.setAttribute("cSubject", countSubject);
		
		//수강신청 하단의 신청내역
		ArrayList<ClassregVo> list = new ArrayList<ClassregVo>();
		list = crdao.listAll(std_no);
		session.setAttribute("crList", list);

		return "classreg.jsp";
	}

}
