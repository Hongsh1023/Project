package com.bit.university.db;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.bit.university.vo.BoardVo;

public class MainManager {

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

	public static List<BoardVo> getBoardList(String board_category, int board_boardno) {
		List<BoardVo> list = null;
		SqlSession session = sqlSessionFactory.openSession();
		HashMap map = new HashMap();
		map.put("board_category", board_category);
		map.put("board_boardno", board_boardno);
		list = session.selectList("main.getBoardList", map);
		session.close();
		return list;
	}

	public static int loginCheck(int std_no, String std_pwd) {
		int re = -1;
		SqlSession session = sqlSessionFactory.openSession();
		HashMap map = new HashMap();
		map.put("std_no", std_no);
		map.put("std_pwd", std_pwd);
		re = session.selectOne("main.loginCheck", map);
		session.close();
		return re;
	}

	public static int updatePwd(String old_pwd, String new_pwd, int std_no) {
		int re = -1;
		SqlSession session = sqlSessionFactory.openSession(true);
		HashMap map = new HashMap();
		map.put("old_pwd", old_pwd);
		map.put("new_pwd", new_pwd);
		map.put("std_no", std_no);
		re = session.update("main.updatePwd", map);
		return re;
	}

	public static int getStudentId(String std_name, String std_email) {
		int re = -1;
		SqlSession session = sqlSessionFactory.openSession();
		HashMap map = new HashMap();
		map.put("std_name", std_name);
		map.put("std_email", std_email);
		if (session.selectOne("main.getStudentId", map) != null) {
			re = session.selectOne("main.getStudentId", map);
		}
		return re;
	}
	
	public static String getStudentPwd(int std_no, String std_email) {
		String re = "";
		SqlSession session = sqlSessionFactory.openSession();
		HashMap map = new HashMap();
		map.put("std_no", std_no);
		map.put("std_email", std_email);
		re = session.selectOne("main.getStudentPwd", map);
		return re;
	}
}
