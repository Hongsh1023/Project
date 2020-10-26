<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>:: 비트대학교 ::</title>
<script type="text/javascript" src=" https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
$(function(){

	$("#btn_search").click(function(){	
		var data = $("#s").serialize();
		$(location).attr("href","/login/classreg.do"+data);
	});
	
	$(document).on("click",".btn_insert",function(){	
		var classno = $(this).attr("classno");
		var data = "?classno="+classno;
		$(location).attr("href","/login/classregInsert.do"+data);
	});
	
	$(document).on("click",".btn_delete",function(){	
		var classregno = $(this).attr("classregno");
		var data = "?classregno="+classregno;
		$(location).attr("href","/login/classregDelete.do"+data);
	});

});
</script>

<style type="text/css">


a {
	text-decoration: none;
	color : black;
}

body {
	font-family: sans-serif;
	margin: 0;
	width: 2000px;
	height: 100%;
	padding : 0;
	background-color: #FFFFFF;
	display: inline-block;
	position: relative;
}

#logo {
	display : inline-block;
	margin-left : 40%;
	padding-top : 20px;
}

#lock_image{
	vertical-align: middle;
}

#hello_box{
	display : inline-block;
	margin-left : 70%;
	vertical-align: middle;
	padding-bottom: 10px;
}

#name {
	font-weight: bold;
	color:#083b90;
}

#logout {
	font-weight: bold;
	color:#8C8C8C;
}

#nav_boxes{
	position: relative;
}


.nav {
	display: inline-block;
	background-color: #FFFFFF;
	width : 100px;
	height: 30px;
	vertical-align: middle;
	text-align: center;
	font-size: 20px;
	font-weight: bold;
	cursor: pointer;
}

#nav_box {
	display: inline;
	width : 100%;
}

#nav1 {
	margin-left : 400px;
}

.nav_window {
	display : none;
	position : absolute;
	width : 100%;
	height : 160px;
	background-color: #083b90;
}

.nav:hover {
	background-color: #083b90;
	color : #FFFFFF;
}

#nav1:hover + #nav_window1{
	display : block;
	border-bottom: 1px #083b90 solid;
	border-top: 1px #083b90 solid;
}

#nav2:hover + #nav_window2{
	display : block;
	border-bottom: 1px #083b90 solid;
	border-top: 1px #083b90 solid;
}

#nav3:hover + #nav_window3{
	display : block;
	border-bottom: 1px #083b90 solid;
	border-top: 1px #083b90 solid;
}

#nav4:hover + #nav_window4{
	display : block;
	border-bottom: 1px #083b90 solid;
	border-top: 1px #083b90 solid;
}

#nav_window1:hover {
	display : block;
	border-bottom: 1px #083b90 solid;
	border-top: 1px #083b90 solid;
}

#nav_window2:hover {
	display : block;
	border-bottom: 1px #083b90 solid;
	border-top: 1px #083b90 solid;
}

#nav_window3:hover {
	display : block;
	border-bottom: 1px #083b90 solid;
	border-top: 1px #083b90 solid;
}

#nav_window4:hover {
	display : block;
	border-bottom: 1px #083b90 solid;
	border-top: 1px #083b90 solid;
}

.nav_title {
	font-size: 30px;
	font-weight: bold;
	color: #FFFFFF;
	vertical-align: middle;
	display: inline-block;
}

.nav_right{
	display: inline-block;
	background-color: #FFFFFF;
	height : 100%;
	width : 75%;
	position: absolute;
	left : 25%;
}

.nav_right_title {
	font-weight: bold;
	font-size: 20px;
}

.nav_right_box{
	display: inline-block;
	padding : 20px;
	vertical-align: top;
}

li {
	list-style-type: square;
}

section {
	background-color: #EBF7FF;
}

#section_main {
	margin-left: 320px;
	margin-top: 50px;
	width: 1250px;
	background-color: #FFFFFF;
	padding : 50px;
	border : 2px #E1E1E1 solid;
}

p {
  display: block;
  margin-top: 1.5em;
  margin-bottom: 2em;
  margin-left: 0;
  margin-right: 0;

}

.p2 {
  display: block;
  margin-top: 0.3em;
  margin-bottom: 0.7em;
  margin-left: 0;
  margin-right: 0;

}
footer {
	background-color: #EBF7FF;
}

#footer_box{
	width: 100%;
	height: 150px;
	background-color: #313740;
	display: inline-block;
	text-align: left;
	margin-top: 50px;
	border-top: 1px solid gray;
}

#footer_title{
	display: inline-block;
	color : #FFFFFF;
	font-weight: bold;
	font-size: 40px; 
	margin-left:620px;
}

#footer_text {
	display: inline-block;
	color : #FFFFFF;
	margin-top:50px;
	margin-left:50px;
}
#header, #article {
	align: center;
	width: 1000px;
	}
	table {
	border-collapse : collapse;
	margin: 10px 0px 10px 0px;
	width : 1000px;
	}
	.searchR {
	margin-right : 0px; 
	width : 750px;
	}
	.timetable {
	margin-left : 0px;
	margin-right : 0px;
	width : 200px; 
	}	
	th {
	width: 10%;
	font-size: 10;
	}
</style>
</head>
<header>
	<div id = "logo">
		<a href = "main.do"><img src ="../image/logo3.png"></a>
	</div>
	<div id = "hello_box">
		<span id = "name">
			${std_name}
		</span>
		님 반갑습니다.&nbsp;&nbsp;
		<img src="../image/lock.png" id= "lock_image">
		<a href = "logout.do" id = "logout">로그아웃</a>
	</div>
	<hr>
</header>
<body>
	<nav>
		<div id = "nav_boxes">
			<div id = "nav1" class = "nav">
				<a href = "studentInfo.do" class = "nav">학사정보</a><br>
			</div>
			<div id = "nav_window1" class ="nav_window">
				<div id = "nav_title1" class = "nav_title">
					<br>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;학사정보
				</div>
				<div id ="nav_right1" class = "nav_right">
					<div id = "nav_right_list1" class = "nav_right_list">
						<div class = "nav_right_box">
							<div class = "nav_right_title">
								학적
							</div>
							<ul class= "inside_list">
								<li><p class = "p2"><a href = "studentInfo.do">학적조회</a></p></li>
							</ul>
						</div>
						<div class = "nav_right_box">
							<div class = "nav_right_title">
								수업
							</div>
							<ul class= "inside_list">
								<li><p class = "p2"><a href = "classreg.do">수강신청</a></p></li>
								<li><p class = "p2"><a href = "classreg.do">수강내역조회</a></p></li>
								<li><p class = "p2"><a href = "classreg.do">시간표조회</a></p></li>
							</ul>
						</div>
						<div class = "nav_right_box">
							<div class = "nav_right_title">
								성적
							</div>
							<ul class= "inside_list">
								<li><p class = "p2"><a href = "listGrade.do">성적조회</a></p></li>
							</ul>
						</div>
						<div class = "nav_right_box">
							<div class = "nav_right_title">
								등록
							</div>
							<ul class= "inside_list">
								<li><p class = "p2"><a href = "listReg.do">등록조회</a></p></li>
							</ul>
						</div>
						<div class = "nav_right_box">
							<div class = "nav_right_title">
								교수
							</div>
							<ul class= "inside_list">
								<li><p class = "p2"><a href = "listPro.do">교수조회</a></p></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
			&nbsp;&nbsp;·&nbsp;&nbsp;
			<div id = "nav2" class = "nav">
				<a href = "listBoard.do?board_boardno=100&board_category=알림마당" class = "nav">알림마당</a><br>
			</div>
			<div id = "nav_window2" class ="nav_window">
				<div id = "nav_title2" class = "nav_title">
					<br>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;알림마당
				</div>
				<div id ="nav_right2" class = "nav_right">
					<div id = "nav_right_list2" class = "nav_right_list">
						<div class = "nav_right_box">
							<div class = "nav_right_title">
								공지사항
							</div>
							<ul class= "inside_list">
								<li><p class = "p2"><a href = "listBoard.do?board_boardno=100&board_category=공지사항">공지사항</a></p></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
			&nbsp;&nbsp;·&nbsp;&nbsp;
			<div id = "nav3" class = "nav">
				<a href = "listBoard.do?board_boardno=300&board_category=참여마당" class = "nav">참여마당</a><br>
			</div>
			<div id = "nav_window3" class ="nav_window">
				<div id = "nav_title3" class = "nav_title">
					<br>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;참여마당
				</div>
				<div id ="nav_right3" class = "nav_right">
					<div id = "nav_right_list3" class = "nav_right_list">
						<div class = "nav_right_box">
							<div class = "nav_right_title">
								중고장터
							</div>
							<ul class= "inside_list">
								<li><p class = "p2"><a href = "listBoard.do?board_boardno=300&board_category=삽니다">삽니다</a></p></li>
								<li><p class = "p2"><a href = "listBoard.do?board_boardno=300&board_category=팝니다">팝니다</a></p></li>
							</ul>
						</div>
						<div class = "nav_right_box">
							<div class = "nav_right_title">
								게시판
							</div>
							<ul class= "inside_list">
								<li><p class = "p2"><a href = "listBoard.do?board_boardno=300&board_category=자유게시판">자유게시판</a></p></li>
								<li><p class = "p2"><a href = "listBoard.do?board_boardno=300&board_category=익명게시판">익명게시판</a></p></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
			&nbsp;&nbsp;·&nbsp;&nbsp;
			<div id = "nav4" class = "nav">
				<a href = "listBoard.do?board_boardno=200&board_category=도움마당" class = "nav">도움마당</a><br>
			</div>
			<div id = "nav_window4" class ="nav_window">
				<div id = "nav_title4" class = "nav_title">
					<br>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;도움마당
				</div>
				<div id ="nav_right4" class = "nav_right">
					<div id = "nav_right_list4" class = "nav_right_list">
						<div class = "nav_right_box">
							<div class = "nav_right_title">
								QnA
							</div>
							<ul class= "inside_list">
								<li><p class = "p2"><a href = "listBoard.do?board_boardno=200&board_category=시설QNA">시설 QnA</a></p></li>
								<li><p class = "p2"><a href = "listBoard.do?board_boardno=200&board_category=학사QNA">학사 QnA</a></p></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</nav>
	<section>
	<hr>

	<div id = "section_main">
	<div class="학생정보"> <!-- 학생정보 -->
		<h3>수강신청</h3>
		<b>${s.std_level } 학년도 ${s.std_semester } 학기 수강신청</b> <a href="printClassreg.do?stdno=${s.std_no}"><button>수강확인서출력</button></a>
		<table border="1" class="basic">
			<tr>
				<th>성명</th>
				<td>${s.std_name }</td>
				<th>성별</th>
				<td>${s.std_gender }</td>
				<th>생년월일</th>
				<td>${s.std_birthday }</td>
			</tr>
			<tr>
				<th>학과</th>
				<td>${s.std_major }</td>
				<th>학년</th>
				<td>${s.std_level }</td>
				<th>학기</th>
				<td>${s.std_semester }</td>
			</tr>
			<tr>
				<th>학번</th>
				<td>${s.std_no }</td>
				<th>학적상태</th>
				<td>${s.std_status }</td>
				<th>입학일</th>
				<td>${s.std_startdate }</td>
			</tr>
		</table>

</div>
<div id="article">
	<div class="조회란" > 
		<table border="1" class="search">
			<tr>
				<th>과목명</th>
				<td>
				<form id="s">
					<input type="hidden" name="site" id="site" value="1">
					<input type="text" name="search" id="search"><button id="btn_search">조회</button>
				</form>
					<font color="${color }">${msg }</font>
					<th>총신청학점</th>
					<td>&nbsp;&nbsp;${cCredit }&nbsp;&nbsp;</td>
					<th>신청과목수</th>
					<td>&nbsp;&nbsp;${cSubject }&nbsp;&nbsp;</td>
				</td>
				
			</tr>
		</table>
	</div>
	 <!-- 수강신청내역 -->
	 <div class="수강신청테이블">
		 <div class="수강신청란" style="float:lefT">
				<table border="1" class="searchR">
					<tr>
						<th>순번</th>
						<th>강의명</th>
						<th>이수구분</th>
						<th>학점</th>
						<th>교수명</th>
						<th>강의시간</th>
						<th>신청</th>
					</tr>
					<!-- foreach 처리 -->
					<c:forEach var="sc" items="${cr_list }">
						<tr>
							<td>${sc.rn }<input type="hidden" value="${sc.class_no }"></td>
							<td>${sc.class_name }</td>
							<td>${sc.class_type }</td>
							<td>${sc.class_credit }</td>
							<td>${sc.pro_name }(${sc.pro_no })</td>
							<td>${sc.class_dayofweek } ${sc.class_time }</td>
							<td>
							<div class="inputInsert"></div>
								<button class="btn_insert" site="2" classno="${sc.class_no }">신청</button>
							</td>
						</tr>
					</c:forEach>
				</table>
				<c:if test="${pageStr !=null  }">
				${pageStr }
				</c:if>
			</div>
			<div class="시간표" style="float:right">
				<table border="1" class="timetable">
					<tr>
						<th></th>
						<th>월</th>
						<th>화</th>
						<th>수</th>
						<th>목</th>
						<th>금</th>
						<th>토</th>
					</tr>
					<c:forEach var="i" begin="1" end="9">
						<tr>
							<th>${i }</th>
								<c:forEach var="j" begin="1" end="6">
									<td id="cell${i }${j }"><input type="hidden" value=""></td>
								</c:forEach>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	<div class="신청결과">
		<table border="1" class="basic">
			<tr>
				<th>순번</th>
				<th>강의명</th>
				<th>학년</th>
				<th>학기</th>
				<th>이수구분</th>
				<th>학점</th>
				<th>교수</th>
				<th>강의시간</th>
				<th>비고</th>
				<th>삭제</th>
			</tr>
			<!-- foreach 처리 ClassregVo-->
			<c:forEach var="cr" items="${mycrList}">
				<tr>
					<td>${cr.rn }<input type="hidden" value="${cr.classreg_no }"></td>
					<td>${cr.class_name }</td>
					<td>${cr.std_level }</td>
					<td>${cr.std_semester }</td>
					<td>${cr.class_type }</td>
					<td>${cr.class_credit }</td>
					<td>${cr.pro_name } (${cr.pro_no })</td>
					<td>${cr.class_dayofweek } ${cr.class_time }</td>
					<td>${cr.classreg_retake }</td>
					<td><button class="btn_delete" site="3" classregno=${cr.classreg_no } >삭제</button></a></td>
				</tr>
			</c:forEach>
		</table>
		</div>
	</div>
	</div>
</section>
</body>
<footer>
	<div id ="footer_box">
		<div id = "footer_title">
		비트대학교
		</div>
		<div id = "footer_text">
			　　주소 | 서울특별시 마포구 백범로 23 구프라자 B1<br>
			대표전화 | 02-707-1480
		</div>
	</div>
</footer>
</html>
