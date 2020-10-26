package com.bit.university.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bit.university.db.ProfessorManager;
import com.bit.university.vo.ProfessorVo;



@Repository
public class ProfessorDao {

	public List<ProfessorVo> professorList(){
		return ProfessorManager.professorList();
	}
	
	public int ProfessorInsert(ProfessorVo p) {
		return ProfessorManager.ProfessorInsert(p);
	}
}
