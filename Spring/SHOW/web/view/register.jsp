<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script>
$(document).ready(function(){
	$("input[name='id']").blur(function () { // blur는 동작이 사라진 후 실행
		if ($(this).val().length >= 3) {
			$("input[name='pwd']").removeAttr('disabled');
		} // 요소를 비활성화 하는 'disabled'이용하여 조건에 따라 입력창 제어
		else {
			$("input[name='pwd']").attr('disabled');
			alert("ID를 세 글자 이상 입력해주세요.");
		}
	});
	
	$("input[name='pwd']").blur(function () {
		if ($(this).val().length >= 5) {
			$("input[name='pwdcheck']").removeAttr('disabled');
		}
		else {
			$("input[name='pwdcheck']").attr('disabled');
			alert("password를 다섯글자 이상  입력해주세요.");
		}
	});
	
	$("input[name='pwdcheck']").blur(function () {
		if ($(this).val() == $('input[name=pwd]').val()) {
			$("input[name='email']").removeAttr('disabled');
		}
		else {
			$("input[name='email']").attr('disabled');
			alert("password를 다시 확인해주세요.");
		}
	});
	
	
	$("input[name='email']").blur(function () {
		if ($(this).val().length > 1) {
			$("input[name='nickname']").removeAttr('disabled');
		}
		else {
			$("input[name='nickname']").attr('disabled');
			alert("이메일주소를 입력해주세요");
		}
	});
	
});
</script>
<div class="center_page">
	<h1>User Register Page</h1>
	<form action="useraddimpl.sh" method="POST">
		<table>
			<tr>
				<td>ID</td>
				<td><input type="text" name="id" required="required"></td>
			</tr>
			<tr>
				<td>PWD</td>
				<td><input type="password" name="pwd" required="required" disabled ></td>
			</tr>
			 <tr>
				<td>PWD Check</td>
				<td><input type="password" name="pwdcheck" required="required" disabled ></td>
			</tr> 
			<tr>
				<td>EMAIL</td>
				<td><input type="email" name="email" required="required" disabled ></td>
			</tr>
			<!-- <tr>
				<td>ICON</td>
				<td><input type="hidden" value="default" name=icon required="required" disabled ></td>
			</tr> -->
			<!-- 가입할 때 icon 사진 등록받을거면  위에 script에 조건문 추가 및 수정 해야됩니다 -->
			<tr>
				<td>NICK</td>
				<td><input type="text" name="nickname" required="required" disabled></td>
			</tr>
			<!-- 초기상태에서 id를 제외한 칸을 비활성화 → id부터 조건에 대입하여 성립할 때만 실행-->
		</table>

		<input type="submit" value="REGISTER"><br>
</div>