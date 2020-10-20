package com.example.demo.db;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.example.demo.vo.ClassVo;

public class ClassManager {

	static SqlSessionFactory sqlSessionFactory;
	static {
		try {
		String resource = "com/example/demo/db/sqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		 sqlSessionFactory =
		  new SqlSessionFactoryBuilder().build(inputStream);
		}catch(Exception e) {System.out.println("sqlsession 시작 오류 : "+e.getMessage());
	}
	}	
	
	public static List<ClassVo> classList(HashMap map){
		List<ClassVo> list = null;
		SqlSession session = sqlSessionFactory.openSession();
		list = session.selectList("class.classSelectAll", map);		
		session.close();
		return list;
	}
	
	public static int classTotalRecord(HashMap map) {
		int n = -1;
		SqlSession session = sqlSessionFactory.openSession();
		n = session.selectOne("class.classTotalRecord", map);
		session.close();
		return n;
	}
	
	public static int classNextNo() {
		int n =-1;
		SqlSession session = sqlSessionFactory.openSession();
		n = session.selectOne("class.classNextNo");
		session.close();
		return n;
	}
	
	public static ClassVo classFindByNo(int class_no) {
		ClassVo c_vo = null;
		SqlSession session = sqlSessionFactory.openSession();
		c_vo = session.selectOne("class.classFindByNo", class_no);
		session.close();
		return c_vo;
	}
	
	public static int classInsert(ClassVo c_vo) {
		int n = -1;
		SqlSession session = sqlSessionFactory.openSession(true);
		n = session.insert("class.classInsert", c_vo);
		session.close();
		return n;
	}
	
	public static int classUpdate(ClassVo c_vo) {
		int n = -1;
		SqlSession session = sqlSessionFactory.openSession(true);
		n = session.update("class.classUpdate", c_vo);
		session.close();
		return n;
	}
	
	public static int classDelete(int class_no) {
		int n = -1;
		SqlSession session = sqlSessionFactory.openSession(true);
		n = session.delete("class.classDelete", class_no);
		session.close();
		return n;
	}

}
