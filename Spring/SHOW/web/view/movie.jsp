<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<div class="center_page">
	<ol class="breadcrumb">
		<li class="breadcrumb-item"><a href="main.sh">Dashboard</a></li>
		<li class="breadcrumb-item active">Overview</li>
	</ol>
	<div class="card mb-3">
		<div class="card-header">
			<i class="fas fa-table"></i> 영화 리뷰
		</div>
		<div class="card-body">
			<div class="table-responsive">
				<table class="table table-bordered" id="dataTable" width="100%"
					cellspacing="0">
					<thead>
						<tr>
							<th>CONTENTS</th>
							<th>TITLE</th>
							<th>TEXT</th>
							<th>Author</th>
							<th>REGDATE</th>
							<th>Score</th>
							<th>Detail</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="p" items="${plist}">
							<c:choose>
								<c:when test="${p.category eq 1 }">
									<tr>
										<td><c:set var="loop_flag" value="false" /> <c:forEach
												var="c" items="${clist}">
												<c:if test="${not loop_flag }">
													<c:choose>
														<c:when test="${c.id eq p.contents}">
															<c:set var="loop_flag" value="true" />
															<img src="${c.poster}" class="newimg">
															<p>${c.title}</p>
														</c:when>
													</c:choose>
												</c:if>
											</c:forEach></td>
										<td>${p.title }</td>
										<td>${p.text }</td>
										<td>${p.writer}
										<td>${p.regdate }</td>
										<td><c:if test="${p.star == 0 }">
											</c:if> <c:if test="${p.star == 1 }"> ★☆☆☆☆</c:if> <c:if
												test="${p.star == 2 }"> ★★☆☆☆</c:if> <c:if
												test="${p.star == 3 }"> ★★★☆☆</c:if> <c:if
												test="${p.star == 4 }"> ★★★★☆</c:if> <c:if
												test="${p.star == 5 }"> ★★★★★</c:if></td>
										<td><form action="postdetail.sh" method="POST">
												<input type="hidden" value="${p.id}" name="id"> <input
													type="submit" value="자세히보기">
											</form></td>
									</tr>
								</c:when>
							</c:choose>

						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		<div class="card-footer small text-muted">Updated yesterday at
			11:59 PM</div>
	</div>
	<a id="write" href="movielist.sh">글쓰기</a>
</div>
