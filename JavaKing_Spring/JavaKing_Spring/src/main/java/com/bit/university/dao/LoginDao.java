package com.bit.university.dao;

import org.springframework.stereotype.Repository;

import com.bit.university.db.LoginManager;

@Repository
public class LoginDao {
	public int loginCheck(int std_no, String std_pwd) {
		return LoginManager.loginCheck(std_no, std_pwd);
	}
}
