package com.bit.university.dao;

import org.springframework.stereotype.Repository;

import com.bit.university.db.StudentManager;
import com.bit.university.vo.StudentVo;

@Repository
public class StudentDao {
	
	public StudentVo getStudent(String std_no) {
		return StudentManager.getStudent(std_no);
	}
	
}
