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
	<!--
	textarea의
	크기
	조정
	방지
	-->
}
</style>

<div class="center_page">
	<h1>Post Update Page</h1>

	<form action="postupdateimpl.sh" method="POST"
		enctype="multipart/form-data">
		<!-- 사진 때문에 추가함 -->
		<table id="board">
			<tbody>
				<tr>
					<td>컨텐츠</td>
					<td>${content.title}</td>
					<td><img src="${content.poster}"></td>
				</tr>
				<!-- 종류와 콘텐츠 입력 값은 사용자 선택 값을 받아서 뿌려줌 -->
				<tr>
					<td>제목</td>
					<td><input type="text" name="title" id="title_field"
						value="${postupdate.title} "></td>
				</tr>
				<tr>
					<td>내용</td>
					<td><textarea name="text" id="content_field">${postupdate.text}</textarea></td>
				</tr>

				<tr>
					<td>평점</td>
					<td><select name="star" name="score">
							<!-- 평점의 value 추가 해야됨 -->
							<option value="">별점을 선택해주세요</option>
							<option value="1">★☆☆☆☆ 1</option>
							<option value="2">★★☆☆☆ 2</option>
							<option value="3">★★★☆☆ 3</option>
							<option value="4">★★★★☆ 4</option>
							<option value="5">★★★★★ 5</option>
					</select></td>
				</tr>

				<tr>
					<td colspan=2 style="text-align: center">
					<input type="hidden" name="id" value="${postupdate.id}">
					<input type="hidden" name="category" value="${postupdate.category}">
					<input type="hidden" name="contents" value="${content.id}">
					<input type="hidden" name="writer" value="${postupdate.writer}">
					<input type="hidden" name="img1" value="${postupdate.img1}">
					<input type="hidden" name="img2" value="${postupdate.img2}">
					<input type="hidden" name="img3" value="${postupdate.img3}">
					<input type="submit" value="확인"></td>
				</tr>
				
			</tbody>
		</table>

	</form>

</div>