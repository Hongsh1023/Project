<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>:: 비트대학교 ::</title>

<style type="text/css">

input[type="number"]::-webkit-outer-spin-button,
input[type="number"]::-webkit-inner-spin-button {
    -webkit-appearance: none;
    margin: 0;
}

body {
	font-family: sans-serif;
	margin: 0;
	width: 100%;
	height: 100%;
	padding : 0;
	background-image: url('image/bg.png');
	background-repeat: no-repeat;
}

#main {
	display: inline-block;
	width: 100%;
	height: 100%;
}

#contents {
	display: inline-block;
	margin-left : 30%; 
	margin-top : 100px;
}

#title {
	display: inline-block;
}

#welcome_image{
	border:none;
}

#login_box {
	margin-top: 30px;
	display: inline-block;
	margin-left: 30px;
	width : 230px;
}

#id_box {
	display: inline-block; 
	vertical-align: middle;
	background-color: #ffffff;
	width:220px;
}

#id_icon {
	vertical-align:middle;
	margin-left: 4px;
}

#std_no{
	height: 30px;
	width : 150px;
	border: none;
}

#login_button {
	margin-left: 11px;
	display: inline-block;
	vertical-align: top;
	padding-top :30px;
	padding-right: 30px;
}

#pwd_box {
	display: inline-block;
	vertical-align: top;
	background-color: #ffffff;
	width : 220px;
	height : 41px;
}

#pwd_icon {
	vertical-align:middle;
	margin-left: 4px;
}

#std_pwd {
	height: 30px;
	width : 150px;
	border: none;
}

.submit {
	width: 100px;
	height: 82px;
	background-color: #083b90; 
	border: none; 
	color: #FFFFFF;
}

#remember_id {
	font-size: 13px; 
	font-weight: bold;
	margin-left: 30px;
}

#error {
	text-align: center;
	font-size: 13px;
	font-weight: bold;
	color :#42bfee;	
}

#finder {
	text-align: center; 
	font-size: 13px;
	margin-top:2px;
}

.find{
	text-decoration: none;
	color: black;
}

#notice_box{
	display:block;
	text-align: left; 
}

#boxes { 
	width : 775px;
	height : 478px; 
	position: relative;
	top : 25%;
}

#box1{
	vertical-align: top;
	position : absolute;
	display: inline-block;
	width : 375px;
	height : 272px;
	margin-right: -6px;
	border: 1px solid #FFFFFF;
	background-color: #FFFFFF;
}

#box2 {
	vertical-align: top;
	position : absolute;
	display: inline-block;
	background-color: #f3f6fc;
	width : 408px; 
	height : 274px; 
	left : 48%;
}

#box3 {
	position : absolute;
	top : 61%;
	width: 352px;
	height: 200px; 
	background-color: #ffffff;
	padding-left: 25px;
	padding-bottom: 25px;
	padding-top: 25px;
	display: none;
	margin-right : -6px
}

#box4 {
	position : absolute;
	top : 61%;
	left : 48%;
	width: 383px;
	height: 200px;
	background-color: #ffffff;
	padding-left: 25px;
	padding-bottom: 25px;
	padding-top: 25px;
	display: none;
	vertical-align: top;
}

#notice {
	font-size: 20px;
	font-weight: bold;
	color: #083b90;
}

.menu {
	width: 160px;
	height: 50px;
	background-color:#E1E1E1;
	display: inline-block;
	text-align: center;
	line-height: 50px;
	border-color: #999999;
	margin-top: 12px;
	margin-left: 10px;
	cursor: pointer;
}

a {
	text-decoration: none;
	color: black;
}

</style>
</head>
<body>
	<div id = "main">
		<div id="contents">
			<div id = "title">
				<a href="login.do">
					<img src = "image/logo2.png">
				</a>
			</div>
			<br>
			<div id = "boxes">
				<div id ="box1">
					<img src = "image/welcome.png" id ="welcome_image">
				</div>
				<div id="box2">
					<form action="/login/main" method="post">
						<div class="login" id="login_box">
							<div class = "login" id = "id_box">
								<img src="image/idIcon.png" id = "id_icon">&nbsp; 
								<input type="number" name="std_no" placeholder="아이디" required="required" id ="std_no" value = "${re_id }">
							</div>
							<div class = "login" id = "pwd_box">
								<img src="image/pwdIcon.png" id = "pwd_icon">&nbsp; 
								<input type="password" name="std_pwd" placeholder="비밀번호" required="required" id = "std_pwd">
							</div>
						</div>	
						<div class="login" id="login_button">
								<input type="submit" value="로그인" class="submit">
						</div>
						<br>
						<br>
						<div id = "remember_id">
							<input type ="checkbox" name ="cb_id" value = "checked" <c:if test="${re_id != null }">checked="checked"</c:if>>&nbsp;
							아이디 저장 
						</div>
						<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
					</form>
					<br>
					<br>
					<div id = "finder">
						<a href ="findId.do" id = "find_id" class = "find">학번 찾기</a>&nbsp;&nbsp;|&nbsp;
						<a href="findPwd.do" id = "find_pwd" class = "find">비밀번호 찾기</a>
					</div>
					<br>
					<div id = "error">
						${login_error }
					</div>
				</div>
				<br>
				<div id = "box3" class = "hide">
					<div id ="notice_box">
						<div id = "notice">
							공지사항
						</div>
						<div id = "notice_list" >
							<ul type = "square">
								<li><p><a href = "board.do?BOARD_NO=1">공지사항 1</a></p></li>
								<li><p><a href = "board.do?BOARD_NO=2">공지사항 2</a></p></li>
								<li><p><a href = "board.do?BOARD_NO=3">공지사항 3</a></p></li>
								<li><p><a href = "board.do?BOARD_NO=4">공지사항 4</a></p></li>
							</ul>
						</div>
					</div>
				</div>
				<div id = "box4" class = "hide">
					<div id ="menus">
						<div id = "menu1" class = "menu" onclick="location.href='http://naver.com'">
							네이버
						</div>
						<div id = "menu2" class = "menu" onclick="location.href='http://google.com'">
							구글
						</div>
						<div id = "menu3" class = "menu" onclick="location.href='http://naver.com'">
							드롭박스
						</div>
						<div id = "menu4" class = "menu" onclick="location.href='https://www.dropbox.com/sh/y60we2a4h1bowdw/AADWxhikrixTFdDM9IYzqpoja?dl=0'">
							구글독스
						</div>
						<div id = "menu5" class = "menu" onclick="location.href='http://discord.com'">
							디스코드
						</div>
						<div id = "menu6" class = "menu" onclick="location.href='http://youtube.com'">
							유튜브
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>