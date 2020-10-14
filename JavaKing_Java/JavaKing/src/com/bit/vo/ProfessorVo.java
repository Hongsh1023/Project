package com.bit.vo;

public class ProfessorVo {
	
	private int pro_no;
	private String pro_name;
	private String pro_email;
	private String pro_major;
	private String pro_type;
	
	public int getPro_no() {
		return pro_no;
	}
	public void setPro_no(int pro_no) {
		this.pro_no = pro_no;
	}
	public String getPro_name() {
		return pro_name;
	}
	public void setPro_name(String pro_name) {
		this.pro_name = pro_name;
	}
	public String getPro_email() {
		return pro_email;
	}
	public void setPro_email(String pro_email) {
		this.pro_email = pro_email;
	}
	public String getPro_major() {
		return pro_major;
	}
	public void setPro_major(String pro_major) {
		this.pro_major = pro_major;
	}
	public String getPro_type() {
		return pro_type;
	}
	public void setPro_type(String pro_type) {
		this.pro_type = pro_type;
	}
	
	public ProfessorVo(int pro_no, String pro_name, String pro_email, String pro_major, String pro_type) {
		super();
		this.pro_no = pro_no;
		this.pro_name = pro_name;
		this.pro_email = pro_email;
		this.pro_major = pro_major;
		this.pro_type = pro_type;
	}
	
	public ProfessorVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
