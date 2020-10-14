package com.bit.vo;

import java.sql.Date;

public class RegisterVo {

	private int reg_no;
	private Date reg_date;
	private int reg_semester;
	private int reg_level;
	private int reg_entfee;
	private int reg_fee;
	private int reg_regfee;
	private int std_no;
	private int reg_year;
	
	
	public int getReg_year() {
		return reg_year;
	}
	public void setReg_year(int reg_year) {
		this.reg_year = reg_year;
	}
	public int getReg_no() {
		return reg_no;
	}
	public void setReg_no(int reg_no) {
		this.reg_no = reg_no;
	}
	public Date getReg_date() {
		return reg_date;
	}
	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}
	public int getReg_semester() {
		return reg_semester;
	}
	public void setReg_semester(int reg_semester) {
		this.reg_semester = reg_semester;
	}
	public int getReg_level() {
		return reg_level;
	}
	public void setReg_level(int reg_level) {
		this.reg_level = reg_level;
	}
	public int getReg_entfee() {
		return reg_entfee;
	}
	public void setReg_entfee(int reg_entfee) {
		this.reg_entfee = reg_entfee;
	}
	public int getReg_fee() {
		return reg_fee;
	}
	public void setReg_fee(int reg_fee) {
		this.reg_fee = reg_fee;
	}
	public int getReg_regfee() {
		return reg_regfee;
	}
	public void setReg_regfee(int reg_regfee) {
		this.reg_regfee = reg_regfee;
	}
	public int getStd_no() {
		return std_no;
	}
	public void setStd_no(int std_no) {
		this.std_no = std_no;
	}
	public RegisterVo(int reg_no, Date reg_date, int reg_semester, int reg_level, int reg_entfee, int reg_fee,
			int reg_regfee, int std_no, int reg_year) {
		super();
		this.reg_no = reg_no;
		this.reg_date = reg_date;
		this.reg_semester = reg_semester;
		this.reg_level = reg_level;
		this.reg_entfee = reg_entfee;
		this.reg_fee = reg_fee;
		this.reg_regfee = reg_regfee;
		this.std_no = std_no;
		this.reg_year = reg_year;
	}
	
	
	public RegisterVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
