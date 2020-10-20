package com.bit.university.dao;


import org.springframework.stereotype.Repository;

import com.bit.university.db.DBManager;
import com.bit.university.vo.StudentVo;

@Repository
public class StudentDao {
	public StudentVo getStudentInfo(int std_no) {
		return DBManager.getStudentInfo(std_no);
	}
	
	public StudentVo getStartEndDate(int std_no) {
		return DBManager.getStartEndDate(std_no);
	}
	
	public int insert(StudentVo sv3) {
		return DBManager.insertStudentInfo(sv3);
	}
}
