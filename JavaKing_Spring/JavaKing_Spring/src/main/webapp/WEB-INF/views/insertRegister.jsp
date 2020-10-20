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

#nav5:hover + #nav_window5{
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

#nav_window5:hover {
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
		border-spacing: 15px;
 		border-collapse: separate;
	}
	label{
		padding-top : 5px;
		margin-left : 13px;
		padding-top : 5px;
		color : #083b90;
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
	
	
	.tab_menu_container{
		margin-left: 80px;
		margin-right: 80px;
		width : 700px;
		display:flex;
		padding-top : 0;
		padding-bottom: 0;
	}

	.tab_menu_btn {
	  width:100px;
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
		width : 500px;
		border : 1px solid gray;
		background-color: #f1f4f8;
	}
	.container1{
		margin-top : 15px;
		font-weight : bold;
		
	}
	.container2{
		padding-left : 40px;
		margin-left : 10px;
	}
	tr{
		
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
	
	#submit{
		margin-left: 345px;
		margin-top : 10px;
		margin-bottom : 20px;
		border : 1px solid gray;
		background-color: #083b90;
		color:white;
	}
	
	.form-control{
		margin-left : 15px;
		width : 310px;
	}
	
	input::placeholder {
		font-size: 8px;
	}
#main {
	margin-left: 230px;
	width : 700px;
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
						&nbsp;&nbsp;·&nbsp;&nbsp;
		<div id = "nav5" class = "nav">
                <a href = "adminStudentInfo.do" class = "nav"><font color="red">관리자</font></a><br>
            </div>
            <div id = "nav_window5" class ="nav_window">
                <div id = "nav_title5" class = "nav_title">
                    <br>
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;관리자
                </div>
                <div id ="nav_right5" class = "nav_right">
                    <div id = "nav_right_list5" class = "nav_right_list">
                        <div class = "nav_right_box">
                            <div class = "nav_right_title">
                                관리자메뉴
                            </div>

                            <ul class= "inside_list">
                                <li><p class = "p2"><a href = "adminStudentInfo.do">기본정보 등록</a></p></li>
                                <li><p class = "p2"><a href = "insertRegister.do">등록금 등록</a></p></li>
                                <li><p class = "p2"><a href = "insertProfessor.do">교수 등록</a></p></li>
                            </ul>
                        </div>
                        <div class = "nav_right_box">
                            <div class = "nav_right_title">
                                &nbsp;&nbsp;
                            </div>
                            <ul class= "inside_list">
                                <li><p class = "p2"><a href = "adminClass.do">강의 등록</a></p></li>
                                <li><p class = "p2"><a href = "adminGrade.do">성적 등록</a></p></li>
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
	<h2>관리자 페이지</h2>

	<form action="insertRegister.do" method="post">
	<div class="info">
		<div id="tabs">
			<div class="tab_menu_container">
	   	 	<button class="tab_menu_btn" type="button" onclick="location='adminStudentInfo.do'">기본정보등록</button>
	    	<button class="tab_menu_btn on" type="button" onclick="location='insertRegister.do'">등록금등록</button>
	  		<button class="tab_menu_btn" type="button" onclick="location='adminGrade.do'">성적등록</button>
	  		<button class="tab_menu_btn" type="button" onclick="location='adminClass.do'">강의등록</button>
	  		<button class="tab_menu_btn" type="button" onclick="location='insertProfessor.do'">교수등록</button>
	  		</div>
	  	</div>
<div id="tables">
			<div class="container1">
					
				<table>
					<tr>
						<td><label for="div학번" id="lbl학번" title="학번">학번</label></td>
						<td><input type="number" id="div학번" class="form-control" name="std_no"></td>
					</tr>
					<tr>
						<td><label for="div년도" id="lbl년도" title="년도">년도</label></td>
						<td><input type="number" id="div년도" class="form-control" name="reg_year"></td>
					</tr>
					<tr>	
						<td><label for="div학년" id="lbl학년" title="학년">학년</label></td>
						<td><input type="number" id="div학년" class="form-control" name="reg_level"></td>
					</tr>
					<tr>	
						<td><label for="div학기" id="lbl학기" title="학기">학기</label></td>
		                <td><input type="number" id="div학기" class="form-control" name="reg_semester"></td>
		            </tr>
					<tr>	  
		                <td><label for="div미납입학금" id="lbl미납입학금" title="미납입학금">미납입학금</label></td>
		                <td><input type="number" id="div미납입학금" class="form-control" name="reg_entfee"></td>
		            </tr>
		            <tr>    
						<td><label for="div미납등록금" id="lbl미납등록금" title="미납등록금">미납등록금</label></td>
						<td><input type="number" id="div미납등록금" class="form-control" name="reg_fee"></td>
					</tr>
					<tr>	
						<td><label for="div납부등록금" id="lbl납부등록금" title="납부등록금">납부등록금</label></td>
						<td><input type="number" id="div납부등록금" class="form-control" name="reg_regfee"></td>
					</tr>
				</table>
			</div>

			<div class="container2">
	        	<input type="submit" value="등록" id="submit">
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