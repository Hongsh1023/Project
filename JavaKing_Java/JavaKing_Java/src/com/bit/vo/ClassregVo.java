package com.bit.vo;

import java.sql.Date;

public class ClassregVo {
	
	private int classreg_no;
	private Date classreg_date;
	private int classreg_level;
	private int classreg_semester;
	private String classreg_retake;
	private int std_no;
	private int class_no;
	
	private int rownum;
	private String class_name;
	private int std_level;
	private int std_semester;
	private String class_type;
	private int class_credit;
	private int pro_no;
	private String pro_name;
	private String class_dayofweek;
	private String class_time;
	
	private String class_year;
	
	
	public ClassregVo(int classreg_no, Date classreg_date, int classreg_level, int classreg_semester,
			String classreg_retake, int std_no, int class_no, int rownum, String class_name, int std_level,
			int std_semester, String class_type, int class_credit, int pro_no, String pro_name, String class_dayofweek,
			String class_time, String class_year) {
		super();
		this.classreg_no = classreg_no;
		this.classreg_date = classreg_date;
		this.classreg_level = classreg_level;
		this.classreg_semester = classreg_semester;
		this.classreg_retake = classreg_retake;
		this.std_no = std_no;
		this.class_no = class_no;
		this.rownum = rownum;
		this.class_name = class_name;
		this.std_level = std_level;
		this.std_semester = std_semester;
		this.class_type = class_type;
		this.class_credit = class_credit;
		this.pro_no = pro_no;
		this.pro_name = pro_name;
		this.class_dayofweek = class_dayofweek;
		this.class_time = class_time;
		this.class_year = class_year;
	}
	public String getClass_year() {
		return class_year;
	}
	public void setClass_year(String class_year) {
		this.class_year = class_year;
	}
	public ClassregVo(int classreg_no, Date classreg_date, int classreg_level, int classreg_semester,
			String classreg_retake, int std_no, int class_no, int rownum, String class_name, int std_level,
			int std_semester, String class_type, int class_credit, int pro_no, String pro_name, String class_dayofweek,
			String class_time) {
		super();
		this.classreg_no = classreg_no;
		this.classreg_date = classreg_date;
		this.classreg_level = classreg_level;
		this.classreg_semester = classreg_semester;
		this.classreg_retake = classreg_retake;
		this.std_no = std_no;
		this.class_no = class_no;
		this.rownum = rownum;
		this.class_name = class_name;
		this.std_level = std_level;
		this.std_semester = std_semester;
		this.class_type = class_type;
		this.class_credit = class_credit;
		this.pro_no = pro_no;
		this.pro_name = pro_name;
		this.class_dayofweek = class_dayofweek;
		this.class_time = class_time;
	}
	public int getStd_semester() {
		return std_semester;
	}
	public void setStd_semester(int std_semester) {
		this.std_semester = std_semester;
	}
	public String getClass_name() {
		return class_name;
	}
	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}
	public int getStd_level() {
		return std_level;
	}
	public void setStd_level(int std_level) {
		this.std_level = std_level;
	}
	public int getRownum() {
		return rownum;
	}
	public void setRownum(int rownum) {
		this.rownum = rownum;
	}
	public String getClass_type() {
		return class_type;
	}
	public void setClass_type(String class_type) {
		this.class_type = class_type;
	}
	public int getClass_credit() {
		return class_credit;
	}
	public void setClass_credit(int class_credit) {
		this.class_credit = class_credit;
	}
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
	public String getClass_dayofweek() {
		return class_dayofweek;
	}
	public void setClass_dayofweek(String class_dayofweek) {
		this.class_dayofweek = class_dayofweek;
	}
	public String getClass_time() {
		return class_time;
	}
	public void setClass_time(String class_time) {
		this.class_time = class_time;
	}
	public int getClassreg_no() {
		return classreg_no;
	}
	public void setClassreg_no(int classreg_no) {
		this.classreg_no = classreg_no;
	}
	public Date getClassreg_date() {
		return classreg_date;
	}
	public void setClassreg_date(Date classreg_date) {
		this.classreg_date = classreg_date;
	}
	public int getClassreg_level() {
		return classreg_level;
	}
	public void setClassreg_level(int classreg_level) {
		this.classreg_level = classreg_level;
	}
	public int getClassreg_semester() {
		return classreg_semester;
	}
	public void setClassreg_semester(int classreg_semester) {
		this.classreg_semester = classreg_semester;
	}
	public String getClassreg_retake() {
		return classreg_retake;
	}
	public void setClassreg_retake(String classreg_retake) {
		this.classreg_retake = classreg_retake;
	}
	public int getStd_no() {
		return std_no;
	}
	public void setStd_no(int std_no) {
		this.std_no = std_no;
	}
	public int getClass_no() {
		return class_no;
	}
	public void setClass_no(int class_no) {
		this.class_no = class_no;
	}
	public ClassregVo(int classreg_no, Date classreg_date, int classreg_level, int classreg_semester,
			String classreg_retake, int std_no, int class_no) {
		super();
		this.classreg_no = classreg_no;
		this.classreg_date = classreg_date;
		this.classreg_level = classreg_level;
		this.classreg_semester = classreg_semester;
		this.classreg_retake = classreg_retake;
		this.std_no = std_no;
		this.class_no = class_no;
	}
	public ClassregVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
