<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	int i = 10;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<style>
td {
	border: 1px solid red;
	width: 30px;
	margin-left: 5px;
	width: 30px;
}
</style>
</head>
<body>
	<h1>
		Login OK Man
		<%=i%></h1>
	<h3>${id}님환영쓰</h3>
	<h3>${dept}개발부</h3>
	<c:choose>
		<c:when test="${gen}==male">
			<div style="border: 1px solid blue"><h4>남자!</h4></div>
		</c:when>
		<c:otherwise>
			<div style="border: 1px solid pink"><h4>여자!</h4></div>
		</c:otherwise>
	</c:choose>
	<h4>사용언어쓰</h4>
	<table>
		<tbody>
			<tr>
				<c:forEach var="it" items="${cl}">
					<td>${it}</td>
				</c:forEach>
			</tr>
		</tbody>
	</table>
</body>
</html>