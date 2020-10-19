package com.bit.university.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bit.university.db.MainManager;
import com.bit.university.vo.BoardVo;

@Repository
public class MainDao {
	
	public List<BoardVo> getBoardList(String board_category, int board_boardno) {
		return MainManager.getBoardList(board_category,board_boardno);
	}
	
}
