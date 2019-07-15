<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
#board {
	margin: 0 auto;
	padding-left: 300px;
	padding-top: 200px;
}

#title_field {
	width: 500px;
}

#content_field {
	width: 500px;
	height: 550px;
	resize: none;
	<!-- textarea의 크기 조정 방지-->
}


#comment_field {
	width: 500px;
	height: 200px; <!-- 사이즈 확인 못 함 → 서버 연결 후 확인하기 -->
	resize: none;
	<!-- textarea의 크기 조정 방지-->
}

</style>

<div class="center_page">
	<h1>Detail Page</h1>
	<!-- User가 작성한 게시글 리스트에서 하나 선택하면 여기로 이동 -->
	<!-- content 정보와 user가 작성한 게시글이 떠야됨 + 댓글 -->
	<!-- 댓글은 입력 후 등록이 가능하도록 -->

	<table id="board">
		<tbody>
			<tr>
				<td colspan=2><h5>리뷰</h5></td>
			</tr>
			<tr>
				<td>종류</td>
				<td>선택한 콘텐츠 이름 출력</td>
			</tr>
			<!-- 종류와 콘텐츠 입력 값은 사용자 선택 값을 받아서 뿌려줌 -->
			<!-- content 정보도 표시해야 됨 -->

			<tr id="title_field">
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
	<!-- 수정과 삭제에 대한 권한은 글을 작성한 사람에게만 부여 → if문 써야하나?? -->
	<a href="productdelete.mc?id=${postdetail.id}">UPDATE</a> 
	<a href="productupdate.mc?id=${postdetail.id }">DELETE</a>
	
	<form action="postaddimpl.sh" method="POST">
	<table id="comment_field">
	<tr><td><h5>댓글</h5></td></tr>
	<tr><td><textarea></textarea></td></tr>
	<tr><td><input type="submit" value="확인"></td></tr>
	</table>
	</form>
</div>