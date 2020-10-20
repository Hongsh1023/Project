package com.bit.university.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.bit.university.db.GradeManager;
import com.bit.university.vo.GradeVo;

@Repository
public class GradeDao {
	public List<GradeVo> listAll(int std_no){
		return GradeManager.listAll(std_no);
	}
	
	public List<GradeVo> detail(HashMap map){
		return GradeManager.detail(map);
	}
	
	public int insert(GradeVo vo) {
		return GradeManager.insert(vo);
	}
	
	public GradeVo findByNo(int grade_no) {
		return GradeManager.findByNo(grade_no);
	}
	
	public int update(GradeVo vo) {
		return GradeManager.update(vo);
	}
	
	public int delete(int grade_no) {
		return GradeManager.delete(grade_no);
	}
}
