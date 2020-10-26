package com.bit.university.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.bit.university.db.ClassManager;
import com.bit.university.db.ClassregManager;
import com.bit.university.vo.ClassregVo;
import com.bit.university.vo.StudentVo;

@Repository
public class ClassregDao {

	//***학사정보*** 에서 보는 학생정보 출력. year 등 detailClass에서 필요한부분이 있어 따로 sql작성
	//std_no, class_year, clsasreg_semester 필요
	public List<ClassregVo> detailClassregList(HashMap map) {
		return ClassregManager.detailClassregList(map);
	}
	//수강신청/에 표시되는 리스트
	public List<ClassregVo> classregList(int std_no){
		return ClassregManager.classregList(std_no);
	}
	//***학사정보***수강신청실행 시 첫창에 뿌릴 학생정보
	public StudentVo classregStudentInfoByNo(int std_no) {
		return ClassregManager.classregStudentInfoByNo(std_no);
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
	public int classregInsert(HashMap map) {
		//true가 되면 insert 진행!
		boolean checkStates = false;
		int n=-1;
		String classreg_retake = classregInsertCheckRetake(map);	//Y,N
		if(classreg_retake.equals("I")) {
			return n;
		}
		if( classregInsertCheckDoubleSub(map) != 0) { // 0
			return n;
		}
		
		int std_no = (Integer) map.get("std_no");
		int class_no = (Integer) map.get("class_no");
		StudentVo svo = classregStudentInfoByNo(std_no);
		String sStates = svo.getStd_status();
		switch(sStates) {
		case "휴학": return n;
		case "졸업" : return n;
		case "재학" : checkStates = true;break;
		case "복학" : checkStates = true;break;
		}
		if(checkStates=true) {
			int classreg_no = classregNextNo();
			int classreg_level = svo.getStd_level();
			int classreg_semester = svo.getStd_semester();
			//classreg_retake; 위에
			ClassregVo cr_vo = new ClassregVo();
			cr_vo.setClassreg_no(classreg_no);
			cr_vo.setClassreg_level(classreg_level);
			cr_vo.setClassreg_semester(classreg_semester);
			cr_vo.setClassreg_retake(classreg_retake);
			cr_vo.setStd_no(std_no);
			cr_vo.setClass_no(class_no);
						
			n= ClassregManager.classregInsert(cr_vo);
		}
		System.out.println("재수강여부,중복신청여부,학적상태: "+classreg_retake+","+classregInsertCheckDoubleSub(map)+","+sStates);
		return n;
	}
	
	//수강신청시 중복과목체크문. 0이 아니면 신청할수 없게 할 예정.	/stdno, classno 필요
	public int classregInsertCheckDoubleSub(HashMap map) {
		int n = -1;
		n = ClassregManager.classregInsertCheckDoubleSub(map);
		return n;
	}
	//수강신청시 재수강여부체크. /stdno, classno 필요
	public String classregInsertCheckRetake(HashMap map) {
		String re = ""; //재수강. 수강가능.
		int n = -1;
		n = ClassregManager.classregInsertCheckRetake(map);
		if(n == 0) {
			re = "N"; 	//첫수강. 수강가능
		}else if (n > 1) {
			re = "I";	//재수강 이상. 수강불가
		}else {
			re = "Y";
		}
		return re;
	}
	
	public int classregDelete(HashMap map) {
		return ClassregManager.classregDelete(map);
	}
}
