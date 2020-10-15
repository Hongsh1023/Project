<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>:: 비트대학교 ::</title>

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
	margin-left: 385px; 
	margin-top: 50px;
	width: 1250px;
}

#info_box {
	display: inline-block;
	border : 2px #E1E1E1 solid;
	width : 390px;
	height : 290px;
	vertical-align: top;
}

#info_box_blue {
	background-color: #083b90;
	width : 390px;
	height : 290px;
	color: #FFFFFF;
	font-size: 20px;
	font-weight: bold;
}

#info_box_white {
	display : inline-block;
	background-color: #FFFFFF;
	padding : 20px;
	width : 350px;
	height : 125px;
}

#my_info_box{
	display: inline-block; 
	margin-left: 50px;
	vertical-align: top; 
	margin-top:25px;
}

#my_info_text{
	display: inline-block;
	text-align: left;
}

#my_info_name{
	font-size: 30px;
}

#profile_image {
	display: inline-block;
	width : 90px;
	height : 90px;
	padding : 12px;
	vertical-align: top;
}

#go_change_pwd_image{
	display : inline-block;
	width : 30px;
	height : 30px;
	margin-left: 40px;
	padding:10px;
}

.my_info_white{
	color:#000000;
	display: inline-block;
	vertical-align: top;
	font-size: 15px;
	font-weight: bold;
}

.board_boxes{
	width : 350px;
	height : 250px;
	background-color: #FFFFFF;
	display: inline-block;
	border : 2px #E1E1E1 solid;
	vertical-align: top;
	padding : 20px;
}

#board_box1 {
	margin-left: 15px;
}

#board_box2 {
	margin-left: 15px;
}

#board_box3 {
	display: inline-block;
}

#board_box4 {
	display: inline-block;
	margin-left: 15px;
}

#banner_box1{
	width : 804px;
	height : 150px;
	background-color: #FFFFFF;
	display: inline-block;
	border : 2px #E1E1E1 solid;
	margin-top: 19px;
}

#board_box_leftside{
	display:inline-block;
	margin-top: 19px;
	width: 809px;
}

#banner_box2{
	width : 390px;
	height : 463px;
	background-color: #FFFFFF;
	display: inline-block;
	border:2px #E1E1E1 solid;
	margin-top: 19px;
	margin-left: 15px;
	vertical-align: top;
}

.box_title {
	font-weight: bold;
	font-size: 20px;
	color: #083b90;
	display: inline-block;
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

#flee_line {
	list-style-type: none;
}

.flee_buy{
	margin-top: 1em;
	margin-bottom: 1em;
}

.flee_sell{
	margin-top: 1em;
	margin-bottom: 1em;
}

.flee_title {
	list-style-type: none;
	font-weight: bold;
	font-size: 18px;
	color : #42bfee;
}

#banner1_image{
	width : 804px;
	height : 150px;
	cursor: pointer;
}

#banner2_image{
	width : 390px;
	height : 463px;
	cursor: pointer;
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
								<li><p class = "p2"><a href = "classSearch.do">수강내역조회</a></p></li>
								<li><p class = "p2"><a href = "classSearch.do">시간표조회</a></p></li>
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
		<div id = "info_box">
			<div id = "info_box_blue">
				<img src = "../image/profile.png" id="profile_image">
				<div id = "my_info_box">
					<div id = "my_info_text">
						<div id = "my_info_name">
							${name }
						</div>
						<div id = "my_info_id">
							${std_no }
						</div>
					</div>
				</div>
				<a href = "changePwd.do">
					<img src = "../image/gear.png" id="go_change_pwd_image">
				</a>
				<div id = "info_box_white">
					<div id = "my_info_major" class = "my_info_white">
						${major }
					</div>
					<hr>
					<div id = "my_info_level_semester" class = "my_info_white">
						${level}학년&nbsp;${semester }학기
					</div>
					<hr>
					<div id = "my_info_email" class = "my_info_white">
						${email }
					</div>
				</div>
			</div>
		</div>
		<div id = "board_box1" class= "board_boxes">
			<div id ="notice_box">
				<div class = "box_title">
					<a href = "" class = "box_title">공지사항</a>
				</div>
				<hr>
				<div id = "link_box1" class = "link_boxes">
					<ul id = "box1_article">
						<c:forEach var="i" items="${main_notice }" begin="0" end="3">
							<li> 
								<p><a href="detailBoard.do?board_no=${i.board_no }">${i.board_title }</a></p>
							</li>
						</c:forEach>
					</ul>
				</div>
			</div>
		</div>
		<div id = "board_box2" class= "board_boxes">
			<div id ="readme_box">
				<div class = "box_title">
					<a href = "" class = "box_title">자유게시판</a>
				</div>
				<hr>
				<div id = "link_box2" class = "link_boxes">
					<ul id = "box2_article">
						<c:forEach var="i" items="${main_freeboard }" begin="0" end="3">
							<li> 
								<p><a href="detailBoard.do?board_no=${i.board_no }">${i.board_title }</a></p>
							</li>
						</c:forEach>
					</ul>
				</div>
			</div>
		</div>
		<div id = "board_box_leftside">
			<div id = "board_box3" class= "board_boxes">
				<div>
					<div class = "box_title">
						<a href = "" class = "box_title">중고장터</a>
					</div>
					<hr>
					<div id = "link_box3" class = "link_boxes">
						<ul id = "box3_article">
							<li class = "flee_title">
								삽니다
							</li>
							<c:forEach var="i" items="${main_flee_buy }" begin="0" end="1">
								<li> 
									<p class = "flee_buy"><a href="detailBoard.do?board_no=${i.board_no }">${i.board_title }</a></p>
								</li>
							</c:forEach>
								<li id = "flee_line">
									<hr>
								</li>
							<li class = "flee_title">
								팝니다
							</li>
							<c:forEach var="i" items="${main_flee_sell }" begin="0" end="1">
								<li> 
									<p class = "flee_sell"><a href="detailBoard.do?board_no=${i.board_no }">${i.board_title }</a></p>
								</li>
							</c:forEach>
						</ul>
					</div>
				</div>
			</div>
			<div id = "board_box4" class= "board_boxes">
				<div>
					<div class = "box_title">
						<a href = "" class = "box_title">익명게시판</a>
					</div> 
					<hr>
					<div id = "link_box4" class = "link_boxes">
					<ul id = "box4_article">
						<c:forEach var="i" items="${main_anonymous }" begin="0" end="3">
							<li> 
								<p><a href="detailBoard.do?board_no=${i.board_no }">${i.board_title }</a></p>
							</li>
						</c:forEach>
					</ul>
					</div>
				</div>
			</div>
			<div id = "banner_box1" class = "banner_boxes">
				<a href = "https://www.kosaf.go.kr" target = "_blank"><img src="../image/scholarship.png" id = "banner1_image"></a>
			</div>
		</div>
		<div id = "banner_box2" class="banner_boxes"> 
			<a href = "https://www.kosaf.go.kr" target = "_blank"><img src="../image/loan.png" id = "banner2_image"></a>
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