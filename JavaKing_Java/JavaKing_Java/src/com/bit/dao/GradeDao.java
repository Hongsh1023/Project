package com.bit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.bit.db.ConnectionProvider;
import com.bit.vo.GradeVo;

public class GradeDao {
	public ArrayList<GradeVo> listAll(int std_no){
		ArrayList<GradeVo> list = new ArrayList<GradeVo>();
		int levelMax = 0;
		int semesterMax = 0;
		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			String sql1 = "select Max(grade_level), Max(grade_semester) from grade \r\n" + 
					"where grade_level=(select Max(grade_level) from grade where std_no="+std_no+")";
			ResultSet rs = stmt.executeQuery(sql1);
			if(rs.next()) {
				levelMax = rs.getInt(1);
				semesterMax = rs.getInt(2);
			}
			ConnectionProvider.close(conn, stmt, rs);
			for(int j=1; j<=levelMax; j++ ) {
				for(int i=1; i<=2; i++) {
					if(levelMax==j && semesterMax==i-1) {
						break;
					}
					String sql = "select grade_semester, grade_level, grade_year, sum(grade_regcredit), avg(grade_getcredit), avg(grade_score) "
							+ "from (select grade_no, grade_regcredit, grade_getcredit, grade_score,grade_semester, grade_level, std_no, g.class_no,"
							+ "to_char(class_startdate,'yyyy') grade_year from class c, grade g where g.class_no=c.class_no and std_no="+std_no
							+ " and grade_level="+j+" and grade_semester="+i+") group by grade_year,grade_semester,grade_level";
					conn = ConnectionProvider.getConnection();
					stmt = conn.createStatement();
					rs = stmt.executeQuery(sql);
					while(rs.next()) {
						list.add(new GradeVo(0, 0, 0, 0, rs.getInt(1), rs.getInt(2), 0, 0, rs.getString(3), rs.getInt(4),rs.getDouble(5),rs.getDouble(6),null,null,null));
					}
					ConnectionProvider.close(conn, stmt, rs);
				}
			}
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("예외발생 :"+e.getMessage());
		}
		return list;
	}
	
	public ArrayList<GradeVo> detailAll(String year, int semester, int std_no){
		ArrayList<GradeVo> list = new ArrayList<GradeVo>();
		String sql = "select grade_no, grade_regcredit, grade_getcredit, grade_score,grade_semester, "
				+ "grade_level, std_no, g.class_no,to_char(class_startdate,'yyyy') grade_year, class_name, class_type, "
				+ "CASE when grade_score>=95 then 'A+' when grade_score>=90 then 'A' when grade_score>=85 then 'B+' "
				+ "when grade_score>=80 then 'B' when grade_score>=75 then 'C+' when grade_score>=70 then 'C' "
				+ "when grade_score>=65 then 'D+' when grade_score>=60 then 'D' else 'F' End As rank from class c, grade g "
				+ "where g.class_no=c.class_no and std_no="+std_no+" and to_char(class_startdate,'yyyy')="+year+
				"and grade_semester="+semester+" order by class_name";
		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				list.add(new GradeVo(rs.getInt(1), rs.getInt(2), rs.getDouble(3), rs.getInt(4), rs.getInt(5), rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getString(9),0,0,0,rs.getString(10),rs.getString(11),rs.getString(12)));
			}
			ConnectionProvider.close(conn, stmt, rs);
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("예외발생 :"+e.getMessage());
		}
		return list;
	}
	
	public int insertGrade(GradeVo vo) {
		int re=-1;
		String sql = "insert into grade values(?,?,?,?,?,?,?,?)";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getGrade_no());
			pstmt.setInt(2, vo.getGrade_regcredit());
			pstmt.setDouble(3, vo.getGrade_getcredit());
			pstmt.setInt(4, vo.getGrade_score());
			pstmt.setInt(5, vo.getGrade_semester());
			pstmt.setInt(6, vo.getGrade_level());
			pstmt.setInt(7, vo.getStd_no());
			pstmt.setInt(8, vo.getClass_no());
			
			re = pstmt.executeUpdate();
			ConnectionProvider.close(conn, pstmt, null);
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("예외발생 :"+e.getMessage());
		}
		return re;
	}

}
