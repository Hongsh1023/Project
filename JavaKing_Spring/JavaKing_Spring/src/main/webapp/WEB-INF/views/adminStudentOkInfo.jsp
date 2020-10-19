<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:if test="${re >0 }">
	<font color="blue"> 기본정보 등록에 성공하였습니다.</font>
</c:if>

<c:if test="${re <=0 }">
	<font color="blue"> 기본정보 등록에 실패하였습니다.</font>
</c:if>

<a href="main.do">메인</a>
</body>
</html>