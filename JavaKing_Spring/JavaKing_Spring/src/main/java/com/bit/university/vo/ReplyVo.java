package com.bit.university.vo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReplyVo {
	private int reply_no;
	private String reply_content;
	private Date reply_regdate;
	private int std_no;
	private int board_no;
}
