package com.bit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.bit.db.ConnectionProvider;
import com.bit.vo.ClassVo;

public class ClassDao {

	private static ClassDao dao;
	
	public static ClassDao getInstence() {
		if(dao == null) {
			dao = new ClassDao();
		}
		return dao;
	}
	
	public int getTotalCount(String search) {
		int n =0;
		String sql = "select count(*) from class";
		if(search != null){
			sql+=" where class_name like '%"+search+"%'";
		}
		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs =stmt.executeQuery(sql);
			if(rs.next()) {
				n = rs.getInt(1);
			}
			ConnectionProvider.close(conn, stmt, rs);
					
		}catch (Exception e) {
			System.out.println("예외발생 class-getTotalCount:"+e.getMessage());
		}
		return n;
	}
	
	public int getNextClassNo() {
		int n = 0;
		String sql = "select nvl(max(class_no),0)+1 from class";
		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs =stmt.executeQuery(sql);
			if(rs.next()) {
				n = rs.getInt(1);
			}
			ConnectionProvider.close(conn, stmt, rs);
					
		}catch (Exception e) {
			System.out.println("예외발생 class-getNextClassNo:"+e.getMessage());
		}
		
		return n;
	}
	
	public ClassVo findByNo(int class_no) {
		ClassVo cv = null;
		String sql = "select * from class where class_no=?";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt= conn.prepareStatement(sql);
			pstmt.setInt(1, class_no);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				cv = new ClassVo();
				cv.setClass_no(rs.getInt(1));
				cv.setClass_name(rs.getString(2));
				cv.setClass_startdate(rs.getString(3));
				cv.setClass_enddate(rs.getString(4));
				cv.setClass_dayofweek(rs.getString(5));
				cv.setClass_time(rs.getString(6));
				cv.setClass_room(rs.getString(7));
				cv.setClass_credit(rs.getInt(8));
				cv.setClass_type(rs.getString(9));
				cv.setPro_no(rs.getInt(10));
			}
			ConnectionProvider.close(conn, pstmt, rs);
		}catch(Exception e) {System.out.println("예외발생 class-findByNo :"+e.getMessage());}
		return cv;
	}
	
//	public ArrayList<ClassVo> findByName(String class_name) {
//		ArrayList<ClassVo> list = new ArrayList<ClassVo>();
//		String sql = "select rownum, CLASS_NO, CLASS_NAME,CLASS_STARTDATE,CLASS_ENDDATE,CLASS_DAYOFWEEK,CLASS_TIME,CLASS_ROOM,CLASS_CREDIT,CLASS_TYPE,c.PRO_NO, pro_name from class c, professor p where c.pro_no = p.pro_no";
//		if(class_name != "" || class_name != null) {
//			sql += " and class_name like '%"+class_name+"%'";
//		}
//		try {
//			Connection conn = ConnectionProvider.getConn();
//			Statement stmt= conn.createStatement();
//			ResultSet rs = stmt.executeQuery(sql);
//			while(rs.next()) {
//				ClassVo cv = new ClassVo();
//				cv.setRownum(rs.getInt(1));
//				cv.setClass_no(rs.getInt(2));
//				cv.setClass_name(rs.getString(3));
//				cv.setClass_startdate(rs.getString(4));
//				cv.setClass_enddate(rs.getString(5));
//				cv.setClass_dayofweek(rs.getString(6));
//				cv.setClass_time(rs.getString(7));
//				cv.setClass_room(rs.getString(8));
//				cv.setClass_credit(rs.getInt(9));
//				cv.setClass_type(rs.getString(10));
//				cv.setPro_no(rs.getInt(11));
//				cv.setPro_name(rs.getString(12));
//				list.add(cv);
//			}
//			ConnectionProvider.close(conn, stmt, rs);
//		}catch(Exception e) {System.out.println("예외발생 class-findByName :"+e.getMessage());}
//		return list;
//	}
	
	public int deleteClass(int class_no) {
		int re =-1;
		String sql = "delete class where class_no=?";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, class_no);
			re =pstmt.executeUpdate();
			ConnectionProvider.close(conn, pstmt, null);
		}catch (Exception e) {
			System.out.println("예외발생 class-deleteClass:"+e.getMessage());
		}
		
		return re;
	}
	
	
	public int updateClass(ClassVo c) {
		int re =-1;
		String class_startdate = "to_date('"+c.getClass_startdate()+"','YYYY-MM-DD')";
		String class_enddate = "to_date('"+c.getClass_enddate()+"','YYYY-MM-DD')";
		String sql = "update class set CLASS_NO=?,CLASS_NAME=?,CLASS_STARTDATE="+class_startdate+",CLASS_ENDDATE="+class_enddate+",CLASS_DAYOFWEEK=?,CLASS_TIME=?,"
				+ "CLASS_ROOM=?,CLASS_CREDIT=?,CLASS_TYPE=?,PRO_NO=? where class_no=?";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, c.getClass_no());
			pstmt.setString(2,c.getClass_name());
//			pstmt.setDate(3,c.getClass_startdate());
//			pstmt.setDate(4,c.getClass_enddate());
			pstmt.setString(3, c.getClass_dayofweek());
			pstmt.setString(4, c.getClass_time());
			pstmt.setString(5, c.getClass_room());
			pstmt.setInt(6, c.getClass_credit());
			pstmt.setString(7, c.getClass_type());
			pstmt.setInt(8, c.getPro_no());
			pstmt.setInt(9, c.getClass_no());
			re =pstmt.executeUpdate();
			ConnectionProvider.close(conn, pstmt, null);
		}catch (Exception e) {
			System.out.println("예외발생 class-updateClass:"+e.getMessage());
		}
		
		return re;
	}
	
	public int insertClass(ClassVo c) {
		int re =-1;
		String class_startdate = "to_date('"+c.getClass_startdate()+"','YYYY-MM-DD')";
		String class_enddate = "to_date('"+c.getClass_enddate()+"','YYYY-MM-DD')";
		String sql = "insert into class (CLASS_NO,CLASS_NAME,CLASS_STARTDATE,CLASS_ENDDATE,CLASS_DAYOFWEEK,CLASS_TIME,CLASS_ROOM,CLASS_CREDIT,CLASS_TYPE,PRO_NO) "
				+ "values (?,?,"+class_startdate+","+class_enddate+",?,?,?,?,?,?)";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, c.getClass_no());
			pstmt.setString(2,c.getClass_name());
//			pstmt.setDate(3,c.getClass_startdate());
//			pstmt.setDate(4,c.getClass_enddate());
			pstmt.setString(3, c.getClass_dayofweek());
			pstmt.setString(4, c.getClass_time());
			pstmt.setString(5, c.getClass_room());
			pstmt.setInt(6, c.getClass_credit());
			pstmt.setString(7, c.getClass_type());
			pstmt.setInt(8, c.getPro_no());
			re =pstmt.executeUpdate();
			ConnectionProvider.close(conn, pstmt, null);
		}catch (Exception e) {
			System.out.println("예외발생 class-insertClass:"+e.getMessage());
		}
		return re;
	}
	
	public ArrayList<ClassVo> listClass(int start, int end, String search){
		ArrayList<ClassVo> list = new ArrayList<ClassVo>();
		
		try {
			String sql = "select r, CLASS_NO, CLASS_NAME,CLASS_STARTDATE,CLASS_ENDDATE,CLASS_DAYOFWEEK,CLASS_TIME,CLASS_ROOM,CLASS_CREDIT,CLASS_TYPE, PRO_NO, pro_name from\r\n"
					+ "			(select rownum r, CLASS_NO, CLASS_NAME,CLASS_STARTDATE,CLASS_ENDDATE,CLASS_DAYOFWEEK,CLASS_TIME,CLASS_ROOM,CLASS_CREDIT,CLASS_TYPE, PRO_NO, pro_name from\r\n"
					+ "			(select CLASS_NO, CLASS_NAME,CLASS_STARTDATE,CLASS_ENDDATE,CLASS_DAYOFWEEK,CLASS_TIME,CLASS_ROOM,CLASS_CREDIT,CLASS_TYPE, p.PRO_NO, pro_name from\r\n"
					+ "			(select * from class";
					if(search != null) {
						sql +=" where class_name like '%"+search+"%'";
					}
			sql += ")a, professor p where a.pro_no = p.pro_no order by class_no)) where r between "+start+" and "+end;
			
			
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				ClassVo cv = new ClassVo();
				cv.setRownum(rs.getInt(1));
				cv.setClass_no(rs.getInt(2));
				cv.setClass_name(rs.getString(3));
				cv.setClass_startdate(rs.getString(4));
				cv.setClass_enddate(rs.getString(5));
				cv.setClass_dayofweek(rs.getString(6));
				cv.setClass_time(rs.getString(7));
				cv.setClass_room(rs.getString(8));
				cv.setClass_credit(rs.getInt(9));
				cv.setClass_type(rs.getString(10));
				cv.setPro_no(rs.getInt(11));
				cv.setPro_name(rs.getString(12));
				list.add(cv);
			}
			conn.close();
		}catch(Exception e){System.out.println("예외발생 class-listClass  :"+e.getMessage());}
		return list;
	}
	
}
