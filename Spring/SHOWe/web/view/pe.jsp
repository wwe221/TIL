<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<div class="center_page">
	<h3 class = "boardtitle"><i class="fas fa-fw fa-table"></i>&nbsp;공연/전시 게시판<div style="float:right;"><a id="write" href="movielist.sh"><img src="view/img/pen.png">글쓰기</a></div></h3></h3>
	<div class="card mb-3">
		<div class="card-body">
			<div class="table-responsive">
				<table class="table table-bordered" id="dataTable" width="100%"
					cellspacing="0">
					<thead>
						<tr>
							<th>포스터</th>
							<th>제목</th>
							<th>감상평</th>
							<th>카테고리</th>
							<th>글쓴이</th>
							<th>작성일</th>
							<th>평점</th>
							<th>자세히보기</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="p" items="${plist}">
							<c:choose>
								<c:when test="${p.category eq 2 }">
									<tr>
										<td><c:set var="loop_flag" value="false" />
										<c:forEach var="c" items="${clist}">
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
										<td>${p.category }</td>
										<td>${p.writer}</td>
										<td>${p.regdate }</td>
										<td>
										<c:if test="${p.star == 0 }"> </c:if>
										<c:if test="${p.star == 1 }"> ★☆☆☆☆</c:if>
										<c:if test="${p.star == 2 }"> ★★☆☆☆</c:if>
										<c:if test="${p.star == 3 }"> ★★★☆☆</c:if>
										<c:if test="${p.star == 4 }"> ★★★★☆</c:if>
										<c:if test="${p.star == 5 }"> ★★★★★</c:if>										
										</td>
										<td><form action="postdetail.sh" method="POST">
											<input type="hidden" value="${p.id}" name="id">	
											<input type="submit" value="선택">
										</form></td>
										
									</tr>
								</c:when>
							</c:choose>

						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<a id="write" href="pelist.sh"><img src="view/img/pen.png">글쓰기</a>
</div>