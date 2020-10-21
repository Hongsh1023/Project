package com.example.demo.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.db.ClassManager;
import com.example.demo.db.ClassregManager;
import com.example.demo.vo.ClassregVo;

@Repository
public class ClassregDao {

	//***학사정보*** 에서 보는 학생정보 출력. year 등 detailClass에서 필요한부분이 있어 따로 sql작성
	//std_no, class_year, clsasreg_semester 필요
	public List<ClassregVo> detailClassregList(HashMap map) {
		return ClassregManager.detailClassregList(map);
	}
	//***수강신청/학사정보*** 에 표시되는 리스트
	public List<ClassregVo> classregList(int std_no){
		return ClassregManager.classregList(std_no);
	}
	//수강신청시 생성되는 다음번호
	public int classregNextNo() {
		return ClassregManager.classregNextNo();
	}
	//수강신청에서 신청한 과목수
	public int classregCountlRecord(int std_no) {
		return ClassregManager.classregCountlRecord(std_no);
	}
	
	//수강신청에서 신청한 학점
	public int classregCountCredit(int std_no) {
		return ClassregManager.classregCountCredit(std_no);
	}
	//번호로 신청한 수강내역 찾기
	public ClassregVo classregFindByNo(int classreg_no) {
		return ClassregManager.classregFindByNo(classreg_no);
	}
	//수강신청 insert문
	public int classregInsert(ClassregVo cr_vo) {
		return ClassregManager.classregInsert(cr_vo);
	}
	//수강신청시 중복과목체크문. 0이 아니면 신청할수 없게 할 예정.	/stdno, classno 필요
	public int classregInsertCheckDoubleSub(HashMap map) {
		return ClassregManager.classregInsertCheckDoubleSub(map);
	}
	//수강신청시 재수강여부체크. 기본 -1 Y재수강, 0 N첫수강, 2이상 I수강불가. /stdno, classno 필요
	public int classregInsertCheckRetake(HashMap map) {
		return ClassregManager.classregInsertCheckRetake(map);
	}
	
	public int classregDelete(int classreg_no) {
		return ClassregManager.classregDelete(classreg_no);
	}
}
