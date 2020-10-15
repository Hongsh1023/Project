package com.bit.university.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bit.university.db.ReplyManager;
import com.bit.university.vo.ReplyVo;

@Repository
public class ReplyDao {
	
	public List<ReplyVo> listReply(int board_no){
		return ReplyManager.listReply(board_no);
	}
	
	public int getTotalReply(int board_no) {
		return ReplyManager.getTotalReply(board_no);
	}
	
	public int insertReply(ReplyVo r_vo) {
		return ReplyManager.insertReply(r_vo);
	}
	
	public int deleteReply(int reply_no) {
		return ReplyManager.deleteReply(reply_no);
	}
	
	public int getNextReplyNo() {
		return ReplyManager.getNextReplyNo();
	}
	
	public int updateReply(String reply_content, int reply_no) {
		return ReplyManager.updateReply(reply_content, reply_no);
	}
}
