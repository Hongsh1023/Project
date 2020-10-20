package com.example.demo.db;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.example.demo.vo.ProfessorVo;
import com.example.demo.vo.RegisterVo;



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
	
	public static List<RegisterVo> registerList(int std_no){
		List<RegisterVo> list = null;
		SqlSession session = sqlSessionFactory.openSession();
		list = session.selectList("register.registerList", std_no);
		session.close();
		return list;
	}
	
	public static int registerInsert(RegisterVo r) {
		int re = -1;
		SqlSession session = sqlSessionFactory.openSession(true);
		re = session.insert("register.registerInsert", r);
		session.close();
		return re;
	}
	
	public static int registerNextNo() {
		int n = 0;
		SqlSession session = sqlSessionFactory.openSession();
		n = session.selectOne("register.nextNo");
		session.close();
		return n;
	}
	
}




















