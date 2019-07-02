<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<body>
	<div class="center_page">
		<h1>LogIn page</h1>
		<form action="login.do" method="POST">
		Id<input type="text" name="id"><br> 
		Pwd<input type="password" name="pwd"><br>
		<input type="submit" value="LOGIN" >
		</form>
	</div>
</body>
