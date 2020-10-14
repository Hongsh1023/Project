package com.bit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.bit.db.ConnectionProvider;
import com.bit.vo.StudentVo;

public class StudentDao {

	private static StudentDao dao;
	
	public static StudentDao getInstance() {
		if(dao == null) {
			dao = new StudentDao();
		}
		return dao;
	}
	
	public StudentVo findByNo(int std_no) {
		StudentVo s = null;
		String sql = "select * from student where std_no=? ";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt= conn.prepareStatement(sql);
			pstmt.setInt(1, std_no);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				s = new StudentVo();
				s.setStd_no(rs.getInt(1));
				s.setStd_pwd(rs.getString(2));
				s.setStd_email(rs.getString(3));
				s.setStd_name(rs.getString(4));
				s.setStd_gender(rs.getString(5));
				s.setStd_birthday(rs.getDate(6));
				s.setStd_level(rs.getInt(7));
				s.setStd_semester(rs.getInt(8));
				s.setStd_major(rs.getString(9));
				s.setStd_status(rs.getString(10));
				s.setStd_startdate(rs.getDate(11));
				s.setStd_enddate(rs.getDate(12));
				s.setStd_etc(rs.getString(13));
				s.setPro_no(rs.getInt(14));
			}
			ConnectionProvider.close(conn, pstmt, rs);
		}catch(Exception e) {System.out.println("예외발생 Student-findByNo :"+e.getMessage());}
		return s;
	}
	
	public int loginCheck (int std_no, String std_pwd) {
		int check=0;
		String sql = "select count(*) from student where std_no=? and std_pwd=?";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt= conn.prepareStatement(sql);
			pstmt.setInt(1, std_no);
			pstmt.setString(2, std_pwd);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				check = rs.getInt(1);
			}
			ConnectionProvider.close(conn, pstmt, rs);
		}catch(Exception e) {System.out.println("예외발생 Student-loginCheck :"+e.getMessage());}
		return check;
	}
	
	public String statusCheck (int std_no) {
		String check="졸업";
		String sql = "select std_status from student where std_no=?";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt= conn.prepareStatement(sql);
			pstmt.setInt(1, std_no);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				check = rs.getString(1).trim();
			}
			ConnectionProvider.close(conn, pstmt, rs);
		}catch(Exception e) {System.out.println("예외발생 Student-statusCheck :"+e.getMessage());}
		return check;
	}
}
