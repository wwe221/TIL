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
<style>
* {
	margin: 0;
	padding: 0;
}

a {
	text-decoration: none;
	color: black;
}

header, nav, section, footer {
	margin: 0 auto;
}

header {
	width: 900px;
	height: 150px;
	background: red;
}

nav {
	width: 900px;
	height: 40px;
	background: pink;
}

section {
	width: 900px;
	height: 600px;
	background: gray;
}

footer {
	width: 900px;
	height: 30px;
	background: blue;
}

.center_page {
	width: 880px;
	height: 580px;
	margin: 0 auto;
	background: white;
}
</style>
</head>
<body>
	<header>
		<h3>
			<c:choose>
				<c:when test="${loginuser!=null}">
					<a href="#">${loginuser.id}</a>
					<a href="login.do">logout</a>
					<a href="main.do?view=about">ABOUTUS </a>
				</c:when>
				<c:otherwise>
					<a href="main.do?view=login">LOGIN</a>
					<a href="main.do?view=register">REGISTER</a>
					<a href="main.do?view=about">ABOUTUS </a>
				</c:otherwise>
			</c:choose>
		</h3>
		<h1>
			<a href="user.do?view=useradd">USERADD </a> <a
				href="user.do?cmd=userlist">USERLIST</a> <a
				href="product.do?view=productadd">PRODUCTADD</a> <a
				href="product.do?cmd=productlist">PRODUCTLIST</a>
		</h1>
	</header>
	<nav>
		<c:choose>
			<c:when test="${navi==null}">
				<a href="main.do">Home</a>
			</c:when>
			<c:otherwise>
	${navi}
	</c:otherwise>
		</c:choose>
	</nav>
	<section>
		<c:choose>
			<c:when test="${center==null}">
				<jsp:include page="center.jsp"></jsp:include>
			</c:when>
			<c:otherwise>
				<jsp:include page="${center}.jsp"></jsp:include>
			</c:otherwise>
		</c:choose>
	</section>
	<footer> </footer>
</body>
</html>