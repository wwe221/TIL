<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
.newimg {
	width: 80px;
	height: 100px;
}
</style>
<div class="center_page">
	<h1>Product List Page</h1>
	<table>
		<tbody>
			<c:forEach var="u" items="${plist}">
				<tr>
					<td><img src="img/${u.imgname}" class="newimg"></td>
					<td><a href="productdetail.mc?id=${u.id}">${u.id}</a></td>
					<td>${u.name}</td>
					<td>${u.price}</td>
					<td>${u.regdate}</td>
					<td>${u.imgname}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>