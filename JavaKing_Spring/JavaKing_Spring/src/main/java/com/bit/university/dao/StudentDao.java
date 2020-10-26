package com.bit.university.dao;

import org.springframework.stereotype.Repository;

import com.bit.university.db.StudentManager;
import com.bit.university.vo.StudentVo;

@Repository
public class StudentDao {
	
	public StudentVo getStudent(int std_no) {
		return StudentManager.getStudent(std_no);
	}
	
	public int insertStudent(StudentVo sv3) {
		return StudentManager.insertStudent(sv3);
	}
	
	public StudentVo getStartEndDate(int std_no) {
		return StudentManager.getStartEndDate(std_no);
	}
	
}
