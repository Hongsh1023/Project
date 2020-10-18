package com.bit.university.db;

import java.io.InputStream;
import java.util.HashMap;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.bit.university.vo.StudentVo;

public class LoginManager {

	public static SqlSessionFactory sqlSessionFactory;

	static {
		String resource = "com/example/demo/db/sqlMapConfig.xml";
		try {
			InputStream inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (Exception e) {
			System.out.print("예외발생:" + e.getMessage());
		}
	}

	public static int loginCheck(int std_no, String std_pwd) {
		int re = -1;
		SqlSession session = sqlSessionFactory.openSession();
		HashMap map = new HashMap();
		map.put("std_no", std_no);
		map.put("std_pwd", std_pwd);
		re = session.selectOne("login.loginCheck", map);
		session.close();
		return re;
	}
}
