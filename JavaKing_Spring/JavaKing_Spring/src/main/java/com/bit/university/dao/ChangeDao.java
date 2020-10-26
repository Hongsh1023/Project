package com.bit.university.dao;


import java.util.List;

import org.springframework.stereotype.Repository;

import com.bit.university.db.ChangeManager;
import com.bit.university.vo.ChangeVo;

@Repository
public class ChangeDao {
	public List<ChangeVo> getChangeInfo(int std_no) {
		return ChangeManager.getChange(std_no);
	}
}
