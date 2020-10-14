package com.bit.vo;

public class ClassVo {
	private int rownum;
	private int class_no;
	private String class_name;
//	private Date class_startdate;
//	private Date class_enddate;
	private String class_startdate;
	private String class_enddate;
	private String class_dayofweek;
	private String class_time;
	private String class_room;
	private int class_credit;
	private String class_type;
	private int pro_no;
	private String pro_name;
	
	public ClassVo(int rownum, int class_no, String class_name, String class_startdate, String class_enddate,
			String class_dayofweek, String class_time, String class_room, int class_credit, String class_type,
			int pro_no, String pro_name) {
		super();
		this.rownum = rownum;
		this.class_no = class_no;
		this.class_name = class_name;
		this.class_startdate = class_startdate;
		this.class_enddate = class_enddate;
		this.class_dayofweek = class_dayofweek;
		this.class_time = class_time;
		this.class_room = class_room;
		this.class_credit = class_credit;
		this.class_type = class_type;
		this.pro_no = pro_no;
		this.pro_name = pro_name;
	}
	public int getRownum() {
		return rownum;
	}
	public void setRownum(int rownum) {
		this.rownum = rownum;
	}
	public String getPro_name() {
		return pro_name;
	}
	public void setPro_name(String pro_name) {
		this.pro_name = pro_name;
	}
	public int getClass_no() {
		return class_no;
	}
	public void setClass_no(int class_no) {
		this.class_no = class_no;
	}
	public String getClass_name() {
		return class_name;
	}
	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}
	public String getClass_startdate() {
		return class_startdate;
	}
	public void setClass_startdate(String class_startdate) {
		this.class_startdate = class_startdate;
	}
	public String getClass_enddate() {
		return class_enddate;
	}
	public void setClass_enddate(String class_enddate) {
		this.class_enddate = class_enddate;
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
	public String getClass_room() {
		return class_room;
	}
	public void setClass_room(String class_room) {
		this.class_room = class_room;
	}
	public int getClass_credit() {
		return class_credit;
	}
	public void setClass_credit(int class_credit) {
		this.class_credit = class_credit;
	}
	public String getClass_type() {
		return class_type;
	}
	public void setClass_type(String class_type) {
		this.class_type = class_type;
	}
	public int getPro_no() {
		return pro_no;
	}
	public void setPro_no(int pro_no) {
		this.pro_no = pro_no;
	}
	//pro_name Ãß°¡	
	public ClassVo(int class_no, String class_name, String class_startdate, String class_enddate, String class_dayofweek,
			String class_time, String class_room, int class_credit, String class_type, int pro_no, String pro_name) {
		super();
		this.class_no = class_no;
		this.class_name = class_name;
		this.class_startdate = class_startdate;
		this.class_enddate = class_enddate;
		this.class_dayofweek = class_dayofweek;
		this.class_time = class_time;
		this.class_room = class_room;
		this.class_credit = class_credit;
		this.class_type = class_type;
		this.pro_no = pro_no;
		this.pro_name = pro_name;
	}
	public ClassVo(int class_no, String class_name, String class_startdate, String class_enddate, String class_dayofweek,
			String class_time, String class_room, int class_credit, String class_type, int pro_no) {
		super();
		this.class_no = class_no;
		this.class_name = class_name;
		this.class_startdate = class_startdate;
		this.class_enddate = class_enddate;
		this.class_dayofweek = class_dayofweek;
		this.class_time = class_time;
		this.class_room = class_room;
		this.class_credit = class_credit;
		this.class_type = class_type;
		this.pro_no = pro_no;
	}
	public ClassVo() {
		super();
		// TODO Auto-generated constructor stub
	}	
}
