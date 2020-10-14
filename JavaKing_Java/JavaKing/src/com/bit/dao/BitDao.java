package com.bit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.bit.db.ConnectionProvider;
import com.bit.vo.ChangeVo;
import com.bit.vo.StudentVo;

public class BitDao {
	public int login(int id, String pwd) {
		int re = 0;
		try {
			String sql = "select count(*) from student where STD_NO=? and STD_PWD=?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.setString(2, pwd);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				re = rs.getInt(1);
			}
			ConnectionProvider.close(conn, pstmt, rs);
		} catch (Exception e) {
			System.out.println("login error : " + e.getMessage());
		}
		return re;
	}

	public ChangeVo getChange(int std_no) {
		ChangeVo vo = null;
		try {
			String sql = "select * from change where STD_NO=?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, std_no);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				vo = new ChangeVo(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getString(5),
						rs.getDate(6), rs.getInt(7));
			}
			ConnectionProvider.close(conn, pstmt, rs);
		} catch (Exception e) {
			System.out.println("getChange error : " + e.getMessage());
		}
		return vo;
	}

	public StudentVo getStudentInfo(int std_no) {
		StudentVo sv = null;
		try {
			String sql = "select * from student where STD_NO=?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, std_no);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				sv = new StudentVo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getDate(6), rs.getInt(7), rs.getInt(8), rs.getString(9), rs.getString(10), rs.getDate(11),
						rs.getDate(12), rs.getString(13), rs.getInt(14));
			}
			ConnectionProvider.close(conn, pstmt, rs);
		} catch (Exception e) {
			System.out.println("Studentinfo:" + e.getMessage());
		}
		return sv;
	}

	public StudentVo getStartEndDate(int std_no) {
		StudentVo sv2 = null;
		try {
			String sql = "select * from student where STD_NO = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, std_no);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				sv2 = new StudentVo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getDate(6), rs.getInt(7), rs.getInt(8), rs.getString(9), rs.getString(10), rs.getDate(11),
						rs.getDate(12), rs.getString(13), rs.getInt(14));
			}
			ConnectionProvider.close(conn, pstmt, rs);
		} catch (Exception e) {
			System.out.println("StartEndDate:" + e.getMessage());
		}
		return sv2;
	}

	public int getStudentId(String name, String email) {
		int id = -1;
		try {
			String sql = "select STD_NO from student where STD_NAME=? and STD_EMAIL=?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, email);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				id = rs.getInt(1);
			}
			ConnectionProvider.close(conn, pstmt, rs);
		} catch (Exception e) {
			System.out.println("Studentinfo:" + e.getMessage());
		}
		return id;
	}

	public String getStudentPwd(int id, String email) {
		String pwd = null;
		try {
			String sql = "select STD_PWD from student where STD_NO=? and STD_EMAIL=?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.setString(2, email);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				pwd = rs.getString(1);
			}
			ConnectionProvider.close(conn, pstmt, rs);
		} catch (Exception e) {
			System.out.println("Studentinfo:" + e.getMessage());
		}
		return pwd;
	}

	public int updatePwd(int id, String old_pwd, String new_pwd) {
		int re = -1;
		try {
			String sql = "update student set STD_PWD=? where STD_NO=? and STD_PWD=?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, new_pwd);
			pstmt.setInt(2, id);
			pstmt.setString(3, old_pwd);
			re = pstmt.executeUpdate();
			ConnectionProvider.close(conn, pstmt, null);
		} catch (Exception e) {
			System.out.println("Studentinfo:" + e.getMessage());
		}
		return re;

	}
	
	public int insertStudentInfo(StudentVo sv3) {
    	int re = -1;
    	try {
			String sql = "insert into student values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, sv3.getStd_no());
			pstmt.setString(2, sv3.getStd_pwd());
			pstmt.setString(3, sv3.getStd_email());
			pstmt.setString(4, sv3.getStd_name());
			pstmt.setString(5, sv3.getStd_gender());
			pstmt.setDate(6, sv3.getStd_birthday());
			pstmt.setInt(7, sv3.getStd_level());
			pstmt.setInt(8, sv3.getStd_semester());
			pstmt.setString(9, sv3.getStd_major());
			pstmt.setString(10, sv3.getStd_status());
			pstmt.setDate(11, sv3.getStd_startdate());
			pstmt.setDate(12, sv3.getStd_enddate());
			pstmt.setString(13, sv3.getStd_etc());
			pstmt.setInt(14, sv3.getPro_no());
			
			re = pstmt.executeUpdate();
			ConnectionProvider.close(conn, pstmt, null);
		} catch (Exception e) {
			System.out.println("insert예외발생:"+e.getMessage());
		}
    	return re;
    }
}
