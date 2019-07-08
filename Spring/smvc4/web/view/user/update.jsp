<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
</head>
<style>
</style>
<script>
	$(document).ready(function() {
	});
</script>
<body>
	<h1>User Update Page</h1>
	<img src="img/${uu.id}.jpg">	
<form id="u_form" action="userupdateimpl.mc" method="POST">
ID<input readonly="readonly" type="text" name="id" value="${uu.id}"><br>
PWD<input type="password" name="pwd" value="${uu.pwd}"><br>
NAME<input type="text" name="name" value="${uu.name}"><br>
<input type="submit" id="button" value="Update"><br>
</form>

</body>
</html>