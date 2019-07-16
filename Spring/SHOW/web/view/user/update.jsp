<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="center_page">
	<h1>User Update Page</h1>

	<form action="userupdateimpl.sh" method="POST"
		enctype="multipart/form-data">
		<!-- 사진 때문에 추가함 -->

		<table>		

			<tr>
				<td>PWD</td>
				<td><input type="hidden" name="id" value="${userupdate.id}">
					<input type="text" name="pwd" value="${userupdate.pwd}"></td>
			</tr>

			<tr>
				<td>EMAIL</td>
				<td><input type="email" name="email"
					value="${userupdate.email}"></td>
			</tr>

			<tr>
				<td>NICK</td>
				<td><input type="text" name="nickname"
					value="${userupdate.nickname}"></td>
			</tr>

			<%-- 	<tr>
				<td>ICON</td>
				<td><input type="hidden" name="icon" value="${userupdate.icon }"> 
				<input type="file" name="mf"></td>
			</tr> --%>

		</table>

		<input type="submit" value="UPDATE"><br>


	</form>

</div>