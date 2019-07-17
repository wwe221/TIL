<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<div class="center_page">
	<c:choose>
		<c:when test="${loginuser.admin == 1}">
			<h1>Admin Mode - Post Management Page!!</h1>	
	<div class="card mb-3">
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
							<th>작성자</th>
							<th>삭제</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="p" items="${plist}">
							<tr>
								<td>${p.id }</td>
								<td>
								<c:if test="${p.category == 3 }"> ${p.img01 } -</c:if>
								${p.title }</td>
								<td>${p.text }</td>
								<td>${p.pdate}</td>
								<td>${p.writer }</td>
								<td><a href="postdelete.sh?id=${p.id }&cate=77">DELETE</a></td>
							</tr>

						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
		</c:when>
	</c:choose>
</div>

