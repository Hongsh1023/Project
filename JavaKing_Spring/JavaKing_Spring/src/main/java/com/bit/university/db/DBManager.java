package com.bit.university.db;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.bit.university.vo.ChangeVo;
import com.bit.university.vo.StudentVo;

public class DBManager {
	
	public static SqlSessionFactory sqlSessionFactory;
	
	static {
		String resource = "com/example/demo/db/sqlMapConfig.xml";
		try {
		InputStream inputStream = Resources.getResourceAsStream(resource);		
		sqlSessionFactory =
		  new SqlSessionFactoryBuilder().build(inputStream);
		}catch (Exception e) {
			System.out.print("예외발생:"+e.getMessage());
		}
	}
	
	public static StudentVo getStudentInfo(int std_no) {
		StudentVo sv = null;
		SqlSession session = sqlSessionFactory.openSession();
		sv = session.selectOne("student.getStudentInfo", std_no);
		return sv;
	}
	
	public static ChangeVo getChangeInfo(int std_no) {
		ChangeVo cv = null;
		SqlSession session = sqlSessionFactory.openSession();
		cv = session.selectOne("student.getChangeInfo", std_no);
		return cv;
	}
	
	public static StudentVo getStartEndDate(int std_no) {
		StudentVo sv2 = null;
		SqlSession session = sqlSessionFactory.openSession();
		sv2 = session.selectOne("student.getStartEndDate", std_no);
		return sv2;
	}
	
	public static int insertStudentInfo(StudentVo sv3) {
		int re = -1;
		SqlSession session = sqlSessionFactory.openSession(true);
		re = session.insert("student.insertStudentInfo", sv3);
		return re;
	}
}
