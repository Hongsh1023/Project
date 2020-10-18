package com.bit.university.vo;

import java.sql.Date;

import lombok.Data;

@Data
public class ReplyVo {
	private int reply_no;
	private String reply_content;
	private Date reply_regdate;
	private int std_no;
	private int board_no;
}
