package com.bit.university.vo;

import java.sql.Date;

public class BoardVo {
	
	private int rownum;
	private int board_no;
	private int board_boardno;
	private String board_category;
	private String board_title;
	private String board_content;
	private Date board_regdate;
	private int board_hit;
	private String board_pwd;
	private String board_fname;
	private int std_no;
	

	public int getRownum() {
		return rownum;
	}
	public void setRownum(int rownum) {
		this.rownum = rownum;
	}
	public int getBoard_no() {
		return board_no;
	}
	public void setBoard_no(int board_no) {
		this.board_no = board_no;
	}
	public int getBoard_boardno() {
		return board_boardno;
	}
	public void setBoard_boardno(int board_boardno) {
		this.board_boardno = board_boardno;
	}
	public String getBoard_category() {
		return board_category;
	}
	public void setBoard_category(String board_category) {
		this.board_category = board_category;
	}
	public String getBoard_title() {
		return board_title;
	}
	public void setBoard_title(String board_title) {
		this.board_title = board_title;
	}
	public String getBoard_content() {
		return board_content;
	}
	public void setBoard_content(String board_content) {
		this.board_content = board_content;
	}
	public Date getBoard_regdate() {
		return board_regdate;
	}
	public void setBoard_regdate(Date board_regdate) {
		this.board_regdate = board_regdate;
	}
	public int getBoard_hit() {
		return board_hit;
	}
	public void setBoard_hit(int board_hit) {
		this.board_hit = board_hit;
	}
	public String getBoard_pwd() {
		return board_pwd;
	}
	public void setBoard_pwd(String board_pwd) {
		this.board_pwd = board_pwd;
	}
	public String getBoard_fname() {
		return board_fname;
	}
	public void setBoard_fname(String board_fname) {
		this.board_fname = board_fname;
	}
	public int getStd_no() {
		return std_no;
	}
	public void setStd_no(int std_no) {
		this.std_no = std_no;
	}
	public BoardVo(int rownum, int board_no, int board_boardno, String board_category, String board_title,
			String board_content, Date board_regdate, int board_hit, String board_pwd, String board_fname, int std_no) {
		super();
		this.rownum = rownum;
		this.board_no = board_no;
		this.board_boardno = board_boardno;
		this.board_category = board_category;
		this.board_title = board_title;
		this.board_content = board_content;
		this.board_regdate = board_regdate;
		this.board_hit = board_hit;
		this.board_pwd = board_pwd;
		this.board_fname = board_fname;
		this.std_no = std_no;
	}
	
	public BoardVo(int board_no, int board_boardno, String board_category, String board_title, String board_content,
			Date board_regdate, int board_hit, String board_pwd, String board_fname, int std_no) {
		super();
		this.board_no = board_no;
		this.board_boardno = board_boardno;
		this.board_category = board_category;
		this.board_title = board_title;
		this.board_content = board_content;
		this.board_regdate = board_regdate;
		this.board_hit = board_hit;
		this.board_pwd = board_pwd;
		this.board_fname = board_fname;
		this.std_no = std_no;
	}
	public BoardVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BoardVo(int board_no, String board_title) {
		super();
		this.board_no = board_no;
		this.board_title = board_title;
	}



}
