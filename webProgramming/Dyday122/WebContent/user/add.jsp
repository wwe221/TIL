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
$(document).ready(function (){
	$('#button').click(function(){
		var c = confirm('회원가입 할껴?');
		if(c){
			$('#r_form').attr('method','POST');
			$('#r_form').attr('action','req?type=user&cmd=addimpl');
			$('#r_form').submit();
		}
	});
});
</script>
<body>
<h1>User add page</h1>
<form id="r_form">
ID<input type="text" name="id"><br>
PWD<input type="password" name="pwd"><br>
NAME<input type="text" name="name"><br>
<input type="button" id="button" value="REGISTER"><br>
</form>

</body>
</html>