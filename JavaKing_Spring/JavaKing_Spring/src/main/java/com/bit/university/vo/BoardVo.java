package com.bit.university.vo;

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoardVo {

	private int rn;
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
	private MultipartFile upload_file;


	public BoardVo(int board_no, int board_boardno, String board_category, String board_title, String board_content,
			Date board_regdate, int board_hit, String board_pwd, String board_fname, int std_no, MultipartFile upload_file) {
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
		this.upload_file = upload_file;
	}




}
