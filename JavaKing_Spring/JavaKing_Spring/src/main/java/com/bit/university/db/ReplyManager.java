package com.bit.university.db;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.bit.university.vo.ReplyVo;



public class ReplyManager {

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

	public static List<ReplyVo> listReply(int board_no) {
		List<ReplyVo> list = null;
		SqlSession session = sqlSessionFactory.openSession();
		list = session.selectList("reply.listReply",board_no);
		session.close();
		return list;
	}
	
	public static int getTotalReply(int board_no) {
		int n=0;
		SqlSession session = sqlSessionFactory.openSession();
		n=session.selectOne("reply.getTotalReply", board_no);
		session.close();
		return n;
	}
	
	public static int insertReply(ReplyVo r_vo) {
		int re=0;
		SqlSession session = sqlSessionFactory.openSession(true);
		re=session.insert("reply.insertReply", r_vo);
		session.close();
		return re;
	}
	
	public static int deleteReply(int reply_no) {
		int re=0;
		SqlSession session = sqlSessionFactory.openSession(true);
		re=session.insert("reply.deleteReply", reply_no);
		session.close();
		return re;
	}
	
	public static int getNextReplyNo() {
		int n=0;
		SqlSession session = sqlSessionFactory.openSession();
		n = session.selectOne("reply.getNextReplyNo");
		session.close();
		return n;
	}
	
	public static int updateReply(String reply_content, int reply_no) {
		int re=0;
		SqlSession session = sqlSessionFactory.openSession(true);
		HashMap map = new HashMap();
		map.put("reply_content", reply_content);
		map.put("reply_no", reply_no);
		re=session.insert("reply.updateReply", map);
		session.close();
		return re;
	}
		
}
