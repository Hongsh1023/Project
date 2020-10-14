package com.bit.vo;

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
	
	public int getGrade_no() {
		return grade_no;
	}
	public void setGrade_no(int grade_no) {
		this.grade_no = grade_no;
	}
	public int getGrade_regcredit() {
		return grade_regcredit;
	}
	public void setGrade_regcredit(int grade_regcredit) {
		this.grade_regcredit = grade_regcredit;
	}
	public double getGrade_getcredit() {
		return grade_getcredit;
	}
	public void setGrade_getcredit(double grade_getcredit) {
		this.grade_getcredit = grade_getcredit;
	}
	public int getGrade_score() {
		return grade_score;
	}
	public void setGrade_score(int grade_score) {
		this.grade_score = grade_score;
	}
	public int getGrade_semester() {
		return grade_semester;
	}
	public void setGrade_semester(int grade_semester) {
		this.grade_semester = grade_semester;
	}
	public int getGrade_level() {
		return grade_level;
	}
	public void setGrade_level(int grade_level) {
		this.grade_level = grade_level;
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
	
	public String getGrade_year() {
		return grade_year;
	}
	public void setGrade_year(String grade_year) {
		this.grade_year = grade_year;
	}
	
	public int getSum_grade_regcredit() {
		return sum_grade_regcredit;
	}
	public void setSum_grade_regcredit(int sum_grade_regcredit) {
		this.sum_grade_regcredit = sum_grade_regcredit;
	}
	public double getAverage_grade_getcredit() {
		return average_grade_getcredit;
	}
	public void setAverage_grade_getcredit(double average_grade_getcredit) {
		this.average_grade_getcredit = average_grade_getcredit;
	}
	public double getAverage_grade_score() {
		return average_grade_score;
	}
	public void setAverage_grade_score(double average_grade_score) {
		this.average_grade_score = average_grade_score;
	}
	public String getClass_name() {
		return class_name;
	}
	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}
	public String getClass_type() {
		return class_type;
	}
	public void setClass_type(String class_type) {
		this.class_type = class_type;
	}
	
	public String getGrade_rank() {
		return grade_rank;
	}
	public void setGrade_rank(String grade_rank) {
		this.grade_rank = grade_rank;
	}
	
	public GradeVo(int grade_no, int grade_regcredit, double grade_getcredit, int grade_score, int grade_semester,
			int grade_level, int std_no, int class_no, String grade_year, int sum_grade_regcredit,
			double average_grade_getcredit, double average_grade_score, String class_name, String class_type,
			String grade_rank) {
		super();
		this.grade_no = grade_no;
		this.grade_regcredit = grade_regcredit;
		this.grade_getcredit = grade_getcredit;
		this.grade_score = grade_score;
		this.grade_semester = grade_semester;
		this.grade_level = grade_level;
		this.std_no = std_no;
		this.class_no = class_no;
		this.grade_year = grade_year;
		this.sum_grade_regcredit = sum_grade_regcredit;
		this.average_grade_getcredit = average_grade_getcredit;
		this.average_grade_score = average_grade_score;
		this.class_name = class_name;
		this.class_type = class_type;
		this.grade_rank = grade_rank;
	}
	public GradeVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
