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

	public static List<BoardVo> getBoardList(String board_category, int board_boardno){
		List<BoardVo> list = null;
		SqlSession session = sqlSessionFactory.openSession();
		HashMap map = new HashMap();
		map.put("board_category", board_category);
		map.put("board_boardno", board_boardno);
		list = session.selectList("main.getBoardList", map);
		session.close();
		return list;
	}
	
}
