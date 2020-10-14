package com.bit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.bit.db.ConnectionProvider;
import com.bit.vo.ReplyVo;

public class ReplyDao {

	//댓글을 보기 위한 메소드
	public ArrayList<ReplyVo> listReply(int board_no) {
		ArrayList<ReplyVo> list = new ArrayList<ReplyVo>();
		try {
			String sql= "select * from reply where board_no=? order by reply_no desc";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, board_no);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(new ReplyVo(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getInt(4), rs.getInt(5)));
			}

		} catch(Exception e) {
			System.out.println("ReplyDao.listReply 예외발송:" + e.getMessage());
		}
		return list;
	}

	//댓글 수를 반환하는 메소드
	public int getTotalReply(int board_no) {
		int n=0;
		try {
			String sql= "select count(*) from reply where board_no=?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, board_no);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				n= rs.getInt(1);
			}
		} catch(Exception e) {
			System.out.println("ReplyDao.listReply 예외발송:" + e.getMessage());
		}
		return n;
	}

	//댓글을 등록하는 메소드
	public int insertReply(ReplyVo r_vo) {
		int re = -1;
		try {
			String sql= "insert into reply values(?,?,sysdate,?,?)";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			System.out.println(r_vo.getReply_no()+"/"+r_vo.getReply_content()+"/"+r_vo.getStd_no()+r_vo.getBoard_no());
			
			pstmt.setInt(1, r_vo.getReply_no());
			pstmt.setString(2, r_vo.getReply_content());
			pstmt.setInt(3, r_vo.getStd_no());
			pstmt.setInt(4, r_vo.getBoard_no());
			re = pstmt.executeUpdate();
			ConnectionProvider.close(conn, pstmt, null);
			
		} catch(Exception e) {
			System.out.println("ReplyDao.listReply 예외발송:" + e.getMessage());
		}
		return re;
	}

	//댓글 삭제 
	public int deleteReply(int reply_no) {
		int re = -1;
		try {
			String sql= "delete reply where reply_no="+reply_no;
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			re=stmt.executeUpdate(sql);
			ConnectionProvider.close(conn, stmt, null);
		} catch(Exception e) {
			System.out.println("ReplyDao.listReply 예외발송:" + e.getMessage());
		}
		return re;
	}

	//새로운 댓글 번호를 반환하는 메소드를 정의
	public int getNextReplyNo() {
		int n = 0;
		String sql = "select nvl(max(reply_no),0)+1 from reply";
		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()) {
				n = rs.getInt(1);
			}

			ConnectionProvider.close(conn, stmt, rs);
		}catch (Exception e) {
			System.out.println("getNextReplyNo예외발생:"+e.getMessage());
		}


		return n;
	}
	
	//댓글을 수정하는 메소드(내용만 수정함)
	public int updateReply(String reply_content, int reply_no) {
		int re=-1;
		try {
			String sql= "update reply set reply_content=?,reply_regdate=sysdate where reply_no=?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, reply_content);
			pstmt.setInt(2, reply_no);
			re = pstmt.executeUpdate();
			
			ConnectionProvider.close(conn, pstmt, null);
		} catch(Exception e) {
			System.out.println("ReplyDao.updaetReply 예외발송:" + e.getMessage());
		}
		return re;
		
		
	}

}


