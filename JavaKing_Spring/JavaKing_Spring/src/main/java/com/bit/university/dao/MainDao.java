package com.bit.university.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bit.university.db.MainManager;
import com.bit.university.vo.BoardVo;

@Repository
public class MainDao {

	public List<BoardVo> getBoardList(String board_category, int board_boardno) {
		return MainManager.getBoardList(board_category, board_boardno);
	}

	public int loginCheck(int std_no, String std_pwd) {
		return MainManager.loginCheck(std_no, std_pwd);
	}

	public int updatePwd(String old_pwd, String new_pwd, int std_no) {
		return MainManager.updatePwd(old_pwd, new_pwd, std_no);
	}

	public int getStudentId(String std_name, String std_email) {
		return MainManager.getStudentId(std_name, std_email);
	}
	
	public String getStudentPwd(int std_no, String std_email) {
		return MainManager.getStudentPwd(std_no, std_email);
	}
}
