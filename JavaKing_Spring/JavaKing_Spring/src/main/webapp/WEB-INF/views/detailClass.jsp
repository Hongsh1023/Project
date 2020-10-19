<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="device-width, initial-scale=1">
<title>:: 비트대학교 ::</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

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
table{
		text-align: middle; 
	}

	h2{
		color: #083b90;
		margin-left: 90px;
	}
	
	#form-control { 
		height: 20px; 
		width: 120px;
		line-height: normal;
	}
	label{
		padding-top : 5px;
		color : #083b90;
	}
	
	.tab_menu_container{
		margin-left: 80px;
		margin-right: 80px;
		width : 700px;
		display: flex;
		padding-top : 0;
		padding-bottom: 0;
	}

	.tab_menu_btn {
	  width:80px;
	  height:40px;
	  background-color : #f1f4f8;
	  transition:0.3s all;
	  border : 1px solid gray;
	}
	.tab_menu_btn.on {
	  border-top:2px solid #083b90;
	  border-left : 1px solid gray;
	  font-weight:700;
	  color:#083b90;
	  background-color: #ffffff;
	}
	.tab_menu_btn:hover {
	  color:#f1f4f8;
	}
	#tables{
		margin-left: 80px;
		margin-right: 80px;
		width : 800px;
		border : 1px solid gray;
	}
	.container1{
		padding-bottom:20px;
		font-weight : bold;
		display : table-cell;
		
	}
	.container2{
		padding-left : 40px;
		margin-left : 10px;
		display : table-cell;
	}

	td{
		text-align: center;
	}
	th{
		border : 1px solid gray;
		text-align: center;
		background-color: #f1f4f8;
	}

	select{
		width : 190px;
		height : 35px;
		border : 1px solid #d5d8db;
	}
	.container3{
		border-bottom : 1px solid gray;
	}
	.container4{
		padding-bottom:20px;
		font-weight : bold;
	}
	
	#submit{
		margin-left: 710px;
		border : 1px solid gray;
		background-color: #083b90;
		color:white;
	}
</style>
</head>
<header>
	<div id = "logo">
		<a href = "main.do"><img src ="../image/logo3.png"></a>
	</div>
	<div id = "hello_box">
		<span id = "name">
			${name}
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
				<a href = "listBoard.do?board_boardno=100&board_category=%25EA%25B3%25B5%25EC%25A7%2580%25EC%2582%25AC%25ED%2595%25AD" class = "nav">알림마당</a><br>
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
								<li><p class = "p2"><a href = "listBoard.do?board_boardno=100&board_category=%25EA%25B3%25B5%25EC%25A7%2580%25EC%2582%25AC%25ED%2595%25AD">공지사항</a></p></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
			&nbsp;&nbsp;·&nbsp;&nbsp;
			<div id = "nav3" class = "nav">
				<a href = "listBoard.do?board_boardno=300&board_category=%25EC%259E%2590%25EC%259C%25A0%25EA%25B2%258C%25EC%258B%259C%25ED%258C%2590" class = "nav">참여마당</a><br>
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
								<li><p class = "p2"><a href = "listBoard.do?board_boardno=300&board_category=%25EC%2582%25BD%25EB%258B%2588%25EB%258B%25A4">삽니다</a></p></li>
								<li><p class = "p2"><a href = "listBoard.do?board_boardno=300&board_category=%25ED%258C%259D%25EB%258B%2588%25EB%258B%25A4">팝니다</a></p></li>
							</ul>
						</div>
						<div class = "nav_right_box">
							<div class = "nav_right_title">
								게시판
							</div>
							<ul class= "inside_list">
								<li><p class = "p2"><a href = "listBoard.do?board_boardno=300&board_category=%25EC%259E%2590%25EC%259C%25A0%25EA%25B2%258C%25EC%258B%259C%25ED%258C%2590">자유게시판</a></p></li>
								<li><p class = "p2"><a href = "listBoard.do?board_boardno=300&board_category=%25EC%259D%25B5%25EB%25AA%2585%25EA%25B2%258C%25EC%258B%259C%25ED%258C%2590">익명게시판</a></p></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
			&nbsp;&nbsp;·&nbsp;&nbsp;
			<div id = "nav4" class = "nav">
				<a href = "listBoard.do?board_boardno=200&board_category=%25EC%258B%259C%25EC%2584%25A4QNA" class = "nav">도움마당</a><br>
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
								<li><p class = "p2"><a href = "listBoard.do?board_boardno=200&board_category=%25EC%258B%259C%25EC%2584%25A4QNA">시설 QnA</a></p></li>
								<li><p class = "p2"><a href = "listBoard.do?board_boardno=200&board_category=%25ED%2595%2599%25EC%2582%25ACQNA">학사 QnA</a></p></li>
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
	<h2>학사정보</h2>

	<form action="detailClassOk.do" method="post">
	<input type="hidden" name="std_no" value="${std_no }">
	<div class="info">
		<div id="tabs" class="tab_menu_container">
	   	 	<button class="tab_menu_btn" type="button" onclick="location='studentInfo.do'">기본정보</button>
	    	<button class="tab_menu_btn" type="button" onclick="location='startEndDate.do'">입학/졸업</button>
	  		<button class="tab_menu_btn" type="button" onclick="location='change.do'">학적변동</button>
	  		<button class="tab_menu_btn" type="button" onclick="location='listGrade.do'">성적</button>
	  		<button class="tab_menu_btn on" type="button" onclick="location='detailClass.do'">수강</button>
	  		<button class="tab_menu_btn" type="button" onclick="location='listReg.do'">등록</button>
	  	</div>
		<div id="tables" class="year_semester_grade">
			<div class="container1">
					<label for="div년도" id="lbl년도" title="년도">년도</label>
					<input type="text" id="div년도" class="form-control" name="year">
	        </div>
	        <div class="container2">
					<label for="div학기" id="lbl학기" title="학기">학기</label>
					<br><select id="div학기" title="학기" name="semester">
						<option value="1">1</option>
						<option value="2">2</option>
					</select>
	        </div>
	        <div class="container3">
	        	<input type="submit" value="조회" id="submit">
	        </div>
	    	<div class="container4">
			<table>
				<tr>
					<th>년도</th>
					<th>학기</th>
					<th>이수구분</th>
					<th>과목번호</th>
					<th width="25%">과목명</th>
					<th>담당교수</th>
					<th>학점</th>
					<th width="15%">강의시간</th>
				</tr>
	<!-- 1006 세션명변경 -->
				<c:forEach var="cv" items="${classreg_list }">
					<tr>
					<td><input type="text" id="div년도" class="form-control" name="year" value="${cv.class_year }" readonly="readonly"></td>
					<td><input type="text" id="div학기" class="form-control" name="semester" value="${cv.classreg_semester }" readonly="readonly"></td>
					<td><input type="text" id="div이수구분" class="form-control" name="class_type" value="${cv.class_type }" readonly="readonly"></td>
					<td><input type="text" id="div과목번호" class="form-control" name="class_no" value="${cv.class_no }" readonly="readonly"></td>
					<td><input type="text" id="div과목명" class="form-control" name="class_name" value="${cv.class_name }" readonly="readonly"></td>
					<td><input type="text" id="div담당교수" class="form-control" name="pro_name" value="${cv.pro_name } (${cv.pro_no })" readonly="readonly"></td>
					<td><input type="text" id="div학점" class="form-control" name="class_credit" value="${cv.class_credit }" readonly="readonly"></td>
					<td><input type="text" id="div강의시간" class="form-control" name="class_dayofweek_class_time" value="${cv.class_dayofweek } ${cv.class_time }" readonly="readonly"></td>
					</tr>
				</c:forEach>
			</table>
			</div>
		</div>
	</div>
	</form>
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