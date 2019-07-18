<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="center_page">
	<h3 class = "boardtitle"><i class="fas fa-cogs"></i>&nbsp;회원정보수정</h3>

	<form action="userupdateimpl.sh" method="POST"
		enctype="multipart/form-data">
		<!-- 사진 때문에 추가함 -->

		<table>		

			<tr>
				<td>PWD</td>
				<td><input type="hidden" name="id" value="${userupdate.id}">
					<input type="password" name="pwd" value="${userupdate.pwd}"></td>
					<!-- type을 password로 쓰면 값 안 보이게(*) 받아올 수 있음 -->
			</tr>

			<tr>
				<td>EMAIL</td>
				<td><input type="email" name="email" value="${userupdate.email}"></td>
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