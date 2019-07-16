<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<script src="js/myjs.js"></script>
<style>
#board {
	margin: 0 auto;
	padding-left: 300px;
	padding-top: 200px;
	width: 95%;
}

#title_field {
	width: 500px;
}

#content_field {
	width: 500px;
	height: 550px;
	resize: none;
	<!--
	textarea의
	크기
	조정
	방지
	-->
}

#comment_field {
	width: 500px;
	height: 200px;
	<!--
	사이즈
	확인
	못
	함
	→
	서버
	연결
	후
	확인하기
	-->
	resize
	:
	none;
	<!--
	textarea의
	크기
	조정
	방지
	-->
}

.post-detail td {
	border: 1px solid black;
}

.cmt_list {
	list-style: none;
	margin: 0;
}

.cmt_list_each {
	padding-top: 10px;
}

.bf_update {
	display: none;
}
</style>

<div class="center_page">
	<h1>Detail Page</h1>
	<!-- User가 작성한 게시글 리스트에서 하나 선택하면 여기로 이동 -->
	<!-- content 정보와 user가 작성한 게시글이 떠야됨 + 댓글 -->
	<!-- 댓글은 입력 후 등록이 가능하도록 -->
	<div class="detail">
		<table id="board" class="post-detail">
			<tbody>
				<tr>
					<td>컨텐츠</td>
					<td>${contdetail.title}</td>
					<td><img src="${contdetail.poster}"></td>
				</tr>
				<!-- 종류와 콘텐츠 입력 값은 사용자 선택 값을 받아서 뿌려줌 -->
				<!-- content 정보도 표시해야 됨 -->
				<tr id="title_field">
					<td>제목</td>
					<td>${postdetail.title }</td>
				</tr>
				<tr id="content_field">
					<td>${postdetail.text }</td>
				</tr>

				<tr id="title_field">
					<td>${stardetail.score }</td>
				</tr>
			</tbody>
		</table>
		<c:choose>
			<c:when test="${postdetail.writer == loginuser.id}">
				<a href="postupdate.sh?id=${postdetail.id}">UPDATE</a>
				<a href="postdelete.sh?id=${postdetail.id }&cate=${postdetail.category}">DELETE</a>
			</c:when>
		</c:choose>
	</div>
	<ul class="cmt_list">
		<c:forEach var="comm" items="${comments}">
			<li>
				<div class="com_list_each">${comm.writer}/${comm.regdate}</div>
				<div id="${comm.id}ori" class="origin_text">
					<p>${comm.text}</p>
				</div> <c:choose>
					<c:when test="${comm.writer == loginuser.id}">
						<button onclick="myShowFunction('${comm.id}')">수정</button>
						<div id="${comm.id}div" class="bf_update">
							<button onclick="myShowFunction('${comm.id}')">수정취소</button>
							<form action="postupdateimpl.sh" method="POST">
								<textarea name="text">${comm.text}</textarea>
								<input type="hidden" name="id" value="${comm.id}"> 
								<input type="hidden" name="title" value="${comm.title}"> 
								<input type="hidden" name="contents" value="${comm.contents}">
								<input type="hidden" name="category" value="${comm.category}">
								<input type="hidden" name="writer" value="${comm.writer}">
								<input type="hidden" name="img1" value="${comm.img1}"> 
								<input type="hidden" name="img2" value="${comm.img2}"> 
								<input type="hidden" name="img3" value="${comm.img3}"> 
								<input type="hidden" name="reid" value="${comm.reid}"> 
								<input type="submit" value="수정">
							</form>
						</div>
						<a href="postdelete.sh?id=${comm.id}&cate=99">삭제</a>
					</c:when>
				</c:choose>
			</li>
			<hr>
		</c:forEach>
	</ul>


	<form action="postcommentadd.sh" method="POST">
		<table id="comment_field">
			<tr>
				<td><textarea name="text"></textarea></td>
			</tr>
			<tr>
				<td><input type="hidden" name="title" value="comment">
					<input type="hidden" name="category" value="99"> <input
					type="hidden" name="reid" value="${postdetail.id}"> <input
					type="hidden" name="contents" value="1"> <input
					type="hidden" name="writer" value="${loginuser.id}"> <input
					type="submit" value="확인"></td>
			</tr>
		</table>
	</form>
</div>