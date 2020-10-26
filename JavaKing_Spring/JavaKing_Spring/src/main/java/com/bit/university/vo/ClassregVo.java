package com.bit.university.vo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClassregVo {
	//기본vo
	private int classreg_no;
	private Date classreg_date;
	private int classreg_level;
	private int classreg_semester;	//
	private String classreg_retake;
	private int std_no;
	private int class_no;
	
	//뷰작성을 위한 추가분
	private int rn;
	private String class_name;
	private int std_level;
	private int std_semester; // 수강신청 시 학생정보에 있는 semester 를 뽑아오기위해
	private String class_type;
	private int class_credit;
	private int pro_no;
	private String pro_name;
	private String class_dayofweek;
	private String class_time;
	private String class_year;	// 학사정보 조회시 입력되는 연도값
}
