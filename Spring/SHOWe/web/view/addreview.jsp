<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="center_page">
<h1>User Add Page</h1>

<form action="writeimpl.sh" method="POST">
ID<input type="text" name="id"><br>
PWD<input type="password" name="pwd"><br>
NAME<input type="text" name="name"><br>
<input type="submit" value="REGISTER"><br>
</form>
</div>