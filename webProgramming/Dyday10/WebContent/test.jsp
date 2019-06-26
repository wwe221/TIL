<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- ev.html 에 데이터를 주기 위한 서버 프로그램 -->
<%
	response.setContentType("text/event-stream;charset=utf-8");
	Date time = new Date();
%>
data:<%=time %>
