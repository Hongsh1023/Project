package com.bit.university.db;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.bit.university.vo.ProfessorVo;

public class ProfessorManager {
	
public static SqlSessionFactory sqlSessionFactory;
	
	static {
		String resource = "com/bit/university/db/sqlMapConfig.xml";
		try {
		InputStream inputStream = Resources.getResourceAsStream(resource);		
		sqlSessionFactory =
		  new SqlSessionFactoryBuilder().build(inputStream);
		}catch (Exception e) {
			System.out.print("예외발생:"+e.getMessage());
		}
	}
	
	public static List<ProfessorVo> professorList(){
		List<ProfessorVo> list = null;
		SqlSession session = sqlSessionFactory.openSession();
		list = session.selectList("professor.professorList");
		session.close();
		return list;
	}
	
	public static int ProfessorInsert(ProfessorVo p) {
		int re = -1;
		SqlSession session = sqlSessionFactory.openSession(true);
		re = session.insert("professor.professorInsert", p);
		session.close();
		return re;
	}
}
