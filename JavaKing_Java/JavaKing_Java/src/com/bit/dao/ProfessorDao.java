package com.bit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


import com.bit.db.ConnectionProvider;
import com.bit.vo.ProfessorVo;


public class ProfessorDao {
    public ArrayList<ProfessorVo> listPro() {
        ArrayList<ProfessorVo> list = new ArrayList<ProfessorVo>();
        try {
            String sql = "select * from professor order by pro_type, pro_major";
            Connection conn = ConnectionProvider.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()) {
                list.add(new ProfessorVo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
            }
            ConnectionProvider.close(conn, stmt, rs);
        } catch (Exception e) {
            System.out.println("listPro예외:" + e.getMessage());
        }
        return list;
    }

    public int insertPro(ProfessorVo p) {
		int re = -1;
		String sql = "insert into professor values(?,?,?,?,?)";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, p.getPro_no());
			pstmt.setString(2, p.getPro_name());
			pstmt.setString(3, p.getPro_email());
			pstmt.setString(4, p.getPro_major());
			pstmt.setString(5, p.getPro_type());
			
			re = pstmt.executeUpdate();
			
			ConnectionProvider.close(conn, pstmt, null);
			
		}catch (Exception e) {
			System.out.println("insertPro예외:"+e.getMessage());
		}
		
		return re;
	}



}

