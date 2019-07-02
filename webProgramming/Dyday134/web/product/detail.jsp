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
		$('#delBut').click(function() {
			var c = confirm("진짜 삭제 하실거임?");
			if (c) {
				location.href = 'product.do?cmd=productdelete&id=${pd.id}';
			}
		});
		$('#upBut').click(function() {
			var c = confirm("수정하시겠습니까");
			if (c) {
				location.href = 'product.do?cmd=productupdate&id=${pd.id}';
			}

		});
	});
</script>
<body>
	<h1>User Detail Page</h1>
	<img src="img/${pd.imgname}" class = "newimg">
	<h5>${pd.id} ${pd.name} ${pd.price} ${pd.regdate}</h5>
	<button id="delBut">DELETE</button>
		<button id="upBut"">UPDATE</button>

</body>
</html>