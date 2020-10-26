package com.bit.university.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.bit.university.db.BoardManager;
import com.bit.university.vo.BoardVo;

@Repository
public class BoardDao {
	
	public int updateBoard(BoardVo b_vo) {
		return BoardManager.updateBoard(b_vo);
	}
	
	public int deleteBoard(int board_no) {
		return BoardManager.deleteBoard(board_no);
	}
	
	public void increaseHit(int board_no) {
		
	}
	
	public BoardVo getBoard(int board_no) {
		return BoardManager.getBoard(board_no);
	}
	
	public List<String> getBoardCategory(int board_boardno) {
		return BoardManager.getBoardCategory(board_boardno);
	}
	
	public List<BoardVo> listAll(HashMap map) {
		return BoardManager.listAll(map);
	}
	
	public int getBoardCount(int board_boardno, String board_category, String search, String keyword) {
		return BoardManager.getBoardCount(board_boardno, board_category, search, keyword);
	}
	
	public int getNextNo() {
		return BoardManager.getNextNo();
	}
	
	public int insertBoard(BoardVo b_vo) {
		System.out.println("dao.boardcategory::::::::" +b_vo.getBoard_category());
		return BoardManager.insertBoard(b_vo);
	}
}
