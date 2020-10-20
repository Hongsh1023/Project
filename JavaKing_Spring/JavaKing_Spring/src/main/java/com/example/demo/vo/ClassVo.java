package com.example.demo.vo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClassVo {

	private int class_no;
	private String class_name;
	private Date class_startdate;
	private Date class_enddate;
	private String class_dayofweek;
	private String class_time;
	private String class_room;	
	private int class_credit;	//학점
	private String class_type;	//교양/전공 구분
	private int pro_no;		//fk 교수번호
	
	private String class_dayTime [];	// 표 색칠을 위한 day+time. 월,화 12,12 라면 월12 화12 이렇게 담을 예정.
	private int rn;
	private String pro_name;
	
}
