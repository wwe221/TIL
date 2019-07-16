<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
	
<div class="center_page">
	<h1>User Detail Page!!</h1>

	<a href="userupdate.sh?id=${u.id }"> USER UPDATE</a><br>
		
			<table>
			<tr><td>${u.id}</td></tr>
			

			<tr>
				<td>EMAIL : </td>
				<td>${u.email}</td>
			</tr>

			<tr>
				<td>NICK : </td>
				<td>${u.nickname}</td>
			</tr>

		 	<tr>
				<td>ICON : </td>
				<td>${u.icon}</td>
			</tr>
			<tr>
				<td>ADMIN : </td>
				<td>${u.admin}</td>
			</tr>
			
		</table>
		<a href="mypost.sh"><p>내가 쓴글</p></a>
		
		


	


</div>

