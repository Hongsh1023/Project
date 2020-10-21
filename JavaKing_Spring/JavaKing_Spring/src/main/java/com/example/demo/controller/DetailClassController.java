package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.ClassregDao;
import com.example.demo.vo.ClassregVo;


@Controller
public class DetailClassController {

	private HttpSession session;
	
	@Autowired
	private ClassregDao dao;
	
	public void setDao (ClassregDao dao) {
		this.dao=dao;
	}
	

	@RequestMapping(value="/detailClass.do", method=RequestMethod.GET)
	public void detailClassForm(Model model) {
//		int std_no =(Integer) session.getAttribute("std_no");
		int std_no = 2014104195; 	//test 용!
		model.addAttribute("std_no", std_no);
	}
	
	@RequestMapping(value="/detailClass.do", method=RequestMethod.POST)
	public void detailClassSubmit(Model model, 
			@RequestParam(value="class_year", defaultValue="2020") String class_year,
			@RequestParam(value="classreg_semester", defaultValue="1") int classreg_semester){ 
		int std_no = 2014104195; 	//test 용!
		//int std_no =(Integer) session.getAttribute("std_no");
		System.out.println("std_no, class_year, classreg_semester: "+std_no+","+"class_year"+","+classreg_semester);

		HashMap map = new HashMap ();
		map.put("std_no", std_no);
		map.put("class_year", class_year);
		map.put("classreg_semester", classreg_semester);
		List<ClassregVo> classreg_list = null;
		classreg_list = dao.detailClassregList(map);
		if(classreg_list == null || classreg_list.size()==0) {
			String classreg_str = "조회 내역이 없습니다.";
			model.addAttribute("classreg_str",classreg_str);
		}else {
			model.addAttribute("classreg_list", classreg_list);
		}
	}
	
}
