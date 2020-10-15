package com.bit.university.db;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.bit.university.vo.BoardVo;

public class BoardManager {

	public static SqlSessionFactory sqlSessionFactory;

	static {
		String resource = "com/example/demo/db/sqlMapConfig.xml";
		try {
			InputStream inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (Exception e) {
			System.out.print("예외발생:" + e.getMessage());
		}
	}

	public static int updateBoard(BoardVo b_vo) {
		int re = -1;
		SqlSession session = sqlSessionFactory.openSession(true);
		re = session.update("board.updateBoard", b_vo);
		session.close();
		return re;
	}
	
	public static int deleteBoard(int board_no) {
		int re = -1;
		SqlSession session = sqlSessionFactory.openSession(true);
		re = session.delete("board.deleteBoard", board_no);
		session.close();
		return re;
	}
	
	public static void increaseHit(int board_no) {
		SqlSession session = sqlSessionFactory.openSession();
		session.update("board.increaseHit", board_no);
		session.close();
	}
	
	public static BoardVo getBoard(int board_no) {
		BoardVo b_vo = null;
		SqlSession session = sqlSessionFactory.openSession();
		b_vo = session.selectOne("board.getBoard", board_no);
		session.close();
		return b_vo; 
	}
	
	public static List<String> getBoardCategory(int board_boardno) {
		List<String> list = null;
		SqlSession session = sqlSessionFactory.openSession();
		list = session.selectList("board.getBoardCategory", board_boardno);
		session.close();
		return list;
	}
	
	public static List<BoardVo> listAll(int board_boardno, String board_category, int page_num, String search,String keyword) {
		List<BoardVo> list = null;
		SqlSession session = sqlSessionFactory.openSession();
		HashMap map = new HashMap();
		map.put("board_boardno", board_boardno);
		map.put("board_category", board_category);
		map.put("page_num", page_num);
		map.put("search", search);
		map.put("keyword", keyword);
		list = session.selectList("board.listAll", map);
		session.close();
		return list;
	}
	
	public static int getBoardCount(int board_boardno, String board_category, String search, String keyword) {
		int n = 0;
		SqlSession session = sqlSessionFactory.openSession();
		HashMap map = new HashMap();
		map.put("board_boardno", board_boardno);
		map.put("board_category", board_category);
		map.put("search", search);
		map.put("keyword", keyword);
		n = session.selectOne("board.deleteBoard", map);
		session.close();
		return n;
	}
	
	public static int getNextNo() {
		int n = 0;
		SqlSession session = sqlSessionFactory.openSession();
		n = session.selectOne("board.getNextNo");
		session.close();
		return n;
	}
	
	public static int insertBoard(BoardVo b) {
		int re = -1;
		SqlSession session = sqlSessionFactory.openSession();
		re = session.selectOne("board.insertBoard", b);
		session.close();
		return re;
	}
}
