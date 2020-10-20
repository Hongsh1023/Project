package com.example.demo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.db.DBManager;
import com.example.demo.vo.ProfessorVo;

@Repository
public class ProfessorDao {

	public List<ProfessorVo> professorList(){
		return DBManager.professorList();
	}
	
	public int ProfessorInsert(ProfessorVo p) {
		return DBManager.ProfessorInsert(p);
	}
}
