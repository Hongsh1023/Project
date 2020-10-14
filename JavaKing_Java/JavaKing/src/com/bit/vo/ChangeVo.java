package com.bit.vo;

import java.sql.Date;

public class ChangeVo {
	private int change_no;
	private int change_year;
	private int change_semester;
	private int change_level;
	private String change_sub;
	private Date change_date;
	private int std_no;

	public ChangeVo() {
		super();
	}

	public ChangeVo(int change_no, int change_year, int change_semester, int change_level, String change_sub,
			Date change_date, int std_no) {
		super();
		this.change_no = change_no;
		this.change_year = change_year;
		this.change_semester = change_semester;
		this.change_level = change_level;
		this.change_sub = change_sub;
		this.change_date = change_date;
		this.std_no = std_no;
	}

	public ChangeVo(int change_no, int change_year, int change_semester, int change_level, String change_sub,
			Date change_date) {
		super();
		this.change_no = change_no;
		this.change_year = change_year;
		this.change_semester = change_semester;
		this.change_level = change_level;
		this.change_sub = change_sub;
		this.change_date = change_date;
	}

	public ChangeVo(int change_year, int change_semester, int change_level, String change_sub, Date change_date) {
		super();
		this.change_year = change_year;
		this.change_semester = change_semester;
		this.change_level = change_level;
		this.change_sub = change_sub;
		this.change_date = change_date;
	}

	public int getChange_no() {
		return change_no;
	}

	public void setChange_no(int change_no) {
		this.change_no = change_no;
	}

	public int getChange_year() {
		return change_year;
	}

	public void setChange_year(int change_year) {
		this.change_year = change_year;
	}

	public int getChange_semester() {
		return change_semester;
	}

	public void setChange_semester(int change_semester) {
		this.change_semester = change_semester;
	}

	public int getChange_level() {
		return change_level;
	}

	public void setChange_level(int change_level) {
		this.change_level = change_level;
	}

	public String getChange_sub() {
		return change_sub;
	}

	public void setChange_sub(String change_sub) {
		this.change_sub = change_sub;
	}

	public Date getChange_date() {
		return change_date;
	}

	public void setChange_date(Date change_date) {
		this.change_date = change_date;
	}

	public int getStd_no() {
		return std_no;
	}

	public void setStd_no(int std_no) {
		this.std_no = std_no;
	}

}
