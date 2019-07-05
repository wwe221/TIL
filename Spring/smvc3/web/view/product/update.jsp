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
	<h1>Product Update Page</h1>
	<h2>ID:${pu.id}</h2>
	<img src="img/${pu.imgname}">	
<form id="u_form" action="productupdateimpl.mc" method="POST" enctype="multipart/form-data">
<input readonly="readonly" type="hidden" name="id" value="${pu.id}"><br>
NAME<input type="text" name="name" value="${pu.name}"><br>
PRICE<input type="number" name="price" value="${pu.price}"><br>
IMG<input type="file" name="mf"value="1"><br>
<input type="text" name="imgname" 
       value="${pu.imgname}">
<input type="submit" id="button" value="Update"><br>
</form>

</body>
</html>