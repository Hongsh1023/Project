<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

.center {
  	margin: auto;
  	padding: 10px;
  	padding-bottom: 30px;
  
}
.property{
	font-size: 13px;
}
.comment{
	font-size: 13px;
	background-color: white;
  	padding: 5px;
 	border: 10px solid #f1f4f8;

}
.before {
	position: static;
	padding: 10px;
	font-size: 13px;
	left: auto;
	width: 1800px;

}
.next{
	position: static;
	padding: 10px;
	font-size: 13px;
	right: auto;
	width: 100px;  
	
}
.bottomright {
  	position: absolute;
  	right: 2px;  
 	width: 220px;
  	height: 120px;

}
textarea {
  	width: 100%;
  	height: 150px;
  	padding: 12px 20px;
  	box-sizing: border-box;
  	border: 2px solid #ccc;
  	border-radius: 4px;
 	background-color: white;
  	resize: none;
}
input[type=text] {
  	width: 80%;
  	padding: 5px 20px;
  	margin: 8px 0;
  	box-sizing: border-box;
}
h2{
	background-color: #9fbaee;
  	color: white;
  	padding: 15px;
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
.list_button{
	margin-left:1000px; 
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
	<h2>
		<c:if test="${b_vo.board_boardno==100}">알림마당</c:if>
		<c:if test="${b_vo.board_boardno==200}">도움마당</c:if>
		<c:if test="${b_vo.board_boardno==300}">참여마당</c:if>
	</h2>
	<h4>${b_vo.board_title}</h4>
	<div class="property">
		<img src="../image/pen.png" width="20" height="20">작성자:${b_vo.std_no} |
		<img src="../image/time.png" width="20" height="20">작성일:${b_vo.board_regdate}|
		<img src="../image/click.png" width="20" height="20">조회수:${b_vo.board_hit} |
		<img src="../image/files.png" width="20" height="20">분류: ${b_vo.board_category} 	
		<hr>
		첨부파일 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;| √ <a href="../image/${b_vo.board_fname}">${b_vo.board_fname}</a>
		<hr>
	</div>
		<div class="center">
		<textarea readonly="readonly">${b_vo.board_content}</textarea><br>
		
		<a href="detailBoard.do?board_no=${b_vo.board_no-1}" class="before">◁ 이전글</a> <a href="detailBoard.do?board_no=${b_vo.board_no+1}" class="next">다음글▷</a>
		
		</div>
	<br>
	
<div class="bottom">
	<div style="background-color: #d2ddf1;  padding: 5px;">
	<img src="../image/conversation.png" width="20" height="25"><font color="#083b90">댓글(${reply_count})</font><a>∧</a>
	</div>
	<div class="comment">
	
	<c:forEach var="r" items="${r_list}">
		
		<c:choose>

			<c:when test="${std_no==r.std_no}"> 
				<form action="updateReply.do">
					<input type="hidden" name="reply_no" value="${r.reply_no}">
					<input type="hidden" name="board_no" value="${r.board_no}">
					<input type="text"  name="reply_content" value="${r.reply_content}" >|${r.reply_regdate}|${r.std_no}|
					<input type="submit" value="수정">
					<a href="deleteReply.do?reply_no=${r.reply_no}&board_no=${r.board_no}">
						<img src="../image/delete_comment.png" width="25" height="25">
					</a>
				</form>
			</c:when>
			<c:when test="${std_no!=r.std_no}">
				<input type="text" readonly="readonly" value="${r.reply_content}" width="50">|${r.reply_regdate}|${r.std_no}|
			</c:when>
				
		</c:choose>
		
				<br>
	
	</c:forEach>
	</div>
	<br>
	
	<hr>
	<form action="insertReply.do?board_no=${b_vo.board_no}" method="post">
		댓글 입력:
			<input type="text" name="reply_content" value="댓글을 입력하세요">
			<input type="submit" value="등록">
	</form>
	<br>
	<hr>
		<div class="list_button">
		
		<c:if test="${std_no==b_vo.std_no}">
			삭제<a href="deleteBoard.do?board_no=${b_vo.board_no}"><img src="../image/delete.png" width="30" height="35"></a>
			수정<a href="updateBoard.do?board_no=${b_vo.board_no}"><img src="../image/browser.png" width="30" height="35"></a>
		</c:if>
			목록<a href="listBoard.do"><img src="../image/schedule.png" width="30" height="35"></a>

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