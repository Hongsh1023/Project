<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="header">
	
	</div>
	<div class="content">
		<div class="contentH">
		<h2>교수진 현황</h2><br><br>
			<div class="type">
			<table border="1" width=60%>
				<c:forEach var="p" items="${list }"> 
				<tr>
					<td width=30%><img src="./image/personIcon.png" width= 100px height=150px></td>
					<td>
						<h3>${p.pro_name }</h3>
						<img src="./image/school.png" width= 20px height=20px> ${p.pro_type } | ${p.pro_major }<br>
						<img src="./image/email.png" width= 20px height=20px> ${p.pro_email }<br>
					</td>
				</tr>
				</c:forEach>
			</table>
			</div>
		</div>
	</div>
	<div class="footer">
	</div>
</body>
</html>