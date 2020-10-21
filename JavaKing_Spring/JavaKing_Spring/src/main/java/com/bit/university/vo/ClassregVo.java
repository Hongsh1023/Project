package com.bit.university.vo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
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
}
