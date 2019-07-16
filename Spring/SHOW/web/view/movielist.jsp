<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<style>
</style>
<div class="center_page">
	<h1>Movie Page!!</h1>
	<div class="card mb-3">
		<div class="card-header">
			<i class="fas fa-table"></i> Data Table Example
		</div>
		<div class="card-body">
			<div class="table-responsive">
				<table class="table table-bordered" id="dataTable" width="100%"
					cellspacing="0">
					<thead>
						<tr>
							<th>Poster</th>
							<th>Title</th>
							<th>Open></th>
							<th>Genre</th>
							<th>Director</th>
							<th>Actor</th>
							<th>Time</th>
							<th>Grade</th>
							<th></th>
						</tr>
					</thead>
					<tfoot>
						<tr>
							<th>Poster</th>
							<th>Title</th>
							<th>Open</th>
							<th>Genre</th>
							<th>Director</th>
							<th>Actor</th>
							<th>Time</th>
							<th>Grade</th>
							<th></th>
						</tr>
					</tfoot>
					<tbody>
						<c:forEach var="u" items="${clist}">
							<tr>
								<td><img src="${u.poster}" class="newimg"></td>
								<td>${u.title}</td>
								<td>${u.open}</td>
								<td>${u.genre}</td>
								<td>${u.director}</td>
								<td>${u.actor1},${u.actor2},${u.actor3}</td>
								<td>${u.time}</td>
								<td>${u.grade}</td>
								<!-- <td><input type="submit" value="글쓰기"></td> -->
								<td>
								<c:choose>
								<c:when test="${loginuser!=null}">
									<form action="postadd2.sh" method="POST">
										<input type="hidden" value="${u.id}" name="id">							
										<input type="hidden" value="${u.title}" name="title">							
										<input type="hidden" value="${u.category}" name="category">							
								<input type="submit" value="글쓰기">
								</form>
								</c:when>
								</c:choose>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		<div class="card-footer small text-muted">Updated yesterday at
			11:59 PM</div>
		<a id="write2" href="postadd3.sh?id=testtest">선택</a>
		<form action="postadd2.sh" method="POST">
			<input type="hidden" value="1" name="category"> <input
				type="submit" value="글쓰기">
		</form>
		<!-- list가 표시되는 table 가장 오른쪽 열에 버튼 추가하면 어떨지!? -->
	</div>
</div>
