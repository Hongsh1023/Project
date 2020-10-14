package com.bit.vo;

import java.sql.Date;


public class ReplyVo {

	private int reply_no;
	private String reply_content;
	private Date reply_regdate;
	private int std_no;
	private int board_no;
	public int getReply_no() {
		return reply_no;
	}
	public void setReply_no(int reply_no) {
		this.reply_no = reply_no;
	}
	public String getReply_content() {
		return reply_content;
	}
	public void setReply_content(String reply_content) {
		this.reply_content = reply_content;
	}
	public Date getReply_regdate() {
		return reply_regdate;
	}
	public void setReply_regdate(Date reply_regdate) {
		this.reply_regdate = reply_regdate;
	}
	public int getStd_no() {
		return std_no;
	}
	public void setStd_no(int std_no) {
		this.std_no = std_no;
	}
	public int getBoard_no() {
		return board_no;
	}
	public void setBoard_no(int board_no) {
		this.board_no = board_no;
	}
	public ReplyVo(int reply_no, String reply_content, Date reply_regdate, int std_no, int board_no) {
		super();
		this.reply_no = reply_no;
		this.reply_content = reply_content;
		this.reply_regdate = reply_regdate;
		this.std_no = std_no;
		this.board_no = board_no;
	}
	public ReplyVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
