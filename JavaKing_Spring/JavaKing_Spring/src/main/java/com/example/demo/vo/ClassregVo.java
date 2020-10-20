package com.example.demo.vo;

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
	
	private int rn;
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
}
