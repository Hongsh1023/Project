package com.example.demo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.db.DBManager;
import com.example.demo.vo.RegisterVo;

@Repository
public class RegisterDao {

	public List<RegisterVo> registerList(int std_no){
		return DBManager.registerList(std_no);
	}
	
	public int registerInsert(RegisterVo r) {
		return DBManager.registerInsert(r);
	}
	
	public int registerNextNo() {
		return DBManager.registerNextNo();
	}
}
