<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="center_page">
	<h1>User List Page</h1>
	<table>
		<tbody>
			<c:forEach var="u" items="${ulist}">
				<tr>
					<td><a href="userdetail.mc?id=${u.id}">${u.id}</a></td>
					<td>${u.name}</td>
					<td>${u.pwd}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>