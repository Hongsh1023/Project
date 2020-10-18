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
	background-image: url('./image/bg.png');
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

#find_pwd_image{
	border:none;
}

#find_pwd_box {
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

#id{
	height: 30px;
	width : 150px;
	border: none;
}

#submit_button {
	margin-left: 11px;
	display: inline-block;
	vertical-align: top;
	padding-top :30px;
	padding-right: 30px;
}

#email_box {
	display: inline-block;
	vertical-align: top;
	background-color: #ffffff;
	width : 220px;
}

#email_icon {
	vertical-align:middle;
	margin-left: 4px;
}

#email {
	height: 30px;
	width : 150px;
	border: none;
}

#submit {
	width: 100px;
	height: 82px;
	background-color: #083b90; 
	border: none; 
	color: #FFFFFF;
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

a {
	text-decoration: none;
	color: black;
}

.go_box {
	width: 220px;
	height: 50px;
	background-color:#f3f6fc;
	display: inline-block;
	text-align: center;
	line-height: 50px;
	border: none;
	color: #083b90;
	margin-top: 20px;
	margin-left: 90px;
	cursor: pointer;
}

#under_menu {
	text-align: center; 
	font-size: 13px;
}

.under_menu{
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
					<img src = "image/findPwdPage.png" id ="find_pwd_image">
				</div>
				<div id="box2">
					<form action="findPwdOk.do" method="post">
						<div class="findPwd" id="find_pwd_box">
							<div class="findPwd" id = "id_box">
								<img src="image/idIcon.png" id = "id_icon">&nbsp; 
								<input type="number" name="id" placeholder="아이디" required="required" id ="id">
							</div>
							<div class="findPwd" id = "email_box">
								<img src="image/emailIcon.png" id = "email_icon">&nbsp; 
								<input type="email" name="email" placeholder="이메일" required="required" id = "email">
							</div>
						</div>	
						<div class="findPwd" id="submit_button">
							<input type="submit" value="비밀번호 찾기" id="submit">
						</div>
					</form>
					<br>
					<br>
					<br>
					<br>
					<div id = "under_menu">
						<a href ="login.do" id = "login_page" class ="under_menu">로그인 페이지</a>&nbsp;&nbsp;|&nbsp;
						<a href="findId.do" id = "find_id" class ="under_menu">아이디 찾기</a>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>