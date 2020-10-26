<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>:: 비트대학교 ::</title>
<script type="text/javascript">
   function change_category(board_category){
      location.href="listBoard.do?board_category="+encodeURI(encodeURI(board_category));
   }
   
   function change_pagesize(page_size){
	   location.href="listBoard.do?page_size="+page_size; 
	}
</script>

<style type="text/css">
d{
	text-align: center;
}
tr:hover{
	color: #3a7cec;
}
table{
	border-collapse: collapse;
}

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
	<form action="class.do" method="POST">
		<h2>강의 목록</h2>
		<a href="adminClass.do"><button type="button">신규등록</button></a>
		<hr>
		<table border="1" width=80%>
			<tr>
				<th>순번</th>
				<th>강의번호</th>
				<th>과목명</th>
				<th>일자(요일,시간)</th>
				<th>강의교실</th>
				<th>시작일</th>
				<th>종료일</th>
				<th>학점</th>
				<th>이수구분</th>
				<th>담당교수</th>
				<th>admin</th>
			</tr>
			<c:forEach var="c" items="${class_list }">		
				<tr>
					<td>${c.rn }</td>
					<td>${c.class_no }</td>
					<td>${c.class_name }</td>
					<td>${c.class_dayofweek } ${c.class_time }</td>
					<td>${c.class_room }</td>
					<td>${c.class_startdate }</td>
					<td>${c.class_enddate }</td>
					<td>${c.class_credit }</td>
					<td>${c.class_type }</td>
					<td>${c.pro_name} (${c.pro_no })</td>
					<td>
						<a href="adminClassEdit.do?classno=${c.class_no }"><button type="button">수정</button></a> 
						<a href="adminClassDelete.do?classno=${c.class_no }"><button type="button">삭제</button></a>
					</td>
				</tr>
			</c:forEach>
		</table>
		<hr>
			<select id="option" name="option">
				<option selected disabled>==선택==</option>
				<option value="class_name">강의명</option>
				<option value="class_type">이수구분</option>
				<option value="pro_name">교수명</option>
			</select> 
			<input type="search" name="search" value="${search }">
			<button type="submit">검색</button><br>
			${pageStr }
	</form>
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
