package com.example.demo.db;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.example.demo.vo.ClassregVo;
import com.example.demo.vo.StudentVo;

public class ClassregManager {

	static SqlSessionFactory sqlSessionFactory;
	static {
		try {
		String resource = "com/example/demo/db/sqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		 sqlSessionFactory =
		  new SqlSessionFactoryBuilder().build(inputStream);
		}catch(Exception e) {System.out.println("sqlsession 시작 오류 : "+e.getMessage());
	}
	}	
	
	//***학사정보*** 에서 보는 학생정보 출력. year 등 detailClass에서 필요한부분이 있어 따로 sql작성
	public static List<ClassregVo> detailClassregList(HashMap map) {
		//std_no, class_year, clsasreg_semester 전달
		List<ClassregVo> list = null;
		SqlSession session = sqlSessionFactory.openSession();
		list = session.selectList("classreg.detailClassregList", map);
		session.close();
		return list;
	}
	
	//수강신청 에 표시되는 리스트
	public static List<ClassregVo> classregList(int std_no){
		List<ClassregVo> list = null;
		SqlSession session = sqlSessionFactory.openSession();
		list = session.selectList("classreg.classregList", std_no);		
		session.close();
		return list;
	}
	
	//***수강신청***
	//수강신청시 생성되는 다음번호
	public static int classregNextNo() {
		int n =-1;
		SqlSession session = sqlSessionFactory.openSession();
		n = session.selectOne("classreg.classregNextNo");
		session.close();
		return n;
	}
	
	//수강신청 실행시 첫창에 학생정보 끌어오기
	public static StudentVo classregStudentInfoByNo(int std_no) {
		StudentVo s_vo = null;
		SqlSession session = sqlSessionFactory.openSession();
		s_vo = session.selectOne("classreg.classregStudentInfoByNo", std_no);
		session.close();
		return s_vo;
	}
	
	//수강신청에서 신청한 과목수
	public static int classregCountlRecord(int std_no) {
		int n = -1;
		SqlSession session = sqlSessionFactory.openSession();
		n = session.selectOne("classreg.classregCountlRecord", std_no);
		session.close();
		return n;
	}
	//수강신청에서 신청한 학점
	public static int classregCountCredit(int std_no) {
		int n = -1;
		SqlSession session = sqlSessionFactory.openSession();
		n = session.selectOne("classreg.classregCountCredit", std_no);
		session.close();
		return n;
	}
	//번호로 신청한 수강내역 찾기
	public static ClassregVo classregFindByNo(int classreg_no) {
		ClassregVo cr_vo = null;
		SqlSession session = sqlSessionFactory.openSession();
		cr_vo = session.selectOne("classreg.classregFindByNo", classreg_no);
		session.close();
		return cr_vo;
	}
	//수강신청 insert문
	public static int classregInsert(ClassregVo cr_vo) {
		int n = -1;
		SqlSession session = sqlSessionFactory.openSession(true);
		n = session.insert("classreg.classregInsert", cr_vo);
		session.close();
		return n;
	}
	//수강신청시 중복과목체크문. 0이 아니면 신청할수 없게 할 예정.	
	public static int classregInsertCheckDoubleSub(HashMap map) {
		//stdno, classno 필요
		int n = -1;
		SqlSession session = sqlSessionFactory.openSession();
		n = session.selectOne("classreg.classregInsertCheckDoubleSub", map);
		session.close();
		return n;
	}
	//수강신청시 재수강여부체크. 기본 -1 Y재수강, 0 N첫수강, 2이상 I수강불가
	public static int classregInsertCheckRetake(HashMap map) {
		//stdno, classno 필요
		int n = -1;
		SqlSession session = sqlSessionFactory.openSession();
		n = session.insert("classreg.classregInsertCheckRetake", map);
		session.close();
		return n;
	}
	
	public static int classregDelete(int classreg_no) {
		int n = -1;
		SqlSession session = sqlSessionFactory.openSession(true);
		n = session.delete("classreg.classergDelete", classreg_no);
		session.close();
		return n;
	}

}
