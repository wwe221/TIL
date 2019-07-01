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
<div class="center_page">
<h1>User List page</h1>
<c:forEach var="u" items="${ulist}">
<h5><a href = "req?type=user&cmd=detail&id=${u.id}">
${u.id}</a> ${u.name} ${u.pwd}
</h5>
</c:forEach>
</div>
</body>
</html>