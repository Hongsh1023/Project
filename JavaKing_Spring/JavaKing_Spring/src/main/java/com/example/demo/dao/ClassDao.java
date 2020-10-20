package com.example.demo.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.db.ClassManager;
import com.example.demo.vo.ClassVo;

@Repository
public class ClassDao {

	public List<ClassVo> classList(HashMap map){
		return ClassManager.classList(map);
	}
	
	public int classTotalRecord(HashMap map) {
		return ClassManager.classTotalRecord(map);
	}
	
	public ClassVo classFindByNo(int class_no) {
		return ClassManager.classFindByNo(class_no);
	}
	
	public int classInsert(ClassVo c_vo) {
		return ClassManager.classInsert(c_vo);
	}
	
	public int classUpdate(ClassVo c_vo) {
		return ClassManager.classUpdate(c_vo);
	}
	
	public int classDelete(int class_no) {
		return ClassManager.classDelete(class_no);
	}
	
	public int classNextNo() {
		return ClassManager.classNextNo();
	}
}
