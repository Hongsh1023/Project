package com.bit.university.db;

import java.io.InputStream;
import java.util.HashMap;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.bit.university.vo.ChangeVo;
import com.bit.university.vo.StudentVo;

public class StudentManager {

	public static SqlSessionFactory sqlSessionFactory;

	static {
		String resource = "com/bit/university/db/sqlMapConfig.xml";
		try {
			InputStream inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (Exception e) {
			System.out.print("예외발생:" + e.getMessage());
		}
	}

	public static StudentVo getStudent(int std_no) {
		StudentVo student_vo = null;
		SqlSession session = sqlSessionFactory.openSession();
		HashMap map = new HashMap();
		map.put("std_no", std_no);
		student_vo = session.selectOne("student.getStudent", map);
		session.close();
		return student_vo;
	}
	
	public static int insertStudent(StudentVo sv3) {
		int re = -1;
		SqlSession session = sqlSessionFactory.openSession(true);
		re = session.insert("student.insertStudent", sv3);
		return re;
	}
	
	public static StudentVo getStartEndDate(int std_no) {
		StudentVo sv2 = null;
		SqlSession session = sqlSessionFactory.openSession();
		sv2 = session.selectOne("student.getStartEndDate", std_no);
		return sv2;
	}
}
