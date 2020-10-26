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

header {
	height: 130px !important;
}

hr {
	display: block;
	margin-top: 0.5em !important;
	margin-bottom: 0.5em !important;
	border-color: #8C8C8C !important;
}

a {
	text-decoration: none !important;
	color : black;
}

body {
	font-family: sans-serif;
	margin: 0 !important;
	width: 2000px;
	height: 100%;
	padding : 0 !important;
	background-color: #FFFFFF;
	display: inline-block;
	position: relative;
}

#logo {
	display : inline-block;
	margin-left : 40%;
	padding-top : 20px;
	margin-bottom: 4px;
}

#lock_image{
	vertical-align: middle;
}

#hello_box{
	display : inline-block;
	margin-left : 70%;
	vertical-align: middle;
	padding-bottom: 10px;
	font-size: 16px !important;
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
	margin-top : 8px;
	margin-bottom : 8px;
	position: relative;
}

.nav {
	display: inline-block !important;
	background-color: #FFFFFF;
	width : 100px !important;
	height: 30px !important;
	vertical-align: middle !important;
	text-align: center !important;
	font-size: 20px !important;
	font-weight: bold !important;
	cursor: pointer;
	margin-left:2px !important;
}

#nav_box {
	display: inline;
	width : 100%;
	vertical-align: middle !important;
	padding-top : 2px !important;
}

#nav1 {
	margin-left : 400px !important;
}

.nav_window {
	display : none;
	position : absolute;
	width : 100%;
	height : 160px;
	background-color: #083b90;
	box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
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
	margin-left: 370px;
	margin-top: 50px;
	width: 1250px;
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

	body{
		vertical-align : middle;
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
		background-color: #f1f4f8;
		width : 500px;
		border : 1px solid gray;
	}
	
	.container1{
		padding-top:15px;
		padding-bottom:20px;
		color : #083b90;
		font-weight : bold;
		border-bottom : 1px solid gray;
	}
	
	.container2{
		display: table-cell;
		flex:1;
		padding-left : 20px;
		padding-right : 40px;
		padding-bottom : 20px;
		padding-top : 10px;
	}
	
	.container5{
		display: table-cell;
		flex:1;
		padding-bottom : 20px;
		padding-top : 10px;
	}
	
	#tables2{
		margin-top: 20px;
		margin-left: 80px;
		margin-right: 80px;
		background-color: #f1f4f8;
		width : 500px;
		border : 1px solid gray;
	}
	
	.container3{
		padding-top:15px;
		padding-bottom:20px;	
		color : #083b90;
		font-weight : bold;
		border-bottom : 1px solid gray;
	}
	
	.container4{
		display: table-cell;
		padding-left : 20px;
		padding-bottom : 20px;
		padding-top : 10px;
	}
	
	#submit{
		padding-top: 10px;
		margin-left: 10px;
		border : 1px solid black;
		background-color: #083b90;
		color:#f1f4f8;
	}
	#main {
	margin-left: 230px;
	width : 670px;
	height: 720px;
	padding : 10px;
	border : 2px #E1E1E1 solid;
	background-color: #ffffff;
}

.form-control[disabled], .form-control[readonly], fieldset[disabled] .form-control {
    background-color: #FFFFFF;
    opacity: 1;
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
	<div id ="main">
	<h2>학사정보</h2>

	<form action="adminStudentInfo">
	<div class="info">
		<div id="tabs" class="tab_menu_container">
			<button class="tab_menu_btn" type="button" onclick="location='studentInfo.do'">기본정보</button>
	    	<button class="tab_menu_btn on" type="button" onclick="location='startEndDate.do'">입학/졸업</button>
	  		<button class="tab_menu_btn" type="button" onclick="location='change.do'">학적변동</button>
	  		<button class="tab_menu_btn" type="button" onclick="location='listGrade.do'">성적</button>
	  		<button class="tab_menu_btn" type="button" onclick="location='detailClass.do'">수강</button>
	  		<button class="tab_menu_btn" type="button" onclick="location='listReg.do'">등록</button>
	  	</div>
		<div id="tables">
			<div class="container1">
					&nbsp;&nbsp;&nbsp;입학정보
	        </div>
	        <div class="container2">   
					<label for="div입학전공" id="lbl입학전공" title="입학전공">입학전공</label>
					<input type="text" id="div입학전공" class="form-control" name="std_major" value="${sv2.std_major }">
			</div>
			<div class="container5">  		
					<label for="div입학일" id="lbl입학일" title="입학일">입학일</label>
					<input type="text" id="div입학일" class="form-control" name="std_startdate" value="${sv2.std_startdate }">			
			</div>
		</div>
		<div id="tables2">
	        <div class="container3">  		
					&nbsp;&nbsp;&nbsp;졸업정보
			</div> 	
			<div class="container4">  		
					<label for="div졸업일" id="lbl졸업일" title="졸업일">졸업일</label>
					<input type="text" id="div졸업일" class="form-control" name="std_enddate" value="${sv2.std_enddate }">
			</div>
		</div>
	</div>
	</form>
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