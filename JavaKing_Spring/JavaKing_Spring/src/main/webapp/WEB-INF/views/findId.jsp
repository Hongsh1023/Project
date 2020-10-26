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

#find_id_image{
	border:none;
}

#find_id_box {
	margin-top: 30px;
	display: inline-block;
	margin-left: 30px;
	width : 230px;
}

#name_box {
	display: inline-block; 
	vertical-align: middle;
	background-color: #ffffff;
	width:220px;
}

#name_icon {
	vertical-align:middle;
	margin-left: 4px;
}

#std_name{
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

#std_email {
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
					<img src = "image/findIdPage.png" id ="find_id_image">
				</div>
				<div id="box2">
					<form action="findIdOk.do" method="post">
						<div class="findId" id="find_id_box">
							<div class="findId" id = "name_box">
								<img src="image/nameIcon.png" id = "name_icon">&nbsp; 
								<input type="text" name="std_name" placeholder="이름" required="required" id ="std_name">
							</div>
							<div class="findId" id = "email_box">
								<img src="image/emailIcon.png" id = "email_icon">&nbsp; 
								<input type="email" name="std_email" placeholder="이메일" required="required" id = "std_email">
							</div>
						</div>	
						<div class="findId" id="submit_button">
							<input type="submit" value="아이디 찾기" id="submit">
						</div>
					</form>
					<br>
					<br>
					<br>
					<br>
					<div id = "under_menu">
						<a href ="login.do" id = "login_page" class ="under_menu">로그인 페이지</a>&nbsp;&nbsp;|&nbsp;
						<a href="findPwd.do" id = "find_pwd" class ="under_menu">비밀번호 찾기</a>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>