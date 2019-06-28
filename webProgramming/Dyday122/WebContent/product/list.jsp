<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
</head>
<style>
</style>
<script>
</script>
<body>
<h1>Product List page</h1>
<c:forEach var="p" items="${plist}">
<h5><a href = "req?type=product&cmd=detail&id=${p.id}">${p.id}</a> ${p.name} ${p.price} ${p.regdate} ${p.imgname}</h5>
</c:forEach>
</body>
</html>