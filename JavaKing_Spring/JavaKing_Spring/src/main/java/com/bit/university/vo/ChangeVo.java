package com.bit.university.vo;

import java.sql.Date;

import lombok.Data;

@Data
public class ChangeVo {
	private int change_no;
	private int change_year;
	private int change_semester;
	private int change_level;
	private String change_sub;
	private Date change_date;
	private int std_no;
}
