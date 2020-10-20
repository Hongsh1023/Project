package com.bit.university.dao;


import org.springframework.stereotype.Repository;

import com.bit.university.db.DBManager;
import com.bit.university.vo.ChangeVo;
import com.bit.university.vo.StudentVo;

@Repository
public class ChangeDao {
	public ChangeVo getChangeInfo(int std_no) {
		return DBManager.getChangeInfo(std_no);
	}
}
