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
	margin-top:49px;
	text-align: center; 
	font-size: 13px;
}

.under_menu{
	text-decoration: none;
	color: black;
}

#result_box1 {
	width: 320px;
	height: 50px;
	background-color:#083b90;
	display: inline-block;
	text-align: center;
	line-height: 50px;
	border : 2px solid #083b90;
	margin-top: 12px;
	margin-left: 12px;
	color : #FFFFFF;
	cursor: pointer;
}

#result_box2 {
	width: 320px;
	height: 50px;
	background-color:#083b90;
	display: inline-block;
	text-align: center;
	line-height: 50px;
	border : 2px solid #083b90;
	margin-top: 12px;
	margin-left: 12px;
	color : #FFFFFF;
	cursor: pointer;
	margin-top: -4px;
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
					<div class="findId" id="find_id_box">
						<div id = "result_box1">
							아이디는 ${result_id } 입니다.
						</div>
						<div id = "result_box2" onclick="location.href='findId.do'">
							재검색을 원하시면 눌러주세요
						</div>
					</div>
					<div id = "under_menu">
						<a href ="login.do" id = "login_page" class ="under_menu">로그인 페이지</a>&nbsp;|&nbsp;
						<a href="findPwd.do" id = "find_pwd" class ="under_menu">비밀번호 찾기</a>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>