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
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<script type="text/javascript">
   function change_category(board_category){
      location.href="listBoard.do?board_category="+encodeURI(encodeURI(board_category));
   }
   
   function change_pagesize(page_size){
	   location.href="listBoard.do?page_size="+page_size; 
	}
</script>
<script type="text/javascript" src=" https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
	$(function(){


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

table{
		text-align: middle; 
		border-spacing: 15px;
 		border-collapse: separate;
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
	div{
		padding:10px;	
	}
	label{
		margin-left : 13px;
		padding-top : 5px;
		color : #083b90;
	}
	.tab_menu_container{
		margin-left: 70px;
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
		width : 500px;
		border : 1px solid gray;
		background-color: #f1f4f8;
	}
	.container1{
		margin-top : 15px;
		padding-bottom:15px;
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
		margin-left: 350px;
		margin-top : 10px;
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
	<h2>학사정보</font></h2>

	<form action="adminClassEdit.do" method="post">
	<div class="info">
		<div id="tabs" class="tab_menu_container">
	   	 	<button class="tab_menu_btn" type="button">학생등록</button>
	    	<button class="tab_menu_btn" type="button">등록금</button>
	  		<button class="tab_menu_btn" type="button">성적등록</button>
	  		<button class="tab_menu_btn on" type="button">강의등록</button>
	  		<button class="tab_menu_btn" type="button">교수등록</button>
	  	</div>
		<div id="tables">
			<div class="container1">
				<table>
					<tr>
						<td><label for="div강의번호" id="lbl강의번호" title="강의번호">강의번호</label></td>
						<td><input type="text" id="div강의번호" class="form-control" name="class_no" value="${c.class_no }" readonly="readonly"></td>
					</tr>
					<tr>
						<td><label for="div강의명" id="lbl강의명" title="강의명">강의명</label></td>
						<td><input type="text" id="div강의명" class="form-control" name="class_name" value="${c.class_name }"></td>
					</tr>
					<tr>
						<td><label for="div강의시작일" id="lbl강의시작일" title="강의시작일">강의시작일</label></td>
						<td><input type="date" id="div강의시작일" class="form-control" name="class_startdate" value="${c.class_startdate }"></td>
					</tr>
					<tr>
						<td><label for="div강의종료일" id="lbl강의종료일" title="강의종료일">강의종료일</label></td>
						<td><input type="date" id="div강의종료일" class="form-control" name="class_enddate" value="${c.class_enddate }"></td>
					</tr>
					<tr>
						<td><label for="div강의요일" id="lbl강의요일" title="강의요일">강의요일</label></td>
						<td><input type="text" id="div강의요일" class="form-control" name="class_dayofweek" value="${c.class_dayofweek }" placeholder="2일 이상 .으로 구분"></td>
					</tr>
					<tr>
						<td><label for="div강의교시" id="lbl강의교시" title="강의교시">강의교시</label></td>
						<td><input type="text" id="div강의교시" class="form-control" name="class_time" value="${c.class_time }" placeholder="2교시 이상 띄어쓰기없이 입력 / 2일 이상 .으로 구분"></td>
					</tr>
					<tr>
						<td><label for="div강의실" id="lbl강의실" title="강의실">강의실</label></td>
						<td><input type="text" id="div강의실" class="form-control" name="class_room" value="${c.class_room }"></td>
					</tr>
					<tr>
						<td><label for="div학점" id="lbl학점" title="학점">학점</label></td>
						<td><input type="number" id="div학점" class="form-control" name="class_credit" value="${c.class_credit }"></td>
					</tr>
					<tr>
						<td><label for="div이수구분" id="lbl이수구분" title="이수구분">이수구분</label></td>
						<td><select id="div이수구분" class="form-control" name="class_type">
							<option selected disable hidden value="${c.class_type }">${c.class_type }</option>
							<option value="전공">전공</option>
							<option value="교양">교양</option>
						</select></td>
					</tr>
					<tr>
						<td><label for="div교수번호" id="lbl교수번호" title="교수번호">교수번호</label></td>
						<td><input type="number" id="div교수번호" class="form-control" name="pro_no" value="${c.pro_no }"></td>
					</tr>
				</table>	      
	        <div class="container2">
	        	<input type="submit" value="수정" id="submit">
	        </div>
	 		</div>
		</div>
	</div>
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