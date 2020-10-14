package com.bit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


import com.bit.db.ConnectionProvider;
import com.bit.vo.RegisterVo;



public class RegisterDao {
    public ArrayList<RegisterVo> listReg(int std_no) {
        ArrayList<RegisterVo> list = new ArrayList<RegisterVo>();
        try {
            String sql = "select reg_no, reg_date, reg_semester, reg_level, reg_entfee, reg_fee, reg_regfee, r.std_no, reg_year "+ 
            			"from register r, student s "+  
            			"where s.std_no=r.std_no and r.std_no=? " + 
            			"order by reg_no";
            Connection conn = ConnectionProvider.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, std_no);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()) {
                list.add(new RegisterVo(rs.getInt(1), rs.getDate(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getInt(9)));
            }
            ConnectionProvider.close(conn, pstmt, rs);
        } catch (Exception e) {
            System.out.println("listReg예외:" + e.getMessage());
        }
        return list;
    }

    public int insertReg(RegisterVo r) {
		int re = -1;
		String sql = "insert into register values(?,null,?,?,?,?,?,?,?)";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, r.getReg_no());
			pstmt.setInt(2, r.getReg_semester());
			pstmt.setInt(3, r.getReg_level());
			pstmt.setInt(4, r.getReg_entfee());
			pstmt.setInt(5, r.getReg_fee());
			pstmt.setInt(6, r.getReg_regfee());
			pstmt.setInt(7, r.getStd_no());
			pstmt.setInt(8, r.getReg_year());
			
			re = pstmt.executeUpdate();
			
			ConnectionProvider.close(conn, pstmt, null);
			
		}catch (Exception e) {
			System.out.println("insertReg예외:"+e.getMessage());
		}
		
		return re;
	}

    public int nextNo() {
    	int no = 0;
    	
    	try {
    		String sql = "select nvl(max(reg_no),0)+1 from register";
    		Connection conn = ConnectionProvider.getConnection();
    		Statement stmt = conn.createStatement();
    		ResultSet rs = stmt.executeQuery(sql);
    		if(rs.next()) {
    			no = rs.getInt(1);
    		}
    		ConnectionProvider.close(conn, stmt, rs);
    		
    	}catch (Exception e) {
			// TODO: handle exception
    		System.out.println("nextNo예외:"+e.getMessage());
		}
    	
    	return no;
    }

}
