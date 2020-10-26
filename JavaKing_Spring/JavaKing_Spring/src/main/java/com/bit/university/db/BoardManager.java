package com.bit.university.db;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.bit.university.vo.BoardVo;

public class BoardManager {

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
		list = list.stream().distinct().collect(Collectors.toList());
		return list;
	}
	
	public static List<BoardVo> listAll(HashMap map) {
		List<BoardVo> list = null;
		SqlSession session = sqlSessionFactory.openSession();
		
		list = session.selectList("board.findAll", map);
		
		session.close();
		
		return list;
	}
	
	public static int getBoardCount(int board_boardno, String board_category, String search, String keyword) {
		int n = 0;
		System.out.println(board_boardno+"/"+board_category+"/"+search+"/"+keyword);
		System.out.println("getBoardCountTest______1111");
		SqlSession session = sqlSessionFactory.openSession();
		System.out.println("getBoardCountTest______2222");
		HashMap map = new HashMap();
		System.out.println("getBoardCountTest______3333");
		map.put("board_boardno", board_boardno);
		System.out.println("getBoardCountTest______4444");
		map.put("board_category", board_category);
		map.put("search", search);
		map.put("keyword", keyword);
		n = session.selectOne("board.getBoardCount", map);
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
	
	public static int insertBoard(BoardVo b_vo) {
		int re = -1;
		System.out.println("manager.boardcategory::::::::" +b_vo.getBoard_category());
		SqlSession session = sqlSessionFactory.openSession(true);
		re = session.insert("board.insertBoard", b_vo);
		session.close();
		return re;
	}
}
