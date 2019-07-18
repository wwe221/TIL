<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div class="center_page">
	<div id="content-wrapper">
		<c:choose>
			<c:when test="${loginuser.admin == 1}">
				<h1>Admin Mode Page!!</h1>
				<a href="usermgnt.sh"> USER MANAGEMENT</a>
				<br>
				<a href="postmgnt.sh"> POST MANAGEMENT</a>
			</c:when>
		</c:choose>
	</div>
</div>
