package com.bit.vo;

public class ScheduleVo {

	private String day;
	private String time;
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public ScheduleVo(String day, String time) {
		super();
		this.day = day;
		this.time = time;
	}
	public ScheduleVo() {
		super();
	}
	
	
}
