<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="center_page">
<h1>User Register Page</h1>

<form action="useraddimpl.sh" method="POST">
<table>
<tr><td>ID</td><td><input type="text" name="id"></td></tr>
<tr><td>PWD</td><td><input type="password" name="pwd"></td></tr>
<tr><td>EMAIL</td><td><input type="email" name="email"></td></tr>

<!-- <tr><td>ICON</td><td><input type="hidden" value="default" name=icon></td></tr> -->

<tr><td>NICK</td><td><input type="text" name="nickname"></td></tr>
</table>
<input type="submit" value="REGISTER"><br>
</form>
</div>