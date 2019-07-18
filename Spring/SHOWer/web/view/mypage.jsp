<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
	
<div class="center_page">
	<h3 class = "boardtitle"><i class="far fa-address-book"></i>&nbsp;마이페이지</h3>
	<div class="mypageuserdetail">
			<table>
			
			<tr><td rowspan='3'><img src="view/img/profile.png"></i></td><td>&nbsp;&nbsp;${u.nickname} 님 안녕하세요!</td></tr>
			<tr><td>&nbsp;&nbsp;이메일 : ${u.email}</td></tr>
			<tr><td><a href="userupdate.sh?id=${u.id }">&nbsp;&nbsp;내 정보 수정</a></td></tr>
			
		</table>
		
		</div>
		
		
		<h4 class = "boardtitle"><i class="fas fa-table"></i>&nbsp;내가 쓴 글 보기</h4>
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


