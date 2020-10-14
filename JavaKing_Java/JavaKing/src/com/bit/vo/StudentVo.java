package com.bit.vo;

import java.sql.Date;

public class StudentVo {
	
	private int std_no;
	private String std_pwd;
	private String std_email;
	private String std_name;
	private String std_gender;
	private Date std_birthday;
	private int std_level;
	private int std_semester;
	private String std_major;
	private String std_status;
	private Date std_startdate;
	private Date std_enddate;
	private String std_etc;
	private int pro_no;
	
	public int getStd_no() {
		return std_no;
	}
	public void setStd_no(int std_no) {
		this.std_no = std_no;
	}
	public String getStd_pwd() {
		return std_pwd;
	}
	public void setStd_pwd(String std_pwd) {
		this.std_pwd = std_pwd;
	}
	public String getStd_email() {
		return std_email;
	}
	public void setStd_email(String std_email) {
		this.std_email = std_email;
	}
	public String getStd_name() {
		return std_name;
	}
	public void setStd_name(String std_name) {
		this.std_name = std_name;
	}
	public String getStd_gender() {
		return std_gender;
	}
	public void setStd_gender(String std_gender) {
		this.std_gender = std_gender;
	}
	public Date getStd_birthday() {
		return std_birthday;
	}
	public void setStd_birthday(Date std_birthday) {
		this.std_birthday = std_birthday;
	}
	public int getStd_level() {
		return std_level;
	}
	public void setStd_level(int std_level) {
		this.std_level = std_level;
	}
	public int getStd_semester() {
		return std_semester;
	}
	public void setStd_semester(int std_semester) {
		this.std_semester = std_semester;
	}
	public String getStd_major() {
		return std_major;
	}
	public void setStd_major(String std_major) {
		this.std_major = std_major;
	}
	public String getStd_status() {
		return std_status;
	}
	public void setStd_status(String std_status) {
		this.std_status = std_status;
	}
	public Date getStd_startdate() {
		return std_startdate;
	}
	public void setStd_startdate(Date std_startdate) {
		this.std_startdate = std_startdate;
	}
	public Date getStd_enddate() {
		return std_enddate;
	}
	public void setStd_enddate(Date std_enddate) {
		this.std_enddate = std_enddate;
	}
	public String getStd_etc() {
		return std_etc;
	}
	public void setStd_etc(String std_etc) {
		this.std_etc = std_etc;
	}
	public int getPro_no() {
		return pro_no;
	}
	public void setPro_no(int pro_no) {
		this.pro_no = pro_no;
	}
	
	public StudentVo(int std_no, String std_pwd, String std_email, String std_name, String std_gender,
			Date std_birthday, int std_level, int std_semester, String std_major, String std_status, Date std_startdate,
			Date std_enddate, String std_etc, int pro_no) {
		super();
		this.std_no = std_no;
		this.std_pwd = std_pwd;
		this.std_email = std_email;
		this.std_name = std_name;
		this.std_gender = std_gender;
		this.std_birthday = std_birthday;
		this.std_level = std_level;
		this.std_semester = std_semester;
		this.std_major = std_major;
		this.std_status = std_status;
		this.std_startdate = std_startdate;
		this.std_enddate = std_enddate;
		this.std_etc = std_etc;
		this.pro_no = pro_no;
	}
	
	public StudentVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
