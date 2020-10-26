package com.bit.university.db;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.bit.university.vo.GradeVo;

public class GradeManager {
	public static SqlSessionFactory sqlSessionFactory;//객체없이 쓰려고 static
	
	static {
		try {
			String resource = "com/bit/university/db/sqlMapConfig.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("예외발생 : "+e.getMessage());
		}
	}
	
	public static List<GradeVo> listAll(int std_no){
		HashMap map = new HashMap();
		map.put("std_no", std_no);
		
		List<GradeVo> list = null;
		int max_grade_level = 0;
		int max_grade_semester = 0;
		
		SqlSession session = sqlSessionFactory.openSession();
		//해당 학생의 최고학년 구함
		max_grade_level = session.selectOne("grade.levelMax", map);
		map.put("max_grade_level", max_grade_level);
		//구한 값을 맵에 추가한뒤 최고학년의 최고학기 구함
		max_grade_semester = session.selectOne("grade.semesterMax", map);
		//맵에 추가
		map.put("max_grade_semester", max_grade_semester);		
		list = session.selectList("grade.selectAll",map);
		session.close();
		return list;
	}
	
	public static List<GradeVo> detail(HashMap map){
		List<GradeVo> list = null;
		SqlSession session = sqlSessionFactory.openSession();
		list = session.selectList("grade.detail",map);
		
		session.close();
		return list;
	}
	
	public static int insert(GradeVo vo) {
		int re = -1;
		SqlSession session = sqlSessionFactory.openSession(true);
		System.out.println(vo);
		re = session.insert("grade.insert",vo);
		session.close();
		return re;
	}
	
	public static GradeVo findByNo(int grade_no) {
		GradeVo vo = null;
		SqlSession session = sqlSessionFactory.openSession();
		vo = session.selectOne("grade.selectOne",vo);
		session.close();
		return vo;
	}
	
	public static int update(GradeVo vo) {
		int re = -1;
		SqlSession session = sqlSessionFactory.openSession(true);
		re = session.update("grade.update",vo);
		session.close();
		return re;
	}
	
	public static int delete(int grade_no) {
		int re = -1;
		SqlSession session = sqlSessionFactory.openSession(true);
		re = session.update("grade.delete",grade_no);
		session.close();
		return re;
	}
}
