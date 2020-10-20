package com.bit.university.vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GradeVo {
	private int grade_no;
	private int grade_regcredit;
	private double grade_getcredit;
	private int grade_score;
	private int grade_semester;
	private int grade_level;
	private int std_no;
	private int class_no;
	private String grade_year;
	private int sum_grade_regcredit;
	private double average_grade_getcredit;
	private double average_grade_score;
	private String class_name;
	private String class_type;
	private String grade_rank;	
}
