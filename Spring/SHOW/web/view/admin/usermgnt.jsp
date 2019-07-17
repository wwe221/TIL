<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div class="center_page">
	<c:choose>
		<c:when test="${loginuser.admin == 1}">
			<h1>Admin Mode - User Management Page!!</h1>
			<h5>${u.id }${u.nickname }</h5>
			<div class="card mb-3">
				<div class="card-body">
					<div class="table-responsive">
						<table class="table table-bordered" id="dataTable" width="100%"
							cellspacing="0">
							<thead>
								<tr>
									<th>아이디</th>
									<th>닉네임</th>
									<th>이메일</th>
									<th>작성글</th>
								</tr>
							</thead>
							<tbody>

								<c:forEach var="u" items="${ulist}">
									<tr>
										<td>${u.id }</td>
										<td>${u.nickname}</td>
										<td>${u.email }</td>
										<td><a href="userpostmgnt.sh?id=${u.id}">작성글 보기</a></td>

									</tr>
								</c:forEach>


							</tbody>
						</table>
					</div>
				</div>
			</div>

			<!-- <a href="userdetail.mc?id==${u.id }"> -->
		</c:when>
	</c:choose>
</div>

