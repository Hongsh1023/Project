package com.bit.university.vo;

import lombok.Data;

@Data
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

	//pro_name	
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

}
