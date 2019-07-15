<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div class="center_page">
<h1>Performance  Page!!</h1>
<div class="card mb-3">
          <div class="card-header">
            <i class="fas fa-table"></i>
            Performance Post Table</div>
          <div class="card-body">
            <div class="table-responsive">
              <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                <thead>
                  <tr>
                    <th>POST ID</th>
                    <th>TITLE</th>
                    <th>TEXT</th>
                    <th>CATEGORY</th>
                    <th>REGDATE</th>
                    <th>CONTENTS</th>
                  </tr>
                </thead>
                <tbody>
               			<c:forEach var="p" items="${plist}">
                			<c:choose>
                			<c:when test = "${p.category eq 2 }">	
                				<tr>
                    		<td>${p.id }</td>
                    		<td>${p.title }</td>
                    		<td>${p.text }</td>
                    		<td>${p.category }</td>
                    		<td>${p.regdate }</td>
                    		<td>${p.contents }</td>
                  		    	</tr>
                 			</c:when>
                 			</c:choose>
                
                </c:forEach>
                </tbody>
              </table>
            </div>
          </div>
          <div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>
        </div>
        <a id="write" href="pelist.sh">글쓰기</a>
      </div>