package com.bit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.bit.action.ListBoardAction;
import com.bit.db.ConnectionProvider;
import com.bit.vo.BoardVo;

public class BoardDao {

	// 모든 게시물 목록을 반환하는 메소드를 정의
	public ArrayList<BoardVo> listAll(int board_boardno, String board_category, int page_num, String search,
			String keyword) {
		ArrayList<BoardVo> list = new ArrayList<BoardVo>();
		int end = page_num * ListBoardAction.page_size;
		int start = end - (ListBoardAction.page_size - 1);
		System.out.println("listAll.end =" + end);
		System.out.println("listAll.start=" + start);

		// 같은 게시판 같은 분류 게시판 리스트를 뽑아오는 sql문
		String sql = "select n, board_no,board_boardno,board_category,board_title,board_content,"
				+ "board_regdate,board_hit,board_pwd,board_fname,std_no from"
				+ "(select rownum n, board_no,board_boardno,board_category,board_title,"
				+ "board_content,board_regdate,board_hit,board_pwd,board_fname,std_no"
				+ " from (select * from board order by board_no desc, board_regdate desc)"
				+ "where board_category like '%" + board_category + "%'" + " and board_boardno=" + board_boardno;

		if (search != null && keyword != null && !keyword.equals("")) {
			sql += " and " + keyword + " like '%" + search + "%'";

		}

		sql += ")where n >=" + start + " and n <= " + end;

		System.out.println(sql);

		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				list.add(new BoardVo(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getDate(7), rs.getInt(8), rs.getString(9), rs.getString(10),
						rs.getInt(11)));
			}
			ConnectionProvider.close(conn, stmt, rs);

		} catch (Exception e) {
			System.out.println("BoardDao.listAll예외발생:" + e.getMessage());
		}

		return list;
	}

	// 선택한 게시판의 모든 게시물 수를 반환해주는 메소드
	public int getBoardCount(int board_boardno, String board_category, String search, String keyword) {
		int n = 0;
		String sql = "select count(*) from board where board_boardno=" + board_boardno + " and board_category='"
				+ board_category;

		if (search != null && keyword != null && !keyword.equals("")) {
			sql += " and " + keyword + " like '%" + search + "%'";

		}
		sql += "' order by board_no";
		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {
				n = rs.getInt(1);
			}
			ConnectionProvider.close(conn, stmt, rs);
		} catch (Exception e) {
			System.out.println("BoardDao.getBoardCount예외발생:" + e.getMessage());
		}

		return n;
	}

	// 새로운 글번호를 반환하는 메소드를 정의
	public int getNextNo() {
		int n = 0;
		String sql = "select nvl(max(board_no),0)+1 from board";
		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {
				n = rs.getInt(1);
			}

			ConnectionProvider.close(conn, stmt, rs);
		} catch (Exception e) {
			System.out.println("예외발생:" + e.getMessage());
		}
		return n;
	}

	// 글등록을 위한 메소드
	public int insertBoard(BoardVo b) {
		int re = -1;
		System.out.println(b.getBoard_no() + "" + b.getBoard_boardno() + "" + b.getBoard_category() + ""
				+ b.getBoard_title() + "" + b.getBoard_content() + "" + b.getBoard_regdate() + "" + b.getBoard_hit()
				+ "" + b.getBoard_pwd() + "" + b.getBoard_fname() + "" + b.getStd_no());

		String sql = "insert into board values(?,?,?,?,?,sysdate,0,?,?,?)";
		System.out.println("어디까지 오니 1");
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			System.out.println("어디까지 오니 2");
			pstmt.setInt(1, b.getBoard_no());
			pstmt.setInt(2, b.getBoard_boardno());
			pstmt.setString(3, b.getBoard_category());
			pstmt.setString(4, b.getBoard_title());
			pstmt.setString(5, b.getBoard_content());
			pstmt.setString(6, b.getBoard_pwd());
			pstmt.setString(7, b.getBoard_fname());
			pstmt.setInt(8, b.getStd_no());
			System.out.println("어디까지 오니 3");
			re = pstmt.executeUpdate();
			System.out.println("어디까지 오니 4");
			System.out.println("re는 " + re);
			ConnectionProvider.close(conn, pstmt, null);
		} catch (Exception e) {
			System.out.println("BoardDao.insertBoard예외발생:" + e.getMessage());
		}
		return re;
	}
	
	public String getName(int std_no) {
		String name = null;
		String sql = "select STD_NAME from student where STD_NO=?";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, std_no);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				name = rs.getString(1);
			}
			ConnectionProvider.close(conn, pstmt, rs);
		} catch (Exception e) {
			System.out.println("BoardDao.getName예외발생:" + e.getMessage());
		}
		return name;
	}
}