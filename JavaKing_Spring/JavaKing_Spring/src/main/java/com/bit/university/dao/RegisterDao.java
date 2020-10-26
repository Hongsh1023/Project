package com.bit.university.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bit.university.db.RegisterManager;
import com.bit.university.vo.RegisterVo;


@Repository
public class RegisterDao {

	public List<RegisterVo> registerList(int std_no){
		return RegisterManager.registerList(std_no);
	}
	
	public int registerInsert(RegisterVo r) {
		return RegisterManager.registerInsert(r);
	}
	
	public int registerNextNo() {
		return RegisterManager.registerNextNo();
	}
}
