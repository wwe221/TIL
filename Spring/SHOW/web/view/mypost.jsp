<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<div class="center_page">
	
	<div class="card mb-3">
		<div class="card-header">
			<i class="fas fa-table"></i> 내가 쓴 글
		</div>
		<div class="card-body">
			<div class="table-responsive">
				<table class="table table-bordered" id="dataTable" width="100%"
					cellspacing="0">
					<thead>
						<tr>
							<th>POST ID</th>
							<th>TITLE</th>
							<th>REGDATE</th>
							<th></th>
							
						</tr>
					</thead>
					<tbody>
						<c:forEach var="mp" items="${mplist}">
							<c:choose>
							 <c:when test="${loginuser.id eq mp.writer }"> 

									<tr>
										<td>${mp.id }</td>
										<td>${mp.title }</td>
										<td>${mp.text }</td>
										<td>${mp.regdate }</td>
										<td>
										${mp.category }
										<c:if test="${mp.category ==1 || mp.category == 2 }">
										<a href="postdetail.sh?id=${mp.id}">${mp.category }</a>
										</c:if>
										<c:if test="${mp.category ==3}">
										<a href="music.sh">${mp.category }</a>
										</c:if>
										<c:if test="${mp.category ==4}">
										<a href="drama.sh">${mp.category }</a>
										</c:if>
										<c:if test="${mp.category ==99}">
										<a href="postdetail.sh?id=${mp.reid}">${mp.category }</a>
										</c:if>
										</td>
									</tr>
								 </c:when>
							</c:choose>

						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		
	</div>
	
</div>
