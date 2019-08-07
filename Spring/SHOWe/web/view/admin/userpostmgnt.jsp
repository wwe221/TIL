<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<div class="center_page">	
	<div class="card mb-3">
		<div class="card-header">
			<i class="fas fa-table"></i> ${uid} 님이 쓴 글
		</div>
		<div class="card-body">
			<div class="table-responsive">
				<table class="table table-bordered" id="dataTable" width="100%"
					cellspacing="0">
					<thead>
						<tr>
							<th>번호</th>
							<th>제목</th>
							<th>내용</th>
							<th>작성일</th>
							<th>삭제</th>
							
						</tr>
					</thead>
					<tbody>
						<c:forEach var="mp" items="${mplist}">
							<c:choose>
							 <c:when test="${uid eq mp.writer }"> 
							 <tr>
										<td>${mp.id }</td>
										<td>${mp.title }</td>
										<td>${mp.text }</td>
										<td>${mp.regdate }</td>
										<td>
										<c:if test="${mp.category ==1 || mp.category == 2 }">
										<a href="postdetail.sh?id=${mp.id}">
										</c:if>
										<c:if test="${mp.category ==3}">
										<a href="music.sh">
										</c:if>
										<c:if test="${mp.category ==4}">
										<a href="drama.sh">
										</c:if>
										<c:if test="${mp.category ==99}">
										<a href="postdetail.sh?id=${mp.reid}">
										</c:if>
										이동</a>
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
