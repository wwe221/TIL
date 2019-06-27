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
	table, tr, td{
	border:1px solid black;
	
	</style>
</head>
<body>
	<h1>
		Login OK Man
		<%=i%></h1>
	<h3>${id}님환영쓰</h3>
	<c:if test="${cnt >5}">
		<h3>high</h3>
	</c:if>
	<c:choose>
		<c:when test="${cnt>=9}">
			<h4>1등급</h4>
		</c:when>
		<c:when test="${cnt>=8 && cnt<9}">
			<h4>2등급</h4>
		</c:when>
		<c:otherwise>
			<h4>F등급</h4>
		</c:otherwise>
	</c:choose>
	<c:forEach var="num" items="${list1}">
		<h5>${num}</h5>
	</c:forEach>
	<table >
		<tbody>
			<c:forEach var="it" items="${list2}">
				<tr>
					<td>${it.name}</td>
					<td>${it.price}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>