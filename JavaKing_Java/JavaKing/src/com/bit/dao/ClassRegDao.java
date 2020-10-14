package com.bit.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.bit.db.ConnectionProvider;
import com.bit.vo.ClassregVo;
import com.bit.vo.StudentVo;

public class ClassRegDao {

	private static ClassRegDao dao;
	
	public static ClassRegDao getInstance() {
		if(dao == null) {
			dao = new ClassRegDao();
		}return dao;
	}
	
	public int getNextClassregNo() {
		int n = 0;
		String sql = "select nvl(max(classreg_no),0)+1 from classreg";
		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs =stmt.executeQuery(sql);
			if(rs.next()) {
				n = rs.getInt(1);
			}
			ConnectionProvider.close(conn, stmt, rs);
					
		}catch (Exception e) {
			System.out.println("예외발생 classreg-getNextClassNo:"+e.getMessage());
		}
		
		return n;
	}
	
	//0이 아니라면 재수강, 재수강을 2번 들을 수 없음
	public String checkRetake (int std_no, int class_no) {
		String re = "Y"; //재수강 
		int n =-1;
		String sql = "select count(*) from classreg where std_no =? and class_no=?";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, std_no);
			pstmt.setInt(2, class_no);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				n=rs.getInt(1);
				if(n == 0) {
					re= "N";
				}else if (n > 1) {
					re ="I"; //Impossible
				}
			}
		}catch(Exception e) {System.out.println("예외발생 classreg-checkRetake: "+e.getMessage());	}
		System.out.println(re);
		return re;
	}
	
	//수강신청 시 중복강의 신청불가
	public int checkDouble (int std_no, int class_no) {
		int n =-1;
		String sql = "select count(*) from classreg where std_no =? and class_no=? and to_char(classreg_date, 'YYYYMMDD') = to_char(sysdate,'YYYYMMDD')";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, std_no);
			pstmt.setInt(2, class_no);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				n=rs.getInt(1);
			}
		}catch(Exception e) {System.out.println("예외발생 classreg-checkDouble: "+e.getMessage());	}
		return n;
	}
	
	public int insertClassreg(HttpServletRequest request, int class_no, int std_no)  throws ServletException, IOException {
		int re =-1;
		StudentDao sdao = StudentDao.getInstance();
		StudentVo s = sdao.findByNo(std_no);
		String check = "휴학";
		check = sdao.statusCheck(std_no);
		if(!check.equals("재학") && !check.contentEquals("복학")) {
			return re; //재학자, 복학자만 신청가능
		}
		
		int classreg_no = dao.getNextClassregNo();
		int classreg_level = s.getStd_level();
		int classreg_semester = s.getStd_semester();
		String classreg_retake = dao.checkRetake(std_no, class_no);
		System.out.println("insert 중 :"+classreg_retake);
		if(classreg_retake.equals("I")) {
			return re; //재수강을 2번이상 신청못함
		}
		int checkDouble = dao.checkDouble(std_no, class_no);
		if(checkDouble != 0) {
			return re;
		}
		
		String sql ="insert into classreg values (?,sysdate,?,?,?,?,?)";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, classreg_no);
			pstmt.setInt(2, classreg_level);
			pstmt.setInt(3, classreg_semester);
			pstmt.setString(4, classreg_retake);
			pstmt.setInt(5, std_no);
			pstmt.setInt(6, class_no);
			re = pstmt.executeUpdate();
			ConnectionProvider.close(conn, pstmt, null);
		}catch(Exception e) {System.out.println("예외발생 classreg-insertClassreg : "+e.getMessage());}
		return re;
	}
	
	//수강신청시 하단에 작성되는 리스트
	public ArrayList<ClassregVo> listAll (int std_no){
		ArrayList<ClassregVo> list = new ArrayList<ClassregVo>();
		String sql = "select rownum, a.classreg_no, a.class_no, class_name, std_level, std_semester, class_type, class_credit, c.pro_no, pro_name, class_dayofweek,class_time, classreg_retake from "
					+ "(select * from classreg where to_char(classreg_date,'YYYYMMDD') = to_char(sysdate,'YYYYMMDD') and std_no = "+std_no+" order by classreg_no desc) a, "
					+ "student s, professor p, class c where a.std_no = s.std_no and a.class_no=c.class_no and c.pro_no=p.pro_no";
		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				ClassregVo c = new ClassregVo();
				c.setRownum(rs.getInt(1));
				c.setClassreg_no(rs.getInt(2));
				c.setClass_no(rs.getInt(3));
				c.setClass_name(rs.getString(4));
				c.setStd_level(rs.getInt(5));
				c.setStd_semester(rs.getInt(6));
				c.setClass_type(rs.getString(7));
				c.setClass_credit(rs.getInt(8));
				c.setPro_no(rs.getInt(9));
				c.setPro_name(rs.getString(10));
				c.setClass_dayofweek(rs.getString(11));
				c.setClass_time(rs.getString(12));
				c.setClassreg_retake(rs.getString(13));
				System.out.println("crList 체크: "+dao.checkRetake(std_no, rs.getInt(2)));
				list.add(c);
			}
		}catch(Exception e) {System.out.println("예외발생 classreg-listAll : "+e.getMessage());}
		return list;
	}
	
	public int countCredit(int std_no) {
		int re =-1;
		String sql = "select sum(class_credit) from classreg c, class c1 where c.std_no="+std_no+" and c.class_no = c1.class_no and to_char(classreg_date, 'YYYYMMDD')>=to_char(sysdate,'YYYYMMDD')";
		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()) {
				re=rs.getInt(1);
			}ConnectionProvider.close(conn, stmt, rs);
		}catch(Exception e) {System.out.println("예외발생 classreg-countCredit: "+e.getMessage());}
		return re;
	}
	
	public int countSubject(int std_no) {
		int re =-1;
		String sql = "select count(*) from classreg where std_no="+std_no+" and to_char(classreg_date,'YYYYMMDD') = to_char(sysdate,'YYYYMMDD')";
		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()) {
				re=rs.getInt(1);
			}ConnectionProvider.close(conn, stmt, rs);
		}catch(Exception e) {System.out.println("예외발생 classreg-countSubject: "+e.getMessage());}
		return re;
	}
	
	public int deleteClassreg(int classreg_no) {
		int re=-1;
		String sql = "delete classreg where classreg_no = "+classreg_no;
		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			re = stmt.executeUpdate(sql);
			ConnectionProvider.close(conn, stmt, null);
		}catch(Exception e) {System.out.println("예외발생 classreg-deleteClassreg: "+e.getMessage());}
		return re;
	}
	
	public int totalCountReg(int std_no) {
		int n =0;
		String sql= "select count(*) from classreg where std_no ="+std_no+" and to_char(classreg_date,'YYYYMMDD') = to_char(sysdate,'YYYYMMDD')";
		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()) {
				n=rs.getInt(1);
			}
			ConnectionProvider.close(conn, stmt, rs);
		}catch(Exception e) {System.out.println("예외발생 classreg-deleteClassreg: "+e.getMessage());}
		return n;
	}
	
	public ClassregVo findByNo(int classreg_no) {
		ClassregVo cv = null;
		String sql = "select * from classreg where classreg_no="+classreg_no;
		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()) {
				cv = new ClassregVo();
				cv.setClassreg_no(rs.getInt(1));
				cv.setClassreg_date(rs.getDate(2));
				cv.setClassreg_level(rs.getInt(3));
				cv.setClassreg_semester(rs.getInt(4));
				cv.setClassreg_retake(rs.getString(5));
				cv.setStd_no(rs.getInt(6));
				cv.setClass_no(rs.getInt(7));
			}
			ConnectionProvider.close(conn, stmt, rs);
		}catch(Exception e) {System.out.println("예외발생 classreg-findByNo: "+e.getMessage());}
		return cv;
	}
	
	public ArrayList<ClassregVo> getAtStudentInfo (int std_no, int year, int semester) {
		ArrayList<ClassregVo> list = new ArrayList<ClassregVo>();
		String sql = "select to_char( classreg_date, 'YYYY'), classreg_semester, class_type, cr.class_no, class_name, c.pro_no, pro_name, class_credit, class_dayofweek, class_time"
				+ " from classreg cr, class c, professor p where cr.class_no=c.class_no and c.pro_no=p.pro_no and std_no='"+std_no+"' and to_char(classreg_date,'YYYY') = '"+year+"' and classreg_semester="+semester;
		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				ClassregVo cv = new ClassregVo();
				cv.setClass_year(rs.getString(1));
				cv.setClassreg_semester(rs.getInt(2));
				cv.setClass_type(rs.getString(3));
				cv.setClass_no(rs.getInt(4));
				cv.setClass_name(rs.getString(5));
				cv.setPro_no(rs.getInt(6));
				cv.setPro_name(rs.getString(7));
				cv.setClass_credit(rs.getInt(8));
				cv.setClass_dayofweek(rs.getString(9));
				cv.setClass_time(rs.getString(10));
				list.add(cv);
				
			}
		}catch(Exception e) {System.out.println("예외발생 classreg-getAtStudentInfo: "+e.getMessage());}
		return list;
	}
}
